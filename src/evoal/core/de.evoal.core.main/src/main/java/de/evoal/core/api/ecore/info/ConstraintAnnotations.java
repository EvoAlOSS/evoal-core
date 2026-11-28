package de.evoal.core.api.ecore.info;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import lombok.NonNull;

import de.evoal.languages.model.base.Module;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.EnumLiteralDefinition;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;

/**
 * Reads the annotations of the DL module {@code de.evoal.core.constraints} that describe a
 *   value, e.g. {@code @MaximumNumberOfElements { bound := 4; }} or
 *   {@code @Scale { scale := 'measurement-scale.cardinal'; }}, from the parsed model. Other
 *   constraints of the element are ignored.
 */
public final class ConstraintAnnotations {
    /**
     * Name of the DL type of the maximum number of elements.
     */
    public static final String MAXIMUM_NUMBER_OF_ELEMENTS = "MaximumNumberOfElements";

    /**
     * Name of the DL type of the minimum number of elements.
     */
    public static final String MINIMUM_NUMBER_OF_ELEMENTS = "MinimumNumberOfElements";

    /**
     * Name of the DL type of the scale of an attribute.
     */
    public static final String SCALE = "Scale";

    private ConstraintAnnotations() {
    }

    /**
     * @return The annotations of the given DL type of {@code de.evoal.core.constraints} among the
     *   constraints, in their order.
     *
     * @param constraints The constraints of an element, e.g. of an attribute.
     * @param typeName The name of the annotation type, e.g. {@code LowerBoundary}.
     */
    public static List<Instance> annotationsOf(final @NonNull List<? extends Expression> constraints,
                                               final @NonNull String typeName) {
        return annotationsOf(constraints, BoundaryExtractor.CONSTRAINTS_MODULE, typeName);
    }

    /**
     * @return The annotations of the given DL type of the given module among the constraints, in
     *   their order.
     *
     * @param constraints The constraints of an element, e.g. of a data description.
     * @param moduleName The module of the annotation type, e.g. {@code de.evoal.core.ecore}.
     * @param typeName The name of the annotation type, e.g. {@code EcoreType}.
     */
    public static List<Instance> annotationsOf(final @NonNull List<? extends Expression> constraints,
                                               final @NonNull String moduleName,
                                               final @NonNull String typeName) {
        return constraints.stream()
                          .filter(Instance.class::isInstance)
                          .map(Instance.class::cast)
                          .filter(instance -> isConstraintType(instance, moduleName, typeName))
                          .toList();
    }

    /**
     * @return The value of the attribute of the annotation or, if it is not specified, its
     *   default value; {@code null} if it has neither.
     *
     * @param annotation The annotation.
     * @param name The name of the attribute.
     */
    public static Object valueOf(final @NonNull Instance annotation, final @NonNull String name) {
        final ConstantEvaluator evaluator = new ConstantEvaluator();

        for(final Attribute attribute : annotation.getAttributes()) {
            if(name.equals(attribute.getDefinition().getName())) {
                return evaluator.doSwitch(attribute.getValue());
            }
        }

        final AttributeDefinition attribute = annotation.getDefinition().findAttribute(name);
        if(attribute != null && attribute.getInitialisation() != null) {
            return evaluator.doSwitch(attribute.getInitialisation());
        }

        return null;
    }

    /**
     * @return The largest number of elements of the attribute ({@code @MaximumNumberOfElements});
     *   the smallest one if it is annotated several times.
     */
    public static OptionalInt maximumNumberOfElements(final @NonNull AttributeDefinition attribute) {
        final List<Instance> annotations = annotationsOf(attribute.getConstraints(), MAXIMUM_NUMBER_OF_ELEMENTS);

        return annotations.stream()
                          .mapToInt(ConstraintAnnotations::boundOf)
                          .min();
    }

    /**
     * @return The smallest number of elements of the attribute ({@code @MinimumNumberOfElements});
     *   the largest one if it is annotated several times.
     */
    public static OptionalInt minimumNumberOfElements(final @NonNull AttributeDefinition attribute) {
        final List<Instance> annotations = annotationsOf(attribute.getConstraints(), MINIMUM_NUMBER_OF_ELEMENTS);

        return annotations.stream()
                          .mapToInt(ConstraintAnnotations::boundOf)
                          .max();
    }

    /**
     * @return The scale of the attribute's {@code @Scale} annotation, or empty if it has none.
     *
     * @throws IllegalStateException if the attribute has several scales.
     */
    public static Optional<ScaleType> scaleOf(final @NonNull AttributeDefinition attribute) {
        final List<Instance> annotations = annotationsOf(attribute.getConstraints(), SCALE);
        final List<ScaleType> scales = annotations.stream()
                                                  .map(ConstraintAnnotations::toScale)
                                                  .distinct()
                                                  .toList();
        if(scales.size() > 1) {
            throw new IllegalStateException("The attribute '" + attribute.getName() + "' has several scales: " + scales + ".");
        }

        return scales.stream()
                     .findFirst();
    }

    private static int boundOf(final Instance annotation) {
        final Object bound = valueOf(annotation, "bound");
        if(bound == null) {
            throw new IllegalStateException("@" + annotation.getDefinition().getName() + " has no 'bound'.");
        }

        return NumericConversions.toInteger(bound);
    }

    private static boolean isConstraintType(final Instance instance, final String moduleName, final String typeName) {
        final ClassDefinition definition = instance.getDefinition();
        if(definition == null || !typeName.equals(definition.getName())) {
            return false;
        }

        return definition.eContainer() instanceof Module module
            && moduleName.equals(module.getName());
    }

    private static ScaleType toScale(final Instance annotation) {
        final Object value = valueOf(annotation, "scale");
        if(!(value instanceof EnumLiteralDefinition literal)) {
            throw new IllegalStateException("@Scale needs a literal of 'measurement-scale', but got " + value + ".");
        }

        final ScaleType scale = ScaleType.get(literal.getName());
        if(scale == null) {
            throw new IllegalStateException("@Scale has the unknown scale '" + literal.getName() + "'.");
        }

        return scale;
    }
}
