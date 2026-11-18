package de.evoal.optimisation.api.evaluation;

import java.util.EnumMap;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.MetricValueType;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.cdi.OptimisationComponentProducer;
import de.evoal.optimisation.api.events.IndividualEvaluated;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;

/**
 * Evaluates candidates with the configured optimisation function
 *   ({@code algorithm.optimisation-function}) and counts the evaluations per
 *   {@link EvaluationSource}. Every call counts, also one that fails. The counters are
 *   the metrics {@code evaluations.real} and {@code evaluations.surrogate} of each
 *   iteration.
 * <p>
 * The number of evaluations of a source can be limited ({@link #limit}). The limit is the
 *   execution metric {@code evaluations.<source>.budget}. With the policy
 *   {@link ExhaustionPolicy#CUT_OFF}, the service throws an
 *   {@link EvaluationBudgetExhaustedException} instead of exceeding the limit.
 * <p>
 * The counters and limits are reset in every run ({@link ExecutionRecorder#startRun()}).
 *   The service is not thread-safe: the algorithms evaluate their candidates one after
 *   another, so that the counter values do not depend on the thread scheduling.
 */
@ApplicationScoped
@Slf4j
public class EvaluationService implements MetricContributor {
    @Inject
    private OptimisationComponentProducer componentProducer;

    /**
     * The number of evaluations per source in the current run.
     */
    private final Map<EvaluationSource, Long> counters = new EnumMap<>(EvaluationSource.class);

    /**
     * Publishes an {@link IndividualEvaluated} for every successful evaluation.
     */
    @Inject
    private RunEventDispatcher events;

    /**
     * The optimisation function of the current run. It is created on first use in a run, so
     *   that applications whose algorithms do not use the service do not create it.
     */
    private OptimisationFunction function;

    /**
     * The limits of the current run, by source.
     */
    private final Map<EvaluationSource, Limit> limits = new EnumMap<>(EvaluationSource.class);

    /**
     * The recorder of the current run. {@code null} before the first run.
     */
    private ExecutionRecorder recorder;

    @Override
    public void contributeTo(final Iteration iteration) {
        for(final EvaluationSource source : EvaluationSource.values()) {
            final long numberOfEvaluations = numberOfEvaluations(source);

            iteration.getMetrics().put(source.getMetricName(), numberOfEvaluations);
        }
    }

    /**
     * The optimisation function of the current run, e.g. for fitness steps that need the
     *   surrogate model the candidates are evaluated with. It is created on the first call
     *   in a run and shared with the evaluations.
     *
     * @return The optimisation function of the current run.
     * @throws IllegalStateException if no run has been started.
     */
    public OptimisationFunction optimisationFunction() {
        requireStartedRun();

        return currentFunction();
    }

    /**
     * @return The optimisation function of the current run.
     */
    private OptimisationFunction currentFunction() {
        if(function == null) {
            function = componentProducer.create(OptimisationFunction.class,
                                                OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                                                "algorithm.optimisation-function");
        }

        return function;
    }

    /**
     * Evaluates a candidate, counts the evaluation and publishes an
     *   {@link IndividualEvaluated} if the evaluation succeeds.
     *
     * @param candidate The candidate (a point of the search space).
     * @return The result of the optimisation function (a point of the optimisation space).
     * @throws EvaluationBudgetExhaustedException if the evaluation would exceed a limit with
     *   the policy {@link ExhaustionPolicy#CUT_OFF}.
     */
    public TypedEObject evaluate(final TypedEObject candidate) {
        requireStartedRun();

        final OptimisationFunction currentFunction = currentFunction();
        final EvaluationSource source = EvaluationSource.of(currentFunction);

        requireBudgetLeft(source);
        counters.merge(source, 1L, Long::sum);

        final TypedEObject output = currentFunction.evaluate(candidate);
        events.publish(new IndividualEvaluated(candidate, output, source));

        return output;
    }

