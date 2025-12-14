grammar BaseLanguage
import 'Terminals'
import 'expressions-types'
import 'definitions-types'
import 'types-types'
import 'model-types'

entry ExpressionRule returns Expression:
    OrExpressionRule 
;

OrExpressionRule returns OrExpression:
    subExpressions+=XorExpressionRule  ("OR" subExpressions+=XorExpressionRule  )*  
;

XorExpressionRule returns XorExpression:
    subExpressions+=AndExpressionRule  ("XOR" subExpressions+=AndExpressionRule  )*  
;

AndExpressionRule returns AndExpression:
    subExpressions+=NotExpressionRule  ("AND" subExpressions+=NotExpressionRule  )*  
;

NotExpressionRule returns NotExpression:
    (negated?="!" )? operand=ComparisonExpressionRule   
;

ComparisonExpressionRule returns ComparisonExpression:
    leftOperand=AddOrSubtractExpressionRule  (comparison+=PartialComparisonExpressionRule )*  
;

PartialComparisonExpressionRule returns PartialComparisonExpression:
    operator=ComparisonOperatorRule  subExpression=AddOrSubtractExpressionRule   
;

ComparisonOperatorRule returns ComparisonOperator:
    ComparisonOperatorRule_GreaterThan | ComparisonOperatorRule_GreaterEqual | ComparisonOperatorRule_Equal | ComparisonOperatorRule_Unequal | ComparisonOperatorRule_LessEqual | ComparisonOperatorRule_LessThan
;
ComparisonOperatorRule_GreaterThan returns ComparisonOperatorRule_GreaterThan: ">=" ;
ComparisonOperatorRule_GreaterEqual returns ComparisonOperatorRule_GreaterEqual: ">" ;
ComparisonOperatorRule_Equal returns ComparisonOperatorRule_Equal: "=" ;
ComparisonOperatorRule_Unequal returns ComparisonOperatorRule_Unequal: "!=" ;
ComparisonOperatorRule_LessEqual returns ComparisonOperatorRule_LessEqual: "<" ;
ComparisonOperatorRule_LessThan returns ComparisonOperatorRule_LessThan: "<=" ;

AddOrSubtractExpressionRule returns AddOrSubtractExpression:
    leftOperand=MultiplyDivideModuloExpressionRule  (operators+=AddOrSubtractOperatorRule  operands+=MultiplyDivideModuloExpressionRule  )*  
;

AddOrSubtractOperatorRule returns AddOrSubtractOperator:
    AddOrSubtractOperatorRule_Add | AddOrSubtractOperatorRule_Subtract
;
AddOrSubtractOperatorRule_Add returns AddOrSubtractOperatorRule_Add: '+' ;
AddOrSubtractOperatorRule_Subtract returns AddOrSubtractOperatorRule_Subtract: '-' ;

MultiplyDivideModuloExpressionRule returns MultiplyDivideModuloExpression:
    leftOperand=PowerOfExpressionRule  (operators+=MultiplyDivideModuloOperatorRule  operands+=PowerOfExpressionRule  )*  
;

MultiplyDivideModuloOperatorRule returns MultiplyDivideModuloOperator:
    MultiplyDivideModuloOperatorRule_Multiply | MultiplyDivideModuloOperatorRule_Divide | MultiplyDivideModuloOperatorRule_Modulo
;
MultiplyDivideModuloOperatorRule_Multiply returns MultiplyDivideModuloOperatorRule_Multiply: '*' ;
MultiplyDivideModuloOperatorRule_Divide returns MultiplyDivideModuloOperatorRule_Divide: "/" ;
MultiplyDivideModuloOperatorRule_Modulo returns MultiplyDivideModuloOperatorRule_Modulo: '%' ;

PowerOfExpressionRule returns PowerOfExpression:
    leftOperand=UnaryAddOrSubtractExpressionRule  ('^' rightOperand=PowerOfExpressionRule  )?  
