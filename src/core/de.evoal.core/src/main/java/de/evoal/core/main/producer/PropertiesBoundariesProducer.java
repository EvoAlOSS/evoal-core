package de.evoal.core.main.producer;

import de.evoal.core.api.ea.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.api.properties.info.PropertiesRanges;
import de.evoal.core.main.ea.constraints.constraint.ast.BoundaryIdentifier;
import de.evoal.languages.model.el.Expression;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Collection;

@ApplicationScoped
public class PropertiesBoundariesProducer {
    @Produces @ApplicationScoped
    public PropertiesBoundaries create(final DataConstraints constraints, final @Named("genotype-specification") PropertiesSpecification genotypeSpecification) {
        final PropertiesBoundaries boundaries = BoundaryIdentifier.run(constraints);

        genotypeSpecification
                .getProperties()
                .stream()
                .filter(s -> !boundaries.contains(s))
                .forEach(s -> {
                    boundaries.add(s, new PropertiesBoundaries.Boundaries(-Double.MAX_VALUE/2, Double.MAX_VALUE/2));
                });

        return boundaries;
    }
}
