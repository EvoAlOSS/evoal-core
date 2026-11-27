package de.evoal.optimisation.ea.api.genotype;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * Maps some features of the search space to genes and back.
 */
public abstract sealed class Chromosome permits DoubleChromosome, IntegerChromosome, BinaryChromosome, ModelChromosome {
    /**
     * The features, in the order of their genes.
     */
    private final List<EStructuralFeature> features;

    /**
     * @param features The features, in the order of their genes.
     */
    protected Chromosome(final List<EStructuralFeature> features) {
        if(features.isEmpty()) {
            throw new IllegalArgumentException("A chromosome needs at least one feature.");
        }

        this.features = List.copyOf(features);
    }

    /**
     * Writes the feature values of the genes into the candidate.
     */
    public abstract void decode(Genes genes, TypedEObject target);

    /**
     * @return The genes of the feature values of the candidate.
     */
    public abstract Genes encode(TypedEObject candidate);

    /**
     * @return The index of the feature that the gene belongs to.
     */
    public abstract int featureOfGene(int gene);

    /**
     * @return The features, in the order of their genes.
     */
    public List<EStructuralFeature> features() {
        return features;
    }

    /**
     * Brings the genes back into the boundaries of their features; nothing to do for bits.
     */
    public abstract void handleBoundaries(Genes genes, BoundaryHandling handling);

    /**
     * @return The representation of the genes.
     */
    public abstract Representation representation();

    @Override
    public String toString() {
        return representation() + "" + features.stream().map(EStructuralFeature::getName).toList();
    }
}
