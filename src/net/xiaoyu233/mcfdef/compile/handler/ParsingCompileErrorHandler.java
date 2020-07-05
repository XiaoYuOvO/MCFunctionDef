package net.xiaoyu233.mcfdef.compile.handler;

import net.xiaoyu233.mcfdef.compile.FunctionCompileException;
import org.antlr.v4.runtime.RecognitionException;

import java.util.ArrayList;

public class ParsingCompileErrorHandler {
    private final ArrayList<FunctionCompileException> errors = new ArrayList<>();
    public void addError(FunctionCompileException e){
        errors.add(e);
    }

    public ArrayList<FunctionCompileException> getErrors() {
        return errors;
    }
}
