package de.evoal.core.api.properties.info;

import de.evoal.core.api.properties.PropertySpecification;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PropertiesBoundaries {
    private final Map<PropertySpecification, PropertyBoundaries> boundariesMap = new HashMap<>();

    public void add(final PropertySpecification specification, final PropertyBoundaries boundaries) {
        boundariesMap.put(specification, boundaries);
    }


    public boolean contains(final PropertySpecification specification) { return boundariesMap.containsKey(specification); }

    public PropertyBoundaries get(final PropertySpecification specification) {
        return boundariesMap.get(specification);
    }

    public Collection<PropertySpecification> getSpecifications() {
        return boundariesMap.keySet();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("PropertiesBoundaries [");
        for(final Map.Entry<PropertySpecification, PropertyBoundaries> entry : boundariesMap.entrySet()) {
            builder.append(entry.getValue().lower());
            builder.append(entry.getValue().isLowerInclusive() ? " <= " : " < ");
            builder.append(entry.getKey().name());
            builder.append(entry.getValue().isUpperInclusive() ? " <= " : " < ");
            builder.append(entry.getValue().upper());
            builder.append(", ");
        }

        builder.append("]");

        return builder.toString();
    }
}
