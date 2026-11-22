package de.evoal.surrogate.main.gof.rmse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

public class RootMeanSquaredErrorTest {
    private static final double[] ACTUAL = {1.0, 2.0, 3.0, 4.0};

    @Nested
    @DisplayName("given predictions that equal the actual values")
    class PerfectPredictions {
        @Test
        public void errorIsZero() {
            // when
            final OptionalDouble rmse = RootMeanSquaredError.of(ACTUAL, ACTUAL.clone());

            // then
            Assertions.assertEquals(0.0, rmse.orElseThrow());
        }
    }

    @Nested
    @DisplayName("given predictions with errors 1 and 3")
    class TwoErrors {
        @Test
        public void errorIsTheRootOfTheMeanSquaredError() {
            // when
            final OptionalDouble rmse = RootMeanSquaredError.of(ACTUAL, new double[] {2.0, 2.0, 3.0, 1.0});

            // then: (1 + 9) / 4
            Assertions.assertEquals(Math.sqrt(2.5), rmse.orElseThrow(), 1e-15);
        }
    }

    @Nested
    @DisplayName("given no values")
    class NoValues {
        @Test
        public void errorIsUndefined() {
            // when
            final OptionalDouble rmse = RootMeanSquaredError.of(new double[0], new double[0]);

            // then
            Assertions.assertTrue(rmse.isEmpty());
        }
    }

    @Nested
    @DisplayName("given fewer predicted than actual values")
    class DifferentLengths {
        @Test
        public void callIsRejected() {
            // when, then
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> RootMeanSquaredError.of(ACTUAL, new double[] {1.0}));
        }
    }
}
