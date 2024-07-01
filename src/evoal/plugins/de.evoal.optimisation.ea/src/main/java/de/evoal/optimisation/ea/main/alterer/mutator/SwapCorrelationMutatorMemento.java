package de.evoal.optimisation.ea.main.alterer.mutator;

import de.evoal.optimisation.api.correlations.Correlation;

import java.util.random.RandomGenerator;

import static io.jenetics.internal.math.Randoms.indexes;

public class SwapCorrelationMutatorMemento implements CorrelationMutatorMemento<SwapCorrelationMutatorMemento> {
    private int [][] indices = null;

    public int [][] getIndices(final RandomGenerator random, final int length, final double probability) {
        if(indices == null) {
            indices = indexes(random, length, probability).mapToObj(i -> new int[] {i, random.nextInt(length)}).toArray(i -> new int [i][]);
        }

        return indices;
    }

    @Override
    public void apply(final SwapCorrelationMutatorMemento context, final Correlation correlation) {
    }
}
