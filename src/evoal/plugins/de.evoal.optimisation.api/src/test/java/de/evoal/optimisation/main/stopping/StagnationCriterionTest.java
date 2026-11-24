package de.evoal.optimisation.main.stopping;

import java.lang.reflect.Field;

import org.eclipse.emf.ecore.EObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

import de.evoal.optimisation.api.model.StagnationMeasure;

public class StagnationCriterionTest {
    private final EObject configuration = Mockito.mock(EObject.class);

    private final AttributeEvaluator evaluator = Mockito.mock(AttributeEvaluator.class);

    private static void inject(final Object target, final String fieldName, final Object value) throws Exception {
        final Field field = StagnationCriterion.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    private static Iteration iteration(final int number) {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(number);

        return iteration;
    }

    /**
     * @return A criterion with the measure values of the iterations 0, 1, ... in turn.
     */
    private static StagnationCriterion criterion(final int iterations, final double... values) throws Exception {
        final StagnationCriterion criterion = new StagnationCriterion();
        inject(criterion, "iterations", iterations);
        inject(criterion, "stagnation", new Stagnation(0.0, 0.0));
        inject(criterion, "measure", new SequenceMeasure(values));

        return criterion;
    }

    @Test
    public void theRunStopsAfterTheGivenNumberOfIterationsWithoutImprovement() throws Exception {
        // given: iteration 0 sets 5, iteration 1 improves, then no improvement
        final StagnationCriterion criterion = criterion(3, 5.0, 4.0, 4.0, 4.5, 4.0, 3.0);

        // when / then
        Assertions.assertFalse(criterion.shouldTerminate(iteration(0)));
        Assertions.assertFalse(criterion.shouldTerminate(iteration(1)));
        Assertions.assertFalse(criterion.shouldTerminate(iteration(2)));
        Assertions.assertFalse(criterion.shouldTerminate(iteration(3)));
        Assertions.assertTrue(criterion.shouldTerminate(iteration(4)));
    }

    @Test
    public void iterationZeroStartsANewRun() throws Exception {
        // given: the first run stagnates, the second run starts with a worse value
        final StagnationCriterion criterion = criterion(1, 1.0, 1.0, 9.0, 8.0);
        criterion.shouldTerminate(iteration(0));
        Assertions.assertTrue(criterion.shouldTerminate(iteration(1)));

        // when / then: 9 is the new reference, 8 improves
        Assertions.assertFalse(criterion.shouldTerminate(iteration(0)));
        Assertions.assertFalse(criterion.shouldTerminate(iteration(1)));
    }

    @Test
    public void aNegativeToleranceIsRejected() throws Exception {
        // given
        final StagnationCriterion criterion = new StagnationCriterion();
        inject(criterion, "evaluator", evaluator);
        Mockito.when(evaluator.attributeToInteger(configuration, "iterations")).thenReturn(5);
        Mockito.when(evaluator.attributeToDouble(configuration, "absolute-tolerance")).thenReturn(-1.0);
        Mockito.when(evaluator.attributeToDouble(configuration, "relative-tolerance")).thenReturn(0.0);

        // when
        final InitializationException exception = Assertions.assertThrows(InitializationException.class,
                                                                          () -> criterion.init(configuration));

        // then
        Assertions.assertTrue(exception.getMessage().contains("absolute-tolerance"), exception.getMessage());
    }

    /**
     * Returns the given values in turn.
     */
    private static final class SequenceMeasure implements StagnationMeasure {
        private final double[] values;

        private int next;

        SequenceMeasure(final double... values) {
            this.values = values;
        }

        @Override
        public SequenceMeasure init(final EObject configuration) {
            return this;
        }

        @Override
        public double measure(final Iteration iteration) {
            return values[next++];
        }
    }
}
