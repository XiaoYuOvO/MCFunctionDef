package net.xiaoyu233.mcfdef.compile.handler;

import net.xiaoyu233.mcfdef.antlr.ExtraneousInputException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.IntervalSet;

import java.io.File;
import java.util.ArrayList;

public class RecognitionErrorHandler extends DefaultErrorStrategy {
    private final ArrayList<RecognitionException> errors = new ArrayList<>();

    @Override
    protected void reportMissingToken(Parser recognizer) {
        Token t = recognizer.getCurrentToken();
        IntervalSet expecting = getExpectedTokens(recognizer);
        String msg = "missing "+expecting.toString(recognizer.getVocabulary())+
                " at "+getTokenErrorDisplay(t);
        errors.add(new RecognitionException(msg,recognizer,recognizer.getInputStream(),recognizer.getContext()));
    }

    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
        errors.add(new RecognitionException(e.getMessage(),recognizer,recognizer.getInputStream(),recognizer.getContext()));
    }

    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        Token t = recognizer.getCurrentToken();
        String tokenName = getTokenErrorDisplay(t);
        IntervalSet expecting = getExpectedTokens(recognizer);
        String msg = "extraneous input "+tokenName+" expecting "+
                expecting.toString(recognizer.getVocabulary());
        errors.add(new ExtraneousInputException(msg,recognizer,recognizer.getInputStream(),recognizer.getContext()));
    }

    @Override
    public void reportError(Parser recognizer, RecognitionException e) {
        errors.add(e);
    }

    public ArrayList<RecognitionException> getErrors() {
        return errors;
    }
}
