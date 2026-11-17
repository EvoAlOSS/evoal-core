package de.evoal.optimisation.api.events;

/**
 * Receives the events of the runs it is registered for
 *   ({@link RunEventDispatcher#startRun(java.util.List)}). A listener must not change the
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
}
