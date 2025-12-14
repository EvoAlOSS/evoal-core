import 'model-types'
import 'execution-types'
import 'expressions-types'

interface GeneratorModule {
	name: string
	imports: Import[]
	pipelines: PipelineDefinition[]
	body: Block
}

interface PipelineDefinition extends NamedVariable {
	steps: Step[]
}

interface Step extends Literal {
}

interface ConcreteStep extends Step {
	instance: Instance
	reads: TypeDefinitionReference[]
	writes: TypeDefinitionReference[]
}

interface PipelineStep extends Step {
	definition: @PipelineDefinition
}

interface ApplyStatement extends Statement {
	file?: string
	count: Literal
	pipelines: VariableReference[]
}

