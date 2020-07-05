package net.xiaoyu233.mcfdef.def.member.instruction;

public abstract class Instruction {
    private String raw;
    public Instruction(String raw){
        this.raw = raw;
    }
    public String getRaw(){
        return raw;
    };
}
