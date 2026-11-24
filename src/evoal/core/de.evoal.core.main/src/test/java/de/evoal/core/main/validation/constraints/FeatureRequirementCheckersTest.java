package de.evoal.core.main.validation.constraints;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.ol.OptimisationModule;

/**
 * The checkers of {@code @RequiresScale}, {@code @RequiresRepresentation} and
 *   {@code @RequiresBoundaries} on {@code configuration.ol} in {@code de/evoal/core/test/paths}:
 *   the search variables x and y of the problem are quotient real data without boundaries; the
 *   'others' are 'bounded' (both sides), 'positive' (lower only) and 'colour' (nominal integer).
 */
public class FeatureRequirementCheckersTest {
    private static final String OTHERS = "../others";

    private static final String SEARCH_VARIABLES = "/algorithm/problem/searchSpace";

    private final OptimisationModule module = LanguageHelper.loadFromClasspath("de/evoal/core/test/paths/configuration.ol");

    private final Instance mover = (Instance) ElementSwitch.elementOf(module.getAlgorithm().findAttribute("mover").getValue())
                                                           .orElseThrow();

    private static void assertViolated(final ConstraintCheck check, final String message) {
        final ConstraintCheck.Violated violated = Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check);

        Assertions.assertEquals(message, violated.message());
    }

    @Test
    public void aBoundaryOnOneSideIsEnoughIfOnlyThatSideIsRequired() {
        // 'positive' passes with only a lower boundary, so 'colour' is the first violation
        assertViolated(new RequiresBoundariesChecker(OTHERS, true, true).check(mover),
                       "needs a lower and an upper boundary for its data, but 'positive' has no upper boundary");
        assertViolated(new RequiresBoundariesChecker(OTHERS, true, false).check(mover),
                       "needs a lower boundary for its data, but 'colour' has no lower boundary");
    }

    @Test
    public void dataWithoutBoundariesIsRejected() {
        assertViolated(new RequiresBoundariesChecker(SEARCH_VARIABLES, true, true).check(mover),
                       "needs a lower and an upper boundary for its data, but 'x' has neither a lower nor an upper boundary");
    }

    @Test
    public void onlyDataCanBeSelected() {
        final ConstraintCheck check = new RequiresScaleChecker("../swarm", ScaleType.NOMINAL).check(mover);
        final ConstraintCheck.Violated violated = Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check);

        Assertions.assertTrue(violated.message().contains("which is no data"), violated.message());
    }

    @Test
    public void representationsAreCompared() {
        final RequiresRepresentationChecker real = new RequiresRepresentationChecker(SEARCH_VARIABLES, List.of(RepresentationType.REAL));
        final RequiresRepresentationChecker realOrInteger = new RequiresRepresentationChecker(OTHERS, List.of(RepresentationType.REAL,
                                                                                                                RepresentationType.INTEGER));

        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, real.check(mover));
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, realOrInteger.check(mover));
        assertViolated(new RequiresRepresentationChecker(OTHERS, List.of(RepresentationType.REAL)).check(mover),
                       "needs real data, but 'colour' is integer data");
    }

    @Test
    public void scalesAreComparedInTheirOrder() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class,
                                    new RequiresScaleChecker(SEARCH_VARIABLES, ScaleType.QUOTIENT).check(mover));
        assertViolated(new RequiresScaleChecker(OTHERS, ScaleType.CARDINAL).check(mover),
                       "needs data of at least cardinal scale, but 'colour' is nominal");
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, new RequiresScaleChecker(OTHERS, ScaleType.NOMINAL).check(mover));
    }

    @Test
    public void anEmptySelectionMeetsEveryRequirement() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class,
                                    new RequiresBoundariesChecker("../unknown", true, true).check(mover));
    }
}
