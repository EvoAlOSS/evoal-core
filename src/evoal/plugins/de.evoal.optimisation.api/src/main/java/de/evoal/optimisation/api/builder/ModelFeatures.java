package de.evoal.optimisation.api.builder;

import java.util.List;

import lombok.NonNull;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * The features of a model class that the search fills and changes, in the order of
 *   {@code getEAllStructuralFeatures}. Left out are the features whose values follow from others or
 *   are not part of the model: the reference to the container (the opposite of a containment),
 *   derived, volatile and transient features and features that cannot be changed. The classes of
 *   DL types have none of them, so their models see every feature. The builder, the value and
 *   structure operators, the checks and the memory model use these features.
 */
public final class ModelFeatures {
    private ModelFeatures() {
    }

    /**
     * @return The searched features of the class.
     */
    public static List<EStructuralFeature> of(final @NonNull EClass eClass) {
        return eClass.getEAllStructuralFeatures()
                     .stream()
                     .filter(ModelFeatures::isSearched)
                     .toList();
    }

    /**
     * @return The searched attributes of the class.
     */
    public static List<EAttribute> attributesOf(final @NonNull EClass eClass) {
        return of(eClass).stream()
                         .filter(EAttribute.class::isInstance)
                         .map(EAttribute.class::cast)
                         .toList();
    }

    /**
     * @return The searched containments of the class.
     */
    public static List<EReference> containmentsOf(final @NonNull EClass eClass) {
        return of(eClass).stream()
                         .filter(EReference.class::isInstance)
                         .map(EReference.class::cast)
                         .filter(EReference::isContainment)
                         .toList();
    }

    /**
     * @return {@code true} if the search fills and changes the feature.
     */
    public static boolean isSearched(final @NonNull EStructuralFeature feature) {
        final boolean isContainer = feature instanceof EReference reference && reference.isContainer();

        return !isContainer
            && !feature.isDerived()
            && !feature.isVolatile()
            && !feature.isTransient()
            && feature.isChangeable();
    }
}
