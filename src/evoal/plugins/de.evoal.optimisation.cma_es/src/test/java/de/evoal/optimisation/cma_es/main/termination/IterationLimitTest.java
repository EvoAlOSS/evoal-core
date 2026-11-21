package de.evoal.optimisation.cma_es.main.termination;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class IterationLimitTest {
    @Nested
    @DisplayName("given the quadratic limit of the archived BBOB entries (a = 100, b = 50)")
    class Quadratic {
        private final IterationLimit limit = new QuadraticIterationLimit(100.0, 50.0);

        @Test
        public void limitIsAPlusBTimesTheSquareOverTheRootOfLambda() {
            // when
            final double value = limit.of(10, 10);

            // then: 100 + 50 * 13^2 / sqrt(10)
            Assertions.assertEquals(100.0 + 50.0 * 169.0 / Math.sqrt(10.0), value, 1e-12);
        }

        @Test
        public void iterationsAreTheCeilingOfTheLimit() {
            // when
            final long iterations = limit.iterations(10, 10);

            // then: 2772.1...
            Assertions.assertEquals(2773L, iterations);
        }

        @Test
        public void aLargerPopulationGetsFewerIterations() {
            // when
            final long small = limit.iterations(10, 10);
            final long large = limit.iterations(10, 40);

            // then: 100 + 50 * 169 / sqrt(40) = 1436.1...
            Assertions.assertEquals(1437L, large);
            Assertions.assertTrue(large < small);
        }
    }

    @Nested
    @DisplayName("given the sep limit of the archived BBOB entry (a = 100, b = 300)")
    class Sep {
        private final IterationLimit limit = new SepIterationLimit(100.0, 300.0);

        @Test
        public void limitIsAPlusBTimesNTimesTheRootOfNOverLambda() {
            // when
            final double value = limit.of(10, 10);

            // then: 100 + 300 * 10 * sqrt(10 / 10)
            Assertions.assertEquals(3100.0, value, 1e-12);
        }

        @Test
        public void populationSizeEntersUnderTheRoot() {
            // when
            final double value = limit.of(10, 40);

            // then: 100 + 300 * 10 * sqrt(1 / 4)
            Assertions.assertEquals(1600.0, value, 1e-12);
        }
    }

    @Nested
    @DisplayName("given a fixed limit of 50 iterations")
    class Fixed {
        private final IterationLimit limit = new FixedIterationLimit(50);

        @Test
        public void limitDoesNotDependOnTheRun() {
            // when
            final long first = limit.iterations(2, 6);
            final long second = limit.iterations(40, 400);

            // then
            Assertions.assertEquals(50L, first);
            Assertions.assertEquals(50L, second);
        }
    }

    @Nested
    @DisplayName("given a limit below one iteration")
    class BelowOne {
        private final IterationLimit limit = new QuadraticIterationLimit(0.0, 0.0);

        @Test
        public void runHasAtLeastOneIteration() {
            // when
            final long iterations = limit.iterations(5, 10);

            // then
            Assertions.assertEquals(1L, iterations);
        }
    }
}
