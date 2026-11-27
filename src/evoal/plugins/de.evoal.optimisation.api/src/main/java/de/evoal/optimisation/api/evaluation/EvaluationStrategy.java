package de.evoal.optimisation.api.evaluation;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * How often a candidate is evaluated (DL type {@code 'evaluation-strategy'} of the
 *   algorithm). The {@link de.evoal.optimisation.api.fitness.Evaluator} evaluates every new
 *   candidate {@link #samplesOfNewCandidates()} times; with {@link #reEvaluates()}, the step
 *   {@link de.evoal.optimisation.api.steps.ReEvaluatePopulation} evaluates every member once
 *   more at the start of an iteration.
 */
public interface EvaluationStrategy extends EvoalComponent<EvaluationStrategy> {
    /**
     * @return The number of evaluations of a new candidate, at least 1.
     */
    int samplesOfNewCandidates();

    /**
     * @return Whether the members of the population are evaluated once more in every
     *   iteration.
     */
    boolean reEvaluates();

    /**
     * @return How the samples of a candidate are aggregated, {@code null} if every candidate
     *   has exactly one sample ({@code 'single-evaluation'}).
     */
    SampleAggregation aggregation();

    /**
     * @return Whether the candidates can have several samples, whose number and spread the
     *   memory model records.
     */
    default boolean samples() {
        return aggregation() != null;
    }

    /**
     * Reads the configuration of the strategy.
     *
     * @param configuration The configuration of the strategy.
     * @return The strategy.
     */
    @Override
    EvaluationStrategy init(EObject configuration);
}
