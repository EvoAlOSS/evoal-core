package de.evoal.core.main.validation.constraints;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

/**
 * Checks {@code @UpperBoundary}: a valid value is {@code <= boundary} if the boundary is
 *   inclusive, otherwise {@code < boundary}.
 */
@Dependent
@Named("de.evoal.core.constraints.UpperBoundary")
public class UpperBoundaryChecker extends BoundaryChecker {
    public UpperBoundaryChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    UpperBoundaryChecker(final Number boundary, final boolean inclusive) {
        super(boundary, inclusive);
    }

    @Override
    protected boolean violates(final double value, final double boundary, final boolean inclusive) {
        return inclusive ? value > boundary : value >= boundary;
    }

    @Override
    protected String operator(final boolean inclusive) {
        return inclusive ? "<=" : "<";
    }
}
