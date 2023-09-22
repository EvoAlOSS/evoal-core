package de.evoal.core.api.constraints.calculation;

import de.evoal.core.api.constraints.strategies.CalculationResult;
import de.evoal.core.api.constraints.model.Constraint;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.Instance;
import lombok.NonNull;

/**
 * A calculation strategy calculates the final difference of a {@link Constraint}.
 *   The actual implementations can modify the result of the constraint evaluation it its own will.
 */
public interface CalculationStrategy {
    /**
     * Calculates the constraint handling result for the given {@code properties}.
     *
     * @param properties Properties of an individual to check.
     * @return A non-null non-empty list of constraint handling results.
     */
    @NonNull CalculationResult calculate(final Properties properties, final Properties fitness);

    /**
     * Initialises the strategy with the constraint and the calculation configuration.
     *
     * @param constraint The corresponding constraint.
     * @param configuration The handler configuration.
     */
    void init(final Constraint constraint, final Instance configuration);
}
