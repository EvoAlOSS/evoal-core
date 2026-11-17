package de.evoal.optimisation.pso.main.impl;

import java.util.random.RandomGenerator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;

public class ARPSOSwarmTest {
    private final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
    private final EAttribute x = attribute("x");
    private final EAttribute y = attribute("y");
    private final Space space;

    public ARPSOSwarmTest() {
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);
        space = new Space(eClass);
    }

    private EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        eClass.getEStructuralFeatures().add(attribute);

        return attribute;
    }

    private Particle particle(final int id, final double xValue, final double yValue) {
        final TypedEObject position = space.newEObject();
        position.eSet(x, xValue);
        position.eSet(y, yValue);

        return new Particle(id, new State(position, TestFitness.evaluation(0.0)), null, RandomGenerator.of("L64X128MixRandom"));
    }

    @Test
    public void theDiversityIsTheMeanDistanceToTheMeanPositionRelativeToTheDiagonal() {
        // given: the mean position is (1, 10), every particle has the distance 1 to it
        final Particle[] particles = {particle(0, 0.0, 10.0), particle(1, 2.0, 10.0)};

        // when
        final double diversity = ARPSOSwarm.diversity(particles, 4.0);

        // then
        Assertions.assertEquals(1.0 / 4.0, diversity, 1e-12);
    }

    @Test
    public void everyVariableIsComparedWithItsOwnMean() {
        // given: the mean position is (0, 10); the distances are 3 and 4 in different variables
        final Particle[] particles = {particle(0, 3.0, 10.0), particle(1, -3.0, 10.0),
                                      particle(2, 0.0, 14.0), particle(3, 0.0, 6.0)};

        // when
        final double diversity = ARPSOSwarm.diversity(particles, 1.0);

        // then: (3 + 3 + 4 + 4) / 4
        Assertions.assertEquals(3.5, diversity, 1e-12);
    }
}
