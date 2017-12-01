grammar Datalog;


/********************************************************
 * Productions
 ********************************************************/
datalogProgram:	  ruleList factList;


aRule:	headPredicate COLON_DASH predicate predicateList PERIOD;


ruleList:	aRule ruleList | lambda	;


idList:	COMMA ID idList | lambda;


headPredicate:	STRING LEFT_PAREN ID idList RIGHT_PAREN;

	
builtInPredicate:	parameter operator parameter;


	
predicate:	builtInPredicate | STRING LEFT_PAREN parameter parameterList RIGHT_PAREN;

	
predicateList:	COMMA predicate predicateList | lambda;




	
parameter:	STRING | ID;

	
parameterList:	COMMA parameter parameterList | lambda;

	
operator:	EQUAL | NONEQUAL | GREATER | LESS | GREATERSTRICT | LESSSTRICT;


query:      Q_MARK COLON_DASH predicate;


queryList:	query queryList | lambda;

fact:	STRING LEFT_PAREN STRING stringList RIGHT_PAREN PERIOD;


factList:	fact factList | lambda;


stringList:	COMMA STRING stringList | lambda ;

lambda	:	;


/********************************************************
 * Token definitions from the lexer project
 * IGNORE: INCLUDED FOR COMPLETENESS FOR ANTLR
 ********************************************************/
 
 
 STRING  :   ('a'..'z'|'0'..'9')('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'.')*|'\''('a'..'z'|'0'..'9'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*'\''
	;


COMMA	:	','
	;

PERIOD	:	'.';

Q_MARK	:	'?'
	;

LEFT_PAREN	: '('
		;

RIGHT_PAREN	: ')';




COLON		: ':'
		;

COLON_DASH	: ':-'
		;

EQUAL	: '='
		;

NONEQUAL	: '<>'
		;

GREATER	: '>'
		;

GREATERSTRICT	: '>='
		;

LESS	: '<'
		;

LESSSTRICT	: '<='
		;

FACTS		: 'Facts'
		;
RULES		: 'Rules'
		;
/*QUERIES		: 'Queries'
		;*/
     

ID  :	('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*
    ;

COMMENT
    :   ('%' ~('\n'|'\r')* '\r'? '\n'
    |   '%|' .*? '|#') -> skip
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) -> skip
    ;

