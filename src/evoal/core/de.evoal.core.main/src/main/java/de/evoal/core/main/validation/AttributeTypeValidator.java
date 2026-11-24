package de.evoal.core.main.validation;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.Module;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.EnumDefinition;
import de.evoal.languages.model.base.definitions.EnumLiteralDefinition;
import de.evoal.languages.model.base.definitions.TypeDefinition;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.BooleanLiteral;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.NumberLiteral;
import de.evoal.languages.model.base.expressions.ReadExpression;
import de.evoal.languages.model.base.expressions.StringLiteral;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;
import de.evoal.languages.model.base.types.ArrayType;
import de.evoal.languages.model.base.types.ClassDefinitionReference;
import de.evoal.languages.model.base.types.EnumDefinitionReference;
import de.evoal.languages.model.base.types.Type;

/**
 * Reports a value that does not fit the DL type of its attribute, both in instances and in
 *   the defaults of DL attributes:
 *
 * <ul>
 *   <li>{@code instance 'T'}: the value is an instance of {@code 'T'} or of a subtype of it,
 *     e.g. {@code crossover : instance 'gene-exchange'} rejects {@code 'sbx-crossover' {}};</li>
 *   <li>{@code enum 'E'}: the value is a literal of {@code 'E'}, e.g.
 *     {@code 'check-reaction.warn'}, not a string or a literal of another enum;</li>
 *   <li>{@code array T}: every element of an array value fits {@code T}.</li>
 * </ul>
 *
 * Only values whose type is known without evaluating them are checked: instances, literals,
 *   enum literals and arrays. Other values (e.g. calls, references to constants, path
 *   expressions or expressions with operators) and the other attribute types are left to the
 *   components that read them.
 *
 * <p>This check is meant to move to the Langium validator of the EvoAl IDE extensions once
 *   its language server replaces the Xtext parser.</p>
 */
@ApplicationScoped
@Slf4j
public class AttributeTypeValidator implements MetaValidator {
    @Inject
    private Event<Diagnostics> events;

    @Override
    public int priority() {
        return 220;
    }

    @Override
    public void validate(final @NonNull Resource res) {
        log.info("Checking the types of the attribute values in resource '{}'.", res.getURI());

        final ResourceContext resourceContext = new ResourceContext(res);
        final TreeIterator<EObject> contents = res.getAllContents();

        while(contents.hasNext()) {
            final EObject next = contents.next();
            if(next instanceof Attribute attribute && attribute.getDefinition() != null && attribute.getValue() != null) {
                check(resourceContext, attribute.getDefinition(), attribute.getDefinition().getType(), attribute.getValue());
            } else if(next instanceof AttributeDefinition definition && definition.getInitialisation() != null) {
                check(resourceContext, definition, definition.getType(), definition.getInitialisation());
            }
        }
    }

    /**
     * Checks a value against the type of its attribute.
     *
     * @param resourceContext The file of the value.
     * @param attribute The DL attribute the value is assigned to.
     * @param type The type the value must have: the attribute's type, or the element type of
     *   an array attribute.
     * @param value The value.
     */
    private void check(final ResourceContext resourceContext, final AttributeDefinition attribute, final Type type, final Expression value) {
        final Optional<ReadExpression> element = ElementSwitch.elementOf(value);
        if(type == null || element.isEmpty()) {
            return;
        }

        final Optional<String> mismatch = switch(type) {
            case ClassDefinitionReference reference -> instanceMismatch(reference.getDefinition(), element.get());
            case EnumDefinitionReference reference -> enumMismatch(reference.getDefinition(), element.get());
            case ArrayType arrayType -> {
                if(element.get() instanceof Array array) {
                    array.getValues().forEach(v -> check(resourceContext, attribute, arrayType.getElements(), v));
                }
                yield Optional.empty();
            }
            default -> Optional.empty();
        };

        mismatch.ifPresent(m -> {
            final EObjectContext context = new EObjectContext(resourceContext, OlPath.of(element.get()), element.get());
            events.fire(new Diagnostics(Diagnostics.Level.Error, context, "'" + attribute.getName() + "' " + m + "."));
        });
    }

    /**
     * @return Why the value is no instance of the expected type, or nothing if it is one or
     *   its type is not known without evaluating it.
     */
    private static Optional<String> instanceMismatch(final ClassDefinition expected, final ReadExpression value) {
        final String expectation = "expects an instance of '" + expected.getName() + "'";

        if(value instanceof Instance instance) {
            final ClassDefinition actual = instance.getDefinition();
            if(actual == null || isSubtype(actual, expected)) {
                return Optional.empty();
            }

            return Optional.of(expectation + ", but '" + actual.getName() + "' is not a subtype of it");
        }

        return kindOfLiteral(value).map(kind -> expectation + ", but the value is " + kind);
    }

    /**
     * @return Why the value is no literal of the expected enum, or nothing if it is one or its
     *   type is not known without evaluating it.
     */
    private static Optional<String> enumMismatch(final EnumDefinition expected, final ReadExpression value) {
        final String expectation = "expects a literal of the enum '" + expected.getName() + "'";

        if(value instanceof ValueDefinitionReference reference && reference.getDefinition() instanceof EnumLiteralDefinition literal) {
            if(literal.eContainer() instanceof EnumDefinition actual && !qualifiedName(actual).equals(qualifiedName(expected))) {
                return Optional.of(expectation + ", but '" + literal.getName() + "' is a literal of '" + actual.getName() + "'");
            }

            return Optional.empty();
        }

        if(value instanceof Instance instance && instance.getDefinition() != null) {
            return Optional.of(expectation + ", but the value is an instance of '" + instance.getDefinition().getName() + "'");
        }

        return kindOfLiteral(value).map(kind -> expectation + ", but the value is " + kind);
    }

    /**
     * @return The kind of a string, number, boolean or array value, for the message, or
     *   nothing for other values.
     */
    private static Optional<String> kindOfLiteral(final ReadExpression value) {
        return switch(value) {
            case StringLiteral string -> Optional.of("the string \"" + string.getLiteral() + "\"");
            case NumberLiteral number -> Optional.of("a number");
            case BooleanLiteral bool -> Optional.of("a boolean");
            case Array array -> Optional.of("an array");
            default -> Optional.empty();
        };
    }

    /**
     * Compares the types by their qualified names, so a type counts as the same if its DL file
     *   is loaded through two URIs.
     *
     * @return Whether {@code actual} is {@code expected} or one of its subtypes.
     */
    static boolean isSubtype(final @NonNull ClassDefinition actual, final @NonNull ClassDefinition expected) {
        final String expectedName = qualifiedName(expected);

        for(ClassDefinition current = actual; current != null; current = current.getSuperType()) {
            if(qualifiedName(current).equals(expectedName)) {
                return true;
            }
        }

        return false;
    }

    private static String qualifiedName(final TypeDefinition definition) {
        return definition.eContainer() instanceof Module module ? module.getName() + "." + definition.getName() : definition.getName();
    }
}
