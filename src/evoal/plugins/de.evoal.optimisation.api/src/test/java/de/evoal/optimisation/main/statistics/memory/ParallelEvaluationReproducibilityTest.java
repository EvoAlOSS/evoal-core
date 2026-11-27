package de.evoal.optimisation.main.statistics.memory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import jakarta.enterprise.inject.Instance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.Mockito;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.reproducibility.ReproducibilityProtocol;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.cdi.OptimisationComponentProducer;
import de.evoal.optimisation.api.evaluation.EvaluationExecutor;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.evaluation.ExhaustionPolicy;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.fitness.Goals;
import de.evoal.optimisation.api.model.IndividualIDGenerator;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.run.CurrentRun;
import de.evoal.optimisation.api.run.OptimisationRun;
import de.evoal.optimisation.api.run.RunParameters;
import de.evoal.optimisation.api.steps.EvaluateCandidates;
import de.evoal.optimisation.api.steps.ReplacePopulation;
import de.evoal.optimisation.api.steps.SampleCandidates;
import de.evoal.optimisation.api.steps.Step;
import de.evoal.optimisation.api.steps.Template;
import de.evoal.optimisation.main.comparator.NumericOptimisationComparator;

/**
 * The memory model of a run does not depend on the number of threads that evaluate the
 *   candidates. A random search runs on the real run kernel, evaluation service, evaluator,
 *   fitness pipeline and memory model writer. Its optimisation function needs a random time
 *   per evaluation, so the evaluations end in a different order in every run, and adds a
 *   random number of its task stream to the objective. The budget ends in the middle of a
 *   batch ({@code cut-off}).
 */
public class ParallelEvaluationReproducibilityTest {
    /**
     * The number of candidates per iteration.
     */
    private static final int SAMPLES_PER_ITERATION = 8;

    /**
     * The budget of real evaluations; it ends in the middle of the fifth batch.
     */
    private static final int BUDGET = 37;

    @TempDir
    private Path outputRoot;

    /**
     * The search space features {@code x:0} and {@code x:1}.
     */
    private static final List<EAttribute> SEARCH_FEATURES = MemoryModels.SEARCH_SPACE.getEClass().getEAllAttributes();

    /**
     * The objective {@code y:0}.
     */
    private static final EAttribute OBJECTIVE = MemoryModels.OPTIMISATION_SPACE.getEClass().getEAllAttributes().getFirst();

