package de.evoal.surrogate.api.function;

import java.util.Collection;

import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;

/**
 * A partial surrogate function calculates only specific properties. Several
 * parallel or chained partial surrogate function make up the complete surrogate
 * function.
 */
public interface PartialSurrogateFunction {
	/**
	 * Applies the regression to {@code input} and returns the calculated
	 *   value.
	 *
	 * @param input The input properties for the regression.
	 * @return The calculated value.
	 */
	public double  [] apply(final Properties input);

	/**
	 * @return The generated property.
	 */
	public PropertiesSpecification getOutputProperty();

	/**
	 * @return A collection of parameters to restore the regression function.
	 */
	public Collection<? extends Parameter> getParameters();

	/**
	 * @return An empty properties vector containing all consumed properties.
	 */
	public PropertiesSpecification getUsedProperties();

	/**
	 * @return The configuration object.
	 */
	public PartialFunctionConfiguration getConfiguration();
}
