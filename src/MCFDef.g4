grammar MCFDef ;    //定义规则文件grammar
/*
*========================
*   一些 options 配置
*=======================
*/
options {
    language = Java; //设定生成代码的语言
}
/**
 =========================
   rule
 =========================
*/
mcfDef :header NEW_LINE* (method)+ ;
method : methodName BRACE (parameters)* BACKBRACE NEW_LINE? (' ')* NEW_LINE? BRACKET NEW_LINE? instructions BACKBRACKET NEW_LINE* ;
methodName : (STRS|' ')+ ;
parameters:((',')?(parameter))+;
parameter: STRS;
instructions : ((NEW_LINE|SIMPLE_COMMENT) command|ifStatement|((NEW_LINE|SIMPLE_COMMENT) functionCall)|NEW_LINE|' ')+;
functionCall: STRS BRACE (realPar) BACKBRACE ;
command : STRS( STRS|' ' | TARGET_SELECETOR| ARRAY | COMPOUND|CHARS | NUM |REFER)* ;
ifStatement: 'if'  ifCondition BRACKET ( ((NEW_LINE|SIMPLE_COMMENT) command|((NEW_LINE|SIMPLE_COMMENT) functionCall)|ifStatement|NEW_LINE) )* NEW_LINE? BACKBRACKET;
ifCondition: BRACE (('&&')?((' ')*)(('!')?command))+ BACKBRACE NEW_LINE?;
par:((NUM | TARGET_SELECETOR| REFER |CHARS | ARRAY | COMPOUND));
realPar: (','par|par)*;
header: (include|global )*;
include : '@include ' (STRS|'\\')+ NEW_LINE?;
global: '@global';
BRACKET:'{';
BACKBRACKET:'}';
BRACE:'(';
BACKBRACE:')';
CHARS: '"' ((STR|' '|','|']'|'['|'{'|'}'|')'|'(')|' '|'#'|'@'|'*'|'\\"'|'&'|'!')* '"';
TARGET_SELECETOR: '@'('a'|'e'|'p'|'s') CONDITION?;
CONDITION:'[' STRS']';
REFER : '&' + STRS;
TAG : (CHARS':' (NUM|CHARS|ARRAY|COMPOUND)(',')?);
NUM : ([0-9]('.'[0-9]+)?([lLdDfFbBsS])?)+;
COMPOUND: '{' ((TAG|ARRAY) +)? '}';
ARRAY:  '[' ((COMPOUND|NUM|CHARS)(',')?)+ ']';
STRS: STR+;
STR : (('\u4E00'..'\u9FA5' | '\uF900'..'\uFA2D' | '/' | '\\')|[a-zA-Z0-9|'_:.?<>+=~%^$]) ;
NEW_LINE:'\n';
SIMPLE_COMMENT: ' '*'#' ((~('\n'|'\r'))|' ')* ->skip ;
WS:[ \t\r]+ -> skip ;