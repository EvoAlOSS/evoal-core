package de.evoal.generator.api;


import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.generator.Step;

/**
 * Interface for all generator functions. A generator function is a named CDI
 *   component with a pre-defined life-cycle.
 */
public interface GeneratorFunction {
    GeneratorFunction init(final Step configuration);

    public Properties apply(final Properties in);
}
