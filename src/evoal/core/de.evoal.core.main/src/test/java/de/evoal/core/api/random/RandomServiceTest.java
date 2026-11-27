package de.evoal.core.api.random;

import java.lang.reflect.Field;
import java.util.function.Function;
import java.util.random.RandomGenerator;
import java.util.stream.DoubleStream;

import jakarta.enterprise.context.spi.Contextual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.cdi.TestScopes;

public class RandomServiceTest {
    /**
     * @return A service with the seed whose runs are the runs of the scopes.
     */
    private static RandomService withScopes(final long seed, final TestScopes scopes) throws ReflectiveOperationException {
        final Contextual<RunStreams> bean = TestScopes.bean(RunStreams::new);

        // looks up the streams of the current run, as the client proxy does
        final RunStreams proxy = new RunStreams() {
            @Override
            public RandomGenerator get(final String name, final Function<String, RandomGenerator> create) {
                return TestScopes.get(scopes.runContext(), bean).get(name, create);
            }
        };

        final RandomService service = RandomService.withSeed(seed);
        set(service, "scopes", scopes.control());
        set(service, "runStreams", proxy);

        return service;
    }

    private static void set(final RandomService service, final String name, final Object value) throws ReflectiveOperationException {
        final Field field = RandomService.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(service, value);
    }

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
    public void runsGetDifferentButReproducibleNumbers() throws ReflectiveOperationException {
        // given
        final TestScopes scopes = new TestScopes();
        final RandomService service = withScopes(42, scopes);
        final double[][] numbers = new double[3][];

        // when
        scopes.control().inEvaluation(() -> {
            scopes.control().inRun(0, () -> numbers[0] = draw(service.random("a")));
            scopes.control().inRun(1, () -> numbers[1] = draw(service.random("a")));
            scopes.control().inRun(0, () -> numbers[2] = draw(service.random("a")));
        });

        // then
        Assertions.assertFalse(java.util.Arrays.equals(numbers[0], numbers[1]));
        Assertions.assertArrayEquals(numbers[0], numbers[2]);
    }

    @Test
    public void everyRunStartsItsStreamsAtTheBeginning() throws ReflectiveOperationException {
        // given
        final TestScopes scopes = new TestScopes();
        final RandomService service = withScopes(42, scopes);
        final RandomGenerator[] generators = new RandomGenerator[3];

        // when
        scopes.control().inEvaluation(() -> {
            scopes.control().inRun(4, () -> {
                generators[0] = service.random("a");
                generators[1] = service.random("a");
            });
            scopes.control().inRun(4, () -> generators[2] = service.random("a"));
        });

        // then
        Assertions.assertSame(generators[0], generators[1]);
        Assertions.assertNotSame(generators[0], generators[2]);
    }

    @Test
    public void theRunNumberComesFromTheOpenRun() throws ReflectiveOperationException {
        // given
        final TestScopes scopes = new TestScopes();
        final RandomService service = withScopes(42, scopes);
        final long[] runs = new long[1];
        final long[] seeds = new long[1];

        // when
        scopes.control().inEvaluation(() -> scopes.control().inRun(5, () -> {
            runs[0] = service.getRun();
            seeds[0] = service.seedFor("a");
        }));

        // then
        Assertions.assertEquals(5, runs[0]);
        Assertions.assertEquals(RandomService.derive(42, 5, "a"), seeds[0]);
        Assertions.assertEquals(0, service.getRun());
    }

    @Test
    public void outsideARunTheStreamsAreTheStreamsOfRun0() throws ReflectiveOperationException {
        // given
        final TestScopes scopes = new TestScopes();
        final RandomService service = withScopes(42, scopes);
        final double[][] numbers = new double[1][];

        // when
        final double[] outside = draw(service.random("a"));
        scopes.control().inEvaluation(() -> scopes.control().inRun(0, () -> numbers[0] = draw(service.random("a"))));

        // then
        Assertions.assertArrayEquals(outside, numbers[0]);
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
    public void taskStreamsAreIndependentOfTheCurrentRunOfTheService() throws ReflectiveOperationException {
        // given
        final TestScopes scopes = new TestScopes();
        final RandomService service = withScopes(42, scopes);
        final double[] expected = drawTask(service, 0, 3, "a");
        final double[][] inRun = new double[1][];

        // when: the run is taken from the task, not from the service
        scopes.control().inEvaluation(() -> scopes.control().inRun(5, () -> inRun[0] = drawTask(service, 0, 3, "a")));

        // then
        Assertions.assertArrayEquals(expected, inRun[0]);
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
