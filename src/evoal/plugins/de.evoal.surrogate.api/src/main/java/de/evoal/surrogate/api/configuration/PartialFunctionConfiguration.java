package de.evoal.surrogate.api.configuration;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration of a {@link PartialSurrogateFunction}.
 */
@Data
public class PartialFunctionConfiguration {
	/**
	 * Logger
	 */
	private final static Logger log = LoggerFactory.getLogger(PartialFunctionConfiguration.class);

	@JsonIgnore
	private Space inputData;

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
	private Space outputData;

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

	private static EClass eClassOf(final List<EStructuralFeature> features) {
		Requirements.requireNotEmpty(features);

		final EClass eClass = features.get(0).getEContainingClass();
		for(final EStructuralFeature feature : features) {
			Requirements.requireEqual(eClass, feature.getEContainingClass());
		}

		return eClass;
	}

	private static List<EStructuralFeature> collect(final EList<DataDescription> descrs, final Map<DataDescription, EStructuralFeature> featureMap) {
		return descrs.stream()
				.map(featureMap::get)
				.toList();
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


	public void setInputData(final Space spec) {
		inputDimensions.clear();

		inputData = spec;
		spec.stream()
			.map(EStructuralFeature::getName)
			.forEach(inputDimensions::add);
	}

	public void setOutputData(final Space spec) {
		outputDimensions.clear();

		outputData = spec;
		spec.stream()
			.map(EStructuralFeature::getName)
			.forEach(outputDimensions::add);
	}

	@Override
	public String toString() {
		return "PartialFunctionConfiguration [" + name + "(" + inputData + "): " + outputData + "]";
	}

	public void link(final Space space) {
		final Map<String, EStructuralFeature> nameToFeature = new HashMap<>();
		space.forEach(f -> nameToFeature.put(f.getName(), f));

		final List<EStructuralFeature> inputs = inputDimensions
				.stream()
				.map(nameToFeature::get)
				.toList();

		inputData = new Space(space.getEClass(), inputs);

		final List<EStructuralFeature> outputs = outputDimensions
				.stream()
				.map(nameToFeature::get)
				.toList();

		outputData = new Space(space.getEClass(), outputs);
	}
}
