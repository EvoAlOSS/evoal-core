package de.evoal.core.ea.api.constraints.model;

import de.evoal.core.api.properties.Properties;
import javax.enterprise.inject.Vetoed;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A collection of constraints that are applicable to an individual.
 */
@Data @Vetoed
public class Constraints {
    /**
     * The actual list of constraints.
     */
    private final List<Constraint> constraints = new ArrayList<>();

    /**
     * Applies the constraints to the given properties and produces the results.
     *
     * @param properties Properties to use
     * @return A non-null list of constraint results.
     */
    public List<ConstraintResult> apply(final Properties genotype, final Properties fitness) {
        return constraints.stream()
                .map(c -> c.apply(genotype, fitness))
                .collect(Collectors.toList());
    }
}
