package de.evoal.core.pso.main.producer;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.pso.api.BoundaryType;
import de.evoal.core.pso.main.impl.NeighborhoodTopology;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

@ApplicationScoped
public class BoundaryTypeProducer {
    @Produces
    @Singleton
    public BoundaryType createBoundaryType(@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.boundary-type") String typeName) {
        return BoundaryType.valueOf(typeName);
    }

    @Produces
    @Singleton
    public NeighborhoodTopology.Topology createTopology(@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.topology") String topologyName) {
        return NeighborhoodTopology.Topology.valueOf(topologyName);
    }

}
