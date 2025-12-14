import 'definitions-types'

interface Expression {
}

interface Literal extends ConstantExpression {
}

interface ConstantExpression extends ReadExpression {
}

interface ReadExpression extends Expression {
}

interface Instance extends Literal {
	definition: @ClassDefinition
	attributes: Attribute[]
}

interface Attribute {
	definition?: @AttributeDefinition
	value?: Expression
}

