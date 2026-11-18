package de.evoal.core.api.ecore.misc;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import lombok.NonNull;

/**
 * Prepares {@link EClass}es for the use by several threads.
 * <p>
 * EMF builds several caches of a class lazily and without synchronisation, e.g., the list
 *   of all features, the feature ids, the map from names to features and the setting
 *   delegates of the features. If several threads use a class for the first time at once,
 *   they build these caches concurrently. {@link #prepare(EClass)} builds them on the calling
 *   thread; afterwards, creating instances of the class and reading and writing their
 *   features only reads the caches. Threads that are started (or receive tasks) after the
 *   preparation see the caches.
 */
public final class ConcurrentEClassAccess {
    private ConcurrentEClassAccess() {
    }

    /**
     * Builds the lazily created caches of the class and its features.
     *
     * @param eClass The class to prepare.
     */
    public static void prepare(final @NonNull EClass eClass) {
        eClass.getEAllSuperTypes();
        eClass.getEAllGenericSuperTypes();
        eClass.getEAllAttributes();
        eClass.getEAllReferences();
        eClass.getEAllContainments();
        eClass.getEAllOperations();
        eClass.getFeatureCount();
        eClass.getOperationCount();

        for(final EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            eClass.getFeatureID(feature);
            eClass.getEStructuralFeature(feature.getName());
            feature.getDefaultValue();
            feature.isMany();
            feature.getEType();
            ((EStructuralFeature.Internal)feature).getSettingDelegate();
        }

        if(eClass.isAbstract() || eClass.isInterface()) {
            return;
        }

        // reading and writing every feature of an instance builds the remaining caches
        final EObject instance = EcoreUtil.create(eClass);
        for(final EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            final Object value = instance.eGet(feature);

            if(feature.isChangeable() && !feature.isMany()) {
                instance.eSet(feature, value);
            }
            instance.eIsSet(feature);
        }
    }
}
