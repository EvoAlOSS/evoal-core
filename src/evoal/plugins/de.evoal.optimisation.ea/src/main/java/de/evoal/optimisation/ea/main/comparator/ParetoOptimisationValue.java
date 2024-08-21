package de.evoal.optimisation.ea.main.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

import de.evoal.optimisation.api.model.OptimisationValue;
import io.jenetics.ext.moea.ElementComparator;
import io.jenetics.ext.moea.ElementDistance;
import io.jenetics.ext.moea.Vec;
import lombok.NonNull;

public class ParetoOptimisationValue implements OptimisationValue {
    private final Vec<double []> fitnessValues;

    private ParetoOptimisationValue(final @NonNull double[] fitnessValues) {
        this.fitnessValues = Vec.of(fitnessValues);
    }

    public static OptimisationValue of(final double [] fitnessValues) {
        return new ParetoOptimisationValue(fitnessValues);
    }

    @Override
    public int compareTo(final OptimisationValue other) {
        if(!(other instanceof ParetoOptimisationValue)) {
            throw new IllegalArgumentException("Only allowed to compare pareto fitness values");
        }

        return this.makeAbsolute().compareTo(((ParetoOptimisationValue)other).makeAbsolute());
    }
    
    private Vec<double[]> makeAbsolute(){
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

    public static ElementComparator<ParetoOptimisationValue> compare() {
        return (u, v, i) -> u.fitnessValues.compare(v.fitnessValues, i);
    }

    public static Comparator<ParetoOptimisationValue> dominance() {
        return (u, v) -> Vec.dominance(u.fitnessValues.data(), v.fitnessValues.data());
    }

    public static ElementDistance<ParetoOptimisationValue> distance() {
        return (u, v, i) -> u.fitnessValues.distance(v.fitnessValues, i);
    }

    public static ToIntFunction<ParetoOptimisationValue> dimension() {
        return u -> u.fitnessValues.length();
    }
}
