package de.evoal.core.api.utils;

import de.evoal.languages.model.base.*;
import de.evoal.languages.model.base.util.BaseSwitch;


import java.util.Objects;

public class ConstantSwitch extends BaseSwitch<Object> {
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

    @Override
    public Object caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        Requirements.requireSize(object.getOperators(), 0);

        Object Object = this.doSwitch(object.getSubExpression());

        /*
        for(final AddOrSubtractOperator aso : object.getOperators()) {
            if(AddOrSubtractOperator.ADD.equals(aso)) {
                continue;
            }

            if(Object instanceof Integer) {
                Object = Math.negateExact(Object.intValue());
            } else if(Object instanceof Double) {
                Object = -Object.doubleValue();
            }
        }
         */

        return Object;
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
    public Object caseDoubleLiteral(final DoubleLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseStringLiteral(StringLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseBooleanLiteral(BooleanLiteral object) {
        return object.isValue();
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
