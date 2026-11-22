package de.evoal.core.main.validation;

import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
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
 * Reports an attribute that is assigned more than once in the same instance.
 */
@ApplicationScoped
@Slf4j
public class MultipleAttributeValidator implements MetaValidator {
    @Inject
    private Event<Diagnostics> events;

    @Override
    public int priority() {
        return 210;
    }

    @Override
    public void validate(final @NonNull Resource res) {
        log.info("Checking if attribute values are defined multiple times in '{}'.", res.getURI());

        final ResourceContext resourceContext = new ResourceContext(res);
        final TreeIterator<EObject> contents = res.getAllContents();

        while(contents.hasNext()) {
            if(contents.next() instanceof Instance instance) {
                validateInstance(new EObjectContext(resourceContext, OlPath.of(instance), instance), instance);
            }
        }
    }

    /**
     * Checks that no attribute is assigned twice; each such attribute is reported once.
     *
     * @param context The context of the instance.
     * @param instance The instance to validate.
     */
    private void validateInstance(final EObjectContext context, final Instance instance) {
        log.debug("Validating instance '{}'.", instance.getDefinition().getName());

        final Set<AttributeDefinition> assigned = new HashSet<>();
        final Set<AttributeDefinition> duplicates = new LinkedHashSet<>();
        instance.getAttributes()
                .stream()
                .map(Attribute::getDefinition)
                .filter(a -> !assigned.add(a))
                .forEach(duplicates::add);

        duplicates.forEach(a -> events.fire(new Diagnostics(Diagnostics.Level.Error, context.child(a.getName(), instance), "Attribute '" + a.getName() + "' is defined multiple times.")));
    }
}
