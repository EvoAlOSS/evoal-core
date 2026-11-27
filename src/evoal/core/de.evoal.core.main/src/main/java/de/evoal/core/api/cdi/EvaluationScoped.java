package de.evoal.core.api.cdi;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.enterprise.context.NormalScope;

/**
 * Scope of an evaluation: the runs of an application that belong together, e.g., all
 *   repetitions and target points of {@code heuristic-search-evaluation}. A single search is
 *   an evaluation with one run. An evaluation-scoped bean exists once per evaluation and is
 *   destroyed (with its {@code @PreDestroy} methods) at the end of the evaluation, e.g., the
 *   statistics files that the runs of the evaluation append to.
 * <p>
 * The applications open the scope with {@link ScopeControl#inEvaluation}. The beans belong
 *   to the evaluation, not to a thread: all threads that work for the evaluation see the same
 *   beans.
 */
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@NormalScope(passivating = false)
public @interface EvaluationScoped {
}
