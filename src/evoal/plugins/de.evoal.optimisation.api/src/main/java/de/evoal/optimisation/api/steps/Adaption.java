package de.evoal.optimisation.api.steps;

/**
 * Changes one or more candidates, e.g., by mutation, recombination or moving particles.
 *   The changed candidates refer to the members of the population they come from
 *   ({@link de.evoal.optimisation.api.run.Lineage}).
 */
public interface Adaption extends Step {
    @Override
    default String kind() {
        return "Adaption";
    }
}
