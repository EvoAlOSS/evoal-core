package de.evoal.optimisation.main.comparator;

import de.evoal.optimisation.api.model.OptimisationValue;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class EpsilonOptimisationValue extends Number implements OptimisationValue {
    @Getter
    private final Number fitnessValue;

    @Getter
    private final @NonNull Number[] fitnessValues;

    private final @NonNull List<Function<Double, Double>> valueConversions;

    private EpsilonOptimisationValue(final @NonNull List<Function<Double, Double>> valueConversions, final int index, final @NonNull Number[] fitnessValues) {
        /*I want to take an array of malus values but specify the index of the one I want...*/
        //TODO does this break things??
        //Requirements.requireEqual(fitnessValues.length, 1);
        this.valueConversions = valueConversions;
        this.fitnessValues = fitnessValues;
        this.fitnessValue = fitnessValues[index];

        throw new IllegalStateException("Fix me");
    }

    public static EpsilonOptimisationValue of(final @NonNull List<Function<Double, Double>> valueConversions, final int index, final double [] fitnessValues) {
        return new EpsilonOptimisationValue(valueConversions,
                index,
                Arrays.stream(fitnessValues)
                        .mapToObj(Double::valueOf)
                        .toArray(s -> new Number [s]));
    }

    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        if(!(other instanceof EpsilonOptimisationValue)) {
            throw new IllegalArgumentException("Only allowed to compare EpsilonOptimisationValue");
        }

        return Double.compare(this.fitnessValue.doubleValue(), ((EpsilonOptimisationValue) other).fitnessValue.doubleValue());
    }

    @Override
    public String toString() {
        return "EpsilonOptimisationValue [" + fitnessValue + "]";
    }

    @Override
    public Object[] toStatistics() {
        final Object [] result = new Object[fitnessValues.length];

        for(int i = 0; i < result.length; ++i) {
            result[i] = fitnessValues[i];
        }

        return result;
    }

    @Override
    public double distanceFrom(final OptimisationValue other) {
        if(!(other instanceof EpsilonOptimisationValue)) {
            throw new IllegalArgumentException("Only allowed to compare EpsilonOptimisationValue");
        }

        final EpsilonOptimisationValue otherEOV = (EpsilonOptimisationValue) other;

        return Math.abs(this.fitnessValue.doubleValue() - ((EpsilonOptimisationValue) other).fitnessValue.doubleValue());
    }

    @Override
    public int intValue() {
        return fitnessValue.intValue();
    }

    @Override
    public long longValue() {
        return fitnessValue.longValue();
    }

    @Override
    public float floatValue() {
        return fitnessValue.floatValue();
    }

    @Override
    public double doubleValue() {
        return fitnessValue.doubleValue();
    }
}