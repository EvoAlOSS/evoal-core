package de.evoal.core.main.producer;

import de.evoal.core.api.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.main.constraints.constraint.ast.BoundaryIdentifier;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.stream.Stream;

@ApplicationScoped
public class PropertiesBoundariesProducer {
    @Produces @ApplicationScoped
    public PropertiesBoundaries create(final DataConstraints constraints,
                                       final @Named("search-space-specification") PropertiesSpecification searchSpecification,
                                       final @Named("optimisation-space-specification") PropertiesSpecification optimisationSpecification) {
        final PropertiesBoundaries boundaries = BoundaryIdentifier.run(constraints);

        Stream.concat(
                searchSpecification.getProperties().stream(),
                optimisationSpecification.getProperties().stream())
                .filter(s -> !boundaries.contains(s))
                .forEach(s -> {
                    boundaries.add(s, new PropertiesBoundaries.Boundaries(-Double.MAX_VALUE/2, Double.MAX_VALUE/2));
                });

        return boundaries;
    }
}
