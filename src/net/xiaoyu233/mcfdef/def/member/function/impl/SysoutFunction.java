package net.xiaoyu233.mcfdef.def.member.function.impl;

import net.xiaoyu233.mcfdef.def.member.function.FunctionToken;
import net.xiaoyu233.mcfdef.def.member.function.IFunction;
import net.xiaoyu233.mcfdef.def.member.instruction.Command;
import net.xiaoyu233.mcfdef.def.member.instruction.Instruction;

import java.util.*;

public class SysoutFunction extends IFunction {
    private static final String COMMAND = "tellraw @a {\"text\":\"#\"}";
    private static final String[] ARG_ORDER = new String[]{"msg"};
    private static final FunctionToken TOKEN = new FunctionToken("sysout",1);

    @Override
    public List<Instruction> getRawInstructions() {
        return Collections.singletonList(new Command(COMMAND));
    }

    @Override
    public List<Instruction> applyArgs(Map<String, String> arg2RealArgs) {
        String result = COMMAND;
        for (Map.Entry<String, String> stringStringEntry : arg2RealArgs.entrySet()) {
            result = result.replace("#",stringStringEntry.getValue());
        }
        return Collections.singletonList(new Command(result));
    }

    @Override
    public FunctionToken getToken() {
        return TOKEN;
    }

    @Override
    public String getName() {
        return "sysout";
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
