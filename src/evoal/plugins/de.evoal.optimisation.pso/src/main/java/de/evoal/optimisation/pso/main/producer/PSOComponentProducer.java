package de.evoal.optimisation.pso.main.producer;

import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.cdi.OptimisationComponentProducer;
import de.evoal.optimisation.pso.api.optimiser.Mover;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;

@ApplicationScoped
public class PSOComponentProducer {
    @Inject
    private OptimisationComponentProducer producer;

    @Produces
    @Dependent
    @Component
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public Mover createMover(final InjectionPoint ip) {
        return producer.create(ip);
    }
}
