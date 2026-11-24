package de.evoal.optimisation.api.fitness;

import java.util.Collection;
import java.util.Optional;

import de.evoal.languages.model.base.Module;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Checks {@code @RequiresFitnessComponents} of {@code de.evoal.core.constraints}: every DL type
 *   that the algorithm's configuration uses (the algorithm and every configuration it holds, e.g.
 *   its selections, comparator and stopping criteria, collected like the literature of a run)
 *   needs, if it or one of its super types carries the annotation, a fitness with that many
 *   components. The number of components follows from the goals of the problem and the steps of
 *   the fitness pipeline, so the check runs when the run knows its fitness layout, before the
 *   algorithm is created.
 */
public final class FitnessComponentRequirements {
    /**
     * The module of the annotation type.
     */
    private static final String MODULE = "de.evoal.core.constraints";

    /**
     * The name of the annotation type.
     */
    private static final String TYPE = "RequiresFitnessComponents";

    private FitnessComponentRequirements() {
    }

    /**
     * @param types The DL types of the algorithm's configuration; other definitions are ignored.
     * @param layout The fitness layout of the run.
     * @throws InitializationException if a type needs another number of fitness components
     *   than the layout has.
     */
    public static void check(final Collection<? extends Definition> types, final FitnessLayout layout) throws InitializationException {
        for(final Definition type : types) {
            if(type instanceof ClassDefinition definition) {
                checkType(definition, layout.size());
            }
        }
    }

    /**
     * Checks the annotations of the type and of its super types.
     */
    private static void checkType(final ClassDefinition definition, final int components) throws InitializationException {
        for(ClassDefinition type = definition; type != null; type = type.getSuperType()) {
            for(final Expression constraint : type.getConstraints()) {
                if(constraint instanceof Instance annotation && isRequirement(annotation)) {
                    checkAnnotation(definition, annotation, components);
                }
            }
        }
    }

    private static boolean isRequirement(final Instance annotation) {
        final ClassDefinition type = annotation.getDefinition();

        return type != null
               && TYPE.equals(type.getName())
               && type.eContainer() instanceof Module module
               && MODULE.equals(module.getName());
    }

    private static void checkAnnotation(final ClassDefinition definition, final Instance annotation, final int components)
            throws InitializationException {
        final long minimum = valueOf(annotation, "minimum").orElse(1L);
        final Optional<Long> maximum = valueOf(annotation, "maximum");

        final boolean fits = components >= minimum && maximum.map(max -> components <= max).orElse(true);
        if(fits) {
            return;
        }

        final String needed = maximum.map(max -> max == minimum ? "exactly " + minimum
                                                                : "between " + minimum + " and " + max)
                                     .orElse("at least " + minimum);
        final String hint = components < minimum
                ? "; the problem needs more goals, or the 'fitness-pipeline' must not reduce them by a scalarisation"
                : "; a scalarisation in the 'fitness-pipeline' (e.g. 'weighted-sum') reduces the fitness to one component";

        throw new InitializationException("'" + definition.getName() + "' needs " + needed + " fitness component"
                                          + (needed.endsWith(" 1") ? "" : "s") + ", but the fitness of the problem has "
                                          + components + hint + ".");
    }

    /**
     * @return The value of an integer attribute of the annotation: the value it sets, else the
     *   default of the attribute; empty if neither exists.
     */
    private static Optional<Long> valueOf(final Instance annotation, final String name) {
        for(final AttributeDefinition attribute : annotation.getDefinition().getAllAttributes()) {
            if(!name.equals(attribute.getName())) {
                continue;
            }

            final Attribute set = annotation.findAttribute(attribute);
            final Expression value = set != null ? set.getValue() : attribute.getInitialisation();
            if(value == null) {
                return Optional.empty();
            }

            return Optional.of(((Number) new ConstantEvaluator().doSwitch(value)).longValue());
        }

        return Optional.empty();
    }
}
