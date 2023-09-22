package de.evoal.surrogate.api.function;

import java.util.List;

import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.core.api.properties.PropertiesSpecification;
import lombok.extern.slf4j.Slf4j;

/**
 * Base class for regression factories.
 */
@Slf4j
public abstract class AbstractPartialSurrogateFunctionFactory implements PartialSurrogateFunctionFactory {
	protected abstract PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, PropertiesSpecification producedOutput, final PropertiesPairStreamSupplier provider);

	@Override
	public final PartialSurrogateFunction create(final PartialFunctionConfiguration configuration, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput, final PropertiesStreamSupplier training) {
		if(configuration.getState().isEmpty()) {
			final PropertiesPairStreamSupplier provider = new PropertiesBasedPropertiesPairStreamSupplier(training, requiredInput, producedOutput);
			final PartialSurrogateFunction function = calculateRegression(configuration, configuration.getParameters(), actualInput, requiredInput, producedOutput, provider);
			
			configuration.getState()
					     .addAll(function.getParameters());

			return function;	
		} else {
			return restoreRegression(configuration, actualInput, requiredInput, producedOutput);
		}
	}

	protected abstract PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput);
}
