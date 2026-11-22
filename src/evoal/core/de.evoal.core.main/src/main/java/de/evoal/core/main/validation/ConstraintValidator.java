package de.evoal.core.main.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.inject.Provider;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.dynamic.ValueConverter;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.model.InstanceValidator;
import de.evoal.languages.model.base.Module;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Checks the constraint annotations of the DL (e.g. {@code @LowerBoundary}) on every parsed
 *   instance when a configuration is loaded, before the run starts:
 *
 * <ul>
 *   <li>an annotation on an attribute against the value of the attribute, computed by the
 *     languages' interpreter ({@link ConstantEvaluator}); attributes the instance does not
 *     set are skipped (their DL defaults are checked by
 *     {@link DefaultValueConstraintValidator});</li>
 *   <li>an annotation on a type, or on one of its super types, against the instance.</li>
 * </ul>
 *
 * A violation is an error, so the run stops. A value that is only known during the run
 *   (e.g. data, or an expression that is evaluated per sample) is reported as an info.
 *   Annotations without a checker (e.g. {@code @Literature}) are skipped.
 *
 * <p>This check is meant to move to the Langium validator of the EvoAl IDE extensions once
 *   its language server replaces the Xtext parser.</p>
 */
@Slf4j
@ApplicationScoped
public class ConstraintValidator implements InstanceValidator {
    @Inject
    private Event<Diagnostics> events;

    /**
     * Converts the annotations into the configurations of their checkers.
     */
    @Inject
    private Provider<ValueConverter> converters;

    /**
     * The checker of every annotation, empty for annotations without a checker.
     */
    private final Map<Instance, Optional<ConstraintCheckerComponent>> checkers = new HashMap<>();

    /**
     * Computes the values of the attributes.
     */
    private final ConstantEvaluator evaluator = new ConstantEvaluator();

    @Override
    public int priority() {
        return 300;
    }

    @Override
    public void validate(final @NonNull EObjectContext context, final @NonNull Instance instance) {
        final ClassDefinition definition = instance.getDefinition();
        log.debug("Checking the constraints of instance {}.", definition.getName());

        for(ClassDefinition type = definition; type != null; type = type.getSuperType()) {
            for(final Expression constraint : type.getConstraints()) {
                apply(context, "'" + definition.getName() + "'", constraint, instance);
            }
        }

        for(final AttributeDefinition attribute : definition.getAllAttributes()) {
            final Attribute value = instance.findAttribute(attribute);
            if(value != null) {
                checkAttribute(context.child(attribute.getName(), value), attribute, value.getValue());
            }
        }
    }

    /**
     * Checks a value of an attribute against the annotations of the attribute.
     *
     * @param context The context of the diagnostics.
     * @param attribute The DL attribute.
     * @param value The expression that assigns the value, e.g. the attribute's value in an
     *   instance or its DL default.
     */
    public void checkAttribute(final @NonNull DiagnosticsContext context, final @NonNull AttributeDefinition attribute, final @NonNull Expression value) {
        if(attribute.getConstraints().isEmpty()) {
            return;
        }

        final String subject = "'" + attribute.getName() + "'";
        final Object computed;
        try {
            computed = evaluator.doSwitch(value);
        } catch(final RuntimeException e) {
            log.debug("Cannot compute the value of {}.", subject, e);
            events.fire(Diagnostics.of(Diagnostics.Level.Info, context, subject + " is not checked against its annotations: its value cannot be computed before the run."));
            return;
        }

        for(final Expression constraint : attribute.getConstraints()) {
            apply(context, subject, constraint, computed);
        }
    }

    private void apply(final DiagnosticsContext context, final String subject, final Expression constraint, final Object value) {
        if(!(constraint instanceof Instance annotation)) {
            log.warn("Constraints of type {} are not supported.", constraint.eClass().getName());
            return;
        }

        checkerFor(context, annotation).ifPresent(checker -> {
            final ConstraintCheck result = checker.check(value);
            switch(result) {
                case ConstraintCheck.Violated violated ->
                        events.fire(Diagnostics.of(Diagnostics.Level.Error, context, subject + " " + violated.message() + "."));
                case ConstraintCheck.NotCheckable notCheckable ->
                        events.fire(Diagnostics.of(Diagnostics.Level.Info, context, subject + " is not checked against @" + annotation.getDefinition().getName() + ": " + notCheckable.reason() + "."));
                case ConstraintCheck.Satisfied satisfied -> {}
            }
        });
    }

    /**
     * @return The configured checker of the annotation, or empty if its type has none.
     */
    private Optional<ConstraintCheckerComponent> checkerFor(final DiagnosticsContext context, final Instance annotation) {
        return checkers.computeIfAbsent(annotation, a -> createChecker(context, a));
    }

    private Optional<ConstraintCheckerComponent> createChecker(final DiagnosticsContext context, final Instance annotation) {
        final String name = nameOf(annotation.getDefinition());
        final ConstraintCheckerComponent checker = BeanProvider.getContextualReference(name, true, ConstraintCheckerComponent.class);
        if(checker == null) {
            log.debug("The annotation {} has no checker.", name);
            return Optional.empty();
        }

        try {
            final EObject configuration = (EObject) converters.get()
                                                              .setTargetType(null)
                                                              .convert(annotation);
            return Optional.of(checker.init(configuration));
        } catch(final InitializationException | RuntimeException e) {
            log.error("Unable to configure the checker of {}.", name, e);
            events.fire(Diagnostics.of(Diagnostics.Level.Error, context, "The annotation @" + annotation.getDefinition().getName() + " is invalid: " + e.getMessage()));
            return Optional.empty();
        }
    }

    /**
     * @return The fully-qualified name of the DL type, which names its checker.
     */
    static String nameOf(final ClassDefinition definition) {
        return definition.eContainer() instanceof Module module ? module.getName() + "." + definition.getName() : definition.getName();
    }
}
