package de.evoal.core.api.cdi;

import jakarta.enterprise.util.Nonbinding;

import jakarta.inject.Qualifier;
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
 *     @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
 *                         access = "algorithm.accepting-strategy.initial-temperature")
 *     private double initialTemperature;
 *   </pre>
 *
 *   This example loads the optimisation configuration from the blackboard and
 *   follows the attributes {@code algorithm}, {@code accepting-strategy} and
 *   {@code initial-temperature}.
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
