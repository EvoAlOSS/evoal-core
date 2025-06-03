package de.evoal.core.api.languages.base;

import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;

import java.util.Objects;

public class StringSwitch extends ExpressionsSwitch<String> {
    @Override
    public String caseOrExpression(final OrExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public String caseXorExpression(final XorExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public String caseAndExpression(final AndExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public String caseNotExpression(final NotExpression object) {
        return this.doSwitch(object.getOperand());
    }

    @Override
    public String caseComparisonExpression(final ComparisonExpression object) {
        Objects.equals(object.getComparison().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public String caseAddOrSubtractExpression(AddOrSubtractExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public String caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public String casePowerOfExpression(PowerOfExpression object) {
        Objects.isNull(object.getRightOperand());

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public String caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
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
    public String caseIntegerLiteral(final IntegerLiteral object) {
        throw new IllegalStateException("Searching for String but found a integer literal.");
    }

    @Override
    public String caseRealLiteral(final RealLiteral object) {
        throw new IllegalStateException("Searching for String but found a double literal.");
    }

    @Override
    public String caseStringLiteral(StringLiteral object) {
        return object.getLiteral();
    }

    @Override
    public String caseBooleanLiteral(BooleanLiteral object) {
        throw new IllegalStateException("Searching for String but found a boolean literal.");
    }

    @Override
    public String caseCall(final Call object) {
        throw new IllegalStateException("Searching for String but found a call.");
    }

    @Override
    public String caseParantheses(Parantheses object) {
        return this.doSwitch(object.getSubExpression());
    }
}
