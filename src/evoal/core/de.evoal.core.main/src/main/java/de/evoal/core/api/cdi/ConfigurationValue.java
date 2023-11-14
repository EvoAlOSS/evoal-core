package de.evoal.core.api.cdi;

import javax.enterprise.util.Nonbinding;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for injecting values from the configuration. You can annotate an
 *   attribute or a parameter in a CDI life-cycle method with this annotation
 *   to tell the framework that you want some information from a blackboard
 *   configuration:
 *
 *   <pre>
 *     @Inject
 *     @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.number-of-iterations")
 *     private int iterations;
 *   </pre>
 *
 *   This example will load the pso configuration from the blackboard and search
 *   for the attribute {@code algorithm}. Afterwards, it looks up the attribute
 *   {@code number-of-generations}.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface ConfigurationValue {
    /**
     * @return The blackboard entry to use for the lookup.
     */
    String entry();

    /**
     * @return The access path.
     */
    @Nonbinding String access();
}
