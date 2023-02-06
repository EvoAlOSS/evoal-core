package de.evoal.core.main.producer;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.api.properties.info.PropertiesRanges;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PropertiesRangesProducer {
    @Produces @ApplicationScoped
    public PropertiesRanges create(final PropertiesBoundaries boundaries) {
        final PropertiesRanges ranges = new PropertiesRanges();

        for(final PropertySpecification specification : boundaries.getSpecifications()) {
            final PropertiesBoundaries.Boundaries bounds = boundaries.get(specification);

            ranges.put(specification, bounds.upper().doubleValue() - bounds.lower().doubleValue());
        }

        return ranges;
    }
}
