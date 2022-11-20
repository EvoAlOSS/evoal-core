package de.evoal.core.main.ea.comparator.weighted;

import de.evoal.core.api.ea.fitness.type.FitnessType;
import de.evoal.core.api.utils.Requirements;
import lombok.NonNull;

import java.util.Arrays;

import static de.evoal.core.api.utils.Requirements.requireSameSize;

public class WeightedSumComparatorType extends Number implements FitnessType {
    private final @NonNull double[] fitnessValues;
    private final @NonNull double[] normalizedWeights;

    private WeightedSumComparatorType(final @NonNull double[] weights, final @NonNull double[] fitnessValues) {
        Requirements.requireSameSize(weights, fitnessValues);

        this.normalizedWeights = new double[weights.length];
        System.arraycopy(weights, 0, normalizedWeights, 0, weights.length);
        this.fitnessValues = fitnessValues;

        final double sumOfWeights = Arrays.stream(weights).sum();
        for(int i = 0; i < normalizedWeights.length; ++i) {
            normalizedWeights[i] = normalizedWeights[i] / sumOfWeights;
        }
    }

    public static FitnessType of(final double [] weights, final double [] fitnessValues) {
        return new WeightedSumComparatorType(weights, fitnessValues);
    }

    @Override
    public int compareTo(final FitnessType other) {
        double ownFitness = 0.0;
        double otherFitness = 0.0;

        for(int index = 0; index < fitnessValues.length; ++index) {
            //ownFitness = ownFitness + this.normalizedWeights[index] * this.fitnessValues[index];
            //otherFitness = otherFitness + this.normalizedWeights[index] * other.getFitnessValues()[index];
            ownFitness = ownFitness - this.normalizedWeights[index] * Math.abs(this.fitnessValues[index]);
            otherFitness = otherFitness - this.normalizedWeights[index] * Math.abs(other.getFitnessValues()[index]);
        }

        return ownFitness == otherFitness ? 0 : (int)Math.signum(ownFitness - otherFitness);
    }

    @Override
    public double[] getFitnessValues() {
        return fitnessValues;
    }
    
    @Override
    public String toString() {
    	return "WeightedSum [fit=" + Arrays.toString(fitnessValues) + ", w" + Arrays.toString(normalizedWeights) + "]";
    }

    @Override
    public int intValue() {
        throw new UnsupportedOperationException("Only allows conversion to a double value.");
    }

    @Override
    public long longValue() {
        throw new UnsupportedOperationException("Only allows conversion to a double value.");
    }

    @Override
    public float floatValue() {
        throw new UnsupportedOperationException("Only allows conversion to a double value.");
    }

    @Override
    public double doubleValue() {
        if(fitnessValues.length != 1) {
            throw new UnsupportedOperationException("Only allows conversion with a single double value.");
        }
        return fitnessValues[0];
    }
}
