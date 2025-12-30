package de.evoal.optimisation.pso.main.producer;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.languages.model.base.definitions.EnumLiteralDefinition;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.BoundaryType;
import de.evoal.optimisation.pso.main.impl.NeighborhoodTopology;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@Slf4j
@ApplicationScoped
public class BoundaryTypeProducer {
    @Produces
    @Singleton
    public BoundaryType createBoundaryType(@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.boundary-type") EnumLiteralDefinition name) {
        log.info("Looking up boundary type {}", name.getName());

        return BoundaryType.valueOf(name.getName().toUpperCase());
    }

    @Produces
    @Singleton
    public NeighborhoodTopology.Topology createTopology(@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.topology") EnumLiteralDefinition name) {
        log.info("Looking up topology {}", name.getName());

        return NeighborhoodTopology.Topology.valueOf(name.getName().toUpperCase());
    }
}
