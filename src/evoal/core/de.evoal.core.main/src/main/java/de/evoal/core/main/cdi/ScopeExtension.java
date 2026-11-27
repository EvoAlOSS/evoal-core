package de.evoal.core.main.cdi;

import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.inject.spi.Extension;

import de.evoal.core.api.cdi.EvaluationScoped;
import de.evoal.core.api.cdi.RunScoped;
import lombok.Getter;

/**
 * Registers the contexts of the {@link EvaluationScoped} and the {@link RunScoped} scope.
 */
public class ScopeExtension implements Extension {
    /**
     * The context of the evaluations.
     */
    @Getter
    private ScopedValueContext evaluationContext;

    /**
     * The context of the runs.
     */
    @Getter
    private ScopedValueContext runContext;

    void afterBeanDiscovery(@Observes final AfterBeanDiscovery abd, final BeanManager beanManager) {
        evaluationContext = ScopedValueContext.forEvaluations(beanManager);
        runContext = ScopedValueContext.forRuns(beanManager);

        abd.addContext(evaluationContext);
        abd.addContext(runContext);
    }
}
