// Generated from H:/IDEAProjects/MCFunctionDef/src\MCFDef.g4 by ANTLR 4.8
package net.xiaoyu233.mcfdef.antlr.mcfdef;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MCFDefParser}.
 */
public interface MCFDefListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#mcfDef}.
	 * @param ctx the parse tree
	 */
	void enterMcfDef(MCFDefParser.McfDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#mcfDef}.
	 * @param ctx the parse tree
	 */
	void exitMcfDef(MCFDefParser.McfDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(MCFDefParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(MCFDefParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(MCFDefParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(MCFDefParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(MCFDefParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(MCFDefParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MCFDefParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MCFDefParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(MCFDefParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(MCFDefParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MCFDefParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MCFDefParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(MCFDefParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(MCFDefParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MCFDefParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MCFDefParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(MCFDefParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(MCFDefParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#par}.
	 * @param ctx the parse tree
	 */
	void enterPar(MCFDefParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#par}.
	 * @param ctx the parse tree
	 */
	void exitPar(MCFDefParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#realPar}.
	 * @param ctx the parse tree
	 */
	void enterRealPar(MCFDefParser.RealParContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#realPar}.
	 * @param ctx the parse tree
	 */
	void exitRealPar(MCFDefParser.RealParContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(MCFDefParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(MCFDefParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(MCFDefParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(MCFDefParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCFDefParser#global}.
	 * @param ctx the parse tree
	 */
	void enterGlobal(MCFDefParser.GlobalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCFDefParser#global}.
	 * @param ctx the parse tree
	 */
	void exitGlobal(MCFDefParser.GlobalContext ctx);
}