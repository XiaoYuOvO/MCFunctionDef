package net.xiaoyu233.mcfdef.parser;

import net.xiaoyu233.mcfdef.antlr.mcfdef.MCFDefParser;
import net.xiaoyu233.mcfdef.antlr.mcfunction.MCFunctionParser;
import net.xiaoyu233.mcfdef.def.MCFunction;
import net.xiaoyu233.mcfdef.def.member.instruction.Command;
import net.xiaoyu233.mcfdef.def.member.instruction.FunctionCall;
import net.xiaoyu233.mcfdef.def.member.instruction.IfStatement;
import net.xiaoyu233.mcfdef.util.StringUtil;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class CommonParser {
    public static IfStatement parseIfStatement(MCFDefParser.IfStatementContext context){
        ArrayList<Command> ifConditions = new ArrayList<>();
        List<ParseTree> trees = context.ifCondition().children;
        for (int i = 0; i < trees.size(); i++) {
            ParseTree tree = trees.get(i);
            if (tree instanceof MCFDefParser.CommandContext){
                if (trees.get(i-1).getText().equals("!")){
                    ifConditions.add(new Command("!" + tree.getText().trim()));
                }else {
                    ifConditions.add(new Command(tree.getText().trim()));
                }
            }
        }
        IfStatement ifStatement = new IfStatement(ifConditions);
        int ifInsnCount = context.getChildCount();
        for (int ifLine = 0; ifLine < ifInsnCount ; ifLine ++){
            ParseTree ifTree = context.getChild(ifLine);
            if (ifTree instanceof MCFDefParser.CommandContext) {
                ifStatement.addInstruction(new Command(ifTree.getText().trim()));
            }
            if (ifTree instanceof MCFDefParser.FunctionCallContext) {
                MCFDefParser.FunctionCallContext callContext = ((MCFDefParser.FunctionCallContext) ifTree);
                FunctionCall call = new FunctionCall(callContext.STRS().getText().trim());
                for (MCFDefParser.ParContext parContext : callContext.realPar().par()) {
                    call.addRealArgument(StringUtil.trimQuote(parContext.getText().trim()));
                }
                ifStatement.addInstruction(call);
            }
            if (ifTree instanceof MCFDefParser.IfStatementContext){
                ifStatement.addInstruction(parseIfStatement(((MCFDefParser.IfStatementContext) ifTree)));
            }
        }
        return ifStatement;
    }

    public static IfStatement parseIfStatement(MCFunctionParser.IfStatementContext context){
        ArrayList<Command> ifConditions = new ArrayList<>();
        List<ParseTree> trees = context.ifCondition().children;
        for (int i = 0; i < trees.size(); i++) {
            ParseTree tree = trees.get(i);
            if (tree instanceof MCFunctionParser.CommandContext){
                if (trees.get(i-1).getText().equals("!")){
                    ifConditions.add(new Command("!" + tree.getText().trim()));
                }else {
                    ifConditions.add(new Command(tree.getText().trim()));
                }
            }
        }
        IfStatement ifStatement = new IfStatement(ifConditions);
        int ifInsnCount = context.getChildCount();
        for (int ifLine = 0; ifLine < ifInsnCount ; ifLine ++){
            ParseTree ifTree = context.getChild(ifLine);
            if (ifTree instanceof MCFunctionParser.CommandContext) {
                ifStatement.addInstruction(new Command(ifTree.getText().trim()));
            }
            if (ifTree instanceof MCFunctionParser.FunctionCallContext) {
                MCFunctionParser.FunctionCallContext callContext = ((MCFunctionParser.FunctionCallContext) ifTree);
                FunctionCall call = new FunctionCall(callContext.STRS().getText().trim());
                for (MCFunctionParser.ParContext parContext : callContext.realPar().par()) {
                    call.addRealArgument(StringUtil.trimQuote(parContext.getText().trim()));
                }
                ifStatement.addInstruction(call);
            }
            if (ifTree instanceof MCFunctionParser.IfStatementContext){
                ifStatement.addInstruction(parseIfStatement(((MCFunctionParser.IfStatementContext) ifTree)));
            }
        }
        return ifStatement;
    }
}
