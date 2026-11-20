package de.evoal.optimisation.main.stopping;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.fitness.Goals;
import de.evoal.optimisation.main.fitness.AbsoluteDistance;

public class TargetValueCriterionTest {
    /**
     * The optimisation space with the objectives {@code y} and {@code z}.
     */
    private static final Space SPACE = space("y", "z");

    private static final EStructuralFeature Y = SPACE.getEClass().getEStructuralFeature("y");

    private static final EStructuralFeature Z = SPACE.getEClass().getEStructuralFeature("z");

    private final EObject configuration = Mockito.mock(EObject.class);

    private final AttributeEvaluator evaluator = Mockito.mock(AttributeEvaluator.class);

    private final AttributeHelper helper = Mockito.mock(AttributeHelper.class);

    /**
     * @return A criterion for the objective {@code y} and the target, with the goals of the
     *   problem.
     */
    private TargetValueCriterion criterion(final double target, final Goal... goals) throws Exception {
        final TargetValueCriterion criterion = new TargetValueCriterion();
        inject(criterion, "evaluator", evaluator);
        inject(criterion, "helper", helper);
        inject(criterion, "goals", new Goals(List.of(goals)));

        Mockito.when(helper.<EStructuralFeature>lookup(configuration, "objective")).thenReturn(Y);
        Mockito.when(evaluator.attributeToDouble(configuration, "target")).thenReturn(target);

        criterion.init(configuration);

        return criterion;
    }

    private static void inject(final TargetValueCriterion criterion, final String fieldName, final Object value)
            throws Exception {
        final Field field = TargetValueCriterion.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(criterion, value);
    }

    /**
     * @return An individual with the objectives and the degrees of violation (properties
     *   {@code violation-1}, {@code violation-2}, ...).
     */
    private static Individual individual(final double y, final double z, final double... violations) {
        final TypedEObject output = SPACE.newEObject();
        output.eSet(Y, y);
        output.eSet(Z, z);

        final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
        individual.setOutput(output);
        for(int index = 0; index < violations.length; ++index) {
            individual.getProperties().put("violation-" + (index + 1), violations[index]);
        }

        return individual;
    }

    private static Iteration iteration(final Individual bestSoFar) {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setBestSoFar(bestSoFar);

        return iteration;
    }

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

    @Nested
    @DisplayName("given a goal minimise and the target 0.01")
    class Minimise {
        @Test
        public void aValueAboveTheTargetContinues() throws Exception {
            final TargetValueCriterion criterion = criterion(0.01, new Goal.Minimise(Y));

            Assertions.assertFalse(criterion.shouldTerminate(iteration(individual(0.5, 0.0))));
        }

        @Test
        public void aValueEqualToTheTargetContinues() throws Exception {
            final TargetValueCriterion criterion = criterion(0.01, new Goal.Minimise(Y));

            Assertions.assertFalse(criterion.shouldTerminate(iteration(individual(0.01, 0.0))));
        }

        @Test
        public void aValueBelowTheTargetStops() throws Exception {
            final TargetValueCriterion criterion = criterion(0.01, new Goal.Minimise(Y));

            Assertions.assertTrue(criterion.shouldTerminate(iteration(individual(0.009, 0.0))));
        }

        @Test
        public void theBestIndividualOfAnEarlierIterationCounts() throws Exception {
            // given: the best individual so far stems from an earlier iteration, the current
            //   iteration (e.g. of simulated annealing) only holds a worse one
            final TargetValueCriterion criterion = criterion(0.01, new Goal.Minimise(Y));
            final Individual earlier = individual(0.001, 0.0);
            final Iteration iteration = iteration(earlier);
            iteration.setNumber(7);

            // when, then
            Assertions.assertTrue(criterion.shouldTerminate(iteration));
        }

        @Test
        public void anIterationWithoutBestIndividualContinues() throws Exception {
            final TargetValueCriterion criterion = criterion(0.01, new Goal.Minimise(Y));

            Assertions.assertFalse(criterion.shouldTerminate(iteration(null)));
        }

        @Test
        public void onlyTheConfiguredObjectiveCounts() throws Exception {
            // given: z is far below the target, y is not
            final TargetValueCriterion criterion = criterion(0.01, new Goal.Minimise(Y), new Goal.Minimise(Z));

            Assertions.assertFalse(criterion.shouldTerminate(iteration(individual(0.5, -100.0))));
        }
    }

    @Nested
    @DisplayName("given a goal maximise and the target 10")
    class Maximise {
        @Test
        public void aValueBelowTheTargetContinues() throws Exception {
            final TargetValueCriterion criterion = criterion(10.0, new Goal.Maximise(Y));

            Assertions.assertFalse(criterion.shouldTerminate(iteration(individual(9.5, 0.0))));
        }

        @Test
        public void aValueEqualToTheTargetContinues() throws Exception {
            final TargetValueCriterion criterion = criterion(10.0, new Goal.Maximise(Y));

            Assertions.assertFalse(criterion.shouldTerminate(iteration(individual(10.0, 0.0))));
        }

        @Test
        public void aValueAboveTheTargetStops() throws Exception {
            final TargetValueCriterion criterion = criterion(10.0, new Goal.Maximise(Y));

            Assertions.assertTrue(criterion.shouldTerminate(iteration(individual(10.5, 0.0))));
        }
    }

    @Nested
    @DisplayName("given a goal towards 5 with the absolute distance and the target 5.1")
    class Towards {
        @Test
        public void aValueCloserToTheGoalStops() throws Exception {
            // given: distance of the target 0.1
            final TargetValueCriterion criterion = criterion(5.1, new Goal.Target(Y, 5.0, new AbsoluteDistance()));

            // when, then: distance 0.05 on the other side of the goal's target
            Assertions.assertTrue(criterion.shouldTerminate(iteration(individual(4.95, 0.0))));
        }

        @Test
        public void aValueFartherFromTheGoalContinues() throws Exception {
            final TargetValueCriterion criterion = criterion(5.1, new Goal.Target(Y, 5.0, new AbsoluteDistance()));

            Assertions.assertFalse(criterion.shouldTerminate(iteration(individual(4.8, 0.0))));
        }
    }

    @Nested
    @DisplayName("given constraints")
    class Constraints {
        @Test
        public void anInfeasibleBestIndividualContinues() throws Exception {
            final TargetValueCriterion criterion = criterion(0.01, new Goal.Minimise(Y));

            Assertions.assertFalse(criterion.shouldTerminate(iteration(individual(0.0, 0.0, 0.0, 0.2))));
        }

        @Test
        public void aFeasibleBestIndividualStops() throws Exception {
            final TargetValueCriterion criterion = criterion(0.01, new Goal.Minimise(Y));

            Assertions.assertTrue(criterion.shouldTerminate(iteration(individual(0.0, 0.0, 0.0, 0.0))));
        }
    }

    @Nested
    @DisplayName("given an objective without goal")
    class WithoutGoal {
        @Test
        public void theConfigurationIsRejected() {
            final InitializationException exception =
                    Assertions.assertThrows(InitializationException.class,
                                            () -> criterion(0.01, new Goal.Minimise(Z)));

            Assertions.assertTrue(exception.getMessage().contains("'y'"), exception.getMessage());
        }
    }
}
