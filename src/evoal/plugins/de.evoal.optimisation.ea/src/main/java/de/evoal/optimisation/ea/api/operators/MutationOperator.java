package de.evoal.optimisation.ea.api.operators;

import java.util.OptionalDouble;
import java.util.random.RandomGenerator;

import de.evoal.models.core.cdi.EvoalComponent;

import de.evoal.optimisation.ea.api.genotype.Genes;

/**
 * A mutation (DL type {@code mutation}): changes the genes of a child. Whether it is applied
 *   to a child is drawn by the algorithm with {@link #probability()}; which genes change is
 *   drawn by the mutation with the gene probability.
 */
public interface MutationOperator extends EvoalComponent<MutationOperator> {
    /**
     * @return The configured probability that a gene is changed; empty for the default 1 / n,
     *   n the number of genes of the chromosome.
     */
    OptionalDouble geneProbability();

    /**
     * Mutates the genes of one chromosome in place: every gene changes with the gene
     *   probability, one draw per gene ({@code nextDouble() < p}).
     *
     * @param genes The genes.
     * @param geneProbability The probability that a gene is changed.
     * @param random The random numbers of the mutation.
     */
    void mutate(Genes genes, double geneProbability, RandomGenerator random);

    /**
     * @return The name of the DL type, e.g., {@code bit-flip-mutation}.
     */
    String name();

    /**
     * @return The probability that the mutation is applied to a child.
     */
    double probability();

    /**
     * Chooses the mutation that changes a child once the mutation fires. A mutation that
     *   combines others (e.g. {@code 'single-choice-mutation'}) chooses one of them; all
     *   others are themselves.
     *
     * @param random The random numbers of the mutation.
     * @return The mutation to apply to all chromosomes of the child.
     */
    default MutationOperator choose(final RandomGenerator random) {
        return this;
    }
}
