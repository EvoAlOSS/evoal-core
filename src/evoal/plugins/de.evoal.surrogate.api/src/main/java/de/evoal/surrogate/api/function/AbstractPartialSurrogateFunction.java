package de.evoal.surrogate.api.function;

import lombok.Getter;

import java.util.List;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;

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

	/**
	 * Configuration of the partial surrogate function
	 */
	@Getter
	private final PartialFunctionConfiguration configuration;

	/**
	 * Input space of the partial surrogate function.
	 */
	protected final Space input;

	/**
	 * Output space of the partial surrogate function.
	 */
	protected final Space output;

	/**
	 * List of parameters
	 */
	private final List<Parameter> parameters;

	public AbstractPartialSurrogateFunction(final PartialFunctionConfiguration configuration, final List<Parameter> functionParameters, final Space input, final Space output) {
		this.configuration = configuration;
		this.parameters = functionParameters;
		this.input = input;
		this.output = output;
	}

	@Override
	public Space getUsedProperties() {
		return input;
	}

	@Override
	public Space getOutputProperty() {
		return output;
	}

	@Override
	public List<Parameter> getParameters() {
		return parameters;
	}
}
