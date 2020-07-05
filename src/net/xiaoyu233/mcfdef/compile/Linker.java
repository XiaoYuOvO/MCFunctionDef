package net.xiaoyu233.mcfdef.compile;

import net.xiaoyu233.mcfdef.compile.managers.DefinitionManager;
import net.xiaoyu233.mcfdef.def.Compilable;
import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.MCFunctionDef;
import net.xiaoyu233.mcfdef.def.member.function.FunctionToken;
import net.xiaoyu233.mcfdef.def.member.function.IFunction;
import net.xiaoyu233.mcfdef.def.member.instruction.FunctionCall;
import net.xiaoyu233.mcfdef.def.member.instruction.IfStatement;
import net.xiaoyu233.mcfdef.def.member.instruction.Instruction;

import java.util.*;

public class Linker {
    public static void linkDef(Compilable function, DefinitionManager manager) throws FunctionCompileException {
        for (String s : function.getUsedFunctionDefString()) {
            MCFunctionDef def = manager.getMCFunctionDef(s);
            if (def != null){
                function.addFuncDefUse(def);
            }else {
                throw new FunctionCompileException("Target definition not found:" + s,function);
            }
        }
    }

    public static void linkFunctionCallInDef(MCFunctionDef mcFunctionDef){
        for (IFunction iFunction : mcFunctionDef.getAllDefinedFunction()) {
            List<Instruction> rawInstructions = iFunction.getRawInstructions();
            linkFunctionInInsn(rawInstructions,mcFunctionDef);
            rawInstructions.stream().filter(instruction -> instruction instanceof IfStatement).forEach(ifStatement ->{
                linkFunctionInInsn(((IfStatement) ifStatement).getInstructions(),mcFunctionDef);
            });
        }
    }

    private static IFunction findFunction(Compilable function,FunctionToken token,ArrayList<MCFunctionDef> defs) throws FunctionCompileException {
        ArrayList<IFunction> foundFunction = new ArrayList<>();
        for (MCFunctionDef def : defs) {
            IFunction thisFunction = def.getDefinedFunction(token);
            if (thisFunction != null){
                foundFunction.add(thisFunction);
            }
        }
        if (foundFunction.size() == 0){
            throw new FunctionCompileException("Target function not found: " + token + "  in:" + function.getFileName(),function);
        }
        else if (foundFunction.size() > 1){
            throw new FunctionCompileException("Found more than 1 matched functions:" + foundFunction.toString(),function);
        }else{
            return foundFunction.get(0);
        }
    }

    private static void linkFunctionInInsn(List<Instruction> content,Compilable function){
        for (int line = 0; line < content.size(); line++) {
            Instruction instruction = content.get(line);
            if (instruction instanceof FunctionCall) {
                FunctionCall functionCall = ((FunctionCall) instruction);
                FunctionToken token = new FunctionToken(functionCall.getFunctionName(), functionCall.getArgs().size());
                IFunction foundFunctionDef = findFunction(function, token, function.getUsedFunctionDefs());
                ArrayList<String> args = functionCall.getArgs();
                String[] argsOrder = foundFunctionDef.getArgsOrder();
                Map<String, String> argMap = new HashMap<>();
                for (int i = 0, argsOrderLength = argsOrder.length; i < argsOrderLength; i++) {
                    String s = argsOrder[i];
                    argMap.put(s, args.get(i));
                }
                content.remove(instruction);
                content.addAll(line,foundFunctionDef.applyArgs(argMap));
                line--;
            }
            if (instruction instanceof IfStatement){
                linkFunctionInInsn(((IfStatement) instruction).getInstructions(),function);
            }
        }
    }

    public static void linkFunction(MCFunction function) throws FunctionCompileException {
        List<Instruction> content = function.getContent();
        linkFunctionInInsn(content,function);
    }
}
