package de.evoal.optimisation.api.constraints;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Iteration;

/**
 * The {@link ConstraintEvaluation}: it measures every constraint once per candidate, counts the
 *   measurements and never needs the optimisation function.
 */
public class ConstraintEvaluationTest {
    private final ConstraintEvaluation evaluation = new ConstraintEvaluation();

    private final TypedEObject input = Mockito.mock(TypedEObject.class);

    private final TypedEObject objectives = Mockito.mock(TypedEObject.class);

    /**
     * Measures the degree from the number of the constraint: constraint n has degree n - 1.
     */
    private final ConstraintMeasure measure = (constraint, input, objectives) -> constraint.number() - 1.0;

    @Nested
    @DisplayName("given three constraints")
    class ThreeConstraints {
        private final Constraints constraints = TestConstraints.constraints("a", "b", "a");

        @BeforeEach
        public void setUp() {
            evaluation.setUp(constraints, measure);
        }

        @Test
        public void everyConstraintIsMeasured() {
            // when
            final ViolationRecord record = evaluation.measure(input, objectives);

            // then
            final Map<String, Double> expected = Map.of("violation-1", 0.0, "violation-2", 1.0, "violation-3", 2.0);
            Assertions.assertEquals(expected, record.toProperties());
        }

        @Test
        public void everyMeasuredConstraintIsCounted() {
            // when
            evaluation.measure(input, objectives);
            evaluation.measure(input, objectives);

            // then
            Assertions.assertEquals(6, evaluation.numberOfEvaluations());
        }

        @Test
        public void theCounterIsTheMetricOfTheIteration() {
            // given
            evaluation.measure(input, objectives);
            final Iteration iteration = Mockito.mock(Iteration.class);
            final EMap<String, Number> metrics = new BasicEMap<>();
            Mockito.when(iteration.getMetrics()).thenReturn(metrics);

            // when
            evaluation.contributeTo(iteration);

            // then
            Assertions.assertEquals(3L, metrics.get(ConstraintEvaluation.METRIC));
        }
    }

    @Nested
    @DisplayName("given a problem without constraints")
    class NoConstraints {
        @BeforeEach
        public void setUp() {
            evaluation.setUp(Constraints.NONE, null);
        }

        @Test
        public void theRecordIsEmptyAndNothingIsCounted() {
            // when
            final ViolationRecord record = evaluation.measure(input, objectives);

            // then
            Assertions.assertSame(ViolationRecord.NONE, record);
            Assertions.assertEquals(0, evaluation.numberOfEvaluations());
        }

        @Test
        public void theIterationGetsNoMetric() {
            // given
            final Iteration iteration = Mockito.mock(Iteration.class);

            // when
            evaluation.contributeTo(iteration);

            // then
            Mockito.verifyNoInteractions(iteration);
        }
    }

    @Nested
    @DisplayName("given a measure that throws")
    class FailingMeasure {
        @Test
        public void theFailureIsPassedOn() {
            // given
            evaluation.setUp(TestConstraints.constraints("a"), (constraint, in, out) -> {
                throw new IllegalStateException("failed");
            });

            // then
            Assertions.assertThrows(IllegalStateException.class, () -> evaluation.measure(input, objectives));
        }
    }
}
