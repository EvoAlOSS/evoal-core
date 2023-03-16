package de.evoal.core.ea.main.alterer.mutator;

import de.evoal.core.ea.api.correlations.Correlation;
import lombok.Getter;
import lombok.Setter;

import java.util.random.RandomGenerator;

public class SingleBitFlipCorrelationMutatorMemento implements CorrelationMutatorMemento<SingleBitFlipCorrelationMutatorMemento> {

    public enum FlipDirection {
        DOWN,
        NOTHING,
        SINGLE_FLIP_UP,
        SINGLE_FLIP_DOWN,
        TRANSITIVE_UP,
        TRANSITIVE_DOWN,
        UNSET,
        UP;

        public static FlipDirection from(final boolean value) {
            return value ? UP : DOWN;
        }
    }

    private int index = -1;

    private final double threshold;

    @Getter @Setter
    private FlipDirection direction = FlipDirection.UNSET;

    public SingleBitFlipCorrelationMutatorMemento(final double threshold) {
        this.threshold = threshold;
    }

    public int getIndex(final RandomGenerator random, final int length, final double probability) {
        if(index == -1) {
            index = random.nextInt(0, length);
        }

        return index;
    }

    @Override
    public void apply(final SingleBitFlipCorrelationMutatorMemento context, final Correlation correlation) {
        final double correlationFactor = correlation.getCorrelationFactor();
        final FlipDirection direction = context.getDirection();

        if(correlationFactor >= threshold && FlipDirection.UP.equals(direction)) {
            this.direction = FlipDirection.TRANSITIVE_UP;
        } else if(correlationFactor >= threshold && FlipDirection.DOWN.equals(direction)) {
            this.direction = FlipDirection.TRANSITIVE_DOWN;
        } else if(correlationFactor >= 0 && FlipDirection.UP.equals(direction)) {
            this.direction = FlipDirection.SINGLE_FLIP_UP;
        } else if(correlationFactor >= 0 && FlipDirection.DOWN.equals(direction)) {
            this.direction = FlipDirection.SINGLE_FLIP_DOWN;
        } else if(correlationFactor > -threshold && FlipDirection.UP.equals(direction)) {
            this.direction = FlipDirection.SINGLE_FLIP_DOWN;
        } else if(correlationFactor > -threshold && FlipDirection.DOWN.equals(direction)) {
            this.direction = FlipDirection.SINGLE_FLIP_UP;
        } else if(correlationFactor <= -threshold && FlipDirection.UP.equals(direction)) {
            this.direction = FlipDirection.TRANSITIVE_DOWN;
        } else if(correlationFactor <= -threshold && FlipDirection.DOWN.equals(direction)) {
            this.direction = FlipDirection.TRANSITIVE_UP;
        }

    }
}
