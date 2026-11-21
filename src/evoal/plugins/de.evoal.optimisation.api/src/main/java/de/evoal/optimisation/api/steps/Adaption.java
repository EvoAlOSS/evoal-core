package de.evoal.optimisation.api.steps;

import java.util.List;

import de.evoal.optimisation.api.run.Candidate;

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

    /**
     * @return The changed candidates, the current candidates after the step. An adaption that
     *   offers its candidates lazily ({@link SearchState#setOffered}) has no outputs: its
     *   candidates are created while a fitness calculation evaluates them and are its outputs.
     */
    @Override
    default List<Candidate> outputs(final SearchState state) {
        return state.getCandidates();
    }
}
