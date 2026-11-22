package de.evoal.core.main.validation.constraints;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

/**
 * Checks {@code @MaximumNumberOfElements}: an array has at most {@code bound} elements.
 */
@Dependent
@Named("de.evoal.core.constraints.MaximumNumberOfElements")
public class MaximumNumberOfElementsChecker extends ElementCountChecker {
    public MaximumNumberOfElementsChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    MaximumNumberOfElementsChecker(final int bound) {
        super(bound);
    }

    @Override
    protected boolean violates(final int size, final int bound) {
        return size > bound;
    }

    @Override
    protected String requirement(final int bound) {
        return "may have at most " + bound;
    }
}
