package de.evoal.optimisation.api.execution;

import de.evoal.models.v202704.optimisation.memory.Iteration;

/**
 * A component that records metrics in the iterations of an execution. The
 *   {@link ExecutionRecorder} calls all contributors that are CDI beans. A contributor keeps
 *   the state of one run, so contributors are {@link de.evoal.core.api.cdi.RunScoped}: every
 *   run gets new contributors, and the recorder of the run calls the contributors of the
 *   same run.
 */
public interface MetricContributor {
    /**
     * Writes the current values of the contributor's iteration metrics into the iteration.
     *
     * @param iteration The iteration to write the values into.
     */
    void contributeTo(Iteration iteration);

    /**
     * Defines the contributor's metrics ({@link ExecutionRecorder#define}) when the recorder
     *   of the run is created. The recorder is in its definition phase. Contributors whose
     *   metrics depend on the algorithm define them later, while the algorithm is created.
     *
     * @param recorder The recorder of the run.
     */
    default void contributeDefinitions(final ExecutionRecorder recorder) {
    }
}
