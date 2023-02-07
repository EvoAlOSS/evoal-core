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
@Target({ElementType.FIELD})
public @interface Commandline {
    /**
     * @return The application that accept this parameter.
     */
    public @Nonbinding String main();

    /**
     * @return Parameter name.
     */
    public @Nonbinding String name();

    /**
     * @return The documentation.
     */
    public @Nonbinding String doc();
}
