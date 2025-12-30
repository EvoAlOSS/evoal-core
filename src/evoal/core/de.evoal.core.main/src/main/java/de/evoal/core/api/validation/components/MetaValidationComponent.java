package de.evoal.core.api.validation.components;

import de.evoal.core.api.validation.model.MetaValidator;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.resource.ResourceSet;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * Component for validating the meta model.
 */
@ApplicationScoped
@Slf4j
public class MetaValidationComponent extends ValidationComponent <MetaValidator> {

    @PostConstruct
    public void init() {
        log.info("Collecting validators for meta validation.");
        loadValidators(MetaValidator.class);
    }

    public void validate(final ResourceSet rs) {
        rs.getResources()
          .forEach(r -> validators.forEach(v -> v.validate(r)));
    }
}
