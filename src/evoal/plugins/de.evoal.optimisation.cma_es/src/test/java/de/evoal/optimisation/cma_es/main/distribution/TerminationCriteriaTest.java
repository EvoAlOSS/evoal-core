package de.evoal.optimisation.cma_es.main.distribution;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TerminationCriteriaTest {
    private static final int DIMENSION = 2;

    private static Distribution distribution(final double stepSize) {
        final StrategyParameters parameters = StrategyParameters.defaults(DIMENSION, 6, 3);

        return new Distribution(parameters, CovarianceModel.full(DIMENSION, 1), new double[] {1.0, 1.0}, stepSize);
    }

    private static RunHistory history(final int iterations, final double value) {
        final RunHistory history = new RunHistory();
        for(int i = 0; i < iterations; ++i) {
            history.record(new double[] {value, value + 1.0e-14, value + 2.0e-14});
        }

        return history;
    }

    @Nested
    @DisplayName("given a fresh distribution")
    class FreshDistribution {
        @Test
        public void noCriterionHolds() {
            // when
            final Optional<String> criterion = TerminationCriteria.DEFAULTS.check(distribution(0.5), new RunHistory(), 0.5);

            // then
            Assertions.assertEquals(Optional.empty(), criterion);
        }
    }

    @Nested
    @DisplayName("given a step size below the numerical resolution of the mean")
    class TinyStepSize {
        @Test
        public void noEffectAxisHolds() {
            // when
            final Optional<String> criterion = TerminationCriteria.DEFAULTS.check(distribution(1.0e-20), new RunHistory(), 0.5);

            // then
            Assertions.assertEquals(Optional.of("no-effect-axis"), criterion);
        }
    }

    @Nested
    @DisplayName("given a step size that grew by more than 1e4")
    class GrowingStepSize {
        @Test
        public void tolXUpHolds() {
            // when
            final Optional<String> criterion = TerminationCriteria.DEFAULTS.check(distribution(2.0e4), new RunHistory(), 1.0);

            // then
            Assertions.assertEquals(Optional.of("tol-x-up"), criterion);
        }
    }

    @Nested
    @DisplayName("given values that no longer change")
    class FlatValues {
        @Test
        public void tolFunHoldsAfterTheHistoryLength() {
            // given: L = 10 + ceil(30 * 2 / 6) = 20
            final TerminationCriteria criteria = new TerminationCriteria(1.0e-12, 0.0, 1.0e4, 1.0e14, false, false, false,
                                                                         false);

            // when
            final Optional<String> early = criteria.check(distribution(0.5), history(19, 3.0), 0.5);
            final Optional<String> late = criteria.check(distribution(0.5), history(20, 3.0), 0.5);

            // then
            Assertions.assertEquals(Optional.empty(), early);
            Assertions.assertEquals(Optional.of("tol-fun"), late);
        }

        @Test
        public void equalFunValuesHoldsForEqualBestValues() {
            // given
            final TerminationCriteria criteria = new TerminationCriteria(0.0, 0.0, 1.0e4, 1.0e14, false, false, true, false);

            // when
            final Optional<String> criterion = criteria.check(distribution(0.5), history(20, 3.0), 0.5);

            // then
            Assertions.assertEquals(Optional.of("equal-fun-values"), criterion);
        }

        @Test
        public void stagnationHoldsWhenTheMediansDoNotImprove() {
            // given: at least 120 + 30 * 2 / 6 = 130 iterations
            final TerminationCriteria criteria = new TerminationCriteria(0.0, 0.0, 1.0e4, 1.0e14, false, false, false, true);
            final RunHistory improving = new RunHistory();
            for(int i = 0; i < 130; ++i) {
                improving.record(new double[] {100.0 - i, 101.0 - i});
            }

            // when
            final Optional<String> stagnating = criteria.check(distribution(0.5), history(130, 3.0), 0.5);
            final Optional<String> progressing = criteria.check(distribution(0.5), improving, 0.5);

            // then
            Assertions.assertEquals(Optional.of("stagnation"), stagnating);
            Assertions.assertEquals(Optional.empty(), progressing);
        }
    }

    @Nested
    @DisplayName("given a run history")
    class History {
        @Test
        public void historyKeepsBestAndMedianValues() {
            // given
            final RunHistory history = new RunHistory();

            // when
            history.record(new double[] {3.0, 1.0, 2.0, 4.0});

            // then
            Assertions.assertEquals(List.of(1.0), history.bestValues());
            Assertions.assertEquals(List.of(2.5), history.medianValues());
        }
    }
}
