package de.evoal.generator.api;


import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.generator.Step;

/**
 * Interface for all generator functions. A generator function is a named CDI
 *   component with a pre-defined life-cycle.
 */
public interface GeneratorFunction {
    Properties apply(final Properties in);

    default GeneratorFunction init(final Step configuration) throws InitializationException {
        return this;
    }
}
