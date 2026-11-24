package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.inject.Inject;

import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.distribution.UniformPointSet;

/**
 * Base class of the uniform point sets (DL type {@code 'uniform-point-set'}). It reads and
 *   checks the box [lower, upper), takes the next point of the unit cube [0, 1)^d from the
 *   subclass ({@link #nextUnitPoint()}) and scales it to the box.
 * <p>
 * Every instance takes its own random stream ({@link RandomStreams}), even if it does not
 *   draw from it, so the streams of the other instances do not depend on its configuration.
 */
public abstract class UniformPointSetBase implements UniformPointSet {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The lower bounds (inclusive) of the box.
     */
    private double [] lower;

    @Inject
    private RandomStreams randomStreams;

    /**
     * The upper bounds (exclusive) of the box.
     */
    private double [] upper;

    @Override
    public UniformPointSetBase init(final EObject configuration) {
        final double [] lower = evaluator.attributeToDoubleArray(configuration, "lower");
        final double [] upper = evaluator.attributeToDoubleArray(configuration, "upper");

        configureBox(lower, upper);
        configurePoints(configuration, randomStreams.forNewInstance(name()));

        return this;
    }

    /**
     * Checks and sets the box.
     *
     * @param lower The lower bounds (inclusive).
     * @param upper The upper bounds (exclusive).
     * @throws IllegalArgumentException if the bounds do not fit or the dimension is not supported.
     */
    protected void configureBox(final double @NonNull [] lower, final double @NonNull [] upper) {
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

        this.lower = lower.clone();
        this.upper = upper.clone();
    }

    /**
     * @return The dimension d of the points, known after {@link #configureBox(double[], double[])}.
     */
    @Override
    public int dimension() {
        return lower.length;
    }

    @Override
    public double [] lower() {
        return lower.clone();
    }

    @Override
    public double [] upper() {
        return upper.clone();
    }

    @Override
    public double [] sample() {
        final double [] point = nextUnitPoint();

        for(int j = 0; j < point.length; ++j) {
            // the product can round up to the upper bound, which is excluded
            point[j] = Math.min(lower[j] + point[j] * (upper[j] - lower[j]), Math.nextDown(upper[j]));
        }

        return point;
    }

    /**
     * Reads the rest of the configuration and prepares the points. Called once, after
     *   {@link #configureBox(double[], double[])}.
     *
     * @param configuration The configuration of the point set.
     * @param randomness The random stream of the instance.
     */
    protected abstract void configurePoints(EObject configuration, RandomGenerator randomness);

    /**
     * @return The CDI name of the point set, which also names its random streams.
     */
    protected abstract String name();

    /**
     * @return The name of the point set for messages, e.g., "Sobol' sequence".
     */
    protected abstract String typeName();

    /**
     * @return The largest dimension the point set supports.
     */
    protected abstract int maximumDimension();

    /**
     * @return The next point in [0, 1)^d, a new array.
     */
    protected abstract double [] nextUnitPoint();
}
