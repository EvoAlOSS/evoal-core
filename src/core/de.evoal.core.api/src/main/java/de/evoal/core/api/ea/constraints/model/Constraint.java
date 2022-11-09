package de.evoal.core.api.ea.constraints.model;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import lombok.Data;

import java.util.List;
import java.util.function.Function;

/**
 * A single evaluable constraint. A constraint ca be applied to an individual
 * (properties) and produces a {@link ConstraintResult} in return.
 */
@Data
public class Constraint {
    /**
     * Type of the constraint
     */
    private ConstraintType constraintType;

    /**
     * Handling group for this constraint
     */
    private String group;

    /**
     * The applicable constraint function.
     */
    private Function<Properties, Double> function;

    /**
     * List of used properties.
     */
    private List<PropertySpecification> usedProperties;

    /**
     * Applies the constraint {@link #function} to the given individual {@code properties}.
     *
     * @param properties The individual to check.
     * @return The result of the constraint's evaluation.
     */
    public ConstraintResult apply(final Properties properties) {
        final ConstraintResult result = new ConstraintResult();

        result.setConstraint(this);
        result.setComparisonDifference(function.apply(properties));
        result.getUsedProperties().addAll(usedProperties);
        result.setType(getConstraintType());

        return result;
    }
}
