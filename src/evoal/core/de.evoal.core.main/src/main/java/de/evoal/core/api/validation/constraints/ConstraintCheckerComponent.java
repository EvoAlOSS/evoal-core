package de.evoal.core.api.validation.constraints;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * Checks one DL constraint annotation, e.g., {@code @LowerBoundary { boundary := 0.0; }}.
 *   The checker of an annotation type is the component named by the fully-qualified name
 *   of the type (e.g., {@code de.evoal.core.constraints.LowerBoundary}); it is configured
 *   with the annotation, converted like any other DL instance.
 *
 * <p>The {@link de.evoal.core.main.validation.ConstraintValidator} calls the checkers when a
 *   configuration is loaded, before the run starts. This is meant to move to the Langium
 *   validator of the EvoAl IDE extensions once its language server replaces the Xtext
 *   parser.</p>
 */
public interface ConstraintCheckerComponent extends EvoalComponent<ConstraintCheckerComponent> {
    /**
     * Checks a value against the constraint.
     *
     * @param value For an annotation on an attribute, the value of the attribute as the
     *   languages' interpreter computes it from the configuration: a number, boolean or
     *   string, a list for an array, the parsed {@code Instance} for an instance, or the
     *   referenced definition for values that are only known during the run (e.g. data).
     *   For an annotation on a type, the parsed {@code Instance} of that type.
     * @return The result of the check.
     */
    public ConstraintCheck check(final Object value);
}
