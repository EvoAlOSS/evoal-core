package de.evoal.optimisation.pso.main.impl;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;

import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;

public class SwarmRankingTest {
    private final Space space = space();

    /**
     * @return The ids of the members of every rank, in the order of the ranks.
     */
    private static List<List<Integer>> idsOf(final List<Rank> ranks) {
        return ranks.stream()
                    .map(SwarmRankingTest::idsOf)
                    .toList();
    }

    private static List<Integer> idsOf(final Rank rank) {
        return rank.getMembers()
                   .stream()
                   .map(Individual::getId)
                   .toList();
    }

    private static Individual individual(final int id) {
        final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
        individual.setId(id);

        return individual;
    }

    /**
     * @return One individual per particle, its id is the particle's index.
     */
    private static Individual[] individualsOf(final Particle[] particles) {
        return IntStream.range(0, particles.length)
                        .mapToObj(SwarmRankingTest::individual)
                        .toArray(Individual[]::new);
    }

    /**
     * Creates a particle whose fitness is the given value (greater is better).
     */
    private Particle particle(final int id, final double value) {
        final TypedEObject position = space.newEObject();
        final TestFitness fitness = new TestFitness(value);
        final State state = new State(position, fitness);
        final RandomGenerator random = RandomGenerator.of("L64X128MixRandom");

        return new Particle(id, state, null, random);
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

    @Nested
    @DisplayName("given a swarm whose best particle is not the first one")
    class BestParticleIsNotFirst {
        private final Particle[] particles = {
            particle(0, 1.0),
            particle(1, 3.0),
            particle(2, 2.0)
        };

        @Test
        public void theBestParticleIsInTheFirstRank() {
            // when
            final Individual[] individuals = individualsOf(particles);
            final List<Rank> ranks = SwarmRanking.toRanks(particles, individuals);

            // then
            final List<List<Integer>> ids = idsOf(ranks);
            Assertions.assertEquals(List.of(List.of(1), List.of(2), List.of(0)), ids);
        }

        @Test
        public void theRanksAreNumberedFromZero() {
            // when
            final Individual[] individuals = individualsOf(particles);
            final List<Rank> ranks = SwarmRanking.toRanks(particles, individuals);

            // then
            final List<Integer> numbers = ranks.stream()
                                               .map(Rank::getNumber)
                                               .toList();
            Assertions.assertEquals(List.of(0, 1, 2), numbers);
        }
    }

    @Nested
    @DisplayName("given a swarm with particles of equal fitness")
    class EqualFitness {
        private final Particle[] particles = {
            particle(0, 1.0),
            particle(1, 2.0),
            particle(2, 1.0),
            particle(3, 2.0)
        };

        @Test
        public void particlesOfEqualFitnessShareARankInSwarmOrder() {
            // when
            final Individual[] individuals = individualsOf(particles);
            final List<Rank> ranks = SwarmRanking.toRanks(particles, individuals);

            // then
            final List<List<Integer>> ids = idsOf(ranks);
            Assertions.assertEquals(List.of(List.of(1, 3), List.of(0, 2)), ids);
        }
    }
}
