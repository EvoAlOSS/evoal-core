package de.evoal.core.ea.main.alterer.mutator;

import de.evoal.core.ea.api.correlations.Correlations;
import io.jenetics.NumericGene;

import java.util.random.RandomGenerator;

import static io.jenetics.internal.math.Basics.clamp;
import static java.lang.Math.nextDown;
import static java.lang.String.format;

public class GaussianCorrelationMutator<
        G extends NumericGene<?, G>,
        C extends Comparable<? super C>>
        extends CorrelationMutator<G, C, GaussianCorrelationMutatorMemento> {

    public GaussianCorrelationMutator(final double probability, final double threshold, final Correlations correlations) {
        super(probability, threshold, correlations);
    }

    @Override
    protected GaussianCorrelationMutatorMemento[] createContextArray(final int count) {
        final GaussianCorrelationMutatorMemento[] result = new GaussianCorrelationMutatorMemento[count];

        for(int i = 0; i < count; ++i) {
            result[i] = uninitializedContext();
        }

        return result;
    }

    @Override
    protected G mutate(final G gene, final GaussianCorrelationMutatorMemento context, final RandomGenerator random) {
        return mutate0(gene, context, random);
    }

    private G mutate0(final G gene, final GaussianCorrelationMutatorMemento context, final RandomGenerator random) {
        final double min = gene.min().doubleValue();
        final double max = gene.max().doubleValue();
        final double std = (max - min)*0.25;

        final double value = gene.doubleValue();
        final double gaussian = context.getGaussian();

        return gene.newInstance(clamp(gaussian*std + value, min, nextDown(max)));
    }

    @Override
    public String toString() {
        return String.format("%s[p=%f]", getClass().getSimpleName(), _probability);
    }

    @Override
    protected GaussianCorrelationMutatorMemento uninitializedContext() {
        return new GaussianCorrelationMutatorMemento(threshold);
    }
}
