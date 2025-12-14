grammar DataDescriptionLanguage
import 'BaseLanguage'
import 'model-types'
import 'model-types'
import 'definitions-types'
import 'expressions-types'
import 'types-types'

entry DataDescriptionModelRule returns DataDescriptionModule:
    (imports+=ImportRule )* 'module' name=QualifiedName  '{' ('types' ':' (types+=DataTypeDefinitionRule )* )? ('data' ':' (descriptions+=DataDescriptionRule )* )? ('constraints' ':' (constraints+=StatementRule )* )? '}'  
;

ScaleType returns ScaleType:
    ScaleType_Nominal | ScaleType_Ordinal | ScaleType_Cardinal | ScaleType_Quotient
;
ScaleType_Nominal returns ScaleType_Nominal: 'nominal' ;
ScaleType_Ordinal returns ScaleType_Ordinal: 'ordinal' ;
ScaleType_Cardinal returns ScaleType_Cardinal: 'cardinal' ;
ScaleType_Quotient returns ScaleType_Quotient: 'quotient' ;

RepresentationType returns RepresentationType:
    RepresentationType_Real | RepresentationType_Integer | RepresentationType_Boolean | RepresentationType_String
;
RepresentationType_Real returns RepresentationType_Real: 'real' ;
RepresentationType_Integer returns RepresentationType_Integer: 'integer' ;
RepresentationType_Boolean returns RepresentationType_Boolean: 'boolean' ;
RepresentationType_String returns RepresentationType_String: 'string' ;

DataTypeDefinitionRule returns Definition:
    BaseDataTypeTypeDefinitionRule | EnumTypeDefinitionRule 
;

BaseDataTypeTypeDefinitionRule returns DataTypeTypeDefinition:
    (constraints+=ConstraintRule )* scale=ScaleType  'type' name=StringOrId  ('with' 'constraints' ':' (constraints+=StatementRule )* )? ';'  
;

EnumLiteralRule returns EnumLiteralDefinition:
    name=StringOrId  
;

EnumTypeDefinitionRule returns EnumDefinition:
    (constraints+=ConstraintRule )* scale=ScaleType  'enum' name=StringOrId  '(' literals+=EnumLiteralRule  (',' literals+=EnumLiteralRule  )* ')' ('with' 'constraints' ':' (constraints+=StatementRule )* )? ';'  
;

DataDescriptionRule returns DataDescription:
    TypedBaseDataDescriptionRule | UntypedBaseDataDescriptionRule | StructuredDataDescriptionRule 
;

TypedBaseDataDescriptionRule returns TypedBaseDataDescription:
    (constraints+=ConstraintRule )* representation=RepresentationType  'data' name=StringOrId  'of' (('type' ^type=[DataTypeTypeDefinition:QualifiedName ] ) | ('enum' ^type=[EnumDefinition:QualifiedName ] ) )('with' 'constraints' ':' (constraints+=StatementRule )* )? ';'  
;

UntypedBaseDataDescriptionRule returns UntypedBaseDataDescription:
    (constraints+=ConstraintRule )* (scale=ScaleType )? representation=RepresentationType  'data' name=StringOrId  ('with' 'constraints' ':' (constraints+=StatementRule )* )? ';'  
;

StructuredDataDescriptionRule returns StructuredDataDescription:
    (constraints+=ConstraintRule )* 'data' name=StringOrId  'of' 'instance' ^type=[ClassDefinition:QualifiedName ] ';'  
;

StatementRule returns Expression:
    ExpressionRule ';'  
;

ReferenceRule returns ConstantExpression:
    ValuelDefinitionReferenceRule | TypeDefinitionReferenceRule | SelfReferenceRule 
;

SelfReferenceRule returns SelfReference:
    {SelfReference} 'value'  
;

