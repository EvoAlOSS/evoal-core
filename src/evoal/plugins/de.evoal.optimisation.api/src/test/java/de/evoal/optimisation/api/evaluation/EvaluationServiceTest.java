package de.evoal.optimisation.api.evaluation;

import java.lang.reflect.Field;
import java.util.List;

import jakarta.enterprise.inject.Instance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import de.evoal.core.api.reproducibility.ReproducibilityProtocol;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.cdi.OptimisationComponentProducer;
import de.evoal.optimisation.api.events.IndividualEvaluated;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.events.RunListener;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;

public class EvaluationServiceTest {
    private final TypedEObject candidate = Mockito.mock(TypedEObject.class);

    private final OptimisationComponentProducer componentProducer = Mockito.mock(OptimisationComponentProducer.class);

    private Execution execution;

    private OptimisationFunction function;

    private final TypedEObject output = Mockito.mock(TypedEObject.class);

    private final ExecutionRecorder recorder = new ExecutionRecorder();

    private final EvaluationService service = new EvaluationService();

    private final RunEventDispatcher events = new RunEventDispatcher(recorder);

    private final RunListener listener = Mockito.mock(RunListener.class);

    private void evaluateTimes(final int numberOfEvaluations) {
        for(int i = 0; i < numberOfEvaluations; ++i) {
            service.evaluate(candidate);
        }
    }

    @BeforeEach
    public void injectDependencies() throws Exception {
        final Field producerField = EvaluationService.class.getDeclaredField("componentProducer");
        producerField.setAccessible(true);
        producerField.set(service, componentProducer);

        final Field eventsField = EvaluationService.class.getDeclaredField("events");
        eventsField.setAccessible(true);
        eventsField.set(service, events);
        events.startRun(List.of(listener));

        // the recorder starts the service in every run
        @SuppressWarnings("unchecked")
        final Instance<MetricContributor> contributors = Mockito.mock(Instance.class, Mockito.CALLS_REAL_METHODS);
        Mockito.doAnswer(invocation -> List.<MetricContributor>of(service).iterator())
               .when(contributors)
               .iterator();

        final Field contributorsField = ExecutionRecorder.class.getDeclaredField("contributors");
        contributorsField.setAccessible(true);
        contributorsField.set(recorder, contributors);

        final Field protocolField = ExecutionRecorder.class.getDeclaredField("reproducibility");
        protocolField.setAccessible(true);
        protocolField.set(recorder, new ReproducibilityProtocol());
    }

    /**
     * Makes the producer return the function and starts a run.
     */
    private void startRunWith(final OptimisationFunction function) {
        this.function = function;
        Mockito.when(componentProducer.create(OptimisationFunction.class,
                                              OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                                              "algorithm.optimisation-function"))
               .thenReturn(function);
        Mockito.when(function.evaluate(ArgumentMatchers.any())).thenReturn(output);

        recorder.startRun();
        execution = recorder.getExecution();
    }

    @Nested
    @DisplayName("given a real optimisation function")
    class RealFunction {
        @BeforeEach
        public void startRun() {
            startRunWith(Mockito.mock(OptimisationFunction.class));
        }

        @Test
        public void definesACounterMetricPerSource() {
            // then
            Assertions.assertEquals(2, execution.getMetricDefinitions().size());
            for(final EvaluationSource source : EvaluationSource.values()) {
                final MetricDefinition definition = execution.getMetricDefinitions()
                                                             .stream()
                                                             .filter(d -> d.getName().equals(source.getMetricName()))
                                                             .findFirst()
                                                             .orElseThrow();
                Assertions.assertEquals(MetricKind.COUNTER, definition.getKind());
                Assertions.assertEquals(MetricScope.ITERATION, definition.getScope());
            }
        }

        @Test
        public void returnsTheResultOfTheFunction() {
            // when
            final TypedEObject result = service.evaluate(candidate);

            // then
            Assertions.assertSame(output, result);
        }

        @Test
        public void countsEveryEvaluationAsReal() {
            // when
            evaluateTimes(3);

            // then
            Assertions.assertEquals(3, service.numberOfEvaluations(EvaluationSource.REAL));
            Assertions.assertEquals(0, service.numberOfEvaluations(EvaluationSource.SURROGATE));
        }

        @Test
        public void publishesTheEvaluation() {
            // when
            service.evaluate(candidate);

            // then
            Mockito.verify(listener).on(new IndividualEvaluated(candidate, output, EvaluationSource.REAL));
        }

        @Test
        public void doesNotPublishAFailedEvaluation() {
            // given
            Mockito.when(function.evaluate(candidate)).thenThrow(new IllegalStateException("simulation failed"));

            // when
            Assertions.assertThrows(IllegalStateException.class, () -> service.evaluate(candidate));

            // then
            Mockito.verifyNoInteractions(listener);
        }

        @Test
        public void countsAFailedEvaluation() {
            // given
            Mockito.when(function.evaluate(candidate)).thenThrow(new IllegalStateException("simulation failed"));

            // when
            Assertions.assertThrows(IllegalStateException.class, () -> service.evaluate(candidate));

            // then
            Assertions.assertEquals(1, service.numberOfEvaluations(EvaluationSource.REAL));
        }

        @Test
        public void writesTheCountersIntoTheIteration() {
            // given
            evaluateTimes(2);
            final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();

            // when
            service.contributeTo(iteration);

            // then
            Assertions.assertEquals(2L, iteration.getMetrics().get("evaluations.real"));
            Assertions.assertEquals(0L, iteration.getMetrics().get("evaluations.surrogate"));
        }

