package de.evoal.optimisation.api.builder;

import lombok.NonNull;

/**
 * The settings of the random builder of model candidates ({@code 'random-population'} with its
 *   {@code method}).
 *
 * @param method The method that gives every candidate its shape and depth limit.
 * @param maximumSize The largest number of objects of a model; {@link #NO_SIZE_LIMIT} for none.
 * @param optionalProbability The probability that an optional feature gets a value;
 *   {@code null} if it was not given (allowed only for models without optional features).
 */
public record BuildSettings(@NonNull TreeMethod method, long maximumSize, Double optionalProbability) {
    /**
     * The size limit of a builder without {@code 'maximum-size'}.
     */
    public static final long NO_SIZE_LIMIT = Long.MAX_VALUE / 4;
}
