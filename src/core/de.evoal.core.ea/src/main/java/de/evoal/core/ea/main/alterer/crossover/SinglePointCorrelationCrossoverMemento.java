package de.evoal.core.ea.main.alterer.crossover;

import de.evoal.core.ea.api.correlations.Correlation;
import io.jenetics.util.RandomRegistry;
import lombok.Getter;
import lombok.Setter;

import java.util.random.RandomGenerator;

import static java.lang.Math.min;

public class SinglePointCorrelationCrossoverMemento extends MultiPointCorrelationCrossoverMemento<SinglePointCorrelationCrossoverMemento> {
    public enum BetterChromsome {
        FIRST,
        SECOND
    }

    private int index = -1;

    @Getter @Setter
    private BetterChromsome select = BetterChromsome.FIRST;

    public int getIndex(final int thatLength, final int otherLength) {
        if(index == -1) {
            final RandomGenerator random = RandomRegistry.random();

            index = random.nextInt(min(thatLength, otherLength));
        }

        return index;
    }


    @Override
    public SinglePointCorrelationCrossoverMemento apply(final SinglePointCorrelationCrossoverMemento other, final Correlation correlation) {
        final double correlationValue = correlation.getCorrelationFactor();
        final SinglePointCorrelationCrossoverMemento result = new SinglePointCorrelationCrossoverMemento();
        result.index = other.index;

        if(BetterChromsome.FIRST.equals(other.select) && correlationValue >= 0) {
            result.select = BetterChromsome.FIRST;
        } else if(BetterChromsome.FIRST.equals(other.select) && correlationValue < 0) {
            result.select = BetterChromsome.SECOND;
        } else if(BetterChromsome.SECOND.equals(other.select) && correlationValue >= 0) {
            result.select = BetterChromsome.SECOND;
        } else if(BetterChromsome.SECOND.equals(other.select) && correlationValue < 0) {
            result.select = BetterChromsome.FIRST;
        }

        return result;
    }
}
