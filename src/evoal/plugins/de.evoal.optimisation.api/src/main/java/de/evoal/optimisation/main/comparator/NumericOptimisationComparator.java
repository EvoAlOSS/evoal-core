package de.evoal.optimisation.main.comparator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.utils.Requirements;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.model.OptimisationValueComparator;

/**
 * Comparator for a single objective (DL type {@code 'numeric-comparator'}). It compares the
 *   canonical fitness, which has exactly one component.
 */
@Dependent
@Named("de.evoal.optimisation.core.numeric-comparator")
public class NumericOptimisationComparator implements OptimisationValueComparator {
    /**
     * The only compared fitness component.
     */
    private static final int[] ORDER = {0};

    /**
     * The value conversions of the problem goals, only used by the evolutionary algorithm,
     *   which does not compute a fitness yet.
     */
    @Inject @Named("optimisation-value-conversions")
    private Map<EStructuralFeature, Function<Number, Number>> valueConversions;

    /**
     * Creates the optimisation value from the objectives and today's value conversions.
     *   Only the evolutionary algorithm uses it; it is removed when the algorithm is rebuilt.
     */
    @Override
    public NumericOptimisationValue toValue(final TypedEObject fitnessValues) {
        return NumericOptimisationValue.of(valueConversions, fitnessValues);
    }

    /**
     * @throws IllegalArgumentException if the fitness has not exactly one component.
     */
    @Override
    public FitnessValue toValue(final TypedEObject objectives, final Fitness fitness) {
        Requirements.requireEqual(fitness.size(), 1);

        final FitnessComponent component = fitness.layout().component(0);
        final List<EStructuralFeature> statisticsFeatures = component.goal()
                                                                     .map(Goal::objective)
                                                                     .stream()
                                                                     .toList();

        return FitnessValue.of(objectives, fitness, ORDER, statisticsFeatures);
    }
}
