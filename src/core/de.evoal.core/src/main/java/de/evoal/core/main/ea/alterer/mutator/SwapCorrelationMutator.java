package de.evoal.core.main.ea.alterer.mutator;

import de.evoal.core.main.ea.model.Correlations;
import io.jenetics.Chromosome;
import io.jenetics.Gene;
import io.jenetics.MutatorResult;
import io.jenetics.util.MSeq;

import java.util.Arrays;
import java.util.random.RandomGenerator;

public class SwapCorrelationMutator<
        G extends Gene<?, G>,
        C extends Comparable<? super C>
        > extends CorrelationMutator<G, C, SwapCorrelationMutatorMemento> {

    public SwapCorrelationMutator(final double probability, final double threshold, final Correlations correlations) {
        super(probability, threshold, correlations);
    }

    @Override
    protected SwapCorrelationMutatorMemento[] createContextArray(final int count) {
        final SwapCorrelationMutatorMemento[] result = new SwapCorrelationMutatorMemento[count];

        for(int i = 0; i < count; ++i) {
            result[i] = uninitializedContext();
        }

        return result;
    }

    @Override
    protected MutatorResult<Chromosome<G>> mutate(
            final Chromosome<G> chromosome,
            final double p,
            final SwapCorrelationMutatorMemento memento,
            final RandomGenerator random
    ) {
        final MutatorResult<Chromosome<G>> result;
        if (chromosome.length() > 1) {
            final MSeq<G> genes = MSeq.of(chromosome);
            final int [][] swaps = memento.getIndices(random, genes.length(), p);

            final int mutations = (int) Arrays.stream(swaps)
                    .peek(i -> genes.swap(i[0], i[1]))
                    .count();
            result = new MutatorResult(
                    chromosome.newInstance(genes.toISeq()),
                    mutations
            );
        } else {
            result = new MutatorResult(chromosome, 0);
        }

        return result;

    }

    @Override
    protected SwapCorrelationMutatorMemento uninitializedContext() {
        return new SwapCorrelationMutatorMemento();
    }
}
