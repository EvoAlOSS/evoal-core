package de.evoal.optimisation.api.model;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.core.cdi.EvoalComponent;

import java.util.function.Function;

import de.evoal.optimisation.api.fitness.Fitness;

/**
 * Converts a given optimisation value (result of {@link de.evoal.models.v202704.optimisation.execution.OptimisationFunction})
 * into a {@link TypedEObject} for comparison.
 */
public interface OptimisationValueComparator extends EvoalComponent<OptimisationValueComparator>, Function<TypedEObject, OptimisationValue> {

    /**
     * Applies the comparator to a given set of raw optimisation values.
     *
     * @param optimisationValues the raw values.
     * @return the optimisation value for comparison.
     */
    default OptimisationValue apply(final TypedEObject optimisationValues) {
        return toValue(optimisationValues);
    }

    /**
     * Creates an optimisation value instance for raw malus values.
     *
     * @param optimisationValues the raw values.
     * @return The calculated optimisation value.
     */
    OptimisationValue toValue(final TypedEObject optimisationValues);

    /**
     * Creates the optimisation value of a candidate from its objectives and its canonical
     *   fitness. Comparators that compare the fitness override this method; the default
     *   ignores the fitness and uses {@link #toValue(TypedEObject)}.
     *
     * @param objectives The objectives of the candidate.
     * @param fitness The canonical fitness of the candidate (smaller is better).
     * @return The optimisation value for comparison.
     */
    default OptimisationValue toValue(final TypedEObject objectives, final Fitness fitness) {
        return toValue(objectives);
    }
}
