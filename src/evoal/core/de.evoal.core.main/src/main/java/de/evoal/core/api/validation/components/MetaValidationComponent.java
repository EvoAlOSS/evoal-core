package de.evoal.core.api.validation.components;

import de.evoal.core.api.validation.model.MetaValidator;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.resource.ResourceSet;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Component for validating the meta model.
 */
@ApplicationScoped
@Slf4j
public class MetaValidationComponent extends ValidationComponent <MetaValidator> {

    @PostConstruct
    public void init() {
        loadValidators(MetaValidator.class);
    }

    public void validate(final ResourceSet rs) {
        rs.getResources()
          .stream()
          .forEach(r -> validators.forEach(v -> v.validate(r)));

    }
}
