package de.evoal.core.api.cdi;

import jakarta.enterprise.util.Nonbinding;
import jakarta.inject.Qualifier;

import java.lang.annotation.*;

/**
 * Annotation for documenting main classes.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Target({ElementType.TYPE})
public @interface Application {
    /**
     * @return Name of the application.
     */
    String name();

    /**
     * @return The documentation.
     */
    @Nonbinding String documentation();
}
