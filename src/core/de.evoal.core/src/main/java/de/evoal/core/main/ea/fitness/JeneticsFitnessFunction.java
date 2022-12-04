package de.evoal.core.main.ea.fitness;

import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.core.api.properties.Properties;

import java.util.function.Function;

public interface JeneticsFitnessFunction extends Function<Properties, FitnessValue> {
}
