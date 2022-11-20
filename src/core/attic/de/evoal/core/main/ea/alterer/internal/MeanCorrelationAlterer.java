package de.evoal.core.main.ea.alterer.internal;

import de.evoal.core.main.ea.functions.correlation.model.Correlations;
import io.jenetics.*;
import io.jenetics.util.Mean;

public class MeanCorrelationAlterer<
        G extends NumericGene<?, G> & Mean<G>,
        C extends Comparable<? super C>
> extends CorrelationCombineAlterer<G, C> {

    /**
     * Constructs an alterer with a given recombination probability.
     *
     * @param probability the crossover probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *         valid range of {@code [0, 1]}.
     */
    public MeanCorrelationAlterer(final double probability, final Correlations correlations) {
        super((x,y) -> (G)((Mean)x).mean(y), probability, correlations);
    }

    /**
     * Create a new alterer with alter probability of {@code 0.05}.
     */
    public MeanCorrelationAlterer(final Correlations correlations) {
        this(0.05, correlations);
    }

}

