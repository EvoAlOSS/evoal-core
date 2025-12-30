package de.evoal.core.api.cdi;

import jakarta.enterprise.util.Nonbinding;

import jakarta.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Annotation to let the framework inject an entry from the blackboard.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface BlackboardValue {
    /**
     * @return The entry to inject.
     */
    @Nonbinding String value();
}
