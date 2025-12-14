
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

