package de.evoal.surrogate.api.function;

import java.util.List;

import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.core.api.properties.PropertiesSpecification;

/**
 * Base class for regression functions storing the input and output properties.
 */
public abstract class AbstractPartialSurrogateFunction implements PartialSurrogateFunction {
	protected static void addParameter(final String name, final Object value, final List<Parameter> parameters) {
		final Parameter parameter = Parameter.builder()
				.name(name)
				.value(value)
				.build();

		parameters.add(parameter);
	}

	private final PropertiesSpecification input;
	private final PropertiesSpecification output;
	private final PartialFunctionConfiguration configuration;
	private final List<Parameter> parameters;

	public AbstractPartialSurrogateFunction(final PartialFunctionConfiguration configuration, final List<Parameter> functionParameters, final PropertiesSpecification input, final PropertiesSpecification output) {
		this.configuration = configuration;
		this.parameters = functionParameters;
		this.input = input;
		this.output = output;
	}

	@Override
	public PropertiesSpecification getUsedProperties() {
		return input;
	}

	@Override
	public PropertiesSpecification getOutputProperty() {
		return output;
	}

	@Override
	public List<Parameter> getParameters() {
		return parameters;
	}

	public PartialFunctionConfiguration getConfiguration() {
		return configuration;
	}
}
