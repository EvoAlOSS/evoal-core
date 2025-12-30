package de.evoal.optimisation.main.producer;

import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.api.properties.info.PropertiesRanges;
import de.evoal.core.api.properties.info.PropertyBoundaries;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class PropertiesRangesProducer {
    @Produces
    @ApplicationScoped
    public PropertiesRanges create(final PropertiesBoundaries boundaries) {
        final PropertiesRanges ranges = new PropertiesRanges();

        for(final PropertySpecification specification : boundaries.getSpecifications()) {
            final PropertyBoundaries bounds = boundaries.get(specification);

            ranges.put(specification, bounds.upper().doubleValue() - bounds.lower().doubleValue());
        }

        return ranges;
    }
}
