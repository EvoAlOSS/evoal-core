package de.evoal.core.api.ecore.misc;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.utils.Requirements;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class SpaceHelper {
    public static Space fromFeatureStream(final Stream<EStructuralFeature> features) {
        final Set<EStructuralFeature> featureSet = new HashSet<>();

        final List<EStructuralFeature> orderedSet =
            features.filter(f -> !featureSet.contains(f))
                    .peek(featureSet::add)
                    .toList();

        Requirements.requireNotEmpty(orderedSet);

        final EClass clazz = orderedSet.get(0).getEContainingClass();
        orderedSet.forEach(f -> Requirements.requireEqual(clazz, f.getEContainingClass()));

        return new Space(clazz).subSpace(orderedSet);
    }
}
