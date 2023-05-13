package de.evoal.core.main.constraints.el;

import de.evoal.languages.model.base.*;
import de.evoal.languages.model.base.util.BaseSwitch;

import java.util.Objects;

public class NumberSwitch extends BaseSwitch<Number> {
    @Override
    public Number caseOrExpression(final OrExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Number caseXorExpression(XorExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Number caseAndExpression(AndExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Number caseNotExpression(NotExpression object) {
        return this.doSwitch(object.getOperand());
    }

    @Override
    public Number caseComparisonExpression(ComparisonExpression object) {
        Objects.equals(object.getComparison().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Number caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Number caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Number casePowerOfExpression(PowerOfExpression object) {
        Objects.isNull(object.getRightOperand());

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Number caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        Number number = this.doSwitch(object.getSubExpression());

        for(final AddOrSubtractOperator aso : object.getOperators()) {
            if(AddOrSubtractOperator.ADD.equals(aso)) {
                continue;
            }

            if(number instanceof Integer) {
                number = Math.negateExact(number.intValue());
            } else if(number instanceof Double) {
                number = -number.doubleValue();
            }
        }

        return number;
    }
    /*
        @Override
        public Number caseCallOrLiteralOrReferenceOrParantheses(CallOrLiteralOrReferenceOrParantheses object) {
            return super.caseCallOrLiteralOrReferenceOrParantheses(object);
        }
    */

    @Override
    public Number caseIntegerLiteral(final IntegerLiteral object) {
        return object.getValue();
    }

    @Override
    public Number caseRealLiteral(final RealLiteral object) {
        return object.getValue();
    }

    @Override
    public Number caseStringLiteral(StringLiteral object) {
        throw new IllegalStateException("Searching for number but found a string literal.");
    }

    @Override
    public Number caseBooleanLiteral(BooleanLiteral object) {
        throw new IllegalStateException("Searching for number but found a boolean literal.");
    }

    @Override
    public Number caseCall(final Call object) {
        throw new IllegalStateException("Searching for number but found a call.");
    }

    @Override
    public Number caseParantheses(Parantheses object) {
        return this.doSwitch(object.getSubExpression());
    }
}
