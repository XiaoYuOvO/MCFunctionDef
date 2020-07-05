// Generated from H:/IDEAProjects/MCFunctionDef/src\MCFunction.g4 by ANTLR 4.8
package net.xiaoyu233.mcfdef.antlr.mcfunction;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MCFunctionParser}.
 */
public interface MCFunctionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#mcfunction}.
	 * @param ctx the parse tree
	 */
	void enterMcfunction(MCFunctionParser.McfunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#mcfunction}.
	 * @param ctx the parse tree
	 */
	void exitMcfunction(MCFunctionParser.McfunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(MCFunctionParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(MCFunctionParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MCFunctionParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MCFunctionParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(MCFunctionParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(MCFunctionParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MCFunctionParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MCFunctionParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(MCFunctionParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(MCFunctionParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#realPar}.
	 * @param ctx the parse tree
	 */
	void enterRealPar(MCFunctionParser.RealParContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#realPar}.
	 * @param ctx the parse tree
	 */
	void exitRealPar(MCFunctionParser.RealParContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#par}.
	 * @param ctx the parse tree
	 */
	void enterPar(MCFunctionParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#par}.
	 * @param ctx the parse tree
	 */
	void exitPar(MCFunctionParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(MCFunctionParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(MCFunctionParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(MCFunctionParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(MCFunctionParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#tick}.
	 * @param ctx the parse tree
	 */
	void enterTick(MCFunctionParser.TickContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#tick}.
	 * @param ctx the parse tree
	 */
	void exitTick(MCFunctionParser.TickContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFunctionParser#load}.
	 * @param ctx the parse tree
	 */
	void enterLoad(MCFunctionParser.LoadContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFunctionParser#load}.
	 * @param ctx the parse tree
	 */
	void exitLoad(MCFunctionParser.LoadContext ctx);
}