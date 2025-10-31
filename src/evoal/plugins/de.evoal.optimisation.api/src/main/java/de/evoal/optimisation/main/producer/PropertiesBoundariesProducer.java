package de.evoal.optimisation.main.producer;

import de.evoal.core.api.properties.info.PropertyBoundaries;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.optimisation.main.constraints.constraint.ast.BoundaryIdentifier;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.stream.Stream;

@ApplicationScoped @Slf4j
public class PropertiesBoundariesProducer {
    @Produces @ApplicationScoped
    public PropertiesBoundaries create(final DataConstraints constraints,
                                       final AttributeHelper helper,
                                       final @Named("search-space-specification") PropertiesSpecification searchSpecification,
                                       final @Named("optimisation-space-specification") PropertiesSpecification optimisationSpecification) {
        final PropertiesBoundaries boundaries = BoundaryIdentifier.run(helper, constraints);

        Stream.concat(
                searchSpecification.getProperties().stream(),
                optimisationSpecification.getProperties().stream())
                .filter(s -> !boundaries.contains(s))
                .forEach(s -> {
                    boundaries.add(s, new PropertyBoundaries(-Double.MAX_VALUE / 2.0, true, Double.MAX_VALUE / 2.0, true));
                });

        log.info("{}", boundaries);

        return boundaries;
    }
}
