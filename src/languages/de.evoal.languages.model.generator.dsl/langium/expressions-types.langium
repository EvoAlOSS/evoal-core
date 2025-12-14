import 'definitions-types'

interface Literal extends ConstantExpression {
}

interface ConstantExpression extends ReadExpression {
}

interface ReadExpression extends Expression {
}

interface Expression {
}

interface Instance extends Literal {
	definition: @ClassDefinition
	attributes: Attribute[]
}

interface Attribute {
	definition?: @AttributeDefinition
	value?: Expression
}

interface TypeDefinitionReference extends ValueReference {
	definition?: @TypeDefinition
}

interface ValueReference extends ConstantExpression {
}

