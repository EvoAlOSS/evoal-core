package de.evoal.optimisation.pso.main.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.enterprise.inject.Instance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.Mockito;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.reproducibility.ReproducibilityProtocol;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.cdi.OptimisationComponentProducer;
import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationExecutor;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.evaluation.ExhaustionPolicy;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.fitness.Goals;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.pso.api.BoundaryType;
import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.main.mover.BasicMover;

/**
 * The particles of a swarm do not depend on the number of threads that move and evaluate
 *   them. A {@link DefaultSwarm} with a {@link BasicMover} and a ring topology runs on the
 *   real evaluator and evaluation service. Its optimisation function needs a random time per
 *   evaluation, so the evaluations end in a different order in every run, and adds a random
 *   number of its task stream to the objective. The budget ends in the middle of a batch
 *   ({@code cut-off}), so the last particles undo their move.
 */
public class ParallelSwarmReproducibilityTest {
    private static final int SIZE_OF_SWARM = 8;

    private static final int NEIGHBOURHOOD_SIZE = 3;

    /**
     * The budget of real evaluations; it ends in the middle of the batch of iteration 6.
     */
    private static final int BUDGET = 6 * SIZE_OF_SWARM + 3;

    /**
     * The search space: {@code x:0} and {@code x:1} in [-5, 5].
     */
    private final Space searchSpace = space("x:0", "x:1");

    /**
     * The optimisation space: {@code y}.
     */
    private final Space optimisationSpace = space("y");

    private final List<EAttribute> searchFeatures = searchSpace.getEClass().getEAllAttributes();

    private final EAttribute objective = optimisationSpace.getEClass().getEAllAttributes().getFirst();

    private static Space space(final String... names) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        for(final String name : names) {
            final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
            feature.setName(name);
            feature.setEType(EcorePackage.Literals.EDOUBLE);
            eClass.getEStructuralFeatures().add(feature);
        }

