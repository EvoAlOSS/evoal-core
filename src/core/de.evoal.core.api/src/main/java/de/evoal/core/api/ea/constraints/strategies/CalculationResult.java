package de.evoal.core.api.ea.constraints.strategies;

import de.evoal.core.api.ea.constraints.model.ConstraintResult;
import lombok.Data;

/**
 * The calculation result checks if the applied constraint was successful or
 * not.
 */
@Data
public class CalculationResult {
    /**
     * The final result of the constraint evaluation.
     */
    private final ConstraintResult result;

    /**
     * If the evaluation is successful.
     */
    private final boolean successful;

    public CalculationResult(final ConstraintResult result) {
        this.result = result;
        this.successful = isSuccessful(result);
    }

    /**
     * Was the application successful?
     */
    public static boolean isSuccessful(final ConstraintResult result) {
        switch (result.getType()) {
            case Equality:
                return result.getComparisonDifference() == 0.0;

            case Inequality:
                return result.getComparisonDifference() > 0.0;

            default:
                throw new IllegalStateException("Unhandled constraint type: " + result.getType());
        }
    }
}
