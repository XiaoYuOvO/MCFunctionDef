package net.xiaoyu233.mcfdef.compile;

import net.xiaoyu233.mcfdef.def.Compilable;
import net.xiaoyu233.mcfdef.def.MCFunction;

public class FunctionCompileException extends RuntimeException {
    private Compilable errorIn;
    public FunctionCompileException(String msg,Compilable errorIn) {
        super(msg);
        this.errorIn = errorIn;
    }

    public Compilable getErrorIn() {
        return errorIn;
    }

    public FunctionCompileException() {
    }
}
