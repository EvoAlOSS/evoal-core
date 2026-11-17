package de.evoal.optimisation.api.steps;

/**
 * Chooses a single member or a subset of the population as the current candidates, e.g.,
 *   the parents of the next adaption.
 */
public interface Selection extends Step {
    @Override
    default String kind() {
        return "Selection";
    }
}
