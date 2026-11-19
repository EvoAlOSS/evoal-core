package de.evoal.optimisation.ea.main.alterer.internal;

import io.jenetics.AbstractAlterer;
import io.jenetics.Gene;

public abstract class AbstractCorrelationAlterer<
        G extends Gene<?, G>,
        C extends Comparable<? super C>
>
        extends AbstractAlterer<G, C> {
    /**
     * Constructs an alterer with a given recombination probability.
     *
     * @param probability The recombination probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *                                  valid range of {@code [0, 1]}.
     */
    protected AbstractCorrelationAlterer(double probability) {
        super(probability);
    }
}
