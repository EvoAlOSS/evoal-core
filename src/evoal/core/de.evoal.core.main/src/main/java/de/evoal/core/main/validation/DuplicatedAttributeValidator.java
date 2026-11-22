package de.evoal.core.main.validation;

import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import java.util.*;

/**
 * Reports an attribute name that exists more than once in a DL type, counting the attributes
 *   of its super types.
 */
@ApplicationScoped
@Slf4j
public class DuplicatedAttributeValidator implements MetaValidator {
    @Inject
    private Event<Diagnostics> events;

    @Override
    public int priority() {
        return 250;
    }

    @Override
    public void validate(final @NonNull Resource res) {
        log.info("Checking if attribute name exists multiple times in resource '{}'.", res.getURI());

        final ResourceContext resourceContext = new ResourceContext(res);
        final TreeIterator<EObject> contents = res.getAllContents();

        while(contents.hasNext()) {
            if(contents.next() instanceof ClassDefinition definition) {
                log.debug("Found class definition {}", definition.getName());
                validateDefinition(new EObjectContext(resourceContext, OlPath.of(definition), definition), definition);
            }
        }
    }

    /**
     * Checks that no attribute name is present more than once.
     *
     * @param context The context of the type.
     * @param definition The definition to validate.
     */
    private void validateDefinition(final EObjectContext context, final ClassDefinition definition) {
        log.debug("Validating definition '{}'.", definition.getName());

        final Set<String> attributes = new HashSet<>();
        definition.getAllAttributes()
                  .stream()
                  .filter(a -> !attributes.add(a.getName()))
                  .forEach(a -> events.fire(new Diagnostics(Diagnostics.Level.Error, context.child(a.getName(), definition), "Attribute with '" + a.getName() + "' exists multiple times in type '" + definition.getName() + "'.")));
    }
}
