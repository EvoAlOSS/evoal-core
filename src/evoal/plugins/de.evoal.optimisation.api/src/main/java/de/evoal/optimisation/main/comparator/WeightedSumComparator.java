package de.evoal.optimisation.main.comparator;

import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.VariableToEObjectHelper;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.core.api.dynamic.EAnnotationHelper;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.core.weighted-sum")
public class WeightedSumComparator implements OptimisationValueComparator {
    @Inject
    protected AttributeHelper attributes;

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private EAnnotationHelper annotations;

    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    @Inject @Named("optimisation-value-conversions")
    private Map<EStructuralFeature, Function<Number, Number>> valueConversions;

    private final Map<EStructuralFeature, Double> weightsMap = new HashMap<>();

    @Override
    public WeightedSumOptimisationValue toValue(final TypedEObject fitnessValues) {
        return WeightedSumOptimisationValue.of(weightsMap, fitnessValues);
    }

    @Override
    public WeightedSumComparator init(final EObject config) {
        final EObject[] weights = evaluator.attributeToEObjectArray(config, "weights");
        // set all weights to a default value
        optimisationSpace.forEach(f -> weightsMap.put(f, 1.0));

        // read the weights from configuration
        final Map<DataDescription, EStructuralFeature> optimisationFeatures = annotations.featuresOf(optimisationSpace);
        for(final EObject weightConfig : weights) {
            // 'var' is the feature of the data, map it to the optimisation space
            final EStructuralFeature variable = attributes.lookup(weightConfig, "var");
            final Optional<EStructuralFeature> feature = annotations.dataDescriptionOf(variable)
                                                                   .map(optimisationFeatures::get);

            if(feature.isEmpty()) {
                log.info("Could not find feature with name '{}' in the optimisation space", variable.getName());
                continue;
            }

            weightsMap.put(feature.get(), evaluator.attributeToDouble(weightConfig, "val"));
        }

        // normalize weights
        final double total = weightsMap.values().stream().mapToDouble(Double::doubleValue).sum();
        for(final Map.Entry<EStructuralFeature, Double> entry : weightsMap.entrySet()) {
            entry.setValue(entry.getValue() / total);
        }

        // apply optimisation direction
        for(final Map.Entry<EStructuralFeature, Double> entry : weightsMap.entrySet()) {
            entry.setValue(valueConversions.get(entry.getKey()).apply(entry.getValue()).doubleValue());
        }

        return this;
    }
}
