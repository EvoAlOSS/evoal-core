package de.evoal.surrogate.api.io.pson;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.evoal.languages.model.pipeline.PipelineDefinition;

import de.evoal.core.api.ecore.Space;

/**
 * Configuration of a {@link de.evoal.surrogate.api.function.ModelFunction}.
 */
@Data
public class SurrogateConfiguration {
	/**
	 * Logger
	 */
	private final static Logger log = LoggerFactory.getLogger(SurrogateConfiguration.class);

	@JsonIgnore
	private Space inputData;

	/**
	 * List of required input features
	 */
	private final List<String> inputFeatures = new ArrayList<>();

	/**
	 * Name of the function to use.

	 */
	private String name;

	/**
	 * List of calculated properties.
	 */
	private final List<String> outputFeatures = new ArrayList<>();

	@JsonIgnore
	private Space outputData;

	/**
	 * The precalculated state of the function.
	 */
	private final List<Parameter> state = new ArrayList<>();

	/**
	 * The prediction pipeline.
	 */
	private PipelineDefinition predictionPipeline = null;

	/**
	 * Parameters of inputs
	 */
	private final Map<String, List<Parameter>> inputParameters = new HashMap<>();

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
	/*
        public static PartialFunctionConfiguration from(final PartialSurrogateFunctionDefinition definition, final Map<DataDescription, EStructuralFeature> featureMap, final AttributeEvaluator evaluator) {
            log.info("Create partial function configuration from {}.", definition.getDefinition().getName());

            final PartialFunctionConfiguration configuration = new PartialFunctionConfiguration();
            configuration.setName(definition.getDefinition().getName());

            final List<EStructuralFeature> inputFeatures = collect(definition.getInputs(), featureMap);
            final List<EStructuralFeature> outputFeatures = collect(definition.getOutputs(), featureMap);

            final Space inputs = new Space(eClassOf(inputFeatures), inputFeatures);
            final Space outputs = new Space(eClassOf(outputFeatures), outputFeatures);

            log.info("  from {}.", inputs);
            log.info("  to {}.", outputs);

            configuration.setInputData(inputs);
            configuration.setOutputData(outputs);

            definition.getAttributes()
                      .stream()
                      .map(a -> Parameter.from(a, evaluator))
                      .forEach(p -> configuration.getParameters().add(p));

            return configuration;
        }
    */

	public static SurrogateConfiguration from(final SurrogateConfiguration config) {
		final SurrogateConfiguration configuration = new SurrogateConfiguration();
		configuration.setName(config.getName());

		configuration.setInputData(config.getInputData());
		configuration.setOutputData(config.getOutputData());
/*
		config.getHyperParameters()
			  .stream()
			  .map(Parameter::from)
			  .forEach(p -> configuration.getHyperParameters().add(p));
*/
		return configuration;
	}


	public void setInputData(final Space spec) {
		inputFeatures.clear();

		inputData = spec;
		spec.stream()
			.map(EStructuralFeature::getName)
			.forEach(inputFeatures::add);
	}

	public void setOutputData(final Space spec) {
		outputFeatures.clear();

		outputData = spec;
		spec.stream()
			.map(EStructuralFeature::getName)
			.forEach(outputFeatures::add);
	}

	@Override
	public String toString() {
		return "SurrogateConfiguration [" + name + "(" + inputData + "): " + outputData + "]";
	}
}
