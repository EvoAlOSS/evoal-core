package de.evoal.optimisation.api.constraints;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Base class of the measures: reads the {@code 'equality-tolerance'} of the base type
 *   {@code 'constraint-measure'} and computes the degree of violation from the value g of the
 *   normal form: max(0, -g) for an inequality, max(0, |g| - tolerance) for an equality.
 *   Subclasses read their own attributes in {@link #configure(EObject)}.
 */
public abstract class AbstractConstraintMeasure implements ConstraintMeasure {
    /**
     * The deviation up to which an equality counts as satisfied.
     */
    private double equalityTolerance;

    @Inject
    private AttributeHelper helper;

    /**
     * Creates a measure that is configured by {@link #init(EObject)}.
     */
    protected AbstractConstraintMeasure() {
    }

    /**
     * Creates a configured measure, e.g., for tests.
     *
     * @param equalityTolerance The deviation up to which an equality counts as satisfied.
     * @throws IllegalArgumentException if the tolerance is negative.
     */
    protected AbstractConstraintMeasure(final double equalityTolerance) {
        this.equalityTolerance = requireTolerance(equalityTolerance);
    }

    /**
     * Reads the attributes of the measure type.
     *
     * @param configuration The configuration of the measure.
     * @throws InitializationException if the configuration cannot be used.
     */
    protected abstract void configure(EObject configuration) throws InitializationException;

    /**
     * @param constraint The constraint.
     * @param value The value g of its normal form.
     * @return The degree of violation: max(0, -g) for an inequality, max(0, |g| - tolerance)
     *   for an equality.
     */
    protected final double degreeOf(final Constraint constraint, final double value) {
        if(Double.isNaN(value)) {
            throw new IllegalStateException("The constraint '" + constraint.text() + "' has no value (NaN).");
        }

        return switch(constraint.kind()) {
            case INEQUALITY -> Math.max(0.0, -value);
            case EQUALITY -> Math.max(0.0, Math.abs(value) - equalityTolerance);
        };
    }

    /**
     * @return The deviation up to which an equality counts as satisfied.
     */
    public double equalityTolerance() {
        return equalityTolerance;
    }

    @Override
    public final ConstraintMeasure init(final EObject configuration) throws InitializationException {
        final double configuredTolerance = helper.<Number>lookup(configuration, "equality-tolerance")
                                                 .doubleValue();

        try {
            equalityTolerance = requireTolerance(configuredTolerance);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage());
        }

        configure(configuration);

        return this;
    }

    private static double requireTolerance(final double tolerance) {
        // also rejects NaN
        if(!(tolerance >= 0.0)) {
            throw new IllegalArgumentException("The 'equality-tolerance' must not be negative, but is " + tolerance
                                               + ".");
        }

        return tolerance;
    }
}
