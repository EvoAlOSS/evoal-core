package de.evoal.core.main.validation;

import de.evoal.core.api.validation.components.InstanceValidationComponent;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

/**
 * Component for validating definition-based model parts.
 */
@ApplicationScoped
@Slf4j
public class AttributeExistsValidator implements MetaValidator {

    @Inject
    private InstanceValidationComponent validator;

    @Inject
    private Event<Diagnostics> events;

    private DiagnosticsContext toPathContext(final DiagnosticsContext diagnostics, final Instance instance) {
        return diagnostics;
    }

    @Override
    public int priority() {
        return 200;
    }

    @Override
    public void validate(final @NonNull Resource res) {
        log.info("Checking if required attributes are set in resource '{}'.", res.getURI());

        final DiagnosticsContext resourceContext = new ResourceContext(res);

        final TreeIterator<EObject> iterator = res.getAllContents();
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),
                        false)
                .filter(Instance.class::isInstance)
                .map(Instance.class::cast)
                .forEach(i -> validateInstance(toPathContext(resourceContext, i), i));
    }

    /**
     * Checks of all required attributes are present.
     *
     * @param instance The instance to validate.
     */
    private void validateInstance(final DiagnosticsContext context, final Instance instance) {
        log.debug("Validating instance '{}'.", instance.getDefinition().getName());
        final ClassDefinition definition = instance.getDefinition();

        definition.getAllAttributes()
                  .stream()
                  .filter(a -> Objects.isNull(a.getInitialisation()))
                  .filter(a -> instance.findAttribute(a) == null)
                  .peek(a -> log.info("Attribute {} is missing.", a.getName()))
                  .forEach(a -> events.fire(new Diagnostics(Diagnostics.Level.Error, new EObjectContext(context, toPath(instance, a.getName()), instance), "Required attribute '" + a.getName() + "' not specified.")));
    }

    private String toPath(final Instance instance, final String attributeName) {
        EObject child = instance;
        EObject current = instance.eContainer();
        String path = "." + attributeName;

        while(current != null) {
            if(current instanceof Attribute attr) {
                path = "." + attr.getDefinition().getName() + path;
            } else if(current instanceof Array arr) {
                for(int index = 0; index < arr.getValues().size(); ++index) {
                    if(child == arr.getValues().get(index)) {
                        path = "[" + index + "]" + path;
                        break;
                    }
                }
            } else if(current.eClass().getName().endsWith("Module")) {
                for(final EStructuralFeature feature : current.eClass().getEAllStructuralFeatures()) {
                    if(current.eGet(feature) == child) {
                        path = feature.getName() + path;
                        return path;
                    }
                }
            }


            child = current;
            current = current.eContainer();
        }

        return path;
    }
}
