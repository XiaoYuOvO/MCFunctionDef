package net.xiaoyu233.mcfdef.compile.handler;

import net.xiaoyu233.mcfdef.antlr.ExtraneousInputException;
import net.xiaoyu233.mcfdef.compile.FunctionCompileException;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DefaultCompileErrorHandler extends DefaultErrorStrategy implements CompileErrorHandler{


    @Override
    public void reportRecognitionError(List<RecognitionException> es, File source) {
        try {
            System.err.println("[MCFDef Compiler] Cannot compile file: " + source.getCanonicalPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.err.println("  Total errors: " + es.size());
        for (RecognitionException error : es) {
            if ( error instanceof NoViableAltException) {
                NoViableAltException e = ((NoViableAltException) error);
                TokenStream tokens = ((Parser) error.getRecognizer()).getInputStream();
                String input;
                if ( tokens!=null ) {
                    if ( e.getStartToken().getType()==Token.EOF ) input = "<EOF>";
                    else input = tokens.getText(e.getStartToken(), e.getOffendingToken());
                }
                else {
                    input = "<unknown input>";
                }
                System.err.println( "   cause by: no viable alternative at input "+escapeWSAndQuote(input));
            }
            else if ( error instanceof InputMismatchException) {
                {
                    System.err.println("    cause by: " +  "mismatched input "+getTokenErrorDisplay(error.getOffendingToken())+
                            " expecting "+error.getExpectedTokens().toString(error.getRecognizer().getVocabulary()));
                }
            }
            else if ( error instanceof FailedPredicateException) {
                Parser recognizer = ((Parser) error.getRecognizer());
                String ruleName = recognizer.getRuleNames()[recognizer.getContext().getRuleIndex()];
                System.out.println("    cause by: rule "+ruleName+" "+error.getMessage());
            }else if (error instanceof ExtraneousInputException){
                System.err.println("    cause by: " + error.getMessage());
            }else {
                System.err.println("    cause by: " + error.getClass().getName() + "<Unknown Type>: " +  error.getMessage());
            }
        }
    }

    protected String escapeWSAndQuote(String s) {
        s = s.replace("\n","\\n");
        s = s.replace("\r","\\r");
        s = s.replace("\t","\\t");
        return "'"+s+"'";
    }

    @Override
    public void reportCompileError(FunctionCompileException e) {
        System.err.println("[MCFDef Compiler] Cannot compile file: " + e.getErrorIn().getFileName());
        System.err.println("    cause by: " + e.getMessage());
    }

    @Override
    public void reportIOException(IOException e, File handlingFile) {
        System.err.println("[MCFDef Compiler] Error processing file/dir: " + handlingFile.getAbsolutePath());
        System.err.println("    cause by: " + e.getMessage());
    }
}
