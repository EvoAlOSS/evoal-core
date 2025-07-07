package de.evoal.optimisation.main.comparator;

import de.evoal.languages.model.interpreter.ArithmeticNumberOperations;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.utils.Requirements;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class NumericOptimisationValue extends Number implements OptimisationValue {
    @Getter
    private final Number fitnessValue;

    private final List<Function<Double, Double>> valueConversions;

    private NumericOptimisationValue(final @NonNull List<Function<Double, Double>> valueConversions, final @NonNull Number[] fitnessValues) {
        Requirements.requireEqual(fitnessValues.length, 1);

        this.valueConversions = valueConversions;
        this.fitnessValue = fitnessValues[0];
    }

    public static NumericOptimisationValue of(final @NonNull List<Function<Double, Double>> valueConversions, final double [] fitnessValues) {
        return new NumericOptimisationValue(
                valueConversions,
                Arrays.stream(fitnessValues)
                      .mapToObj(Double::valueOf)
                      .toArray(s -> new Number [s]));
    }

    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        if(!(other instanceof NumericOptimisationValue otherNumeric)) {
            throw new IllegalArgumentException("Only allowed to compare NumericOptimisationValue");
        }

        final Double thisConvertedValue = valueConversions.get(0).apply(this.fitnessValue.doubleValue());
        final Double otherConvertedValue = valueConversions.get(0).apply(otherNumeric.fitnessValue.doubleValue());

        return Double.compare(thisConvertedValue, otherConvertedValue);
    }

    @Override
    public double distanceFrom(final @NonNull OptimisationValue other) {
        if(!(other instanceof NumericOptimisationValue)) {
            throw new IllegalArgumentException("Only allowed to compare NumericOptimisationValue");
        }

        return Math.abs(this.fitnessValue.doubleValue()-((NumericOptimisationValue) other).fitnessValue.doubleValue());
    }

    @Override
    public String toString() {
    	return "NumericOptimisationValue [" + fitnessValue + "]";
    }

    @Override
    public Object[] toStatistics() {
        return new Object [] {fitnessValue};
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
