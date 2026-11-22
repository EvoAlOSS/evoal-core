package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.pipeline.api.distribution.Randomisation;

/**
 * Keeps the points of a low-discrepancy sequence (DL type {@code 'no-randomisation'}), so every
 *   execution gives the same points.
 */
@Named(NoRandomisation.NAME)
@Dependent
public class NoRandomisation implements Randomisation {
    /**
     * The CDI name of the randomisation.
     */
    static final String NAME = "de.evoal.pipeline.distributions.no-randomisation";

    @Override
    public void prepare(final int dimension, final RandomGenerator randomness) {
    }

    @Override
    public double [] apply(final double [] point) {
        return point;
    }
}
