package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.main.ea.model.Correlations;
import io.jenetics.Gene;
import io.jenetics.util.MSeq;


import static java.lang.String.format;

public class SinglePointCorrelationCrossover<
        A,
        G extends Gene<A, G>,
        C extends Comparable<? super C>
> extends MultiPointCorrelationCrossover<G, C, SinglePointCorrelationCrossoverMemento>  {

    /**
     * Constructs an alterer with a given recombination probability.
     *
     * @param probability the crossover probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *         valid range of {@code [0, 1]}.
     */
    public SinglePointCorrelationCrossover(final double probability, final Correlations correlations) {
        super(probability, 1, correlations);
    }

    @Override
    protected int crossover(final SinglePointCorrelationCrossoverMemento memento, final MSeq<G> that, final MSeq<G> other) {
        final int index = memento.getIndex(that.length(), other.length());

        if(SinglePointCorrelationCrossoverMemento.BetterChromsome.FIRST.equals(memento.getSelect())) {
            copy(other, that, index, that.length() - index, index);
        } else {
            copy(that, other, index, that.length() - index, index);
        }

        return that.length() - index;
    }

    private void copy(final MSeq<G> source, final MSeq<G> target, final int start, int size, int index) {
        for(int i = 0; i < size; ++i) {
            final G gene = source.get(start + i);
            final A allele = gene.allele();
            target.set(index + i, gene.newInstance(allele ));
        }
    }

    @Override
    protected SinglePointCorrelationCrossoverMemento newCrossoverMemento() {
        return new SinglePointCorrelationCrossoverMemento();
    }

    @Override
    public String toString() {
        return format("%s[p=%f]", getClass().getSimpleName(), _probability);
    }
}
