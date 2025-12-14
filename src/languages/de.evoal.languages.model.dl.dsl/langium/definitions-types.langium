import 'expressions-types'
import 'types-types'

type ScaleType = ScaleType_Nominal | ScaleType_Ordinal | ScaleType_Cardinal | ScaleType_Quotient | ScaleType_Unknown;
type ScaleType_Nominal = 'nominal';
type ScaleType_Ordinal = 'ordinal';
type ScaleType_Cardinal = 'cardinal';
type ScaleType_Quotient = 'quotient';
type ScaleType_Unknown = 'unknown';

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

interface FunctionDefinition extends Definition {
	^type: Type
	parameters: Parameter[]
}

interface Parameter extends Definition {
	^type: Type
}

interface ConstantDefinition extends LiteralDefinition {
	^type: Type
	value: Expression
}

interface LiteralDefinition extends ValueDefinition {
}

interface EnumDefinition extends TypeDefinition, ScaledDefinition {
	literals: EnumLiteralDefinition[]
}

interface ScaledDefinition {
}

interface EnumLiteralDefinition extends LiteralDefinition {
}

