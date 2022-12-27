package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.api.utils.Requirements;
import de.evoal.core.main.ea.model.Correlations;
import io.jenetics.Gene;
import io.jenetics.util.MSeq;

import static java.lang.Math.min;

public class UniformCorrelationCrossover<
        A,
        G extends Gene<A, G>,
        C extends Comparable<? super C>
        > extends  CorrelationCrossover<G, C, UniformCorrelationCrossoverMemento> {
    private final double _swapProbability;

    /**
     * Create a new universal crossover instance.
     *
     * @param crossoverProbability the recombination probability as defined in
     *        {@link CorrelationCrossover#CorrelationCrossover(double, Correlations)} . This is the probability that
     *        a given individual is selected for crossover.
     * @param swapProbability the probability for swapping a given gene of
     *         a chromosome
     * @throws IllegalArgumentException if the probabilities are not in the
     *         valid range of {@code [0, 1]}
     */
    public UniformCorrelationCrossover(
            final double crossoverProbability,
            final double swapProbability,
            final Correlations correlations
    ) {
        super(crossoverProbability, correlations);

        Requirements.requireProbability(swapProbability);
        _swapProbability = swapProbability;
    }

    @Override
    protected UniformCorrelationCrossoverMemento newCrossoverMemento() {
        return new UniformCorrelationCrossoverMemento();
    }

    @Override
    protected int crossover(final UniformCorrelationCrossoverMemento memento, final MSeq<G> that, final MSeq<G> other) {
        final int length = min(that.length(), other.length());

        final int [] indices = memento.getCrossoverPoints(length, _swapProbability);

        for(int index : indices) {
            if (UniformCorrelationCrossoverMemento.BetterChromsome.FIRST.equals(memento.getSelect())) {
                copy(other, that, index);
            } else {
                copy(that, other, index);
            }
        }

        return indices.length;
    }

    private void copy(final MSeq<G> source, final MSeq<G> target, final int index) {
        final G gene = source.get(index);
        final A allele = gene.allele();
        final G copy = gene.newInstance(allele);

        target.set(index, copy);
    }
}
