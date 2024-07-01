package de.evoal.optimisation.ea.main.fitness;

import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.properties.Properties;

import java.util.function.Function;

public interface JeneticsFitnessFunction extends Function<Properties, OptimisationValue> {
}
