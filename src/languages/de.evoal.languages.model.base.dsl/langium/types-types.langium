import 'definitions-types'

interface Type {
}

interface BaseType extends Type {
}

interface DefinitionReference extends Type {
	definition: @Definition
}

interface LiteralType extends Type {
}

interface DataType extends Type {
}

interface StringType extends BaseType {
}

interface ExpressionType extends Type {
}

interface IntType extends BaseType {
}

interface RealType extends BaseType {
}

interface BooleanType extends BaseType {
}

interface VoidType extends BaseType {
}

interface ArrayType extends BaseType {
	elements: Type
}