;

UnaryAddOrSubtractExpressionRule returns UnaryAddOrSubtractExpression:
    (operators+=AddOrSubtractOperatorRule )* subExpression=ReadExpressionRule   
;

ReadExpressionRule returns ReadExpression:
    ArrayRule | CallRule | LiteralRule | ParanthesesRule | ReferenceRule 
;

ArrayRule returns Array:
    {Array} '[' (values+=ReadExpressionRule  (',' values+=ReadExpressionRule  )* )? ']'  
;

ParanthesesRule returns Parantheses:
    '(' subExpression=ExpressionRule  ')'  
;

CallRule returns Call:
    function=[FunctionDefinition:QualifiedName ] '(' (parameters+=ExpressionRule  (',' parameters+=ExpressionRule  )* )? ')'  
;

ReferenceRule returns ConstantExpression:
    ValuelDefinitionReferenceRule | TypeDefinitionReferenceRule 
;

ValuelDefinitionReferenceRule returns ValueDefinitionReference:
    definition=[ValueDefinition:QualifiedName ] 
;

TypeDefinitionReferenceRule returns TypeDefinitionReference:
    BaseDataReferenceRule | StructuredDataDescriptionReferenceRule 
;

BaseDataReferenceRule returns TypeDefinitionReference:
    'data' definition=[BaseDataDescription:QualifiedName ]  
;

StructuredDataDescriptionReferenceRule returns TypeDefinitionReference:
    'instance' definition=[StructuredDataDescription:QualifiedName ]  
;

LiteralRule returns Literal:
    NumberLiteralRule | StringLiteralRule | BooleanLiteralRule | InstanceLiteralRule 
;

InstanceLiteralRule returns Instance:
    definition=[ClassDefinition:QualifiedName ] '{' attributes+=AttributeRule * '}'  
;

AttributeRule returns Attribute:
    definition=[AttributeDefinition:StringOrId ] ':=' value=ExpressionRule  ';'  
;

NumberLiteralRule returns NumberLiteral:
    RealLiteralRule | IntegerLiteralRule 
;

RealLiteralRule returns RealLiteral:
    literal=DOUBLE  (factor=FactorRule )?  
;

IntegerLiteralRule returns IntegerLiteral:
    literal=INT  (factor=FactorRule )?  
;

StringLiteralRule returns StringLiteral:
    literal=STRING  
;

FactorRule returns Factor:
    FactorRule_Yotta | FactorRule_Zetta | FactorRule_Exa | FactorRule_Peta | FactorRule_Tera | FactorRule_Giga | FactorRule_Mega | FactorRule_Kilo | FactorRule_Hecto | FactorRule_Deka | FactorRule_Deci | FactorRule_Centi | FactorRule_Milli | FactorRule_Micro | FactorRule_Nano | FactorRule_Piko | FactorRule_Femto | FactorRule_Atto | FactorRule_Zepto | FactorRule_Yocto
;
FactorRule_Yotta returns FactorRule_Yotta: 'Y' ;
FactorRule_Zetta returns FactorRule_Zetta: 'Z' ;
FactorRule_Exa returns FactorRule_Exa: 'E' ;
FactorRule_Peta returns FactorRule_Peta: 'P' ;
FactorRule_Tera returns FactorRule_Tera: 'T' ;
FactorRule_Giga returns FactorRule_Giga: 'G' ;
FactorRule_Mega returns FactorRule_Mega: 'M' ;
FactorRule_Kilo returns FactorRule_Kilo: 'k' ;
FactorRule_Hecto returns FactorRule_Hecto: 'h' ;
FactorRule_Deka returns FactorRule_Deka: 'da' ;
FactorRule_Deci returns FactorRule_Deci: 'd' ;
FactorRule_Centi returns FactorRule_Centi: 'c' ;
FactorRule_Milli returns FactorRule_Milli: 'm' ;
FactorRule_Micro returns FactorRule_Micro: 'µ' ;
FactorRule_Nano returns FactorRule_Nano: 'n' ;
FactorRule_Piko returns FactorRule_Piko: 'p' ;
FactorRule_Femto returns FactorRule_Femto: 'f' ;
FactorRule_Atto returns FactorRule_Atto: 'a' ;
FactorRule_Zepto returns FactorRule_Zepto: 'z' ;
FactorRule_Yocto returns FactorRule_Yocto: 'y' ;

