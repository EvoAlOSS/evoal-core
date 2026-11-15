package de.evoal.core.api.ecore.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import de.evoal.languages.model.base.Module;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.Constrained;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.TypedBaseDataDescription;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Extracts the boundaries of a data description from its {@code @LowerBoundary} and
 *   {@code @UpperBoundary} constraints (types of the DL module {@code de.evoal.core.constraints}).
 *   Constraints of the data description and of its data type are considered. Other
 *   constraints, e.g., statements like {@code value >= 0.0}, are ignored.
 *
 * The extractor works on the parsed model and is used while creating the space classes.
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

        Optional<Bound> lower = Optional.empty();
        Optional<Bound> upper = Optional.empty();

        for(final Expression constraint : constraints) {
            if(!(constraint instanceof Instance instance) || !isBoundaryConstraint(instance)) {
                continue;
            }

            final Bound bound = toBound(instance, description);
            if(LOWER_BOUNDARY.equals(instance.getDefinition().getName())) {
                lower = Optional.of(lower.map(b -> tighterLower(b, bound)).orElse(bound));
            } else {
                upper = Optional.of(upper.map(b -> tighterUpper(b, bound)).orElse(bound));
            }
        }

        if(lower.isPresent() && upper.isPresent()) {
            final Bound l = lower.get();
            final Bound u = upper.get();

            if(l.value() > u.value() || (l.value() == u.value() && !(l.inclusive() && u.inclusive()))) {
                throw new IllegalStateException("The boundaries of data '" + description.getName() + "' are contradicting: lower " + l + ", upper " + u + ".");
            }
        }

        return new Extracted(lower, upper);
    }

    private static boolean isBoundaryConstraint(final Instance instance) {
        final ClassDefinition definition = instance.getDefinition();
        if(definition == null) {
            return false;
        }

        final String name = definition.getName();
        if(!LOWER_BOUNDARY.equals(name) && !UPPER_BOUNDARY.equals(name)) {
            return false;
        }

        return definition.eContainer() instanceof Module module && CONSTRAINTS_MODULE.equals(module.getName());
    }

    private static Bound toBound(final Instance instance, final DataDescription description) {
        final Object boundary = evaluate(instance, "boundary");
        if(boundary == null) {
            throw new IllegalStateException("Boundary constraint of data '" + description.getName() + "' has no 'boundary'.");
        }

        final double value;
        try {
            value = NumericConversions.toDouble(boundary);
        } catch(final IllegalArgumentException e) {
            throw new IllegalStateException("Boundary of data '" + description.getName() + "' is not a number: " + e.getMessage(), e);
        }

        final Object inclusive = evaluate(instance, "inclusive");
        return new Bound(value, inclusive == null || Boolean.TRUE.equals(inclusive));
    }

    /**
     * Evaluates the attribute of the instance or, if it is not specified, its default value.
     */
    private static Object evaluate(final Instance instance, final String name) {
        final ConstantEvaluator evaluator = new ConstantEvaluator();

        for(final Attribute attribute : instance.getAttributes()) {
            if(name.equals(attribute.getDefinition().getName())) {
                return evaluator.doSwitch(attribute.getValue());
            }
        }

        final AttributeDefinition attribute = instance.getDefinition().findAttribute(name);
        if(attribute != null && attribute.getInitialisation() != null) {
            return evaluator.doSwitch(attribute.getInitialisation());
        }

        return null;
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
