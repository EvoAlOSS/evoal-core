package de.evoal.optimisation.main.statistics.individuals;

import jakarta.enterprise.context.ApplicationScoped;

import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.MetricValueType;

import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;

/**
 * Counts the evaluations of the reference functions of the
 *   {@code reference-values-per-individual} writers of a run: the execution metric
 *   {@value #METRIC_NAME}.
 * <p>
 * The metric is only defined in runs that use such a writer ({@link #register()}), so runs
 *   without one keep their metric definitions. All writers of a run share the counter. It is
 *   an execution metric because the writers see an iteration only after its metrics are
 *   recorded: an iteration metric would lag one iteration behind.
 */
@ApplicationScoped
public class ReferenceEvaluations implements MetricContributor {
    /**
     * The name of the execution metric.
     */
    public static final String METRIC_NAME = "evaluations.reference";

    /**
     * The number of reference evaluations in the current run.
     */
    private long numberOfEvaluations;

    /**
     * The recorder of the current run. {@code null} before the first run.
     */
    private ExecutionRecorder recorder;

    /**
     * Records nothing: the counter is an execution metric.
     */
    @Override
    public void contributeTo(final Iteration iteration) {
    }

    /**
     * Records that a writer evaluated its reference function once more, also if the
     *   evaluation failed.
     *
     * @throws IllegalStateException if no writer registered in the current run.
     */
    public void count() {
        requireRegistration();

        numberOfEvaluations += 1;
        recorder.recordExecutionMetric(METRIC_NAME, numberOfEvaluations);
    }

    /**
     * @return The number of reference evaluations in the current run.
     */
    public long numberOfEvaluations() {
        return numberOfEvaluations;
    }

    /**
     * Defines the metric in the current run, if no writer has defined it yet, and records its
     *   initial value 0. A writer calls it while it is created, i.e. in the definition phase.
     *
     * @throws IllegalStateException if no run has been started or the run is not in its
     *   definition phase.
     */
    public void register() {
        if(recorder == null) {
            throw new IllegalStateException("No run has been started. Call ExecutionRecorder.startRun() first.");
        }

        final boolean alreadyDefined = recorder.findDefinition(METRIC_NAME).isPresent();
        if(alreadyDefined) {
            return;
        }

        recorder.define(toDefinition());
        recorder.recordExecutionMetric(METRIC_NAME, numberOfEvaluations);
    }

    /**
     * @throws IllegalStateException if the metric is not defined in the current run.
     */
    private void requireRegistration() {
        final boolean isRegistered = recorder != null && recorder.findDefinition(METRIC_NAME).isPresent();

        if(!isRegistered) {
            throw new IllegalStateException("The metric '" + METRIC_NAME + "' is not defined in the current run.");
        }
    }

    /**
     * Resets the counter. The metric is defined by the first writer of the run.
     */
    @Override
    public void startRun(final ExecutionRecorder recorder) {
        this.recorder = recorder;
        numberOfEvaluations = 0;
    }

    /**
     * @return The definition of the metric.
     */
    private static MetricDefinition toDefinition() {
        final MetricDefinition definition = MemoryFactory.eINSTANCE.createMetricDefinition();
        definition.setName(METRIC_NAME);
        definition.setKind(MetricKind.COUNTER);
        definition.setValueType(MetricValueType.INTEGER);
        definition.setScope(MetricScope.EXECUTION);
        definition.setDescription("Number of evaluations of the reference functions of the statistics writer"
                                  + " 'reference-values-per-individual'.");

        return definition;
    }
}
