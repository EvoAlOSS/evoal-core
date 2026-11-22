package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.inject.Inject;

import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.distribution.Distribution;
import de.evoal.pipeline.api.distribution.Randomisation;

/**
 * Base class of the low-discrepancy sequences (DL type {@code 'low-discrepancy-sequence'}).
 *   Each {@link #sample()} takes the next point of the unit cube [0, 1)^d from the subclass
 *   ({@link #next()}), randomises it ({@link Randomisation}) and scales it to the box
 *   [lower, upper).
 * <p>
 * Every instance takes its own random stream ({@link RandomStreams}), also without
 *   randomisation, so the streams of the other instances do not depend on the chosen
 *   randomisations.
 */
public abstract class LowDiscrepancySequence implements Distribution {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The lower bounds (inclusive) of the box.
     */
    private double [] lower;

    /**
     * The randomisation of the points.
     */
    private Randomisation randomisation;

    @Inject
    private RandomStreams randomStreams;

    /**
     * The upper bounds (exclusive) of the box.
     */
    private double [] upper;

    @Override
    public LowDiscrepancySequence init(final EObject configuration) {
        final double [] lower = evaluator.attributeToDoubleArray(configuration, "lower");
        final double [] upper = evaluator.attributeToDoubleArray(configuration, "upper");
        final Randomisation randomisation = BeanFactory.createComponentForAttribute(Randomisation.class, configuration, "randomisation");

        configure(lower, upper, randomisation, randomStreams.forNewInstance(name()));

        return this;
    }

    /**
     * Checks and sets the configuration and prepares the sequence and the randomisation.
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
        final String type = typeName();
        Requirements.requireTrue(lower.length == upper.length,
                "The " + type + " has " + lower.length + " lower but " + upper.length + " upper bounds.");
        Requirements.requireTrue(lower.length >= 1 && lower.length <= maximumDimension(),
                "The " + type + " supports 1 to " + maximumDimension() + " dimensions, but has " + lower.length + ".");

        for(int j = 0; j < lower.length; ++j) {
            Requirements.requireTrue(lower[j] < upper[j],
                    "The lower bound of dimension " + j + " of the " + type + " (" + lower[j]
                    + ") has to be less than its upper bound (" + upper[j] + ").");
        }

        Requirements.requireTrue(supports(randomisation),
                "The " + type + " does not support the randomisation " + randomisation.getClass().getSimpleName() + ".");

        this.lower = lower.clone();
        this.upper = upper.clone();
        this.randomisation = randomisation;

        start(lower.length);
        randomisation.prepare(lower.length, randomness);
    }

    @Override
    public double [] sample() {
        final double [] point = randomisation.apply(next());

        for(int j = 0; j < point.length; ++j) {
            // the product can round up to the upper bound, which is excluded
            point[j] = Math.min(lower[j] + point[j] * (upper[j] - lower[j]), Math.nextDown(upper[j]));
        }

        return point;
    }

    /**
     * @return The CDI name of the sequence, which also names its random streams.
     */
    protected abstract String name();

    /**
     * @return The name of the sequence for messages, e.g., "Sobol' sequence".
     */
    protected abstract String typeName();

    /**
     * @return The largest dimension the sequence supports.
     */
    protected abstract int maximumDimension();

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
