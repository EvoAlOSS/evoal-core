package de.evoal.core.main.ea.constraints.el;

import de.evoal.languages.model.ddl.DataReference;
import de.evoal.languages.model.el.*;
import de.evoal.languages.model.el.util.ELSwitch;

import java.util.Objects;

public class ValueReferenceSwitch extends ELSwitch<String> {
    @Override
    public String caseOrExpression(final OrExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public String caseXorExpression(XorExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public String caseAndExpression(AndExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public String caseNotExpression(NotExpression object) {
        return this.doSwitch(object.getOperand());
    }

    @Override
    public String caseComparisonExpression(ComparisonExpression object) {
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
        throw new IllegalStateException("Searching for a value reference but found a integer literal.");
    }

    @Override
    public String caseDoubleLiteral(final DoubleLiteral object) {
        throw new IllegalStateException("Searching for a value reference but found a double literal.");
    }

    @Override
    public String caseStringLiteral(StringLiteral object) {
        throw new IllegalStateException("Searching for a value reference but found a string literal.");
    }

    @Override
    public String caseBooleanLiteral(BooleanLiteral object) {
        throw new IllegalStateException("Searching for a value reference but found a boolean literal.");
    }

    @Override
    public String caseCall(final Call object) {
        throw new IllegalStateException("Searching for a value reference but found a call.");
    }

    @Override
    public String caseParantheses(Parantheses object) {
        return this.doSwitch(object.getSubExpression());
    }

    @Override
    public String caseValueReference(final ValueReference object) {
        if(!(object instanceof DataReference)) {
            throw new IllegalStateException("Value reference is not a data reference.");
        }

        final DataReference reference = (DataReference)object;
        return reference.getDefinition().getName();
    }
}