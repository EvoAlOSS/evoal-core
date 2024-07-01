package de.evoal.optimisation.main.comparator;

import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.utils.Requirements;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;

public class WeightedSumOptimisationValue implements OptimisationValue {
    @Getter
    private final @NonNull double[] fitnessValues;
    private final @NonNull double[] normalizedWeights;

    private WeightedSumOptimisationValue(final @NonNull double[] weights, final @NonNull double[] fitnessValues) {
        Requirements.requireSameSize(weights, fitnessValues);

        this.normalizedWeights = new double[weights.length];
        System.arraycopy(weights, 0, normalizedWeights, 0, weights.length);
        this.fitnessValues = fitnessValues;

        final double sumOfWeights = Arrays.stream(weights).sum();
        for(int i = 0; i < normalizedWeights.length; ++i) {
            normalizedWeights[i] = normalizedWeights[i] / sumOfWeights;
        }
    }

    public static WeightedSumOptimisationValue of(final double [] weights, final double [] fitnessValues) {
        return new WeightedSumOptimisationValue(weights, fitnessValues);
    }

    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        if(!(other instanceof WeightedSumOptimisationValue)) {
            throw new IllegalArgumentException("Only allowed to compare WeightedSumFitnessValue");
        }

        double ownFitness = 0.0;
        double otherFitness = 0.0;

        for(int index = 0; index < fitnessValues.length; ++index) {
            ownFitness = ownFitness + this.normalizedWeights[index] * Math.abs(this.fitnessValues[index]);
            otherFitness = otherFitness + this.normalizedWeights[index] * Math.abs(((WeightedSumOptimisationValue)other).getFitnessValues()[index]);
        }

        return ownFitness == otherFitness ? 0 : (int)Math.signum(ownFitness - otherFitness);
    }

    @Override
    public String toString() {
    	return "WeightedSum [fit=" + Arrays.toString(fitnessValues) + ", w=" + Arrays.toString(normalizedWeights) + "]";
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
