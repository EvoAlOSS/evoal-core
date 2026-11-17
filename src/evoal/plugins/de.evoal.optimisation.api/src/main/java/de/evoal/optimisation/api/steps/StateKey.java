package de.evoal.optimisation.api.steps;

/**
 * The key of a value in the strategy state ({@link SearchState#strategy}), e.g., the
 *   temperature or the velocities of the particles.
 *
 * @param name The name of the value.
 * @param type The type of the value.
 * @param <T> The type of the value.
 */
public record StateKey<T>(String name, Class<T> type) {
}
