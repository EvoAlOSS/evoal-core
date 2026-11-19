package de.evoal.optimisation.ea.api.operators;

import java.util.random.RandomGenerator;

import de.evoal.models.core.cdi.EvoalComponent;

import de.evoal.optimisation.ea.api.genotype.Genes;

/**
 * A recombination (DL type {@code recombination}): changes the genes of two children of a
 *   pair, which start as copies of their parents. Whether it is applied to a pair is drawn
 *   by the algorithm with {@link #probability()}.
 */
public interface RecombinationOperator extends EvoalComponent<RecombinationOperator> {
    /**
     * @return The name of the DL type, e.g., {@code single-point-crossover}.
     */
    String name();

    /**
     * @return The probability that the recombination is applied to a pair.
     */
    double probability();

    /**
     * Recombines the genes of one chromosome of the two children in place.
     *
     * @param first The genes of the first child.
     * @param second The genes of the second child, of the same type and size.
     * @param random The random numbers of the recombination.
     */
    void recombine(Genes first, Genes second, RandomGenerator random);
}
