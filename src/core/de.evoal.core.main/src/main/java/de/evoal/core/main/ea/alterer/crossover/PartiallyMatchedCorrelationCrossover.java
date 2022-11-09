package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.main.ea.functions.correlation.model.Correlations;
import io.jenetics.EnumGene;
import io.jenetics.util.MSeq;

import static java.lang.String.format;

public class PartiallyMatchedCorrelationCrossover<
        T,
        C extends Comparable<? super C>
> extends CorrelationCrossover<EnumGene<T>, C, PartiallyMatchedCorrelationCrossoverMemento>
{

    public PartiallyMatchedCorrelationCrossover(final double probability, final Correlations correlations) {
        super(probability, correlations);
    }

    @Override
    protected PartiallyMatchedCorrelationCrossoverMemento newCrossoverMemento() {
        return new PartiallyMatchedCorrelationCrossoverMemento();
    }

    @Override
    protected int crossover(
            final PartiallyMatchedCorrelationCrossoverMemento memento,
            final MSeq<EnumGene<T>> that,
            final MSeq<EnumGene<T>> other
    ) {
        if (that.length() != other.length()) {
            throw new IllegalArgumentException(format(
                    "Required chromosomes with same length: %s != %s",
                    that.length(), other.length()
            ));
        }

        if (that.length() >= 2) {
            final int[] points = memento.getCrossoverPoints(that.length());

            that.swap(points[0], points[1], other, points[0]);
            repair(that, other, points[0], points[1]);
            repair(other, that, points[0], points[1]);
        }

        return 1;
    }

    private static <T> void repair(
            final MSeq<T> that, final MSeq<T> other,
            final int begin, final int end
    ) {
        for (int i = 0; i < begin; ++i) {
            int index = that.indexOf(that.get(i), begin, end);
            while (index != -1) {
                that.set(i, other.get(index));
                index = that.indexOf(that.get(i), begin, end);
            }
        }
        for (int i = end, n = that.length(); i < n; ++i) {
            int index = that.indexOf(that.get(i), begin, end);
            while (index != -1) {
                that.set(i, other.get(index));
                index = that.indexOf(that.get(i), begin, end);
            }
        }
    }

    @Override
    public String toString() {
        return format("%s[p=%f]", getClass().getSimpleName(), _probability);
    }

}
