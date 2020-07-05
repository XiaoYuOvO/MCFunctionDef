package net.xiaoyu233.mcfdef.compile.handler;

import net.xiaoyu233.mcfdef.compile.FunctionCompileException;
import org.antlr.v4.runtime.RecognitionException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CompileErrorHandler {
    void reportRecognitionError(List<RecognitionException> es, File source);
    void reportCompileError(FunctionCompileException e);
    void reportIOException(IOException e,File handlingFile);
}
