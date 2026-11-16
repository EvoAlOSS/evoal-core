package de.evoal.optimisation.api.execution;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

import lombok.Getter;

import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricScope;

/**
 * Records the description of the current run: the metrics it records
 *   ({@link Execution#getMetricDefinitions()}) and the values of its execution metrics
 *   ({@link Execution#getMetrics()}).
 * <p>
 * A run passes through three phases, and the recorder rejects calls in the wrong phase:
 * <ol>
 *   <li>{@link #startRun()} opens the <em>definition phase</em>. The applications call it
 *     before they create the algorithm. The {@link MetricContributor}s and the components
 *     of the algorithm (e.g., stopping criteria) define all metrics
 *     ({@link #define(MetricDefinition)}).</li>
 *   <li>{@link #beginExecution()} closes the definitions. The applications call it after
 *     they created the algorithm and before they run it. From now on, the definitions are
 *     complete and can be written, e.g., to the description of the run. The algorithm
 *     passes every iteration to {@link #recordMetrics(Iteration)}.</li>
 *   <li>{@link #finishRun()} ends the run. The execution metrics are final.</li>
 * </ol>
 * Execution metrics ({@link #recordExecutionMetric(String, Number)}) can be recorded until
 *   the run is finished.
 */
@ApplicationScoped
public class ExecutionRecorder {
    /**
     * All components that record metrics.
     */
    @Inject @Any
    private Instance<MetricContributor> contributors;

    /**
     * The position of the current run in the evaluation setup, {@code null} for a single run.
     */
    private EvaluationPosition evaluationPosition;

    /**
     * The execution of the current run.
     */
    @Getter
    private Execution execution = MemoryFactory.eINSTANCE.createExecution();

    /**
     * The phase of the current run.
     */
    private Phase phase = Phase.NO_RUN;

    /**
     * Closes the definitions of the current run and starts its execution.
     *
     * @throws IllegalStateException if the run is not in the definition phase.
     */
    public void beginExecution() {
        requirePhase(Phase.DEFINITION, "begin the execution");

        phase = Phase.EXECUTION;
    }

    /**
     * Defines a metric of the current run.
     *
     * @param definition The definition of the metric.
     * @throws IllegalStateException if the run is not in the definition phase.
     * @throws IllegalArgumentException if a metric with the same name is already defined.
     */
    public void define(final MetricDefinition definition) {
        final String name = definition.getName();
        requirePhase(Phase.DEFINITION, "define the metric '" + name + "'");

        final boolean alreadyDefined = findDefinition(name).isPresent();
        if(alreadyDefined) {
            throw new IllegalArgumentException("The metric '" + name + "' is already defined.");
        }

        execution.getMetricDefinitions().add(definition);
    }

    /**
     * @param name The name of the metric.
     * @return The definition of the metric in the current run, if there is one.
     */
    public Optional<MetricDefinition> findDefinition(final String name) {
        return execution.getMetricDefinitions()
                        .stream()
                        .filter(definition -> definition.getName().equals(name))
                        .findFirst();
    }

    /**
     * Ends the current run. The execution metrics are final.
     *
     * @throws IllegalStateException if the run is not in the execution phase.
     */
    public void finishRun() {
        requirePhase(Phase.EXECUTION, "finish the run");

        phase = Phase.FINISHED;
    }

    /**
     * @return The position of the current run in the evaluation setup, empty for a single run.
     */
    public Optional<EvaluationPosition> getEvaluationPosition() {
        return Optional.ofNullable(evaluationPosition);
    }

    /**
     * Records the value of an execution metric, e.g., a limit.
     *
     * @param name The name of the metric.
     * @param value The value of the metric.
     * @throws IllegalStateException if the run is not started or already finished, or if the
     *   metric is not defined with the scope {@link MetricScope#EXECUTION}.
     */
    public void recordExecutionMetric(final String name, final Number value) {
        final boolean isRunning = phase == Phase.DEFINITION || phase == Phase.EXECUTION;
        if(!isRunning) {
            throw new IllegalStateException("Cannot record the metric '" + name + "' in phase " + phase + ".");
        }

        requireDefinition(name, MetricScope.EXECUTION);

        execution.getMetrics().put(name, value);
    }

    /**
     * Writes the current values of all iteration metrics into the iteration.
     *
     * @param iteration The iteration to write the values into.
     * @throws IllegalStateException if the run is not in the execution phase, or if a
     *   contributor wrote a metric that is not defined with the scope
     *   {@link MetricScope#ITERATION}.
     */
    public void recordMetrics(final Iteration iteration) {
        requirePhase(Phase.EXECUTION, "record the metrics of iteration " + iteration.getNumber());

        contributors.forEach(contributor -> contributor.contributeTo(iteration));

        iteration.getMetrics()
                 .keySet()
                 .forEach(name -> requireDefinition(name, MetricScope.ITERATION));
    }

    /**
     * @throws IllegalStateException if the metric is not defined with the given scope.
     */
    private void requireDefinition(final String name, final MetricScope scope) {
        final boolean isDefined = findDefinition(name).filter(definition -> definition.getScope() == scope)
                                                      .isPresent();

        if(!isDefined) {
            throw new IllegalStateException("The metric '" + name + "' is not defined with the scope " + scope + ".");
        }
    }

    /**
     * @param action What the caller tries to do, for the error message.
     * @throws IllegalStateException if the current run is not in the expected phase.
     */
    private void requirePhase(final Phase expected, final String action) {
        if(phase != expected) {
            throw new IllegalStateException("Cannot " + action + " in phase " + phase + ", only in phase "
                                            + expected + ".");
        }
    }

    /**
     * Starts a single run (not part of the evaluation setup), see {@link #startRun(EvaluationPosition)}.
     */
    public void startRun() {
        startRun(null);
    }

    /**
     * Starts a new run with a new execution and opens its definition phase. All
     *   contributors reset their state and define their metrics.
     *
     * @param evaluationPosition The position of the run in the evaluation setup, {@code null}
     *   for a single run.
     */
    public void startRun(final EvaluationPosition evaluationPosition) {
        this.evaluationPosition = evaluationPosition;
        execution = MemoryFactory.eINSTANCE.createExecution();
        phase = Phase.DEFINITION;

        contributors.forEach(contributor -> contributor.startRun(this));
    }

    /**
     * The phases of a run.
     */
    private enum Phase {
        /**
         * No run has been started yet.
         */
        NO_RUN,

        /**
         * The metrics are being defined.
         */
        DEFINITION,

        /**
         * The algorithm runs and records its iterations.
         */
        EXECUTION,

        /**
         * The run is finished.
         */
        FINISHED
    }
}
