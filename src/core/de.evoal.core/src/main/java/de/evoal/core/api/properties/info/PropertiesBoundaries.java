package de.evoal.core.api.properties.info;

import de.evoal.core.api.properties.PropertySpecification;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PropertiesBoundaries {
    public record Boundaries(Number lower, Number upper) {}

    private Map<PropertySpecification, Boundaries> boundariesMap = new HashMap<>();


    public Boundaries get(final PropertySpecification specification) {
        return boundariesMap.get(specification);

    }

    public Collection<PropertySpecification> getSpecifications() {
        return boundariesMap.keySet();
    }
}
