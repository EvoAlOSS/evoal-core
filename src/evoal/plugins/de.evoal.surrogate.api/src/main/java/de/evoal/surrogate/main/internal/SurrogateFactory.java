package de.evoal.surrogate.main.internal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.PartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.properties.PropertiesSpecification;

/**
 * Factory class for surrogate functions.
 */
@Slf4j
public final class SurrogateFactory {

	/**
	 * Name of the surrogate configuration.
	 */
	@Getter
	private final SurrogateConfiguration config;

	/**
	 * Training points used.
	 */
	private final PropertiesStreamSupplier factory;

	/**
	 * Called to train model based on trainings points, e.g. during initial model training.
	 */
	public static SurrogateFunction create(final @NonNull SurrogateConfiguration config, final PropertiesStreamSupplier trainingPoints) {
		final List<PartialSurrogateFunction> functions =
				config.getFunctions()
						  .stream()
						  //.map(func -> createLayerFunction(func, trainingPoints, null))
						  .map(func -> create(func, func.getInputData(), func.getOutputData(), trainingPoints))
						  .collect(Collectors.toList());

		return new SurrogateFunction(functions);
	}

	/**
	 * Creates a surrogate function based on a pre-loaded model.
	 */
	public static SurrogateFunction create(final @NonNull SurrogateConfiguration config, final PropertiesSpecification specification) {
		final List<PartialSurrogateFunction> functions =
				config.getFunctions()
						.stream()
						//.map(func -> createLayerFunction(func, null, specification))
						.map(func -> create(func, specification, func.getOutputData(), null))
						.collect(Collectors.toList());

		return new SurrogateFunction(functions);
	}

	private static PropertiesSpecification mergeSpecifications(final Stream<PropertiesSpecification> stream) {
		final PropertiesSpecification.Builder builder = PropertiesSpecification.builder();

		stream.forEach(builder::add);

		return builder.build();
	}

	/**
	 * Internal training function, e.g., used by GoF calculation or from within this factory.
	 */
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
