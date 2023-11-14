package de.evoal.core.pso.main.producer;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ComponentProducer;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.pso.api.optimiser.Mover;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

@ApplicationScoped
public class PSOComponentProducer {
    @Inject
    private ComponentProducer producer;

    @Produces
    @Dependent
    @Component
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Mover createMover(final InjectionPoint ip) {
        return producer.create(ip);
    }
}
