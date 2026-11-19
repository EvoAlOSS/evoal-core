package de.evoal.optimisation.ea.api.genotype;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * Integer features, one {@link IntegerGenes integer gene} each.
 */
public final class IntegerChromosome extends Chromosome {
    /**
     * The inclusive boundaries of every feature.
     */
    private final long[] lower;
    private final long[] upper;

    /**
     * @param features The integer features.
     * @param lower The inclusive lower boundary of every feature.
     * @param upper The inclusive upper boundary of every feature.
     */
    public IntegerChromosome(final List<EStructuralFeature> features, final long[] lower, final long[] upper) {
        super(features);

        if(lower.length != features.size() || upper.length != features.size()) {
            throw new IllegalArgumentException("Every feature needs a lower and an upper boundary.");
        }

        this.lower = lower.clone();
        this.upper = upper.clone();
    }

    @Override
    public void decode(final Genes genes, final TypedEObject target) {
        final IntegerGenes values = (IntegerGenes) genes;

        for(int i = 0; i < values.size(); ++i) {
            target.eSet(features().get(i), Math.toIntExact(values.get(i)));
        }
    }

    @Override
    public IntegerGenes encode(final TypedEObject candidate) {
        final long[] values = new long[features().size()];

        for(int i = 0; i < values.length; ++i) {
            values[i] = ((Number) candidate.eGet(features().get(i))).longValue();
        }

        return new IntegerGenes(values, lower, upper);
    }

    @Override
    public int featureOfGene(final int gene) {
        return gene;
    }

    @Override
    public void handleBoundaries(final Genes genes, final BoundaryHandling handling) {
        final IntegerGenes values = (IntegerGenes) genes;

        for(int i = 0; i < values.size(); ++i) {
            values.set(i, handling.apply(values.get(i), lower[i], upper[i]));
        }
    }

    @Override
    public Representation representation() {
        return Representation.INTEGER;
    }
}
