package de.evoal.optimisation.main.comparator;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import de.evoal.optimisation.api.model.OptimisationValueComparator;
import org.eclipse.emf.ecore.EStructuralFeature;

@Dependent
@Named("de.evoal.optimisation.core.numeric-comparator")
public class NumericOptimisationComparator implements OptimisationValueComparator {
    @Inject @Named("optimisation-value-conversions")
    private Map<EStructuralFeature, Function<Number, Number>> valueConversions;

    @Override
    public NumericOptimisationValue toValue(final TypedEObject fitnessValues) {
        return NumericOptimisationValue.of(valueConversions, fitnessValues);
    }
}
