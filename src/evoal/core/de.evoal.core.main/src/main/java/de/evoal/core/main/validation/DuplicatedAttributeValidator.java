package de.evoal.core.main.validation;

import de.evoal.core.api.validation.components.InstanceValidationComponent;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import java.util.*;
import java.util.stream.StreamSupport;

/**
 * Component for validating definition-based model parts.
 */
@ApplicationScoped
@Slf4j
public class DuplicatedAttributeValidator implements MetaValidator {

    @Inject
    private InstanceValidationComponent validator;

    @Inject
    private Event<Diagnostics> events;

    private DiagnosticsContext toPathContext(final DiagnosticsContext diagnostics, final ClassDefinition instance) {
        return diagnostics;
    }

    @Override
    public int priority() {
        return 250;
    }

    @Override
    public void validate(final @NonNull Resource res) {
        log.info("Checking if attribute name exists multiple times in resource '{}'.", res.getURI());

        final DiagnosticsContext resourceContext = new ResourceContext(res);

        final TreeIterator<EObject> iterator = res.getAllContents();
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),
                        false)
                .filter(ClassDefinition.class::isInstance)
                .peek(d -> log.info("Found class definition {}", ((ClassDefinition) d).getName()))
                .map(ClassDefinition.class::cast)
                .forEach(d -> validateDefinition(toPathContext(resourceContext, d), d));
    }

    /**
     * Checks if an attribute name is present multiple times.
     *
     * @param definition The definition to validate.
     */
    private void validateDefinition(final DiagnosticsContext context, final ClassDefinition definition) {
        log.debug("Validating definition '{}'.", definition.getName());

        final Set<String> attributes = new HashSet<>();
        definition.getAllAttributes()
                  .stream()
                  .filter(a -> !attributes.add(a.getName()))
                  .forEach(a -> events.fire(new Diagnostics(Diagnostics.Level.Error, new EObjectContext(context, toPath(definition, a.getName()), definition), "Attribute with '" + a.getName() + "' exists multiple times in type '" + definition.getName() + "'.")));
    }

    private String toPath(final ClassDefinition definition, final String attributeName) {
        return moduleToName(definition.eContainer()) + ": " + definition.getName() + "." + attributeName;
    }

    private String moduleToName(final EObject eObject) {
    if(!eObject.eClass().getName().endsWith("Module")) {
        return "<Unknown>";
    }

    return eObject
            .eClass()
            .getEAllStructuralFeatures()
            .stream()
            .filter(f -> "name".equals(f.getName()))
            .findFirst()
            .map(f -> (String)eObject.eGet(f))
            .orElse("<Unknown>");
    }
}
