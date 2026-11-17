package de.evoal.optimisation.api.events;

/**
 * An event of an optimisation run, see the package documentation for the order of the
 *   events. Listeners select the events they need with a {@code switch} over the event types.
 */
public sealed interface RunEvent permits RunStarted,
                                         IterationStarted,
                                         StepExecuted,
                                         IndividualEvaluated,
                                         IterationFinished,
                                         RunFinished {
}
