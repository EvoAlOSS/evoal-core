import 'expressions-types'
import 'types-types'

interface DataDescription extends DataTypeDefinition {
}

interface DataTypeDefinition extends TypeDefinition {
}

interface TypeDefinition extends Definition {
}

interface Definition extends Constrained {
	name?: string
}

interface Constrained {
	constraints: Expression[]
}

interface ClassDefinition extends TypeDefinition {
	attributes: AttributeDefinition[]
	superType?: @ClassDefinition
	abstract: boolean
}

interface AttributeDefinition extends Definition, ValueDefinition {
	^type: Type
	initialisation?: Expression
	optional: boolean
}

interface ValueDefinition extends Definition {
}

