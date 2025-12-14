import 'definitions-types'

interface Instance extends Literal {
	definition: @ClassDefinition
	attributes: Attribute[]
}

interface Literal extends ConstantExpression {
}

interface ConstantExpression extends ReadExpression {
}

interface ReadExpression extends Expression {
}

interface Expression {
}

interface Attribute {
	definition?: @AttributeDefinition
	value?: Expression
}

