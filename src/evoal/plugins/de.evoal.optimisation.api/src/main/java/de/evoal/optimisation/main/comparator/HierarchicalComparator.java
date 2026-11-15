package de.evoal.optimisation.main.comparator;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.languages.model.base.definitions.DataDescription;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Dependent
@Named("de.evoal.optimisation.core.hierarchical-comparator")
public class HierarchicalComparator implements OptimisationValueComparator {
    @Inject
    private EAnnotationHelper annotations;

    @Inject
    private AttributeEvaluator evaluator;

    private List<EStructuralFeature> dimensionOrder;

    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    @Inject @Named("optimisation-value-conversions")
    private Map<EStructuralFeature, Function<Number, Number>> valueConversions;

    @Override
    public HierarchicalValue toValue(final TypedEObject fitnessValues) {
        return HierarchicalValue.of(valueConversions, fitnessValues, dimensionOrder);
    }

    @Override
    public HierarchicalComparator init(final EObject config) {
        final DataDescription[] order = evaluator.attributeToDataDescriptionArray(config, "order");

        Map<DataDescription, EStructuralFeature> features = annotations.featuresOf(optimisationSpace);

        dimensionOrder = Arrays.stream(order)
                .map(features::get)
                .toList();

        return this;
    }
}
