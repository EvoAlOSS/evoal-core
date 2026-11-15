package de.evoal.optimisation.main.comparator;

import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.ecore.*;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.utils.Requirements;

public class NumericOptimisationValue extends NumberOptimisationValue {

    private NumericOptimisationValue(final @NonNull Function<Number, Number> valueConversions, final TypedEObject optimisationSpaceValue, final @NonNull Number[] fitnessValues) {
        super(new NumberOptimisationValueImpl(optimisationSpaceValue, fitnessValues[0], valueConversions));

        Requirements.requireEqual(fitnessValues.length, 1);
    }

    public static NumericOptimisationValue of(final @NonNull Map<EStructuralFeature, Function<Number, Number>> valueConversions, final TypedEObject fitnessValues) {
        Requirements.requireEqual(fitnessValues.eSpace().size(), 1);
        return new NumericOptimisationValue(
                valueConversions.get(fitnessValues.eSpace().getFirst()),
                fitnessValues,
                fitnessValues
                        .eSpace()
                        .stream()
                        .map(fitnessValues::eGetAsDouble)
                        .toArray(Number[]::new));
    }

    @Override
    public String toString() {
    	return "NumericOptimisationValue [" + delegate.fitnessValue + "]";
    }
}
