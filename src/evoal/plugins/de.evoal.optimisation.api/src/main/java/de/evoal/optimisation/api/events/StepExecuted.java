package de.evoal.optimisation.api.events;

import de.evoal.models.v202704.optimisation.memory.IterationStep;

/**
 * A step of an iteration was executed, e.g., a selection or an adaption.
 *
 * @param iteration The number of the iteration the step belongs to.
 * @param step The description and the result of the step.
 */
public record StepExecuted(int iteration, IterationStep step) implements RunEvent {
}
