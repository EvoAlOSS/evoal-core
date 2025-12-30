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
@Target({ElementType.FIELD})
public @interface Commandline {
    /**
     * @return The application that accept this parameter.
     */
    @Nonbinding String [] main();

    /**
     * @return Parameter name.
     */
    @Nonbinding String name();

    /**
     * @return The documentation.
     */
    @Nonbinding String doc();
}
