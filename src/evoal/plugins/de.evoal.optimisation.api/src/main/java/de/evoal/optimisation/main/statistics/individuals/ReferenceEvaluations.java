package de.evoal.optimisation.main.statistics.individuals;

import jakarta.inject.Inject;

import de.evoal.core.api.cdi.RunScoped;

import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.MetricValueType;

import de.evoal.optimisation.api.execution.ExecutionRecorder;

/**
 * Counts the evaluations of the reference functions of the
 *   {@code reference-values-per-individual} writers of a run: the execution metric
 *   {@value #METRIC_NAME}.
 * <p>
 * The metric is only defined in runs that use such a writer ({@link #register()}), so runs
 *   without one keep their metric definitions. All writers of a run share the counter. It is
 *   an execution metric because the writers see an iteration only after its metrics are
 *   recorded: an iteration metric would lag one iteration behind. Every run has its own
 *   counter.
 */
@RunScoped
public class ReferenceEvaluations {
    /**
     * The name of the execution metric.
     */
    public static final String METRIC_NAME = "evaluations.reference";

    /**
     * The number of reference evaluations in the run.
     */
    private long numberOfEvaluations;

    /**
     * The recorder of the run.
     */
    @Inject
    private ExecutionRecorder recorder;

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
     * @return The number of reference evaluations in the run.
     */
    public long numberOfEvaluations() {
        return numberOfEvaluations;
    }

    /**
     * Defines the metric in the run, if no writer has defined it yet, and records its initial
     *   value 0. A writer calls it while it is created, i.e. in the definition phase.
     *
     * @throws IllegalStateException if the run is not in its definition phase.
     */
    public void register() {
        final boolean alreadyDefined = recorder.findDefinition(METRIC_NAME).isPresent();
        if(alreadyDefined) {
            return;
        }

        recorder.define(toDefinition());
        recorder.recordExecutionMetric(METRIC_NAME, numberOfEvaluations);
    }

    /**
     * @throws IllegalStateException if the metric is not defined in the run.
     */
    private void requireRegistration() {
        final boolean isRegistered = recorder.findDefinition(METRIC_NAME).isPresent();

        if(!isRegistered) {
            throw new IllegalStateException("The metric '" + METRIC_NAME + "' is not defined in the run.");
        }
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
