package de.evoal.optimisation.api.model;

import de.evoal.core.api.cdi.EvoalComponent;

import java.util.function.Function;

/**
 * Converts a given optimisation value (result of {@link OptimisationFunction})
 * into a {@link OptimisationValue} for comparison.
 */
public interface OptimisationValueComparator extends EvoalComponent<OptimisationValueComparator>, Function<double [], OptimisationValue> {

    /**
     * Applies the comparator to a given set of raw optimisation values.
     *
     * @param optimisationValues the raw values.
     * @return the optimisation value for comparison.
     */
    default OptimisationValue apply(final double [] optimisationValues) {
        return toValue(optimisationValues);
    }

    /**
     * Creates an optimisation value instance for raw malus values.
     *
     * @param optimisationValues the raw values.
     * @return The calculated optimisation value.
     */
    OptimisationValue toValue(final double [] optimisationValues);
}
