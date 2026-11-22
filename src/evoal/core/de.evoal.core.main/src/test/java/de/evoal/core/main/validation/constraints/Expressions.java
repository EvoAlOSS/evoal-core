package de.evoal.core.main.validation.constraints;

import de.evoal.languages.model.base.expressions.AddOrSubtractExpression;
import de.evoal.languages.model.base.expressions.AddOrSubtractOperator;
import de.evoal.languages.model.base.expressions.ComparisonExpression;
import de.evoal.languages.model.base.expressions.ComparisonOperator;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.IntegerLiteral;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator;
import de.evoal.languages.model.base.expressions.PartialComparisonExpression;
import de.evoal.languages.model.base.expressions.PowerOfExpression;
import de.evoal.languages.model.base.expressions.ReadExpression;
import de.evoal.languages.model.base.expressions.RealLiteral;
import de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression;

/**
 * Builds expressions as the parser does, e.g. {@code 2.0 / 4.0} as a product of power
 *   expressions of unary expressions of literals.
 */
final class Expressions {
    private static final ExpressionsFactory FACTORY = ExpressionsFactory.eINSTANCE;

    private Expressions() {
    }

    static RealLiteral real(final double value) {
        final RealLiteral literal = FACTORY.createRealLiteral();
        literal.setLiteral(value);
        return literal;
    }

    static IntegerLiteral integer(final int value) {
        final IntegerLiteral literal = FACTORY.createIntegerLiteral();
        literal.setLiteral(value);
        return literal;
    }

    /**
     * @return {@code operators expression}, e.g. {@code - 0.5}.
     */
    static UnaryAddOrSubtractExpression unary(final ReadExpression expression, final AddOrSubtractOperator... operators) {
        final UnaryAddOrSubtractExpression unary = FACTORY.createUnaryAddOrSubtractExpression();
        unary.getOperators().addAll(java.util.List.of(operators));
        unary.setSubExpression(expression);
        return unary;
    }

    private static PowerOfExpression power(final ReadExpression expression) {
        final PowerOfExpression power = FACTORY.createPowerOfExpression();
        power.setLeftOperand(expression instanceof UnaryAddOrSubtractExpression unary ? unary : unary(expression));
        return power;
    }

    /**
     * @return The expression as a product with one factor.
     */
    static MultiplyDivideModuloExpression term(final ReadExpression expression) {
        final MultiplyDivideModuloExpression term = FACTORY.createMultiplyDivideModuloExpression();
        term.setLeftOperand(power(expression));
        return term;
    }

    /**
     * @return {@code left operator right}, e.g. {@code 2.0 / 4.0}.
     */
    static MultiplyDivideModuloExpression product(final ReadExpression left, final MultiplyDivideModuloOperator operator, final ReadExpression right) {
        final MultiplyDivideModuloExpression term = term(left);
        term.getOperators().add(operator);
        term.getOperands().add(power(right));
        return term;
    }

    /**
     * @return {@code left operator right}, e.g. {@code self.'c1' + self.'c2'}.
     */
    static AddOrSubtractExpression sum(final ReadExpression left, final AddOrSubtractOperator operator, final ReadExpression right) {
        final AddOrSubtractExpression sum = FACTORY.createAddOrSubtractExpression();
        sum.setLeftOperand(left instanceof MultiplyDivideModuloExpression t ? t : term(left));
        sum.getOperators().add(operator);
        sum.getOperands().add(right instanceof MultiplyDivideModuloExpression t ? t : term(right));
        return sum;
    }

    /**
     * @return {@code left operator right}, e.g. {@code self.'c1' + self.'c2' >= 4.0}.
     */
    static ComparisonExpression comparison(final AddOrSubtractExpression left, final ComparisonOperator operator, final ReadExpression right) {
        final AddOrSubtractExpression rightSum = FACTORY.createAddOrSubtractExpression();
        rightSum.setLeftOperand(term(right));

        final PartialComparisonExpression partial = FACTORY.createPartialComparisonExpression();
        partial.setOperator(operator);
        partial.setSubExpression(rightSum);

        final ComparisonExpression comparison = FACTORY.createComparisonExpression();
        comparison.setLeftOperand(left);
        comparison.getComparison().add(partial);
        return comparison;
    }
}
