package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.main.ea.functions.correlation.model.Correlation;
import io.jenetics.util.RandomRegistry;
import lombok.Getter;
import lombok.Setter;

import java.util.random.RandomGenerator;

import static io.jenetics.internal.math.Randoms.indexes;

public class UniformCorrelationCrossoverMemento implements CorrelationCrossoverMemento<UniformCorrelationCrossoverMemento> {

    public enum BetterChromsome {
        FIRST,
        SECOND
    }

    private int[] points = null;

    @Getter
    @Setter
    private BetterChromsome select = BetterChromsome.FIRST;

    public int[] getCrossoverPoints(final int thatLength, final double probability) {
        if(points == null) {
            final RandomGenerator random = RandomRegistry.random();
            points = indexes(random, thatLength, probability).toArray();
        }

        return points;
    }


    @Override
    public UniformCorrelationCrossoverMemento apply(final UniformCorrelationCrossoverMemento other, final Correlation correlation) {
        final double correlationValue = correlation.getCorrelationFactor();
        final UniformCorrelationCrossoverMemento result = new UniformCorrelationCrossoverMemento();
        result.points = other.points;

        if(UniformCorrelationCrossoverMemento.BetterChromsome.FIRST.equals(other.select) && correlationValue >= 0) {
            result.select = UniformCorrelationCrossoverMemento.BetterChromsome.FIRST;
        } else if(UniformCorrelationCrossoverMemento.BetterChromsome.FIRST.equals(other.select) && correlationValue < 0) {
            result.select = UniformCorrelationCrossoverMemento.BetterChromsome.SECOND;
        } else if(UniformCorrelationCrossoverMemento.BetterChromsome.SECOND.equals(other.select) && correlationValue >= 0) {
            result.select = UniformCorrelationCrossoverMemento.BetterChromsome.SECOND;
        } else if(UniformCorrelationCrossoverMemento.BetterChromsome.SECOND.equals(other.select) && correlationValue < 0) {
            result.select = UniformCorrelationCrossoverMemento.BetterChromsome.FIRST;
        }

        return result;
    }
}
