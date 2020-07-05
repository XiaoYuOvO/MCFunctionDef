// Generated from H:/IDEAProjects/MCFunctionDef/src\MCFDef.g4 by ANTLR 4.8
package net.xiaoyu233.mcfdef.antlr.mcfdef;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MCFDefParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, BRACKET=9, 
		BACKBRACKET=10, BRACE=11, BACKBRACE=12, CHARS=13, TARGET_SELECETOR=14, 
		CONDITION=15, REFER=16, TAG=17, NUM=18, COMPOUND=19, ARRAY=20, STRS=21, 
		STR=22, NEW_LINE=23, SIMPLE_COMMENT=24, WS=25;
	public static final int
		RULE_mcfDef = 0, RULE_method = 1, RULE_methodName = 2, RULE_parameters = 3, 
		RULE_parameter = 4, RULE_instructions = 5, RULE_functionCall = 6, RULE_command = 7, 
		RULE_ifStatement = 8, RULE_ifCondition = 9, RULE_par = 10, RULE_realPar = 11, 
		RULE_header = 12, RULE_include = 13, RULE_global = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"mcfDef", "method", "methodName", "parameters", "parameter", "instructions", 
			"functionCall", "command", "ifStatement", "ifCondition", "par", "realPar", 
			"header", "include", "global"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "','", "'if'", "'&&'", "'!'", "'@include '", "'\\'", "'@global'", 
			"'{'", "'}'", "'('", "')'", null, null, null, null, null, null, null, 
			null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "BRACKET", "BACKBRACKET", 
			"BRACE", "BACKBRACE", "CHARS", "TARGET_SELECETOR", "CONDITION", "REFER", 
			"TAG", "NUM", "COMPOUND", "ARRAY", "STRS", "STR", "NEW_LINE", "SIMPLE_COMMENT", 
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
	public String getGrammarFileName() { return "MCFDef.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MCFDefParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class McfDefContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(MCFDefParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(MCFDefParser.NEW_LINE, i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public McfDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mcfDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterMcfDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitMcfDef(this);
		}
	}

	public final McfDefContext mcfDef() throws RecognitionException {
		McfDefContext _localctx = new McfDefContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mcfDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			header();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEW_LINE) {
				{
				{
				setState(31);
				match(NEW_LINE);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				method();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==STRS );
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

	public static class MethodContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TerminalNode BRACE() { return getToken(MCFDefParser.BRACE, 0); }
		public TerminalNode BACKBRACE() { return getToken(MCFDefParser.BACKBRACE, 0); }
		public TerminalNode BRACKET() { return getToken(MCFDefParser.BRACKET, 0); }
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public TerminalNode BACKBRACKET() { return getToken(MCFDefParser.BACKBRACKET, 0); }
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(MCFDefParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(MCFDefParser.NEW_LINE, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			methodName();
			setState(43);
			match(BRACE);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==STRS) {
				{
				{
				setState(44);
				parameters();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(BACKBRACE);
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(51);
				match(NEW_LINE);
				}
				break;
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(54);
				match(T__0);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEW_LINE) {
				{
				setState(60);
				match(NEW_LINE);
				}
			}

			setState(63);
			match(BRACKET);
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(64);
				match(NEW_LINE);
				}
				break;
			}
			setState(67);
			instructions();
			setState(68);
			match(BACKBRACKET);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEW_LINE) {
				{
				{
				setState(69);
				match(NEW_LINE);
				}
				}
				setState(74);
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

	public static class MethodNameContext extends ParserRuleContext {
		public List<TerminalNode> STRS() { return getTokens(MCFDefParser.STRS); }
		public TerminalNode STRS(int i) {
			return getToken(MCFDefParser.STRS, i);
		}
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitMethodName(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_methodName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==STRS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==STRS );
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

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameters);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__1) {
						{
						setState(80);
						match(T__1);
						}
					}

					{
					setState(83);
					parameter();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(86); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode STRS() { return getToken(MCFDefParser.STRS, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(STRS);
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
		public List<IfStatementContext> ifStatement() {
			return getRuleContexts(IfStatementContext.class);
		}
		public IfStatementContext ifStatement(int i) {
			return getRuleContext(IfStatementContext.class,i);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(MCFDefParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(MCFDefParser.NEW_LINE, i);
		}
		public List<TerminalNode> SIMPLE_COMMENT() { return getTokens(MCFDefParser.SIMPLE_COMMENT); }
		public TerminalNode SIMPLE_COMMENT(int i) {
			return getToken(MCFDefParser.SIMPLE_COMMENT, i);
		}
		public List<FunctionCallContext> functionCall() {
			return getRuleContexts(FunctionCallContext.class);
		}
		public FunctionCallContext functionCall(int i) {
			return getRuleContext(FunctionCallContext.class,i);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitInstructions(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instructions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(97);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(90);
					_la = _input.LA(1);
					if ( !(_la==NEW_LINE || _la==SIMPLE_COMMENT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(91);
					command();
					}
					break;
				case 2:
					{
					setState(92);
					ifStatement();
					}
					break;
				case 3:
					{
					{
					setState(93);
					_la = _input.LA(1);
					if ( !(_la==NEW_LINE || _la==SIMPLE_COMMENT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(94);
					functionCall();
					}
					}
					break;
				case 4:
					{
					setState(95);
					match(NEW_LINE);
					}
					break;
				case 5:
					{
					setState(96);
					match(T__0);
					}
					break;
				}
				}
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << NEW_LINE) | (1L << SIMPLE_COMMENT))) != 0) );
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
		public TerminalNode STRS() { return getToken(MCFDefParser.STRS, 0); }
		public TerminalNode BRACE() { return getToken(MCFDefParser.BRACE, 0); }
		public TerminalNode BACKBRACE() { return getToken(MCFDefParser.BACKBRACE, 0); }
		public RealParContext realPar() {
			return getRuleContext(RealParContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(STRS);
			setState(102);
			match(BRACE);
			{
			setState(103);
			realPar();
			}
			setState(104);
			match(BACKBRACE);
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
		public List<TerminalNode> STRS() { return getTokens(MCFDefParser.STRS); }
		public TerminalNode STRS(int i) {
			return getToken(MCFDefParser.STRS, i);
		}
		public List<TerminalNode> TARGET_SELECETOR() { return getTokens(MCFDefParser.TARGET_SELECETOR); }
		public TerminalNode TARGET_SELECETOR(int i) {
			return getToken(MCFDefParser.TARGET_SELECETOR, i);
		}
		public List<TerminalNode> ARRAY() { return getTokens(MCFDefParser.ARRAY); }
		public TerminalNode ARRAY(int i) {
			return getToken(MCFDefParser.ARRAY, i);
		}
		public List<TerminalNode> COMPOUND() { return getTokens(MCFDefParser.COMPOUND); }
		public TerminalNode COMPOUND(int i) {
			return getToken(MCFDefParser.COMPOUND, i);
		}
		public List<TerminalNode> CHARS() { return getTokens(MCFDefParser.CHARS); }
		public TerminalNode CHARS(int i) {
			return getToken(MCFDefParser.CHARS, i);
		}
		public List<TerminalNode> NUM() { return getTokens(MCFDefParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(MCFDefParser.NUM, i);
		}
		public List<TerminalNode> REFER() { return getTokens(MCFDefParser.REFER); }
		public TerminalNode REFER(int i) {
			return getToken(MCFDefParser.REFER, i);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_command);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(STRS);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(107);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << CHARS) | (1L << TARGET_SELECETOR) | (1L << REFER) | (1L << NUM) | (1L << COMPOUND) | (1L << ARRAY) | (1L << STRS))) != 0)) ) {
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
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class IfStatementContext extends ParserRuleContext {
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public TerminalNode BRACKET() { return getToken(MCFDefParser.BRACKET, 0); }
		public TerminalNode BACKBRACKET() { return getToken(MCFDefParser.BACKBRACKET, 0); }
		public List<TerminalNode> NEW_LINE() { return getTokens(MCFDefParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(MCFDefParser.NEW_LINE, i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<IfStatementContext> ifStatement() {
			return getRuleContexts(IfStatementContext.class);
		}
		public IfStatementContext ifStatement(int i) {
			return getRuleContext(IfStatementContext.class,i);
		}
		public List<TerminalNode> SIMPLE_COMMENT() { return getTokens(MCFDefParser.SIMPLE_COMMENT); }
		public TerminalNode SIMPLE_COMMENT(int i) {
			return getToken(MCFDefParser.SIMPLE_COMMENT, i);
		}
		public List<FunctionCallContext> functionCall() {
			return getRuleContexts(FunctionCallContext.class);
		}
		public FunctionCallContext functionCall(int i) {
			return getRuleContext(FunctionCallContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__2);
			setState(114);
			ifCondition();
			setState(115);
			match(BRACKET);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(122);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(116);
						_la = _input.LA(1);
						if ( !(_la==NEW_LINE || _la==SIMPLE_COMMENT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(117);
						command();
						}
						break;
					case 2:
						{
						{
						setState(118);
						_la = _input.LA(1);
						if ( !(_la==NEW_LINE || _la==SIMPLE_COMMENT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(119);
						functionCall();
						}
						}
						break;
					case 3:
						{
						setState(120);
						ifStatement();
						}
						break;
					case 4:
						{
						setState(121);
						match(NEW_LINE);
						}
						break;
					}
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEW_LINE) {
				{
				setState(129);
				match(NEW_LINE);
				}
			}

			setState(132);
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
		public TerminalNode BRACE() { return getToken(MCFDefParser.BRACE, 0); }
		public TerminalNode BACKBRACE() { return getToken(MCFDefParser.BACKBRACE, 0); }
		public TerminalNode NEW_LINE() { return getToken(MCFDefParser.NEW_LINE, 0); }
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
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterIfCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitIfCondition(this);
		}
	}

	public final IfConditionContext ifCondition() throws RecognitionException {
		IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(BRACE);
			setState(148); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(135);
					match(T__3);
					}
				}

				{
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(138);
					match(T__0);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				{
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(144);
					match(T__4);
					}
				}

				setState(147);
				command();
				}
				}
				}
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << STRS))) != 0) );
			setState(152);
			match(BACKBRACE);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEW_LINE) {
				{
				setState(153);
				match(NEW_LINE);
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

	public static class ParContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(MCFDefParser.NUM, 0); }
		public TerminalNode TARGET_SELECETOR() { return getToken(MCFDefParser.TARGET_SELECETOR, 0); }
		public TerminalNode REFER() { return getToken(MCFDefParser.REFER, 0); }
		public TerminalNode CHARS() { return getToken(MCFDefParser.CHARS, 0); }
		public TerminalNode ARRAY() { return getToken(MCFDefParser.ARRAY, 0); }
		public TerminalNode COMPOUND() { return getToken(MCFDefParser.COMPOUND, 0); }
		public ParContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_par; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitPar(this);
		}
	}

	public final ParContext par() throws RecognitionException {
		ParContext _localctx = new ParContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_par);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHARS) | (1L << TARGET_SELECETOR) | (1L << REFER) | (1L << NUM) | (1L << COMPOUND) | (1L << ARRAY))) != 0)) ) {
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
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterRealPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitRealPar(this);
		}
	}

	public final RealParContext realPar() throws RecognitionException {
		RealParContext _localctx = new RealParContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_realPar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << CHARS) | (1L << TARGET_SELECETOR) | (1L << REFER) | (1L << NUM) | (1L << COMPOUND) | (1L << ARRAY))) != 0)) {
				{
				setState(161);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(158);
					match(T__1);
					setState(159);
					par();
					}
					break;
				case CHARS:
				case TARGET_SELECETOR:
				case REFER:
				case NUM:
				case COMPOUND:
				case ARRAY:
					{
					setState(160);
					par();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(165);
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

	public static class HeaderContext extends ParserRuleContext {
		public List<IncludeContext> include() {
			return getRuleContexts(IncludeContext.class);
		}
		public IncludeContext include(int i) {
			return getRuleContext(IncludeContext.class,i);
		}
		public List<GlobalContext> global() {
			return getRuleContexts(GlobalContext.class);
		}
		public GlobalContext global(int i) {
			return getRuleContext(GlobalContext.class,i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5 || _la==T__7) {
				{
				setState(168);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(166);
					include();
					}
					break;
				case T__7:
					{
					setState(167);
					global();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(172);
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
		public TerminalNode NEW_LINE() { return getToken(MCFDefParser.NEW_LINE, 0); }
		public List<TerminalNode> STRS() { return getTokens(MCFDefParser.STRS); }
		public TerminalNode STRS(int i) {
			return getToken(MCFDefParser.STRS, i);
		}
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitInclude(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_include);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__5);
			setState(175); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(174);
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
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(177); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(179);
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

	public static class GlobalContext extends ParserRuleContext {
		public GlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).enterGlobal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MCFDefListener ) ((MCFDefListener)listener).exitGlobal(this);
		}
	}

	public final GlobalContext global() throws RecognitionException {
		GlobalContext _localctx = new GlobalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_global);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00bb\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f"+
		"\2\16\2&\13\2\3\2\6\2)\n\2\r\2\16\2*\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63"+
		"\13\3\3\3\3\3\5\3\67\n\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\5\3@\n\3\3\3"+
		"\3\3\5\3D\n\3\3\3\3\3\3\3\7\3I\n\3\f\3\16\3L\13\3\3\4\6\4O\n\4\r\4\16"+
		"\4P\3\5\5\5T\n\5\3\5\6\5W\n\5\r\5\16\5X\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\6\7d\n\7\r\7\16\7e\3\b\3\b\3\b\3\b\3\b\3\t\3\t\7\to\n\t\f\t\16"+
		"\tr\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n}\n\n\7\n\177\n\n\f\n"+
		"\16\n\u0082\13\n\3\n\5\n\u0085\n\n\3\n\3\n\3\13\3\13\5\13\u008b\n\13\3"+
		"\13\7\13\u008e\n\13\f\13\16\13\u0091\13\13\3\13\5\13\u0094\n\13\3\13\6"+
		"\13\u0097\n\13\r\13\16\13\u0098\3\13\3\13\5\13\u009d\n\13\3\f\3\f\3\r"+
		"\3\r\3\r\7\r\u00a4\n\r\f\r\16\r\u00a7\13\r\3\16\3\16\7\16\u00ab\n\16\f"+
		"\16\16\16\u00ae\13\16\3\17\3\17\6\17\u00b2\n\17\r\17\16\17\u00b3\3\17"+
		"\5\17\u00b7\n\17\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36\2\7\4\2\3\3\27\27\3\2\31\32\6\2\3\3\17\20\22\22\24\27\5\2\17\20"+
		"\22\22\24\26\4\2\t\t\27\27\2\u00cc\2 \3\2\2\2\4,\3\2\2\2\6N\3\2\2\2\b"+
		"V\3\2\2\2\nZ\3\2\2\2\fc\3\2\2\2\16g\3\2\2\2\20l\3\2\2\2\22s\3\2\2\2\24"+
		"\u0088\3\2\2\2\26\u009e\3\2\2\2\30\u00a5\3\2\2\2\32\u00ac\3\2\2\2\34\u00af"+
		"\3\2\2\2\36\u00b8\3\2\2\2 $\5\32\16\2!#\7\31\2\2\"!\3\2\2\2#&\3\2\2\2"+
		"$\"\3\2\2\2$%\3\2\2\2%(\3\2\2\2&$\3\2\2\2\')\5\4\3\2(\'\3\2\2\2)*\3\2"+
		"\2\2*(\3\2\2\2*+\3\2\2\2+\3\3\2\2\2,-\5\6\4\2-\61\7\r\2\2.\60\5\b\5\2"+
		"/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61"+
		"\3\2\2\2\64\66\7\16\2\2\65\67\7\31\2\2\66\65\3\2\2\2\66\67\3\2\2\2\67"+
		";\3\2\2\28:\7\3\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<?\3\2\2\2"+
		"=;\3\2\2\2>@\7\31\2\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AC\7\13\2\2BD\7\31"+
		"\2\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\5\f\7\2FJ\7\f\2\2GI\7\31\2\2HG\3"+
		"\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\5\3\2\2\2LJ\3\2\2\2MO\t\2\2\2NM"+
		"\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\7\3\2\2\2RT\7\4\2\2SR\3\2\2\2"+
		"ST\3\2\2\2TU\3\2\2\2UW\5\n\6\2VS\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2"+
		"Y\t\3\2\2\2Z[\7\27\2\2[\13\3\2\2\2\\]\t\3\2\2]d\5\20\t\2^d\5\22\n\2_`"+
		"\t\3\2\2`d\5\16\b\2ad\7\31\2\2bd\7\3\2\2c\\\3\2\2\2c^\3\2\2\2c_\3\2\2"+
		"\2ca\3\2\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\r\3\2\2\2gh\7\27"+
		"\2\2hi\7\r\2\2ij\5\30\r\2jk\7\16\2\2k\17\3\2\2\2lp\7\27\2\2mo\t\4\2\2"+
		"nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\21\3\2\2\2rp\3\2\2\2st\7\5\2"+
		"\2tu\5\24\13\2u\u0080\7\13\2\2vw\t\3\2\2w}\5\20\t\2xy\t\3\2\2y}\5\16\b"+
		"\2z}\5\22\n\2{}\7\31\2\2|v\3\2\2\2|x\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\177"+
		"\3\2\2\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\7\31\2\2\u0084"+
		"\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\f"+
		"\2\2\u0087\23\3\2\2\2\u0088\u0096\7\r\2\2\u0089\u008b\7\6\2\2\u008a\u0089"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008f\3\2\2\2\u008c\u008e\7\3\2\2\u008d"+
		"\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0094\7\7\2\2\u0093"+
		"\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\5\20"+
		"\t\2\u0096\u008a\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\7\16\2\2\u009b\u009d\7"+
		"\31\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\25\3\2\2\2\u009e"+
		"\u009f\t\5\2\2\u009f\27\3\2\2\2\u00a0\u00a1\7\4\2\2\u00a1\u00a4\5\26\f"+
		"\2\u00a2\u00a4\5\26\f\2\u00a3\u00a0\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\31\3\2\2"+
		"\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\5\34\17\2\u00a9\u00ab\5\36\20\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\33\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1"+
		"\7\b\2\2\u00b0\u00b2\t\6\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b7\7\31"+
		"\2\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\35\3\2\2\2\u00b8\u00b9"+
		"\7\n\2\2\u00b9\37\3\2\2\2\36$*\61\66;?CJPSXcep|\u0080\u0084\u008a\u008f"+
		"\u0093\u0098\u009c\u00a3\u00a5\u00aa\u00ac\u00b3\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}