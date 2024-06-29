package de.evoal.core.api.properties.info;

import de.evoal.core.api.properties.PropertySpecification;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PropertiesBoundaries {
    public void add(final PropertySpecification specification, final Boundaries boundaries) {
        boundariesMap.put(specification, boundaries);
    }

    public record Boundaries(Number lower, Number upper) {}

    private final Map<PropertySpecification, Boundaries> boundariesMap = new HashMap<>();

    public boolean contains(final PropertySpecification specification) { return boundariesMap.containsKey(specification); }

    public Boundaries get(final PropertySpecification specification) {
        return boundariesMap.get(specification);
    }

    public Collection<PropertySpecification> getSpecifications() {
        return boundariesMap.keySet();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("PropertiesBoundaries [");
        for(final Map.Entry<PropertySpecification, Boundaries> entry : boundariesMap.entrySet()) {
            builder.append(entry.getValue().lower);
            builder.append(" < ");
            builder.append(entry.getKey().name());
            builder.append(" < ");
            builder.append(entry.getValue().upper);
            builder.append(", ");
        }

        builder.append("]");

        return builder.toString();
    }
}
