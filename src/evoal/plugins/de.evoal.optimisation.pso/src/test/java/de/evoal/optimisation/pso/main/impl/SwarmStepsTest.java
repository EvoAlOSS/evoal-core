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

import org.mockito.InOrder;
import org.mockito.Mockito;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.steps.SearchState;
import de.evoal.optimisation.api.steps.Step;

import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.optimisation.pso.main.impl.DefaultSwarm;
import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;

public class SwarmStepsTest {
    @Nested
    @DisplayName("given the steps of an iteration")
    class Iteration {
        private final Swarm swarm = Mockito.mock(Swarm.class);

        private final List<Step> steps = List.of(SwarmSteps.adjust(swarm),
                                                 SwarmSteps.move(swarm),
                                                 SwarmSteps.evaluate(swarm),
                                                 SwarmSteps.updatePersonalBests(swarm));

        @Test
        public void theSwarmIsAdjustedMovedEvaluatedAndUpdatedInThisOrder() {
            // given
            final SearchState state = new SearchState();

            // when
            steps.forEach(step -> step.execute(state));

            // then
            final InOrder order = Mockito.inOrder(swarm);
            order.verify(swarm).adjust(state.getIteration());
            order.verify(swarm).move(state.getIteration());
            order.verify(swarm).evaluate();
            order.verify(swarm).updatePersonalBests();
            order.verifyNoMoreInteractions();
        }

        @Test
        public void theStepsHaveTheKindsOfTheMetaModel() {
            final List<String> kinds = steps.stream()
                                            .map(Step::kind)
                                            .toList();

            Assertions.assertEquals(List.of("ParameterAdjustment", "Adaption", "FitnessCalculation", "Acceptance"), kinds);
            Assertions.assertEquals("Initialization", SwarmSteps.initialise(swarm).kind());
        }
    }

    /**
     * @return A position in a search space with the real variable {@code x}.
     */
    private static TypedEObject position(final double value) {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName("x");
        feature.setEType(EcorePackage.Literals.EDOUBLE);

        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.getEStructuralFeatures().add(feature);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        final TypedEObject position = new Space(eClass).newEObject();
        position.eSet(feature, value);

        return position;
    }

    @Nested
    @DisplayName("given a particle whose fitness changes")
    class PersonalBest {
        private final TypedEObject start = position(1.0);

        private final Particle particle = new Particle(0, new State(start, new TestFitness(2.0)), null,
                                                       RandomGenerator.of("L64X128MixRandom"));

        private final DefaultSwarm swarm = new DefaultSwarm();

        private void updateWithFitness(final double fitness) {
            particle.getCurrentState().setPosition(position(fitness));
            particle.setCurrentFitness(new TestFitness(fitness));
            swarm.setParticles(new Particle[] {particle});

            swarm.updatePersonalBests();
        }

        @Test
        public void aBetterPositionBecomesThePersonalBest() {
            // when
            updateWithFitness(3.0);

            // then
            Assertions.assertEquals(List.of(3.0), particle.getBestFitness().toStatistics());
        }

        @Test
        public void aWorsePositionKeepsThePersonalBest() {
            // when
            updateWithFitness(1.0);

            // then
            Assertions.assertEquals(List.of(2.0), particle.getBestFitness().toStatistics());
        }
    }
}
