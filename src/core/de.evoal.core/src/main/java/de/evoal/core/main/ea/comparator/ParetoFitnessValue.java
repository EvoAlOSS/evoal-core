package de.evoal.core.main.ea.comparator;

import java.util.Arrays;

import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import io.jenetics.ext.moea.Vec;
import lombok.NonNull;

public class ParetoFitnessValue implements FitnessValue {
    private final Vec<double []> fitnessValues;

    private ParetoFitnessValue(final @NonNull double[] fitnessValues) {
        this.fitnessValues = Vec.of(fitnessValues);
    }

    public static FitnessValue of(final double [] fitnessValues) {
        return new ParetoFitnessValue(fitnessValues);
    }

    @Override
    public int compareTo(final FitnessValue other) {
        if(!(other instanceof ParetoFitnessValue)) {
            throw new IllegalArgumentException("Only allowed to compare pareto fitness values");
        }

        return this.makeAbsolute().compareTo(((ParetoFitnessValue)other).makeAbsolute());
    }
    
    private final Vec<double[]> makeAbsolute(){
    	final double [] values = fitnessValues.data();
    	final double [] negativeAbsoluteValues = Arrays.stream(values)
    			                                       .map(d -> -Math.abs(d))
    			                                       .toArray();
    	
    	return Vec.of(negativeAbsoluteValues);
    }

    @Override
    public String toString() {
    	return "ParetoComparatorType [values=" + fitnessValues + "]";
    }

    @Override
    public Object[] toStatistics() {
        final Object [] result = new Object[fitnessValues.length()];

        for(int i = 0; i < result.length; ++i) {
            result[i] = fitnessValues.data()[i];
        }

        return result;
    }
}
