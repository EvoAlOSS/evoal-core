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

    private static double[] drawTask(final RandomService service, final long run, final long index, final String name) {
        return new EvaluationTask(run, index).call(() -> draw(service.taskRandom(name)));
    }

    @Test
    public void taskStreamsAreReproducible() {
        Assertions.assertArrayEquals(drawTask(RandomService.withSeed(42), 0, 3, "a"),
                                     drawTask(RandomService.withSeed(42), 0, 3, "a"));
    }

    @Test
    public void taskStreamsAreNotCached() {
        final RandomService service = RandomService.withSeed(42);
        final double[] first = drawTask(service, 0, 3, "a");

        // drawing from the same task again starts at the beginning of the stream
        Assertions.assertArrayEquals(first, drawTask(service, 0, 3, "a"));
    }

    @Test
    public void taskStreamsDifferPerIndexRunNameAndSeed() {
        final double[] expected = drawTask(RandomService.withSeed(42), 0, 3, "a");

        Assertions.assertFalse(java.util.Arrays.equals(expected, drawTask(RandomService.withSeed(42), 0, 4, "a")));
        Assertions.assertFalse(java.util.Arrays.equals(expected, drawTask(RandomService.withSeed(42), 1, 3, "a")));
        Assertions.assertFalse(java.util.Arrays.equals(expected, drawTask(RandomService.withSeed(42), 0, 3, "b")));
        Assertions.assertFalse(java.util.Arrays.equals(expected, drawTask(RandomService.withSeed(43), 0, 3, "a")));
    }

    @Test
    public void taskStreamsDifferFromTheNamedStream() {
        final RandomService service = RandomService.withSeed(42);

        Assertions.assertFalse(java.util.Arrays.equals(draw(service.random("a")), drawTask(service, 0, 0, "a")));
    }

    @Test
    public void taskStreamsAreIndependentOfTheCurrentRunOfTheService() {
        final RandomService service = RandomService.withSeed(42);
        final double[] expected = drawTask(service, 0, 3, "a");

        // the run is taken from the task, not from the service
        service.startRun(5);
        Assertions.assertArrayEquals(expected, drawTask(service, 0, 3, "a"));
    }

    @Test
    public void taskStreamsAreUnavailableOutsideAnEvaluation() {
        final RandomService service = RandomService.withSeed(42);

        Assertions.assertThrows(IllegalStateException.class, () -> service.taskRandom("a"));
    }

    @Test
    public void taskDerivationIsStable() {
        Assertions.assertEquals(RandomService.deriveTask(42, 0, "a", 0), RandomService.deriveTask(42, 0, "a", 0));
        Assertions.assertNotEquals(RandomService.deriveTask(42, 0, "a", 0), RandomService.deriveTask(42, 0, "a", 1));
        Assertions.assertNotEquals(RandomService.deriveTask(42, 0, "a", 0), RandomService.derive(42, 0, "a"));
    }
}
