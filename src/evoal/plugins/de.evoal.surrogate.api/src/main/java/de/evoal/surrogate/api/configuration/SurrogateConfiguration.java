package de.evoal.surrogate.api.configuration;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.mll.SurrogateDefinition;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.Data;

import java.util.*;

/**
 * Configuration of a {@link SurrogateFunction}.
 */
@Data
public class SurrogateConfiguration {
	/**
	 * List of functions within this mapping.
	 */
	private List<PartialFunctionConfiguration> functions = new ArrayList<>();

	/**
	 * Parameters of outputs
	 */
	private final Map<String, List<Parameter>> outputParameters = new HashMap<>();

	private SurrogateConfiguration() {
	}

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

	public static SurrogateConfiguration from(final SurrogateDefinition definition, final AttributeEvaluator evaluator) {
		final SurrogateConfiguration configuration = new SurrogateConfiguration();

		definition.getFunctions()
				  .stream()
				  .map(d -> PartialFunctionConfiguration.from(d, evaluator))
				  .forEach(configuration.functions::add);

		return configuration;
    }

	public static SurrogateConfiguration from(final SurrogateConfiguration original) {
		final SurrogateConfiguration configuration = new SurrogateConfiguration();

		original.getFunctions()
				.stream()
				.map(PartialFunctionConfiguration::from)
				.forEach(configuration.functions::add);

		return configuration;
	}

	public static List<DataDescription> getInputs(final SurrogateConfiguration configuration) {
		final Set<DataDescription> inputs = new HashSet<>();

		return configuration.functions
							.stream()
							.flatMap(f -> f.getInputData().getProperties().stream())
							.filter(spec -> !inputs.contains(spec.type()))
							.map(PropertySpecification::type)
							.map(DataDescription.class::cast)
							.peek(inputs::add)
							.toList();
	}

	public static List<DataDescription> getOutputs(final SurrogateConfiguration configuration) {
		final Set<DataDescription> outputs = new HashSet<>();

		return configuration.functions
				.stream()
				.flatMap(f -> f.getOutputData().getProperties().stream())
				.filter(spec -> !outputs.contains(spec.type()))
				.map(PropertySpecification::type)
				.map(DataDescription.class::cast)
				.peek(outputs::add)
				.toList();
	}

	/**
	 * @Deprecated
	 */
	public static List<DataDescription> getInputs(final List<PartialSurrogateFunction> configurations) {
		final Set<DataDescription> inputs = new HashSet<>();

		return configurations
				.stream()
				.flatMap(f -> f.getUsedProperties().getProperties().stream())
				.filter(spec -> !inputs.contains(spec.type()))
				.map(PropertySpecification::type)
				.map(DataDescription.class::cast)
				.peek(inputs::add)
				.toList();
	}

	/**
	 * @Deprecated
	 */
	public static List<DataDescription> getOutputs(final List<PartialSurrogateFunction> configurations) {
		final Set<DataDescription> outputs = new HashSet<>();

		return configurations
				.stream()
				.flatMap(f -> f.getOutputProperty().getProperties().stream())
				.filter(spec -> !outputs.contains(spec.type()))
				.map(PropertySpecification::type)
				.map(DataDescription.class::cast)
				.map(DataDescription.class::cast)
				.peek(outputs::add)
				.toList();
	}
}
