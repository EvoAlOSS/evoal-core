package de.evoal.optimisation.ea.main.alterer.internal;

import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
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
    public MeanCorrelationAlterer(final double probability, final Correlations correlations, final CustomCodec<G> codec) {
        super((x,y) -> (G)((Mean)x).mean(y), probability, correlations, codec);
    }

    /**
     * Create a new alterer with alter probability of {@code 0.05}.
     */
    public MeanCorrelationAlterer(final Correlations correlations, final CustomCodec<G> codec) {
        this(0.05, correlations, codec);
    }

}

