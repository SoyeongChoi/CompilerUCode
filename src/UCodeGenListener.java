import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

public class UCodeGenListener extends MiniGoBaseListener {
	ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
	HashMap<String, Var> symbol = new HashMap();
	HashMap<Var, String> symbolVar = new HashMap();
	HashMap<String, String> type = new HashMap();
	int localVal = 1;
	int globalVal = 1;
	int Loop = 0;

	@Override
	public void enterDecl(MiniGoParser.DeclContext ctx) {

	}

	@Override
	public void exitDecl(MiniGoParser.DeclContext ctx) {
		String decl = "";
		if (ctx.getChildCount() == 1) {
			if (ctx.var_decl() != null) // var_decl
				decl += newTexts.get(ctx.var_decl());
			else // fun_decl
				decl += newTexts.get(ctx.fun_decl());
		}
		newTexts.put(ctx, decl);

	}
	// fun_decl : FUNC IDENT '(' params ')' type_spec compound_stmt |
	// FUNC IDENT '(' params ')' '(' type_spec ',' type_spec ')' compound_stmt;

	// fun_decl : type_spec IDENT '(' params ')' compound_stmt ;
	@Override
	public void enterFun_decl(MiniGoParser.Fun_declContext ctx) {
		// 함수 이름 출력

	}

	@Override
	public void exitFun_decl(MiniGoParser.Fun_declContext ctx) {

		newTexts.put(ctx, newTexts.get(ctx.compound_stmt()));
	}

	@Override
	public void enterIf_stmt(MiniGoParser.If_stmtContext ctx) {
	}

	/*
	 * if_stmt : IF expr compound_stmt | IF expr compound_stmt ELSE
	 * compound_stmt ; (non-Javadoc)
	 * 
	 * @see MiniGoBaseListener#exitIf_stmt(MiniGoParser.If_stmtContext)
	 */
	@Override
	public void exitIf_stmt(MiniGoParser.If_stmtContext ctx) {
		String sym = "";
		String s = "";
		if (ctx.getChildCount() >= 3) {
			sym += newTexts.get(ctx.expr());
			sym += "           " + "fjp $$" + Loop + " \n";
			sym += newTexts.get(ctx.compound_stmt(0));
			if (ctx.ELSE() != null) {
				sym += "           " + "ujp $$" + (Loop + 1) + " \n";
				String elseLoop = "$$" + (Loop++);
				for (int i = 0; i < 11 - elseLoop.length(); i++)
					s += " ";
				sym += elseLoop + s + "nop \n";
				sym += newTexts.get(ctx.compound_stmt(1));
			}
			String endLoop = "$$" + (Loop++);
			s = "";
			for (int i = 0; i < 11 - endLoop.length(); i++)
				s += " ";
			sym += endLoop + s + "nop \n";
		}
		newTexts.put(ctx, sym);

	}

	@Override
	public void enterProgram(MiniGoParser.ProgramContext ctx) {

	}

	@Override
	public void exitProgram(MiniGoParser.ProgramContext ctx) {
		String fun_decl = "", var_decl = "";
		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (ctx.getChild(i).getChild(0) instanceof MiniGoParser.Fun_declContext) {
				fun_decl += newTexts.get(ctx.decl(i));
			} else {
				var_decl += newTexts.get(ctx.decl(i));
			}

		}
		var_decl += "           bgn " + (globalVal - 1) + " \n           ldp \n           call main \n           end ";
		newTexts.put(ctx, fun_decl + var_decl);
		System.out.println();
		System.out.println(newTexts.get(ctx));
		
