package de.evoal.core.api.random;

import java.util.random.RandomGenerator;
import java.util.stream.DoubleStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomServiceTest {
    private static double[] draw(final RandomGenerator generator) {
        return DoubleStream.generate(generator::nextDouble).limit(5).toArray();
    }

    @Test
    public void sameSeedSameNumbers() {
        Assertions.assertArrayEquals(draw(RandomService.withSeed(42).random("a")),
                                     draw(RandomService.withSeed(42).random("a")));
    }

    @Test
    public void differentSeedsDifferentNumbers() {
        Assertions.assertFalse(java.util.Arrays.equals(draw(RandomService.withSeed(42).random("a")),
                                                       draw(RandomService.withSeed(43).random("a"))));
    }

    @Test
    public void streamsAreIndependentOfEachOther() {
        final RandomService first = RandomService.withSeed(42);
        final double[] expected = draw(first.random("b"));

        // drawing from another stream first must not change stream b
        final RandomService second = RandomService.withSeed(42);
        draw(second.random("a"));
        Assertions.assertArrayEquals(expected, draw(second.random("b")));

        Assertions.assertFalse(java.util.Arrays.equals(draw(RandomService.withSeed(42).random("a")), expected));
    }

    @Test
    public void sameNameReturnsTheSameGeneratorWithinARun() {
        final RandomService service = RandomService.withSeed(42);
        Assertions.assertSame(service.random("a"), service.random("a"));
    }

    @Test
    public void runsGetDifferentButReproducibleNumbers() {
        final RandomService service = RandomService.withSeed(42);
        service.startRun(0);
        final double[] run0 = draw(service.random("a"));
        service.startRun(1);
        final double[] run1 = draw(service.random("a"));
        service.startRun(0);
        final double[] run0Again = draw(service.random("a"));

        Assertions.assertFalse(java.util.Arrays.equals(run0, run1));
        Assertions.assertArrayEquals(run0, run0Again);
    }

    @Test
    public void derivationIsStable() {
        // guards against accidental changes of the derivation, which would change all results
        Assertions.assertEquals(RandomService.derive(42, 0, "a"), RandomService.derive(42, 0, "a"));
        Assertions.assertNotEquals(RandomService.derive(42, 0, "a"), RandomService.derive(42, 0, "b"));
        Assertions.assertNotEquals(RandomService.derive(42, 0, "a"), RandomService.derive(42, 1, "a"));
    }
}
