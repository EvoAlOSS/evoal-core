package de.evoal.optimisation.gp.main;

import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * The error measures of the DL enumeration {@code 'regression-error'}.
 */
public enum RegressionError {
    /**
     * The sum of the squared errors divided by the number of rows.
     */
    MEAN_SQUARED_ERROR("mean-squared-error"),

    /**
     * The sum of the absolute errors.
     */
    SUM_OF_ABSOLUTE_ERRORS("sum-of-absolute-errors");

    /**
     * The name of the literal in the DL.
     */
    private final String literal;

    RegressionError(final String literal) {
        this.literal = literal;
    }

    /**
     * @param literal A literal of the DL enumeration.
     * @return The corresponding measure.
     * @throws IllegalArgumentException if the literal is unknown.
     */
    public static RegressionError of(final EEnumLiteral literal) {
        for(final RegressionError measure : values()) {
            if(measure.literal.equals(literal.getName())) {
                return measure;
            }
        }

        throw new IllegalArgumentException("Unknown regression error '" + literal.getName() + "'.");
    }

    /**
     * @param targets The target of every row.
     * @param predictions The prediction of every row.
     * @return The error of the predictions.
     */
    public double of(final double[] targets, final double[] predictions) {
        return switch(this) {
            case MEAN_SQUARED_ERROR -> meanSquaredError(targets, predictions);
            case SUM_OF_ABSOLUTE_ERRORS -> sumOfAbsoluteErrors(targets, predictions);
        };
    }

    private static double meanSquaredError(final double[] targets, final double[] predictions) {
        double sum = 0.0;
        for(int i = 0; i < targets.length; ++i) {
            final double difference = targets[i] - predictions[i];
            sum += difference * difference;
        }

        return sum / targets.length;
    }

    private static double sumOfAbsoluteErrors(final double[] targets, final double[] predictions) {
        double sum = 0.0;
        for(int i = 0; i < targets.length; ++i) {
            final double difference = targets[i] - predictions[i];
            sum += Math.abs(difference);
        }

        return sum;
    }
}
