package de.evoal.core.main.ea.constraints.el;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DataReference;
import de.evoal.languages.model.ddl.SelfReference;
import de.evoal.languages.model.el.*;
import de.evoal.languages.model.el.util.ELSwitch;

import java.util.Objects;

public class DataReferenceSwitch extends ELSwitch<DataDescription> {
    @Override
    public DataDescription caseOrExpression(final OrExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public DataDescription caseXorExpression(final XorExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public DataDescription caseAndExpression(final AndExpression object) {
        Objects.equals(object.getSubExpressions().size(), 1);

        return this.doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public DataDescription caseNotExpression(final NotExpression object) {
        return this.doSwitch(object.getOperand());
    }

    @Override
    public DataDescription caseComparisonExpression(final ComparisonExpression object) {
        Objects.equals(object.getComparison().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public DataDescription caseAddOrSubtractExpression(AddOrSubtractExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public DataDescription caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public DataDescription casePowerOfExpression(PowerOfExpression object) {
        Objects.isNull(object.getRightOperand());

        return this.doSwitch(object.getLeftOperand());
    }

    @Override
    public DataDescription caseUnaryAddOrSubtractExpression(UnaryAddOrSubtractExpression object) {
        Objects.equals(object.getOperators().size(), 0);

        return this.doSwitch(object.getSubExpression());
    }
    /*
        @Override
        public DataDescription caseCallOrLiteralOrReferenceOrParantheses(CallOrLiteralOrReferenceOrParantheses object) {
            return super.caseCallOrLiteralOrReferenceOrParantheses(object);
        }
    */

    @Override
    public DataDescription caseIntegerLiteral(final IntegerLiteral object) {
        throw new IllegalStateException("Searching for Data but found a integer literal.");
    }

    @Override
    public DataDescription caseDoubleLiteral(final DoubleLiteral object) {
        throw new IllegalStateException("Searching for Data but found a double literal.");
    }

    @Override
    public DataDescription caseStringLiteral(StringLiteral object) {
        throw new IllegalStateException("Searching for Data but found a string literal.");
    }

    @Override
    public DataDescription caseBooleanLiteral(BooleanLiteral object) {
        throw new IllegalStateException("Searching for Data but found a boolean literal.");
    }

    @Override
    public DataDescription caseCall(final Call object) {
        throw new IllegalStateException("Searching for Data but found a call.");
    }

    @Override
    public DataDescription caseParantheses(Parantheses object) {
        return this.doSwitch(object.getSubExpression());
    }

    @Override
    public DataDescription caseValueReference(final ValueReference object) {
        if(object instanceof SelfReference) {
            throw  new IllegalStateException("Not yet implemented");
        } else {
            return ((DataReference)object).getDefinition();
        }
    }
}
