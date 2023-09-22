package de.evoal.core.ea.main.fitness;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.properties.Properties;

import java.util.function.Function;

public interface JeneticsFitnessFunction extends Function<Properties, OptimisationValue> {
}
