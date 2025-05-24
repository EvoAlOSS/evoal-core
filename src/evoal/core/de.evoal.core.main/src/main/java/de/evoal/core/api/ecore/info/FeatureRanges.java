package de.evoal.core.api.ecore.info;

import de.evoal.core.api.properties.PropertySpecification;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.HashMap;
import java.util.Map;

public class FeatureRanges {
    private final Map<EStructuralFeature, Double> rangeMap = new HashMap<>();

    public Double get(final EStructuralFeature specification) {
        return rangeMap.get(specification);
    }

    public void put(final EStructuralFeature specification, double v) {
        rangeMap.put(specification, v);
    }
}
