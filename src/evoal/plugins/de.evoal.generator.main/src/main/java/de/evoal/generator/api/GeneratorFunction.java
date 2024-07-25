package de.evoal.generator.api;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
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

    /**
     * Returns the specification properties read by the generator function.
     */
    PropertiesSpecification getReadSpecification();

    /**
     * Returns the specification properties written by the generator function.
     */
    PropertiesSpecification getWriteSpecification();
}
