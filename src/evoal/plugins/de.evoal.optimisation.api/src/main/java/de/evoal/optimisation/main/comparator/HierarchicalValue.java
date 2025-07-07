package de.evoal.optimisation.main.comparator;

import de.evoal.optimisation.api.model.OptimisationValue;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class HierarchicalValue implements OptimisationValue {
    @Getter
    private final @NonNull double[] fitnessValues;
    private final @NonNull int[] orderIndices;
    private final @NonNull Function<Double, Double> [] valueConversions;

    private HierarchicalValue(final @NonNull List<Function<Double, Double>> valueConversions,  final @NonNull int[] orderIndices, final @NonNull double[] fitnessValues) {
        this.orderIndices = Arrays.copyOf(orderIndices, orderIndices.length);
        this.fitnessValues = fitnessValues;
        this.valueConversions = valueConversions.toArray(size -> new Function[size]);
    }

    public static HierarchicalValue of(final @NonNull List<Function<Double, Double>> valueConversions, final int[] orderIndices, final double [] fitnessValues) {
        return new HierarchicalValue(valueConversions, orderIndices, fitnessValues);
    }

    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        if(other instanceof HierarchicalValue hv) {
            for(int index : orderIndices) {
                final double thisNormalizedValue = valueConversions[index].apply(fitnessValues[index]);
                final double otherNormalizedValue = valueConversions[index].apply(hv.fitnessValues[index]);

                if(thisNormalizedValue != otherNormalizedValue) {
                    return Double.compare(thisNormalizedValue, otherNormalizedValue);
                }
            }

            return 0;
        } else{
            throw new IllegalArgumentException("Only allowed to compare HierarchicalValue");
        }
    }

    @Override
    public double distanceFrom(final @NonNull OptimisationValue other) {
        if(other instanceof HierarchicalValue hv) {
            for(int index : orderIndices) {
                if(fitnessValues[index] != hv.fitnessValues[index]) {
                    return Math.abs(fitnessValues[index] - hv.fitnessValues[index]);
                }
            }

            return 0.0;
        } else{
            throw new IllegalArgumentException("Only allowed to compare HierarchicalValue");
        }
    }

    @Override
    public String toString() {
    	return "HierarchicalValue [fit=" + Arrays.toString(fitnessValues) + ", order=" + Arrays.toString(orderIndices) + "]";
    }

    @Override
    public Object[] toStatistics() {
        final Object [] result = new Object[fitnessValues.length];

        for(int i = 0; i < result.length; ++i) {
            result[i] = fitnessValues[i];
        }

        return result;
    }
}
