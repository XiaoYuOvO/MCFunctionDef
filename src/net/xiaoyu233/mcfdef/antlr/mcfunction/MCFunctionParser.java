// Generated from H:/IDEAProjects/MCFunctionDef/src\MCFunction.g4 by ANTLR 4.8
package net.xiaoyu233.mcfdef.antlr.mcfunction;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MCFunctionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NUM=10, BRACKET=11, BACKBRACKET=12, BRACE=13, BACKBRACE=14, TARGET_SELECETOR=15, 
		CONDITION=16, CHARS=17, TAG=18, COMPOUND=19, ARRAY=20, STRS=21, STR=22, 
		NEW_LINE=23, SIMPLE_COMMENT=24, WS=25;
	public static final int
		RULE_mcfunction = 0, RULE_instructions = 1, RULE_functionCall = 2, RULE_command = 3, 
		RULE_ifStatement = 4, RULE_ifCondition = 5, RULE_realPar = 6, RULE_par = 7, 
		RULE_header = 8, RULE_include = 9, RULE_tick = 10, RULE_load = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"mcfunction", "instructions", "functionCall", "command", "ifStatement", 
			"ifCondition", "realPar", "par", "header", "include", "tick", "load"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'if'", "'&&'", "'!'", "','", "'@include '", "'\\'", "'@tick'", 
			"'@load'", null, "'{'", "'}'", "'('", "')'", null, null, null, null, 
			null, null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "NUM", "BRACKET", 
			"BACKBRACKET", "BRACE", "BACKBRACE", "TARGET_SELECETOR", "CONDITION", 
			"CHARS", "TAG", "COMPOUND", "ARRAY", "STRS", "STR", "NEW_LINE", "SIMPLE_COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MCFunction.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MCFunctionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class McfunctionContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public McfunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mcfunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterMcfunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitMcfunction(this);
		}
	}

	public final McfunctionContext mcfunction() throws RecognitionException {
		McfunctionContext _localctx = new McfunctionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mcfunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			header();
			setState(25);
			instructions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionsContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(MCFunctionParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(MCFunctionParser.NEW_LINE, i);
		}
		public List<FunctionCallContext> functionCall() {
			return getRuleContexts(FunctionCallContext.class);
		}
		public FunctionCallContext functionCall(int i) {
			return getRuleContext(FunctionCallContext.class,i);
		}
		public List<IfStatementContext> ifStatement() {
			return getRuleContexts(IfStatementContext.class);
		}
		public IfStatementContext ifStatement(int i) {
			return getRuleContext(IfStatementContext.class,i);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitInstructions(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instructions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(27);
					command();
					setState(28);
					match(NEW_LINE);
					}
					break;
				case 2:
					{
					setState(30);
					functionCall();
					setState(31);
					match(NEW_LINE);
					}
					break;
				case 3:
					{
					setState(33);
					ifStatement();
					setState(34);
					match(NEW_LINE);
					}
					break;
				case 4:
					{
					setState(36);
					match(NEW_LINE);
					}
					break;
				}
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << NUM) | (1L << TARGET_SELECETOR) | (1L << CHARS) | (1L << COMPOUND) | (1L << ARRAY) | (1L << STRS) | (1L << NEW_LINE))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode STRS() { return getToken(MCFunctionParser.STRS, 0); }
		public TerminalNode BRACE() { return getToken(MCFunctionParser.BRACE, 0); }
		public TerminalNode BACKBRACE() { return getToken(MCFunctionParser.BACKBRACE, 0); }
		public RealParContext realPar() {
			return getRuleContext(RealParContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(43);
			match(STRS);
			setState(44);
			match(BRACE);
			{
			setState(45);
			realPar();
			}
			setState(46);
			match(BACKBRACE);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public List<TerminalNode> STRS() { return getTokens(MCFunctionParser.STRS); }
		public TerminalNode STRS(int i) {
			return getToken(MCFunctionParser.STRS, i);
		}
		public List<TerminalNode> TARGET_SELECETOR() { return getTokens(MCFunctionParser.TARGET_SELECETOR); }
		public TerminalNode TARGET_SELECETOR(int i) {
			return getToken(MCFunctionParser.TARGET_SELECETOR, i);
		}
		public List<TerminalNode> ARRAY() { return getTokens(MCFunctionParser.ARRAY); }
		public TerminalNode ARRAY(int i) {
			return getToken(MCFunctionParser.ARRAY, i);
		}
		public List<TerminalNode> COMPOUND() { return getTokens(MCFunctionParser.COMPOUND); }
		public TerminalNode COMPOUND(int i) {
			return getToken(MCFunctionParser.COMPOUND, i);
		}
		public List<TerminalNode> CHARS() { return getTokens(MCFunctionParser.CHARS); }
		public TerminalNode CHARS(int i) {
			return getToken(MCFunctionParser.CHARS, i);
		}
		public List<TerminalNode> NUM() { return getTokens(MCFunctionParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(MCFunctionParser.NUM, i);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_command);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(48);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NUM) | (1L << TARGET_SELECETOR) | (1L << CHARS) | (1L << COMPOUND) | (1L << ARRAY) | (1L << STRS))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(51); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public TerminalNode BRACKET() { return getToken(MCFunctionParser.BRACKET, 0); }
		public TerminalNode BACKBRACKET() { return getToken(MCFunctionParser.BACKBRACKET, 0); }
		public List<TerminalNode> NEW_LINE() { return getTokens(MCFunctionParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(MCFunctionParser.NEW_LINE, i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<FunctionCallContext> functionCall() {
			return getRuleContexts(FunctionCallContext.class);
		}
		public FunctionCallContext functionCall(int i) {
			return getRuleContext(FunctionCallContext.class,i);
		}
		public List<IfStatementContext> ifStatement() {
			return getRuleContexts(IfStatementContext.class);
		}
		public IfStatementContext ifStatement(int i) {
			return getRuleContext(IfStatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__1);
			setState(54);
			ifCondition();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEW_LINE) {
				{
				setState(55);
				match(NEW_LINE);
				}
			}

			setState(58);
			match(BRACKET);
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(59);
				match(NEW_LINE);
				}
				break;
			}
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << NUM) | (1L << TARGET_SELECETOR) | (1L << CHARS) | (1L << COMPOUND) | (1L << ARRAY) | (1L << STRS))) != 0)) {
				{
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(62);
					command();
					setState(63);
					match(NEW_LINE);
					}
					break;
				case 2:
					{
					setState(65);
					functionCall();
					setState(66);
					match(NEW_LINE);
					}
					break;
				case 3:
					{
					setState(68);
					ifStatement();
					setState(69);
					match(NEW_LINE);
					}
					break;
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEW_LINE) {
				{
				setState(76);
				match(NEW_LINE);
				}
			}

			setState(79);
			match(BACKBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfConditionContext extends ParserRuleContext {
		public TerminalNode BRACE() { return getToken(MCFunctionParser.BRACE, 0); }
		public TerminalNode BACKBRACE() { return getToken(MCFunctionParser.BACKBRACE, 0); }
		public TerminalNode NEW_LINE() { return getToken(MCFunctionParser.NEW_LINE, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public IfConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterIfCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitIfCondition(this);
		}
	}

	public final IfConditionContext ifCondition() throws RecognitionException {
		IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifCondition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(BRACE);
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(82);
					match(T__2);
					}
				}

				{
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(85);
						match(T__0);
						}
						} 
					}
					setState(90);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				}
				{
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(91);
					match(T__3);
					}
				}

				setState(94);
				command();
				}
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << NUM) | (1L << TARGET_SELECETOR) | (1L << CHARS) | (1L << COMPOUND) | (1L << ARRAY) | (1L << STRS))) != 0) );
			setState(99);
			match(BACKBRACE);
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(100);
				match(NEW_LINE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RealParContext extends ParserRuleContext {
		public List<ParContext> par() {
			return getRuleContexts(ParContext.class);
		}
		public ParContext par(int i) {
			return getRuleContext(ParContext.class,i);
		}
		public RealParContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realPar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterRealPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitRealPar(this);
		}
	}

	public final RealParContext realPar() throws RecognitionException {
		RealParContext _localctx = new RealParContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_realPar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << TARGET_SELECETOR) | (1L << CHARS) | (1L << COMPOUND) | (1L << ARRAY))) != 0)) {
				{
				setState(107);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(103);
					par();
					setState(104);
					match(T__4);
					}
					break;
				case 2:
					{
					setState(106);
					par();
					}
					break;
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(MCFunctionParser.NUM, 0); }
		public TerminalNode TARGET_SELECETOR() { return getToken(MCFunctionParser.TARGET_SELECETOR, 0); }
		public TerminalNode CHARS() { return getToken(MCFunctionParser.CHARS, 0); }
		public TerminalNode ARRAY() { return getToken(MCFunctionParser.ARRAY, 0); }
		public TerminalNode COMPOUND() { return getToken(MCFunctionParser.COMPOUND, 0); }
		public ParContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_par; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitPar(this);
		}
	}

	public final ParContext par() throws RecognitionException {
		ParContext _localctx = new ParContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_par);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(112);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << TARGET_SELECETOR) | (1L << CHARS) | (1L << COMPOUND) | (1L << ARRAY))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public List<TerminalNode> NEW_LINE() { return getTokens(MCFunctionParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(MCFunctionParser.NEW_LINE, i);
		}
		public List<IncludeContext> include() {
			return getRuleContexts(IncludeContext.class);
		}
		public IncludeContext include(int i) {
			return getRuleContext(IncludeContext.class,i);
		}
		public List<TickContext> tick() {
			return getRuleContexts(TickContext.class);
		}
		public TickContext tick(int i) {
			return getRuleContext(TickContext.class,i);
		}
		public List<LoadContext> load() {
			return getRuleContexts(LoadContext.class);
		}
		public LoadContext load(int i) {
			return getRuleContext(LoadContext.class,i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8))) != 0)) {
				{
				{
				setState(117);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(114);
					include();
					}
					break;
				case T__7:
					{
					setState(115);
					tick();
					}
					break;
				case T__8:
					{
					setState(116);
					load();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(119);
				match(NEW_LINE);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeContext extends ParserRuleContext {
		public List<TerminalNode> STRS() { return getTokens(MCFunctionParser.STRS); }
		public TerminalNode STRS(int i) {
			return getToken(MCFunctionParser.STRS, i);
		}
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitInclude(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_include);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__5);
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==STRS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 || _la==STRS );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TickContext extends ParserRuleContext {
		public TickContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tick; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterTick(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitTick(this);
		}
	}

	public final TickContext tick() throws RecognitionException {
		TickContext _localctx = new TickContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tick);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoadContext extends ParserRuleContext {
		public LoadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_load; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFunctionListener ) ((MCFunctionListener)listener).exitLoad(this);
		}
	}

	public final LoadContext load() throws RecognitionException {
		LoadContext _localctx = new LoadContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_load);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u008b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3(\n\3\6\3*\n\3\r\3\16\3+\3\4\3\4\3\4\3\4\3\4\3\5\6\5\64\n\5\r"+
		"\5\16\5\65\3\6\3\6\3\6\5\6;\n\6\3\6\3\6\5\6?\n\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\6\5\6P\n\6\3\6\3\6\3\7\3\7\5"+
		"\7V\n\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\7\5\7_\n\7\3\7\6\7b\n\7\r\7\16"+
		"\7c\3\7\3\7\5\7h\n\7\3\b\3\b\3\b\3\b\7\bn\n\b\f\b\16\bq\13\b\3\t\3\t\3"+
		"\n\3\n\3\n\5\nx\n\n\3\n\3\n\7\n|\n\n\f\n\16\n\177\13\n\3\13\3\13\6\13"+
		"\u0083\n\13\r\13\16\13\u0084\3\f\3\f\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\2\5\7\2\3\3\f\f\21\21\23\23\25\27\6\2\f\f\21\21\23\23"+
		"\25\26\4\2\t\t\27\27\2\u0094\2\32\3\2\2\2\4)\3\2\2\2\6-\3\2\2\2\b\63\3"+
		"\2\2\2\n\67\3\2\2\2\fS\3\2\2\2\16o\3\2\2\2\20r\3\2\2\2\22}\3\2\2\2\24"+
		"\u0080\3\2\2\2\26\u0086\3\2\2\2\30\u0088\3\2\2\2\32\33\5\22\n\2\33\34"+
		"\5\4\3\2\34\3\3\2\2\2\35\36\5\b\5\2\36\37\7\31\2\2\37(\3\2\2\2 !\5\6\4"+
		"\2!\"\7\31\2\2\"(\3\2\2\2#$\5\n\6\2$%\7\31\2\2%(\3\2\2\2&(\7\31\2\2\'"+
		"\35\3\2\2\2\' \3\2\2\2\'#\3\2\2\2\'&\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\3"+
		"\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-.\7\27\2\2./\7\17\2\2/\60\5\16\b"+
		"\2\60\61\7\20\2\2\61\7\3\2\2\2\62\64\t\2\2\2\63\62\3\2\2\2\64\65\3\2\2"+
		"\2\65\63\3\2\2\2\65\66\3\2\2\2\66\t\3\2\2\2\678\7\4\2\28:\5\f\7\29;\7"+
		"\31\2\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<>\7\r\2\2=?\7\31\2\2>=\3\2\2\2>"+
		"?\3\2\2\2?K\3\2\2\2@A\5\b\5\2AB\7\31\2\2BJ\3\2\2\2CD\5\6\4\2DE\7\31\2"+
		"\2EJ\3\2\2\2FG\5\n\6\2GH\7\31\2\2HJ\3\2\2\2I@\3\2\2\2IC\3\2\2\2IF\3\2"+
		"\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LO\3\2\2\2MK\3\2\2\2NP\7\31\2\2ON\3"+
		"\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\16\2\2R\13\3\2\2\2Sa\7\17\2\2TV\7\5\2\2"+
		"UT\3\2\2\2UV\3\2\2\2VZ\3\2\2\2WY\7\3\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2"+
		"\2Z[\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2]_\7\6\2\2^]\3\2\2\2^_\3\2\2\2_`\3\2"+
		"\2\2`b\5\b\5\2aU\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2eg\7\20"+
		"\2\2fh\7\31\2\2gf\3\2\2\2gh\3\2\2\2h\r\3\2\2\2ij\5\20\t\2jk\7\7\2\2kn"+
		"\3\2\2\2ln\5\20\t\2mi\3\2\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2"+
		"p\17\3\2\2\2qo\3\2\2\2rs\t\3\2\2s\21\3\2\2\2tx\5\24\13\2ux\5\26\f\2vx"+
		"\5\30\r\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2xy\3\2\2\2yz\7\31\2\2z|\3\2\2\2"+
		"{w\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\23\3\2\2\2\177}\3\2\2\2\u0080"+
		"\u0082\7\b\2\2\u0081\u0083\t\4\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\25\3\2\2\2\u0086\u0087"+
		"\7\n\2\2\u0087\27\3\2\2\2\u0088\u0089\7\13\2\2\u0089\31\3\2\2\2\24\'+"+
		"\65:>IKOUZ^cgmow}\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}