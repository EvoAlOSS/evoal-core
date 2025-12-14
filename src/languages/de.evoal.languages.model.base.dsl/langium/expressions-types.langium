import 'definitions-types'

type AddOrSubtractOperator = AddOrSubtractOperator_Add | AddOrSubtractOperator_Subtract;
type AddOrSubtractOperator_Add = 'Add';
type AddOrSubtractOperator_Subtract = 'Subtract';

type MultiplyDivideModuloOperator = MultiplyDivideModuloOperator_Multiply | MultiplyDivideModuloOperator_Divide | MultiplyDivideModuloOperator_Modulo;
type MultiplyDivideModuloOperator_Multiply = 'Multiply';
type MultiplyDivideModuloOperator_Divide = 'Divide';
type MultiplyDivideModuloOperator_Modulo = 'Modulo';

type ComparisonOperator = ComparisonOperator_GreaterThan | ComparisonOperator_GreaterEqual | ComparisonOperator_Equal | ComparisonOperator_Unequal | ComparisonOperator_LessEqual | ComparisonOperator_LessThan;
type ComparisonOperator_GreaterThan = 'GreaterThan';
type ComparisonOperator_GreaterEqual = 'GreaterEqual';
type ComparisonOperator_Equal = 'Equal';
type ComparisonOperator_Unequal = 'Unequal';
type ComparisonOperator_LessEqual = 'LessEqual';
type ComparisonOperator_LessThan = 'LessThan';

type Factor = Factor_Yotta | Factor_Zetta | Factor_Exa | Factor_Peta | Factor_Tera | Factor_Giga | Factor_Mega | Factor_Kilo | Factor_Hecto | Factor_Deka | Factor_None | Factor_Deci | Factor_Centi | Factor_Milli | Factor_Micro | Factor_Nano | Factor_Piko | Factor_Femto | Factor_Atto | Factor_Zepto | Factor_Yocto;
type Factor_Yotta = 'Yotta';
type Factor_Zetta = 'Zetta';
type Factor_Exa = 'Exa';
type Factor_Peta = 'Peta';
type Factor_Tera = 'Tera';
type Factor_Giga = 'Giga';
type Factor_Mega = 'Mega';
type Factor_Kilo = 'Kilo';
type Factor_Hecto = 'Hecto';
type Factor_Deka = 'Deka';
type Factor_None = 'None';
type Factor_Deci = 'Deci';
type Factor_Centi = 'Centi';
type Factor_Milli = 'Milli';
type Factor_Micro = 'Micro';
type Factor_Nano = 'Nano';
type Factor_Piko = 'Piko';
type Factor_Femto = 'Femto';
type Factor_Atto = 'Atto';
type Factor_Zepto = 'Zepto';
type Factor_Yocto = 'Yocto';

interface Expression {
}

interface OrExpression extends ReadExpression {
	subExpressions: XorExpression[]
}

interface ReadExpression extends Expression {
}

interface XorExpression extends ReadExpression {
	subExpressions: AndExpression[]
}

interface AndExpression extends ReadExpression {
	subExpressions: NotExpression[]
}

interface NotExpression extends ReadExpression {
	negated: boolean
	operand: ComparisonExpression
}

interface ComparisonExpression extends ReadExpression {
	leftOperand: AddOrSubtractExpression
	comparison: PartialComparisonExpression[]
}

interface AddOrSubtractExpression extends ReadExpression {
	leftOperand: MultiplyDivideModuloExpression
	operators: AddOrSubtractOperator[]
	operands: MultiplyDivideModuloExpression[]
}

interface MultiplyDivideModuloExpression extends ReadExpression {
	leftOperand: PowerOfExpression
	operators: MultiplyDivideModuloOperator[]
	operands: PowerOfExpression[]
}

interface PowerOfExpression extends ReadExpression {
	leftOperand: UnaryAddOrSubtractExpression
	rightOperand?: PowerOfExpression
}

interface UnaryAddOrSubtractExpression extends ReadExpression {
	operators: AddOrSubtractOperator[]
	subExpression: ReadExpression
}

interface PartialComparisonExpression extends ReadExpression {
	operator: ComparisonOperator
	subExpression: AddOrSubtractExpression
}

interface Array extends ReadExpression {
	values: ReadExpression[]
}

interface Parantheses extends ReadExpression {
	subExpression: Expression
}

interface Call extends ReadExpression {
	function?: @FunctionDefinition
	parameters: Expression[]
}

interface ConstantExpression extends ReadExpression {
}

interface ValueDefinitionReference extends ValueReference {
	definition: @ValueDefinition
}

interface ValueReference extends ConstantExpression {
}

interface TypeDefinitionReference extends ValueReference {
	definition?: @TypeDefinition
}

interface Literal extends ConstantExpression {
}

interface Instance extends Literal {
	definition: @ClassDefinition
	attributes: Attribute[]
}

interface Attribute {
	definition?: @AttributeDefinition
	value?: Expression
}

interface NumberLiteral extends Literal {
	factor: Factor
}

interface RealLiteral extends NumberLiteral {
	literal: number
}

interface IntegerLiteral extends NumberLiteral {
	literal: number
}

interface StringLiteral extends Literal {
	literal: string
}

interface BooleanLiteral extends Literal {
	literal: boolean
}

