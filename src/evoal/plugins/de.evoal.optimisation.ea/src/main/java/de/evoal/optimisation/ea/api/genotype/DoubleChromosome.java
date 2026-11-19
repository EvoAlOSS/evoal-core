package de.evoal.optimisation.ea.api.genotype;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * Real features, one {@link RealGenes real gene} each.
 */
public final class DoubleChromosome extends Chromosome {
    /**
     * The inclusive boundaries of every feature.
     */
    private final double[] lower;
    private final double[] upper;

    /**
     * @param features The real features.
     * @param lower The inclusive lower boundary of every feature.
     * @param upper The inclusive upper boundary of every feature.
     */
    public DoubleChromosome(final List<EStructuralFeature> features, final double[] lower, final double[] upper) {
        super(features);

        if(lower.length != features.size() || upper.length != features.size()) {
            throw new IllegalArgumentException("Every feature needs a lower and an upper boundary.");
        }

        this.lower = lower.clone();
        this.upper = upper.clone();
    }

    @Override
    public void decode(final Genes genes, final TypedEObject target) {
        final RealGenes values = (RealGenes) genes;

        for(int i = 0; i < values.size(); ++i) {
            target.eSet(features().get(i), values.get(i));
        }
    }

    @Override
    public RealGenes encode(final TypedEObject candidate) {
        final double[] values = new double[features().size()];

        for(int i = 0; i < values.length; ++i) {
            values[i] = ((Number) candidate.eGet(features().get(i))).doubleValue();
        }

        return new RealGenes(values, lower, upper);
    }

    @Override
    public int featureOfGene(final int gene) {
        return gene;
    }

    @Override
    public void handleBoundaries(final Genes genes, final BoundaryHandling handling) {
        final RealGenes values = (RealGenes) genes;

        for(int i = 0; i < values.size(); ++i) {
            values.set(i, handling.apply(values.get(i), lower[i], upper[i]));
        }
    }

    @Override
    public Representation representation() {
        return Representation.DOUBLE;
    }
}
