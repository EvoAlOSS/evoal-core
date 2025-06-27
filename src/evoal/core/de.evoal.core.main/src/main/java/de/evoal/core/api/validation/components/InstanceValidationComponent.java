package de.evoal.core.api.validation.components;

import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.model.InstanceValidator;
import de.evoal.languages.model.base.expressions.Instance;
import org.eclipse.emf.ecore.EObject;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 * Component for validating data instances.
 */
@ApplicationScoped
public class InstanceValidationComponent extends ValidationComponent<InstanceValidator> {

    @PostConstruct
    public void init() {
        loadValidators(InstanceValidator.class);
    }

    public void validate(final EObjectContext context, final Instance instance) {
        validators.forEach(v -> v.validate(context, instance));
    }

}
