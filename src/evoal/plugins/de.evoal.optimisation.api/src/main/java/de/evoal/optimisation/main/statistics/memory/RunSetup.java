package de.evoal.optimisation.main.statistics.memory;

import de.evoal.optimisation.api.execution.EvaluationPosition;

/**
 * What is needed to repeat a run, written as {@code setup} into
 *   {@code execution-information.json}.
 *
 * @param evoalVersion The version of EvoAl that executed the run.
 * @param seed The seed of the EvoAl execution, the same for all of its runs.
 * @param run The index of the run within the EvoAl execution. The random numbers of the run
 *   are derived from the seed, the run and the name of the requesting component.
 * @param evaluationPosition The position of the run in the evaluation setup, {@code null} for
 *   a single run.
 */
public record RunSetup(String evoalVersion, long seed, long run, EvaluationPosition evaluationPosition) {
}
