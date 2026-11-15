package de.evoal.optimisation.main.comparator;

import lombok.NonNull;

import java.util.Map;
import java.util.function.Function;

import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * TODO Check this implementation.
 */
public class EpsilonOptimisationValue extends NumberOptimisationValue {
    private EpsilonOptimisationValue(final @NonNull Map<EStructuralFeature, Function<Number, Number>> valueConversions, final TypedEObject optimisationSpace, final @NonNull EStructuralFeature feature) {
        super(new NumberOptimisationValueImpl(optimisationSpace, optimisationSpace.eGetAsNumber(feature), valueConversions.get(feature)));
    }

    public static EpsilonOptimisationValue of(final @NonNull Map<EStructuralFeature, Function<Number, Number>> valueConversions, @NonNull final TypedEObject optimisationSpaceValue, final @NonNull EStructuralFeature feature) {
        return new EpsilonOptimisationValue(valueConversions,
                optimisationSpaceValue,
                feature);
    }
    @Override
    public String toString() {
        return "EpsilonOptimisationValue [" + delegate.fitnessValue + "]";
    }
}