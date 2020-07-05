grammar MCFunction ;    //定义规则文件grammar
/*
*========================
*   一些 options 配置
*=======================
*/
options {
    language = Java; //设定生成代码的语言
}
mcfunction: header instructions;
instructions: ((command NEW_LINE|functionCall NEW_LINE|ifStatement NEW_LINE|NEW_LINE))+;
functionCall : (STRS BRACE (realPar) BACKBRACE);
command : ( STRS | TARGET_SELECETOR| ARRAY | COMPOUND|CHARS|' '|NUM)+;
ifStatement: 'if' ifCondition NEW_LINE? BRACKET NEW_LINE? ( command NEW_LINE| functionCall NEW_LINE | ifStatement NEW_LINE)* NEW_LINE? BACKBRACKET;
ifCondition: BRACE (('&&')?((' ')*)(('!')?command))+ BACKBRACE NEW_LINE?;
realPar: (par','|par)*;
par:((NUM | TARGET_SELECETOR |CHARS | ARRAY | COMPOUND));
header: ((include|tick|load) NEW_LINE)*;
include : '@include ' (STRS|'\\')+ ;
tick : '@tick';
load : '@load';
NUM : ([0-9]('.'[0-9]+)?([lLdDfFbBsS])?)+;
BRACKET:'{';
BACKBRACKET:'}';
BRACE:'(';
BACKBRACE:')';
TARGET_SELECETOR: '@'('a'|'e'|'p'|'s') CONDITION?;
CONDITION:'[' STRS']';
CHARS: '"' ((STR|','|']'|'['|'{'|'}'|')'|'(')|' '|'#'|'@'|'*'|'\\"'|'&'|'!')* '"';
TAG : (CHARS':' (NUM|CHARS|ARRAY|COMPOUND)(',')?);
COMPOUND: '{' ((TAG|ARRAY) +)? '}';
ARRAY:  '[' ((COMPOUND|NUM)(',')?)+ ']';
STRS: STR+;
STR : (('\u4E00'..'\u9FA5' | '\uF900'..'\uFA2D')|[a-zA-Z0-9|'_:.&?<>+=~%^$]) ;
NEW_LINE:'\n';
SIMPLE_COMMENT: ' '*'#' ((~('\n'|'\r'))|' ')* ->skip;
WS: [ \t\r]+ -> skip ;