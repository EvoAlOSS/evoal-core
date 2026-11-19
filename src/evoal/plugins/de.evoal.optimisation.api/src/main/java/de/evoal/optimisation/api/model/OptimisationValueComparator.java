package de.evoal.optimisation.api.model;

import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.fitness.Fitness;

/**
 * Creates the optimisation value of a candidate (DL type {@code comparator}): the value the
 *   algorithms compare. A comparator compares the canonical fitness, where smaller is better.
 */
public interface OptimisationValueComparator extends EvoalComponent<OptimisationValueComparator> {
    /**
     * Creates the optimisation value of a candidate from its objectives and its canonical
     *   fitness.
     *
     * @param objectives The objectives of the candidate, shown in the statistics.
     * @param fitness The canonical fitness of the candidate (smaller is better).
     * @return The optimisation value for comparison.
     */
    OptimisationValue toValue(final TypedEObject objectives, final Fitness fitness);

    /**
     * Creates the optimisation value of a candidate from its objectives, its canonical
     *   fitness and its violation record. The {@link de.evoal.optimisation.api.fitness.Evaluator}
     *   calls this method. Comparators that ignore the constraints keep the default, which
     *   calls {@link #toValue(TypedEObject, Fitness)}.
     *
     * @param objectives The objectives of the candidate, shown in the statistics.
     * @param fitness The canonical fitness of the candidate (smaller is better).
     * @param violations How far the candidate violates the constraints of the problem.
     * @return The optimisation value for comparison.
     */
    default OptimisationValue toValue(final TypedEObject objectives,
                                      final Fitness fitness,
                                      final ViolationRecord violations) {
        return toValue(objectives, fitness);
    }
}
