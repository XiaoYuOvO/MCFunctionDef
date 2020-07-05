package net.xiaoyu233.mcfdef.def.member.instruction;

import java.util.ArrayList;

public class FunctionCall extends Instruction {
    private String functionName;
    private ArrayList<String> args = new ArrayList<>();

    public FunctionCall(String functionName){
        super( "");
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public void addRealArgument(String arg){
        args.add(arg);
    }
}