BooleanLiteralRule returns BooleanLiteral:
    {BooleanLiteral} (literal?='true'  | 'false' ) 
;

ClassDefinitionRule returns ClassDefinition:
    (constraints+=ConstraintRule )* (abstract?='abstract' )? 'type' name=StringOrId  ('extends' superType=[ClassDefinition:QualifiedName ] )? '{' attributes+=AttributeDefinitionRule * '}'  
;

ConstraintRule returns Instance:
    '@' InstanceLiteralRule  
;

AttributeDefinitionRule returns AttributeDefinition:
    (constraints+=ConstraintRule )* name=StringOrId  ':' (optional?='optional' )? ^type=TypeRule  (':=' initialisation=ExpressionRule  )? ';'  
;

TypeRule returns Type:
    ArrayTypeRule | BaseTypeRule | TypeReferenceRule | EnumReferenceRule | ExpressionTypeRule | LiteralTypeRule | DataTypeRule 
;

BaseTypeRule returns BaseType:
    StringTypeRule | IntTypeRule | RealTypeRule | BooleanTypeRule | VoidTypeRule 
;

EnumReferenceRule returns DefinitionReference:
    'enum' definition=[EnumDefinition:QualifiedName ]  
;

TypeReferenceRule returns DefinitionReference:
    'instance' definition=[ClassDefinition:QualifiedName ]  
;

LiteralTypeRule returns LiteralType:
    {LiteralType} 'literal'  
;

DataTypeRule returns DataType:
    {DataType} 'data'  
;

StringTypeRule returns StringType:
    {StringType} 'string'  
;

ExpressionTypeRule returns ExpressionType:
    {ExpressionType} 'expression'  
;

IntTypeRule returns IntType:
    {IntType} 'int'  
;

RealTypeRule returns RealType:
    {RealType} 'real'  
;

BooleanTypeRule returns BooleanType:
    {BooleanType} 'boolean'  
;

VoidTypeRule returns VoidType:
    {VoidType} 'void'  
;

ArrayTypeRule returns ArrayType:
    'array' elements=TypeRule   
;

FunctionDefinitionRule returns FunctionDefinition:
    'def' ^type=TypeRule  name=StringOrId  '(' (parameters+=ParameterRule  (',' parameters+=ParameterRule  )* )? ')' ';'  
;

ConstantDefinitionRule returns ConstantDefinition:
    'const' ^type=TypeRule  name=StringOrId  ':=' value=ExpressionRule  ';'  
;

ParameterRule returns Parameter:
    ^type=TypeRule  name=StringOrId   
;

ImportRule returns Import:
    'import' language=STRING  'from' importedNamespace=QualifiedName  ";"  
;

QualifiedName returns string:
    StringOrId ('.' StringOrId )*  
;

StringOrId returns string:
    QUOTED_ID | ID 
;

terminal DIGIT returns string:'0' ..'9' ;
terminal EXPONENT returns string:'e' ('+' | '-' )?DIGIT+  ;
terminal INT returns number:'-'? DIGIT+  ;
terminal DOUBLE returns number:INT EXPONENT  | INT '.' DIGIT* EXPONENT?  ;
terminal STRING returns string:'"' ('\\' . |  !('\\' | '"' ))*'"'  ;
terminal QUOTED_ID returns string:"'" ('\\' . |  !('\\' | "'" ))*"'"  ;
