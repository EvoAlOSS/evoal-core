package de.evoal.surrogate.api.configuration;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.languages.model.mll.SurrogateDefinition;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Configuration of a {@link SurrogateFunction}.
 */
@Data
public class SurrogateConfiguration {
	/**
	 * List of mappings. At least one.
	 */
	private final List<FunctionCombinerConfiguration> mappings = new ArrayList<>();

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

	public static SurrogateConfiguration from(final SurrogateDefinition definition, final ExpressionEvaluator evaluator) {
		final SurrogateConfiguration configuration = new SurrogateConfiguration();

		definition.getLayers()
				  .stream()
				  .map(d -> FunctionCombinerConfiguration.from(d, evaluator))
				  .forEach(configuration.mappings::add);

		return configuration;
    }

	public static SurrogateConfiguration from(final SurrogateConfiguration original) {
		final SurrogateConfiguration configuration = new SurrogateConfiguration();

		original.getMappings()
				.stream()
				.map(FunctionCombinerConfiguration::from)
				.forEach(configuration.mappings::add);

		return configuration;
	}
}
