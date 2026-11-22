package de.evoal.core.main.validation.constraints;

import java.util.Collection;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Base class of the checkers of {@code @LowerBoundary} and {@code @UpperBoundary}: a number
 *   is compared with the {@code boundary}, which is included if {@code inclusive} is set. For
 *   an array, every element is checked (also of nested arrays).
 */
abstract class BoundaryChecker implements ConstraintCheckerComponent {
    @Inject
    private AttributeHelper helper;

    /**
     * The boundary as written in the annotation, e.g. {@code 0} or {@code 1.0}.
     */
    private Number boundary;

    /**
     * Whether the boundary itself is allowed.
     */
    private boolean inclusive;

    BoundaryChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    BoundaryChecker(final Number boundary, final boolean inclusive) {
        this.boundary = boundary;
        this.inclusive = inclusive;
    }

    @Override
    public ConstraintCheckerComponent init(final EObject config) throws InitializationException {
        final Object value = helper.lookup(config, "boundary");
        if(!(value instanceof Number number)) {
            throw new InitializationException("The boundary of a boundary annotation has to be a number, but is '" + value + "'.");
        }

        boundary = number;
        inclusive = helper.<Boolean>lookup(config, "inclusive");

        return this;
    }

    @Override
    public ConstraintCheck check(final Object value) {
        return check(value, "");
    }

    private ConstraintCheck check(final Object value, final String element) {
        if(value instanceof Collection<?> elements) {
            int index = 0;
            for(final Object child : elements) {
                final ConstraintCheck result = check(child, element + "[" + index++ + "]");
                if(!(result instanceof ConstraintCheck.Satisfied)) {
                    return result;
                }
            }
            return ConstraintCheck.satisfied();
        }

        if(!(value instanceof Number number)) {
            return ConstraintCheck.notCheckable("its value is only known during the run");
        }

        final double actual = number.doubleValue();
        if(Double.isNaN(actual) || violates(actual, boundary.doubleValue(), inclusive)) {
            final String subject = element.isEmpty() ? "is " : "has the element " + element + " = ";
            return ConstraintCheck.violated(subject + number + ", but must be " + operator(inclusive) + " " + boundary);
        }

        return ConstraintCheck.satisfied();
    }

    /**
     * @return {@code true} if the value lies on the wrong side of the boundary.
     */
    protected abstract boolean violates(final double value, final double boundary, final boolean inclusive);

    /**
     * @return The comparison a valid value satisfies, e.g. {@code >=}.
     */
    protected abstract String operator(final boolean inclusive);
}
