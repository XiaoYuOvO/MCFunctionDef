package net.xiaoyu233.mcfdef.def.member.instruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IfStatement extends Instruction {
    private final ArrayList<Command> condition = new ArrayList<>();
    private final List<Instruction> instructions = new ArrayList<>();
    public IfStatement(Command... condition) {
        super("<ifStatement>");
        this.condition.addAll(Arrays.asList(condition));
    }

    public IfStatement(List<Command> condition){
        super("<ifStatement>");
        this.condition.addAll(condition);
    }

    public Command getCallCommand(String genFunctionName){
        StringBuilder command = new StringBuilder("execute ");
        for (Command command1 : this.condition) {
            String condition = command1.getRaw();
            if (condition.startsWith("!")){
                condition = condition.substring(1);
                command.append("unless ").append(condition).append(" ");
            }else {
                command.append("if ").append(condition).append(" ");
            }
        }
        command.append("run function " + genFunctionName);
        return new Command(command.toString());
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public ArrayList<Command> getCondition() {
        return condition;
    }

    public void addInstruction(Instruction instruction){
        this.instructions.add(instruction);
    }

    public void addAllInstruction(List<Instruction> instruction){
        this.instructions.addAll(instruction);
    }
}