    /**
     * Limits the number of evaluations of a source in the current run. The limit is
     *   recorded as the execution metric {@code evaluations.<source>.budget}, so it has
     *   to be set in the definition phase of the run (while the algorithm is created).
     *   Setting the same limit again has no effect, since the stopping criteria can be
     *   created more than once (e.g., by the statistics writers).
     *
     * @param source The limited source.
     * @param maximum The maximum number of evaluations.
     * @param policy What happens if the limit is reached in the middle of an iteration.
     * @throws IllegalArgumentException if the source already has a different limit.
     * @throws IllegalStateException if the run is not in its definition phase.
     */
    public void limit(final EvaluationSource source, final long maximum, final ExhaustionPolicy policy) {
        requireStartedRun();

        final Limit limit = new Limit(maximum, policy);
        final Limit existingLimit = limits.get(source);

        if(limit.equals(existingLimit)) {
            return;
        }
        if(existingLimit != null) {
            throw new IllegalArgumentException("'" + source.getMetricName() + "' is already limited to "
                                               + existingLimit + ", cannot limit it to " + limit + ".");
        }

        log.info("Limiting '{}' to {} ({}).", source.getMetricName(), maximum, policy);
        limits.put(source, limit);

        final String metricName = source.getBudgetMetricName();
        final String description = "Maximum number of evaluations ('" + source.getMetricName() + "').";
        final MetricDefinition definition = toMetricDefinition(metricName,
                                                               MetricKind.MEASURE,
                                                               MetricScope.EXECUTION,
                                                               description);
        recorder.define(definition);
        recorder.recordExecutionMetric(metricName, maximum);
    }

    /**
     * @param source The source.
     * @return The number of evaluations of the source in the current run.
     */
    public long numberOfEvaluations(final EvaluationSource source) {
        return counters.getOrDefault(source, 0L);
    }

    /**
     * @throws EvaluationBudgetExhaustedException if the source has a limit with the policy
     *   {@link ExhaustionPolicy#CUT_OFF} and the limit is reached.
     */
    private void requireBudgetLeft(final EvaluationSource source) {
        final Limit limit = limits.get(source);
        if(limit == null || limit.policy() != ExhaustionPolicy.CUT_OFF) {
            return;
        }

        final long numberOfEvaluations = numberOfEvaluations(source);
        if(numberOfEvaluations >= limit.maximum()) {
            throw new EvaluationBudgetExhaustedException(source, limit.maximum());
        }
    }

    private void requireStartedRun() {
        if(recorder == null) {
            throw new IllegalStateException("No run has been started. Call ExecutionRecorder.startRun() first.");
        }
    }

    @Override
    public void startRun(final ExecutionRecorder recorder) {
        this.recorder = recorder;
        counters.clear();
        limits.clear();
        function = null;

        for(final EvaluationSource source : EvaluationSource.values()) {
            final MetricDefinition definition = toMetricDefinition(source.getMetricName(),
                                                                   MetricKind.COUNTER,
                                                                   MetricScope.ITERATION,
                                                                   source.getDescription());

            recorder.define(definition);
        }
    }

    /**
     * @return The definition of an integer metric.
     */
    private static MetricDefinition toMetricDefinition(final String name,
                                                       final MetricKind kind,
                                                       final MetricScope scope,
                                                       final String description) {
        final MetricDefinition definition = MemoryFactory.eINSTANCE.createMetricDefinition();
        definition.setName(name);
        definition.setKind(kind);
        definition.setValueType(MetricValueType.INTEGER);
        definition.setScope(scope);
        definition.setDescription(description);

        return definition;
    }

    /**
     * A limit of the number of evaluations of a source.
     *
     * @param maximum The maximum number of evaluations.
     * @param policy What happens if the limit is reached in the middle of an iteration.
     */
    private record Limit(long maximum, ExhaustionPolicy policy) {}
}
