package de.evoal.optimisation.main.comparator;

import java.util.List;

import jakarta.enterprise.context.Dependent;
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
