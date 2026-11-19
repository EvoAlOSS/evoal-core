package de.evoal.optimisation.main.comparator;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.utils.Requirements;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.model.OptimisationValueComparator;

/**
 * Base class of the comparators that prefer feasible candidates
 *   ({@link FeasibilityValue}): {@code 'feasibility-comparator'} and
 *   {@code 'epsilon-comparator'}. Like {@code 'numeric-comparator'}, they compare a fitness
 *   with exactly one component.
 */
abstract class AbstractFeasibilityComparator implements OptimisationValueComparator {
    /**
     * The only compared fitness component.
     */
    private static final int[] ORDER = {0};

    /**
     * @return The violation up to which a candidate counts as feasible.
     */
    protected abstract double epsilon();

    /**
     * @return Whether two infeasible candidates with the same violation are compared by their
     *   fitness.
     */
    protected abstract boolean fitnessOnEqualViolation();

    /**
     * @return The constraint group.
     */
    protected abstract String group();

    /**
     * @throws IllegalStateException always: the comparator needs the violation record.
     */
    @Override
    public FeasibilityValue toValue(final TypedEObject objectives, final Fitness fitness) {
        throw new IllegalStateException("'" + getClass().getSimpleName()
                                        + "' needs the violation record of the candidate.");
    }

    /**
     * @throws IllegalArgumentException if the fitness has not exactly one component, or the
     *   problem has no constraint in the group.
     */
    @Override
    public FeasibilityValue toValue(final TypedEObject objectives,
                                    final Fitness fitness,
                                    final ViolationRecord violations) {
        Requirements.requireEqual(fitness.size(), 1);

        final FitnessComponent component = fitness.layout().component(0);
        final List<EStructuralFeature> statisticsFeatures = component.goal()
                                                                     .map(Goal::objective)
                                                                     .stream()
                                                                     .toList();
        final FitnessValue fitnessValue = FitnessValue.of(objectives, fitness, ORDER, statisticsFeatures);
        final double violation = violations.violation(group());

        return new FeasibilityValue(fitnessValue, violation, epsilon(), fitnessOnEqualViolation());
    }
}
