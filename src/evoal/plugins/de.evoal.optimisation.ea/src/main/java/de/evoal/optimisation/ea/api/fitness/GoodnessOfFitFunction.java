package de.evoal.optimisation.ea.api.fitness;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;

import java.util.function.Function;

public interface GoodnessOfFitFunction extends EvoalComponent<GoodnessOfFitFunction>, Function<Properties, Double> {
}
