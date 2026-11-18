package de.evoal.optimisation.api.fitness;

import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.model.ModelFactory;
import de.evoal.models.v202704.optimisation.model.TargetGoal;

import de.evoal.optimisation.main.fitness.SquaredDistance;

public class GoalTest {
    private static final Function<Configuration, TargetDistance> SQUARED = configuration -> new SquaredDistance();

    private static EClass optimisationSpace() {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName("y");
        feature.setEType(EcorePackage.Literals.EDOUBLE);

        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.getEStructuralFeatures().add(feature);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return eClass;
    }

    private static TargetGoal targetGoal(final EStructuralFeature objective) {
        final TargetGoal goal = ModelFactory.eINSTANCE.createTargetGoal();
        goal.setData(objective);

        return goal;
    }

    @Nested
    @DisplayName("given a target goal with a constant target")
    class ConstantTarget {
        private final EClass space = optimisationSpace();

        private final EStructuralFeature y = space.getEStructuralFeature("y");

        @Test
        public void theTargetAndTheDistanceAreTakenFromTheGoal() {
            // given
            final TargetGoal goal = targetGoal(y);
            goal.setValue(3.0);

            // when
            final Goal.Target target = (Goal.Target) Goal.of(goal, null, SQUARED);

            // then
            Assertions.assertEquals(3.0, target.target());
            Assertions.assertEquals(4.0, target.distanceOf(1.0));
        }
    }

    @Nested
    @DisplayName("given a target goal that takes its target from the evaluation")
    class TargetFromEvaluation {
        private final EClass space = optimisationSpace();

        private final EStructuralFeature y = space.getEStructuralFeature("y");

        private final TargetGoal goal = targetGoal(y);

        TargetFromEvaluation() {
            goal.setFromEvaluation(true);
        }

        @Test
        public void theTargetIsTheValueOfTheTargetPoint() {
            // given
            final EObject targetPoint = EcoreUtil.create(space);
            targetPoint.eSet(y, -2.0);

            // when
            final Goal.Target target = (Goal.Target) Goal.of(goal, targetPoint, SQUARED);

            // then
            Assertions.assertEquals(-2.0, target.target());
        }

        @Test
        public void theTargetPointMayBeAnObjectOfAnotherClassWithTheSameFeatureName() {
            // given
            final EClass otherSpace = optimisationSpace();
            final EObject targetPoint = EcoreUtil.create(otherSpace);
            targetPoint.eSet(otherSpace.getEStructuralFeature("y"), 7.0);

            // when
            final Goal.Target target = (Goal.Target) Goal.of(goal, targetPoint, SQUARED);

            // then
            Assertions.assertEquals(7.0, target.target());
        }

        @Test
        public void aMissingTargetPointIsRejected() {
            // when
            final IllegalStateException exception =
                    Assertions.assertThrows(IllegalStateException.class, () -> Goal.of(goal, null, SQUARED));

            // then
            Assertions.assertTrue(exception.getMessage().contains("'y'"), exception.getMessage());
        }
    }
}
