package de.evoal.optimisation.api.events;

import de.evoal.models.v202704.optimisation.memory.Iteration;

/**
 * An iteration is finished. The iteration holds the values of all iteration metrics.
 *
 * @param iteration The memory state of the iteration.
 */
public record IterationFinished(Iteration iteration) implements RunEvent {
}
