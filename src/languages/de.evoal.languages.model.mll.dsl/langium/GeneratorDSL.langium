grammar GeneratorDSL
import 'BaseLanguage'
import 'generator-types'
import 'model-types'
import 'execution-types'
import 'expressions-types'
import 'definitions-types'
import 'types-types'

entry GeneratorModuleRule returns GeneratorModule:
    (imports+=ImportRule )* "module" name=QualifiedName  "{" (pipelines+=PipelineDefinitionRule )* body=BodyRule  "}"  
;

PipelineDefinitionRule returns PipelineDefinition:
    'pipeline' name=StringOrId  '[' steps+=StepRule * ']'  
;

StepRule returns Step:
    ConcreteStepRule | PipelineStepRule 
;

ConcreteStepRule returns ConcreteStep:
    'step' '{' 'component' instance=InstanceLiteralRule  ('reads' '[' (reads+=BaseDataReferenceRule  (',' reads+=BaseDataReferenceRule  )* )? ']' ';' )? ('writes' '[' (writes+=BaseDataReferenceRule  (',' writes+=BaseDataReferenceRule  )* )? ']' ';' )? '}'  
;

PipelineStepRule returns PipelineStep:
    'pipeline' definition=[PipelineDefinition:QualifiedName ]  
;

BodyRule returns Block:
    {Block} 'begin' (statements+=StatementRule )* 'end'  
;

StatementRule returns Statement:
    ForStatementRule | ApplyStatementRule | CallBuiltInFunctionRule 
;

ForStatementRule returns ForStatement:
    'for' var=NamedVariableRule  'in' range=RangeRule  body=BodyRule   
;

NamedVariableRule returns NamedVariable:
    name=StringOrId  
;

RangeRule returns Range:
    CounterRangeRule | LiteralRangeRule 
;

LiteralRangeRule returns ValueRange:
    '[' elements+=ReadExpressionRule  (',' elements+=ReadExpressionRule  )* ']'  
;

CounterRangeRule returns CounterRange:
    '[' start=IntegerLiteralRule  'to' end=IntegerLiteralRule  'increment' 'by' increment=IntegerLiteralRule  ']'  
;

ApplyStatementRule returns ApplyStatement:
    'write' file=STRING  'with' count=LiteralRule  'samples' 'from' 'executing' '[' pipelines+=VariableReferenceRule  (',' pipelines+=VariableReferenceRule  )* ']' ';'  
;

ReferenceRule returns ConstantExpression:
    ValuelDefinitionReferenceRule | TypeDefinitionReferenceRule | VariableReferenceRule 
;

VariableReferenceRule returns VariableReference:
    variable=[NamedVariable:StringOrId ] 
;

CallBuiltInFunctionRule returns CallBuiltinFunction:
    definition=[FunctionDefinition:QualifiedName ] '(' (parameters+=ExpressionRule  (',' parameters+=ExpressionRule  )* )? ')' ';'  
;

