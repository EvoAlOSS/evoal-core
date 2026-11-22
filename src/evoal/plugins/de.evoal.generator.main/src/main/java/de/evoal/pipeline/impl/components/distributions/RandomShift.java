package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.pipeline.api.distribution.Randomisation;

/**
 * Random shift of a low-discrepancy sequence (DL type {@code 'random-shift'}, Cranley and
 *   Patterson 1976): every point x becomes frac(x + Δ) for one uniform random vector Δ that is
 *   drawn from the sequence's random stream when the randomisation is prepared.
 */
@Named(RandomShift.NAME)
@Dependent
public class RandomShift implements Randomisation {
    /**
     * The CDI name of the randomisation.
     */
    static final String NAME = "de.evoal.pipeline.distributions.random-shift";

    /**
     * The shift Δ in [0, 1)^d.
     */
    private double [] shift;

    @Override
    public void prepare(final int dimension, final RandomGenerator randomness) {
        shift = new double[dimension];

        for(int j = 0; j < dimension; ++j) {
            shift[j] = randomness.nextDouble();
        }
    }

    @Override
    public double [] apply(final double [] point) {
        for(int j = 0; j < point.length; ++j) {
            point[j] = wrap(point[j] + shift[j]);
        }

        return point;
    }

    /**
     * Returns the fractional part of x + Δ, a value in [0, 2]. The sum of two numbers below 1
     *   can round to 2, which would wrap to 1, so the result is kept below 1.
     */
    static double wrap(final double value) {
        double result = value >= 1.0 ? value - 1.0 : value;

        if(result >= 1.0) {
            result = Math.nextDown(1.0);
        }

        return result;
    }
}
