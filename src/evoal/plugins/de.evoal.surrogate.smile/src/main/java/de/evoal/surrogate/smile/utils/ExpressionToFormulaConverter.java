package de.evoal.surrogate.smile.utils;

import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import smile.data.formula.Formula;
import smile.data.formula.Term;
import smile.data.formula.Variable;

@Slf4j
public class ExpressionToFormulaConverter extends ExpressionsSwitch<Term> {
    public Formula convert(final Expression expression) {
        Term term = doSwitch(expression);

        return Formula.lhs(term);
    }

    @Override
    public Term caseOrExpression(final OrExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return caseXorExpression(object.getSubExpressions().get(0));
    }

    @Override
    public Term caseXorExpression(final XorExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return caseAndExpression(object.getSubExpressions().get(0));
    }

    @Override
    public Term caseAndExpression(final AndExpression object) {
        Requirements.requireSize(object.getSubExpressions(), 1);

        return caseNotExpression(object.getSubExpressions().get(0));
    }

    @Override
    public Term caseNotExpression(final NotExpression object) {
        Requirements.requireFalse(object.isNegated());

        return caseComparisonExpression(object.getOperand());
    }

    @Override
    public Term caseComparisonExpression(final ComparisonExpression object) {
        Requirements.requireEmpty(object.getComparison());

        return caseAddOrSubtractExpression(object.getLeftOperand());
    }

    @Override
    public Term caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Requirements.requireEmpty(object.getOperands());

        return caseMultiplyDivideModuloExpression(object.getLeftOperand());
    }

    @Override
    public Term caseMultiplyDivideModuloExpression(final MultiplyDivideModuloExpression object) {
        Requirements.requireEmpty(object.getOperands());

        return casePowerOfExpression(object.getLeftOperand());
    }

    @Override
    public Term casePowerOfExpression(final PowerOfExpression object) {
        Requirements.requireNull(object.getRightOperand());

        return caseUnaryAddOrSubtractExpression(object.getLeftOperand());
    }

    @Override
    public Term caseUnaryAddOrSubtractExpression(final UnaryAddOrSubtractExpression object) {
        Requirements.requireEmpty(object.getOperators());

        return doSwitch(object.getSubExpression());
    }

    @Override
    public Term caseTypeDefinitionReference(final TypeDefinitionReference object) {
        return  new Variable(object.getDefinition().getName());
    }

    @Override
    public Term defaultCase(final EObject object) {
        log.info("Visiting EObject of type {}.", object.eClass().getName());
        return super.defaultCase(object);
    }
}
