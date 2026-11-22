package de.evoal.core.main.validation.constraints;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

/**
 * Checks {@code @MinimumNumberOfElements}: an array has at least {@code bound} elements.
 */
@Dependent
@Named("de.evoal.core.constraints.MinimumNumberOfElements")
public class MinimumNumberOfElementsChecker extends ElementCountChecker {
    public MinimumNumberOfElementsChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    MinimumNumberOfElementsChecker(final int bound) {
        super(bound);
    }

    @Override
    protected boolean violates(final int size, final int bound) {
        return size < bound;
    }

    @Override
    protected String requirement(final int bound) {
        return "needs at least " + bound;
    }
}
