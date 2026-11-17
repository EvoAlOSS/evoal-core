package de.evoal.optimisation.api.steps;

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
}
