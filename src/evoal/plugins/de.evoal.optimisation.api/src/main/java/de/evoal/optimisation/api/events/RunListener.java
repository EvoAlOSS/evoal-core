package de.evoal.optimisation.api.events;

/**
 * Receives the events of the runs it is registered for
 *   ({@link RunEventDispatcher#dispatchTo(java.util.List)}). A listener must not change the
 *   data of an event.
 */
@FunctionalInterface
public interface RunListener {
    /**
     * Handles an event. It is called on the thread of the run, so the run waits for it.
     *
     * @param event The event.
     */
    void on(RunEvent event);

    /**
     * @return Whether the listener reads the steps of an iteration
     *   ({@link de.evoal.models.v202704.optimisation.memory.Iteration#getSteps()}). The run builds the steps
     *   only if one of its listeners reads them; otherwise its iterations have no steps.
     *   {@code false} by default.
     */
    default boolean readsSteps() {
        return false;
    }
}
