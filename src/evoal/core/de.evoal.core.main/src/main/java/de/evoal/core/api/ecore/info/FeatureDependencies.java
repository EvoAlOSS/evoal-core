package de.evoal.core.api.ecore.info;

import de.evoal.core.api.ecore.Space;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.*;

/**
 * Small utility class for calculating the dependencies between input and output properties.
 */
public class FeatureDependencies {
    private final Map<EStructuralFeature, Set<EStructuralFeature>> dependencies = new HashMap<>();

    public FeatureDependencies(final Space specification) {
        for(final EStructuralFeature ps : specification) {
            dependencies.put(ps, new HashSet<>());
        }
    }

    public void add(final EStructuralFeature target, final Collection<EStructuralFeature> deps) {
        dependencies.get(target).addAll(deps);
    }

    public Set<EStructuralFeature> get(final EStructuralFeature specification) {
        return dependencies.get(specification);
    }
}
