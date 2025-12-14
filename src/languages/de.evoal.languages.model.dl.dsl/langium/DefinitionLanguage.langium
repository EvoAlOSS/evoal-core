grammar DefinitionLanguage
import 'BaseLanguage'
import 'model-types'
import 'model-types'
import 'definitions-types'
import 'expressions-types'
import 'types-types'

entry DefinitionModelRule returns DefinitionModule:
    (imports+=ImportRule )* 'module' name=QualifiedName  '{' ((enums+=EnumTypeDefinitionRule ) | (types+=ClassDefinitionRule ) | (functions+=FunctionDefinitionRule ) | constants+=ConstantDefinitionRule  )*'}'  
;

EnumLiteralRule returns EnumLiteralDefinition:
    name=StringOrId  
;

EnumTypeDefinitionRule returns EnumDefinition:
    (constraints+=ConstraintRule )* scale=ScaleType  'enum' name=StringOrId  '(' literals+=EnumLiteralRule  (',' literals+=EnumLiteralRule  )* ')' ('with' 'constraints' ':' (constraints+=StatementRule )* )? ';'  
;

ScaleType returns ScaleType:
    ScaleType_Nominal | ScaleType_Ordinal | ScaleType_Cardinal | ScaleType_Quotient
;
ScaleType_Nominal returns ScaleType_Nominal: 'nominal' ;
ScaleType_Ordinal returns ScaleType_Ordinal: 'ordinal' ;
ScaleType_Cardinal returns ScaleType_Cardinal: 'cardinal' ;
ScaleType_Quotient returns ScaleType_Quotient: 'quotient' ;

StatementRule returns Expression:
    ExpressionRule ';'  
;

