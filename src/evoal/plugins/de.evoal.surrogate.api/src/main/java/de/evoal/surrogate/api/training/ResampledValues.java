package de.evoal.surrogate.api.training;

import lombok.NonNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The values of a goodness-of-fit measure on the parts of a resampling scheme and their
 *   summary: the value of a scheme's data set in {@link GoodnessOfFit}.
 *
 * @param mean The mean of the values.
 * @param standardDeviation The sample standard deviation of the values (divided by m - 1 for
 *   m values), 0 for a single value.
 * @param values The values of the parts, in the order of the parts.
 */
public record ResampledValues(double mean, double standardDeviation, @NonNull List<Double> values) {
    /**
     * The keys of {@link #asMap()}.
     */
    public static final String MEAN = "mean";
    public static final String STANDARD_DEVIATION = "standard-deviation";
    public static final String VALUES = "values";

    public ResampledValues {
        values = List.copyOf(values);
    }

    /**
     * Summarises the values of the parts.
     *
     * @param values The values, at least one.
     * @return The mean, the standard deviation and the values.
     * @throws IllegalArgumentException if there is no value.
     */
    public static ResampledValues of(final @NonNull List<Double> values) {
        if(values.isEmpty()) {
            throw new IllegalArgumentException("A resampled value needs at least one value.");
        }

        final double mean = values.stream()
                                  .mapToDouble(Double::doubleValue)
                                  .sum() / values.size();

        if(values.size() == 1) {
            return new ResampledValues(mean, 0.0, values);
        }

        final double squares = values.stream()
                                     .mapToDouble(v -> (v - mean) * (v - mean))
                                     .sum();

        return new ResampledValues(mean, Math.sqrt(squares / (values.size() - 1)), values);
    }

    /**
     * @return {@code mean}, {@code standard-deviation} and {@code values} (as {@code double[]}),
     *   the form in which the model file and the goodness-of-fit file store them.
     */
    public Map<String, Object> asMap() {
        final Map<String, Object> result = new LinkedHashMap<>();
        result.put(MEAN, mean);
        result.put(STANDARD_DEVIATION, standardDeviation);
        result.put(VALUES, values.stream().mapToDouble(Double::doubleValue).toArray());

        return result;
    }
}
