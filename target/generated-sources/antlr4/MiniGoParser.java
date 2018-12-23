// Generated from MiniGo.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniGoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__20=1, T__19=2, T__18=3, T__17=4, T__16=5, T__15=6, T__14=7, T__13=8, 
		T__12=9, T__11=10, T__10=11, T__9=12, T__8=13, T__7=14, T__6=15, T__5=16, 
		T__4=17, T__3=18, T__2=19, T__1=20, T__0=21, VOID=22, VAR=23, CASE=24, 
		SWITCH=25, FUNC=26, FMT=27, INT=28, STRING=29, FLOAT=30, FOR=31, IF=32, 
		ELSE=33, RETURN=34, DEFAULT=35, OR=36, AND=37, LE=38, GE=39, EQ=40, NE=41, 
		IDENT=42, LITERAL=43, DecimalConstant=44, OctalConstant=45, HexadecimalConstant=46, 
		StringConstant=47, WS=48;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "':'", "'{'", "'['", "'<'", "'++'", "'--'", "'}'", 
		"'='", "']'", "'>'", "'!'", "'%'", "'\"'", "'('", "')'", "'*'", "'+'", 
		"','", "'-'", "'.'", "'void'", "'var'", "'case'", "'switch'", "'func'", 
		"'fmt'", "'int'", "'string'", "'float'", "'for'", "'if'", "'else'", "'return'", 
		"'default'", "'or'", "'and'", "'<='", "'>='", "'=='", "'!='", "IDENT", 
		"LITERAL", "DecimalConstant", "OctalConstant", "HexadecimalConstant", 
		"StringConstant", "WS"
	};
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type_spec = 3, 
		RULE_fun_decl = 4, RULE_params = 5, RULE_param = 6, RULE_stmt = 7, RULE_expr_stmt = 8, 
		RULE_assign_stmt = 9, RULE_compound_stmt = 10, RULE_if_stmt = 11, RULE_for_stmt = 12, 
		RULE_switch_stmt = 13, RULE_case_stmt = 14, RULE_return_stmt = 15, RULE_local_decl = 16, 
		RULE_expr = 17, RULE_args = 18;
	public static final String[] ruleNames = {
		"program", "decl", "var_decl", "type_spec", "fun_decl", "params", "param", 
		"stmt", "expr_stmt", "assign_stmt", "compound_stmt", "if_stmt", "for_stmt", 
		"switch_stmt", "case_stmt", "return_stmt", "local_decl", "expr", "args"
	};

	@Override
	public String getGrammarFileName() { return "MiniGo.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniGoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
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
				setState(38); decl();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR || _la==FUNC );
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

	public static class DeclContext extends ParserRuleContext {
		public Fun_declContext fun_decl() {
			return getRuleContext(Fun_declContext.class,0);
		}
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(45);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); var_decl();
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(44); fun_decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Var_declContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MiniGoParser.VAR, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT(int i) {
			return getToken(MiniGoParser.IDENT, i);
		}
		public TerminalNode LITERAL() { return getToken(MiniGoParser.LITERAL, 0); }
		public List<TerminalNode> IDENT() { return getTokens(MiniGoParser.IDENT); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			setState(61);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); match(VAR);
				setState(48); match(IDENT);
				setState(49); type_spec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50); match(VAR);
				setState(51); match(IDENT);
				setState(52); match(T__2);
				setState(53); match(IDENT);
				setState(54); type_spec();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55); match(VAR);
				setState(56); match(IDENT);
				setState(57); match(T__17);
				setState(58); match(LITERAL);
				setState(59); match(T__11);
				setState(60); type_spec();
				}
				break;
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

	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(MiniGoParser.VOID, 0); }
		public TerminalNode STRING() { return getToken(MiniGoParser.STRING, 0); }
		public TerminalNode INT() { return getToken(MiniGoParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(MiniGoParser.FLOAT, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitType_spec(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_spec);
		try {
			setState(68);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(63); match(INT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(64); match(STRING);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(65); match(FLOAT);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 4);
				{
				setState(66); match(VOID);
				}
				break;
			case EOF:
			case T__18:
			case T__15:
			case T__14:
			case T__13:
			case T__12:
			case T__9:
			case T__6:
			case T__5:
			case T__3:
			case T__2:
			case T__1:
			case VAR:
			case CASE:
			case SWITCH:
			case FUNC:
			case FMT:
			case FOR:
			case IF:
			case RETURN:
			case DEFAULT:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Fun_declContext extends ParserRuleContext {
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<Type_specContext> type_spec() {
			return getRuleContexts(Type_specContext.class);
		}
		public Type_specContext type_spec(int i) {
			return getRuleContext(Type_specContext.class,i);
		}
		public TerminalNode FUNC() { return getToken(MiniGoParser.FUNC, 0); }
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Fun_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterFun_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitFun_decl(this);
		}
	}

	public final Fun_declContext fun_decl() throws RecognitionException {
		Fun_declContext _localctx = new Fun_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun_decl);
		try {
			setState(90);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); match(FUNC);
				setState(71); match(IDENT);
				setState(72); match(T__6);
				setState(73); params();
				setState(74); match(T__5);
				setState(75); type_spec();
				setState(76); compound_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78); match(FUNC);
				setState(79); match(IDENT);
				setState(80); match(T__6);
				setState(81); params();
				setState(82); match(T__5);
				setState(83); match(T__6);
				setState(84); type_spec();
				setState(85); match(T__2);
				setState(86); type_spec();
				setState(87); match(T__5);
				setState(88); compound_stmt();
				}
				break;
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			setState(101);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(93); param();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(94); match(T__2);
					setState(95); param();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParamContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); match(IDENT);
				setState(104); type_spec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105); match(IDENT);
				setState(106); match(T__17);
				setState(107); match(T__11);
				setState(108); type_spec();
				}
				break;
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

	public static class StmtContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Switch_stmtContext switch_stmt() {
			return getRuleContext(Switch_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		try {
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111); expr_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112); compound_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113); assign_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114); if_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(115); for_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(116); return_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(117); switch_stmt();
				}
				break;
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

	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitExpr_stmt(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); expr(0);
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

	public static class Assign_stmtContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MiniGoParser.VAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT(int i) {
			return getToken(MiniGoParser.IDENT, i);
		}
		public TerminalNode LITERAL(int i) {
			return getToken(MiniGoParser.LITERAL, i);
		}
		public List<TerminalNode> LITERAL() { return getTokens(MiniGoParser.LITERAL); }
		public List<TerminalNode> IDENT() { return getTokens(MiniGoParser.IDENT); }
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitAssign_stmt(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assign_stmt);
		try {
			setState(165);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); match(VAR);
				setState(123); match(IDENT);
				setState(124); match(T__2);
				setState(125); match(IDENT);
				setState(126); type_spec();
				setState(127); match(T__12);
				setState(128); match(LITERAL);
				setState(129); match(T__2);
				setState(130); match(LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132); match(VAR);
				setState(133); match(IDENT);
				setState(134); type_spec();
				setState(135); match(T__12);
				setState(136); expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138); match(VAR);
				setState(139); match(IDENT);
				setState(140); type_spec();
				setState(141); match(T__12);
				setState(142); match(T__7);
				setState(143); expr(0);
				setState(144); match(T__7);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(146); match(IDENT);
				setState(147); type_spec();
				setState(148); match(T__12);
				setState(149); expr(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(151); match(IDENT);
				setState(152); type_spec();
				setState(153); match(T__12);
				setState(154); match(T__7);
				setState(155); expr(0);
				setState(156); match(T__7);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(158); match(IDENT);
				setState(159); match(T__17);
				setState(160); expr(0);
				setState(161); match(T__11);
				setState(162); match(T__12);
				setState(163); expr(0);
				}
				break;
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public List<Local_declContext> local_decl() {
			return getRuleContexts(Local_declContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public Local_declContext local_decl(int i) {
			return getRuleContext(Local_declContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitCompound_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compound_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(167); match(T__18);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(168); local_decl();
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__15) | (1L << T__14) | (1L << T__9) | (1L << T__6) | (1L << T__3) | (1L << T__1) | (1L << VAR) | (1L << CASE) | (1L << SWITCH) | (1L << FMT) | (1L << FOR) | (1L << IF) | (1L << RETURN) | (1L << DEFAULT) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(174); stmt();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180); match(T__13);
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

	public static class If_stmtContext extends ParserRuleContext {
		public Compound_stmtContext compound_stmt(int i) {
			return getRuleContext(Compound_stmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniGoParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(MiniGoParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Compound_stmtContext> compound_stmt() {
			return getRuleContexts(Compound_stmtContext.class);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_stmt);
		try {
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182); match(IF);
				setState(183); expr(0);
				setState(184); compound_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186); match(IF);
				setState(187); expr(0);
				setState(188); compound_stmt();
				setState(189); match(ELSE);
				setState(190); compound_stmt();
				}
				break;
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

	public static class For_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FOR() { return getToken(MiniGoParser.FOR, 0); }
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitFor_stmt(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(FOR);
			setState(195); expr(0);
			setState(196); compound_stmt();
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

	public static class Switch_stmtContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(MiniGoParser.CASE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SWITCH() { return getToken(MiniGoParser.SWITCH, 0); }
		public Switch_stmtContext switch_stmt() {
			return getRuleContext(Switch_stmtContext.class,0);
		}
		public Case_stmtContext case_stmt() {
			return getRuleContext(Case_stmtContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(MiniGoParser.DEFAULT, 0); }
		public Switch_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterSwitch_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitSwitch_stmt(this);
		}
	}

	public final Switch_stmtContext switch_stmt() throws RecognitionException {
		Switch_stmtContext _localctx = new Switch_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_switch_stmt);
		try {
			setState(212);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198); match(SWITCH);
				setState(199); expr(0);
				setState(200); match(T__18);
				setState(201); switch_stmt();
				setState(202); match(T__13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); match(CASE);
				setState(205); case_stmt();
				setState(206); switch_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(208); match(CASE);
				setState(209); case_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(210); match(DEFAULT);
				setState(211); case_stmt();
				}
				break;
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

	public static class Case_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public Case_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterCase_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitCase_stmt(this);
		}
	}

	public final Case_stmtContext case_stmt() throws RecognitionException {
		Case_stmtContext _localctx = new Case_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_case_stmt);
		try {
			int _alt;
			setState(229);
			switch (_input.LA(1)) {
			case T__15:
			case T__14:
			case T__9:
			case T__6:
			case T__3:
			case T__1:
			case FMT:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(214); expr(0);
				setState(215); match(T__19);
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(216); stmt();
						}
						} 
					}
					setState(221);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(222); match(T__19);
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(223); stmt();
						}
						} 
					}
					setState(228);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniGoParser.RETURN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_return_stmt);
		try {
			setState(239);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(231); match(RETURN);
				setState(232); expr(0);
				setState(233); match(T__2);
				setState(234); expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236); match(RETURN);
				setState(237); expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(238); match(RETURN);
				}
				break;
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

	public static class Local_declContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MiniGoParser.VAR, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(MiniGoParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public Local_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterLocal_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitLocal_decl(this);
		}
	}

	public final Local_declContext local_decl() throws RecognitionException {
		Local_declContext _localctx = new Local_declContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_local_decl);
		try {
			setState(250);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241); match(VAR);
				setState(242); match(IDENT);
				setState(243); type_spec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244); match(VAR);
				setState(245); match(IDENT);
				setState(246); match(T__17);
				setState(247); match(LITERAL);
				setState(248); match(T__11);
				setState(249); type_spec();
				}
				break;
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public TerminalNode GE() { return getToken(MiniGoParser.GE, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LITERAL(int i) {
			return getToken(MiniGoParser.LITERAL, i);
		}
		public TerminalNode LE() { return getToken(MiniGoParser.LE, 0); }
		public TerminalNode FMT() { return getToken(MiniGoParser.FMT, 0); }
		public TerminalNode OR() { return getToken(MiniGoParser.OR, 0); }
		public List<TerminalNode> LITERAL() { return getTokens(MiniGoParser.LITERAL); }
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode AND() { return getToken(MiniGoParser.AND, 0); }
		public TerminalNode EQ() { return getToken(MiniGoParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MiniGoParser.NE, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(253);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__14) | (1L << T__9) | (1L << T__3) | (1L << T__1))) != 0)) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(254); expr(7);
				}
				break;
			case 2:
				{
				setState(255); match(IDENT);
				setState(256); match(T__12);
				setState(257); expr(2);
				}
				break;
			case 3:
				{
				setState(258);
				_la = _input.LA(1);
				if ( !(_la==IDENT || _la==LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 4:
				{
				setState(259); match(T__6);
				setState(260); expr(0);
				setState(261); match(T__5);
				}
				break;
			case 5:
				{
				setState(263); match(IDENT);
				setState(264); match(T__17);
				setState(265); expr(0);
				setState(266); match(T__11);
				}
				break;
			case 6:
				{
				setState(268); match(IDENT);
				setState(269); match(T__6);
				setState(270); args();
				setState(271); match(T__5);
				}
				break;
			case 7:
				{
				setState(273); match(FMT);
				setState(274); match(T__0);
				setState(275); match(IDENT);
				setState(276); match(T__6);
				setState(277); args();
				setState(278); match(T__5);
				}
				break;
			case 8:
				{
				setState(280); match(LITERAL);
				setState(281); match(T__2);
				setState(282); match(LITERAL);
				}
				break;
			case 9:
				{
				setState(283); match(IDENT);
				setState(284); match(T__17);
				setState(285); expr(0);
				setState(286); match(T__11);
				setState(287); match(T__12);
				setState(288); expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(301);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(292);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(293);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__8) | (1L << T__4))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(294); ((ExprContext)_localctx).right = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(295);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(296);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__1) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(297); ((ExprContext)_localctx).right = expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(298);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(299);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__10) | (1L << OR) | (1L << AND) | (1L << LE) | (1L << GE) | (1L << EQ) | (1L << NE))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(300); ((ExprContext)_localctx).right = expr(5);
						}
						break;
					}
					} 
				}
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_args);
		int _la;
		try {
			setState(315);
			switch (_input.LA(1)) {
			case T__15:
			case T__14:
			case T__9:
			case T__6:
			case T__3:
			case T__1:
			case FMT:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(306); expr(0);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(307); match(T__2);
					setState(308); expr(0);
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 6);
		case 1: return precpred(_ctx, 5);
		case 2: return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0140\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\6\2*\n\2\r\2\16\2+\3\3\3\3\5\3\60\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4@\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\5\5G\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6]\n\6\3\7\3\7\3\7\3\7\7\7c\n\7\f\7\16"+
		"\7f\13\7\5\7h\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bp\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\ty\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a8\n\13\3\f\3\f\7\f\u00ac\n\f\f"+
		"\f\16\f\u00af\13\f\3\f\7\f\u00b2\n\f\f\f\16\f\u00b5\13\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c3\n\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5"+
		"\17\u00d7\n\17\3\20\3\20\3\20\7\20\u00dc\n\20\f\20\16\20\u00df\13\20\3"+
		"\20\3\20\7\20\u00e3\n\20\f\20\16\20\u00e6\13\20\5\20\u00e8\n\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f2\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00fd\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0125\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u0130\n\23\f\23\16\23\u0133\13\23\3\24\3\24\3\24\7\24"+
		"\u0138\n\24\f\24\16\24\u013b\13\24\3\24\5\24\u013e\n\24\3\24\2\3$\25\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\7\6\2\b\t\16\16\24\24\26"+
		"\26\3\2,-\5\2\3\3\17\17\23\23\4\2\24\24\26\26\5\2\7\7\r\r&+\u015c\2)\3"+
		"\2\2\2\4/\3\2\2\2\6?\3\2\2\2\bF\3\2\2\2\n\\\3\2\2\2\fg\3\2\2\2\16o\3\2"+
		"\2\2\20x\3\2\2\2\22z\3\2\2\2\24\u00a7\3\2\2\2\26\u00a9\3\2\2\2\30\u00c2"+
		"\3\2\2\2\32\u00c4\3\2\2\2\34\u00d6\3\2\2\2\36\u00e7\3\2\2\2 \u00f1\3\2"+
		"\2\2\"\u00fc\3\2\2\2$\u0124\3\2\2\2&\u013d\3\2\2\2(*\5\4\3\2)(\3\2\2\2"+
		"*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3\3\2\2\2-\60\5\6\4\2.\60\5\n\6\2/-\3"+
		"\2\2\2/.\3\2\2\2\60\5\3\2\2\2\61\62\7\31\2\2\62\63\7,\2\2\63@\5\b\5\2"+
		"\64\65\7\31\2\2\65\66\7,\2\2\66\67\7\25\2\2\678\7,\2\28@\5\b\5\29:\7\31"+
		"\2\2:;\7,\2\2;<\7\6\2\2<=\7-\2\2=>\7\f\2\2>@\5\b\5\2?\61\3\2\2\2?\64\3"+
		"\2\2\2?9\3\2\2\2@\7\3\2\2\2AG\7\36\2\2BG\7\37\2\2CG\7 \2\2DG\7\30\2\2"+
		"EG\3\2\2\2FA\3\2\2\2FB\3\2\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2G\t\3\2\2"+
		"\2HI\7\34\2\2IJ\7,\2\2JK\7\21\2\2KL\5\f\7\2LM\7\22\2\2MN\5\b\5\2NO\5\26"+
		"\f\2O]\3\2\2\2PQ\7\34\2\2QR\7,\2\2RS\7\21\2\2ST\5\f\7\2TU\7\22\2\2UV\7"+
		"\21\2\2VW\5\b\5\2WX\7\25\2\2XY\5\b\5\2YZ\7\22\2\2Z[\5\26\f\2[]\3\2\2\2"+
		"\\H\3\2\2\2\\P\3\2\2\2]\13\3\2\2\2^h\3\2\2\2_d\5\16\b\2`a\7\25\2\2ac\5"+
		"\16\b\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eh\3\2\2\2fd\3\2\2\2g^"+
		"\3\2\2\2g_\3\2\2\2h\r\3\2\2\2ij\7,\2\2jp\5\b\5\2kl\7,\2\2lm\7\6\2\2mn"+
		"\7\f\2\2np\5\b\5\2oi\3\2\2\2ok\3\2\2\2p\17\3\2\2\2qy\5\22\n\2ry\5\26\f"+
		"\2sy\5\24\13\2ty\5\30\r\2uy\5\32\16\2vy\5 \21\2wy\5\34\17\2xq\3\2\2\2"+
		"xr\3\2\2\2xs\3\2\2\2xt\3\2\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\21\3\2\2"+
		"\2z{\5$\23\2{\23\3\2\2\2|}\7\31\2\2}~\7,\2\2~\177\7\25\2\2\177\u0080\7"+
		",\2\2\u0080\u0081\5\b\5\2\u0081\u0082\7\13\2\2\u0082\u0083\7-\2\2\u0083"+
		"\u0084\7\25\2\2\u0084\u0085\7-\2\2\u0085\u00a8\3\2\2\2\u0086\u0087\7\31"+
		"\2\2\u0087\u0088\7,\2\2\u0088\u0089\5\b\5\2\u0089\u008a\7\13\2\2\u008a"+
		"\u008b\5$\23\2\u008b\u00a8\3\2\2\2\u008c\u008d\7\31\2\2\u008d\u008e\7"+
		",\2\2\u008e\u008f\5\b\5\2\u008f\u0090\7\13\2\2\u0090\u0091\7\20\2\2\u0091"+
		"\u0092\5$\23\2\u0092\u0093\7\20\2\2\u0093\u00a8\3\2\2\2\u0094\u0095\7"+
		",\2\2\u0095\u0096\5\b\5\2\u0096\u0097\7\13\2\2\u0097\u0098\5$\23\2\u0098"+
		"\u00a8\3\2\2\2\u0099\u009a\7,\2\2\u009a\u009b\5\b\5\2\u009b\u009c\7\13"+
		"\2\2\u009c\u009d\7\20\2\2\u009d\u009e\5$\23\2\u009e\u009f\7\20\2\2\u009f"+
		"\u00a8\3\2\2\2\u00a0\u00a1\7,\2\2\u00a1\u00a2\7\6\2\2\u00a2\u00a3\5$\23"+
		"\2\u00a3\u00a4\7\f\2\2\u00a4\u00a5\7\13\2\2\u00a5\u00a6\5$\23\2\u00a6"+
		"\u00a8\3\2\2\2\u00a7|\3\2\2\2\u00a7\u0086\3\2\2\2\u00a7\u008c\3\2\2\2"+
		"\u00a7\u0094\3\2\2\2\u00a7\u0099\3\2\2\2\u00a7\u00a0\3\2\2\2\u00a8\25"+
		"\3\2\2\2\u00a9\u00ad\7\5\2\2\u00aa\u00ac\5\"\22\2\u00ab\u00aa\3\2\2\2"+
		"\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b3"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\5\20\t\2\u00b1\u00b0\3\2\2\2"+
		"\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\7\n\2\2\u00b7\27\3\2\2\2\u00b8"+
		"\u00b9\7\"\2\2\u00b9\u00ba\5$\23\2\u00ba\u00bb\5\26\f\2\u00bb\u00c3\3"+
		"\2\2\2\u00bc\u00bd\7\"\2\2\u00bd\u00be\5$\23\2\u00be\u00bf\5\26\f\2\u00bf"+
		"\u00c0\7#\2\2\u00c0\u00c1\5\26\f\2\u00c1\u00c3\3\2\2\2\u00c2\u00b8\3\2"+
		"\2\2\u00c2\u00bc\3\2\2\2\u00c3\31\3\2\2\2\u00c4\u00c5\7!\2\2\u00c5\u00c6"+
		"\5$\23\2\u00c6\u00c7\5\26\f\2\u00c7\33\3\2\2\2\u00c8\u00c9\7\33\2\2\u00c9"+
		"\u00ca\5$\23\2\u00ca\u00cb\7\5\2\2\u00cb\u00cc\5\34\17\2\u00cc\u00cd\7"+
		"\n\2\2\u00cd\u00d7\3\2\2\2\u00ce\u00cf\7\32\2\2\u00cf\u00d0\5\36\20\2"+
		"\u00d0\u00d1\5\34\17\2\u00d1\u00d7\3\2\2\2\u00d2\u00d3\7\32\2\2\u00d3"+
		"\u00d7\5\36\20\2\u00d4\u00d5\7%\2\2\u00d5\u00d7\5\36\20\2\u00d6\u00c8"+
		"\3\2\2\2\u00d6\u00ce\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\35\3\2\2\2\u00d8\u00d9\5$\23\2\u00d9\u00dd\7\4\2\2\u00da\u00dc\5\20\t"+
		"\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de"+
		"\3\2\2\2\u00de\u00e8\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e4\7\4\2\2\u00e1"+
		"\u00e3\5\20\t\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3"+
		"\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00d8\3\2\2\2\u00e7\u00e0\3\2\2\2\u00e8\37\3\2\2\2\u00e9\u00ea\7$\2\2"+
		"\u00ea\u00eb\5$\23\2\u00eb\u00ec\7\25\2\2\u00ec\u00ed\5$\23\2\u00ed\u00f2"+
		"\3\2\2\2\u00ee\u00ef\7$\2\2\u00ef\u00f2\5$\23\2\u00f0\u00f2\7$\2\2\u00f1"+
		"\u00e9\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2!\3\2\2\2"+
		"\u00f3\u00f4\7\31\2\2\u00f4\u00f5\7,\2\2\u00f5\u00fd\5\b\5\2\u00f6\u00f7"+
		"\7\31\2\2\u00f7\u00f8\7,\2\2\u00f8\u00f9\7\6\2\2\u00f9\u00fa\7-\2\2\u00fa"+
		"\u00fb\7\f\2\2\u00fb\u00fd\5\b\5\2\u00fc\u00f3\3\2\2\2\u00fc\u00f6\3\2"+
		"\2\2\u00fd#\3\2\2\2\u00fe\u00ff\b\23\1\2\u00ff\u0100\t\2\2\2\u0100\u0125"+
		"\5$\23\t\u0101\u0102\7,\2\2\u0102\u0103\7\13\2\2\u0103\u0125\5$\23\4\u0104"+
		"\u0125\t\3\2\2\u0105\u0106\7\21\2\2\u0106\u0107\5$\23\2\u0107\u0108\7"+
		"\22\2\2\u0108\u0125\3\2\2\2\u0109\u010a\7,\2\2\u010a\u010b\7\6\2\2\u010b"+
		"\u010c\5$\23\2\u010c\u010d\7\f\2\2\u010d\u0125\3\2\2\2\u010e\u010f\7,"+
		"\2\2\u010f\u0110\7\21\2\2\u0110\u0111\5&\24\2\u0111\u0112\7\22\2\2\u0112"+
		"\u0125\3\2\2\2\u0113\u0114\7\35\2\2\u0114\u0115\7\27\2\2\u0115\u0116\7"+
		",\2\2\u0116\u0117\7\21\2\2\u0117\u0118\5&\24\2\u0118\u0119\7\22\2\2\u0119"+
		"\u0125\3\2\2\2\u011a\u011b\7-\2\2\u011b\u011c\7\25\2\2\u011c\u0125\7-"+
		"\2\2\u011d\u011e\7,\2\2\u011e\u011f\7\6\2\2\u011f\u0120\5$\23\2\u0120"+
		"\u0121\7\f\2\2\u0121\u0122\7\13\2\2\u0122\u0123\5$\23\2\u0123\u0125\3"+
		"\2\2\2\u0124\u00fe\3\2\2\2\u0124\u0101\3\2\2\2\u0124\u0104\3\2\2\2\u0124"+
		"\u0105\3\2\2\2\u0124\u0109\3\2\2\2\u0124\u010e\3\2\2\2\u0124\u0113\3\2"+
		"\2\2\u0124\u011a\3\2\2\2\u0124\u011d\3\2\2\2\u0125\u0131\3\2\2\2\u0126"+
		"\u0127\f\b\2\2\u0127\u0128\t\4\2\2\u0128\u0130\5$\23\t\u0129\u012a\f\7"+
		"\2\2\u012a\u012b\t\5\2\2\u012b\u0130\5$\23\b\u012c\u012d\f\6\2\2\u012d"+
		"\u012e\t\6\2\2\u012e\u0130\5$\23\7\u012f\u0126\3\2\2\2\u012f\u0129\3\2"+
		"\2\2\u012f\u012c\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132%\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0139\5$\23\2"+
		"\u0135\u0136\7\25\2\2\u0136\u0138\5$\23\2\u0137\u0135\3\2\2\2\u0138\u013b"+
		"\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013e\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u0134\3\2\2\2\u013d\u013c\3\2"+
		"\2\2\u013e\'\3\2\2\2\32+/?F\\dgox\u00a7\u00ad\u00b3\u00c2\u00d6\u00dd"+
		"\u00e4\u00e7\u00f1\u00fc\u0124\u012f\u0131\u0139\u013d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}