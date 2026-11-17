package de.evoal.optimisation.api.events;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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
 * Events published outside a run, e.g. by an algorithm that does not use the dispatcher,
 *   are ignored.
 */
@ApplicationScoped
public class RunEventDispatcher {
    /**
     * The listeners of the current run in the order of registration, empty outside a run.
     */
    private List<RunListener> listeners = List.of();

    /**
     * Records the metrics of the iterations.
     */
    private final ExecutionRecorder recorder;

    /**
     * Whether a run is active.
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
     * Ends the current run; later events are ignored until the next run starts.
     */
    public void finishRun() {
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
     * Starts a run with its listeners. The listeners of a previous run are removed.
     *
     * @param listeners The listeners of the run in the order they receive the events.
     */
    public void startRun(final List<RunListener> listeners) {
        this.listeners = List.copyOf(listeners);
        running = true;
    }
}
