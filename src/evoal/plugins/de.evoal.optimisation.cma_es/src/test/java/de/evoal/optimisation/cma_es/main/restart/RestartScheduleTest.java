package de.evoal.optimisation.cma_es.main.restart;

import java.util.Optional;
import java.util.SplittableRandom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RestartScheduleTest {
    @Nested
    @DisplayName("given IPOP with factor 2 and at most 2 restarts")
    class Ipop {
        private final RestartSchedule schedule = new IpopRestart(2.0, 2).schedule(10);

        @Test
        public void populationDoublesUntilTheLimit() {
            // when
            final RunSetting first = schedule.first();
            final Optional<RunSetting> second = schedule.next(1000, new SplittableRandom(1));
            final Optional<RunSetting> third = schedule.next(1000, new SplittableRandom(1));
            final Optional<RunSetting> fourth = schedule.next(1000, new SplittableRandom(1));

            // then
            Assertions.assertEquals(10, first.populationSize());
            Assertions.assertEquals(20, second.orElseThrow().populationSize());
            Assertions.assertEquals(40, third.orElseThrow().populationSize());
            Assertions.assertEquals(1.0, third.orElseThrow().stepSizeFactor());
            Assertions.assertTrue(fourth.isEmpty());
        }
    }

    @Nested
    @DisplayName("given BIPOP with factor 2")
    class Bipop {
        private final RestartSchedule schedule = new BipopRestart(2.0, 9).schedule(10);

        @Test
        public void firstRestartIsLargeAndThenSmallRestartsFollowWhileTheyUseLessBudget() {
            // given
            final SplittableRandom random = new SplittableRandom(3);

            // when: the first run (small budget) used 1000 evaluations
            final RunSetting large = schedule.next(1000, random).orElseThrow();
            // the large run used 4000 evaluations, so small runs follow until they used 4000
            final RunSetting small = schedule.next(4000, random).orElseThrow();
            final RunSetting nextSmall = schedule.next(2000, random).orElseThrow();
            final RunSetting nextLarge = schedule.next(2000, random).orElseThrow();

            // then
            Assertions.assertEquals("large", large.regime());
            Assertions.assertEquals(20, large.populationSize());
            Assertions.assertEquals("small", small.regime());
            Assertions.assertTrue(small.populationSize() >= 10 && small.populationSize() <= 40, "lambda " + small);
            Assertions.assertTrue(small.stepSizeFactor() > 0.01 && small.stepSizeFactor() <= 1.0, "sigma " + small);
            Assertions.assertTrue(small.maximumIterations() <= (long) Math.ceil(0.5 * 4000 / small.populationSize()));
            Assertions.assertEquals("small", nextSmall.regime());
            Assertions.assertEquals("large", nextLarge.regime());
            Assertions.assertEquals(40, nextLarge.populationSize());
        }
    }

    @Nested
    @DisplayName("given a run setting with an iteration limit of 100")
    class LimitedSetting {
        private final RunSetting setting = new RunSetting(10, 0.5, 100L, "small");

        @Test
        public void aSmallerFurtherLimitWins() {
            // when
            final RunSetting limited = setting.limitedTo(40L);

            // then
            Assertions.assertEquals(40L, limited.maximumIterations());
            Assertions.assertEquals(10, limited.populationSize());
            Assertions.assertEquals(0.5, limited.stepSizeFactor());
            Assertions.assertEquals("small", limited.regime());
        }

        @Test
        public void aLargerFurtherLimitKeepsTheOwnOne() {
            // when
            final RunSetting limited = setting.limitedTo(1000L);

            // then
            Assertions.assertEquals(100L, limited.maximumIterations());
        }

        @Test
        public void noFurtherLimitKeepsTheOwnOne() {
            // when
            final RunSetting limited = setting.limitedTo(Long.MAX_VALUE);

            // then
            Assertions.assertEquals(100L, limited.maximumIterations());
        }
    }
}
