package de.evoal.core.api.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;

import de.evoal.core.main.cdi.RunContext;
import de.evoal.core.main.cdi.RunScopeExtension;

/**
 * Starts and stops the {@link RunScoped} context on the current thread.
 * <p>
 * DeltaSpike's {@code ContextControl} only starts and stops the built-in scopes and ignores
 *   {@link RunScoped}. The context is therefore controlled directly: {@link #start()} activates
 *   it, {@link #stop()} destroys all run-scoped beans (calling their {@code @PreDestroy}
 *   methods) and deactivates it.
 */
@ApplicationScoped
public class RunScopeControl {
    @Inject
    private BeanManager beanManager;

    /**
     * Activates the run scope on the current thread.
     *
     * @throws IllegalStateException if the run scope is already active on the current thread.
     */
    public void start() {
        context().startRun();
    }

    /**
     * Destroys the run-scoped beans of the current thread and deactivates the run scope.
     *   Does nothing if the run scope is not active.
     */
    public void stop() {
        context().stopRun();
    }

    /**
     * @return {@code true} iff the run scope is active on the current thread.
     */
    public boolean isActive() {
        return context().isActive();
    }

    private RunContext context() {
        return beanManager.getExtension(RunScopeExtension.class).getRunContext();
    }
}
