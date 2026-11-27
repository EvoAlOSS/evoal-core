package de.evoal.core.api.cdi;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.enterprise.context.NormalScope;

/**
 * Scope of a single optimisation run: a run-scoped bean exists once per run and is destroyed
 *   (with its {@code @PreDestroy} methods) at the end of the run, e.g., the counters of the
 *   evaluations or the ids of the individuals. A run belongs to an {@link EvaluationScoped}
 *   evaluation and is opened with {@link ScopeControl#inRun}.
 * <p>
 * The beans belong to the run, not to a thread: the threads that evaluate the candidates of
 *   a run in parallel see the same beans as the thread of the algorithm. A run-scoped bean
 *   that these threads use has to be thread-safe.
 */
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@NormalScope(passivating = false)
public @interface RunScoped {
}
