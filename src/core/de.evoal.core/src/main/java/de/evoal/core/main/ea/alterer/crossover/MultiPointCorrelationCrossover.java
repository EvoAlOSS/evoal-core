package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.api.ea.correlations.Correlations;
import io.jenetics.Gene;
import io.jenetics.util.MSeq;

import static java.lang.Math.min;
import static java.lang.String.format;

public class MultiPointCorrelationCrossover<
        G extends Gene<?, G>,
        C extends Comparable<? super C>,
        M extends MultiPointCorrelationCrossoverMemento<M>
        > extends CorrelationCrossover<G, C, M> {
    private final int _n;

    /**
     * Create a new crossover instance.
     *
     * @param probability the recombination probability.
     * @param n the number of crossover points.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *         valid range of {@code [0, 1]} or {@code n &lt; 1}.
     */
    public MultiPointCorrelationCrossover(final double probability, final int n, final Correlations correlations) {
        super(probability, correlations);
        if (n < 1) {
            throw new IllegalArgumentException(format(
                    "n must be at least 1 but was %d.", n
            ));
        }
        _n = n;
    }

    /**
     * Create a new crossover instance with two crossover points.
     *
     * @param probability the recombination probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *         valid range of {@code [0, 1]}.
     */
    public MultiPointCorrelationCrossover(final double probability, final Correlations correlations) {
        this(probability, 2, correlations);
    }

    /**
     * Create a new crossover instance with default crossover probability of
     * 0.05.
     *
     * @param n the number of crossover points.
     * @throws IllegalArgumentException if {@code n &lt; 1}.
     */
    public MultiPointCorrelationCrossover(final int n, final Correlations correlations) {
        this(0.05, n, correlations);
    }

    /**
     * Create a new crossover instance with two crossover points and crossover
     * probability 0.05.
     */
    public MultiPointCorrelationCrossover(final Correlations correlations) {
        this(0.05, 2, correlations);
    }

    /**
     * Return the number of crossover points.
     *
     * @return the number of crossover points.
     */
    public int crossoverPointCount() {
        return _n;
    }

    @Override
    protected int crossover(final M memento, final MSeq<G> that, final MSeq<G> other) {
        assert that.length() == other.length();

        final int[] points = memento.getCrossoverPoints(that.length(), other.length(), _n);

        crossover(that, other, points);
        return 2;
    }

    @Override
    protected M newCrossoverMemento() {
        return (M)new MultiPointCorrelationCrossoverMemento();
    }

    // Package private for testing purpose.
    static <T> void crossover(
            final MSeq<T> that,
            final MSeq<T> other,
            final int[] indexes
    ) {

        for (int i = 0; i < indexes.length - 1; i += 2) {
            final int start = indexes[i];
            final int end = indexes[i + 1];
            that.swap(start, end, other, start);
        }
        if (indexes.length%2 == 1) {
            final int index = indexes[indexes.length - 1];
            that.swap(index, min(that.length(), other.length()), other, index);
        }
    }

    @Override
    public String toString() {
        return format(
                "%s[p=%f, n=%d]",
                getClass().getSimpleName(), _probability, _n
        );
    }
}
