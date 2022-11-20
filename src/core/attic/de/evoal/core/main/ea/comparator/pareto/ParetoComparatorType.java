package de.evoal.core.main.ea.comparator.pareto;

import java.util.Arrays;

import de.evoal.core.api.ea.fitness.type.FitnessType;
import io.jenetics.ext.moea.Vec;
import lombok.NonNull;

public class ParetoComparatorType implements FitnessType {
    private final Vec<double []> fitnessValues;

    private ParetoComparatorType(final @NonNull double[] fitnessValues) {
        this.fitnessValues = Vec.of(fitnessValues);
    }

    public static FitnessType of(final double [] fitnessValues) {
        return new ParetoComparatorType(fitnessValues);
    }

    @Override
    public int compareTo(final FitnessType other) {
        return this.makeAbsolute().compareTo(((ParetoComparatorType)other).makeAbsolute());
    }
    
    private final Vec<double[]> makeAbsolute(){
    	final double [] values = fitnessValues.data();
    	final double [] negativeAbsoluteValues = Arrays.stream(values)
    			                                       .map(d -> -Math.abs(d))
    			                                       .toArray();
    	
    	return Vec.of(negativeAbsoluteValues);
    }

    @Override
    public double[] getFitnessValues() {
        return fitnessValues.data();
    }

    @Override
    public String toString() {
    	return "ParetoComparatorType [values=" + fitnessValues + "]";
    }
}
