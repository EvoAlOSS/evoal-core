package de.evoal.surrogate.smile.boosting;

import java.lang.reflect.Field;

import smile.base.cart.OrdinalNode;
import smile.regression.GradientTreeBoost;

/**
 * Reads the values of a fitted Smile model that Smile 5.0.1 does not make public, but that the
 *   ONNX graph of the model needs: the split value of a node and the intercept of a model.
 *   {@code smile-core} is an automatic module, so all its packages are open to reflection. A
 *   Smile version that renames the fields fails here, and the round-trip test of the writer
 *   finds it.
 */
final class SmileInternals {
    private static final Field SPLIT_VALUE = field(OrdinalNode.class, "value");

    private static final Field INTERCEPT = field(GradientTreeBoost.class, "b");

    private SmileInternals() {
    }

    private static Field field(final Class<?> type, final String name) {
        try {
            final Field field = type.getDeclaredField(name);
            field.setAccessible(true);

            return field;
        } catch(final NoSuchFieldException e) {
            throw new IllegalStateException("The Smile class " + type.getName() + " has no field '" + name + "'; the Smile version is not supported.", e);
        }
    }

    /**
     * @return The split value of the node: a row goes to the true child iff its feature is at
     *   most the value.
     */
    static double splitValue(final OrdinalNode node) {
        return read(SPLIT_VALUE, node);
    }

    /**
     * @return The intercept of the model: its prediction before the first tree.
     */
    static double intercept(final GradientTreeBoost model) {
        return read(INTERCEPT, model);
    }

    private static double read(final Field field, final Object object) {
        try {
            return field.getDouble(object);
        } catch(final IllegalAccessException e) {
            throw new IllegalStateException("Cannot read the field '" + field.getName() + "' of " + field.getDeclaringClass().getName() + ".", e);
        }
    }
}
