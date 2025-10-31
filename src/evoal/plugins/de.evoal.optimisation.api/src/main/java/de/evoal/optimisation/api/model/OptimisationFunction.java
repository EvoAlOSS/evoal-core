package de.evoal.optimisation.api.model;

import java.util.function.Function;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;

/**
 * The function to optimise. Maps between the search and the optimisation space.
 */
public interface OptimisationFunction extends EvoalComponent<OptimisationFunction>, Function<Properties, double []> {
    /**
     * Applies the optimisation function to the passed candidate.
     *
     * @param candidate The candidate instance.
     * @return The result of the function.
     */
    default double [] apply(final Properties candidate) {
        return evaluate(candidate);
    }

    /**
     * @link {{@link #apply(Properties)}}
     */
    double [] evaluate(final Properties candidate);
}
