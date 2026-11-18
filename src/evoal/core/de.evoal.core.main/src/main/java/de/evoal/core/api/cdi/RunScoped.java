package de.evoal.core.api.cdi;

import jakarta.enterprise.context.NormalScope;
import java.lang.annotation.*;

/**
 * Scope of a single optimisation run: a run-scoped bean exists once per run and is destroyed
 *   (with its {@code @PreDestroy} methods) at the end of the run. The run kernel controls the
 *   scope with {@link RunScopeControl}.
 * <p>
 * The scope is bound to the thread that runs the algorithm. Other threads, e.g. the workers
 *   that evaluate candidates in parallel, cannot use run-scoped beans.
 */
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@NormalScope(passivating = false)
public @interface RunScoped {
}