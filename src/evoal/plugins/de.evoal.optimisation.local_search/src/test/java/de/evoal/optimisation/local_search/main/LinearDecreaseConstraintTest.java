package de.evoal.optimisation.local_search.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.core.main.validation.constraints.MultiVariateChecker;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.ol.OptimisationModule;

/**
 * The constraint of {@code 'linear-decrease'} (#255): its 10 {@code 'iterations'} must not exceed
 *   the {@code 'maximum-iterations'} of an {@code 'iteration-count'} that bounds the run, on the
 *   configurations of {@code de/evoal/optimisation/local_search/test/linear}.
 */
public class LinearDecreaseConstraintTest {
    private static ConstraintCheck check(final String configuration) {
        final OptimisationModule module = LanguageHelper.loadFromClasspath("de/evoal/optimisation/local_search/test/linear/"
                                                                           + configuration + ".ol");
        final Instance accepting = elementOf(module.getAlgorithm().findAttribute("accepting-strategy").getValue());
        final Instance decrease = elementOf(accepting.findAttribute("decreasing-function").getValue());
        final Instance constraint = elementOf(decrease.getDefinition().getConstraints().getFirst());
        final MultiVariateChecker checker = new MultiVariateChecker(constraint.findAttribute("expression").getValue());

        return checker.check(decrease);
    }

    private static Instance elementOf(final Expression expression) {
        return (Instance) ElementSwitch.elementOf(expression).orElseThrow();
    }

    @Test
    public void anIterationCountAtTheTopLevelBoundsTheIterations() {
        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check("top-level"));
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, check("equal"));
    }

    @Test
    public void anIterationCountInNestedAnyOfsBoundsTheIterations() {
        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check("nested-any-of"));
    }

    @Test
    public void anIterationCountInAnAllOfDoesNotBoundTheIterations() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, check("all-of"));
    }

    @Test
    public void withoutAnIterationCountAnyNumberOfIterationsIsAccepted() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, check("none"));
    }
}
