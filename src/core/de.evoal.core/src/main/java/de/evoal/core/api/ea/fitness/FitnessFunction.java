package de.evoal.core.api.ea.fitness;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.instance.Instance;

import java.util.function.Function;

/**
 * A fitness function calculates a list of doubles for a given individual,
 *   expressing some kind of similarity measures.
 */
public interface FitnessFunction extends Function<Properties, double []> {
    public default double [] apply(final Properties properties) {
        return evaluate(properties);
    }

    public double [] evaluate(final Properties properties);

    FitnessFunction init(final Instance config);
}
