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

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;

public class SwarmRankingTest {
    private final Space space = space();

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
            final List<List<Integer>> ranks = SwarmRanking.toRanks(particles);

            // then
            Assertions.assertEquals(List.of(List.of(1), List.of(2), List.of(0)), ranks);
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
            final List<List<Integer>> ranks = SwarmRanking.toRanks(particles);

            // then
            Assertions.assertEquals(List.of(List.of(1, 3), List.of(0, 2)), ranks);
        }
    }
}
