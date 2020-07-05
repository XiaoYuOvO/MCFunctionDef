package net.xiaoyu233.mcfdef.def.member.function;

import net.xiaoyu233.mcfdef.def.member.instruction.Command;
import net.xiaoyu233.mcfdef.def.member.instruction.FunctionCall;
import net.xiaoyu233.mcfdef.def.member.instruction.IfStatement;
import net.xiaoyu233.mcfdef.def.member.instruction.Instruction;

import java.util.*;

public class FunctionDef extends IFunction {
    private LinkedList<Instruction> instructions = new LinkedList<>();
    private final String name;
    private final ArrayList<String> args;
    private final FunctionToken token;
    public FunctionDef(String name,String... args){
        this.name = name;
        this.args = new ArrayList<> ();
        this.args.addAll(Arrays.asList(args));
        this.token = new FunctionToken(name,args.length);
    }

    public FunctionDef(String name, ArrayList<String> args){
        this.name = name;
        this.args = new ArrayList<> ();
        this.args.addAll(args);
        this.token = new FunctionToken(name,args.size());
    }

    public void addInstruction(Instruction insn){
        this.instructions.add(insn);
    }

    @Override
    public List<Instruction> getRawInstructions() {
        return instructions;
    }

    @Override
    public List<Instruction> applyArgs(Map<String, String> arg2RealArgs) {
        ArrayList<Instruction> result = new ArrayList<>();

            for (Instruction instruction : this.instructions) {
                if (instruction instanceof FunctionCall){
                    FunctionCall origin = ((FunctionCall) instruction);
                    FunctionCall pended = new FunctionCall(origin.getFunctionName());
                    for (String arg : origin.getArgs()) {
                        pended.addRealArgument(pendArgs(arg,arg2RealArgs));
                    }
                    result.add(pended);
                }
                if (instruction instanceof Command){
                    result.add(new Command(pendArgs(instruction.getRaw(),arg2RealArgs)));
                }
                if (instruction instanceof IfStatement){
                    IfStatement ifStatement = ((IfStatement) instruction);
                    ArrayList<Instruction> ifInsn = new ArrayList<>();
                    for (Instruction ifStatementInstruction : ifStatement.getInstructions()) {
                        if (ifStatementInstruction instanceof Command){
                            ifInsn.add(new Command(pendArgs(ifStatementInstruction.getRaw(),arg2RealArgs)));
                        }
                        if (ifStatementInstruction instanceof IfStatement){
                            ifInsn.add(ifStatementInstruction);
                        }
                    }
                    IfStatement newIfStatement = new IfStatement(ifStatement.getCondition());
                    newIfStatement.addAllInstruction(ifInsn);
                    result.add(newIfStatement);
                }
            }
        return result;
    }

    private String pendArgs(String raw,Map<String, String> arg2RealArgs){
        for (Map.Entry<String, String> stringStringEntry : arg2RealArgs.entrySet()) {
            raw = raw.replace("&" + stringStringEntry.getKey(),stringStringEntry.getValue());
        }
        return raw;
    }

    @Override
    public FunctionToken getToken() {
        return this.token;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getArgCount() {
        return args.size();
    }

    @Override
    public String[] getArgsOrder() {
        return args.toArray(new String[0]);
    }
}
