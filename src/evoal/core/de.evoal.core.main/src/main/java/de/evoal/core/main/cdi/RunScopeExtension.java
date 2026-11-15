package de.evoal.core.main.cdi;

import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.inject.spi.Extension;
import lombok.Getter;

public class RunScopeExtension implements Extension {

    @Getter
    private RunContext runContext;

    void afterBeanDiscovery(@Observes AfterBeanDiscovery abd, BeanManager beanManager) {
        runContext = new RunContext(beanManager);
        abd.addContext(runContext);
    }
}