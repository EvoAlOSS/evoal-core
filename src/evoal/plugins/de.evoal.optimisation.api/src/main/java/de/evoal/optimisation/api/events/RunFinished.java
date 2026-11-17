package de.evoal.optimisation.api.events;

import de.evoal.models.v202704.optimisation.memory.Execution;

/**
 * The run is finished. The execution metrics are final.
 *
 * @param execution The execution of the run.
 */
public record RunFinished(Execution execution) implements RunEvent {
}
