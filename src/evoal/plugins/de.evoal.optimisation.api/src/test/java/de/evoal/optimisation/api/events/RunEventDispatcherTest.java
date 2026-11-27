package de.evoal.optimisation.api.events;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.InOrder;
import org.mockito.Mockito;

import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

import de.evoal.optimisation.api.execution.ExecutionRecorder;

public class RunEventDispatcherTest {
    private final ExecutionRecorder recorder = Mockito.mock(ExecutionRecorder.class);

    private final RunEventDispatcher dispatcher = new RunEventDispatcher(recorder);

    /**
     * The events in the order the listeners received them, prefixed by the listener's name.
     */
    private final List<String> received = new ArrayList<>();

    private RunListener listener(final String name) {
        return event -> received.add(name + ":" + event.getClass().getSimpleName());
    }

    private static Iteration iteration() {
        return MemoryFactory.eINSTANCE.createIteration();
    }

    @Nested
    @DisplayName("given no dispatching")
    class NoDispatching {
        @Test
        public void eventsAreIgnored() {
            // when
            dispatcher.publish(new IterationFinished(iteration()));

            // then
            Mockito.verifyNoInteractions(recorder);
        }
    }

    @Nested
    @DisplayName("given dispatched events")
    class DispatchedEvents {
        @BeforeEach
        public void dispatch() {
            dispatcher.dispatchTo(List.of(listener("first"), listener("second")));
        }

        @Test
        public void listenersReceiveTheEventsInRegistrationOrder() {
            // when
            dispatcher.publish(new RunStarted(null));
            dispatcher.publish(new IterationStarted(0));
            dispatcher.publish(new StepExecuted(0, MemoryFactory.eINSTANCE.createOrderedIterationStep()));
            dispatcher.publish(new IterationFinished(iteration()));
            dispatcher.publish(new RunFinished(null));

            // then
            final List<String> expected = List.of("first:RunStarted", "second:RunStarted",
                                                  "first:IterationStarted", "second:IterationStarted",
                                                  "first:StepExecuted", "second:StepExecuted",
                                                  "first:IterationFinished", "second:IterationFinished",
                                                  "first:RunFinished", "second:RunFinished");
            Assertions.assertEquals(expected, received);
        }

        @Test
        public void theMetricsAreRecordedBeforeTheListenersReceiveTheIteration() {
            // given
            final RunListener listener = Mockito.mock(RunListener.class);
            dispatcher.dispatchTo(List.of(listener));
            final IterationFinished event = new IterationFinished(iteration());

            // when
            dispatcher.publish(event);

            // then
            final InOrder order = Mockito.inOrder(recorder, listener);
            order.verify(recorder).recordMetrics(event.iteration());
            order.verify(listener).on(event);
        }

        @Test
        public void onlyFinishedIterationsRecordMetrics() {
            // when
            dispatcher.publish(new RunStarted(null));
            dispatcher.publish(new IterationStarted(0));
            dispatcher.publish(new RunFinished(null));

            // then
            Mockito.verifyNoInteractions(recorder);
        }

        @Test
        public void laterEventsAreIgnoredWhenTheDispatchingStops() {
            // given
            dispatcher.stopDispatching();

            // when
            dispatcher.publish(new IterationStarted(1));

            // then
            Assertions.assertEquals(List.of(), received);
        }

        @Test
        public void dispatchingAgainReplacesTheListeners() {
            // given
            dispatcher.dispatchTo(List.of(listener("next")));

            // when
            dispatcher.publish(new IterationStarted(0));

            // then
            Assertions.assertEquals(List.of("next:IterationStarted"), received);
        }

        @Test
        public void anExceptionOfAListenerReachesThePublisher() {
            // given
            final RunListener failing = event -> {
                throw new IllegalStateException("listener failed");
            };
            dispatcher.dispatchTo(List.of(failing, listener("later")));

            // when / then
            Assertions.assertThrows(IllegalStateException.class,
                                    () -> dispatcher.publish(new IterationStarted(0)));
            Assertions.assertEquals(List.of(), received);
        }
    }
}
