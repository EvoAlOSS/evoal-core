package de.evoal.optimisation.pso.main.mover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InertiaScheduleTest {
    private static final double DELTA = 1e-12;

    @Nested
    @DisplayName("given a schedule from 0.9 to 0.4 within 10 iterations")
    class TenIterations {
        private final InertiaSchedule schedule = new InertiaSchedule(0.9, 0.4, 10);

        @Test
        public void theWeightDecreasesLinearly() {
            // when
            final double weight = schedule.weight(5);

            // then
            Assertions.assertEquals(0.65, weight, DELTA);
        }

        @Test
        public void theLastIterationReachesTheEnd() {
            // when
            final double weight = schedule.weight(10);

            // then
            Assertions.assertEquals(0.4, weight, DELTA);
        }

        @Test
        public void theWeightStaysAtTheEndAfterwards() {
            // when
            final double weight = schedule.weight(100);

            // then
            Assertions.assertEquals(0.4, weight, DELTA);
        }
    }

    @Nested
    @DisplayName("given no iterations")
    class NoIterations {
        @Test
        public void theScheduleIsRejected() {
            // when, then
            Assertions.assertThrows(IllegalArgumentException.class, () -> new InertiaSchedule(0.9, 0.4, 0));
        }
    }
}
