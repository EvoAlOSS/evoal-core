package de.evoal.optimisation.pso.main.impl;

import java.util.List;
import java.util.random.RandomGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.memory.Individual;
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

    /**
     * Creates a particle whose fitness is the given value (greater is better).
     */
    private Particle particle(final int id, final double value) {
        final TypedEObject position = space.newEObject();
        final Fitness fitness = new Fitness(value);
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

    /**
     * An optimisation value with a single number, greater values are better.
     */
    private static final class Fitness extends MinimalEObjectImpl.Container implements OptimisationValue {
        private final double value;

        private Fitness(final double value) {
            this.value = value;
        }

        @Override
        public int compareTo(final OptimisationValue other) {
            final Fitness otherFitness = (Fitness) other;

            return Double.compare(value, otherFitness.value);
        }

        @Override
        public boolean isBetter(final OptimisationValue other) {
            return compareTo(other) > 0;
        }

        @Override
        public boolean isEqual(final OptimisationValue other) {
            return compareTo(other) == 0;
        }

        @Override
        public boolean isWorse(final OptimisationValue other) {
            return compareTo(other) < 0;
        }

        @Override
        public TypedEObject toOptmisationSpace() {
            return null;
        }

        @Override
        public List<Object> toStatistics() {
            return List.of(value);
        }
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
            final List<Rank> ranks = SwarmRanking.toRanks(particles);

            // then
            final List<List<Integer>> ids = idsOf(ranks);
            Assertions.assertEquals(List.of(List.of(1), List.of(2), List.of(0)), ids);
        }

        @Test
        public void theRanksAreNumberedFromZero() {
            // when
            final List<Rank> ranks = SwarmRanking.toRanks(particles);

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
            final List<Rank> ranks = SwarmRanking.toRanks(particles);

            // then
            final List<List<Integer>> ids = idsOf(ranks);
            Assertions.assertEquals(List.of(List.of(1, 3), List.of(0, 2)), ids);
        }
    }
}