    private static void inject(final Object target, final String name, final Object value) throws Exception {
        final Field field = target.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    /**
     * A thread-safe function that needs between 1 and 5 ms per evaluation and computes
     *   {@code x0² + x1²} plus a random number of the evaluation's task stream. It records the
     *   threads that evaluated.
     */
    private static final class DelayedFunction extends OptimisationFunctionImpl {
        private final RandomService randomService;

        private final Set<String> threads = ConcurrentHashMap.newKeySet();

        DelayedFunction(final RandomService randomService) {
            this.randomService = randomService;
        }

        @Override
        public boolean isThreadSafe() {
            return true;
        }

        @Override
        public TypedEObject evaluate(final TypedEObject candidate) {
            threads.add(Thread.currentThread().getName());
            waitRandomly();

            final double x0 = (Double) candidate.eGet(SEARCH_FEATURES.get(0));
            final double x1 = (Double) candidate.eGet(SEARCH_FEATURES.get(1));
            final double noise = randomService.taskRandom("test/noise").nextDouble();
            final double objective = x0 * x0 + x1 * x1 + noise;

            final TypedEObject output = MemoryModels.OPTIMISATION_SPACE.newEObject();
            output.eSet(OBJECTIVE, objective);

            return output;
        }

        /**
         * Waits between 1 and 5 ms, chosen independently of the seed.
         */
        private static void waitRandomly() {
            final int milliseconds = ThreadLocalRandom.current().nextInt(1, 6);
            try {
                Thread.sleep(milliseconds);
            } catch(final InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /**
     * Provides random points of the search space in [-5, 5)².
     */
    private static final class RandomPoints implements InitialCandidatesProvider {
        private final RandomGenerator random;

        RandomPoints(final RandomService randomService) {
            this.random = randomService.random("test/candidates");
        }

        @Override
        public InitialCandidatesProvider init(final EObject configuration) {
            return this;
        }

        @Override
        public Stream<TypedEObject> create() {
            return Stream.generate(this::randomPoint);
        }

        private TypedEObject randomPoint() {
            final TypedEObject point = MemoryModels.SEARCH_SPACE.newEObject();
            for(final EAttribute feature : SEARCH_FEATURES) {
                final double value = random.nextDouble(-5.0, 5.0);
                point.eSet(feature, value);
            }

            return point;
        }
    }

    /**
     * The result of a run.
     *
     * @param files The content of the written memory model files, by file name.
     * @param threads The names of the threads that evaluated.
     */
    private record RunResult(Map<String, String> files, Set<String> threads) {
    }

    /**
     * Runs the random search with the number of threads.
     */
    private RunResult runWithThreads(final int numberOfThreads) throws Exception {
        final RandomService randomService = RandomService.withSeed(42);

        final DelayedFunction function = new DelayedFunction(randomService);
        final ExecutionRecorder recorder = new ExecutionRecorder();
        final EvaluationService evaluationService = evaluationService(recorder, function, randomService);
        final EvaluationExecutor executor = EvaluationExecutor.withThreads(numberOfThreads);
        inject(evaluationService, "executor", executor);
        inject(evaluationService, "recorder", recorder);
        inject(recorder, "contributors", contributors(evaluationService));
        inject(recorder, "reproducibility", new ReproducibilityProtocol());

        final Problem problem = MemoryModels.problem();
        final Goals goals = MemoryModels.goals(problem);
        final FitnessPipeline pipeline = new FitnessPipeline(goals, List.of());

        recorder.defineContributions();
        evaluationService.limit(EvaluationSource.REAL, BUDGET, ExhaustionPolicy.CUT_OFF);
        recorder.defineFitness(pipeline.layout());
        recorder.beginExecution();

        final Path outputFolder = outputRoot.resolve("threads-" + numberOfThreads);
        final MemoryModelWriter writer = writer(recorder, problem, goals, outputFolder, randomService);
        final IndividualIDGenerator idGenerator = new IndividualIDGenerator();
        final RunEventDispatcher events = new RunEventDispatcher(recorder);
        inject(evaluationService, "events", events);

        final OptimisationRun kernel = new OptimisationRun(events, idGenerator, recorder, writer);
        final Evaluator evaluator = new Evaluator(evaluationService, pipeline, new NumericOptimisationComparator());
        final List<Step> steps = List.of(new SampleCandidates(new RandomPoints(randomService), SAMPLES_PER_ITERATION),
                                         new EvaluateCandidates(evaluator),
                                         new ReplacePopulation());

        try {
            kernel.execute(alwaysContinue(), new Template(steps, steps));
            recorder.finishRun();
        } finally {
            executor.shutdown();
        }

        final Map<String, String> files = contentOf(outputFolder.resolve(MemoryModelWriter.FOLDER_NAME));
        return new RunResult(files, function.threads);
    }

    private static EvaluationService evaluationService(final ExecutionRecorder recorder,
                                                      final OptimisationFunction function,
                                                      final RandomService randomService) throws Exception {
        final OptimisationComponentProducer componentProducer = Mockito.mock(OptimisationComponentProducer.class);
        Mockito.when(componentProducer.create(OptimisationFunction.class,
                                              OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                                              "algorithm.optimisation-function"))
               .thenReturn(function);

        final EvaluationService service = new EvaluationService();
        inject(service, "componentProducer", componentProducer);
        inject(service, "randomService", randomService);

        return service;
    }

    /**
     * @return The contributors of the recorder: only the evaluation service.
     */
    private static Instance<MetricContributor> contributors(final EvaluationService evaluationService) {
        @SuppressWarnings("unchecked")
        final Instance<MetricContributor> contributors = Mockito.mock(Instance.class, Mockito.CALLS_REAL_METHODS);
        Mockito.doAnswer(invocation -> List.<MetricContributor>of(evaluationService).iterator())
               .when(contributors)
               .iterator();

        return contributors;
    }

    /**
     * @return A memory model writer that also writes the executed steps.
     */
    private static MemoryModelWriter writer(final ExecutionRecorder recorder,
                                            final Problem problem,
                                            final Goals goals,
                                            final Path outputFolder,
                                            final RandomService randomService) throws Exception {
        final AttributeHelper attributes = Mockito.mock(AttributeHelper.class);
        Mockito.when(attributes.lookup(Mockito.any(EObject.class), Mockito.eq("steps"))).thenReturn(true);
        Mockito.when(attributes.lookup(Mockito.any(EObject.class), Mockito.eq("fitness-pipeline"))).thenReturn(List.of());

        final MemoryModelWriter writer = new MemoryModelWriter();
        inject(writer, "algorithm", MemoryModels.algorithmConfiguration());
        inject(writer, "annotationHelper", new EAnnotationHelper());
        inject(writer, "attributes", attributes);
        inject(writer, "evaluator", Mockito.mock(AttributeEvaluator.class));
        inject(writer, "goals", goals);
        inject(writer, "literature", MemoryModelWriterTest.literature(List.of()));
        inject(writer, "currentRun", CurrentRun.of(RunParameters.single(0, outputFolder.toFile())));
        inject(writer, "problem", problem);
        inject(writer, "randomService", randomService);
        inject(writer, "recorder", recorder);

        return writer;
    }

    /**
     * @return A criterion that always continues; the budget ends the run.
     */
    private static TerminationCriterion alwaysContinue() {
        final TerminationCriterion criterion = Mockito.mock(TerminationCriterion.class);
        Mockito.when(criterion.shouldContinue(Mockito.any())).thenReturn(true);

        return criterion;
    }

    /**
     * @return The content of the files in the folder, by file name.
     */
    private static Map<String, String> contentOf(final Path folder) throws IOException {
        final Map<String, String> content = new TreeMap<>();
        try(Stream<Path> files = Files.list(folder)) {
            for(final Path file : files.toList()) {
                final String name = file.getFileName().toString();
                content.put(name, Files.readString(file));
            }
        }

        return content;
    }

    @Test
    public void theRunWritesEveryIterationUntilTheBudgetEnds() throws Exception {
        // when
        final RunResult result = runWithThreads(1);

        // then
        final List<String> expectedFiles = List.of("execution-finished.json",
                                                   "execution-information.json",
                                                   "iteration-0.json",
                                                   "iteration-1.json",
                                                   "iteration-2.json",
                                                   "iteration-3.json",
                                                   "iteration-4.json");
        Assertions.assertEquals(expectedFiles, List.copyOf(result.files().keySet()));
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 8 })
    public void theMemoryModelDoesNotDependOnTheThreads(final int numberOfThreads) throws Exception {
        // given
        final RunResult sequential = runWithThreads(1);

        // when
        final RunResult parallel = runWithThreads(numberOfThreads);

        // then
        Assertions.assertTrue(parallel.threads().size() > 1, "evaluated on " + parallel.threads());
        Assertions.assertEquals(sequential.files().keySet(), parallel.files().keySet());
        for(final String file : sequential.files().keySet()) {
            Assertions.assertEquals(sequential.files().get(file), parallel.files().get(file), file);
        }
    }
}
