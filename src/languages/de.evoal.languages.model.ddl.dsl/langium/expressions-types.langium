
interface Expression {
}

interface ConstantExpression extends ReadExpression {
}

interface ReadExpression extends Expression {
}

interface SelfReference extends ValueReference {
}

interface ValueReference extends ConstantExpression {
}

