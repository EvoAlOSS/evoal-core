package de.evoal.core.main.validation.constraints;

import java.util.List;

import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.languages.model.base.definitions.Parameter;
import de.evoal.languages.model.base.definitions.ScaleType;

/**
 * The checkers of the annotated parameters of {@code de/evoal/core/test/parameters/functions.dl},
 *   configured by hand as the annotations state them, for tests outside this package.
 */
public final class TestCheckers {
    private TestCheckers() {
    }

    /**
     * @return The checkers of the parameter, as its annotations state them.
     * @throws IllegalArgumentException for a parameter that the test functions do not have.
     */
    private static List<ConstraintCheckerComponent> checkersOf(final Parameter parameter) {
        return switch(parameter.getName()) {
            case "feature" -> List.of(new RequiresScaleChecker(".", ScaleType.ORDINAL));
            case "weight" -> List.of(new LowerBoundaryChecker(0.0, true), new UpperBoundaryChecker(1.0, true));
            case "features" -> List.of(new MinimumNumberOfElementsChecker(2));
            default -> throw new IllegalArgumentException("Unknown test parameter '" + parameter.getName() + "'.");
        };
    }

    /**
     * @return The first violation of the value against the checkers of the parameter, or
     *   satisfied.
     */
    public static ConstraintCheck check(final Parameter parameter, final Object value) {
        for(final ConstraintCheckerComponent checker : checkersOf(parameter)) {
            final ConstraintCheck result = checker.check(value);
            if(!(result instanceof ConstraintCheck.Satisfied)) {
                return result;
            }
        }

        return ConstraintCheck.satisfied();
    }
}
