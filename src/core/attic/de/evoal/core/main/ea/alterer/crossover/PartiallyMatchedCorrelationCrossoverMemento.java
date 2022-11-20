package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.main.ea.functions.correlation.model.Correlation;
import io.jenetics.internal.math.Subset;
import io.jenetics.util.RandomRegistry;

import java.util.Random;
import java.util.random.RandomGenerator;

import static java.lang.Math.min;

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
