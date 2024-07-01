package de.evoal.optimisation.pso.main.producer;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.BoundaryType;
import de.evoal.optimisation.pso.main.impl.NeighborhoodTopology;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@ApplicationScoped
public class BoundaryTypeProducer {
    @Produces
    @Singleton
    public BoundaryType createBoundaryType(@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.boundary-type") String typeName) {
        return BoundaryType.valueOf(typeName);
    }

    @Produces
    @Singleton
    public NeighborhoodTopology.Topology createTopology(@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.topology") String topologyName) {
        return NeighborhoodTopology.Topology.valueOf(topologyName);
    }
}
