// Generated from H:/IDEAProjects/MCFunctionDef/src\MCFDef.g4 by ANTLR 4.8
package net.xiaoyu233.mcfdef.parser;

import net.xiaoyu233.mcfdef.antlr.mcfdef.MCFDefBaseListener;
import net.xiaoyu233.mcfdef.antlr.mcfdef.MCFDefListener;
import net.xiaoyu233.mcfdef.antlr.mcfdef.MCFDefParser;
import net.xiaoyu233.mcfdef.compile.FunctionCompileException;
import net.xiaoyu233.mcfdef.compile.handler.ParsingCompileErrorHandler;
import net.xiaoyu233.mcfdef.def.MCFunctionDef;
import net.xiaoyu233.mcfdef.def.member.function.FunctionDef;
import net.xiaoyu233.mcfdef.def.member.instruction.Command;
import net.xiaoyu233.mcfdef.def.member.instruction.FunctionCall;
import net.xiaoyu233.mcfdef.def.member.instruction.IfStatement;
import net.xiaoyu233.mcfdef.util.StringUtil;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * This class provides an empty implementation of {@link MCFDefListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class MCFDefParseListener extends MCFDefBaseListener {
    private final MCFunctionDef def;
    private ArrayList<ParsingCompileErrorHandler> exceptionHandlers = new ArrayList<> ();
    private boolean compiled = false;
    public MCFDefParseListener(MCFunctionDef def) {
        this.def = def;
    }


    public void addExceptionHandler(ParsingCompileErrorHandler handler){
        this.exceptionHandlers.add(handler);
    }

    public MCFunctionDef getCompiledDef()  {
        if (!compiled){
            throw new UnsupportedOperationException("The function is being compiled");
        }
        return def;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMcfDef(MCFDefParser.McfDefContext ctx) {

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMcfDef(MCFDefParser.McfDefContext ctx) {
        this.compiled = true;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMethod(MCFDefParser.MethodContext ctx) {
            ArrayList<String> args = new ArrayList<>();
            ctx.parameters().forEach((par) -> par.parameter().forEach((parameterContext -> args.add(parameterContext.getText()))));
            FunctionDef functionDef = new FunctionDef(ctx.methodName().getText().trim(), args);
            int instructionCount = ctx.instructions().getChildCount();
            for (int line = 0; line < instructionCount; line++) {
                ParseTree tree = ctx.instructions().getChild(line);
                if (tree instanceof MCFDefParser.CommandContext) {
                    functionDef.addInstruction(new Command(tree.getText().trim()));
                }
                if (tree instanceof MCFDefParser.FunctionCallContext) {
                    MCFDefParser.FunctionCallContext callContext = ((MCFDefParser.FunctionCallContext) tree);
                    FunctionCall call = new FunctionCall(callContext.STRS().getText().trim());
                    for (MCFDefParser.ParContext parContext : callContext.realPar().par()) {
                        call.addRealArgument(StringUtil.trimQuote(parContext.getText().trim()));
                    }
                    functionDef.addInstruction(call);
                }
                if (tree instanceof MCFDefParser.IfStatementContext){
                    functionDef.addInstruction(CommonParser.parseIfStatement((MCFDefParser.IfStatementContext) tree));
                }
            }
            def.addFunctionDef(functionDef);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMethod(MCFDefParser.MethodContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMethodName(MCFDefParser.MethodNameContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMethodName(MCFDefParser.MethodNameContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParameters(MCFDefParser.ParametersContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParameters(MCFDefParser.ParametersContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParameter(MCFDefParser.ParameterContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParameter(MCFDefParser.ParameterContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterInstructions(MCFDefParser.InstructionsContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitInstructions(MCFDefParser.InstructionsContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunctionCall(MCFDefParser.FunctionCallContext ctx) {

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunctionCall(MCFDefParser.FunctionCallContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCommand(MCFDefParser.CommandContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCommand(MCFDefParser.CommandContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPar(MCFDefParser.ParContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPar(MCFDefParser.ParContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterRealPar(MCFDefParser.RealParContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitRealPar(MCFDefParser.RealParContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterHeader(MCFDefParser.HeaderContext ctx) {
        for (MCFDefParser.IncludeContext includeContext : ctx.include()) {
            def.addMCFunctionDefUse(includeContext.STRS().get(0).getText());
        }
        if (!ctx.global().isEmpty()){
            def.setGlobal(true);
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitHeader(MCFDefParser.HeaderContext ctx) { }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) { }
}