package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

/**
 * Base class of the discrete distributions (DL type {@code 'discrete-distribution'}): their
 *   values are whole numbers, written to integer data. The quantile is the smallest value k with
 *   F(k) ≥ p, so sampling by inversion gives every value with its probability.
 */
abstract class DiscreteDistribution extends InversionDistribution {
    /**
     * Creates a distribution that is configured by {@link #init(org.eclipse.emf.ecore.EObject)}.
     */
    protected DiscreteDistribution() {
    }

    /**
     * Creates a distribution with the given random stream, e.g., for tests.
     */
    protected DiscreteDistribution(final RandomGenerator randomness) {
        super(randomness);
    }

    /**
     * @return true, the value is a whole number.
     */
    @Override
    public boolean isDiscrete(final int index) {
        return true;
    }
}
