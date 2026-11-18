package de.evoal.optimisation.api.run;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import de.evoal.core.api.cdi.RunScopeControl;
import de.evoal.core.api.cdi.RunScoped;

/**
 * Controls the {@link RunScoped} context of the CDI container on the thread of the run.
 */
@ApplicationScoped
public class ContainerRunScope implements RunScope {
    @Inject
    private RunScopeControl control;

    @Override
    public void start() {
        control.start();
    }

    @Override
    public void stop() {
        control.stop();
    }
}
