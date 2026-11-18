package de.evoal.optimisation.pso.main.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationExecutor;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.fitness.BatchEvaluation;
import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.pso.api.swarm.Particle;

public class DefaultSwarmTest {
    private final DefaultSwarm swarm = new DefaultSwarm();

    private final Evaluator evaluator = Mockito.mock(Evaluator.class);

    private final EvaluationBudgetExhaustedException exhaustion = new EvaluationBudgetExhaustedException(EvaluationSource.REAL, 2);

    private final Space space;

    public DefaultSwarmTest() throws Exception {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);
        final EAttribute x = EcoreFactory.eINSTANCE.createEAttribute();
        x.setName("x");
        x.setEType(EcorePackage.Literals.EDOUBLE);
        eClass.getEStructuralFeatures().add(x);
        space = new Space(eClass);

        inject("evaluator", evaluator);
    }

    private void inject(final String name, final Object value) throws Exception {
        final Field field = DefaultSwarm.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(swarm, value);
    }

    /**
     * @return {@code n} particles whose positions are points of the space.
     */
    private Particle[] particles(final int n) {
        final Particle[] particles = new Particle[n];
        for(int i = 0; i < n; ++i) {
            particles[i] = Mockito.mock(Particle.class);
            Mockito.when(particles[i].getCurrentPosition()).thenReturn(space.newEObject());
        }

        return particles;
    }

    @Test
    public void particlesBeyondTheBudgetUndoTheirMove() {
        // given
        final Particle[] particles = particles(4);
        swarm.setParticles(particles);
        final List<Evaluation> evaluations = List.of(TestFitness.evaluation(1.0), TestFitness.evaluation(2.0));
        Mockito.when(evaluator.evaluateAll(ArgumentMatchers.any())).thenReturn(new BatchEvaluation(evaluations, exhaustion));

        // when
        Assertions.assertSame(exhaustion, Assertions.assertThrows(EvaluationBudgetExhaustedException.class, swarm::evaluate));

        // then
        Mockito.verify(particles[0]).setCurrentEvaluation(evaluations.get(0));
        Mockito.verify(particles[1]).setCurrentEvaluation(evaluations.get(1));
        for(int i = 0; i < 4; ++i) {
            Mockito.verify(particles[i], Mockito.times(i < 2 ? 0 : 1)).undoMove();
        }
        Mockito.verify(particles[2], Mockito.never()).setCurrentEvaluation(ArgumentMatchers.any());
    }

    @Test
    public void allParticlesAreEvaluatedAsOneBatch() {
        // given
        final Particle[] particles = particles(3);
        swarm.setParticles(particles);
        final List<Evaluation> evaluations = List.of(TestFitness.evaluation(1.0), TestFitness.evaluation(2.0), TestFitness.evaluation(3.0));
        Mockito.when(evaluator.evaluateAll(ArgumentMatchers.any())).thenReturn(new BatchEvaluation(evaluations, null));

        // when
        swarm.evaluate();

        // then
        Mockito.verify(evaluator).evaluateAll(Stream.of(particles).map(Particle::getCurrentPosition).toList());
        for(int i = 0; i < 3; ++i) {
            Mockito.verify(particles[i]).setCurrentEvaluation(evaluations.get(i));
            Mockito.verify(particles[i], Mockito.never()).undoMove();
        }
    }

    @Test
    public void theInitialSwarmConsistsOfTheEvaluatedParticles() throws Exception {
        // given
        final List<TypedEObject> positions = new ArrayList<>();
        for(int i = 0; i < 4; ++i) {
            positions.add(space.newEObject());
        }
        final InitialCandidatesProvider provider = Mockito.mock(InitialCandidatesProvider.class);
        Mockito.when(provider.create()).thenAnswer(invocation -> positions.stream());
        inject("provider", provider);
        inject("sizeOfPopulation", 4);
        inject("randomService", RandomService.withSeed(42));
        final List<Evaluation> evaluations = List.of(TestFitness.evaluation(1.0), TestFitness.evaluation(2.0));
        Mockito.when(evaluator.evaluateAll(positions)).thenReturn(new BatchEvaluation(evaluations, exhaustion));

        // when
        Assertions.assertThrows(EvaluationBudgetExhaustedException.class, swarm::initialise);

        // then
        final Particle[] particles = swarm.getParticles();
        Assertions.assertEquals(2, particles.length);
        for(int i = 0; i < 2; ++i) {
            Assertions.assertSame(positions.get(i), particles[i].getCurrentPosition());
            Assertions.assertSame(evaluations.get(i), particles[i].getCurrentEvaluation());
        }
    }

    @Test
    public void everyParticleMovesOnceOnTheThreadsOfTheRun() throws Exception {
        // given
        final Particle[] particles = particles(20);
        swarm.setParticles(particles);
        final NeighborhoodTopology topology = Mockito.mock(NeighborhoodTopology.class);
        Mockito.when(topology.getNeighborIDs(ArgumentMatchers.anyInt())).thenReturn(new Integer[0]);
        inject("neighborhoodTopology", topology);
        final EvaluationExecutor executor = EvaluationExecutor.withThreads(4);
        inject("executor", executor);

        final Set<String> threads = ConcurrentHashMap.newKeySet();
        for(final Particle particle : particles) {
            Mockito.doAnswer(invocation -> threads.add(Thread.currentThread().getName()))
                   .when(particle)
                   .moveParticle(ArgumentMatchers.any(), ArgumentMatchers.eq(7));
        }

        try {
            // when
            swarm.move(7);

            // then
            for(final Particle particle : particles) {
                Mockito.verify(particle).moveParticle(ArgumentMatchers.any(), ArgumentMatchers.eq(7));
            }
            Assertions.assertTrue(threads.stream().allMatch(name -> name.startsWith("evoal-evaluation-")));
        } finally {
            executor.shutdown();
        }
    }
}
