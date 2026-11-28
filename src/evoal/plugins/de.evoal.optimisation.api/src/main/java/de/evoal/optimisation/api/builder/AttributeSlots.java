package de.evoal.optimisation.api.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lombok.NonNull;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * The attribute values of a model candidate in a fixed order, the "genes" of a model for the value
 *   mutations: the objects in pre-order ({@link ModelTrees#objects}), per object its attributes in
 *   the order of {@link ModelFeatures}, one slot per element of a multi-valued
 *   attribute. An optional attribute without value is no slot; giving it a value changes the
 *   structure of the model.
 */
public final class AttributeSlots {
    private AttributeSlots() {
    }

    /**
     * One attribute value of a model.
     *
     * @param object The object that holds the value.
     * @param attribute The attribute.
     * @param index The position in a multi-valued attribute, -1 for a single-valued one.
     */
    public record Slot(@NonNull EObject object, @NonNull EAttribute attribute, int index) {
        /**
         * @return The value.
         */
        public Object get() {
            if(index < 0) {
                return object.eGet(attribute);
            }

            return values().get(index);
        }

        /**
         * Replaces the value.
         */
        public void set(final Object value) {
            if(index < 0) {
                object.eSet(attribute, value);
            } else {
                values().set(index, value);
            }
        }

        @SuppressWarnings("unchecked")
        private List<Object> values() {
            return (List<Object>) object.eGet(attribute);
        }
    }

    /**
     * @param root The root of the model.
     * @param isOptional Whether a single-valued attribute may stay without value, e.g.
     *   {@link ModelTypes#isOptional}.
     * @return The slots of the model in their fixed order.
     */
    public static List<Slot> of(final @NonNull EObject root, final @NonNull Predicate<EStructuralFeature> isOptional) {
        final List<Slot> slots = new ArrayList<>();

        for(final EObject object : ModelTrees.objects(root)) {
            for(final EStructuralFeature feature : ModelFeatures.of(object.eClass())) {
                if(!(feature instanceof EAttribute attribute)) {
                    continue;
                }

                if(attribute.isMany()) {
                    final int count = ((List<?>) object.eGet(attribute)).size();
                    for(int index = 0; index < count; ++index) {
                        slots.add(new Slot(object, attribute, index));
                    }
                } else if(!isOptional.test(attribute) || object.eIsSet(attribute)) {
                    slots.add(new Slot(object, attribute, -1));
                }
            }
        }

        return slots;
    }
}
