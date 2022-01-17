grammar PseInt;

s: subprocess* process EOF;

according: SEGUN expression HACER accordingBody FIN_SEGUN;
accordingBody: accordingCase* accordingDefault?;
accordingCase: CASO expressionList ':' action*;
accordingDefault: DE OTRO MODO ':' action*;

action: according | asig | cmd | def | for | (functionCall ';') | (ID ';') | if | repeat | setArrayDim | while;

arrayDimensions: '[' expressionList ']';

asig: idSetter '<-' expression ';';

binaryOp: '+' | '-' | '/' | '*' | '^' | '%' | MOD | booleanBinaryOp;
booleanBinaryOp: '=' | '<>' | '<' | '<=' | '>' | '>=' | '&' | Y | '|' | O;
booleanUnaryOp: '~' | NO;

cmd: cmdClean | cmdRead | cmdWait | cmdWrite ;
cmdClean: (LIMPIAR | BORRAR) PANTALLA ';';
cmdRead: LEER ID arrayDimensions? (',' ID arrayDimensions?)* ';';
cmdWait: ESPERAR cmdWaitOptions  ';';
cmdWaitOptions: TECLA | (expression timeUnits)  ';';
cmdWrite: ESCRIBIR expressionList ';';

def: DEFINIR idList COMO defType ';';
defType: NUMERICO | ENTERO | CARACTER | REAL | TEXTO | CADENA | NUMERO | LOGICO;

else: SINO action*;

expression: ((value) | (unaryOp expression) | ('(' expression ')')) expressionOp;
expressionOp: (binaryOp expression)?;

expressionList: expression (',' expression)*;

for: PARA forComplement1;
forComplement1: ID '<-' expression forComplement2;
forComplement2: HASTA expression forComplement3;
forComplement3: (CON PASO expression)? forComplement4;
forComplement4: HACER action* FINPARA;

functionCall: ID (functionCallPar | functionCallCor);
functionCallCor: '[' expressionList? ']';
functionCallPar: '(' expressionList? ')';

idList: ID (',' ID)*;
idGetter: (ID arrayDimensions) | functionCall | ID;
idSetter: (ID arrayDimensions) | ID;

if: SI expression ENTONCES action* else? FINSI;

process: processOpen ID action* processClose;
processClose: FIN_PROCESO | FIN_ALGORITMO;
processOpen: PROCESO | ALGORITMO;

repeat: REPETIR action* HASTA QUE expression;

setArrayDim: DIMENSION ID arrayDimensions (',' ID arrayDimensions)* ';';

subprocess: subprocessOpen (ID '<-')? ID ('(' idList? ')')? action* subprocessClose;
subprocessOpen: FUNCION | SUBPROCESO | SUBALGORITMO;
subprocessClose: (FIN_FUNCION | FIN_SUBPROCESO | FIN_SUBALGORITMO);

timeUnits: SEGUNDOS | MILISEGUNDOS;

unaryOp: booleanUnaryOp | '-';

value: idGetter | VERDADERO | FALSO | TOKEN_CADENA | TOKEN_ENTERO | TOKEN_REAL;

while: MIENTRAS expression HACER action* FIN_MIENTRAS;



TOKEN_CADENA: ('"' | '\'') ~ [\r\n]+ ('"' | '\'');
TOKEN_ENTERO: [0-9]+;
TOKEN_REAL: [0-9]+ '.' [0-9]+;

ALGORITMO: [Aa] [Ll] [Gg] [Oo] [Rr] [Ii] [Tt] [Mm] [Oo];
FIN_ALGORITMO: [Ff] [Ii] [Nn] [Aa] [Ll] [Gg] [Oo] [Rr] [Ii] [Tt] [Mm] [Oo];

BORRAR: [Bb] [Oo] [Rr] [Rr] [Aa] [Rr];

CARACTER: [Cc] [Aa] [Rr] [Aa] [Cc] [Tt] [Ee] [Rr];

CADENA: [Cc] [Aa] [Dd] [Ee] [Nn] [Aa];

CASO: [Cc] [Aa] [Ss] [Oo];

COMO: [Cc] [Oo] [Mm] [Oo];

CON: [Cc] [Oo] [Nn];

DE: [Dd] [Ee];

DEFINIR: [Dd] [Ee] [Ff] [Ii] [Nn] [Ii] [Rr];

DIMENSION: [Dd] [Ii] [Mm] [Ee] [Nn] [Ss] [Ii] [Oo] [Nn];

ENTERO: [Ee] [Nn] [Tt] [Ee] [Rr] [Oo];

