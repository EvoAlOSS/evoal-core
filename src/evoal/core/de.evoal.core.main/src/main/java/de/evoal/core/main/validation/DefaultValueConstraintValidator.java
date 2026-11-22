package de.evoal.core.main.validation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;

/**
 * Checks the DL default of every attribute against the attribute's own constraint
 *   annotations, e.g. {@code @UpperBoundary { boundary := 1.0; } probability : real := 0.9;},
 *   so a wrong default is reported where it is written, see {@link ConstraintValidator}.
 */
@Slf4j
@ApplicationScoped
public class DefaultValueConstraintValidator implements MetaValidator {
    @Inject
    private ConstraintValidator constraints;

    @Override
    public int priority() {
        return 310;
    }

    @Override
    public void validate(final @NonNull Resource resource) {
        final ResourceContext context = new ResourceContext(resource);
        final TreeIterator<EObject> contents = resource.getAllContents();

        while(contents.hasNext()) {
            if(contents.next() instanceof ClassDefinition type) {
                for(final AttributeDefinition attribute : type.getAttributes()) {
                    if(attribute.getInitialisation() != null) {
                        constraints.checkAttribute(new EObjectContext(context, type.getName() + "." + attribute.getName(), attribute),
                                                   attribute,
                                                   attribute.getInitialisation());
                    }
                }
            }
        }
    }
}
