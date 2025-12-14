import 'expressions-types'
import 'definitions-types'

interface NamedVariable extends Variable {
	name: string
}

interface Variable {
}

interface Block extends Statement {
	statements: Statement[]
}

interface Statement {
}

interface ForStatement extends Statement {
	var: NamedVariable
	range: Range
	body: Block
}

interface Range {
}

interface ValueRange extends Range {
	elements: ReadExpression[]
}

interface CounterRange extends Range {
	start: Literal
	end: Literal
	increment: Literal
}

interface VariableReference extends ValueReference {
	variable: @Variable
}

interface CallBuiltinFunction extends CallStatement {
	definition: @FunctionDefinition
	parameters: Expression[]
}

interface CallStatement extends Statement {
}

