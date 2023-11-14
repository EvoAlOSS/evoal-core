package de.evoal.core.api.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for injecting components. Depending on the component you have to specify
 *   an additonal @ConfigurationValue to specify the configuration, or you don't if it
 *   is a core component. You can annotate an attribute or a parameter in a CDI
 *   life-cycle method with this annotation to tell the framework that you want some
 *   component:
 *
 *   <pre>
 *     @Inject @Component
 *     private OptimisationFunction iterations;
 *   </pre>
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Component {
}
