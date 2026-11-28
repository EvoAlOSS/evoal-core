package de.evoal.optimisation.ea.main.operators.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.optimisation.api.builder.ModelFeatures;
import de.evoal.optimisation.api.builder.ModelTrees;

/**
 * An array of a model: a multi-valued feature (attribute or containment) of one object.
 *
 * @param object The object.
 * @param feature The multi-valued feature.
 */
record ModelArray(EObject object, EStructuralFeature feature) {
    /**
     * @return The arrays of the model, objects in pre-order, per object its multi-valued features
     *   in the order of {@link ModelFeatures}.
     */
    static List<ModelArray> of(final EObject root) {
        final List<ModelArray> arrays = new ArrayList<>();
        for(final EObject object : ModelTrees.objects(root)) {
            for(final EStructuralFeature feature : ModelFeatures.of(object.eClass())) {
                if(feature.isMany()) {
                    arrays.add(new ModelArray(object, feature));
                }
            }
        }

        return arrays;
    }

    /**
     * @return The elements; changes change the model.
     */
    @SuppressWarnings("unchecked")
    List<Object> elements() {
        return (List<Object>) object.eGet(feature);
    }
}
