package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

/**
 * Independent uniform random points in a box (DL type {@code 'random-points'}). Every
 *   coordinate is drawn from the random stream of the instance ({@link RandomStreams}).
 */
@Named(RandomPoints.NAME)
@Dependent
public class RandomPoints extends UniformPointSetBase {
    /**
     * The CDI name of the point set.
     */
    static final String NAME = "de.evoal.pipeline.distributions.random-points";

    /**
     * The random stream of this instance.
     */
    private RandomGenerator randomness;

    /**
     * Creates a point set that is configured by {@link #init(EObject)}.
     */
    public RandomPoints() {
    }

    /**
     * Creates a configured point set, e.g., for tests.
     *
     * @throws IllegalArgumentException if the bounds do not fit.
     */
    RandomPoints(final double [] lower, final double [] upper, final @NonNull RandomGenerator randomness) {
        configureBox(lower, upper);
        this.randomness = randomness;
    }

    @Override
    protected void configurePoints(final EObject configuration, final RandomGenerator randomness) {
        this.randomness = randomness;
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    protected String typeName() {
        return "random point set";
    }

    @Override
    protected int maximumDimension() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected double [] nextUnitPoint() {
        final double [] point = new double[dimension()];

        for(int j = 0; j < point.length; ++j) {
            point[j] = randomness.nextDouble();
        }

        return point;
    }
}
