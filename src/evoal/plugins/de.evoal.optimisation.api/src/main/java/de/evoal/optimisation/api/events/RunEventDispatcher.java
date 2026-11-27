package de.evoal.optimisation.api.events;

import java.util.List;

import jakarta.inject.Inject;

import de.evoal.core.api.cdi.RunScoped;
import de.evoal.optimisation.api.execution.ExecutionRecorder;

/**
 * Passes the events of the current run to the listeners of the run, synchronously on the
 *   thread of the run and in the order the listeners were registered.
 * <p>
 * Before the listeners receive an {@link IterationFinished}, the dispatcher records the
 *   iteration metrics ({@link ExecutionRecorder#recordMetrics}). Recording the metrics is
 *   not a listener, because the stopping criteria read them and listeners must not change
 *   the search.
 * <p>
 * Every run has its own dispatcher. Events published while the kernel does not dispatch
 *   them, e.g. by an algorithm that does not use the kernel, are ignored.
 */
@RunScoped
public class RunEventDispatcher {
    /**
     * The listeners of the run in the order of registration, empty while the events are not
     *   dispatched.
     */
    private List<RunListener> listeners = List.of();

    /**
     * Records the metrics of the iterations.
     */
    private final ExecutionRecorder recorder;

    /**
     * Whether the events are dispatched.
     */
    private boolean running;

    /**
     * Required for the proxy of the CDI container.
     */
    protected RunEventDispatcher() {
        this(null);
    }

    /**
     * @param recorder Records the metrics of the iterations.
     */
    @Inject
    public RunEventDispatcher(final ExecutionRecorder recorder) {
        this.recorder = recorder;
    }

    /**
     * Stops dispatching at the end of the run; later events are ignored.
     */
    public void stopDispatching() {
        running = false;
        listeners = List.of();
    }

    /**
     * Passes an event to the listeners of the current run. For an {@link IterationFinished},
     *   the iteration metrics are recorded first. Exceptions of a listener are passed on to
     *   the publisher; the remaining listeners do not receive the event.
     *
     * @param event The event.
     */
    public void publish(final RunEvent event) {
        if(!running) {
            return;
        }

        if(event instanceof IterationFinished(var iteration)) {
            recorder.recordMetrics(iteration);
        }

        for(final RunListener listener : listeners) {
            listener.on(event);
        }
    }

    /**
     * Starts dispatching the events of the run to its listeners.
     *
     * @param listeners The listeners of the run in the order they receive the events.
     */
    public void dispatchTo(final List<RunListener> listeners) {
        this.listeners = List.copyOf(listeners);
        running = true;
    }
}