        return new Space(eClass);
    }

    private static void inject(final Object target, final Class<?> declaringClass, final String name, final Object value) throws Exception {
        final Field field = declaringClass.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    /**
     * A thread-safe function that needs between 1 and 5 ms per evaluation and computes
     *   {@code x0² + x1²} plus a random number of the evaluation's task stream. It records the
     *   threads that evaluated.
     */
    private final class DelayedFunction extends OptimisationFunctionImpl {
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

            final double x0 = (Double) candidate.eGet(searchFeatures.get(0));
            final double x1 = (Double) candidate.eGet(searchFeatures.get(1));
            final double noise = randomService.taskRandom("test/noise").nextDouble();
            final double value = x0 * x0 + x1 * x1 + noise;

            final TypedEObject output = optimisationSpace.newEObject();
            output.eSet(objective, value);

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
     * Minimises {@code y}: the optimisation value is {@code -y}.
     */
    private final class MinimiseObjective implements OptimisationValueComparator {
        @Override
        public OptimisationValueComparator init(final EObject configuration) {
            return this;
        }

        @Override
        public OptimisationValue toValue(final TypedEObject objectives, final Fitness fitness) {
            final double value = (Double) objectives.eGet(objective);

            return new TestFitness(-value);
        }
    }

    /**
     * Provides random points of the search space.
     */
    private final class RandomPoints implements InitialCandidatesProvider {
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
            final TypedEObject point = searchSpace.newEObject();
            for(final EAttribute feature : searchFeatures) {
                final double value = random.nextDouble(-5.0, 5.0);
                point.eSet(feature, value);
            }

            return point;
        }
    }

    /**
     * The result of a run.
     *
     * @param states The states of the particles after every iteration.
     * @param threads The names of the threads that evaluated.
     */
    private record RunResult(List<String> states, Set<String> threads) {
    }

    /**
     * Initialises the swarm and moves it until the budget ends.
     */
    private RunResult runWithThreads(final int numberOfThreads) throws Exception {
        final RandomService randomService = RandomService.withSeed(42);

        final DelayedFunction function = new DelayedFunction(randomService);
        final EvaluationExecutor executor = EvaluationExecutor.withThreads(numberOfThreads);
        final EvaluationService evaluationService = evaluationService(function, randomService, executor);
        final FitnessPipeline pipeline = new FitnessPipeline(new Goals(List.of()), List.of());
        final Evaluator evaluator = new Evaluator(evaluationService, pipeline, new MinimiseObjective());
        final DefaultSwarm swarm = swarm(evaluator, randomService, executor);

        final List<String> states = new ArrayList<>();
        try {
            swarm.initialise();
            states.add(describe(swarm));

            for(int iteration = 1; iteration <= 10; ++iteration) {
                swarm.move(iteration);
                swarm.evaluate();
                swarm.updatePersonalBests();
                states.add(describe(swarm));
            }

            Assertions.fail("The budget should have ended the run.");
        } catch(final EvaluationBudgetExhaustedException e) {
            states.add(describe(swarm));
        } finally {
            executor.shutdown();
        }

        return new RunResult(states, function.threads);
    }

    private static EvaluationService evaluationService(final OptimisationFunction function,
                                                      final RandomService randomService,
                                                      final EvaluationExecutor executor) throws Exception {
        final OptimisationComponentProducer componentProducer = Mockito.mock(OptimisationComponentProducer.class);
        Mockito.when(componentProducer.create(OptimisationFunction.class,
                                              OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                                              "algorithm.optimisation-function"))
               .thenReturn(function);

        final EvaluationService service = new EvaluationService();
        final ExecutionRecorder recorder = new ExecutionRecorder();
        inject(service, EvaluationService.class, "componentProducer", componentProducer);
        inject(service, EvaluationService.class, "randomService", randomService);
        inject(service, EvaluationService.class, "executor", executor);
        inject(service, EvaluationService.class, "events", new RunEventDispatcher(recorder));
        inject(service, EvaluationService.class, "recorder", recorder);

        @SuppressWarnings("unchecked")
        final Instance<MetricContributor> contributors = Mockito.mock(Instance.class, Mockito.CALLS_REAL_METHODS);
        Mockito.doAnswer(invocation -> List.<MetricContributor>of(service).iterator())
               .when(contributors)
               .iterator();
        inject(recorder, ExecutionRecorder.class, "contributors", contributors);
        inject(recorder, ExecutionRecorder.class, "reproducibility", new ReproducibilityProtocol());

        recorder.defineContributions();
        service.limit(EvaluationSource.REAL, BUDGET, ExhaustionPolicy.CUT_OFF);
        recorder.beginExecution();

        return service;
    }

    private DefaultSwarm swarm(final Evaluator evaluator,
                               final RandomService randomService,
                               final EvaluationExecutor executor) throws Exception {
        final DefaultSwarm swarm = new DefaultSwarm();
        inject(swarm, DefaultSwarm.class, "mover", mover());
        inject(swarm, DefaultSwarm.class, "neighborhoodTopology", new NeighborhoodTopology(NeighborhoodTopology.Topology.RING, SIZE_OF_SWARM, NEIGHBOURHOOD_SIZE));
        inject(swarm, DefaultSwarm.class, "evaluator", evaluator);
        inject(swarm, DefaultSwarm.class, "provider", new RandomPoints(randomService));
        inject(swarm, DefaultSwarm.class, "randomService", randomService);
        inject(swarm, DefaultSwarm.class, "executor", executor);
        inject(swarm, DefaultSwarm.class, "sizeOfPopulation", SIZE_OF_SWARM);

        return swarm;
    }

    /**
     * @return A mover with the default parameters of the DL type that bounces off the
     *   boundaries [-5, 5].
     */
    private BasicMover mover() throws Exception {
        final FeatureBoundaries boundaries = new FeatureBoundaries();
        final FeatureBoundaries.Boundaries interval = new FeatureBoundaries.Boundaries(-5.0, true, 5.0, true);
        searchFeatures.forEach(feature -> boundaries.add(feature, interval));

        final BasicMover mover = new BasicMover();
        inject(mover, BasicMover.class, "boundaries", boundaries);
        inject(mover, BasicMover.class, "boundaryType", BoundaryType.BOUNCE);
        inject(mover, BasicMover.class, "wstart", 0.9);
        inject(mover, BasicMover.class, "wend", 0.4);
        inject(mover, BasicMover.class, "inertiaIterations", 10);
        inject(mover, BasicMover.class, "c1", 2.0);
        inject(mover, BasicMover.class, "c2", 2.0);
        mover.init(null);

        return mover;
    }

    /**
     * @return The positions, velocities and values of the particles and their personal bests.
     */
    private String describe(final DefaultSwarm swarm) {
        return Arrays.stream(swarm.getParticles())
                     .map(this::describe)
                     .collect(Collectors.joining("\n"));
    }

    private String describe(final Particle particle) {
        final String position = describe(particle.getCurrentPosition());
        final String velocity = Arrays.toString(particle.getCurrentState().getVelocity());
        final OptimisationValue value = particle.getCurrentEvaluation().value();
        final String bestPosition = describe(particle.getBestPosition());
        final OptimisationValue bestValue = particle.getBestEvaluation().value();

        return position + " " + velocity + " " + value.toStatistics() + " best " + bestPosition + " " + bestValue.toStatistics();
    }

    private String describe(final TypedEObject position) {
        return searchFeatures.stream()
                             .map(position::eGet)
                             .map(String::valueOf)
                             .collect(Collectors.joining(", ", "(", ")"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 8 })
    public void theParticlesDoNotDependOnTheThreads(final int numberOfThreads) throws Exception {
        // given
        final RunResult sequential = runWithThreads(1);

        // when
        final RunResult parallel = runWithThreads(numberOfThreads);

        // then
        Assertions.assertTrue(parallel.threads().size() > 1, "evaluated on " + parallel.threads());
        Assertions.assertEquals(7, sequential.states().size());
        Assertions.assertEquals(sequential.states(), parallel.states());
    }
}
