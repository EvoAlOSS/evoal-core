package de.evoal.optimisation.main.constraints.constraint.ast;

import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;
import de.evoal.languages.model.base.expressions.SelfReference;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.types.DefinitionReference;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class UnaryBoundaryIdentifier extends ExpressionsSwitch<Object> {
    private final DataDescription context;

    public UnaryBoundaryIdentifier(final DataDescription context) {
        this.context = context;
    }

    @Override
    public Object caseOrExpression(OrExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Object caseXorExpression(XorExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Object caseAndExpression(final AndExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Object caseNotExpression(NotExpression object) {
        Requirements.requireFalse(object.isNegated());

        return doSwitch(object.getOperand());
    }

    @Override
    public Object caseComparisonExpression(final ComparisonExpression object) {
        if(object.getComparison().isEmpty()) {
            return null;
        }

        Requirements.requireSize(object.getComparison(), 1);

        final Object leftValue = doSwitch(object.getLeftOperand());
        final Object rightValue = doSwitch(object.getComparison().get(0).getSubExpression());

        if(!((leftValue instanceof DataDescription && rightValue instanceof Number) ||
             (rightValue instanceof DataDescription && leftValue instanceof Number))) {
            // not a supported relation
            return Optional.empty();
        }

        final ComparisonOperator operator = object.getComparison().get(0).getOperator();

        if(ComparisonOperator.EQUAL.equals(operator) || ComparisonOperator.UNEQUAL.equals(operator)) {
            log.info("The (un)equal operator is not allowed as an boundary comparison.");
            return Optional.empty();
        }

        final boolean isLowerBoundary = ComparisonOperator.GREATER_EQUAL.equals(operator) || ComparisonOperator.GREATER_THAN.equals(operator);
        final DataDescription data = (DataDescription) (leftValue instanceof DataDescription ? leftValue : rightValue);
        final Number boundary = (Number) (leftValue instanceof Number ? leftValue : rightValue);
        final boolean inclusive = ComparisonOperator.GREATER_EQUAL.equals(operator) || ComparisonOperator.LESS_EQUAL.equals(operator);

        return Optional.of(new Boundary(isLowerBoundary, data, boundary, inclusive));
    }


    @Override
    public Object caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Requirements.requireEmpty(object.getOperators());
        return doSwitch(object.getLeftOperand());
    }

    @Override
    public Object caseMultiplyDivideModuloExpression(final MultiplyDivideModuloExpression object) {
        Requirements.requireEmpty(object.getOperators());
        return doSwitch(object.getLeftOperand());
    }

    @Override
    public Object casePowerOfExpression(final PowerOfExpression object) {
        Requirements.requireNull(object.getRightOperand());

        return doSwitch(object.getLeftOperand());
    }

    @Override
    public Object caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        Object value = doSwitch(object.getSubExpression());

        for(final AddOrSubtractOperator operator : object.getOperators()) {
            switch (operator) {
                case ADD: {
                    value = value;
                    break;
                }

                case SUBTRACT: {
                    if(value instanceof Double) {
                        value = -(Double)value;
                    } else if(value instanceof Integer) {
                        value = -(Integer)value;
                    } else {
                        throw new IllegalStateException("Unsupported");
                    }
                    break;
                }
            }
        }

        return value;
    }

    @Override
    public Object caseIntegerLiteral(final IntegerLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseRealLiteral(final RealLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseStringLiteral(final StringLiteral object) {
        return null;
    }

    @Override
    public Object caseValueReference(final ValueReference object) {
        if(object instanceof SelfReference) {
            Requirements.requireNotNull(context);
            return context;
        }

        if(!(object instanceof final DefinitionReference reference)) {
            throw new IllegalStateException("Value reference is not a data reference: " + object.eClass());
        }

        return reference.getDefinition();
    }

    @Override
    public Object caseParantheses(final Parantheses object) {
        return doSwitch(object.getSubExpression());
    }
}
