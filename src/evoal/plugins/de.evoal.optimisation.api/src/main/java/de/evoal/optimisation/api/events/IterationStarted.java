package de.evoal.optimisation.api.events;

/**
 * An iteration starts. Iteration 0 creates and evaluates the initial candidates.
 *
 * @param number The number of the iteration.
 */
public record IterationStarted(int number) implements RunEvent {
}
