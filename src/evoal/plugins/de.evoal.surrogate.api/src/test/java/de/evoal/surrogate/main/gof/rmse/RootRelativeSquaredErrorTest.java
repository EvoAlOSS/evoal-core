package de.evoal.surrogate.main.gof.rmse;

import de.evoal.surrogate.main.gof.rsquare.CoefficientOfDetermination;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

public class RootRelativeSquaredErrorTest {
    private static final double[] ACTUAL = {1.0, 2.0, 3.0, 4.0};

    @Nested
    @DisplayName("given predictions that equal the actual values")
    class PerfectPredictions {
        @Test
        public void errorIsZero() {
            // when
            final OptionalDouble rrse = RootRelativeSquaredError.of(ACTUAL, ACTUAL.clone());

            // then
            Assertions.assertEquals(0.0, rrse.orElseThrow());
        }
    }

    @Nested
    @DisplayName("given predictions that equal the mean of the actual values")
    class MeanPredictions {
        @Test
        public void errorIsOne() {
            // when
            final OptionalDouble rrse = RootRelativeSquaredError.of(ACTUAL, new double[] {2.5, 2.5, 2.5, 2.5});

            // then
            Assertions.assertEquals(1.0, rrse.orElseThrow(), 1e-15);
        }
    }

    @Nested
    @DisplayName("given predictions with one error of 1")
    class OneError {
        private final double[] predicted = {1.0, 2.0, 3.0, 5.0};

        @Test
        public void errorIsTheRootOfTheModelErrorOverTheErrorOfTheMean() {
            // when
            final OptionalDouble rrse = RootRelativeSquaredError.of(ACTUAL, predicted);

            // then: squared error 1, squared error of the mean 5
            Assertions.assertEquals(Math.sqrt(1.0 / 5.0), rrse.orElseThrow(), 1e-15);
        }

        @Test
        public void errorAndCoefficientOfDeterminationAgree() {
            // when
            final double rrse = RootRelativeSquaredError.of(ACTUAL, predicted).orElseThrow();
            final double rSquare = CoefficientOfDetermination.of(ACTUAL, predicted).orElseThrow();

            // then
            Assertions.assertEquals(1.0 - rSquare, rrse * rrse, 1e-15);
        }
    }

    @Nested
    @DisplayName("given actual values that are all equal")
    class ConstantActualValues {
        @Test
        public void errorIsUndefined() {
            // when
            final OptionalDouble rrse = RootRelativeSquaredError.of(new double[] {2.0, 2.0, 2.0}, new double[] {1.0, 2.0, 3.0});

            // then
            Assertions.assertTrue(rrse.isEmpty());
        }
    }

    @Nested
    @DisplayName("given fewer predicted than actual values")
    class DifferentLengths {
        @Test
        public void callIsRejected() {
            // when, then
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> RootRelativeSquaredError.of(ACTUAL, new double[] {1.0}));
        }
    }
}
