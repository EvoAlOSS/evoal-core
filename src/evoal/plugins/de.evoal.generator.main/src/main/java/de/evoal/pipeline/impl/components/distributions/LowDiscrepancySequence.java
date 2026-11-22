package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.distribution.Randomisation;

/**
 * Base class of the low-discrepancy sequences (DL type {@code 'low-discrepancy-sequence'}).
 *   Each point is the next point of the sequence ({@link #next()}), randomised by the
 *   configured {@link Randomisation}, which the random stream of the instance drives.
 */
public abstract class LowDiscrepancySequence extends UniformPointSetBase {
    /**
     * The randomisation of the points.
     */
    private Randomisation randomisation;

    @Override
    protected void configurePoints(final EObject configuration, final RandomGenerator randomness) {
        configureSequence(BeanFactory.createComponentForAttribute(Randomisation.class, configuration, "randomisation"), randomness);
    }

    /**
     * Checks and sets the configuration and prepares the sequence and the randomisation, e.g.,
     *   for tests.
     *
     * @param lower The lower bounds (inclusive).
     * @param upper The upper bounds (exclusive).
     * @param randomisation The randomisation.
     * @param randomness The random stream of the instance.
     * @throws IllegalArgumentException if the bounds do not fit, the dimension is not supported or
     *   the sequence does not support the randomisation.
     */
    protected void configure(final double @NonNull [] lower, final double @NonNull [] upper, final @NonNull Randomisation randomisation,
                             final @NonNull RandomGenerator randomness) {
        configureBox(lower, upper);
        configureSequence(randomisation, randomness);
    }

    private void configureSequence(final @NonNull Randomisation randomisation, final @NonNull RandomGenerator randomness) {
        Requirements.requireTrue(supports(randomisation),
                "The " + typeName() + " does not support the randomisation " + randomisation.getClass().getSimpleName() + ".");

        this.randomisation = randomisation;

        start(dimension());
        randomisation.prepare(dimension(), randomness);
    }

    @Override
    protected double [] nextUnitPoint() {
        return randomisation.apply(next());
    }

    /**
     * Prepares the sequence. Called once, before the first point.
     *
     * @param dimension The dimension d, at most {@link #maximumDimension()}.
     */
    protected abstract void start(int dimension);

    /**
     * @return The next point of the sequence in [0, 1)^d, a new array.
     */
    protected abstract double [] next();

    /**
     * @param randomisation The randomisation of the configuration.
     * @return {@code true} if the sequence can be randomised this way.
     */
    protected abstract boolean supports(Randomisation randomisation);
}
