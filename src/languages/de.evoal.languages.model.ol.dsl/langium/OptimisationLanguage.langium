grammar OptimisationLanguage
import 'BaseLanguage'
import 'model-types'
import 'expressions-types'
import 'definitions-types'
import 'types-types'
import 'model-types'

entry OptimisationModelRule returns OptimisationModule:
    (imports+=ImportRule )* "module" name=QualifiedName  "{" (problem=ProblemRule )? (algorithm=AlgorithmInstanceRule )? "}"  
;

ProblemRule returns ProblemInstance:
    "specify" definition=[ClassDefinition:QualifiedName ] name=StringOrId  "{" 'search' 'for' searchSpace+=TypeDefinitionReferenceRule  (',' searchSpace+=TypeDefinitionReferenceRule  )* 'map' 'with' optimisationFunction=InstanceLiteralRule  'and' optimisationSpace+=OptimisationGoalRule  (',' optimisationSpace+=OptimisationGoalRule  )* ("document" documentation=ArrayRule  '.' )? "}"  
;

OptimisationGoalRule returns OptimisationGoal:
    MaximiseGoalRule | MinimiseGoalRule | TargetGoalRule 
;

MaximiseGoalRule returns MaximiseGoal:
    'maximise' data=TypeDefinitionReferenceRule   
;

MinimiseGoalRule returns MinimiseGoal:
    'minimise' data=TypeDefinitionReferenceRule   
;

TargetGoalRule returns TargetGoal:
    'optimise' data=TypeDefinitionReferenceRule  'towards' value=LiteralRule   
;

AlgorithmInstanceRule returns AlgorithmInstance:
    "configure" definition=[ClassDefinition:QualifiedName ] "for" problem=[ProblemInstance:QualifiedName ] "{" attributes+=AttributeRule * ("document" ":=" documentation=ArrayRule  ';' )? "}"  
;

