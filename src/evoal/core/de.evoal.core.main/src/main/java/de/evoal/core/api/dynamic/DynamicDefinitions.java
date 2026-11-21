package de.evoal.core.api.dynamic;

import java.util.Optional;

import lombok.NonNull;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dynamic.ClassMapping;
import de.evoal.languages.model.dynamic.DynamicPackage;

/**
 * The DL types of dynamic classes: {@link DynamicEClassProvider} records the DL type that a
 *   class was created from in an annotation of the class.
 */
public final class DynamicDefinitions {
    private DynamicDefinitions() {
    }

    /**
     * @param eClass A class, e.g., the class of a configuration.
     * @return The DL type that the class was created from, empty for other classes.
     */
    public static Optional<ClassDefinition> definitionOf(final @NonNull EClass eClass) {
        final EAnnotation annotation = eClass.getEAnnotation(DynamicPackage.eNS_URI);
        if(annotation != null) {
            for(final EObject content : annotation.getContents()) {
                if(content instanceof ClassMapping mapping) {
                    return Optional.ofNullable(mapping.getSource());
                }
            }
        }

        return Optional.empty();
    }
}
