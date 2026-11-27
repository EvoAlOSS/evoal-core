package de.evoal.optimisation.api.evaluation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.enterprise.inject.Instance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import de.evoal.core.api.random.EvaluationTask;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.reproducibility.ReproducibilityProtocol;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;
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

    private final RandomService randomService = Mockito.spy(RandomService.withSeed(42));

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
        events.dispatchTo(List.of(listener));

        final Field randomField = EvaluationService.class.getDeclaredField("randomService");
        randomField.setAccessible(true);
        randomField.set(service, randomService);

        final Field recorderField = EvaluationService.class.getDeclaredField("recorder");
        recorderField.setAccessible(true);
        recorderField.set(service, recorder);

        useThreads(1);

        // the recorder lets the service define its counters
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
     * Gives the service an executor with the number of threads.
     */
    private EvaluationExecutor useThreads(final int threads) throws Exception {
        final EvaluationExecutor executor = EvaluationExecutor.withThreads(threads);

        final Field executorField = EvaluationService.class.getDeclaredField("executor");
        executorField.setAccessible(true);
        executorField.set(service, executor);

        return executor;
    }

    /**
     * Makes the producer return the function without stubbing it and starts a run.
     */
    private void startRunWithFunction(final OptimisationFunction function) {
        this.function = function;
        Mockito.when(componentProducer.create(OptimisationFunction.class,
                                              OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                                              "algorithm.optimisation-function"))
               .thenReturn(function);

        recorder.defineContributions();
        execution = recorder.getExecution();
    }

    /**
     * @return {@code n} distinct candidates.
     */
    private static List<TypedEObject> candidates(final int n) {
        final List<TypedEObject> candidates = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            candidates.add(Mockito.mock(TypedEObject.class, "candidate-" + i));
        }

        return candidates;
    }

    /**
     * A function that needs a random time per evaluation, returns one output per candidate
     *   and records the task context and the concurrency of its calls.
     */
    private static class RecordingFunction extends OptimisationFunctionImpl {
        private final boolean threadSafe;

        private final Map<TypedEObject, TypedEObject> outputs = new IdentityHashMap<>();

        private final Map<TypedEObject, EvaluationTask> tasks = new ConcurrentHashMap<>();

        private final Map<TypedEObject, String> threads = new ConcurrentHashMap<>();

        private final AtomicInteger inFlight = new AtomicInteger();

        private final AtomicInteger maximumInFlight = new AtomicInteger();

        /**
         * The candidates whose evaluation fails.
         */
        private final List<TypedEObject> failing = new ArrayList<>();

        RecordingFunction(final boolean threadSafe, final List<TypedEObject> candidates) {
            this.threadSafe = threadSafe;
            candidates.forEach(c -> outputs.put(c, Mockito.mock(TypedEObject.class)));
        }

        @Override
        public boolean isThreadSafe() {
            return threadSafe;
        }

        @Override
        public TypedEObject evaluate(final TypedEObject candidate) {
            maximumInFlight.accumulateAndGet(inFlight.incrementAndGet(), Math::max);
            try {
                tasks.put(candidate, EvaluationTask.current().orElseThrow());
                threads.put(candidate, Thread.currentThread().getName());
                Thread.sleep(ThreadLocalRandom.current().nextInt(3));

                if(failing.contains(candidate)) {
                    throw new IllegalArgumentException(((Object)candidate).toString());
                }
                return outputs.get(candidate);
            } catch(final InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                inFlight.decrementAndGet();
            }
        }
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

        recorder.defineContributions();
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
        public void createsTheFunctionOnce() {
            // when
            evaluateTimes(2);

            // then
            Mockito.verify(componentProducer, Mockito.times(1))
                   .create(OptimisationFunction.class,
                           OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                           "algorithm.optimisation-function");
        }

        @Test
        public void bindsTheTaskOfEachEvaluation() {
            // given
            final List<EvaluationTask> tasks = new java.util.ArrayList<>();
            Mockito.when(function.evaluate(ArgumentMatchers.any())).thenAnswer(invocation -> {
                tasks.add(EvaluationTask.current().orElseThrow());
                return output;
            });
            Mockito.doReturn(3L).when(randomService).getRun();

            // when
            evaluateTimes(2);

            // then
            Assertions.assertEquals(List.of(new EvaluationTask(3, 0), new EvaluationTask(3, 1)), tasks);
            Assertions.assertTrue(EvaluationTask.current().isEmpty());
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
    @DisplayName("given a batch of candidates")
    class Batches {
        private final List<TypedEObject> batch = candidates(40);

        @ParameterizedTest
        @ValueSource(ints = { 1, 8 })
        public void returnsTheOutputsInTheOrderOfTheCandidates(final int threads) throws Exception {
            // given
            useThreads(threads);
            final RecordingFunction recording = new RecordingFunction(true, batch);
            startRunWithFunction(recording);

            // when
            final List<TypedEObject> outputs = service.evaluateAll(batch);

            // then
            Assertions.assertEquals(batch.stream().map(recording.outputs::get).toList(), outputs);
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 8 })
        public void indicesCountersAndEventsDoNotDependOnTheThreads(final int threads) throws Exception {
            // given
            useThreads(threads);
            final RecordingFunction recording = new RecordingFunction(true, batch);
            startRunWithFunction(recording);
            final List<TypedEObject> published = new ArrayList<>();
            Mockito.doAnswer(invocation -> published.add(((IndividualEvaluated)invocation.getArgument(0)).candidate()))
                   .when(listener)
                   .on(ArgumentMatchers.any(IndividualEvaluated.class));

            // when
            service.evaluate(candidate);
            service.evaluateAll(batch);

            // then
            for(int i = 0; i < batch.size(); ++i) {
                Assertions.assertEquals(new EvaluationTask(0, i + 1), recording.tasks.get(batch.get(i)));
            }
            Assertions.assertEquals(batch.size() + 1, service.numberOfEvaluations(EvaluationSource.REAL));
            Assertions.assertEquals(batch, published.subList(1, published.size()));
        }

        @Test
        public void usesSeveralThreadsForAThreadSafeFunction() throws Exception {
            // given
            useThreads(8);
            final RecordingFunction recording = new RecordingFunction(true, batch);
            startRunWithFunction(recording);

            // when
            service.evaluateAll(batch);

            // then
            Assertions.assertTrue(recording.threads.values().stream().distinct().count() > 1);
        }

        @Test
        public void neverCallsAFunctionThatIsNotThreadSafeConcurrently() throws Exception {
            // given
            useThreads(8);
            final RecordingFunction recording = new RecordingFunction(false, batch);
            startRunWithFunction(recording);

            // when
            service.evaluateAll(batch);

            // then
            Assertions.assertEquals(1, recording.maximumInFlight.get());
            Assertions.assertEquals(List.of(Thread.currentThread().getName()),
                                    recording.threads.values().stream().distinct().toList());
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 8 })
        public void throwsTheFailureWithTheLowestIndexAfterAllEvaluations(final int threads) throws Exception {
            // given
            useThreads(threads);
            final RecordingFunction recording = new RecordingFunction(true, batch);
            recording.failing.add(batch.get(30));
            recording.failing.add(batch.get(7));
            startRunWithFunction(recording);

            // when
            final IllegalArgumentException failure = Assertions.assertThrows(IllegalArgumentException.class, () -> service.evaluateAll(batch));

            // then
            Assertions.assertEquals("candidate-7", failure.getMessage());
            Assertions.assertEquals("candidate-30", failure.getSuppressed()[0].getMessage());
            Assertions.assertEquals(batch.size(), recording.tasks.size());
            Assertions.assertEquals(batch.size(), service.numberOfEvaluations(EvaluationSource.REAL));
            Mockito.verify(listener, Mockito.times(batch.size() - 2)).on(ArgumentMatchers.any(IndividualEvaluated.class));
        }

        @ParameterizedTest
        @ValueSource(ints = { 1, 8 })
        public void rejectsABatchThatExceedsACutOffBudget(final int threads) throws Exception {
            // given
            useThreads(threads);
            final RecordingFunction recording = new RecordingFunction(true, batch);
            startRunWithFunction(recording);
            service.limit(EvaluationSource.REAL, batch.size() - 1, ExhaustionPolicy.CUT_OFF);

            // when
            Assertions.assertThrows(EvaluationBudgetExhaustedException.class, () -> service.evaluateAll(batch));

            // then
            Assertions.assertTrue(recording.tasks.isEmpty());
            Assertions.assertEquals(0, service.numberOfEvaluations(EvaluationSource.REAL));
            Assertions.assertEquals(OptionalLong.of(batch.size() - 1), service.remainingEvaluations());
        }

        @Test
        public void evaluatesTheWholeBatchBeyondAFinishIterationBudget() throws Exception {
            // given
            useThreads(8);
            final RecordingFunction recording = new RecordingFunction(true, batch);
            startRunWithFunction(recording);
            service.limit(EvaluationSource.REAL, 1, ExhaustionPolicy.FINISH_ITERATION);

            // when
            service.evaluateAll(batch);

            // then
            Assertions.assertEquals(batch.size(), service.numberOfEvaluations(EvaluationSource.REAL));
            Assertions.assertEquals(OptionalLong.empty(), service.remainingEvaluations());
        }

        @Test
        public void theThreadsAreStoppedAtTheEndOfTheRun() throws Exception {
            // given
            final EvaluationExecutor executor = useThreads(8);
            startRunWithFunction(new RecordingFunction(true, batch));
            service.evaluateAll(batch);

            // when
            final boolean hadThreads = executor.hasThreads();
            executor.shutdown();

            // then
            Assertions.assertTrue(hadThreads);
            Assertions.assertFalse(executor.hasThreads());
        }
    }
}
