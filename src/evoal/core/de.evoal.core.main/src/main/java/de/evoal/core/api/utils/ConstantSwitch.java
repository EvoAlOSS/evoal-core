package de.evoal.core.api.utils;

import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;
import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;

public class ConstantSwitch extends ExpressionsSwitch<Object> {
    private ConstantSwitch() {
    }

    @Override
    public Object caseOrExpression(final OrExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Object caseXorExpression(XorExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Object caseAndExpression(AndExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Object caseNotExpression(NotExpression object) {
        return this.doSwitch(object.getOperand());
    }

    @Override
    public Object caseComparisonExpression(ComparisonExpression object) {
        Requirements.requireSize(object.getComparison(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Object caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Requirements.requireSize(object.getOperators(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Object caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        Requirements.requireSize(object.getOperators(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Object casePowerOfExpression(PowerOfExpression object) {
        Requirements.requireNull(object.getRightOperand());

        return this.doSwitch(object.getLeftOperand());
    }

    /**
     * Applies the signs to the constant: numbers have no sign of their own, so {@code -4} is a
     *   unary minus applied to 4; each minus negates the value, a plus keeps it.
     */
    @Override
    public Object caseUnaryAddOrSubtractExpression(final UnaryAddOrSubtractExpression object) {
        Object value = this.doSwitch(object.getSubExpression());

        for(final AddOrSubtractOperator operator : object.getOperators()) {
            if(AddOrSubtractOperator.SUBTRACT.equals(operator)) {
                value = ArithmeticNumberOperations.multiply(value, -1);
            }
        }

        return value;
    }
    /*
        @Override
        public Object caseCallOrLiteralOrReferenceOrParantheses(CallOrLiteralOrReferenceOrParantheses object) {
            return super.caseCallOrLiteralOrReferenceOrParantheses(object);
        }
    */

    @Override
    public Object caseIntegerLiteral(final IntegerLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseRealLiteral(final RealLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseStringLiteral(StringLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseBooleanLiteral(BooleanLiteral object) {
        return object.isLiteral();
    }

    @Override
    public Object caseCall(final Call object) {
        throw new IllegalStateException("Searching for Object but found a call.");
    }

    @Override
    public Object caseParantheses(Parantheses object) {
        return this.doSwitch(object.getSubExpression());
    }

    public static Object findConstant(final Expression expression) {
        return new ConstantSwitch().doSwitch(expression);
    }
}
