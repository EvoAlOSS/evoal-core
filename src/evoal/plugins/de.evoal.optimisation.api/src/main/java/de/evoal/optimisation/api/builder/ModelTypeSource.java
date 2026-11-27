package de.evoal.optimisation.api.builder;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * What the random builder needs to know about the classes of a model beyond the reflective EMF
 *   API: which concrete classes an abstract-typed feature can hold and which features are
 *   optional. The DL front-end answers it from the DL types (subtypes of the loaded modules,
 *   {@code optional} attributes); other front-ends, e.g. {@code .ecore} files, can answer it
 *   from their own packages.
 */
public interface ModelTypeSource {
    /**
     * @param type The type of a feature or of the root of a model.
     * @return The concrete classes that a feature of the type can hold, including the type itself
     *   if it is concrete, in a fixed order.
     */
    List<EClass> concreteSubtypesOf(EClass type);

    /**
     * @param feature A single-valued feature.
     * @return {@code true} if the feature may stay without value, i.e. the builder sets it only
     *   with a probability.
     */
    boolean isOptional(EStructuralFeature feature);
}
