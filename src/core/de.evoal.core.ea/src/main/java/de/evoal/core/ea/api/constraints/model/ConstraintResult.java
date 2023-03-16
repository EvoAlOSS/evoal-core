package de.evoal.core.ea.api.constraints.model;

import de.evoal.core.api.properties.PropertySpecification;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * The result of a constraint comparison.
 */
@Data
public class ConstraintResult {
    /**
     * The applied constraint.
     */
    private Constraint constraint;

    /**
     * Type of the constraint.
     */
    private ConstraintType type;

    /**
     * The calculated difference.
     */
    private double comparisonDifference = 0.0;

    /**
     * A list of used properties to calculate the constraint result.
     */
    private final List<PropertySpecification> usedProperties = new ArrayList<>();
}
