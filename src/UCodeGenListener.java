import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;
public class UCodeGenListener extends MiniGoBaseListener {
	ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
	HashMap<String, Var> symbol = new HashMap(); 
	int tab = 0;
	int localVal = 1;
	int globalVal = 1;

	@Override
	public void enterDecl(MiniGoParser.DeclContext ctx) {
			
	
	}

	@Override
	public void exitDecl(MiniGoParser.DeclContext ctx) {
	}
//	fun_decl   : FUNC IDENT '(' params ')' type_spec compound_stmt      | FUNC IDENT '(' params ')' '(' type_spec ',' type_spec ')' compound_stmt;
	@Override
	public void enterFun_decl(MiniGoParser.Fun_declContext ctx) {
	//함수 이름 출력

		
		

	}

	@Override
	public void exitFun_decl(MiniGoParser.Fun_declContext ctx) {
	}

	@Override
	public void enterIf_stmt(MiniGoParser.If_stmtContext ctx) {
	}

	@Override
	public void exitIf_stmt(MiniGoParser.If_stmtContext ctx) {
	}

	@Override
	public void enterProgram(MiniGoParser.ProgramContext ctx) {
		System.out.println();
	}

	@Override
	public void exitProgram(MiniGoParser.ProgramContext ctx) {
	//	System.out.println("\tldp");
	//	System.out.println("\tcall main");
	//	System.out.println("\tend");
		

		//처음에는 print문으로 진행하고 다하고나서는 newText같은 Buffer에 추가해주고
		//여기서 파일 write해주면 될 것 같음.
	}

	@Override
	public void enterExpr_stmt(MiniGoParser.Expr_stmtContext ctx) {
		
	
	}

	@Override
	public void exitExpr_stmt(MiniGoParser.Expr_stmtContext ctx) {
		// System.out.println();
	}

	//compound_stmt: '{' local_decl* stmt* '}';
	@Override
	public void enterCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {
		String stmt = "";
		for(int i = 0; i < ctx.stmt().size(); i++)
			stmt += newTexts.get(ctx.stmt(i));
		if(ctx.getParent() instanceof MiniGoParser.Fun_declContext) {
			if (ctx.getParent().getChild(0).getText().equals("func")){				
				stmt += "           ret \n";
				System.out.println("\tret \n");
			}
			System.out.println("\tend \n");
			stmt += "           end \n";
			
			newTexts.put(ctx, newTexts.get(ctx) + stmt);
			return;
		}
		newTexts.put(ctx, stmt);

	
	}

	@Override
	public void exitCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {
	}

	@Override
	public void enterArgs(MiniGoParser.ArgsContext ctx) {
	}

	@Override
	public void exitArgs(MiniGoParser.ArgsContext ctx) {

	}

	@Override
	public void enterLocal_decl(MiniGoParser.Local_declContext ctx) {
		
	}

	@Override
	public void exitLocal_decl(MiniGoParser.Local_declContext ctx) {
	}
//	type_spec  : INT     | VOID     | ; 
	public void enterType_spec(MiniGoParser.Type_specContext ctx) {
		
	}

	@Override
	public void exitType_spec(MiniGoParser.Type_specContext ctx) {
	}

	@Override
	public void enterParam(MiniGoParser.ParamContext ctx) {
		// 파라미터 들어가는기능
		
		System.out.println();
	}

	@Override
	public void exitParam(MiniGoParser.ParamContext ctx) {

	}

	@Override
	public void enterParams(MiniGoParser.ParamsContext ctx) {// param이 들어올 때
	}

	@Override
	public void exitParams(MiniGoParser.ParamsContext ctx) {
		

	}

	@Override
	public void enterFor_stmt(MiniGoParser.For_stmtContext ctx) {
		System.out.println(ctx.getChild(0));
	}

	@Override
	public void exitFor_stmt(MiniGoParser.For_stmtContext ctx) {
	}

	@Override
	public void enterExpr(MiniGoParser.ExprContext ctx) {
	}

	@Override
	public void exitExpr(MiniGoParser.ExprContext ctx) {

	}
//var_decl   : VAR IDENT type_spec | VAR IDENT ',' IDENT type_spec | VAR IDENT '[' LITERAL ']' type_spec ;
	@Override
	public void enterVar_decl(MiniGoParser.Var_declContext ctx) {
		//전역변수 출력하는 곳
		String sym = "";
		if(ctx.getChildCount()>= 3){
			sym +="\tsym1"+globalVal;
			if(ctx.getChildCount() == 6){
				symbol.put(ctx.IDENT().toString(), new Var(1,1,globalVal));
				sym += " "+ctx.LITERAL().getText();
				globalVal = Integer.valueOf(ctx.LITERAL().getText());
			}else{
				symbol.put(ctx.IDENT(1).getText(), new Var(0,1,globalVal));
				sym += " 1";
				if(ctx.getChildCount() == 5){
					globalVal++;
					symbol.put(ctx.IDENT(3).getText(), new Var(0,1,globalVal));
				}
				globalVal++;				
			}
			sym += " \n";
		}
		newTexts.put(ctx, sym);
	}

	@Override
	public void exitVar_decl(MiniGoParser.Var_declContext ctx) {
	}

	@Override
	public void enterStmt(MiniGoParser.StmtContext ctx) {

	}

	@Override
	public void exitStmt(MiniGoParser.StmtContext ctx) {

	}

	@Override
	public void enterReturn_stmt(MiniGoParser.Return_stmtContext ctx) {

	}

	@Override
	public void exitReturn_stmt(MiniGoParser.Return_stmtContext ctx) {
		System.out.println();
	}
	public class Var{
		int type;
		int base;
		int offset;
		
		public Var(int type,int base, int offset){
			this.type = type;
			this.base = base;
			this.offset = offset;
		}
		
	}

}