		try {
			File newFile = new File("item2Result.txt");
			FileWriter fw = new FileWriter(newFile, true);
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));

			if (newFile.canWrite()) {
				bufferedWriter.write(newTexts.get(ctx));
			}

			bufferedWriter.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void enterExpr_stmt(MiniGoParser.Expr_stmtContext ctx) {

	}

	@Override
	public void exitExpr_stmt(MiniGoParser.Expr_stmtContext ctx) {
		String stmt = "";
		if (ctx.getChildCount() == 1) {
			stmt += newTexts.get(ctx.expr()); // expr
		}
		newTexts.put(ctx, stmt);

	}

	// compound_stmt: '{' local_decl* stmt* '}';
	@Override
	public void enterCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {
		String sym = "";
		if (ctx.getParent() instanceof MiniGoParser.Fun_declContext) {
			MiniGoParser.ParamsContext params = (MiniGoParser.ParamsContext) ctx.getParent().getChild(3);
			for (int i = 0; i < params.param().size(); i++) { // paramsCheck
				sym += "           sym 2 " + localVal + " 1 \n";
				if (params.param(i).getChildCount() == 4) {
					symbol.put(params.param(i).IDENT().getText(), new Var(1, 2, localVal));
					type.put(params.param(i).IDENT().getText(), params.param(i).type_spec().getText());

				} else {
					symbol.put(params.param(i).IDENT().getText(), new Var(0, 2, localVal));
					type.put(params.param(i).IDENT().getText(), params.param(i).type_spec().getText());
				}
				localVal++;
			}
			for (int i = 0; i < ctx.local_decl().size(); i++) {
				MiniGoParser.Local_declContext local_decl = ctx.local_decl(i);
				sym += "           sym 2 " + localVal;

				if (local_decl.getChildCount() == 6) {
					symbol.put(local_decl.IDENT().getText(), new Var(1, 2, localVal));

					sym += " " + local_decl.LITERAL().getText();
					localVal += Integer.parseInt(local_decl.LITERAL().getText());
				} else {
					symbol.put(local_decl.IDENT().getText(), new Var(0, 2, localVal));
					sym += " 1";
					type.put(local_decl.IDENT().getText(), local_decl.type_spec().getText());
					localVal++;
				}
				sym += " \n";
			}
			String proc = ctx.getParent().getChild(1).getText();
			String s = "";
			for (int i = 0; i < 11 - proc.length(); i++)
				s += " ";
			proc += s + "proc " + (localVal - 1) + " 2 2 \n";
			newTexts.put(ctx, proc + sym);
			localVal = 1;
		}

	}

	@Override
	public void exitCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {
		String com = "";

		for (int i = 0; i < ctx.stmt().size(); i++) {
			com += newTexts.get(ctx.stmt(i));
		}
		if (ctx.getParent() instanceof MiniGoParser.Fun_declContext) {
			if (ctx.getParent().getChild(0).getText().equals("func")) {
				com += "           ret \n";
			}
			// System.out.println(" end \n");
			com += "           end \n";

			newTexts.put(ctx, newTexts.get(ctx) + com);
			return;
		}
		newTexts.put(ctx, com);
	}

	@Override
	public void enterArgs(MiniGoParser.ArgsContext ctx) {
	}

	/*
	 * args : expr (',' expr) * | ; (non-Javadoc)
	 * 
	 * @see MiniGoBaseListener#exitArgs(MiniGoParser.ArgsContext)
	 */
	@Override
	public void exitArgs(MiniGoParser.ArgsContext ctx) {
		String args = "           ldp \n";
		if (ctx.getChildCount() >= 0) {
			for (int i = 0; i < ctx.expr().size(); i++) {
				System.out.println(args);
			}
		}
		newTexts.put(ctx, args);

	}

	@Override
	public void visitTerminal(TerminalNode node) {
		newTexts.put(node, node.getText());
	}

	@Override
	public void enterLocal_decl(MiniGoParser.Local_declContext ctx) {

	}

	@Override
	public void exitLocal_decl(MiniGoParser.Local_declContext ctx) {
	}

	// type_spec : INT | VOID | ;
	public void enterType_spec(MiniGoParser.Type_specContext ctx) {

	}

	@Override
	public void exitType_spec(MiniGoParser.Type_specContext ctx) {
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

	// for_stmt : FOR expr compound_stmt;
	@Override
	public void exitFor_stmt(MiniGoParser.For_stmtContext ctx) {
		String forS = "";
		String s = "";
		if (ctx.getChildCount() == 3) {
			forS += "$$" + Loop;
			for (int i = 0; i < 11 - forS.length(); i++)
				s += " ";
			forS += s + "nop \n" + newTexts.get(ctx.expr());
			forS += "           " + "fjp $$" + (Loop + 1) + " \n";
			forS += newTexts.get(ctx.compound_stmt());

			forS += "           " + "ujp $$" + (Loop++) + " \n";
			String fjpL = "$$" + (Loop++);
			s = "";
			for (int i = 0; i < 11 - fjpL.length(); i++)
				s += " ";
			forS += fjpL + s + "nop \n";
		}
		// System.out.println(stmt);
		newTexts.put(ctx, forS);

	}

	@Override
	public void enterExpr(MiniGoParser.ExprContext ctx) {
	}
	// expr_stmt : expr ;
	/*
	 * 
	 * expr : (LITERAL|IDENT) | '(' expr ')' | IDENT '[' expr ']' | IDENT '('
	 * args ')' | FMT '.' IDENT '(' args ')' | op=('-'|'+'|'--'|'++'|'!') expr |
	 * left=expr op=('*'|'/'|'%') right=expr | left=expr op=('+'|'-') right=expr
	 * | left=expr op=(EQ|NE|LE|'<'|GE|'>'|AND|OR) right=expr | LITERAL ','
	 * LITERAL | IDENT '=' expr | IDENT '[' expr ']' '=' expr;
	 */

	@Override
	public void exitExpr(MiniGoParser.ExprContext ctx) {
		String sym = "";
		if (ctx.getChildCount() > 0) {
			// (LITERAL|IDENT)
			if (ctx.getChildCount() == 1) {

				if (ctx.IDENT() != null) {
					if (symbol.get(ctx.IDENT().getText()) != null) {
						if (symbol.get(ctx.IDENT().getText()).type == 0)
							sym += "           lod " + symbol.get(ctx.IDENT().getText()).base + " "
									+ symbol.get(ctx.IDENT().getText()).offset + " \n";
						else {
							sym += "           lda " + symbol.get(ctx.IDENT().getText()).base + " "
									+ symbol.get(ctx.IDENT().getText()).offset + " \n";

						}
					}
				} else {
					if (ctx.LITERAL(0) != null) {
						sym += "           ldc " + newTexts.get(ctx.LITERAL(0)) + " \n";
					}
				}
			}
			// op=('-'|'+'|'--'|'++'|'!') expr
			else if (ctx.getChildCount() == 2) {
				if (newTexts.get(ctx.expr(0)) != null) {
					if (!type.get(ctx.expr(0).getText()).equals("string")) {
						sym += newTexts.get(ctx.expr(0));
					}
				}
				if (!type.get(ctx.getChild(1).getText()).equals("string")) {
					if (ctx.getChild(0).getText().equals("-")) {
						sym += "           neg \n";
					} else if (ctx.getChild(0).getText().equals("--")) {
						sym += "           dec \n";
					} else if (ctx.getChild(0).getText().equals("++")) {
						sym += "           inc \n";
					} else if (ctx.getChild(0).getText().equals("!")) {
						sym += "           notop \n";
					}
				} else {
					sym += "           [String does not calculate] \n";
				}
					
				if (ctx.expr(0).getText() != null) {
					sym += "           str " + symbol.get(ctx.expr(0).getText()).base + " "
							+ symbol.get(ctx.expr(0).getText()).offset + " \n";
				}

			} else if (ctx.getChildCount() == 3) {
				// '(' expr ')'
				if (ctx.getChild(0).getText().equals("(")) {
					sym += newTexts.get(ctx.expr(0));
				}
				// IDENT '=' expr
				else if (ctx.getChild(1).getText().equals("=")) {
					if (!(ctx.getParent() instanceof MiniGoParser.Assign_stmtContext)) {
						sym += newTexts.get(ctx.expr().get(0));
						sym += "           str " + symbol.get(ctx.IDENT().getText()).base + " "
								+ symbol.get(ctx.IDENT().getText()).offset + " \n";
					}
				}
				// left=expr op=('*'|'/'|'%') right=expr
				// left=expr op=('+'|'-') right=expr
				// left=expr op=(EQ|NE|LE|'<'|GE|'>'|AND|OR) right=expr
				else {

					// System.out.println(type.get(ctx.expr(0).getText()));

					if (type.get(ctx.expr(1).getText()) != null) {
						if (type.get(ctx.expr(0).getText()) != null) {
							if (type.get(ctx.expr(0).getText()).equals(type.get(ctx.expr(1).getText()))) {
								sym += newTexts.get(ctx.expr(0));
								sym += newTexts.get(ctx.expr(1));

								sym += "           ";
								switch (ctx.getChild(1).getText()) {
								case "*":
									sym += "mult \n";
									break;
								case "/":
									sym += "div \n";
									break;
								case "%":
									sym += "mod \n";
									break;
								case "+":
									sym += "add \n";
									break;
								case "-":
									sym += "sub \n";
									break;
								case "==":
									sym += "eq \n";
									break;
								case "!=":
									sym += "ne \n";
									break;
								case "<=":
									sym += "le \n";
									break;
								case "<":
									sym += "lt \n";
									break;
								case ">=":
									sym += "ge \n";
									break;
								case ">":
									sym += "gt \n";
									break;
								case "and":
									sym += "and \n";
									break;
								case "or":
									sym += "or \n";
									break;
								}
							} else {
								sym += "[type mismatch] \n";
							}
						} else {
							sym += newTexts.get(ctx.expr(0));
							sym += newTexts.get(ctx.expr(1));
							sym += "           ";
							switch (ctx.getChild(1).getText()) {
							case "*":
								sym += "mult \n";
								break;
							case "/":
								sym += "div \n";
								break;
							case "%":
								sym += "mod \n";
								break;
							case "+":
								sym += "add \n";
								break;
							case "-":
								sym += "sub \n";
								break;
							case "==":
								sym += "eq \n";
								break;
							case "!=":
								sym += "ne \n";
								break;
							case "<=":
								sym += "le \n";
								break;
							case "<":
								sym += "lt \n";
								break;
							case ">=":
								sym += "ge \n";
								break;
							case ">":
								sym += "gt \n";
								break;
							case "and":
								sym += "and \n";
								break;
							case "or":
								sym += "or \n";
								break;
							}
						}

					} else {

						sym += newTexts.get(ctx.expr(0));

						sym += newTexts.get(ctx.expr(1));
						sym += "           ";
						switch (ctx.getChild(1).getText()) {
						case "*":
							sym += "mult \n";
							break;
						case "/":
							sym += "div \n";
							break;
						case "%":
							sym += "mod \n";
							break;
						case "+":
							sym += "add \n";
							break;
						case "-":
							sym += "sub \n";
							break;
						case "==":
							sym += "eq \n";
							break;
						case "!=":
							sym += "ne \n";
							break;
						case "<=":
							sym += "le \n";
							break;
						case "<":
							sym += "lt \n";
							break;
						case ">=":
							sym += "ge \n";
							break;
						case ">":
							sym += "gt \n";
							break;
						case "and":
							sym += "and \n";
							break;
						case "or":
							sym += "or \n";
							break;
						}
					}

				}
			}
			// IDENT '(' args ')' | IDENT '[' expr ']'
			else if (ctx.getChildCount() == 4) {
				if (ctx.args() != null) // args
				{
					sym += newTexts.get(ctx.args());
					sym += "           call " + ctx.IDENT().getText() + " \n";
				} else // expr
				{
					sym += newTexts.get(ctx.expr(0));
					sym += "           lda " + symbol.get(ctx.IDENT().getText()).base + " "
							+ symbol.get(ctx.IDENT().getText()).offset + " \n";
					sym += "           add \n           ldi \n";
				}
			}
			// IDENT '[' expr ']' '=' expr
			else if (ctx.getChildCount() == 6) {
				sym += newTexts.get(ctx.getChild(0));
				sym += "           lda " + symbol.get(ctx.IDENT().getText()).base + " "
						+ symbol.get(ctx.IDENT().getText()).offset + " \n";
				sym += "           add \n";
				sym += newTexts.get(ctx.getChild(1));
				sym += "           sti \n";
			}
			newTexts.put(ctx, sym);
		}

	}

	@Override
	public void enterVar_decl(MiniGoParser.Var_declContext ctx) {
		// 전역변수 출력하는 곳
		String sym = "";
		if (ctx.getChildCount() >= 3) {
			sym += "           sym 1" + globalVal;
			if (ctx.getChildCount() == 6) {
				symbol.put(ctx.IDENT().toString(), new Var(1, 1, globalVal));
				sym += " " + ctx.LITERAL().getText();
				globalVal = Integer.valueOf(ctx.LITERAL().getText());

			} else {
				symbol.put(ctx.IDENT().toString(), new Var(0, 1, globalVal));
				sym += " 1";
				if (ctx.getChildCount() == 5) {
					globalVal++;
					symbol.put(ctx.IDENT().toString(), new Var(0, 1, globalVal));
					type.put(ctx.IDENT().toString(), ctx.type_spec().getText());
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
		String stmt = "";
		if (ctx.getChildCount() > 0) {
			if (ctx.expr_stmt() != null) // expr_stmt
				stmt += newTexts.get(ctx.expr_stmt());
			else if (ctx.compound_stmt() != null) // compound_stmt
				stmt += newTexts.get(ctx.compound_stmt());
			else if (ctx.assign_stmt() != null) // assign_stmt
				stmt += newTexts.get(ctx.assign_stmt());
			else if (ctx.if_stmt() != null) // if_stmt
				stmt += newTexts.get(ctx.if_stmt());
			else if (ctx.for_stmt() != null) // for_stmt
				stmt += newTexts.get(ctx.for_stmt());
			else if (ctx.return_stmt() != null)// return_stmt
				stmt += newTexts.get(ctx.return_stmt());
			else if (ctx.switch_stmt() != null) {
				stmt += newTexts.get(ctx.switch_stmt());
			}
		}
		newTexts.put(ctx, stmt);

	}

	@Override
	public void enterSwitch_stmt(MiniGoParser.Switch_stmtContext ctx) {

	}

	@Override
	public void exitSwitch_stmt(MiniGoParser.Switch_stmtContext ctx) {

		/*
		 * String sym = ""; String s = "";
		 * if(type.containsKey(ctx.getChild(1).getText())){
		 * System.out.println("??"+symbolVar.get(symbol.get(ctx.getChild(1).
		 * getText()))); } if(ctx.case_stmt()!=null){
		 * 
		 * if(ctx.case_stmt().getChildCount() == 3){ // case문 //
		 * System.out.println("aaa"+ctx.case_stmt().stmt().expr_stmt().getText()
		 * );
		 * System.out.println("AAA"+newTexts.get(ctx.case_stmt().getChild(1)));/
		 * / System.out.println("EEE"+ctx.case_stmt().getChild(4).getText());
		 * }else if(ctx.case_stmt().getChildCount() == 2){//default문
		 * System.out.println("aaa"+ctx.case_stmt().getText());
		 * System.out.println("AAA"+newTexts.get(ctx.case_stmt().getChild(2)));/
		 * /
		 * 
		 * System.out.println("EEE"+ctx.case_stmt().getChild(4).getText()); }
		 * sym += newTexts.get(ctx.expr()); sym += "           " + "fjp $$" +
		 * Loop + " \n"; // sym += newTexts.get(ctx.case_stmt().expr(0));
		 * System.out.println("!!!!"+sym); 
		 */
		/*
		 * String endLoop = "$$" + (Loop++); s = ""; for (int i = 0; i < 11 -
		 * endLoop.length(); i++) s += " "; sym += endLoop + s + "nop \n"; } if
		 * (ctx.getChildCount() >= 3) {
		 * 
		 * } newTexts.put(ctx, sym);
		 */


	}

	@Override
	public void enterAssign_stmt(MiniGoParser.Assign_stmtContext ctx) {

		String sym = "";
		/*
		 * VAR IDENT ',' IDENT type_spec '=' LITERAL ',' LITERAL | VAR IDENT
		 * type_spec '=' expr | IDENT type_spec '=' expr | IDENT '[' expr ']'
		 * '=' expr ;
		 */
		if (ctx.getChildCount() > 4) {

			if (ctx.getChildCount() == 5) {
				sym += "           sym 2 " + localVal;
				String temp = ctx.IDENT(0).getText();
				symbol.put(ctx.IDENT().get(0).getText(), new Var(0, 2, localVal));
				localVal++;
				sym += " 1";
				// String temp2 = ctx.expr(0).getText();
				if (ctx.type_spec().getText().equals("int")) {
					if (ctx.expr(0).getText().contains(".")) {

						sym += "\n           [type Error]";
						symbol.remove(ctx.IDENT().get(0).getText(), new Var(0, 2, localVal));
						localVal--;
					} else if ((int) ctx.expr(0).getText().charAt(0) >= 65) {
						sym += "\n           [expr Error]";
						symbol.remove(ctx.IDENT().get(0).getText(), new Var(0, 2, localVal));
						localVal--;
					} else {
						sym += "\n           ldc " + ctx.expr(0).getText() + " \n";
						sym += "           str " + symbol.get(ctx.IDENT().get(0).getText()).base + " "
								+ symbol.get(ctx.IDENT().get(0).getText()).offset + "";
						type.put(ctx.IDENT().get(0).getText(), ctx.type_spec().getText());
						symbolVar.put(symbol.get(ctx.IDENT().get(0).getText()), ctx.expr(0).getText());
					}
				} else if (ctx.type_spec().getText().equals("string")) {
					sym += "\n[type Error]";
					symbol.remove(ctx.IDENT().get(0).getText(), new Var(0, 2, localVal));
					localVal--;
				} else if (ctx.type_spec().getText().equals("float")) {
					if (!ctx.expr(0).getText().contains(".")) {

						sym += "\n           [type Error]";
						symbol.remove(ctx.IDENT().get(0).getText(), new Var(0, 2, localVal));
						localVal--;
					} else if ((int) ctx.expr(0).getText().charAt(0) >= 65) {
						sym += "\n           [expr Error]";
						symbol.remove(ctx.IDENT().get(0).getText(), new Var(0, 2, localVal));
						localVal--;
					} else {
						sym += "\n           ldc " + ctx.expr(0).getText() + " \n";
						sym += "           str " + symbol.get(ctx.IDENT().get(0).getText()).base + " "
								+ symbol.get(ctx.IDENT().get(0).getText()).offset + "";
						type.put(ctx.IDENT().get(0).getText(), ctx.type_spec().getText());
						symbolVar.put(symbol.get(ctx.IDENT().get(0).getText()), ctx.expr(0).getText());
					}
				}
			} else if (ctx.getChildCount() == 9) {
				localVal++;
				sym += "           sym 2 " + localVal;
				// symbol.put(ctx.IDENT().toString(), new Var(1, 1, globalVal));
				// sym += " " + ctx.LITERAL().getText();
				// globalVal = Integer.valueOf(ctx.LITERAL().getText());
				symbol.put(ctx.IDENT(0).getText(), new Var(0, 2, localVal));
				sym += " " + ctx.LITERAL(0).getText();

				symbolVar.put(symbol.get(ctx.IDENT(0).getText()), ctx.LITERAL(0).getText());
				localVal++;
				symbol.put(ctx.IDENT(1).toString(), new Var(0, 2, localVal));

				symbolVar.put(symbol.get(ctx.IDENT(0).getText()), ctx.LITERAL(1).getText());
				sym += " " + ctx.LITERAL(1).getText();
				localVal++;
			} else if (ctx.getChildCount() == 7) {
				sym += "           sym 2 " + localVal;
				String temp = ctx.IDENT(0).getText();
				symbol.put(ctx.IDENT().get(0).getText(), new Var(0, 2, localVal));
				localVal++;
				sym += " 1";
				// String temp2 = ctx.expr(0).getText();

				type.put(ctx.IDENT().get(0).getText(), ctx.type_spec().getText());
				sym += "\n           ldc " + ctx.expr(0).getText() + " \n";
				sym += "           str " + symbol.get(ctx.IDENT().get(0).getText()).base + " "
						+ symbol.get(ctx.IDENT().get(0).getText()).offset + "";

				symbolVar.put(symbol.get(ctx.IDENT().get(0).getText()), ctx.expr(0).getText());
			}

			sym += " \n";
		}

		else {

			if (ctx.getChildCount() == 6) {
				sym += newTexts.get(ctx.getChild(0));
				sym += "           lda " + symbol.get(ctx.IDENT(0).getText()).base + " "
						+ symbol.get(ctx.IDENT(0).getText()).offset + " \n";
				sym += "           add \n";
				sym += newTexts.get(ctx.getChild(1));
				sym += "           sti \n";
				localVal += Integer.valueOf(ctx.expr(0).getText());
				sym += " \n";
			} else if(ctx.getChildCount() == 4){
				sym += newTexts.get(ctx.getChild(0));
				sym += "           lda " + symbol.get(ctx.IDENT(0).getText()).base + " "
						+ symbol.get(ctx.IDENT(0).getText()).offset + " \n";
				// sym += newTexts.get(ctx.expr(0));
				// sym += " str " + symbol.get(ctx.IDENT(0).getText()).base + "
				// "
				// + symbol.get(ctx.IDENT().getText()).offset + " \n";

				sym += " \n";
				localVal++;
			}
		}

		newTexts.put(ctx, sym);

	}

	@Override
	public void exitAssign_stmt(MiniGoParser.Assign_stmtContext ctx) {

	}

	@Override
	public void enterReturn_stmt(MiniGoParser.Return_stmtContext ctx) {

	}

	@Override
	public void exitReturn_stmt(MiniGoParser.Return_stmtContext ctx) {
		String stmt = "";
		if (ctx.getChildCount() == 1) {
			stmt += "           ret \n";
		}
		if (ctx.getChildCount() == 2) {
			stmt += newTexts.get(ctx.expr(1));
			stmt += "           retv \n";
		} else {
			if (ctx.getChildCount() == 4) {
				stmt += newTexts.get(ctx.expr(1));
				stmt += "           retv \n";
				stmt += newTexts.get(ctx.expr(3));
				stmt += "           retv \n";
			}
		}
		newTexts.put(ctx, stmt);

	}

	public class Var {
		int type;
		int base;
		int offset;

		public Var(int type, int base, int offset) {
			this.type = type;
			this.base = base;
			this.offset = offset;
		}

	}

}
