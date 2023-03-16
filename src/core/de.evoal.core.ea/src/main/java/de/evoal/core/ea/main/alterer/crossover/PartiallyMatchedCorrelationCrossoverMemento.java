package de.evoal.core.ea.main.alterer.crossover;

import de.evoal.core.ea.api.correlations.Correlation;
import io.jenetics.internal.math.Subset;
import io.jenetics.util.RandomRegistry;

import java.util.random.RandomGenerator;

public class PartiallyMatchedCorrelationCrossoverMemento implements CorrelationCrossoverMemento<PartiallyMatchedCorrelationCrossoverMemento> {
    private int[] points = null;

    public int[] getCrossoverPoints(final int thatLength) {
        if(points == null) {
            final RandomGenerator random = RandomRegistry.random();
            points = Subset.next(thatLength, 2, random);
        }

        return points;
    }

    @Override
    public PartiallyMatchedCorrelationCrossoverMemento apply(PartiallyMatchedCorrelationCrossoverMemento memento, Correlation correlation) {
        return this;
    }
}
