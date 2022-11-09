package de.evoal.surrogate.api.configuration;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Configuration of a {@link PartialSurrogateFunction}.
 */
@Data
public class PartialFunctionConfiguration {
	/**
	 * List of required input dimensions
	 */
	private final List<String> inputDimensions = new ArrayList<>();

	/**
	 * Name of the function to use.

	 */
	private String name;

	/**
	 * List of calculated properties.
	 */
	private final List<String> outputDimensions = new ArrayList<>();

	/**
	 * Function-specific configuration parameters.
	 */
	private final List<Parameter> parameters = new ArrayList<>();

	/**
	 * The precalculated state of the function.
	 */
	private final List<Parameter> state = new ArrayList<>();

	/**
	 * Parameters of outputs
	 */
	private final Map<String, List<Parameter>> outputParameters = new HashMap<>();

	public void addOutputParameter(final String name, final Parameter parameter) {
		List<Parameter> content = outputParameters.get(name);

		if(content == null) {
			content = new ArrayList<>();
			content.add(parameter);
			outputParameters.put(name, content);
		} else {
			content.add(parameter);
		}
	}

	public static PartialFunctionConfiguration from(final PartialSurrogateFunctionDefinition definition) {
		final PartialFunctionConfiguration configuration = new PartialFunctionConfiguration();
		configuration.setName(definition.getName().getName());

		final List<String> inputs =
				definition.getInputs()
  						  .stream()
						  .map(DataDescription::getName)
						  .collect(Collectors.toList());

		final List<String> outputs =
				definition.getOutputs()
						  .stream()
						  .map(DataDescription::getName)
						  .collect(Collectors.toList());

		configuration.getInputDimensions().addAll(inputs);
		configuration.getOutputDimensions().addAll(outputs);

		definition.getParameters()
				  .stream()
				  .map(Parameter::from)
				  .forEach(p -> configuration.getParameters().add(p));

		return configuration;
	}

	public static PartialFunctionConfiguration from(final PartialFunctionConfiguration config) {
		final PartialFunctionConfiguration configuration = new PartialFunctionConfiguration();
		configuration.setName(config.getName());

		configuration.getInputDimensions()
					 .addAll(config.getInputDimensions());
		configuration.getOutputDimensions()
					 .addAll(config.getOutputDimensions());

		config.getParameters()
			  .stream()
			  .map(Parameter::from)
			  .forEach(p -> configuration.getParameters().add(p));

		return configuration;
	}
}
