package net.xiaoyu233.mcfdef.parser;

import net.xiaoyu233.mcfdef.antlr.mcfdef.MCFDefParser;
import net.xiaoyu233.mcfdef.antlr.mcfunction.MCFunctionBaseListener;
import net.xiaoyu233.mcfdef.antlr.mcfunction.MCFunctionParser;
import net.xiaoyu233.mcfdef.compile.FunctionCompileException;
import net.xiaoyu233.mcfdef.compile.handler.ParsingCompileErrorHandler;
import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.member.instruction.Command;
import net.xiaoyu233.mcfdef.def.member.instruction.FunctionCall;
import net.xiaoyu233.mcfdef.def.member.instruction.IfStatement;
import net.xiaoyu233.mcfdef.def.member.instruction.Instruction;
import net.xiaoyu233.mcfdef.util.StringUtil;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MCFunctionParseListener extends MCFunctionBaseListener {
    private final MCFunction function;
    private ArrayList<ParsingCompileErrorHandler> exceptionHandlers = new ArrayList<> ();
    private boolean compiled = false;
    public MCFunctionParseListener(MCFunction function){
        this.function = function;
    }

    public void addExceptionHandler(ParsingCompileErrorHandler handler){
        this.exceptionHandlers.add(handler);
    }

    public MCFunction getCompiledFunction() {
        if (!compiled){
            throw new UnsupportedOperationException("The function is being compiled");
        }
        return function;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMcfunction(MCFunctionParser.McfunctionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMcfunction(MCFunctionParser.McfunctionContext ctx) {
        this.compiled = true;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterInstructions(MCFunctionParser.InstructionsContext ctx) {
        List<ParseTree> children = ctx.children;
        for (ParseTree child : children) {
            if (child instanceof MCFunctionParser.FunctionCallContext) {
                MCFunctionParser.FunctionCallContext callContext = ((MCFunctionParser.FunctionCallContext) child);
                FunctionCall call = new FunctionCall(callContext.STRS().getText().trim());
                callContext.realPar().par().forEach((par) -> call.addRealArgument(StringUtil.trimQuote(par.getText().trim())));
                function.addFunctionUsage(call);
            }
            if (child instanceof MCFunctionParser.CommandContext) {
                function.addCommand(new Command(child.getText().trim()));
            }
            if (child instanceof MCFunctionParser.IfStatementContext){
                function.addIfStatement(CommonParser.parseIfStatement(((MCFunctionParser.IfStatementContext) child)));
            }
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitInstructions(MCFunctionParser.InstructionsContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunctionCall(MCFunctionParser.FunctionCallContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunctionCall(MCFunctionParser.FunctionCallContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCommand(MCFunctionParser.CommandContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCommand(MCFunctionParser.CommandContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterRealPar(MCFunctionParser.RealParContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitRealPar(MCFunctionParser.RealParContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPar(MCFunctionParser.ParContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPar(MCFunctionParser.ParContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterHeader(MCFunctionParser.HeaderContext ctx) {
        if (!ctx.tick().isEmpty()){
            this.function.setExecPerTick(true);
        }
        if (!ctx.load().isEmpty()){
            this.function.setExecOnLoad(true);
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitHeader(MCFunctionParser.HeaderContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterInclude(MCFunctionParser.IncludeContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        List<ParseTree> strs = ctx.children;
        for (int i = 1; i < strs.size(); i++) {
            ParseTree str = strs.get(i);
            stringBuilder.append(str);
        }
        function.addFuncDefUseString(stringBuilder.toString());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitInclude(MCFunctionParser.IncludeContext ctx) { }

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
