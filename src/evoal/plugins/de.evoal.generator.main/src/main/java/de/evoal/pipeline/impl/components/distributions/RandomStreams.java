package de.evoal.pipeline.impl.components.distributions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.random.RandomService;

/**
 * Provides the random streams of the distributions.
 * <p>
 * Each distribution instance draws from its own named stream of the {@link RandomService},
 *   so that two distributions with the same parameters draw different numbers. The name
 *   consists of the CDI name of the distribution and the number of the instance, counted
 *   per CDI name in creation order, e.g., {@code ...normal-distribution/1} for the second
 *   normal distribution. The pipelines create their distributions in a fixed order, so
 *   the names are the same in every execution of the same configuration.
 * <p>
 * The names cannot be derived from the configuration of a distribution: the configurations
 *   are created when the expressions of the generator file are evaluated and are not
 *   contained in a model, so they have no position that tells them apart.
 */
@ApplicationScoped
@Slf4j
public class RandomStreams {
    /**
     * The number of instances created so far, per CDI name of a distribution.
     */
    private final Map<String, AtomicLong> numberOfInstances = new ConcurrentHashMap<>();

    @Inject
    private RandomService randomService;

    /**
     * Creates the bean. The random service is injected.
     */
    public RandomStreams() {
    }

    /**
     * Creates the streams of the given random service, e.g., for testing.
     */
    static RandomStreams of(final @NonNull RandomService randomService) {
        final RandomStreams streams = new RandomStreams();
        streams.randomService = randomService;

        return streams;
    }

    /**
     * Returns the random stream of a new distribution instance.
     *
     * @param distributionName The CDI name of the distribution.
     */
    public RandomGenerator forNewInstance(final @NonNull String distributionName) {
        final long instance = numberOfInstances.computeIfAbsent(distributionName, name -> new AtomicLong())
                                               .getAndIncrement();
        final String streamName = distributionName + "/" + instance;
        log.debug("Using the random stream {}.", streamName);

        return randomService.random(streamName);
    }
}
