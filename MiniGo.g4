grammar MiniGo;
program       : decl+    ; 
decl      : var_decl
         | fun_decl ;
var_decl   : VAR IDENT type_spec
         | VAR IDENT ',' IDENT type_spec
         | VAR IDENT '[' LITERAL ']' type_spec ;
type_spec  : INT 
		 | STRING
		 | FLOAT
         | VOID 
         | ; 
fun_decl   : FUNC IDENT '(' params ')' type_spec compound_stmt  
         | FUNC IDENT '(' params ')' '(' type_spec ',' type_spec ')' compound_stmt;
params    :  
         | param(',' param)* ;
param     : IDENT type_spec 
         | IDENT '[' ']' type_spec ;
stmt      : expr_stmt
         | compound_stmt
         | assign_stmt
         | if_stmt
         | for_stmt
         | return_stmt
         | switch_stmt;
expr_stmt  : expr ;
assign_stmt : VAR IDENT ',' IDENT type_spec '=' LITERAL ',' LITERAL
         | VAR IDENT type_spec '=' expr
         | VAR IDENT type_spec '=' '\"' expr '\"'
         | IDENT type_spec '=' expr
         | IDENT type_spec '=' '\"' expr '\"'
         | IDENT '[' expr ']' '=' expr ;
compound_stmt: '{' local_decl* stmt* '}';
if_stmt       : IF expr compound_stmt
         | IF expr compound_stmt ELSE compound_stmt ;
for_stmt    : FOR expr compound_stmt;
switch_stmt   : SWITCH expr '{' switch_stmt '}'
			| CASE case_stmt switch_stmt
			| CASE case_stmt
			| DEFAULT case_stmt ;
case_stmt    : expr ':' stmt*
			 | ':' stmt* ;
return_stmt    : RETURN expr ',' expr
         | RETURN expr
         | RETURN ;
local_decl : VAR IDENT type_spec
             | VAR IDENT '[' LITERAL ']' type_spec;
expr      : (LITERAL|IDENT)
         | '(' expr ')' 
         | IDENT '[' expr ']' 
         | IDENT '(' args ')' 
         | FMT '.' IDENT '(' args ')' 
         | op=('-'|'+'|'--'|'++'|'!') expr 
         | left=expr op=('*'|'/'|'%') right=expr 
         | left=expr op=('+'|'-') right=expr 
         | left=expr op=(EQ|NE|LE|'<'|GE|'>'|AND|OR) right=expr
         | LITERAL ',' LITERAL
         | IDENT '=' expr
         | IDENT '[' expr ']' '=' expr;
args      : expr (',' expr) * 
         | ;
         
VOID      : 'void'     ;
VAR          : 'var'   ;
CASE      : 'case'    ;
SWITCH       : 'switch'    ;
FUNC      : 'func'  ;
FMT          : 'fmt'      ;
INT          : 'int'   ;
STRING      : 'string'	;
FLOAT      : 'float'	;
FOR          : 'for'   ;
IF       : 'if'    ;
ELSE      : 'else'  ;
RETURN    : 'return';
DEFAULT   : 'default';
OR       : 'or'    ;
AND          : 'and'   ;
LE       : '<='    ;
GE       : '>='    ;
EQ       : '=='    ;
NE       : '!='    ;

IDENT     : [a-zA-Z_] 
         ( [a-zA-Z_]
         | [0-9]
         )*;
         
LITERAL       : DecimalConstant | OctalConstant | HexadecimalConstant | StringConstant;

DecimalConstant    : '0' | [1-9] [0-9]* |[1-9] [0-9]* '.' [0-9]+ | '0.' [0-9]+;
OctalConstant  : '0' [0-7]* ;
HexadecimalConstant    : '0' [xX] [0-9a-fA-F]+ ;
StringConstant : [a-z][a-z]*[A-Z]* | [A-Z][a-z]*[A-Z]* | [A-Z][A-Z]*[a-z]* | [a-z][A-Z]*[a-z]*;
WS       : (' '
         | '\t'
         | '\r'
         | '\n'        
         )+
   -> channel(HIDDEN)  
    ;