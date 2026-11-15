package de.evoal.optimisation.main.comparator;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.Pair;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl;

import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;


public class WeightedSumOptimisationValue extends OptimisationValueWithDistanceImpl {
    @Getter
    private final TypedEObject fitnessValues;
    private final Map<EStructuralFeature, Double> weights;

    private WeightedSumOptimisationValue(final Map<EStructuralFeature, Double> weights, final @NonNull TypedEObject fitnessValues) {
        this.weights = weights;
        this.fitnessValues = fitnessValues;
    }

    public static WeightedSumOptimisationValue of(final Map<EStructuralFeature, Double> weights, final TypedEObject fitnessValues) {
        return new WeightedSumOptimisationValue(weights, fitnessValues);
    }

    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        final Pair<Number, Number> values = calculate(other);

        return ArithmeticNumberOperations.compare(values.getFirst(), values.getSecond());
    }

    @Override
    public double distanceFrom(final @NonNull OptimisationValue other) {
        final Pair<Number, Number> values = calculate(other);

        return ArithmeticNumberOperations.abs(ArithmeticNumberOperations.minus(values.getFirst(), values.getSecond())).doubleValue();
    }

    private Pair<Number, Number> calculate(@NonNull OptimisationValue other) {
        if(!(other instanceof WeightedSumOptimisationValue otherValue)) {
            throw new IllegalArgumentException("Only allowed to compare WeightedSumFitnessValue");
        }

        Number ownFitness = 0.0;
        Number otherFitness = 0.0;

        for(final EStructuralFeature feature : fitnessValues.eSpace()) {
            // TODO Do we want to use Math.abs for the fitness values here?
            ownFitness   = ArithmeticNumberOperations.add(ownFitness, ArithmeticNumberOperations.multiply(this.weights.get(feature), this.fitnessValues.eGetAsNumber(feature)));
            otherFitness = ArithmeticNumberOperations.add(otherFitness, ArithmeticNumberOperations.multiply(this.weights.get(feature), otherValue.fitnessValues.eGetAsNumber(feature)));
        }

        return new Pair<>(ownFitness, otherFitness);
    }

    @Override
    public String toString() {
    	return "WeightedSum [fit=[" +
                fitnessValues
                        .eSpace()
                        .stream()
                        .map(fitnessValues::eGet)
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")) +
                "], w=[" +
                fitnessValues
                        .eSpace()
                        .stream()
                        .map(weights::get)
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")) +
                "]]";
    }

    @Override
    public List<Object> toStatistics() {
        return fitnessValues.eSpace()
                .stream()
                .map(fitnessValues::eGet)
                .toList();
    }

    @Override
    public TypedEObject toOptmisationSpace() {
        return fitnessValues;
    }
}
