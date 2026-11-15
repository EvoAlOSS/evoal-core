package de.evoal.models.core.cdi;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Documents the DL type that configures an {@link EvoalComponent}. Every configuration
 *   passed to {@link EvoalComponent#init(org.eclipse.emf.ecore.EObject)} of a component of
 *   the annotated type has to be an instance of the DL type or one of its sub-types.
 *
 * This is the Java counterpart of the Ecore annotation with source
 *   {@code https://evoal.de/v202610/models/core/configured-by}. If a type carries both
 *   annotations, both have to name the same DL type.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConfiguredBy {
    /**
     * @return The fully-qualified name of the configuring DL type, e.g.,
     *   {@code de.evoal.optimisation.core.optimisation-function}.
     */
    String value();
}
