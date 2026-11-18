package de.evoal.optimisation.main.comparator;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.fitness.Goals;

/**
 * The numeric and the hierarchical comparator on the canonical fitness, and the
 *   {@link FitnessValue} they create.
 */
public class FitnessComparatorsTest {
    private final Space space = space("a", "b");

    private final EStructuralFeature a = space.getEClass().getEStructuralFeature("a");

    private final EStructuralFeature b = space.getEClass().getEStructuralFeature("b");

    private static Space space(final String... names) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();

        for(final String name : names) {
            final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
            feature.setName(name);
            feature.setEType(EcorePackage.Literals.EDOUBLE);
            eClass.getEStructuralFeatures().add(feature);
        }

        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private TypedEObject objectives(final double valueOfA, final double valueOfB) {
        final TypedEObject objectives = space.newEObject();
        objectives.eSet(a, valueOfA);
        objectives.eSet(b, valueOfB);

        return objectives;
    }

    @Nested
    @DisplayName("given the numeric comparator and a maximised objective")
    class Numeric {
        private final FitnessLayout layout = FitnessLayout.of(new Goals(List.of(new Goal.Maximise(a))));

        private final NumericOptimisationComparator comparator = new NumericOptimisationComparator();

        private FitnessValue valueOf(final double objective) {
            final Fitness fitness = new Fitness(layout, new double[] {0.0 - objective});

            return comparator.toValue(objectives(objective, 0.0), fitness);
        }

        @Test
        public void theSmallerFitnessIsBetter() {
            // given
            final FitnessValue greaterObjective = valueOf(5.0);
            final FitnessValue smallerObjective = valueOf(3.0);

            // then
            Assertions.assertTrue(greaterObjective.isBetter(smallerObjective));
            Assertions.assertTrue(smallerObjective.isWorse(greaterObjective));
            Assertions.assertTrue(valueOf(3.0).isEqual(smallerObjective));
        }

        @Test
        public void theStatisticsShowTheObjective() {
            Assertions.assertEquals(List.of(5.0), valueOf(5.0).toStatistics());
        }

        @Test
        public void theDistanceIsTheAbsoluteDifferenceOfTheFitness() {
            Assertions.assertEquals(2.0, valueOf(5.0).distanceFrom(valueOf(3.0)));
            Assertions.assertEquals(2.0, valueOf(3.0).distanceFrom(valueOf(5.0)));
        }

        @Test
        public void theOptimisationSpaceValueAreTheObjectives() {
            // given
            final TypedEObject objectives = objectives(5.0, 0.0);
            final Fitness fitness = new Fitness(layout, new double[] {-5.0});

            // when
            final FitnessValue value = comparator.toValue(objectives, fitness);

            // then
            Assertions.assertSame(objectives, value.toOptmisationSpace());
            Assertions.assertSame(fitness, value.getFitness());
        }

        @Test
        public void aFitnessWithSeveralComponentsIsRejected() {
            // given
            final FitnessLayout twoGoals = FitnessLayout.of(new Goals(List.of(new Goal.Minimise(a), new Goal.Minimise(b))));
            final Fitness fitness = new Fitness(twoGoals, new double[] {1.0, 2.0});
            final TypedEObject objectives = objectives(1.0, 2.0);

            // when, then
            Assertions.assertThrows(IllegalArgumentException.class, () -> comparator.toValue(objectives, fitness));
        }

        @Test
        public void aValueOfAnotherComparatorCannotBeCompared() {
            // given
            final OptimisationValue other = Mockito.mock(OptimisationValue.class);
            final FitnessValue value = valueOf(1.0);

            // when, then
            Assertions.assertThrows(IllegalArgumentException.class, () -> value.compareTo(other));
        }
    }

    @Nested
    @DisplayName("given the hierarchical comparator with the order b, a")
    class Hierarchical {
        private final FitnessLayout layout = FitnessLayout.of(new Goals(List.of(new Goal.Minimise(a), new Goal.Minimise(b))));

        private final HierarchicalComparator comparator = new HierarchicalComparator();

        @BeforeEach
        public void configureOrder() throws Exception {
            final Field field = HierarchicalComparator.class.getDeclaredField("dimensionOrder");
            field.setAccessible(true);
            field.set(comparator, List.of(b, a));
        }

        private FitnessValue valueOf(final double valueOfA, final double valueOfB) {
            final Fitness fitness = new Fitness(layout, new double[] {valueOfA, valueOfB});

            return comparator.toValue(objectives(valueOfA, valueOfB), fitness);
        }

        @Test
        public void theFirstObjectiveOfTheOrderDecides() {
            Assertions.assertTrue(valueOf(9.0, 1.0).isBetter(valueOf(0.0, 2.0)));
        }

        @Test
        public void theNextObjectiveDecidesOnEquality() {
            Assertions.assertTrue(valueOf(1.0, 2.0).isBetter(valueOf(3.0, 2.0)));
            Assertions.assertTrue(valueOf(1.0, 2.0).isEqual(valueOf(1.0, 2.0)));
        }

        @Test
        public void theStatisticsShowTheObjectivesInTheOrder() {
            Assertions.assertEquals(List.of(2.0, 1.0), valueOf(1.0, 2.0).toStatistics());
        }

        @Test
        public void theDistanceSumsTheComparedComponents() {
            Assertions.assertEquals(5.0, valueOf(1.0, 2.0).distanceFrom(valueOf(3.0, -1.0)));
        }
    }
}
