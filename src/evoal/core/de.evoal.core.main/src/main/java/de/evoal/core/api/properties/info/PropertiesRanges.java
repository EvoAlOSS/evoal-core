package de.evoal.core.api.properties.info;

import de.evoal.core.api.properties.PropertySpecification;

import java.util.HashMap;
import java.util.Map;

public class PropertiesRanges {
    private final Map<PropertySpecification, Double> rangeMap = new HashMap<>();

    public Double get(final PropertySpecification specification) {
        return rangeMap.get(specification);
    }

    public void put(final PropertySpecification specification, double v) {
        rangeMap.put(specification, v);
    }
}
