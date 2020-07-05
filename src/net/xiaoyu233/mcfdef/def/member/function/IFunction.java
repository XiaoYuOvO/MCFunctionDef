package net.xiaoyu233.mcfdef.def.member.function;

import net.xiaoyu233.mcfdef.def.member.instruction.Instruction;

import java.util.List;
import java.util.Map;

public abstract class IFunction {
    public abstract List<Instruction> getRawInstructions();
    public abstract List<Instruction> applyArgs(Map<String,String> arg2RealArgs);
    public abstract FunctionToken getToken();
    public abstract String getName();
    public abstract int getArgCount();
    public abstract String[] getArgsOrder();
    public String toString() {
        return getName() + "(" +"args:" + getArgCount() + ")";
    }
}
