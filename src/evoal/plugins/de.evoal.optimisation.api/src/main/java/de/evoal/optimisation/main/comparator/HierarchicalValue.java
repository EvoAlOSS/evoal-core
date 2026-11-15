package de.evoal.optimisation.main.comparator;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.languages.model.interpreter.numeric.BooleanNumberOperations;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl;

import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;


public class HierarchicalValue extends OptimisationValueWithDistanceImpl {
    @Getter
    private final @NonNull TypedEObject fitnessValues;
    private final @NonNull List<EStructuralFeature> featureOrder;
    private final @NonNull Map<EStructuralFeature, Function<Number, Number>> valueConversions;

    private HierarchicalValue(final @NonNull Map<EStructuralFeature, Function<Number, Number>> valueConversions, final @NonNull TypedEObject fitnessValues, final @NonNull List<EStructuralFeature> featureOrder) {
        this.featureOrder = featureOrder;
        this.fitnessValues = fitnessValues;
        this.valueConversions = valueConversions;
    }

    public static HierarchicalValue of(final @NonNull Map<EStructuralFeature, Function<Number, Number>> valueConversions, final @NonNull TypedEObject fitnessValues, final @NonNull List<EStructuralFeature> featureOrder) {
        return new HierarchicalValue(valueConversions, fitnessValues, featureOrder);
    }

    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        if(other instanceof HierarchicalValue hv) {
            for(int index = 0; index < featureOrder.size(); ++index) {
                final EStructuralFeature feature1 = featureOrder.get(index);
                final EStructuralFeature feature2 = hv.featureOrder.get(index);
                final Number thisNormalizedValue = valueConversions.get(feature1).apply(fitnessValues.eGetAsNumber(feature1));
                final Number otherNormalizedValue = hv.valueConversions.get(feature2).apply(hv.fitnessValues.eGetAsNumber(feature2));

                if(!BooleanNumberOperations.isEqualTo(thisNormalizedValue, otherNormalizedValue)) {
                    return ArithmeticNumberOperations.compare(thisNormalizedValue, otherNormalizedValue);
                }
            }

            return 0;
        } else{
            throw new IllegalArgumentException("Only allowed to compare HierarchicalValue");
        }
    }

    @Override
    public double distanceFrom(final @NonNull OptimisationValue other) {
        final double distance = 0.0;

        if(other instanceof HierarchicalValue hv) {
            return featureOrder
                    .stream()
                    .mapToDouble(f -> ArithmeticNumberOperations.minus(fitnessValues.eGetAsNumber(f), hv.fitnessValues.eGetAsNumber(f)).doubleValue())
                    .map(Math::abs)
                    .sum();
        } else{
            throw new IllegalArgumentException("Only allowed to compare HierarchicalValue");
        }
    }

    @Override
    public String toString() {
    	return "HierarchicalValue [fit=" +
                    fitnessValues +
                    ", order=" +
                    featureOrder.stream().map(EStructuralFeature::getName).collect(Collectors.joining(", ")) +
                "]";

    }

    @Override
    public List<Object> toStatistics() {
        return featureOrder
                .stream()
                .map(fitnessValues::eGet)
                .toList();
    }
}
