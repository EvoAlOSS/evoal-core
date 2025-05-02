package de.evoal.optimisation.api.constraints.model;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import lombok.Data;

import java.util.List;
import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;

/**
 * A single evaluable constraint. A constraint ca be applied to an individual
 * (properties) and produces a {@link ConstraintResult} in return.
 */
@Slf4j
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
    private BiFunction<Properties, Properties, Object> function;

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
    public ConstraintResult apply(final Properties genotypeProps, final Properties fitnessProps) {
        final ConstraintResult result = new ConstraintResult();
        log.info("applying constraint and generating constraint result. Data is following:");
        log.info("constraint type: " + getConstraintType());
        log.info("used properties: " + usedProperties.toString());
        result.setConstraint(this);
        result.setComparisonDifference(((Number)function.apply(genotypeProps, fitnessProps)).doubleValue());
        result.getUsedProperties().addAll(usedProperties);
        result.setType(getConstraintType());

        return result;
    }
}
