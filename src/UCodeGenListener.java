import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

public class UCodeGenListener extends MiniGoBaseListener {
	int localVal = 0;
	int globalVal = 0;

	@Override
	public void enterDecl(MiniGoParser.DeclContext ctx) {
		//git test
		
	}

	@Override
	public void exitDecl(MiniGoParser.DeclContext ctx) {
	}

	@Override
	public void enterFun_decl(MiniGoParser.Fun_declContext ctx) {
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
		System.out.println(ctx.getChild(0).toString());
		
	}

	@Override
	public void exitProgram(MiniGoParser.ProgramContext ctx) {
		System.out.println("\tldp");
		System.out.println("\tcall main");
		System.out.println("\tend");
		

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

	
	@Override
	public void enterCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {
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
		localVal++;
		System.out.println(localVal);
	}

	@Override
	public void exitLocal_decl(MiniGoParser.Local_declContext ctx) {
	}

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

	@Override
	public void enterVar_decl(MiniGoParser.Var_declContext ctx) {
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

}
