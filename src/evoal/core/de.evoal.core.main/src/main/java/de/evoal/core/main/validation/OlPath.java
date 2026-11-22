package de.evoal.core.main.validation;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Builds the path of a parsed model element as the user writes it, for the messages of the
 *   validators, e.g. {@code algorithm.instance.mutator[0]} for the first mutator of an OL
 *   configuration, or {@code Type.attribute} for an element of a DL attribute definition, such
 *   as its constraint annotation.
 */
public final class OlPath {
    private OlPath() {
    }

    /**
     * Walks from the element up to its module:
     *
     * <ul>
     *   <li>an attribute adds {@code .name};</li>
     *   <li>an array adds {@code [index]} of the element that contains the path so far;</li>
     *   <li>a DL attribute definition adds {@code .name};</li>
     *   <li>a DL type definition adds {@code Type} and ends the path;</li>
     *   <li>a module ends the path with the name of its feature that holds the element, e.g.
     *     {@code algorithm}.</li>
     * </ul>
     *
     * @param element The element.
     * @return The path, empty if none of the above contains the element.
     */
    public static String of(final @NonNull EObject element) {
        String path = "";
        EObject child = null;
        EObject current = element;

        while(current != null) {
            if(current instanceof Attribute attribute) {
                path = "." + attribute.getDefinition().getName() + path;
            } else if(current instanceof Array array && child != null) {
                path = "[" + array.getValues().indexOf(child) + "]" + path;
            } else if(current instanceof AttributeDefinition attribute) {
                path = "." + attribute.getName() + path;
            } else if(current instanceof ClassDefinition type) {
                return type.getName() + path;
            } else if(child != null && current.eClass().getName().endsWith("Module")) {
                final String feature = featureHolding(current, child);
                if(feature != null) {
                    return feature + path;
                }
            }

            child = current;
            current = current.eContainer();
        }

        return path.startsWith(".") ? path.substring(1) : path;
    }

    /**
     * @return The name of the single-valued feature of the module that holds the child, or
     *   {@code null} if the child is in a list.
     */
    private static String featureHolding(final EObject module, final EObject child) {
        for(final EStructuralFeature feature : module.eClass().getEAllStructuralFeatures()) {
            if(module.eGet(feature) == child) {
                return feature.getName();
            }
        }

        return null;
    }
}
