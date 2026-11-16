package de.evoal.optimisation.api.execution;

import java.lang.reflect.Field;
import java.util.List;

import jakarta.enterprise.inject.Instance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.MetricValueType;

public class ExecutionRecorderTest {
    private final FakeContributor contributor = new FakeContributor();

    private final ExecutionRecorder recorder = new ExecutionRecorder();

    private static MetricDefinition definition(final String name, final MetricScope scope) {
        final MetricDefinition definition = MemoryFactory.eINSTANCE.createMetricDefinition();
        definition.setName(name);
        definition.setKind(MetricKind.COUNTER);
        definition.setValueType(MetricValueType.INTEGER);
        definition.setScope(scope);
        definition.setDescription(name);

        return definition;
    }

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void injectContributors() throws Exception {
        final Instance<MetricContributor> contributors = Mockito.mock(Instance.class, Mockito.CALLS_REAL_METHODS);
        Mockito.doAnswer(invocation -> List.<MetricContributor>of(contributor).iterator())
               .when(contributors)
               .iterator();

        final Field field = ExecutionRecorder.class.getDeclaredField("contributors");
        field.setAccessible(true);
        field.set(recorder, contributors);
    }

    private static Iteration iteration() {
        return MemoryFactory.eINSTANCE.createIteration();
    }

    /**
     * Defines the iteration metric {@code counter} and the execution metric {@code limit},
     *   and writes the value 7 for {@code counter} (or the metric in {@code writtenMetric}).
     */
    private static class FakeContributor implements MetricContributor {
        private ExecutionRecorder recorder;

        private String writtenMetric = "counter";

        @Override
        public void contributeTo(final Iteration iteration) {
            iteration.getMetrics().put(writtenMetric, 7L);
        }

        @Override
        public void startRun(final ExecutionRecorder recorder) {
            this.recorder = recorder;
            recorder.define(definition("counter", MetricScope.ITERATION));
            recorder.define(definition("limit", MetricScope.EXECUTION));
        }
    }

    @Nested
    @DisplayName("given no started run")
    class NoRun {
        @Test
        public void metricsCannotBeDefined() {
            // given
            final MetricDefinition definition = definition("late", MetricScope.ITERATION);

            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> recorder.define(definition));
        }

        @Test
        public void theExecutionCannotBegin() {
            Assertions.assertThrows(IllegalStateException.class, recorder::beginExecution);
        }
    }

    @Nested
    @DisplayName("given a run in its definition phase")
    class DefinitionPhase {
        @BeforeEach
        public void startRun() {
            recorder.startRun();
        }

        @Test
        public void theContributorsDefineTheirMetrics() {
            // then
            Assertions.assertSame(recorder, contributor.recorder);
            Assertions.assertTrue(recorder.findDefinition("counter").isPresent());
            Assertions.assertTrue(recorder.findDefinition("limit").isPresent());
        }

        @Test
        public void aNewRunHasANewExecution() {
            // given
            final Execution previous = recorder.getExecution();

            // when
            recorder.startRun();

            // then
            Assertions.assertNotSame(previous, recorder.getExecution());
        }

        @Test
        public void aMetricIsDefinedOnce() {
            // given
            final MetricDefinition duplicate = definition("counter", MetricScope.ITERATION);

            // when, then
            Assertions.assertThrows(IllegalArgumentException.class, () -> recorder.define(duplicate));
        }

        @Test
        public void anExecutionMetricIsRecordedInTheExecution() {
            // when
            recorder.recordExecutionMetric("limit", 5L);

            // then
            Assertions.assertEquals(5L, recorder.getExecution().getMetrics().get("limit"));
        }

        @Test
        public void anIterationMetricIsNotRecordedInTheExecution() {
            Assertions.assertThrows(IllegalStateException.class, () -> recorder.recordExecutionMetric("counter", 5L));
        }

        @Test
        public void iterationsCannotBeRecorded() {
            // given
            final Iteration iteration = iteration();

            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> recorder.recordMetrics(iteration));
        }

        @Test
        public void theRunCannotBeFinished() {
            Assertions.assertThrows(IllegalStateException.class, recorder::finishRun);
        }
    }

    @Nested
    @DisplayName("given a run in its execution phase")
    class ExecutionPhase {
        @BeforeEach
        public void beginExecution() {
            recorder.startRun();
            recorder.beginExecution();
        }

        @Test
        public void metricsCannotBeDefined() {
            // given
            final MetricDefinition definition = definition("late", MetricScope.ITERATION);

            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> recorder.define(definition));
        }

        @Test
        public void theContributorsWriteTheirValuesIntoTheIteration() {
            // given
            final Iteration iteration = iteration();

            // when
            recorder.recordMetrics(iteration);

            // then
            Assertions.assertEquals(7L, iteration.getMetrics().get("counter"));
        }

        @Test
        public void anUndefinedMetricIsRejected() {
            // given
            contributor.writtenMetric = "unknown";
            final Iteration iteration = iteration();

            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> recorder.recordMetrics(iteration));
        }

        @Test
        public void anExecutionMetricIsRejectedInAnIteration() {
            // given
            contributor.writtenMetric = "limit";
            final Iteration iteration = iteration();

            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> recorder.recordMetrics(iteration));
        }

        @Test
        public void anExecutionMetricCanStillBeRecorded() {
            // when
            recorder.recordExecutionMetric("limit", 5L);

            // then
            Assertions.assertEquals(5L, recorder.getExecution().getMetrics().get("limit"));
        }
    }

    @Nested
    @DisplayName("given a finished run")
    class FinishedRun {
        @BeforeEach
        public void finishRun() {
            recorder.startRun();
            recorder.beginExecution();
            recorder.finishRun();
        }

        @Test
        public void executionMetricsCannotBeRecorded() {
            Assertions.assertThrows(IllegalStateException.class, () -> recorder.recordExecutionMetric("limit", 5L));
        }

        @Test
        public void iterationsCannotBeRecorded() {
            // given
            final Iteration iteration = iteration();

            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> recorder.recordMetrics(iteration));
        }
    }
}
