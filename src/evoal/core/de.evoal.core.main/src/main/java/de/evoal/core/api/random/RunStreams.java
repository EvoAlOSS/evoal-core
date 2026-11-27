package de.evoal.core.api.random;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.random.RandomGenerator;

import de.evoal.core.api.cdi.RunScoped;

/**
 * The named generators of a run ({@link RandomService#random(String)}). Every run starts
 *   without generators, so a name gets the beginning of its stream in every run.
 */
@RunScoped
public class RunStreams {
    /**
     * The generators of the run by name.
     */
    private final Map<String, RandomGenerator> generators = new ConcurrentHashMap<>();

    /**
     * @param name The name of the generator.
     * @param create Creates the generator on the first request of the name in the run.
     * @return The generator of the name in the run.
     */
    public RandomGenerator get(final String name, final Function<String, RandomGenerator> create) {
        return generators.computeIfAbsent(name, create);
    }
}
