package de.evoal.surrogate.api.configuration;

import de.evoal.core.api.ecore.misc.SpaceHelper;
import lombok.Data;

import java.util.*;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.mll.SurrogateDefinition;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration of a {@link SurrogateFunction}.
 */
@Data
public class SurrogateConfiguration {
	/**
	 * Logger
	 */
	private final static Logger log = LoggerFactory.getLogger(SurrogateConfiguration.class);

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

	public void link(final Space space) {
		functions.forEach(f -> f.link(space));
	}

	public static SurrogateConfiguration from(final SurrogateDefinition definition, final Map<DataDescription, EStructuralFeature> featureMap, final AttributeEvaluator evaluator) {
		log.info("Create surrogate configuration from {}.", definition.getName());

		final SurrogateConfiguration configuration = new SurrogateConfiguration();

		definition.getFunctions()
				  .stream()
				  .map(d -> PartialFunctionConfiguration.from(d, featureMap, evaluator))
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

	@Deprecated
	public static Space getInputs(final SurrogateConfiguration configuration) {
		return SpaceHelper.fromFeatureStream(
				configuration.functions
						.stream()
						.flatMap(f -> f.getInputData().stream())

		);
	}

	@Deprecated
	public static Space getOutputs(final SurrogateConfiguration configuration) {
		return SpaceHelper.fromFeatureStream(
				configuration.functions
						.stream()
						.flatMap(f -> f.getOutputData().stream())

		);
	}

	@Deprecated
	public static Space getInputs(final List<PartialSurrogateFunction> configurations) {
		return SpaceHelper.fromFeatureStream(
				configurations
						.stream()
						.flatMap(f -> f.getUsedProperties().stream())

		);
	}

	@Deprecated
	public static Space getOutputs(final List<PartialSurrogateFunction> configurations) {
		return SpaceHelper.fromFeatureStream(
				configurations
						.stream()
						.flatMap(f -> f.getOutputProperty().stream())

		);
	}
}
