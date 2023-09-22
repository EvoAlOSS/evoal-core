package de.evoal.surrogate.api.function;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;

/**
 * General interface of a functions. It receives some input properties that
 * adhere to the input properties specification and calculates some
 * properties based on the input that adheres to the output properties specification.
 */
public interface MappingFunction {
	/**
	 * Applies the mapping function.
	 */
    Properties apply(final Properties input);

	/**
	 * @return An empty input vector with all property headers set.
	 */
    PropertiesSpecification getInputSpecification();

	/**
	 * @return An empty output vector with all property headers set.
	 */
    PropertiesSpecification getOutputSpecification();
}
