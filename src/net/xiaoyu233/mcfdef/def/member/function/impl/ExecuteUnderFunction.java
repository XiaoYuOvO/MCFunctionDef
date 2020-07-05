package net.xiaoyu233.mcfdef.def.member.function.impl;

import net.xiaoyu233.mcfdef.compile.managers.FunctionManager;
import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.Namespace;
import net.xiaoyu233.mcfdef.def.member.function.FunctionToken;
import net.xiaoyu233.mcfdef.def.member.function.IFunction;
import net.xiaoyu233.mcfdef.def.member.instruction.Command;
import net.xiaoyu233.mcfdef.def.member.instruction.Instruction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExecuteUnderFunction extends IFunction {
    private final FunctionManager manager;
    private final Namespace namespace;
    private static final String[] ARG_ORDER = new String[]{"path"};
    private static final FunctionToken TOKEN = new FunctionToken("execUnder",1);
    public ExecuteUnderFunction(Namespace namespace){
        this.manager = namespace.getLocalFunctionManager();
        this.namespace = namespace;
    }
    @Override
    public List<Instruction> getRawInstructions() {
        return Collections.singletonList(new Command("<execUnder_marker>"));
    }

    @Override
    public List<Instruction> applyArgs(Map<String, String> arg2RealArgs) {
        String functionPath = arg2RealArgs.get("path");
        if (!functionPath.endsWith("/")){
            functionPath += "/";
        }
        List<Instruction> result = new ArrayList<>();
        for (MCFunction allFunction : manager.getAllFunctions()) {
            if (allFunction.getName().startsWith(functionPath)){
                result.add(new Command("function " + namespace.getName() + ":" + allFunction.getCallName()));
            }
        }
        return result;
    }

    @Override
    public FunctionToken getToken() {
        return TOKEN;
    }

    @Override
    public String getName() {
        return "execUnder";
    }

    @Override
    public int getArgCount() {
        return 1;
    }

    @Override
    public String[] getArgsOrder() {
        return ARG_ORDER;
    }
}
