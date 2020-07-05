package net.xiaoyu233.mcfdef.compile.handler;

import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.MCFunctionDef;

import java.io.File;
import java.util.List;

public class DefaultCompHandler implements CompilationStatsHandler{
    private long startTime;
    @Override
    public void onStartCompileNamespace(List<File> toCompileFunctions, List<File> toCompileDefs, String src) {
        System.out.println("[MCFDef Compiler] Start compile function files in " + src + "( "+ toCompileFunctions.size() + " MCFunction(s) ; " + toCompileDefs.size() + " MCFunctionDef(s)"+ ")");
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onFunctionCompiled(MCFunction function) {
        System.out.println("[MCFDef Compiler] Compiled Function " + function.getFileName());
    }

    @Override
    public void onFunctionDefCompiled(MCFunctionDef functionDef) {

    }

    @Override
    public void onFunctionParsed(MCFunction function) {
        System.out.println("[MCFDef Compiler] Parsed Function " + function.getFileName());
    }

    @Override
    public void onFunctionDefParsed(MCFunctionDef functionDef) {
        System.out.println("[MCFDef Compiler] Parsed FunctionDef " + functionDef.getFileName());
    }

    @Override
    public void onCompileFinished() {
        System.out.println("[MCFDef Compiler] Compilation finished,time used:" + (System.currentTimeMillis() - startTime + "ms"));
    }

    @Override
    public void onFunctionFileWrote(File functionFile) {
        System.out.println("[MCFDef Compiler] Write file:" + functionFile.getPath());
    }
}
