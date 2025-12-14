import 'types-types'
import 'expressions-types'

type RepresentationType = RepresentationType_Real | RepresentationType_Integer | RepresentationType_Boolean | RepresentationType_String;
type RepresentationType_Real = 'real';
type RepresentationType_Integer = 'integer';
type RepresentationType_Boolean = 'boolean';
type RepresentationType_String = 'string';

interface FunctionDefinition extends Definition {
	^type: Type
	parameters: Parameter[]
}

interface Definition extends Constrained {
	name?: string
}

interface Constrained {
	constraints: Expression[]
}

interface Parameter extends Definition {
	^type: Type
}

interface ValueDefinition extends Definition {
}

interface TypeDefinition extends Definition {
}

interface BaseDataDescription extends DataDescription {
	representation: RepresentationType
}

interface DataDescription extends DataTypeDefinition {
}

interface DataTypeDefinition extends TypeDefinition {
}

interface StructuredDataDescription extends DataDescription {
	^type: @ClassDefinition
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

interface EnumDefinition extends TypeDefinition, ScaledDefinition {
	literals: EnumLiteralDefinition[]
}

interface ScaledDefinition {
}

interface EnumLiteralDefinition extends LiteralDefinition {
}

interface LiteralDefinition extends ValueDefinition {
}

interface ConstantDefinition extends LiteralDefinition {
	^type: Type
	value: Expression
}

