package de.evoal.optimisation.api.evaluation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.Set;
import java.util.concurrent.Callable;

import org.eclipse.emf.ecore.EClass;

import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.cdi.RunScoped;
import de.evoal.core.api.ecore.misc.ConcurrentEClassAccess;
import de.evoal.core.api.random.EvaluationTask;
import de.evoal.core.api.random.RandomService;

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
 * Every evaluation gets an index, assigned in call order across all sources and starting
 *   at 0 in every run. The service binds the {@link EvaluationTask} (run and index) around the
 *   call of the optimisation function, so that the function can draw its random numbers
 *   from {@link RandomService#taskRandom(String)}.
 *
 * <h2>Parallel evaluation</h2>
 * {@link #evaluateAll(List)} evaluates a batch of candidates in three parts:
 * <ol>
 *   <li><em>reserve</em> (calling thread, in input order): checks the budget for the whole
 *     batch and assigns the evaluation indices,</li>
 *   <li><em>compute</em>: calls the optimisation function in the task context of each
 *     index, on the threads of the {@link EvaluationExecutor} if the function is
 *     {@linkplain OptimisationFunction#isThreadSafe() thread-safe}, otherwise one after
 *     another on the calling thread,</li>
 *   <li><em>complete</em> (calling thread, in index order, after all evaluations have
 *     ended): counts the evaluations and publishes the events.</li>
 * </ol>
 * Therefore, the indices, the counters and the order of the events do not depend on the
 *   number of threads. The fitness pipeline and the comparator are not part of the service
 *   and stay on the thread of the algorithm.
 * <p>
 * Every run has its own service, so the counters, the indices and the limits start anew in
 *   every run. The service itself is not thread-safe: only the thread of the algorithm calls
 *   it.
 */
@RunScoped
@Slf4j
public class EvaluationService implements MetricContributor {
    @Inject
    private OptimisationComponentProducer componentProducer;

    /**
     * The number of evaluations per source in the run.
     */
    private final Map<EvaluationSource, Long> counters = new EnumMap<>(EvaluationSource.class);

    /**
     * The index of the next evaluation in the run.
     */
    private long nextIndex;

    /**
     * The threads that compute the evaluations of a batch. Only used for batches of a
     *   thread-safe function.
     */
    @Inject
    private EvaluationExecutor executor;

    /**
     * Whether the classes of the run have been prepared for parallel evaluations.
     */
    private boolean preparedForThreads;

    /**
     * Whether the current run has reported that its function is evaluated sequentially.
     */
    private boolean reportedSequentialEvaluation;

    /**
     * Provides the run of the evaluation tasks.
     */
    @Inject
    private RandomService randomService;

    /**
     * Publishes an {@link IndividualEvaluated} for every successful evaluation.
     */
    @Inject
    private RunEventDispatcher events;

    /**
     * The optimisation function of the run. It is created on first use in a run, so
     *   that applications whose algorithms do not use the service do not create it.
     */
    private OptimisationFunction function;

    /**
     * The limits of the run, by source.
     */
    private final Map<EvaluationSource, Limit> limits = new EnumMap<>(EvaluationSource.class);

    /**
     * The recorder of the run.
     */
    @Inject
    private ExecutionRecorder recorder;

    @Override
    public void contributeTo(final Iteration iteration) {
        for(final EvaluationSource source : EvaluationSource.values()) {
            final long numberOfEvaluations = numberOfEvaluations(source);

            iteration.getMetrics().put(source.getMetricName(), numberOfEvaluations);
        }
    }

    /**
     * The optimisation function of the run, e.g. for fitness steps that need the
     *   surrogate model the candidates are evaluated with. It is created on the first call
     *   in a run and shared with the evaluations.
     *
     * @return The optimisation function of the run.
     */
    public OptimisationFunction optimisationFunction() {
        return currentFunction();
    }

    /**
     * @return The optimisation function of the run.
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
     * Evaluates a candidate on the calling thread, counts the evaluation and publishes an
     *   {@link IndividualEvaluated} if the evaluation succeeds.
     *
     * @param candidate The candidate (a point of the search space).
     * @return The result of the optimisation function (a point of the optimisation space).
     * @throws EvaluationBudgetExhaustedException if the evaluation would exceed a limit with
     *   the policy {@link ExhaustionPolicy#CUT_OFF}.
     */
    public TypedEObject evaluate(final TypedEObject candidate) {
        return evaluateAll(List.of(candidate)).getFirst();
    }

    /**
     * Evaluates a batch of candidates, in parallel if the optimisation function is
     *   thread-safe. All evaluations are counted; for every successful evaluation, an
     *   {@link IndividualEvaluated} is published in the order of the candidates.
     * <p>
     * The batch is evaluated completely or not at all: if a limit with the policy
     *   {@link ExhaustionPolicy#CUT_OFF} does not allow all evaluations, none is made. Callers
     *   that want to use the rest of the budget limit the batch to
     *   {@link #remainingEvaluations()}.
     *
     * @param candidates The candidates (points of the search space).
     * @return The results of the optimisation function, in the order of the candidates.
     * @throws EvaluationBudgetExhaustedException if the evaluations would exceed a limit with
     *   the policy {@link ExhaustionPolicy#CUT_OFF}.
     * @throws RuntimeException the failure of the evaluation with the lowest index, after all
     *   evaluations have ended. The failures of the other evaluations are suppressed
     *   exceptions of it.
     */
    public List<TypedEObject> evaluateAll(final List<TypedEObject> candidates) {
        final OptimisationFunction currentFunction = currentFunction();
        final EvaluationSource source = EvaluationSource.of(currentFunction);

        final List<EvaluationTask> tasks = reserve(source, candidates.size());
        final List<Outcome> outcomes = compute(currentFunction, candidates, tasks);

        return complete(source, candidates, outcomes);
    }

    /**
     * The number of evaluations of the current optimisation function that the budget still
     *   allows before {@link #evaluateAll(List)} throws an
     *   {@link EvaluationBudgetExhaustedException}.
     *
     * @return The remaining evaluations, or empty if the source of the current function has no
     *   limit with the policy {@link ExhaustionPolicy#CUT_OFF}.
     */
    public OptionalLong remainingEvaluations() {
        final EvaluationSource source = EvaluationSource.of(currentFunction());
        final Limit limit = limits.get(source);
        if(limit == null || limit.policy() != ExhaustionPolicy.CUT_OFF) {
            return OptionalLong.empty();
        }

        return OptionalLong.of(Math.max(0, limit.maximum() - numberOfEvaluations(source)));
    }

    /**
     * Checks the budget for the batch and assigns the evaluation indices.
     */
    private List<EvaluationTask> reserve(final EvaluationSource source, final int numberOfCandidates) {
        requireBudgetFor(source, numberOfCandidates);

        final long run = randomService.getRun();
        final List<EvaluationTask> tasks = new ArrayList<>(numberOfCandidates);
        for(int i = 0; i < numberOfCandidates; ++i) {
            tasks.add(new EvaluationTask(run, nextIndex++));
        }

        return tasks;
    }

    /**
     * Calls the optimisation function for every candidate and waits until all calls have
     *   ended.
     */
    private List<Outcome> compute(final OptimisationFunction currentFunction,
                                  final List<TypedEObject> candidates,
                                  final List<EvaluationTask> tasks) {
        if(candidates.size() <= 1 || !useThreads(currentFunction)) {
            final List<Outcome> outcomes = new ArrayList<>(candidates.size());
            for(int i = 0; i < candidates.size(); ++i) {
                outcomes.add(Outcome.of(tasks.get(i), currentFunction, candidates.get(i)));
            }

            return outcomes;
        }

        final List<Outcome> outcomes = new ArrayList<>(candidates.size());
        int first = 0;
        if(!preparedForThreads) {
            // the first evaluation on this thread builds the caches of the classes it uses
            prepareClassesOf(candidates);
            outcomes.add(Outcome.of(tasks.getFirst(), currentFunction, candidates.getFirst()));
            first = 1;
            preparedForThreads = true;
        }

        final List<Callable<Outcome>> evaluations = new ArrayList<>(candidates.size() - first);
        for(int i = first; i < candidates.size(); ++i) {
            final EvaluationTask task = tasks.get(i);
            final TypedEObject candidate = candidates.get(i);

            evaluations.add(() -> Outcome.of(task, currentFunction, candidate));
        }
        outcomes.addAll(executor.invokeAll(evaluations));

        return outcomes;
    }

    /**
     * @return {@code true} iff the batches of the function are computed on several threads.
     */
    private boolean useThreads(final OptimisationFunction currentFunction) {
        if(executor.threads() <= 1) {
            return false;
        }

        if(!currentFunction.isThreadSafe()) {
            if(!reportedSequentialEvaluation) {
                log.info("The optimisation function {} is not declared thread-safe, evaluating its candidates one after another.",
                         currentFunction.getClass().getSimpleName());
                reportedSequentialEvaluation = true;
            }

            return false;
        }

        return true;
    }

    /**
     * Prepares the classes of the candidates for the use by several threads.
     */
    private static void prepareClassesOf(final List<TypedEObject> candidates) {
        final Set<EClass> classes = Collections.newSetFromMap(new IdentityHashMap<>());
        for(final TypedEObject candidate : candidates) {
            final EClass eClass = candidate.eClass();

            if(eClass != null && classes.add(eClass)) {
                ConcurrentEClassAccess.prepare(eClass);
            }
        }
    }

    /**
     * Counts the evaluations and publishes the successful ones in index order.
     *
     * @throws RuntimeException the failure with the lowest index, if any.
     */
    private List<TypedEObject> complete(final EvaluationSource source,
                                        final List<TypedEObject> candidates,
                                        final List<Outcome> outcomes) {
        counters.merge(source, (long) outcomes.size(), Long::sum);

        Throwable failure = null;
        final List<TypedEObject> outputs = new ArrayList<>(outcomes.size());
        for(int i = 0; i < outcomes.size(); ++i) {
            final Outcome outcome = outcomes.get(i);

            if(outcome.failure() == null) {
                events.publish(new IndividualEvaluated(candidates.get(i), outcome.output(), source));
            } else if(failure == null) {
                failure = outcome.failure();
            } else {
                failure.addSuppressed(outcome.failure());
            }
            outputs.add(outcome.output());
        }

        if(failure instanceof RuntimeException exception) {
            throw exception;
        }
        if(failure instanceof Error error) {
            throw error;
        }
        if(failure != null) {
            throw new IllegalStateException("The evaluation failed.", failure);
        }

        return outputs;
    }

    /**
     * Limits the number of evaluations of a source in the run. The limit is
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
     * @return The number of evaluations of the source in the run.
     */
    public long numberOfEvaluations(final EvaluationSource source) {
        return counters.getOrDefault(source, 0L);
    }

    /**
     * @throws EvaluationBudgetExhaustedException if the source has a limit with the policy
     *   {@link ExhaustionPolicy#CUT_OFF} that does not allow the evaluations.
     */
    private void requireBudgetFor(final EvaluationSource source, final int numberOfCandidates) {
        final Limit limit = limits.get(source);
        if(limit == null || limit.policy() != ExhaustionPolicy.CUT_OFF) {
            return;
        }

        final long numberOfEvaluations = numberOfEvaluations(source);
        if(numberOfEvaluations + numberOfCandidates > limit.maximum()) {
            throw new EvaluationBudgetExhaustedException(source, limit.maximum());
        }
    }

    /**
     * Defines the counters of the sources.
     */
    @Override
    public void contributeDefinitions(final ExecutionRecorder recorder) {
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

    /**
     * The result of one evaluation: either the output or the failure.
     */
    private record Outcome(TypedEObject output, Throwable failure) {
        /**
         * Calls the function in the task context of the evaluation.
         */
        static Outcome of(final EvaluationTask task, final OptimisationFunction function, final TypedEObject candidate) {
            try {
                return new Outcome(task.call(() -> function.evaluate(candidate)), null);
            } catch(final RuntimeException | Error e) {
                return new Outcome(null, e);
            }
        }
    }
}
