package net.xiaoyu233.mcfdef.antlr;

import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ExtraneousInputException extends RecognitionException {
    public ExtraneousInputException(String msg,Recognizer<?, ?> recognizer, IntStream input, ParserRuleContext ctx) {
        super(msg,recognizer, input, ctx);
    }
}
