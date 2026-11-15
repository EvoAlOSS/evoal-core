package de.evoal.optimisation.local_search.main.cooling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;

@ExtendWith(MockitoExtension.class)
public class LinearDecreaseFunctionTest {
    @Mock
    private EObject configuration;

    @Mock
    private AttributeEvaluator evaluator;

    @InjectMocks
    private LinearDecreaseFunction function;

    @Nested
    @DisplayName("given a linear decrease over 10 iterations starting at 5.0")
    class TenIterations {
        @BeforeEach
        public void configure() {
            Mockito.when(evaluator.attributeToInteger(configuration, "iterations"))
                   .thenReturn(10);
            function.init(configuration);
        }

        @Test
        public void theValueDecreasesByATenthPerIteration() {
            // when
            final double value = function.decrease(5.0, 5.0, 4);

            // then
            Assertions.assertEquals(3.0, value, 1e-12);
        }

        @Test
        public void theValueReachesZeroAfterTheLastIteration() {
            // when
            final double value = function.decrease(0.5, 5.0, 10);

            // then
            Assertions.assertEquals(0.0, value, 1e-12);
        }

        @Test
        public void theValueStaysZeroAfterwards() {
            // when
            final double value = function.decrease(0.0, 5.0, 15);

            // then
            Assertions.assertEquals(0.0, value);
        }
    }
}
