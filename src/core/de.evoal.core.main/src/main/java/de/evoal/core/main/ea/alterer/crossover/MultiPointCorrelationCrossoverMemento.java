package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.api.ea.correlations.Correlation;
import io.jenetics.internal.math.Subset;
import io.jenetics.util.RandomRegistry;

import java.util.random.RandomGenerator;

import static java.lang.Math.min;

public class MultiPointCorrelationCrossoverMemento<T extends MultiPointCorrelationCrossoverMemento<T>> implements CorrelationCrossoverMemento<T> {
    private int[] points = null;

    public int[] getCrossoverPoints(final int thatLength, final int otherLength, final int count) {
        if(points == null) {
            final int n = min(thatLength, otherLength);
            final int k = min(n, count);

            final RandomGenerator random = RandomRegistry.random();
            points = k > 0 ? Subset.next(n, k, random) : new int[0];
        }

        return points;
    }

    @Override
    public T apply(final T memento, final Correlation correlation) {
        return (T)this;
    }
}
