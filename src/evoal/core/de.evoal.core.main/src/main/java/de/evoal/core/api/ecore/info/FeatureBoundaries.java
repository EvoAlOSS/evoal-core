package de.evoal.core.api.ecore.info;

import de.evoal.core.api.properties.PropertySpecification;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FeatureBoundaries {
    public void add(final EStructuralFeature specification, final Boundaries boundaries) {
        boundariesMap.put(specification, boundaries);
    }

    public record Boundaries(Number lower, Number upper) {}

    private final Map<EStructuralFeature, Boundaries> boundariesMap = new HashMap<>();

    public boolean contains(final EStructuralFeature specification) { return boundariesMap.containsKey(specification); }

    public Boundaries get(final EStructuralFeature specification) {
        return boundariesMap.get(specification);
    }

    public Collection<EStructuralFeature> getSpecifications() {
        return boundariesMap.keySet();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("PropertiesBoundaries [");
        for(final Map.Entry<EStructuralFeature, Boundaries> entry : boundariesMap.entrySet()) {
            builder.append(entry.getValue().lower);
            builder.append(" < ");
            builder.append(entry.getKey().getName());
            builder.append(" < ");
            builder.append(entry.getValue().upper);
            builder.append(", ");
        }

        builder.append("]");

        return builder.toString();
    }
}
