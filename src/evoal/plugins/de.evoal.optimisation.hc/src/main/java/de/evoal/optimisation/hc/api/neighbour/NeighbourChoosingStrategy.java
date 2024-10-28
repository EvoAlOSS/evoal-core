package de.evoal.optimisation.hc.api.neighbour;

import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.Instance;
import de.evoal.core.api.cdi.EvoalComponent;

import java.util.stream.Stream;

public interface NeighbourChoosingStrategy extends EvoalComponent<NeighbourChoosingStrategy> {

    NeighbourChoosingStrategy init(final Instance ncs);

    Stream<Properties> neighbours(final Properties candidate);
}
