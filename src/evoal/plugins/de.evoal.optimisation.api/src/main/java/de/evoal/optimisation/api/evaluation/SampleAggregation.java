package de.evoal.optimisation.api.evaluation;

import java.util.Arrays;

import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * How the samples of an objective are aggregated (DL enumeration {@code 'sample-aggregation'}).
 */
public enum SampleAggregation {
    /**
     * The arithmetic mean of the samples.
     */
    MEAN {
        @Override
        public double apply(final double[] samples) {
            double sum = 0.0;
            for(final double sample : samples) {
                sum += sample;
            }

            return sum / samples.length;
        }
    },

    /**
     * The middle sample; for an even number of samples, the mean of the two middle samples.
     */
    MEDIAN {
        @Override
        public double apply(final double[] samples) {
            final double[] sorted = samples.clone();
            Arrays.sort(sorted);

            final int middle = sorted.length / 2;
            if(sorted.length % 2 == 1) {
                return sorted[middle];
            }

            return (sorted[middle - 1] + sorted[middle]) / 2.0;
        }
    };

    /**
     * @param samples The samples of an objective, at least one.
     * @return The aggregate of the samples.
     */
    public abstract double apply(double[] samples);

    /**
     * @param literal A literal of the DL enumeration {@code 'sample-aggregation'}.
     * @return The corresponding aggregation.
     * @throws IllegalArgumentException if the literal is unknown.
     */
    public static SampleAggregation of(final EEnumLiteral literal) {
        final String name = literal.getName();

        return switch(name) {
            case "mean" -> MEAN;
            case "median" -> MEDIAN;
            default -> throw new IllegalArgumentException("Unknown sample aggregation '" + name + "'.");
        };
    }
}
