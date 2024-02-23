package de.evoal.core.main.comparator;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.utils.Requirements;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;

public class NumericOptimisationValue extends Number implements OptimisationValue {
    @Getter
    private final Number fitnessValue;
    private NumericOptimisationValue(final @NonNull Number[] fitnessValues) {
        Requirements.requireEqual(fitnessValues.length, 1);

        this.fitnessValue = fitnessValues[0];
    }

    public static NumericOptimisationValue of(final double [] fitnessValues) {
        return new NumericOptimisationValue(
                Arrays.stream(fitnessValues)
                      .mapToObj(Double::valueOf)
                      .toArray(s -> new Number [s]));
    }

    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        if(!(other instanceof NumericOptimisationValue)) {
            throw new IllegalArgumentException("Only allowed to compare NumericOptimisationValue");
        }

        return Double.compare(this.fitnessValue.doubleValue(), ((NumericOptimisationValue) other).fitnessValue.doubleValue());
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
