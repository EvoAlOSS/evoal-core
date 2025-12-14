import 'execution-types'
import 'expressions-types'

interface PipelineDefinition extends NamedVariable {
	steps: Step[]
}

interface Step extends Literal {
}

