import 'expressions-types'
import 'types-types'

interface ClassDefinition extends TypeDefinition {
	attributes: AttributeDefinition[]
	superType?: @ClassDefinition
	abstract: boolean
}

interface TypeDefinition extends Definition {
}

interface Definition extends Constrained {
	name?: string
}

interface Constrained {
	constraints: Expression[]
}

interface AttributeDefinition extends Definition, ValueDefinition {
	^type: Type
	initialisation?: Expression
	optional: boolean
}

interface ValueDefinition extends Definition {
}

