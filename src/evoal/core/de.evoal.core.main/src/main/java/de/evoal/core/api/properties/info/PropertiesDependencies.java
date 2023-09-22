package de.evoal.core.api.properties.info;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;

import java.util.*;

/**
 * Small utility class for calculating the dependencies between input and output properties.
 */
public class PropertiesDependencies {
    private final Map<PropertySpecification, Set<PropertySpecification>> dependencies = new HashMap<>();

    public PropertiesDependencies(final PropertiesSpecification specification) {
        for(final PropertySpecification ps : specification.getProperties()) {
            dependencies.put(ps, new HashSet<>());
        }
    }

    public void add(final PropertySpecification target, final PropertiesSpecification deps) {
        dependencies.get(target).addAll(deps.getProperties());
    }

    public Set<PropertySpecification> get(final PropertySpecification specification) {
        return dependencies.get(specification);
    }
}
