package de.evoal.core.api.validation.constraints;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import org.eclipse.emf.ecore.EObject;

/**
 * A constraint checker component for checking data constraint.
 */
public interface ConstraintCheckerComponent extends EvoalComponent<ConstraintCheckerComponent> {
    /**
     * Implements the actual check. The check fires instances of {@link de.evoal.core.api.validation.model.Diagnostics}
     *  if a violation is found.
     *
     * @param context The context of the check.
     * @param container The container that has the constraint attached.
     */
    public void check(final DiagnosticsContext context, final EObject container);
}
