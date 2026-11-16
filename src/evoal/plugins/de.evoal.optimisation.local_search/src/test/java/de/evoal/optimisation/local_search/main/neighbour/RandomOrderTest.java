package de.evoal.optimisation.local_search.main.neighbour;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;

public class RandomOrderTest {
    private static RandomGenerator generator(final long seed) {
        return RandomService.withSeed(seed).random("random-order-test");
    }

    @Nested
    @DisplayName("given ten numbers")
    class TenNumbers {
        private static final int SIZE = 10;

        @Test
        public void everyNumberIsDrawnExactlyOnce() {
            // when
            final List<Integer> order = RandomOrder.of(SIZE, generator(42)).boxed().toList();

            // then
            final List<Integer> sorted = order.stream().sorted().toList();
            Assertions.assertEquals(IntStream.range(0, SIZE).boxed().toList(), sorted);
        }

        @Test
        public void theSameSeedGivesTheSameOrder() {
            // when
            final List<Integer> first = RandomOrder.of(SIZE, generator(42)).boxed().toList();
            final List<Integer> second = RandomOrder.of(SIZE, generator(42)).boxed().toList();

            // then
            Assertions.assertEquals(first, second);
        }

        @Test
        public void theOrderIsNotAlwaysTheSame() {
            // given
            final RandomGenerator random = generator(42);

            // when
            final List<Integer> first = RandomOrder.of(SIZE, random).boxed().toList();
            final List<Integer> second = RandomOrder.of(SIZE, random).boxed().toList();

            // then
            Assertions.assertNotEquals(first, second);
        }
    }

    @Nested
    @DisplayName("given more numbers than fit into memory as a list")
    class ManyNumbers {
        @Test
        public void theFirstNumbersCanBeDrawnLazily() {
            // when
            final List<Integer> first = RandomOrder.of(Integer.MAX_VALUE, generator(42)).limit(1000).boxed().toList();

            // then
            Assertions.assertEquals(1000, first.stream().distinct().count());
            Assertions.assertTrue(first.stream().allMatch(number -> number >= 0));
        }
    }

    @Nested
    @DisplayName("given no numbers")
    class NoNumbers {
        @Test
        public void theOrderIsEmpty() {
            // when
            final long count = RandomOrder.of(0, generator(42)).count();

            // then
            Assertions.assertEquals(0, count);
        }
    }
}
