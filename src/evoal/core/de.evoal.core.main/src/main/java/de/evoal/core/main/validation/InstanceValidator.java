package de.evoal.core.main.validation;

import de.evoal.core.api.validation.components.InstanceValidationComponent;
import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * Runs the instance validators ({@link de.evoal.core.api.validation.model.InstanceValidator})
 *   on every instance of a resource, with the instance's path as context.
 */
@Slf4j
@ApplicationScoped
public class InstanceValidator implements MetaValidator {
    @Inject
    private InstanceValidationComponent instanceValidator;

    @Override
    public void validate(@NonNull Resource resource) {
        final ResourceContext resourceContext = new ResourceContext(resource);
        final TreeIterator<EObject> treeIterator = resource.getAllContents();

        while (treeIterator.hasNext()) {
            if (treeIterator.next() instanceof Instance instance) {
                instanceValidator.validate(new EObjectContext(resourceContext, OlPath.of(instance), instance), instance);
            }
        }
    }

    @Override
    public int priority() {
        return 300;
    }
}
