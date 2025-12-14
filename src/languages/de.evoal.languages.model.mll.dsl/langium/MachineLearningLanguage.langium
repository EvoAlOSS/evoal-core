grammar MachineLearningLanguage
import 'GeneratorDSL'
import 'mll-types'
import 'model-types'
import 'execution-types'
import 'definitions-types'
import 'expressions-types'
import 'generator-types'
import 'types-types'

entry MachineLearningModuleRule returns MachineLearningModule:
    (imports+=ImportRule )* "module" name=QualifiedName  "{" task=TaskDescriptionRule  validation=ValidationPipelineDefinitionRule  preparation=PreparationPipelineDefinitionRule  'specify' 'model' model=InstanceLiteralRule  ('specify' 'gof' gof=BodyRule  )? ('use' 'cases' (learningUseCase=LearningUseCaseRule  ';' )? (predictionUseCase=PredictionUseCaseRule  ';' )? 'end' )? '}'  
;

TaskDescriptionRule returns TaskDescription:
    'specify' name='learning-task'  '{' 'input' 'features' inputs+=[DataDescription:QualifiedName ] ("," inputs+=[DataDescription:QualifiedName ] )* 'output' 'features' outputs+=[DataDescription:QualifiedName ] ("," outputs+=[DataDescription:QualifiedName ] )* 'learning' 'from' '[' learningData+=STRING  (',' learningData+=STRING  )* ']' ('testing' 'with' '[' testingData+=STRING  (',' testingData+=STRING  )* ']' )? 'serialise' 'to' modelFile=STRING  ('and' gofFile=STRING  )? '}'  
;

ValidationPipelineDefinitionRule returns PipelineDefinition:
    {PipelineDefinition} 'specify' name='validation'  'steps' '[' steps+=StepRule * ']'  
;

PreparationPipelineDefinitionRule returns PipelineDefinition:
    {PipelineDefinition} 'specify' name='preparation'  'steps' '[' steps+=StepRule * ']'  
;

LearningUseCaseRule returns Block:
    {Block} 'specify' 'learning' 'begin' (statements+=StatementRule )* 'end'  
;

PredictionUseCaseRule returns PipelineDefinition:
    {PipelineDefinition} 'specify' name='predicting'  'begin' steps+=StepRule * 'end'  
;

LiteralRule returns Literal:
    NumberLiteralRule | StringLiteralRule | BooleanLiteralRule | InstanceLiteralRule | StepRule 
;

