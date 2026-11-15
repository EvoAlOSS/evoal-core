package de.evoal.optimisation.main.comparator;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.languages.model.base.definitions.DataDescription;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Map;
import java.util.function.Function;

@Dependent
@Named("de.evoal.optimisation.core.epsilon-comparator")
public class EpsilonComparator implements OptimisationValueComparator {

    @Inject
    private EAnnotationHelper helper;

    @Inject
    private AttributeEvaluator evaluator;

    private EStructuralFeature feature;

    @Inject
    @Named("optimisation-space")
    private Space optimisationSpace;

    @Inject @Named("optimisation-value-conversions")
    private Map<EStructuralFeature, Function<Number, Number>> valueConversions;

    @Override
    public EpsilonOptimisationValue toValue(final TypedEObject fitnessValues) {
        return EpsilonOptimisationValue.of(valueConversions, fitnessValues, feature);
    }

    @Override
    public OptimisationValueComparator init(final EObject config) {
        final DataDescription goalData = evaluator.attributeToDataDescription(config, "goal-objective");

        feature = helper.featureOf(optimisationSpace, goalData);

        return this;
    }
}