package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;

public class RandomStreamsTest {
    private static final String NAME = "test-distribution";

    private static final String OTHER_NAME = "other-test-distribution";

    private static RandomStreams streams(final long seed) {
        return RandomStreams.of(RandomService.withSeed(seed));
    }

    @Nested
    @DisplayName("given two instances of the same distribution")
    class TwoInstances {
        @Test
        public void theInstancesDrawDifferentNumbers() {
            // given
            final RandomStreams streams = streams(42);

            // when
            final RandomGenerator first = streams.forNewInstance(NAME);
            final RandomGenerator second = streams.forNewInstance(NAME);

            // then
            Assertions.assertNotEquals(first.nextLong(), second.nextLong());
        }

        @Test
        public void theSameSeedGivesTheSameNumbers() {
            // given
            final RandomStreams firstExecution = streams(42);
            final RandomStreams secondExecution = streams(42);

            // when
            firstExecution.forNewInstance(NAME);
            secondExecution.forNewInstance(NAME);
            final long first = firstExecution.forNewInstance(NAME).nextLong();
            final long second = secondExecution.forNewInstance(NAME).nextLong();

            // then
            Assertions.assertEquals(first, second);
        }

        @Test
        public void differentSeedsGiveDifferentNumbers() {
            // when
            final long first = streams(42).forNewInstance(NAME).nextLong();
            final long second = streams(43).forNewInstance(NAME).nextLong();

            // then
            Assertions.assertNotEquals(first, second);
        }
    }

    @Nested
    @DisplayName("given instances of different distributions")
    class DifferentDistributions {
        @Test
        public void anInstanceOfAnotherDistributionDoesNotChangeTheNumbers() {
            // given
            final RandomStreams withOther = streams(42);
            final RandomStreams withoutOther = streams(42);

            // when
            withOther.forNewInstance(OTHER_NAME);
            final long first = withOther.forNewInstance(NAME).nextLong();
            final long second = withoutOther.forNewInstance(NAME).nextLong();

            // then
            Assertions.assertEquals(first, second);
        }
    }
}
