// Generated from H:/IDEAProjects/MCFunctionDef/src\MCFunction.g4 by ANTLR 4.8
package net.xiaoyu233.mcfdef.antlr.mcfunction;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MCFunctionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NUM=10, BRACKET=11, BACKBRACKET=12, BRACE=13, BACKBRACE=14, TARGET_SELECETOR=15, 
		CONDITION=16, CHARS=17, TAG=18, COMPOUND=19, ARRAY=20, STRS=21, STR=22, 
		NEW_LINE=23, SIMPLE_COMMENT=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"NUM", "BRACKET", "BACKBRACKET", "BRACE", "BACKBRACE", "TARGET_SELECETOR", 
			"CONDITION", "CHARS", "TAG", "COMPOUND", "ARRAY", "STRS", "STR", "NEW_LINE", 
			"SIMPLE_COMMENT", "WS"
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


	public MCFunctionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MCFunction.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00cf\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\6\13]\n\13\r\13\16\13^\5\13a\n\13"+
		"\3\13\5\13d\n\13\6\13f\n\13\r\13\16\13g\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\5\20u\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22"+
		"~\n\22\3\22\3\22\3\22\3\22\7\22\u0084\n\22\f\22\16\22\u0087\13\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0091\n\23\3\23\5\23\u0094\n"+
		"\23\3\24\3\24\3\24\6\24\u0099\n\24\r\24\16\24\u009a\5\24\u009d\n\24\3"+
		"\24\3\24\3\25\3\25\3\25\5\25\u00a4\n\25\3\25\5\25\u00a7\n\25\6\25\u00a9"+
		"\n\25\r\25\16\25\u00aa\3\25\3\25\3\26\6\26\u00b0\n\26\r\26\16\26\u00b1"+
		"\3\27\5\27\u00b5\n\27\3\30\3\30\3\31\7\31\u00ba\n\31\f\31\16\31\u00bd"+
		"\13\31\3\31\3\31\3\31\7\31\u00c2\n\31\f\31\16\31\u00c5\13\31\3\31\3\31"+
		"\3\32\6\32\u00ca\n\32\r\32\16\32\u00cb\3\32\3\32\2\2\33\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\13\3\2\62;\f\2DDFFHHNNUUddf"+
		"fhhnnuu\6\2ccggrruu\b\2*+..]]__}}\177\177\6\2\"\"%%,,BB\4\2##((\16\2&"+
		")--\60\60\62<>AC\\`ac|~~\u0080\u0080\u4e02\u9fa7\uf902\ufa2f\4\2\f\f\17"+
		"\17\5\2\13\13\17\17\"\"\2\u00e7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2"+
		"\2\5\67\3\2\2\2\7:\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17K\3\2\2"+
		"\2\21M\3\2\2\2\23S\3\2\2\2\25e\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33m\3\2"+
		"\2\2\35o\3\2\2\2\37q\3\2\2\2!v\3\2\2\2#z\3\2\2\2%\u008a\3\2\2\2\'\u0095"+
		"\3\2\2\2)\u00a0\3\2\2\2+\u00af\3\2\2\2-\u00b4\3\2\2\2/\u00b6\3\2\2\2\61"+
		"\u00bb\3\2\2\2\63\u00c9\3\2\2\2\65\66\7\"\2\2\66\4\3\2\2\2\678\7k\2\2"+
		"89\7h\2\29\6\3\2\2\2:;\7(\2\2;<\7(\2\2<\b\3\2\2\2=>\7#\2\2>\n\3\2\2\2"+
		"?@\7.\2\2@\f\3\2\2\2AB\7B\2\2BC\7k\2\2CD\7p\2\2DE\7e\2\2EF\7n\2\2FG\7"+
		"w\2\2GH\7f\2\2HI\7g\2\2IJ\7\"\2\2J\16\3\2\2\2KL\7^\2\2L\20\3\2\2\2MN\7"+
		"B\2\2NO\7v\2\2OP\7k\2\2PQ\7e\2\2QR\7m\2\2R\22\3\2\2\2ST\7B\2\2TU\7n\2"+
		"\2UV\7q\2\2VW\7c\2\2WX\7f\2\2X\24\3\2\2\2Y`\t\2\2\2Z\\\7\60\2\2[]\t\2"+
		"\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`Z\3\2\2\2`a\3"+
		"\2\2\2ac\3\2\2\2bd\t\3\2\2cb\3\2\2\2cd\3\2\2\2df\3\2\2\2eY\3\2\2\2fg\3"+
		"\2\2\2ge\3\2\2\2gh\3\2\2\2h\26\3\2\2\2ij\7}\2\2j\30\3\2\2\2kl\7\177\2"+
		"\2l\32\3\2\2\2mn\7*\2\2n\34\3\2\2\2op\7+\2\2p\36\3\2\2\2qr\7B\2\2rt\t"+
		"\4\2\2su\5!\21\2ts\3\2\2\2tu\3\2\2\2u \3\2\2\2vw\7]\2\2wx\5+\26\2xy\7"+
		"_\2\2y\"\3\2\2\2z\u0085\7$\2\2{~\5-\27\2|~\t\5\2\2}{\3\2\2\2}|\3\2\2\2"+
		"~\u0084\3\2\2\2\177\u0084\t\6\2\2\u0080\u0081\7^\2\2\u0081\u0084\7$\2"+
		"\2\u0082\u0084\t\7\2\2\u0083}\3\2\2\2\u0083\177\3\2\2\2\u0083\u0080\3"+
		"\2\2\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7$"+
		"\2\2\u0089$\3\2\2\2\u008a\u008b\5#\22\2\u008b\u0090\7<\2\2\u008c\u0091"+
		"\5\25\13\2\u008d\u0091\5#\22\2\u008e\u0091\5)\25\2\u008f\u0091\5\'\24"+
		"\2\u0090\u008c\3\2\2\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0094\7.\2\2\u0093\u0092\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094&\3\2\2\2\u0095\u009c\7}\2\2\u0096\u0099\5%\23\2\u0097"+
		"\u0099\5)\25\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c"+
		"\u0098\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7\177"+
		"\2\2\u009f(\3\2\2\2\u00a0\u00a8\7]\2\2\u00a1\u00a4\5\'\24\2\u00a2\u00a4"+
		"\5\25\13\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a6\3\2\2\2"+
		"\u00a5\u00a7\7.\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9"+
		"\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\7_\2\2\u00ad*\3\2\2\2\u00ae"+
		"\u00b0\5-\27\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2,\3\2\2\2\u00b3\u00b5\t\b\2\2\u00b4\u00b3"+
		"\3\2\2\2\u00b5.\3\2\2\2\u00b6\u00b7\7\f\2\2\u00b7\60\3\2\2\2\u00b8\u00ba"+
		"\7\"\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c3\7%"+
		"\2\2\u00bf\u00c2\n\t\2\2\u00c0\u00c2\7\"\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\b\31\2\2\u00c7"+
		"\62\3\2\2\2\u00c8\u00ca\t\n\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2"+
		"\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce"+
		"\b\32\2\2\u00ce\64\3\2\2\2\31\2^`cgt}\u0083\u0085\u0090\u0093\u0098\u009a"+
		"\u009c\u00a3\u00a6\u00aa\u00b1\u00b4\u00bb\u00c1\u00c3\u00cb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}