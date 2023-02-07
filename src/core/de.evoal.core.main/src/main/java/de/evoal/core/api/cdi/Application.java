package de.evoal.core.api.cdi;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
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
    public String name();

    /**
     * @return The documentation.
     */
    public @Nonbinding String documentation();
}
