package de.evoal.core.api.validation.model;

import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

/**
 * A validator for instance validation
 */
public interface InstanceValidator extends Validator {
    /**
     * Validate an object.
     */
    public void validate(final @NonNull EObjectContext context, final @NonNull Instance instance);
}
