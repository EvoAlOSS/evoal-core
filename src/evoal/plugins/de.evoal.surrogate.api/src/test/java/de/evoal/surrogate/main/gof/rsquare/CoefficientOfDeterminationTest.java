package de.evoal.surrogate.main.gof.rsquare;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

public class CoefficientOfDeterminationTest {
    private static final double[] ACTUAL = {1.0, 2.0, 3.0, 4.0};

    @Nested
    @DisplayName("given predictions that equal the actual values")
    class PerfectPredictions {
        @Test
        public void coefficientIsOne() {
            // when
            final OptionalDouble rSquare = CoefficientOfDetermination.of(ACTUAL, ACTUAL.clone());

            // then
            Assertions.assertEquals(1.0, rSquare.orElseThrow());
        }
    }

    @Nested
    @DisplayName("given predictions that equal the mean of the actual values")
    class MeanPredictions {
        @Test
        public void coefficientIsZero() {
            // when
            final OptionalDouble rSquare = CoefficientOfDetermination.of(ACTUAL, new double[] {2.5, 2.5, 2.5, 2.5});

            // then
            Assertions.assertEquals(0.0, rSquare.orElseThrow(), 1e-15);
        }
    }

    @Nested
    @DisplayName("given predictions with one error of 1")
    class OneError {
        @Test
        public void coefficientUsesTheTotalVariationWithoutBiasCorrection() {
            // when
            final OptionalDouble rSquare = CoefficientOfDetermination.of(ACTUAL, new double[] {1.0, 2.0, 3.0, 5.0});

            // then: squared error 1, total variation 5 (not 5 * 4 / 3)
            Assertions.assertEquals(0.8, rSquare.orElseThrow(), 1e-15);
        }
    }

    @Nested
    @DisplayName("given actual values that are all equal")
    class ConstantActualValues {
        @Test
        public void coefficientIsUndefined() {
            // when
            final OptionalDouble rSquare = CoefficientOfDetermination.of(new double[] {2.0, 2.0, 2.0}, new double[] {1.0, 2.0, 3.0});

            // then
            Assertions.assertTrue(rSquare.isEmpty());
        }
    }
}
