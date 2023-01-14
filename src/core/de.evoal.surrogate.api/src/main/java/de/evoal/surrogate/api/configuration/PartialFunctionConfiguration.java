package de.evoal.surrogate.api.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import lombok.Data;
import org.eclipse.emf.common.util.EList;

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
	@JsonIgnore
	private PropertiesSpecification inputData;

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

	@JsonIgnore
	private PropertiesSpecification outputData;

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

		final List<DataDescription> inputs = definition.getInputs();
		final List<DataDescription> outputs = definition.getOutputs();

		configuration.setInputData(PropertiesSpecification.builder().add(inputs.stream()).build());
		configuration.setOutputData(PropertiesSpecification.builder().add(outputs.stream()).build());

		definition.getParameters()
				  .stream()
				  .map(Parameter::from)
				  .forEach(p -> configuration.getParameters().add(p));

		return configuration;
	}

	public static PartialFunctionConfiguration from(final PartialFunctionConfiguration config) {
		final PartialFunctionConfiguration configuration = new PartialFunctionConfiguration();
		configuration.setName(config.getName());

		configuration.setInputData(config.getInputData());
		configuration.setOutputData(config.getOutputData());

		config.getParameters()
			  .stream()
			  .map(Parameter::from)
			  .forEach(p -> configuration.getParameters().add(p));

		return configuration;
	}


	protected void setInputData(final PropertiesSpecification spec) {
		inputData = PropertiesSpecification.builder().add(spec).build();

		spec.getProperties()
			.stream()
			.map(PropertySpecification::name)
			.forEach(inputDimensions::add);
	}

	protected void setOutputData(final PropertiesSpecification spec) {
		outputData = PropertiesSpecification.builder().add(spec).build();

		spec.getProperties()
			.stream()
			.map(PropertySpecification::name)
			.forEach(outputDimensions::add);
	}
}
