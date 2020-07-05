package net.xiaoyu233.mcfdef.def.member.function;

import java.util.Objects;

public class FunctionToken {
    private String name;
    private int argLength;

    public FunctionToken(IFunction function){
        this.name = function.getName();
        this.argLength = function.getArgCount();
    }
    public FunctionToken(String name,int argLength){
        this.name = name;
        this.argLength = argLength;
    }

    @Override
    public String toString() {
        return name + '(' + "argLength=" + argLength + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FunctionToken that = (FunctionToken) o;
        return argLength == that.argLength && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, argLength);
    }
}
