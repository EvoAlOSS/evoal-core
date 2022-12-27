package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.api.utils.Requirements;
import de.evoal.core.main.ea.model.Correlations;
import io.jenetics.NumericGene;
import io.jenetics.util.MSeq;

import static java.lang.Math.min;
import static java.lang.String.format;

public class LineCorrelationCrossover<
        G extends NumericGene<?, G>,
        C extends Comparable<? super C>
        > extends CorrelationCrossover<G, C, LineCorrelationCrossoverMemento> {
    private final double _p;

    /**
     * Creates a new linear-crossover with the given recombination
     * probability and the line-scaling factor <em>p</em>.
     *
     * @param probability the recombination probability.
     * @param p defines the possible location of the recombined chromosomes. If
     *        <em>p</em> = 0 then the children will be located along the line
     *        within the hypercube between the two points. If <em>p</em> &gt; 0
     *        then the children may be located anywhere on the line, even
     *        somewhat outside of the hypercube.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *         valid range of {@code [0, 1]} or if {@code p} is smaller then zero
     */
    public LineCorrelationCrossover(final double probability, final double p, final Correlations correlations) {
        super(probability, correlations);
        _p = Requirements.nonNegative(p);
    }

    /**
     * Creates a new linear-crossover with the given recombination
     * probability. The parameter <em>p</em> is set to zero, which restricts the
     * recombined chromosomes within the hypercube of the selected chromosomes
     * (vectors).
     *
     * @param probability the recombination probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *         valid range of {@code [0, 1]}
     */
    public LineCorrelationCrossover(final double probability, final Correlations correlations) {
        this(probability, 0, correlations);
    }

    @Override
    protected int crossover(final LineCorrelationCrossoverMemento memento, final MSeq<G> v, final MSeq<G> w) {
        final double min = v.get(0).min().doubleValue();
        final double max = v.get(0).max().doubleValue();


        boolean changed = false;
        for (int i = 0, n = min(v.length(), w.length()); i < n; ++i) {
            final double vi = v.get(i).doubleValue();
            final double wi = w.get(i).doubleValue();

            final double t = memento.getA() * vi + (1 - memento.getA()) * wi;
            final double s = memento.getB() * wi + (1 - memento.getB()) * vi;

            if (t >= min && s >= min && t < max && s < max) {
                v.set(i, v.get(i).newInstance(t));
                w.set(i, w.get(i).newInstance(s));
                changed = true;
            }
        }

        return changed ? 2 : 0;
    }

    @Override
    public String toString() {
        return format("%s[p=%f]", getClass().getSimpleName(), _probability);
    }

    @Override
    protected LineCorrelationCrossoverMemento newCrossoverMemento() {
        return new LineCorrelationCrossoverMemento(_p);
    }
}
