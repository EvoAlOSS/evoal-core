package de.evoal.optimisation.pso.api.swarm;

import java.util.random.RandomGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.pso.api.optimiser.Mover;

public class ParticleTest {
    private final Space space = space();

    private final EAttribute x = (EAttribute) space.getEClass().getEStructuralFeature("x");

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
     * A mover that moves the particle to a fixed position, as a mover changes the current state.
     */
    private static final class MoveTo implements Mover {
        private final TypedEObject target;

        private MoveTo(final TypedEObject target) {
            this.target = target;
        }

        @Override
        public Mover init(final EObject configuration) {
            return this;
        }

        @Override
        public void moveParticle(final State current,
                                 final State personalBest,
                                 final Particle[] neighbors,
                                 final int currentIteration,
                                 final int maxIterations,
                                 final RandomGenerator random) {
            current.setPosition(target);
        }
    }

    @Nested
    @DisplayName("given a particle at its start position")
    class ParticleAtStartPosition {
        private Particle particle;

        @BeforeEach
        public void createParticle() {
            final TypedEObject start = position(1.0);
            final TypedEObject target = position(5.0);
            final MoveTo mover = new MoveTo(target);
            final RandomGenerator random = RandomGenerator.of("L64X128MixRandom");

            particle = new Particle(0, new State(start, null), mover, random);
        }

        @Test
        public void movingDoesNotChangeThePersonalBest() {
            // when
            particle.moveParticle(new Particle[] {particle}, 0, 10);

            // then
            Assertions.assertEquals(5.0, particle.getCurrentPosition().eGet(x));
            Assertions.assertEquals(1.0, particle.getBestPosition().eGet(x));
        }

        @Test
        public void theBestPositionIsACopyOfTheGivenPosition() {
            // given
            final TypedEObject newBest = position(3.0);
            particle.setBestPosition(newBest);

            // when
            newBest.eSet(x, 7.0);

            // then
            Assertions.assertEquals(3.0, particle.getBestPosition().eGet(x));
        }

        @Test
        public void undoingAMoveRestoresThePreviousState() {
            // given
            final Double[] startVelocity = particle.getCurrentState().getVelocity();
            particle.moveParticle(new Particle[] {particle}, 0, 10);

            // when
            particle.undoMove();

            // then
            Assertions.assertEquals(1.0, particle.getCurrentPosition().eGet(x));
            Assertions.assertSame(startVelocity, particle.getCurrentState().getVelocity());
        }

        @Test
        public void aMoveCannotBeUndoneBeforeTheFirstMove() {
            // when, then
            Assertions.assertThrows(IllegalStateException.class, particle::undoMove);
        }
    }
}