ENTONCES: [Ee] [Nn] [Tt] [Oo] [Nn] [Cc] [Ee] [Ss];

ESCRIBIR: [Ee] [Ss] [Cc] [Rr] [Ii] [Bb] [iI] [Rr];

ESPERAR: [Ee] [Ss] [Pp] [Ee] [Rr] [Aa] [Rr];

FALSO: [Ff] [Aa] [Ll] [Ss] [Oo];

FINSI: [Ff] [Ii] [Nn] [Ss] [Ii];

FUNCION: [Ff] [Uu] [Nn] [Cc] [Ii] [Oo] [Nn];
FIN_FUNCION: [Ff] [Ii] [Nn] [Ff] [Uu] [Nn] [Cc] [Ii] [Oo] [Nn];

HACER: [Hh] [Aa] [Cc] [Ee] [Rr];

HASTA: [Hh] [Aa] [Ss] [Tt] [Aa];

LEER: [Ll] [Ee] [Ee] [Rr];

LIMPIAR: [Ll] [Ii] [Mm] [Pp] [Ii] [Aa] [Rr];

LOGICO: [Ll] [Oo] [Gg] [Ii] [Cc] [Oo];

MIENTRAS: [Mm] [Ii] [Ee] [Nn] [Tt] [Rr] [Aa] [Ss];
FIN_MIENTRAS: [Ff] [Ii] [Nn] [Mm] [Ii] [Ee] [Nn] [Tt] [Rr] [Aa] [Ss];

MILISEGUNDOS: [Mm] [Ii] [Ll] [Ii] [Ss] [Ee] [Gg] [Uu] [Nn] [Dd] [Oo] [Ss];

MOD: [Mm] [Oo] [Dd];

MODO: [Mm] [Oo] [Dd] [Oo];

NO: [Nn] [Oo];

NUMERICO: [Nn] [Uu] [Mm] [Ee] [Rr] [Ii] [Cc] [Oo];

NUMERO: [Nn] [Uu] [Mm] [Ee] [Rr] [Oo];

O: [Oo];

OTRO: [Oo] [Tt] [Rr] [Oo];

PANTALLA: [Pp] [Aa] [Nn] [Tt] [Aa] [Ll] [Ll] [Aa];

PARA: [Pp] [Aa] [Rr] [Aa];
FINPARA: [Ff] [Ii] [Nn] [Pp] [Aa] [Rr] [Aa];

PASO: [Pp] [Aa] [Ss] [Oo];

PROCESO: [Pp] [Rr] [Oo] [Cc] [Ee] [Ss] [Oo];
FIN_PROCESO: [Ff] [Ii] [Nn] [Pp] [Rr] [Oo] [Cc] [Ee] [Ss] [Oo];

QUE: [Qq] [Uu] [Ee];

REAL: [Rr] [Ee] [Aa] [Ll];

REPETIR: [Rr] [Ee] [Pp] [Ee] [Tt] [Ii] [Rr];

SEGUN: [Ss] [Ee] [Gg] [Uu] [Nn];
FIN_SEGUN: [Ff] [Ii] [Nn] [Ss] [Ee] [Gg] [Uu] [Nn];

SEGUNDOS: [Ss] [Ee] [Gg] [Uu] [Nn] [Dd] [Oo] [Ss];

SI: [Ss] [Ii];

SINO: [Ss] [Ii] [Nn] [Oo];

SUBALGORITMO: [Ss] [Uu] [Bb] [Aa] [Ll] [Gg] [Oo] [Rr] [Ii] [Tt] [Mm] [Oo];
FIN_SUBALGORITMO: [Ff] [Ii] [Nn] [Ss] [Uu] [Bb] [Aa] [Ll] [Gg] [Oo] [Rr] [Ii] [Tt] [Mm] [Oo];

SUBPROCESO: [Ss] [Uu] [Bb] [Pp] [Rr] [Oo] [Cc] [Ee] [Ss] [Oo];
FIN_SUBPROCESO: [Ff] [Ii] [Nn] [Ss] [Uu] [Bb] [Pp] [Rr] [Oo] [Cc] [Ee] [Ss] [Oo];

TECLA: [Tt] [Ee] [Cc] [Ll] [Aa];

TEXTO: [Tt] [Ee] [Xx] [Tt] [Oo];

VERDADERO: [Vv] [Ee] [Rr] [Dd] [Aa] [Dd] [Ee] [Rr] [Oo];

Y: [Yy];


COMMENT: '//' ~ [\r\n]+ -> skip;
ESPACE: [ \t\r\n]+ -> skip;
ID: [a-zA-Z][a-zA-Z0-9_]*;