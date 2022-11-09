package de.evoal.core.api.cdi;

import de.evoal.core.api.board.BlackboardEntry;

import javax.enterprise.util.Nonbinding;

import javax.inject.Qualifier;
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
    public @Nonbinding String value();
}
