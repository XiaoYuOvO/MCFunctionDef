package net.xiaoyu233.mcfdef.service.minecraft_server;

import net.xiaoyu233.mcfdef.antlr.ExtraneousInputException;
import net.xiaoyu233.mcfdef.compile.FunctionCompileException;
import net.xiaoyu233.mcfdef.compile.handler.CompileErrorHandler;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MCServerCompileErrorHandler implements CompileErrorHandler {
    private MinecraftServer server;

    public MCServerCompileErrorHandler(MinecraftServer server){
        this.server = server;
    }
    protected String getSymbolText(Token symbol) {
        return symbol.getText();
    }
    protected int getSymbolType(Token symbol) {
        return symbol.getType();
    }

    protected String getTokenErrorDisplay(Token t) {
        if ( t==null ) return "<no token>";
        String s = getSymbolText(t);
        if ( s==null ) {
            if ( getSymbolType(t)==Token.EOF ) {
                s = "<EOF>";
            }
            else {
                s = "<"+getSymbolType(t)+">";
            }
        }
        return escapeWSAndQuote(s);
    }

    @Override
    public void reportRecognitionError(List<RecognitionException> es, File source) {
        try {
            printErrorMsgWithID("Cannot compile file: " + source.getCanonicalPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        printErrorMsg("  Total errors: " + es.size());
        for (RecognitionException error : es) {
            if ( error instanceof NoViableAltException) {
                NoViableAltException e = ((NoViableAltException) error);
                TokenStream tokens = ((Parser) error.getRecognizer()).getInputStream();
                String input;
                if ( tokens!=null ) {
                    if ( e.getStartToken().getType()== Token.EOF ) input = "<EOF>";
                    else input = tokens.getText(e.getStartToken(), e.getOffendingToken());
                }
                else {
                    input = "<unknown input>";
                }
                printErrorMsg( "   cause by: no viable alternative at input "+escapeWSAndQuote(input));
            }
            else if ( error instanceof InputMismatchException) {
                {
                    printErrorMsg("    cause by: " +  "mismatched input "+getTokenErrorDisplay(error.getOffendingToken())+
                            " expecting "+error.getExpectedTokens().toString(error.getRecognizer().getVocabulary()));
                }
            }
            else if ( error instanceof FailedPredicateException) {
                Parser recognizer = ((Parser) error.getRecognizer());
                String ruleName = recognizer.getRuleNames()[recognizer.getContext().getRuleIndex()];
                printErrorMsg("    cause by: rule "+ruleName+" "+error.getMessage());
            }else if (error instanceof ExtraneousInputException){
                printErrorMsg("    cause by: " + error.getMessage());
            }else {
                printErrorMsg("    cause by: " + error.getClass().getName()  + " : " +  error.getMessage());
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
        printErrorMsgWithID("Cannot compile file: " + e.getErrorIn().getFileName());
        printErrorMsg("    cause by: " + e.getMessage());
    }

    @Override
    public void reportIOException(IOException e, File handlingFile) {
        printErrorMsgWithID("Error handling file/dir: " + handlingFile.getName());
        printErrorMsg("    cause by: " + e.getMessage());
    }

    public void printErrorMsgWithID(String msg) {
        try {
            server.sendCommand("tellraw @a [{\"text\":\"[MCFDef Compiler]\",\"color\":\"rest\"},{\"color\":\"red\",\"text\":\"" + msg.replace("\\","\\\\") + "\"}]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printErrorMsg(String msg) {
        try {
            server.sendCommand("tellraw @a [{\"color\":\"red\",\"text\":\"" + msg.replace("\\","\\\\") + "\"}]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
