package de.evoal.optimisation.api.run;

import jakarta.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;

import de.evoal.core.api.cdi.RunScoped;

/**
 * Controls the {@link RunScoped} context through the CDI container.
 */
@ApplicationScoped
public class ContainerRunScope implements RunScope {
    private static ContextControl contextControl() {
        return CdiContainerLoader.getCdiContainer()
                                 .getContextControl();
    }

    @Override
    public void start() {
        contextControl().startContext(RunScoped.class);
    }

    @Override
    public void stop() {
        contextControl().stopContext(RunScoped.class);
    }
}
