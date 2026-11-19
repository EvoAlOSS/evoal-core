package de.evoal.optimisation.ea.api.cdi;

import jakarta.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Annotation for marking malus functions.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Target({ElementType.TYPE})
public @interface Fitness {
    /**
     * @return Name of the malus calculator.
     */
    String value();
}
