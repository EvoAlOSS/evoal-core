package de.evoal.surrogate.api.training;

import lombok.NonNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

/**
 * The values of a goodness-of-fit measure on the parts of a resampling scheme and their
 *   summary: the value of a scheme's data set in {@link GoodnessOfFit}.
 *
 * @param mean The mean of the values, empty if no part has a value.
 * @param standardDeviation The sample standard deviation of the values (divided by m - 1 for
 *   m values), 0 for a single value, empty if no part has a value.
 * @param values The values of the parts on which the measure is defined, in the order of the
 *   parts.
 * @param pooled The measure on the held-out rows of all parts together, each with the
 *   prediction of its part's model; empty if the measure is undefined on them.
 */
public record ResampledValues(@NonNull OptionalDouble mean, @NonNull OptionalDouble standardDeviation, @NonNull List<Double> values,
                              @NonNull OptionalDouble pooled) {
    /**
     * The keys of {@link #asMap()}.
     */
    public static final String MEAN = "mean";
    public static final String STANDARD_DEVIATION = "standard-deviation";
    public static final String POOLED = "pooled";
    public static final String VALUES = "values";

    public ResampledValues {
        values = List.copyOf(values);
    }

    /**
     * Summarises the values of the parts.
     *
     * @param values The values of the parts on which the measure is defined.
     * @param pooled The value on the held-out rows of all parts, if defined.
     * @return The mean, the standard deviation, the values and the pooled value.
     * @throws IllegalArgumentException if there is neither a value nor a pooled value.
     */
    public static ResampledValues of(final @NonNull List<Double> values, final @NonNull OptionalDouble pooled) {
        if(values.isEmpty() && pooled.isEmpty()) {
            throw new IllegalArgumentException("A resampled value needs at least one value or a pooled value.");
        }

        if(values.isEmpty()) {
            return new ResampledValues(OptionalDouble.empty(), OptionalDouble.empty(), values, pooled);
        }

        final double mean = values.stream()
                                  .mapToDouble(Double::doubleValue)
                                  .sum() / values.size();

        if(values.size() == 1) {
            return new ResampledValues(OptionalDouble.of(mean), OptionalDouble.of(0.0), values, pooled);
        }

        final double squares = values.stream()
                                     .mapToDouble(v -> (v - mean) * (v - mean))
                                     .sum();

        return new ResampledValues(OptionalDouble.of(mean), OptionalDouble.of(Math.sqrt(squares / (values.size() - 1))), values, pooled);
    }

    /**
     * @return {@code mean} and {@code standard-deviation} (if a part has a value),
     *   {@code pooled} (if defined) and {@code values} (as {@code double[]}, maybe empty), the
     *   form in which the model file and the goodness-of-fit file store them.
     */
    public Map<String, Object> asMap() {
        final Map<String, Object> result = new LinkedHashMap<>();
        mean.ifPresent(value -> result.put(MEAN, value));
        standardDeviation.ifPresent(value -> result.put(STANDARD_DEVIATION, value));
        pooled.ifPresent(value -> result.put(POOLED, value));
        result.put(VALUES, values.stream().mapToDouble(Double::doubleValue).toArray());

        return result;
    }
}
