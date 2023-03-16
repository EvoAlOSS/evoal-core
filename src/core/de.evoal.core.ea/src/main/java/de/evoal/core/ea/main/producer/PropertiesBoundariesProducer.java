package de.evoal.core.ea.main.producer;

import de.evoal.core.ea.api.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.ea.main.constraints.constraint.ast.BoundaryIdentifier;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

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
