package de.evoal.optimisation.api.execution;

import de.evoal.models.v202704.optimisation.memory.Iteration;

/**
 * A component that records metrics in the iterations of an execution. The
 *   {@link ExecutionRecorder} calls all contributors that are CDI beans. Since the
 *   recorder looks them up on every call, contributors have to be
 *   {@code @ApplicationScoped}.
 */
public interface MetricContributor {
    /**
     * Writes the current values of the contributor's iteration metrics into the iteration.
     *
     * @param iteration The iteration to write the values into.
     */
    void contributeTo(Iteration iteration);

    /**
     * Starts a new run: resets the contributor's state and defines its metrics
     *   ({@link ExecutionRecorder#define}). The recorder is in its definition phase.
     *
     * @param recorder The recorder of the new run.
     */
    void startRun(ExecutionRecorder recorder);
}
