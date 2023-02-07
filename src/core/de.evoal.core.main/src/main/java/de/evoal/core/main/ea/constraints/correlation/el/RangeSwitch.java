package de.evoal.core.main.ea.constraints.correlation.el;

import de.evoal.core.main.ea.constraints.el.ElHelper;
import de.evoal.core.api.ea.correlations.Range;
import de.evoal.languages.model.el.*;
import de.evoal.languages.model.el.util.ELSwitch;

import java.util.Objects;

public class RangeSwitch extends ELSwitch<Range> {
    @Override
    public Range caseOrExpression(final OrExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Range caseXorExpression(final XorExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Range caseAndExpression(final AndExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Range caseNotExpression(final NotExpression object) {
        return this.doSwitch(object.getOperand());
    }

    @Override
    public Range caseComparisonExpression(final ComparisonExpression object) {
        Objects.equals(object.getComparison().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Range caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Range caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Range casePowerOfExpression(PowerOfExpression object) {
        Objects.isNull(object.getRightOperand());

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public Range caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getSubExpression());
    }
    /*
        @Override
        public Range caseCallOrLiteralOrReferenceOrParantheses(CallOrLiteralOrReferenceOrParantheses object) {
            return super.caseCallOrLiteralOrReferenceOrParantheses(object);
        }
    */

    @Override
    public Range caseIntegerLiteral(final IntegerLiteral object) {
        throw new IllegalStateException("Searching for Range but found a integer literal.");
    }

    @Override
    public Range caseDoubleLiteral(final DoubleLiteral object) {
        throw new IllegalStateException("Searching for range but found a double literal.");
    }

    @Override
    public Range caseStringLiteral(StringLiteral object) {
        throw new IllegalStateException("Searching for Range but found a string literal.");
    }

    @Override
    public Range caseBooleanLiteral(BooleanLiteral object) {
        throw new IllegalStateException("Searching for Range but found a boolean literal.");
    }

    @Override
    public Range caseCall(final Call object) {
        final de.evoal.languages.model.ol.FunctionName calledFunction = (de.evoal.languages.model.ol.FunctionName)object.getFunction();
        if(!"range".equals(calledFunction.getDefinition().getName())) {
            throw new IllegalStateException("Searching for range but found: " + calledFunction.getDefinition().getName());
        }

        Objects.equals(object.getParameters().size(), 2);

        final Number lowerBound = ElHelper.findNumber(object.getParameters().get(0));
        final Number upperBound = ElHelper.findNumber(object.getParameters().get(1));

        final Range result = new Range();
        result.setLower(lowerBound.doubleValue());
        result.setUpper(upperBound.doubleValue());

        return result;
    }

    @Override
    public Range caseParantheses(Parantheses object) {
        return this.doSwitch(object.getSubExpression());
    }
}
