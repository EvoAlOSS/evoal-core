package de.evoal.optimisation.pso.main.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;

import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;

public class SwarmPopulationTest {
    private final Space space = space();

    private final EAttribute x = (EAttribute) space.getEClass().getEStructuralFeature("x");

    private void moveTo(final Particle particle, final double value) {
        final TypedEObject position = position(value);
        particle.getCurrentState().setPosition(position);
    }

    private Particle particle(final int id, final double value) {
        final TypedEObject position = position(value);
        final Evaluation evaluation = TestFitness.evaluation(value);
        final State state = new State(position, evaluation);
        final RandomGenerator random = RandomGenerator.of("L64X128MixRandom");

        return new Particle(id, state, null, random);
    }

    private TypedEObject position(final double value) {
        final TypedEObject position = space.newEObject();
        position.eSet(x, value);

        return position;
    }

    private static Space space() {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName("x");
        feature.setEType(EcorePackage.Literals.EDOUBLE);

        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.getEStructuralFeatures().add(feature);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    /**
     * Two particles over three iterations: particle 0 moves in every iteration, particle 1
     *   keeps its position (as a new, equal position object, like a mover creates it).
     */
    @Nested
    @DisplayName("given the populations of a swarm in three iterations")
    class ThreeIterations {
        private final List<List<Candidate>> populations = new ArrayList<>();

        private final Particle moving = particle(0, 1.0);

        private final Particle resting = particle(1, 2.0);

        @BeforeEach
        public void runSwarm() {
            final Particle[] particles = {moving, resting};
            final SwarmPopulation population = new SwarmPopulation();

            populations.add(population.toMembers(particles));

            for(int number = 1; number < 3; ++number) {
                moveTo(moving, 1.0 + number);
                moveTo(resting, 2.0);

                populations.add(population.toMembers(particles));
            }
        }

        private Candidate memberOf(final int iteration, final int particle) {
            return populations.get(iteration).get(particle);
        }

        private Lineage lineageOf(final int iteration, final int particle) {
            return memberOf(iteration, particle).lineage();
        }

        @Test
        public void theInitialMembersHaveNoPredecessor() {
            Assertions.assertEquals(Lineage.NONE, lineageOf(0, 0));
            Assertions.assertEquals(Lineage.NONE, lineageOf(0, 1));
        }

        @Test
        public void aMovedParticleIsAMutationOfItsPreviousState() {
            Assertions.assertEquals(Lineage.mutation(memberOf(0, 0)), lineageOf(1, 0));
            Assertions.assertEquals(Lineage.mutation(memberOf(1, 0)), lineageOf(2, 0));
        }

        @Test
        public void anUnchangedParticleIsAnIdentityOfItsPreviousState() {
            Assertions.assertEquals(Lineage.identity(memberOf(0, 1)), lineageOf(1, 1));
            Assertions.assertEquals(Lineage.identity(memberOf(1, 1)), lineageOf(2, 1));
        }

        @Test
        public void theMembersAreTheParticlesInSwarmOrder() {
            final Candidate first = populations.get(2).get(0);

            Assertions.assertSame(moving.getCurrentPosition(), first.input());
            Assertions.assertSame(moving.getCurrentEvaluation(), first.evaluation());
        }
    }
}
