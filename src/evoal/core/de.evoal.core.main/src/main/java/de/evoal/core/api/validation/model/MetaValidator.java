package de.evoal.core.api.validation.model;

import lombok.NonNull;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A validator for the meta-model level.
 */
public interface MetaValidator extends Validator {
    /**
     * Validates a resource.
     *
     * @param resource The resource to validate
     */
    public void validate(final @NonNull Resource resource);
}
