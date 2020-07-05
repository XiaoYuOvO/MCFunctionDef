package net.xiaoyu233.mcfdef.compile;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.xiaoyu233.mcfdef.antlr.mcfdef.MCFDefLexer;
import net.xiaoyu233.mcfdef.antlr.mcfdef.MCFDefParser;
import net.xiaoyu233.mcfdef.antlr.mcfunction.MCFunctionLexer;
import net.xiaoyu233.mcfdef.antlr.mcfunction.MCFunctionParser;
import net.xiaoyu233.mcfdef.compile.handler.*;
import net.xiaoyu233.mcfdef.compile.io.DirectoryWalker;
import net.xiaoyu233.mcfdef.compile.io.FunctionWriter;
import net.xiaoyu233.mcfdef.compile.managers.DefinitionManager;
import net.xiaoyu233.mcfdef.compile.managers.FunctionManager;
import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.MCFunctionDef;
import net.xiaoyu233.mcfdef.def.Namespace;
import net.xiaoyu233.mcfdef.def.member.instruction.IfStatement;
import net.xiaoyu233.mcfdef.def.member.instruction.Instruction;
import net.xiaoyu233.mcfdef.parser.MCFDefParseListener;
import net.xiaoyu233.mcfdef.parser.MCFunctionParseListener;
import net.xiaoyu233.mcfdef.util.IOUtils;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MCFDefCompiler {
    public static final int COMPILER_VERSION_NUM = 1;
    private final File src,out;
    private final boolean deleteOldFile;
    public static final CompileErrorHandler DEFAULT_ERR_HANDLER = new DefaultCompileErrorHandler();
    public static final CompilationStatsHandler DEFAULT_STATS_HANDLER = new DefaultCompHandler();
    private final List<CompileErrorHandler> errorHandlers = new ArrayList<>();
    private final List<CompilationStatsHandler> statsHandlers = new ArrayList<>();
    private final DefinitionManager globalManager = new DefinitionManager();
    public  MCFDefCompiler(MCFDefProject project){
        this.src = project.getSrcDir();
        this.out = new File(project.getOutDir(),src.getName());
        this.deleteOldFile = project.isDeleteOldFiles();
        this.addErrorHandler(DEFAULT_ERR_HANDLER);
        this.addStatsHandler(DEFAULT_STATS_HANDLER);
    }

    public void removeErrorHandler(int index){
        this.errorHandlers.remove(index);
    }
    public void removeStatsHandler(int index) {
        this.statsHandlers.remove(index);
    }

    public void removeErrorHandler(CompileErrorHandler handler){
        this.errorHandlers.remove(handler);
    }
    public void removeStatsHandler(CompilationStatsHandler handler){
        this.statsHandlers.remove(handler);
    }

    public void addStatsHandler(CompilationStatsHandler statsHandler){
        this .statsHandlers.add(statsHandler);
    }
    public void addErrorHandler(CompileErrorHandler errorHandler){
        this.errorHandlers.add(errorHandler);
    }

    public void compile() {
        if (deleteOldFile){
            IOUtils.deleteDir(out);
        }
        Collection<Namespace> builtNamespaces = buildPack();
        statsHandlers.forEach(CompilationStatsHandler::onCompileFinished);
        writeFiles(builtNamespaces);
    }

    private void reportIOException(IOException exception,File file){
        this.errorHandlers.forEach((handler)-> handler.reportIOException(exception,file));
    }

    private void writeFiles(Collection<Namespace> builtNamespaces) {
        for (Namespace builtNamespace : builtNamespaces) {
            File dataDir = new File(new File(out,"data"),builtNamespace.getName());
            File namespaceFuncOutDirectory = new File(dataDir,"functions");
            for (File resourceFileDir : builtNamespace.getResourceFileDirs()) {
                File dest = new File(dataDir,resourceFileDir.getName());
                dest.mkdirs();
                try {
                    IOUtils.copyDir(resourceFileDir,dest);
                } catch (IOException e) {
                    reportIOException(e,resourceFileDir);
                }
            }
            if (!namespaceFuncOutDirectory.exists()){
                if (!namespaceFuncOutDirectory.mkdirs()) reportIOException(new IOException("Cannot create dir:" + namespaceFuncOutDirectory.getAbsolutePath()),namespaceFuncOutDirectory);
            }
            for (MCFunction allFunction : builtNamespace.getLocalFunctionManager().getAllFunctions()) {
                if (allFunction.isCompiled()) {
                    File functionFile = new File(namespaceFuncOutDirectory, (allFunction.getFileName()));
                    try {
                        FunctionWriter.writeToFile(functionFile, allFunction);
                        statsHandlers.forEach(statsHandler -> statsHandler.onFunctionFileWrote(functionFile));
                    } catch (IOException e) {
                        reportIOException(e,functionFile);
                    }
                }
            }
        }
        for (File file : Objects.requireNonNull(src.listFiles())) {
            if (!file.getName().equals("data")){
                try {
                    IOUtils.copyFile(file,new File(out,file.getName()));
                } catch (IOException e) {
                    reportIOException(e,file);
                }
            }
        }
    }

    private void writeFunctionTags(List<MCFunction> content,String tagName,Namespace namespace) {
        File tagDir = new File( new File(namespace.getNamespaceDir(),"tags"),"functions");
        if (!tagDir.exists()){
            if(tagDir.mkdirs()) reportIOException(new IOException("Cannot create dir:" + tagDir.getAbsolutePath()),tagDir);
        }
        JsonObject tagObject = new JsonObject();
        tagObject.addProperty("replace",false);
        JsonArray array = new JsonArray();
        for (MCFunction mcFunction : content) {
            array.add(namespace.getName() + ":" + mcFunction.getCallName());
        }
        tagObject.add("values",array);
        File tagFile = new File(tagDir,tagName + ".json");
        try( FileWriter writer = new FileWriter(tagFile)) {
            new Gson().newBuilder().setPrettyPrinting().create().toJson(tagObject,writer);
        } catch (IOException exception) {
            reportIOException(exception,tagFile);
        }
    }

    public List<Namespace> buildPack() {
        List<Namespace> namespaces = new ArrayList<>();
        File packDataFiles = new File(this.src,"data");
        if (packDataFiles.exists()){
            for (File file : Objects.requireNonNull(packDataFiles.listFiles())) {
                if (file.isDirectory()){
                    Namespace namespace = new Namespace(this.src,file.getName());
                    namespaces.add(namespace);
                    this.buildNamespace(namespace);
                    this.writeFunctionTags(namespace.getTickFunctions(),"tick",namespace);
                    this.writeFunctionTags(namespace.getLoadFunctions(),"load",namespace);
                }
            }
        }

        return namespaces;
    }

    private void buildNamespace(Namespace namespace) {
        buildFunctions(namespace);
        for (File file : Objects.requireNonNull(namespace.getNamespaceDir().listFiles())) {
            if (!file.getName().equals("functions")){
                namespace.addResourceDir(file);
            }
        }
    }

    private DirectoryWalker buildWalker(Namespace namespace){
        DirectoryWalker walker = null;
        try {
            walker = new DirectoryWalker(namespace.getFunctionDir());
            walker.walk(namespace.getFunctionDir());
        } catch (IOException exception) {
            reportIOException(exception,namespace.getFunctionDir());
        }
        return walker;
    }

    private void pendIfInFunction(List<Instruction> instructions,Namespace namespace,List<MCFunction> newFunctions) {
        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            if (instruction instanceof IfStatement) {
                instructions.remove(instruction);
                IfStatement ifStatement = ((IfStatement) instruction);
                String generatedFunctionName = namespace.getName() + ":" + "generated/if/" + namespace.getIfGeneratedIndex();
                instructions.add(i,ifStatement.getCallCommand(generatedFunctionName));
                List<Instruction> ifStatementInstructions = ifStatement.getInstructions();
                for (int i1 = 0; i1 < ifStatementInstructions.size(); i1++) {
                    Instruction ifStatementInstruction = ifStatementInstructions.get(i1);
                    if (ifStatementInstruction instanceof IfStatement) {
                        pendIfInFunction(ifStatement.getInstructions(), namespace, newFunctions);
                    }
                }
                ArrayList<Instruction> callContext = new ArrayList<>(ifStatement.getInstructions());
                MCFunction mcFunction = new MCFunction(generatedFunctionName.substring(generatedFunctionName.indexOf(":")+1) + ".mcfunction");
                mcFunction.getContent().addAll(callContext);
                mcFunction.setCompiled(true);
                newFunctions.add(mcFunction);
            }
        }
    }

    private void buildFunctions(Namespace namespace) {
        DirectoryWalker walker = buildWalker(namespace);
        DefinitionManager definitionManager = namespace.getLocalDefinitionManager();
        definitionManager.merge(globalManager);
        FunctionManager functionManager = namespace.getLocalFunctionManager();
        String srcString = namespace.getFunctionDir().getAbsolutePath();
        this.statsHandlers.forEach((statsHandler -> statsHandler.onStartCompileNamespace(walker.getMcFunctionFiles(),walker.getMcfDefFiles(), srcString)));
        for (File mcfDefFile : walker.getMcfDefFiles()) {
            CharStream input = null;
            try {
                input = CharStreams.fromFileName(mcfDefFile.getAbsolutePath());
            } catch (IOException exception) {
                reportIOException(exception,mcfDefFile);
            }
            MCFDefLexer lexer = new MCFDefLexer(input);  //词法分析
            CommonTokenStream tokens = new CommonTokenStream(lexer);  //转成token流
            MCFDefParser parser = new MCFDefParser(tokens); // 语法分析
            RecognitionErrorHandler handler = new RecognitionErrorHandler();
            parser.setErrorHandler(handler);
            MCFDefParser.McfDefContext tree = parser.mcfDef();  //获取某一个规则树，这里获取的是最外层的规则，也可以通过sql()获取sql规则树......
            MCFDefParseListener listener = new MCFDefParseListener(new MCFunctionDef(mcfDefFile.getPath()));
            if (handler.getErrors().isEmpty()){
                try {
                    ParseTreeWalker.DEFAULT.walk(listener, tree);
                    MCFunctionDef mcfDef = listener.getCompiledDef();
                    definitionManager.addDefinition(mcfDef.getName(), mcfDef.getFileName(), mcfDef);
                    if (mcfDef.isGlobal()) globalManager.addDefinition(mcfDef.getName(), mcfDef.getFileName(), mcfDef);
                    statsHandlers.forEach(statsHandler -> statsHandler.onFunctionDefParsed(mcfDef));
                }catch (FunctionCompileException e){
                    for (CompileErrorHandler errorHandler : this.errorHandlers) {
                        errorHandler.reportCompileError(e);
                    }
                }
            }else {
                for (CompileErrorHandler errorHandler : this.errorHandlers) {
                    if (!handler.getErrors().isEmpty()) {
                        errorHandler.reportRecognitionError(handler.getErrors(), mcfDefFile);
                    }
                }
            }
        }
        for (File mcfFile : walker.getMcFunctionFiles()) {
            String src = null;
            try {
                src = new String(Utils.readFile(mcfFile.getAbsolutePath()));
            } catch (IOException exception) {
                reportIOException(exception,mcfFile);
            }
            src = src + "\n";
            CharStream input = CharStreams.fromString(src);
            MCFunctionLexer lexer = new MCFunctionLexer(input);  //词法分析
            CommonTokenStream tokens = new CommonTokenStream(lexer);  //转成token流
            MCFunctionParser parser = new MCFunctionParser(tokens); // 语法分析
            RecognitionErrorHandler handler = new RecognitionErrorHandler();
            parser.setErrorHandler(handler);
            MCFunctionParser.McfunctionContext tree = parser.mcfunction();  //获取某一个规则树，这里获取的是最外层的规则，也可以通过sql()获取sql规则树......
            try {
            MCFunctionParseListener listener = new MCFunctionParseListener(new MCFunction(mcfFile.getPath()));
            if (handler.getErrors().isEmpty()){

                    ParseTreeWalker.DEFAULT.walk(listener, tree);
                    MCFunction mcf = listener.getCompiledFunction();
                    if (mcf.isExecOnLoad()) namespace.getLoadFunctions().add(mcf);
                    if (mcf.isExecPerTick()) namespace.getTickFunctions().add(mcf);
                    functionManager.addFunction(mcf.getName(), mcf.getFileName(), mcf);
                    statsHandlers.forEach(statsHandler -> statsHandler.onFunctionParsed(mcf));

            }else {
                for (CompileErrorHandler errorHandler : this.errorHandlers) {
                    errorHandler.reportRecognitionError(handler.getErrors(),mcfFile);
                }
            }
            }catch (FunctionCompileException e){
                for (CompileErrorHandler errorHandler : this.errorHandlers) {
                    errorHandler.reportCompileError(e);
                }
            }
        }
        try {
            for (MCFunctionDef functionDef : definitionManager.getAllDef()){
                Linker.linkDef(functionDef,definitionManager);
                Linker.linkFunctionCallInDef(functionDef);
            }
            BuiltinFunctions.addBuiltinFunctions(namespace);
            ArrayList<MCFunction> newFunctions = new ArrayList<>();
            for (MCFunction allFunction : functionManager.getAllFunctions()) {
                Linker.linkDef(allFunction, definitionManager);
                Linker.linkFunction(allFunction);
                pendIfInFunction(allFunction.getContent(), namespace,newFunctions);
                allFunction.setCompiled(true);
                statsHandlers.forEach(statsHandler -> statsHandler.onFunctionCompiled(allFunction));
            }
            newFunctions.forEach(function -> functionManager.addFunction(function.getName(), function.getFileName(), function));
        }catch (FunctionCompileException e){
            for (CompileErrorHandler errorHandler : this.errorHandlers) {
                errorHandler.reportCompileError(e);
            }
        }
    }
}
