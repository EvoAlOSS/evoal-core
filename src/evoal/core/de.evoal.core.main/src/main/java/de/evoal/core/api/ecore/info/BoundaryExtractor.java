package de.evoal.core.api.ecore.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.Constrained;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.TypedBaseDataDescription;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Extracts the boundaries of a data description from its {@code @LowerBoundary} and
 *   {@code @UpperBoundary} constraints (types of the DL module {@code de.evoal.core.constraints}).
 *   Constraints of the data description and of its data type are considered. Other
 *   constraints, e.g., statements like {@code value >= 0.0}, are ignored.
 *
 * The extractor works on the parsed model and is used while creating the space classes and
 *   the classes of DL types.
 */
@Slf4j
public final class BoundaryExtractor {
    /**
     * Name of the DL module that defines the boundary constraints.
     */
    public static final String CONSTRAINTS_MODULE = "de.evoal.core.constraints";

    public static final String LOWER_BOUNDARY = "LowerBoundary";
    public static final String UPPER_BOUNDARY = "UpperBoundary";

    /**
     * A single bound.
     *
     * @param value The bound.
     * @param inclusive If the bound itself is a valid value.
     */
    public record Bound(double value, boolean inclusive) {}

    /**
     * The extracted boundaries. A missing side is unbounded.
     */
    public record Extracted(Optional<Bound> lower, Optional<Bound> upper) {
        public boolean isEmpty() {
            return lower.isEmpty() && upper.isEmpty();
        }
    }

    private BoundaryExtractor() {
    }

    /**
     * Extracts the boundaries of the given data description.
     *
     * @throws IllegalStateException if the boundaries contradict each other.
     */
    public static Extracted extract(final @NonNull DataDescription description) {
        final List<Expression> constraints = new ArrayList<>(description.getConstraints());

        if(description instanceof TypedBaseDataDescription typed && typed.getType() != null) {
            constraints.addAll(((Constrained) typed.getType()).getConstraints());
        }

        return extract(constraints, "data '" + description.getName() + "'");
    }

    /**
     * Extracts the boundaries of the given attribute of a DL type.
     *
     * @throws IllegalStateException if the boundaries contradict each other.
     */
    public static Extracted extract(final @NonNull AttributeDefinition attribute) {
        return extract(attribute.getConstraints(), "attribute '" + attribute.getName() + "'");
    }

    /**
     * Extracts the boundaries from the given constraints.
     *
     * @param constraints The constraints of the element.
     * @param subject The element in messages, e.g. {@code data 'x'}.
     * @throws IllegalStateException if the boundaries contradict each other.
     */
    private static Extracted extract(final List<? extends Expression> constraints, final String subject) {
        Optional<Bound> lower = Optional.empty();
        Optional<Bound> upper = Optional.empty();

        for(final Instance instance : ConstraintAnnotations.annotationsOf(constraints, LOWER_BOUNDARY)) {
            final Bound bound = toBound(instance, subject);
            lower = Optional.of(lower.map(b -> tighterLower(b, bound)).orElse(bound));
        }

        for(final Instance instance : ConstraintAnnotations.annotationsOf(constraints, UPPER_BOUNDARY)) {
            final Bound bound = toBound(instance, subject);
            upper = Optional.of(upper.map(b -> tighterUpper(b, bound)).orElse(bound));
        }

        if(lower.isPresent() && upper.isPresent()) {
            final Bound l = lower.get();
            final Bound u = upper.get();

            if(l.value() > u.value() || (l.value() == u.value() && !(l.inclusive() && u.inclusive()))) {
                throw new IllegalStateException("The boundaries of " + subject + " are contradicting: lower " + l + ", upper " + u + ".");
            }
        }

        return new Extracted(lower, upper);
    }

    private static Bound toBound(final Instance instance, final String subject) {
        final Object boundary = ConstraintAnnotations.valueOf(instance, "boundary");
        if(boundary == null) {
            throw new IllegalStateException("Boundary constraint of " + subject + " has no 'boundary'.");
        }

        final double value;
        try {
            value = NumericConversions.toDouble(boundary);
        } catch(final IllegalArgumentException e) {
            throw new IllegalStateException("Boundary of " + subject + " is not a number: " + e.getMessage(), e);
        }

        final Object inclusive = ConstraintAnnotations.valueOf(instance, "inclusive");
        return new Bound(value, inclusive == null || Boolean.TRUE.equals(inclusive));
    }

    private static Bound tighterLower(final Bound a, final Bound b) {
        if(a.value() != b.value()) {
            return a.value() > b.value() ? a : b;
        }

        return a.inclusive() ? b : a;
    }

    private static Bound tighterUpper(final Bound a, final Bound b) {
        if(a.value() != b.value()) {
            return a.value() < b.value() ? a : b;
        }

        return a.inclusive() ? b : a;
    }
}
