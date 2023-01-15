package de.evoal.core.main.producer;

import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.api.properties.info.PropertiesRanges;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PropertiesBoundariesProducer {
    @Produces @ApplicationScoped
    public PropertiesBoundaries create() {
        return null;
    }
}
