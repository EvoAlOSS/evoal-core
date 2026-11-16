package de.evoal.optimisation.main.stopping;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.evaluation.ExhaustionPolicy;

public class EvaluationBudgetCriterionTest {
    private final EObject configuration = Mockito.mock(EObject.class);

    private final EvaluationBudgetCriterion criterion = new EvaluationBudgetCriterion();

    private final EvaluationService evaluationService = Mockito.mock(EvaluationService.class);

    private final AttributeEvaluator evaluator = Mockito.mock(AttributeEvaluator.class);

    private final AttributeHelper helper = Mockito.mock(AttributeHelper.class);

    /**
     * Configures the criterion with the given maximum and exhaustion literal.
     */
    private void configure(final int maximumEvaluations, final String exhaustion) {
        final EEnumLiteral literal = EcoreFactory.eINSTANCE.createEEnumLiteral();
        literal.setName(exhaustion);

        Mockito.when(evaluator.attributeToInteger(configuration, "maximum-evaluations")).thenReturn(maximumEvaluations);
        Mockito.when(helper.<EEnumLiteral>lookup(configuration, "exhaustion")).thenReturn(literal);
    }

    @BeforeEach
    public void injectDependencies() throws Exception {
        inject("evaluationService", evaluationService);
        inject("evaluator", evaluator);
        inject("helper", helper);
    }

    private void inject(final String fieldName, final Object value) throws Exception {
        final Field field = EvaluationBudgetCriterion.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(criterion, value);
    }

    private static Iteration iteration(final long numberOfRealEvaluations) {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.getMetrics().put("evaluations.real", numberOfRealEvaluations);

        return iteration;
    }

    @Nested
    @DisplayName("given a budget of 5 evaluations that finishes the iteration")
    class FinishIteration {
        @BeforeEach
        public void init() {
            configure(5, "finish-iteration");
            criterion.init(configuration);
        }

        @Test
        public void limitsTheRealEvaluations() {
            Mockito.verify(evaluationService).limit(EvaluationSource.REAL, 5, ExhaustionPolicy.FINISH_ITERATION);
        }

        @Test
        public void theRunContinuesBelowTheBudget() {
            Assertions.assertFalse(criterion.shouldTerminate(iteration(4)));
        }

        @Test
        public void theRunTerminatesAtTheBudget() {
            Assertions.assertTrue(criterion.shouldTerminate(iteration(5)));
        }

        @Test
        public void theRunTerminatesAboveTheBudget() {
            Assertions.assertTrue(criterion.shouldTerminate(iteration(7)));
        }

        @Test
        public void anIterationWithoutEvaluationCountIsRejected() {
            // given
            final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();

            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> criterion.shouldTerminate(iteration));
        }
    }

    @Nested
    @DisplayName("given a budget that cuts off")
    class CutOff {
        @Test
        public void declaresACutOffBudget() {
            // given
            configure(3, "cut-off");

            // when
            criterion.init(configuration);

            // then
            Mockito.verify(evaluationService).limit(EvaluationSource.REAL, 3, ExhaustionPolicy.CUT_OFF);
        }
    }

    @Nested
    @DisplayName("given an unknown exhaustion")
    class UnknownExhaustion {
        @Test
        public void theConfigurationIsRejected() {
            // given
            configure(3, "stop-somehow");

            // when, then
            Assertions.assertThrows(IllegalArgumentException.class, () -> criterion.init(configuration));
        }
    }
}
