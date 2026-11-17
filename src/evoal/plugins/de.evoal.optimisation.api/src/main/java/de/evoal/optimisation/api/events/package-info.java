/**
 * The events of an optimisation run and the listeners that receive them.
 * <p>
 * The {@link de.evoal.optimisation.api.events.RunEventDispatcher} passes every
 *   {@link de.evoal.optimisation.api.events.RunEvent} of the current run to the
 *   {@link de.evoal.optimisation.api.events.RunListener}s of the run, synchronously and in
 *   the order the listeners were registered. A run publishes its events in this order:
 * <pre>
 * RunStarted
 *   IterationStarted(0) (StepExecuted | IndividualEvaluated)* IterationFinished(0)
 *   IterationStarted(1) (StepExecuted | IndividualEvaluated)* IterationFinished(1)
 *   ...
 * RunFinished
 * </pre>
 * {@link de.evoal.optimisation.api.events.StepExecuted} is published by the
 *   {@link de.evoal.optimisation.api.steps.Template} after every step.
 * Listeners observe the run: they must not change the data of an event, so that they
 *   cannot change the search result.
 */
package de.evoal.optimisation.api.events;
