package de.evoal.surrogate.api.function;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;

/**
 * Factory for creating regression functions.
 */
public interface PartialSurrogateFunctionFactory {
	/**
	 * Method for creating a regression function.
	 * 
	 * @param configuration Regression configuration.
	 * @param requiredInput The properties that the regression function has to consume.
	 * @param producedOutput  The property that the regression function has to produce.
	 * @param training Training data with target values.
	 *
	 * @return The resulting regression function.
	 */
    PartialSurrogateFunction create(final PartialFunctionConfiguration configuration, final Space requiredInput, final Space producedOutput, final EObjectPairStreamSupplier training);
}
