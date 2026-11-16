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
import de.evoal.models.v202704.optimisation.memory.Identity;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.Mutation;
import de.evoal.models.v202704.optimisation.memory.Relationship;
import de.evoal.optimisation.api.model.IndividualIDGenerator;

import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;

public class SwarmMemoryTest {
    private final Space space = space();

    private final EAttribute x = (EAttribute) space.getEClass().getEStructuralFeature("x");

    /**
     * @return The individuals of all iterations.
     */
    private static List<Individual> individualsOf(final List<Iteration> iterations) {
        return iterations.stream()
                         .flatMap(Iteration::survivedIndividuals)
                         .toList();
    }

    private static Individual individualWithId(final List<Iteration> iterations, final int id) {
        return individualsOf(iterations).stream()
                                        .filter(individual -> individual.getId() == id)
                                        .findFirst()
                                        .orElseThrow();
    }

    private void moveTo(final Particle particle, final double value) {
        final TypedEObject position = position(value);
        particle.getCurrentState().setPosition(position);
    }

    private Particle particle(final int id, final double value) {
        final TypedEObject position = position(value);
        final TestFitness fitness = new TestFitness(value);
        final State state = new State(position, fitness);
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
     * Two particles over three iterations: particle 0 moves in every iteration,
     *   particle 1 keeps its position (as a new, equal position object, like a
     *   mover creates it). The ids are given in particle order, i.e., particle 0
     *   has the ids 0, 2, 4 and particle 1 the ids 1, 3, 5.
     */
    @Nested
    @DisplayName("given the memory of a swarm after three iterations")
    class ThreeIterations {
        private final List<Iteration> iterations = new ArrayList<>();

        @BeforeEach
        public void runSwarm() {
            final Particle moving = particle(0, 1.0);
            final Particle resting = particle(1, 2.0);
            final Particle[] particles = {moving, resting};
            final IndividualIDGenerator idGenerator = new IndividualIDGenerator();
            final SwarmMemory memory = new SwarmMemory(idGenerator);

            final Iteration initialIteration = memory.toIteration(0, particles);
            iterations.add(initialIteration);

            for(int number = 1; number < 3; ++number) {
                moveTo(moving, 1.0 + number);
                moveTo(resting, 2.0);

                final Iteration iteration = memory.toIteration(number, particles);
                iterations.add(iteration);
            }
        }

        @Test
        public void aMovedParticleIsAMutation() {
            // when
            final Individual individual = individualWithId(iterations, 2);

            // then
            final Relationship relationship = individual.getRelationships().getFirst();
            Assertions.assertInstanceOf(Mutation.class, relationship);
        }

        @Test
        public void anUnchangedParticleIsAnIdentity() {
            // when
            final Individual individual = individualWithId(iterations, 3);

            // then
            final Relationship relationship = individual.getRelationships().getFirst();
            Assertions.assertInstanceOf(Identity.class, relationship);
        }

        @Test
        public void everyLaterIndividualHasTheIndividualOfTheSameParticleAsItsOnlyPredecessor() {
            // when
            final List<Individual> laterIndividuals = individualsOf(iterations.subList(1, 3));

            // then
            for(final Individual individual : laterIndividuals) {
                final List<Relationship> relationships = individual.getRelationships();
                Assertions.assertEquals(1, relationships.size());

                final List<Individual> targets = relationships.getFirst().getTarget();
                final List<Integer> targetIds = targets.stream()
                                                       .map(Individual::getId)
                                                       .toList();
                final int predecessorId = individual.getId() - 2;
                Assertions.assertEquals(List.of(predecessorId), targetIds);
            }
        }

        private boolean hasNoRelationships(final Individual individual) {
            return individual.getRelationships().isEmpty();
        }

        @Test
        public void theIdsAreUniqueAcrossIterations() {
            // when
            final List<Integer> ids = individualsOf(iterations).stream()
                                                               .map(Individual::getId)
                                                               .sorted()
                                                               .toList();

            // then
            Assertions.assertEquals(List.of(0, 1, 2, 3, 4, 5), ids);
        }

        @Test
        public void theInitialIndividualsHaveNoPredecessor() {
            // when
            final List<Individual> initialIndividuals = individualsOf(iterations.subList(0, 1));

            // then
            final boolean withoutRelationships = initialIndividuals.stream()
                                                                   .allMatch(this::hasNoRelationships);
            Assertions.assertTrue(withoutRelationships);
        }
    }

    /**
     * Two particles whose fitness changes (greater is better): iteration 0 has the
     *   fitness values 1 and 2 (ids 0, 1), iteration 1 the values 3 and 2 (ids 2, 3),
     *   iteration 2 the values 0 and 3 (ids 4, 5).
     */
    @Nested
    @DisplayName("given a swarm whose best particle gets worse")
    class BestSoFar {
        private final List<Iteration> iterations = new ArrayList<>();

        private void moveTo(final Particle particle, final double value, final double fitness) {
            SwarmMemoryTest.this.moveTo(particle, value);
            particle.setCurrentFitness(new TestFitness(fitness));
        }

        @BeforeEach
        public void runSwarm() {
            final Particle first = particle(0, 1.0);
            final Particle second = particle(1, 2.0);
            final Particle[] particles = {first, second};
            final SwarmMemory memory = new SwarmMemory(new IndividualIDGenerator());

            iterations.add(memory.toIteration(0, particles));

            moveTo(first, 3.0, 3.0);
            moveTo(second, 2.5, 2.0);
            iterations.add(memory.toIteration(1, particles));

            moveTo(first, 0.0, 0.0);
            moveTo(second, 3.5, 3.0);
            iterations.add(memory.toIteration(2, particles));
        }

        private int bestSoFarId(final int iteration) {
            return iterations.get(iteration).getBestSoFar().getId();
        }

        @Test
        public void theBestOfTheInitialSwarmIsTheBestSoFar() {
            Assertions.assertEquals(1, bestSoFarId(0));
        }

        @Test
        public void aBetterIndividualBecomesTheBestSoFar() {
            Assertions.assertEquals(2, bestSoFarId(1));
        }

        @Test
        public void theBestSoFarStaysWhenTheSwarmGetsWorseOrOnlyEqual() {
            Assertions.assertEquals(2, bestSoFarId(2));
        }
    }
}
