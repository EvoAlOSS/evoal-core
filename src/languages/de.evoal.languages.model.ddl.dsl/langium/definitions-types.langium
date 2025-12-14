import 'expressions-types'
import 'types-types'

type ScaleType = ScaleType_Nominal | ScaleType_Ordinal | ScaleType_Cardinal | ScaleType_Quotient | ScaleType_Unknown;
type ScaleType_Nominal = 'nominal';
type ScaleType_Ordinal = 'ordinal';
type ScaleType_Cardinal = 'cardinal';
type ScaleType_Quotient = 'quotient';
type ScaleType_Unknown = 'unknown';

type RepresentationType = RepresentationType_Real | RepresentationType_Integer | RepresentationType_Boolean | RepresentationType_String;
type RepresentationType_Real = 'real';
type RepresentationType_Integer = 'integer';
type RepresentationType_Boolean = 'boolean';
type RepresentationType_String = 'string';

interface Definition extends Constrained {
	name?: string
}

interface Constrained {
	constraints: Expression[]
}

interface DataDescription extends DataTypeDefinition {
}

interface DataTypeDefinition extends TypeDefinition {
}

interface TypeDefinition extends Definition {
}

interface DataTypeTypeDefinition extends DataTypeDefinition, ScaledDefinition {
}

interface ScaledDefinition {
}

interface EnumLiteralDefinition extends LiteralDefinition {
}

interface LiteralDefinition extends ValueDefinition {
}

interface ValueDefinition extends Definition {
}

interface EnumDefinition extends TypeDefinition, ScaledDefinition {
	literals: EnumLiteralDefinition[]
}

interface TypedBaseDataDescription extends BaseDataDescription {
	^type: @Definition
}

interface BaseDataDescription extends DataDescription {
	representation: RepresentationType
}

interface UntypedBaseDataDescription extends BaseDataDescription, ScaledDefinition {
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

