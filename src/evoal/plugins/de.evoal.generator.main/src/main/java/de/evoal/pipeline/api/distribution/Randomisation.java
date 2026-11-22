package de.evoal.pipeline.api.distribution;

import java.util.random.RandomGenerator;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * Randomisation of a low-discrepancy sequence (DL type {@code randomisation}): maps every
 *   point of the sequence in the unit cube [0, 1)^d to another point of the unit cube before
 *   the sequence scales it to its box.
 */
public interface Randomisation extends EvoalComponent<Randomisation> {
    /**
     * Prepares the randomisation for one sequence. Called once, before the first point.
     *
     * @param dimension The dimension d of the sequence.
     * @param randomness The random stream of the sequence.
     */
    void prepare(int dimension, RandomGenerator randomness);

    /**
     * Randomises a point of the sequence.
     *
     * @param point A point of [0, 1)^d. It may be changed and returned.
     * @return The randomised point in [0, 1)^d.
     */
    double [] apply(double [] point);
}
