package de.evoal.core.main.validation.constraints;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

/**
 * Checks {@code @LowerBoundary}: a valid value is {@code >= boundary} if the boundary is
 *   inclusive, otherwise {@code > boundary}.
 */
@Dependent
@Named("de.evoal.core.constraints.LowerBoundary")
public class LowerBoundaryChecker extends BoundaryChecker {
    public LowerBoundaryChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    LowerBoundaryChecker(final Number boundary, final boolean inclusive) {
        super(boundary, inclusive);
    }

    @Override
    protected boolean violates(final double value, final double boundary, final boolean inclusive) {
        return inclusive ? value < boundary : value <= boundary;
    }

    @Override
    protected String operator(final boolean inclusive) {
        return inclusive ? ">=" : ">";
    }
}