        @Test
        public void aNewRunStartsWithZeroEvaluations() {
            // given
            evaluateTimes(2);

            // when
            recorder.startRun();

            // then
            Assertions.assertEquals(0, service.numberOfEvaluations(EvaluationSource.REAL));
        }

        @Test
        public void aNewRunCreatesTheFunctionAgain() {
            // given
            evaluateTimes(1);
            recorder.startRun();

            // when
            evaluateTimes(1);

            // then
            Mockito.verify(componentProducer, Mockito.times(2))
                   .create(OptimisationFunction.class,
                           OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                           "algorithm.optimisation-function");
        }
    }

    @Nested
    @DisplayName("given a surrogate function")
    class SurrogateFunction {
        @BeforeEach
        public void startRun() {
            final OptimisationFunction surrogate = Mockito.mock(OptimisationFunction.class,
                    Mockito.withSettings().extraInterfaces(EvaluationSourceProvider.class));
            Mockito.when(((EvaluationSourceProvider)surrogate).getEvaluationSource())
                   .thenReturn(EvaluationSource.SURROGATE);

            startRunWith(surrogate);
        }

        @Test
        public void countsEveryEvaluationAsSurrogate() {
            // when
            evaluateTimes(3);

            // then
            Assertions.assertEquals(0, service.numberOfEvaluations(EvaluationSource.REAL));
            Assertions.assertEquals(3, service.numberOfEvaluations(EvaluationSource.SURROGATE));
        }

        @Test
        public void doesNotUseABudgetOfRealEvaluations() {
            // given
            service.limit(EvaluationSource.REAL, 1, ExhaustionPolicy.CUT_OFF);

            // when
            evaluateTimes(3);

            // then
            Assertions.assertEquals(3, service.numberOfEvaluations(EvaluationSource.SURROGATE));
        }
    }

    @Nested
    @DisplayName("given a cut-off budget of 2 real evaluations")
    class CutOffBudget {
        @BeforeEach
        public void startRun() {
            startRunWith(Mockito.mock(OptimisationFunction.class));
            service.limit(EvaluationSource.REAL, 2, ExhaustionPolicy.CUT_OFF);
        }

        @Test
        public void recordsTheLimitAsExecutionMetric() {
            // then
            final MetricDefinition definition = execution.getMetricDefinitions()
                                                         .stream()
                                                         .filter(d -> d.getName().equals("evaluations.real.budget"))
                                                         .findFirst()
                                                         .orElseThrow();
            Assertions.assertEquals(MetricScope.EXECUTION, definition.getScope());
            Assertions.assertEquals(2L, execution.getMetrics().get("evaluations.real.budget"));
        }

        @Test
        public void theSameLimitCanBeSetAgain() {
            // when
            service.limit(EvaluationSource.REAL, 2, ExhaustionPolicy.CUT_OFF);

            // then
            final long numberOfBudgetDefinitions = execution.getMetricDefinitions()
                                                            .stream()
                                                            .filter(d -> d.getName().equals("evaluations.real.budget"))
                                                            .count();
            Assertions.assertEquals(1, numberOfBudgetDefinitions);
        }

        @Test
        public void aLimitIsRejectedAfterTheDefinitionPhase() {
            // given
            recorder.beginExecution();

            // when, then
            Assertions.assertThrows(IllegalStateException.class,
                                    () -> service.limit(EvaluationSource.SURROGATE, 3, ExhaustionPolicy.CUT_OFF));
        }

        @Test
        public void aDifferentLimitIsRejected() {
            // when, then
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> service.limit(EvaluationSource.REAL, 3, ExhaustionPolicy.CUT_OFF));
        }

        @Test
        public void aNewRunHasNoLimit() {
            // given
            evaluateTimes(2);
            recorder.startRun();

            // when
            evaluateTimes(3);

            // then
            Assertions.assertEquals(3, service.numberOfEvaluations(EvaluationSource.REAL));
        }

        @Test
        public void evaluatesUpToTheBudget() {
            // when
            evaluateTimes(2);

            // then
            Assertions.assertEquals(2, service.numberOfEvaluations(EvaluationSource.REAL));
        }

        @Test
        public void rejectsAnEvaluationBeyondTheBudget() {
            // given
            evaluateTimes(2);

            // when
            final EvaluationBudgetExhaustedException exception =
                    Assertions.assertThrows(EvaluationBudgetExhaustedException.class,
                                            () -> service.evaluate(candidate));

            // then
            Assertions.assertEquals(EvaluationSource.REAL, exception.getSource());
            Assertions.assertEquals(2, exception.getBudget());
            Assertions.assertEquals(2, service.numberOfEvaluations(EvaluationSource.REAL));
            Mockito.verify(function, Mockito.times(2)).evaluate(candidate);
        }
    }

    @Nested
    @DisplayName("given a finish-iteration budget of 2 real evaluations")
    class FinishIterationBudget {
        @BeforeEach
        public void startRun() {
            startRunWith(Mockito.mock(OptimisationFunction.class));
            service.limit(EvaluationSource.REAL, 2, ExhaustionPolicy.FINISH_ITERATION);
        }

        @Test
        public void evaluatesBeyondTheBudget() {
            // when
            evaluateTimes(3);

            // then
            Assertions.assertEquals(3, service.numberOfEvaluations(EvaluationSource.REAL));
        }
    }

    @Nested
    @DisplayName("given no started run")
    class NoRun {
        @Test
        public void rejectsEvaluations() {
            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> service.evaluate(candidate));
        }
    }
}
