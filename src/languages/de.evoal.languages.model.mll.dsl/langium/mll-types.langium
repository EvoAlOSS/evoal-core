import 'model-types'
import 'generator-types'
import 'expressions-types'
import 'execution-types'
import 'definitions-types'

interface MachineLearningModule {
	imports: Import[]
	name: string
	task: TaskDescription
	validation: PipelineDefinition
	preparation: PipelineDefinition
	model: Instance
	gof?: Block
	learningUseCase?: Block
	predictionUseCase: PipelineDefinition
}

interface TaskDescription extends NamedVariable {
	inputs: @DataDescription[]
	outputs: @DataDescription[]
	learningData: string[]
	testingData: string[]
	modelFile: string
	gofFile?: string
}

