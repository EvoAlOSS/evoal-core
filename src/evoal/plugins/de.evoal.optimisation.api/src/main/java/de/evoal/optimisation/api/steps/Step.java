package de.evoal.optimisation.api.steps;

import java.util.List;

import de.evoal.optimisation.api.run.Candidate;

/**
 * A step of an algorithm. Every step belongs to one kind of the meta-algorithm model,
 *   given by the interface it implements.
 */
public interface Step {
    /**
     * @return What the step does, e.g., "sample random candidates". Together with the
     *   {@link #kind()}, it describes the step in the memory model.
     */
    String description();

    /**
     * Executes the step.
     *
     * @param state The state of the search.
     */
    void execute(SearchState state);

    /**
     * @return The kind of the step in the meta-algorithm model, e.g., {@code Selection}.
     */
    String kind();

    /**
     * The candidates the step created or evaluated, which the memory model records as the
     *   individuals of the step; the kinds of steps give the usual ones, e.g., the selected
     *   members of a selection or the new population of an acceptance. What a step read is the
     *   lineage of its outputs.
     *
     * @param state The state of the search right after the step.
     * @return The outputs of the step, in its order; none by default, e.g., for a parameter
     *   adjustment.
     */
    default List<Candidate> outputs(final SearchState state) {
        return List.of();
    }
}
