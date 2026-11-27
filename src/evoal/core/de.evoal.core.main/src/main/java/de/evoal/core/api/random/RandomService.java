package de.evoal.core.api.random;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ScopeControl;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Central source of random numbers. All random numbers of EvoAl have to be drawn from
 *   generators of this service, so that runs can be repeated.
 *
 * <h2>Seed</h2>
 * The seed is read from the blackboard entry {@link CoreBlackboardEntries#SEED}
 *   ({@code -Bcore:seed=...}; the start scripts pass the environment variable
 *   {@code EVOAL_SEED}). Without a seed, a random seed is chosen. The seed is logged in
 *   both cases, so every run can be repeated afterwards.
 *
 * <h2>Named streams</h2>
 * Each component requests its own generator ({@link #random(String)}), e.g., using its
 *   CDI name. The generator is derived from the seed, the current run, and the name only.
 *   Therefore, additional random numbers drawn by one component do not change the random
 *   numbers of the other components.
 *
 * <h2>Runs</h2>
 * Within a run ({@link ScopeControl#inRun}), the generators are derived from the number of
 *   the run and belong to the run ({@link RunStreams}): each run gets different, but
 *   reproducible, random numbers, and a run gets the same numbers whether it is executed
 *   alone or after other runs. Outside a run, e.g., in applications without runs, the
 *   generators are derived from run 0 and belong to the application.
 *
 * <h2>Task streams</h2>
 * Random numbers drawn during an evaluation (e.g., by a random or noisy optimisation
 *   function) come from {@link #taskRandom(String)}. Its generator is derived from the
 *   seed, the run, the name, and the index of the evaluation ({@link EvaluationTask}).
 *   Therefore, the values of an evaluation depend neither on the evaluations before it nor
 *   on the thread that computes it.
 *
 * <h2>Which stream to use</h2>
 * <ul>
 *   <li>Decisions of the algorithm (initial candidates, mutations, neighbour order,
 *     acceptance) use a named component stream ({@link #random(String)}). The algorithm
 *     makes them on its own thread in a fixed order.</li>
 *   <li>Everything drawn while a candidate is evaluated uses a task stream
 *     ({@link #taskRandom(String)}), since evaluations may run in parallel.</li>
 * </ul>
 *
 * <h2>Threads</h2>
 * The generators are not thread-safe. A generator must only be used by one thread at a
 *   time. Parallel code requests one generator per processed entity (e.g., per particle or
 *   per evaluation), which also keeps the results independent of the thread scheduling.
 */
@ApplicationScoped
@Slf4j
public class RandomService {
    @Inject
    private Blackboard board;

    /**
     * The open scopes, {@code null} for a service with a fixed seed.
     */
    @Inject
    private ScopeControl scopes;

    /**
     * The generators of the current run, {@code null} for a service with a fixed seed.
     */
    @Inject
    private RunStreams runStreams;

    /**
     * The generator algorithm. Its output is specified, i.e., independent of the JDK version.
     */
    private static final RandomGeneratorFactory<RandomGenerator> FACTORY = RandomGeneratorFactory.of("L64X128MixRandom");

    /**
     * The seed of the whole execution.
     */
    private long seed;

    /**
     * The generators outside a run.
     */
    private final Map<String, RandomGenerator> generators = new ConcurrentHashMap<>();

    /**
     * Creates a service. The seed is read in {@link #initialise()}.
     */
    public RandomService() {
    }

    /**
     * Creates a service with a fixed seed and without runs, e.g., for testing.
     */
    public static RandomService withSeed(final long seed) {
        final RandomService service = new RandomService();
        service.seed = seed;
        return service;
    }

    @PostConstruct
    void initialise() {
        final Object configured = board.getOrNull(CoreBlackboardEntries.SEED);

        if(configured == null || configured.toString().isBlank()) {
            seed = new SecureRandom().nextLong();
            log.info("Using random seed {}. Pass -B{}={} (or set EVOAL_SEED={}) to repeat the execution.", seed, CoreBlackboardEntries.SEED, seed, seed);

            // make the chosen seed available, e.g., for writing it to the results
            board.bind(CoreBlackboardEntries.SEED, Long.toString(seed));
        } else {
            try {
                seed = configured instanceof Number number ? number.longValue() : Long.parseLong(configured.toString().trim());
            } catch(final NumberFormatException e) {
                throw new IllegalArgumentException("The value of " + CoreBlackboardEntries.SEED + " is not a number: " + configured, e);
            }
            log.info("Using seed {} of {}.", seed, CoreBlackboardEntries.SEED);
        }
    }

    /**
     * @return The seed of the whole execution.
     */
    public long getSeed() {
        return seed;
    }

    /**
     * @return The number of the current run, 0 outside a run.
     */
    public long getRun() {
        return isInRun() ? scopes.runNumber() : 0;
    }

    /**
     * Returns the generator for the given name. Within a run, the same name always returns
     *   the same generator instance; outside a run, the application always gets the same one.
     *
     * @param name A stable name, e.g., the CDI name of the component, optionally followed by a key
     *   such as {@code "/particle-3"}.
     */
    public RandomGenerator random(final @NonNull String name) {
        if(isInRun()) {
            final long run = scopes.runNumber();
            return runStreams.get(name, n -> FACTORY.create(derive(seed, run, n)));
        }

        return generators.computeIfAbsent(name, n -> FACTORY.create(derive(seed, 0, n)));
    }

    /**
     * Returns a new generator for the given name and the current evaluation
     *   ({@link EvaluationTask#current()}). The generator is not cached: each call returns a
     *   new generator that starts at the beginning of the stream, so a component calls it
     *   once per evaluation and draws all its values from the returned generator.
     *
     * @param name A stable name, e.g., the CDI name of the component.
     * @throws IllegalStateException if the current thread does not evaluate a candidate.
     */
    public RandomGenerator taskRandom(final @NonNull String name) {
        final EvaluationTask task = EvaluationTask.current()
                                                  .orElseThrow(() -> new IllegalStateException("The task stream '" + name + "' is only available during an evaluation."));

        return FACTORY.create(deriveTask(seed, task.run(), name, task.index()));
    }

    /**
     * Returns the seed for the given name, e.g., for libraries that need a seed instead of a generator.
     */
    public long seedFor(final @NonNull String name) {
        return derive(seed, getRun(), name);
    }

    /**
     * @return {@code true} iff a run is open for the current code.
     */
    private boolean isInRun() {
        return scopes != null && scopes.isRunActive();
    }

    /**
     * Derives the seed of a named generator from the execution's seed and the run.
     */
    static long derive(final long seed, final long run, final String name) {
        return mix(mix(mix(seed) ^ run) ^ hash(name));
    }

    /**
     * Derives the seed of a task generator from the seed of the named generator and the index
     *   of the evaluation. The extra mixing step separates the task streams from the named
     *   stream of the same name.
     */
    static long deriveTask(final long seed, final long run, final String name, final long index) {
        return mix(mix(derive(seed, run, name)) ^ index);
    }

    /**
     * Finalisation function of SplitMix64, spreads the bits of the value.
     */
    private static long mix(long z) {
        z = (z ^ (z >>> 30)) * 0xbf58476d1ce4e5b9L;
        z = (z ^ (z >>> 27)) * 0x94d049bb133111ebL;
        return z ^ (z >>> 31);
    }

    /**
     * 64-bit FNV-1a hash of the UTF-8 encoded name. Unlike {@link String#hashCode()}, it uses all 64 bits.
     */
    private static long hash(final String name) {
        long hash = 0xcbf29ce484222325L;
        for(final byte b : name.getBytes(StandardCharsets.UTF_8)) {
            hash ^= (b & 0xff);
            hash *= 0x100000001b3L;
        }
        return hash;
    }
}
