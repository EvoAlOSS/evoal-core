package de.evoal.surrogate.main.internal;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.PartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.SurrogateFunction;

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
	private final EObjectPairStreamSupplier factory;

	/**
	 * Called to train model based on trainings points, e.g. during initial model training.
	 */
	public static SurrogateFunction create(final @NonNull SurrogateConfiguration config, final EObjectPairStreamSupplier trainingPoints) {
		final List<PartialSurrogateFunction> functions =
				config.getFunctions()
						  .stream()
						  .map(func -> create(func, trainingPoints))
						  .collect(Collectors.toList());

		return new SurrogateFunction(functions);
	}

	/**
	 * Creates a surrogate function based on a pre-loaded model.
	 */
	public static SurrogateFunction create(final @NonNull SurrogateConfiguration config) {
		final List<PartialSurrogateFunction> functions =
				config.getFunctions()
						.stream()
						.map(func -> create(func, null))
						.collect(Collectors.toList());

		return new SurrogateFunction(functions);
	}

	/**
	 * Internal training function, e.g., used by GoF calculation or from within this factory.
	 */
	public static PartialSurrogateFunction create(final PartialFunctionConfiguration config, final EObjectPairStreamSupplier trainingPoints) {
		log.info("Calculating mapping function '{}'.", config.getName());
		final Space functionTargetSpecification = config.getOutputData();
		final Space functionSourceSpecification = config.getInputData();
		log.info("  from '{}' to '{}'.", functionSourceSpecification, functionTargetSpecification);

		final PartialSurrogateFunctionFactory factory = BeanFactory.create(config.getName(), PartialSurrogateFunctionFactory.class);
		return factory.create(config, functionSourceSpecification, functionTargetSpecification, trainingPoints);
	}

	public SurrogateFactory(final SurrogateConfiguration config, final EObjectPairStreamSupplier factory) {
		this.config = config;
		this.factory = factory;
	}

	public SurrogateFunction create() {
		return create(config, factory);
	}
}
