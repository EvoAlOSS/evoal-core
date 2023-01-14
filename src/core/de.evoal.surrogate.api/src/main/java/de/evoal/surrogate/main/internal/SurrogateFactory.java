package de.evoal.surrogate.main.internal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.surrogate.api.configuration.FunctionCombinerConfiguration;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.FunctionCombiner;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.PartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.properties.PropertiesSpecification;

/**
 * Factory class for predictive functions.
 */
@Slf4j
public final class SurrogateFactory {

	/**
	 * Name of the predictive file
	 */
	@Getter
	private final SurrogateConfiguration config;

	/**
	 * Training points used
	 */
	private final PropertiesStreamSupplier factory;

	public static SurrogateFunction create(final @NonNull SurrogateConfiguration config, final PropertiesStreamSupplier trainingPoints) {
		final List<FunctionCombiner> functions =
				config.getMappings()
						  .stream()
						  .map(layer -> createLayerFunction(layer, trainingPoints))
						  .collect(Collectors.toList());

		return new SurrogateFunction(functions);
	}

	private static FunctionCombiner createLayerFunction(final FunctionCombinerConfiguration config, final PropertiesStreamSupplier trainingPoints) {
		log.info("Creating mapping function for level {}.", config.getName());

		final List<PartialFunctionConfiguration> subConfiguration = config.getFunctions();

		// map source values to properties
		final PropertiesSpecification sourceSpecification =
				mergeSpecifications(subConfiguration.stream()
													.map(PartialFunctionConfiguration::getInputData));

		// map source values to properties
		final PropertiesSpecification targetSpecification =
				mergeSpecifications(subConfiguration.stream()
													.map(PartialFunctionConfiguration::getOutputData));

		final List<PartialSurrogateFunction> subFunctions = createFunctions(subConfiguration, sourceSpecification, targetSpecification, trainingPoints);

		return new FunctionCombiner(subFunctions, sourceSpecification, targetSpecification);
	}

	private static PropertiesSpecification mergeSpecifications(final Stream<PropertiesSpecification> stream) {
		final PropertiesSpecification.Builder builder = PropertiesSpecification.builder();

		stream.forEach(builder::add);

		return builder.build();
	}

	private static List<PartialSurrogateFunction> createFunctions(final List<PartialFunctionConfiguration> configurations, final PropertiesSpecification source, final PropertiesSpecification target, final PropertiesStreamSupplier trainingPoints) {
		// create regression functions from configuration
		final List<PartialSurrogateFunction> functions = new ArrayList<>(configurations.size());

		for(final PartialFunctionConfiguration config : configurations) {
			functions.add(create(config, source, target, trainingPoints));
		}
		
		return functions;
	}

	public static PartialSurrogateFunction create(final PartialFunctionConfiguration config, final PropertiesSpecification source, final PropertiesSpecification target, final PropertiesStreamSupplier trainingPoints) {
		log.info("Calculating mapping function '{}'.", config.getName());
		final PropertiesSpecification functionTargetSpecification = config.getOutputData();
		final PropertiesSpecification functionSourceSpecification = config.getInputData();

		final PartialSurrogateFunctionFactory factory = BeanFactory.create(config.getName(), PartialSurrogateFunctionFactory.class);
		return factory.create(config, source, functionSourceSpecification, functionTargetSpecification, trainingPoints);
	}

	public SurrogateFactory(final SurrogateConfiguration config, final PropertiesStreamSupplier factory) {
		this.config = config;
		this.factory = factory;
	}

	public SurrogateFunction create() {
		return create(config, factory);
	}
}
