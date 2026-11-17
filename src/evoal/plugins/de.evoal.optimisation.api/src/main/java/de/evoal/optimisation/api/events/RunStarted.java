package de.evoal.optimisation.api.events;

import de.evoal.models.v202704.optimisation.memory.Execution;

/**
 * The run starts. The metric definitions of the execution are complete.
 *
 * @param execution The execution of the run.
 */
public record RunStarted(Execution execution) implements RunEvent {
}
