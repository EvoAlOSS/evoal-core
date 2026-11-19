package de.evoal.optimisation.ea.api.genotype;

/**
 * The genes of one chromosome of a candidate. The operators change them in place; every
 *   candidate has its own copy.
 */
public sealed interface Genes permits RealGenes, IntegerGenes, BitGenes {
    /**
     * @return A copy with the same values.
     */
    Genes copy();

    /**
     * @return Whether the gene at the index has the same value in both genes.
     * @throws IllegalArgumentException if the other genes have another type or size.
     */
    boolean equalAt(Genes other, int index);

    /**
     * Exchanges the gene at the index with the gene of the other genes.
     *
     * @throws IllegalArgumentException if the other genes have another type or size.
     */
    void exchange(Genes other, int index);

    /**
     * @return The number of genes.
     */
    int size();

    /**
     * @throws IllegalArgumentException if the other genes have another type or size.
     */
    default void requireCompatible(final Genes other) {
        if(other.getClass() != getClass() || other.size() != size()) {
            throw new IllegalArgumentException("Genes of type " + getClass().getSimpleName() + " with " + size()
                                               + " genes cannot be combined with " + other.getClass().getSimpleName()
                                               + " with " + other.size() + " genes.");
        }
    }
}
