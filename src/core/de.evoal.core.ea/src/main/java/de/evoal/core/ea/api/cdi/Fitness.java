package de.evoal.core.ea.api.cdi;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Annotation for marking fitness functions.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Target({ElementType.TYPE})
public @interface Fitness {
    /**
     * @return Name of the fitness calculator.
     */
    public String value();
}
