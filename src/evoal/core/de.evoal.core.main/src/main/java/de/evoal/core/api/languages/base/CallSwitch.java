package de.evoal.core.api.languages.base;

import de.evoal.languages.model.base.*;
import de.evoal.languages.model.base.util.BaseSwitch;

import java.util.Objects;

public class CallSwitch extends BaseSwitch<Call> {
    @Override
    public Call caseOrExpression(final OrExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Call caseXorExpression(XorExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Call caseAndExpression(AndExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Call caseNotExpression(NotExpression object) {
        return this.doSwitch(object.getOperand());
    }

    @Override
    public Call caseComparisonExpression(ComparisonExpression object) {
        Objects.equals(object.getComparison().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Call caseAddOrSubtractExpression(AddOrSubtractExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Call caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Call casePowerOfExpression(PowerOfExpression object) {
        Objects.isNull(object.getRightOperand());

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Call caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getSubExpression());
    }
    /*
        @Override
        public String caseCallOrLiteralOrReferenceOrParantheses(CallOrLiteralOrReferenceOrParantheses object) {
            return super.caseCallOrLiteralOrReferenceOrParantheses(object);
        }
    */

    @Override
    public Call caseParantheses(Parantheses object) {
        return this.doSwitch(object.getSubExpression());
    }

    public Call caseCall(Call object) {
        return object;
    }
}