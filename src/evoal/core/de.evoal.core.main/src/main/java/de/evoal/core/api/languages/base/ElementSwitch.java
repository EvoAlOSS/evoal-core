package de.evoal.core.api.languages.base;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

import de.evoal.languages.model.base.expressions.AddOrSubtractExpression;
import de.evoal.languages.model.base.expressions.AndExpression;
import de.evoal.languages.model.base.expressions.ComparisonExpression;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression;
import de.evoal.languages.model.base.expressions.NotExpression;
import de.evoal.languages.model.base.expressions.OrExpression;
import de.evoal.languages.model.base.expressions.Parantheses;
import de.evoal.languages.model.base.expressions.PowerOfExpression;
import de.evoal.languages.model.base.expressions.ReadExpression;
import de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression;
import de.evoal.languages.model.base.expressions.XorExpression;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;

/**
 * Finds the single element of an expression without operators. The parser represents every
 *   expression as a chain with one level per operator precedence ({@code OrExpression} → … →
 *   {@code UnaryAddOrSubtractExpression} → element), also a plain element such as the instance
 *   in {@code document ['memory-model' {}]}. The switch follows the chain down to the element,
 *   also through parentheses, and finds nothing if one of the levels has an operator (e.g.
 *   {@code 1 + 2} or {@code -4}).
 */
public final class ElementSwitch extends ExpressionsSwitch<Optional<ReadExpression>> {
    private ElementSwitch() {
    }

    /**
     * @param expression An expression, e.g. an element of an array.
     * @return The element the expression consists of, or nothing if it has an operator.
     */
    public static Optional<ReadExpression> elementOf(final Expression expression) {
        return new ElementSwitch().doSwitch(expression);
    }

    private Optional<ReadExpression> onlyIf(final boolean withoutOperator, final EObject next) {
        if(!withoutOperator) {
            return Optional.empty();
        }

        return doSwitch(next);
    }

    @Override
    public Optional<ReadExpression> caseOrExpression(final OrExpression object) {
        final boolean withoutOperator = object.getSubExpressions().size() == 1;

        return onlyIf(withoutOperator, object.getSubExpressions().getFirst());
    }

    @Override
    public Optional<ReadExpression> caseXorExpression(final XorExpression object) {
        final boolean withoutOperator = object.getSubExpressions().size() == 1;

        return onlyIf(withoutOperator, object.getSubExpressions().getFirst());
    }

    @Override
    public Optional<ReadExpression> caseAndExpression(final AndExpression object) {
        final boolean withoutOperator = object.getSubExpressions().size() == 1;

        return onlyIf(withoutOperator, object.getSubExpressions().getFirst());
    }

    @Override
    public Optional<ReadExpression> caseNotExpression(final NotExpression object) {
        return onlyIf(!object.isNegated(), object.getOperand());
    }

    @Override
    public Optional<ReadExpression> caseComparisonExpression(final ComparisonExpression object) {
        return onlyIf(object.getComparison().isEmpty(), object.getLeftOperand());
    }

    @Override
    public Optional<ReadExpression> caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        return onlyIf(object.getOperators().isEmpty(), object.getLeftOperand());
    }

    @Override
    public Optional<ReadExpression> caseMultiplyDivideModuloExpression(final MultiplyDivideModuloExpression object) {
        return onlyIf(object.getOperators().isEmpty(), object.getLeftOperand());
    }

    @Override
    public Optional<ReadExpression> casePowerOfExpression(final PowerOfExpression object) {
        return onlyIf(object.getRightOperand() == null, object.getLeftOperand());
    }

    @Override
    public Optional<ReadExpression> caseUnaryAddOrSubtractExpression(final UnaryAddOrSubtractExpression object) {
        return onlyIf(object.getOperators().isEmpty(), object.getSubExpression());
    }

    @Override
    public Optional<ReadExpression> caseParantheses(final Parantheses object) {
        return doSwitch(object.getSubExpression());
    }

    @Override
    public Optional<ReadExpression> caseReadExpression(final ReadExpression object) {
        return Optional.of(object);
    }

    @Override
    public Optional<ReadExpression> defaultCase(final EObject object) {
        return Optional.empty();
    }
}
