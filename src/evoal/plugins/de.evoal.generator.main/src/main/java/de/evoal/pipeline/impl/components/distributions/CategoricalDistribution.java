package de.evoal.pipeline.impl.components.distributions;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.Requirements;

/**
 * Categorical distribution: the i-th of the {@code values} with the i-th of the
 *   {@code probabilities}. The quantile follows the order of the list, not the order of the
 *   values: it is the first value whose cumulative probability reaches p.
 */
@Named(CategoricalDistribution.NAME)
@Dependent
public class CategoricalDistribution extends DiscreteDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.categorical-distribution";

    /**
     * How far the sum of the probabilities may differ from 1.
     */
    static final double SUM_TOLERANCE = 1e-9;

    /**
     * The cumulative probabilities in the order of the list; the last one is 1.
     */
    private double [] cumulative;

    /**
     * The values.
     */
    private int [] values;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public CategoricalDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if the arrays differ in length, a probability is
     *   negative, or the probabilities do not sum to 1.
     */
    CategoricalDistribution(final int [] values, final double [] probabilities, final RandomGenerator randomness) {
        super(randomness);
        configure(values, probabilities);
    }

    @Override
    protected void configure(final EObject configuration) {
        final List<Number> values = lookup(configuration, "values");
        final List<Number> probabilities = lookup(configuration, "probabilities");

        configure(values.stream().mapToInt(Number::intValue).toArray(),
                  probabilities.stream().mapToDouble(Number::doubleValue).toArray());
    }

    private void configure(final int [] values, final double [] probabilities) {
        Requirements.requireTrue(values.length == probabilities.length,
                "The categorical distribution has " + values.length + " values but " + probabilities.length
                + " probabilities; it needs one probability per value.");
        Requirements.requireTrue(values.length > 0, "The categorical distribution needs at least one value.");
        Requirements.requireTrue(Arrays.stream(probabilities).allMatch(p -> p >= 0.0),
                "The probabilities of the categorical distribution have to be non-negative, but are "
                + Arrays.toString(probabilities) + ".");

        final double sum = Arrays.stream(probabilities).sum();
        Requirements.requireTrue(Math.abs(sum - 1.0) <= SUM_TOLERANCE,
                "The probabilities of the categorical distribution have to sum to 1, but sum to " + sum + ".");

        this.values = values.clone();
        cumulative = new double[probabilities.length];
        double running = 0.0;
        for(int i = 0; i < probabilities.length; ++i) {
            running += probabilities[i];
            cumulative[i] = running / sum;
        }
        cumulative[cumulative.length - 1] = 1.0;
    }

    @Override
    protected String name() {
        return NAME;
    }

    /**
     * @return true, the values name categories.
     */
    @Override
    public boolean isCategorical(final int index) {
        return true;
    }

    @Override
    public double quantile(final double p) {
        for(int i = 0; i < cumulative.length; ++i) {
            if(cumulative[i] >= p) {
                return values[i];
            }
        }

        return values[values.length - 1];
    }
}
