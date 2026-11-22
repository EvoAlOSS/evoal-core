package de.evoal.core.main.validation.constraints;

import static de.evoal.core.main.validation.constraints.Expressions.integer;
import static de.evoal.core.main.validation.constraints.Expressions.product;
import static de.evoal.core.main.validation.constraints.Expressions.real;
import static de.evoal.core.main.validation.constraints.Expressions.term;
import static de.evoal.core.main.validation.constraints.Expressions.unary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.languages.model.base.definitions.ConstantDefinition;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.expressions.AddOrSubtractOperator;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;
import de.evoal.languages.model.interpreter.ConstantEvaluator;

/**
 * Tests the checks on values as the {@link de.evoal.core.main.validation.ConstraintValidator}
 *   computes them ({@link ConstantEvaluator}): formulas are evaluated, not read from their
 *   leftmost literal.
 */
public class ComputedValuesTest {
    private static ConstraintCheck check(final BoundaryChecker checker, final Expression value) {
        return checker.check(new ConstantEvaluator().doSwitch(value));
    }

    @Test
    public void aDivisionIsCheckedByItsResult() {
        // 2.0 / 4.0 = 0.5 (the former checker read 2.0)
        final Expression half = product(real(2.0), MultiplyDivideModuloOperator.DIVIDE, real(4.0));

        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, check(new UpperBoundaryChecker(1.0, true), half));
        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check(new UpperBoundaryChecker(0.4, true), half));
    }

    @Test
    public void aSignIsKept() {
        // - 0.5 (the former checker read 0.5)
        final Expression negative = term(unary(real(0.5), AddOrSubtractOperator.SUBTRACT));

        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check(new LowerBoundaryChecker(0.0, true), negative));
    }

    @Test
    public void aSmallFractionIsAccepted() {
        // 1.0 / 30.0, as in the regressions
        final Expression fraction = product(real(1.0), MultiplyDivideModuloOperator.DIVIDE, real(30.0));

        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, check(new LowerBoundaryChecker(0.0, false), fraction));
    }

    @Test
    public void aDivisionOfIntegersIsCheckedByItsRealResult() {
        // 1 / 5 = 0.2, also with integers (#332), so an exclusive lower bound of 0 accepts it
        final Expression fifth = product(integer(1), MultiplyDivideModuloOperator.DIVIDE, integer(5));

        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, check(new LowerBoundaryChecker(0.0, false), fifth));
        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check(new UpperBoundaryChecker(0.1, true), fifth));
    }

    @Test
    public void aConstantIsCheckedByItsValue() {
        final ConstantDefinition constant = DefinitionsFactory.eINSTANCE.createConstantDefinition();
        constant.setName("rate");
        constant.setValue(term(real(1.5)));

        final ValueDefinitionReference reference = ExpressionsFactory.eINSTANCE.createValueDefinitionReference();
        reference.setDefinition(constant);

        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check(new UpperBoundaryChecker(1.0, true), term(reference)));
    }
}
