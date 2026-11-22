package de.evoal.core.main.validation;

import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Instance;
import jakarta.enterprise.event.Event;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Objects;

/**
 * Reports a required attribute that an instance does not set: an attribute of the instance's
 *   type (or one of its super types) that has no default and is not optional.
 */
@ApplicationScoped
@Slf4j
public class AttributeExistsValidator implements MetaValidator {
    @Inject
    private Event<Diagnostics> events;

    @Override
    public int priority() {
        return 200;
    }

    @Override
    public void validate(final @NonNull Resource res) {
        log.info("Checking if required attributes are set in resource '{}'.", res.getURI());

        final ResourceContext resourceContext = new ResourceContext(res);
        final TreeIterator<EObject> contents = res.getAllContents();

        while(contents.hasNext()) {
            if(contents.next() instanceof Instance instance) {
                validateInstance(new EObjectContext(resourceContext, OlPath.of(instance), instance), instance);
            }
        }
    }

    /**
     * Checks that all required attributes are set.
     *
     * @param context The context of the instance.
     * @param instance The instance to validate.
     */
    private void validateInstance(final EObjectContext context, final Instance instance) {
        log.debug("Validating instance '{}'.", instance.getDefinition().getName());
        final ClassDefinition definition = instance.getDefinition();

        definition.getAllAttributes()
                  .stream()
                  .filter(a -> Objects.isNull(a.getInitialisation()))
                  .filter(a -> !a.isOptional())
                  .filter(a -> instance.findAttribute(a) == null)
                  .peek(a -> log.info("Attribute {} is missing.", a.getName()))
                  .forEach(a -> events.fire(new Diagnostics(Diagnostics.Level.Error, context.child(a.getName(), instance), "Required attribute '" + a.getName() + "' not specified.")));
    }
}
