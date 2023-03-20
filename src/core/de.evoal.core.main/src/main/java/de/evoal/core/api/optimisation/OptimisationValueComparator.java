package de.evoal.core.api.optimisation;

import de.evoal.languages.model.instance.Instance;

import java.util.function.Function;

/**
 * Converts a given optimisation value (result of {@link de.evoal.core.api.optimisation.OptimisationFunction})
 * into a {@link OptimisationValue} for comparison.
 */
public interface OptimisationValueComparator extends Function<double [], OptimisationValue> {

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
     * Creates an optimisation value instance for raw fitness values.
     *
     * @param optimisationValues the raw values.
     * @return The calculated optimisation value.
     */
    OptimisationValue toValue(final double [] optimisationValues);



    OptimisationValueComparator init(final Instance config);
}
