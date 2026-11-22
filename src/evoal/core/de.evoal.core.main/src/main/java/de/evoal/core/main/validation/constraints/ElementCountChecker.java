package de.evoal.core.main.validation.constraints;

import java.util.Collection;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Base class of the checkers of {@code @MinimumNumberOfElements} and
 *   {@code @MaximumNumberOfElements}: the number of elements of an array is compared with
 *   the {@code bound}.
 */
abstract class ElementCountChecker implements ConstraintCheckerComponent {
    @Inject
    private AttributeHelper helper;

    /**
     * The number of elements the array needs at least or may have at most.
     */
    private int bound;

    ElementCountChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    ElementCountChecker(final int bound) {
        this.bound = bound;
    }

    @Override
    public ConstraintCheckerComponent init(final EObject config) throws InitializationException {
        bound = helper.<Integer>lookup(config, "bound");

        return this;
    }

    @Override
    public ConstraintCheck check(final Object value) {
        if(!(value instanceof Collection<?> elements)) {
            return ConstraintCheck.notCheckable("its elements are only known during the run");
        }

        final int size = elements.size();
        if(violates(size, bound)) {
            return ConstraintCheck.violated("has " + size + (size == 1 ? " element" : " elements") + ", but " + requirement(bound));
        }

        return ConstraintCheck.satisfied();
    }

    /**
     * @return {@code true} if the number of elements violates the bound.
     */
    protected abstract boolean violates(final int size, final int bound);

    /**
     * @return The requirement for the message, e.g. "needs at least 1".
     */
    protected abstract String requirement(final int bound);
}
