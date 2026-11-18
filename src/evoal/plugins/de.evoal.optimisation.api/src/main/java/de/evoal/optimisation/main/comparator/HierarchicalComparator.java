package de.evoal.optimisation.main.comparator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.model.OptimisationValueComparator;

/**
 * Compares the objectives in the configured order (DL type {@code 'hierarchical-comparator'}):
 *   first the first objective; only if it is equal, the next one, and so on. It compares the
 *   canonical fitness components of the objectives.
 */
@Dependent
@Named("de.evoal.optimisation.core.hierarchical-comparator")
public class HierarchicalComparator implements OptimisationValueComparator {
    @Inject
    private EAnnotationHelper annotations;

    /**
     * The objectives in the order of comparison.
     */
    private List<EStructuralFeature> dimensionOrder;

    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The positions of the objectives' fitness components in {@link #resolvedLayout}, in the
     *   order of comparison.
     */
    private int[] fitnessOrder;

    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    /**
     * The layout {@link #fitnessOrder} was resolved for; all candidates of a run share it.
     */
    private FitnessLayout resolvedLayout;

    /**
     * The value conversions of the problem goals, only used by the evolutionary algorithm,
     *   which does not compute a fitness yet.
     */
    @Inject @Named("optimisation-value-conversions")
    private Map<EStructuralFeature, Function<Number, Number>> valueConversions;

    @Override
    public HierarchicalComparator init(final EObject config) {
        final DataDescription[] order = evaluator.attributeToDataDescriptionArray(config, "order");
        final Map<DataDescription, EStructuralFeature> features = annotations.featuresOf(optimisationSpace);
        dimensionOrder = Arrays.stream(order)
                               .map(features::get)
                               .toList();
        return this;
    }

    /**
     * Resolves the objectives of the order to the positions of their fitness components.
     *
     * @throws IllegalArgumentException if an objective has no fitness component.
     */
    private int[] toFitnessOrder(final FitnessLayout layout) {
        if(layout != resolvedLayout) {
            fitnessOrder = dimensionOrder.stream()
                                         .map(EStructuralFeature::getName)
                                         .mapToInt(layout::indexOf)
                                         .toArray();
            resolvedLayout = layout;
        }

        return fitnessOrder;
    }

    /**
     * Creates the optimisation value from the objectives and today's value conversions.
     *   Only the evolutionary algorithm uses it; it is removed when the algorithm is rebuilt.
     */
    @Override
    public HierarchicalValue toValue(final TypedEObject fitnessValues) {
        return HierarchicalValue.of(valueConversions, fitnessValues, dimensionOrder);
    }

    @Override
    public FitnessValue toValue(final TypedEObject objectives, final Fitness fitness) {
        final int[] order = toFitnessOrder(fitness.layout());

        return FitnessValue.of(objectives, fitness, order, dimensionOrder);
    }
}
