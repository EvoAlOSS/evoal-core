package de.evoal.optimisation.main.stopping;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

@ExtendWith(MockitoExtension.class)
public class IterationCountCriterionTest {
    @Mock
    private EObject configuration;

    @Mock
    private AttributeEvaluator evaluator;

    private final IterationCountCriterion criterion = new IterationCountCriterion();

    @BeforeEach
    public void injectDependencies() throws Exception {
        final Field field = IterationCountCriterion.class.getDeclaredField("evaluator");
        field.setAccessible(true);
        field.set(criterion, evaluator);
    }

    private static Iteration iteration(final int number) {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(number);
        return iteration;
    }

    @Nested
    @DisplayName("given a maximum of 10 iterations")
    class TenIterations {
        @BeforeEach
        public void configure() throws Exception {
            Mockito.when(evaluator.attributeToInteger(configuration, "maximum-iterations"))
                   .thenReturn(10);
            criterion.init(configuration);
        }

        @Test
        public void theRunContinuesAfterTheInitialIteration() {
            Assertions.assertFalse(criterion.shouldTerminate(iteration(0)));
        }

        @Test
        public void theRunContinuesBeforeTheLastIteration() {
            Assertions.assertFalse(criterion.shouldTerminate(iteration(9)));
        }

        @Test
        public void theRunTerminatesAfterTheLastIteration() {
            Assertions.assertTrue(criterion.shouldTerminate(iteration(10)));
        }
    }

    @Nested
    @DisplayName("given a maximum of 0 iterations")
    class NoIterations {
        @BeforeEach
        public void configure() throws Exception {
            Mockito.when(evaluator.attributeToInteger(configuration, "maximum-iterations"))
                   .thenReturn(0);
            criterion.init(configuration);
        }

        @Test
        public void theRunTerminatesAfterTheInitialIteration() {
            Assertions.assertTrue(criterion.shouldTerminate(iteration(0)));
        }
    }
}
