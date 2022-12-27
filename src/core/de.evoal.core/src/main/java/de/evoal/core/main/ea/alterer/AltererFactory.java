package de.evoal.core.main.ea.alterer;

import java.util.function.BiFunction;

import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.core.main.ea.alterer.crossover.*;
import de.evoal.core.main.ea.alterer.internal.MeanCorrelationAlterer;
import de.evoal.core.main.ea.alterer.mutator.SingleBitFlipCorrelationMutator;
import de.evoal.core.main.ea.alterer.mutator.SingleBitFlipMutator;
import de.evoal.core.main.ea.alterer.mutator.SwapCorrelationMutator;
import de.evoal.core.main.ea.model.Correlations;
import de.evoal.languages.model.instance.Instance;
import de.evoal.core.api.utils.LanguageHelper;
import io.jenetics.*;
import io.jenetics.util.Mean;
import javax.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@ApplicationScoped
@Slf4j
public class AltererFactory {

	@Inject
	private Correlations correlations;

	@Inject
	private BiFunction<Double, Double, Alterer> factory;

	/**
	 * Creates an alterer based on the heuristic configuration.
	 *
	 * Blackboard slots used:
	 * <ul>
	 *   <li>None</li>
	 * </ul>
	 */
	public <G extends Gene<?, G>> Alterer<G, FitnessValue> create(final Instance config) {
		final String name = LanguageHelper.lookup(config, "name");

		log.info("Creating alterer with name '{}'.", name);

		switch(name) {
			//case "CompositeAlterer": return createCompositeAlterer(config);
			case "mean_alterer": return createMeanAlterer(config);
			case "correlation_mean_alterer": return (Alterer<G, FitnessValue>) createCorrelationMeanAlterer(config);
			case "partial_matched_alterer": return createPartiallyMatchedAlterer(config);
			case "correlation_partial_matched_alterer": return createCorrelationPartiallyMatchedAlterer(config);

			case "gaussian_mutator": return createGaussianMutator(config);
			case "correlation_gaussian_mutator": return createGaussianCorrelationMutator(config);
			case "swap_mutator": return createSwapMutator(config);
			case "correlation_swap_mutator": return createCorrelationSwapMutator(config);
			case "bit_flip_mutator": return createBitFlipMutator(config);
			case "correlation_bit_flip_mutator": return createCorrelationBitFlipMutator(config);

//			case "IntermediateCrossover": return createIntermediateCrossover(config);
			case "line_crossover": return createLineCrossover(config);
			case "correlation_line_crossover": return createCorrelationLineCrossover(config);
			case "multi_point_crossover": return createMultiPointCrossover(config);
			case "correlation_multi_point_crossover": return createCorrelationMultiPointCrossover(config);
			case "single_point_crossover": return createSinglePointCrossover(config);
			case "correlation_single_point_crossover": return createCorrelationSinglePointCrossover(config);
			case "uniform_crossover": return createUniformCrossover(config);
			case "correlation_uniform_crossover": return createCorrelationUniformCrossover(config);
		}
		throw new IllegalStateException("Selector '" + name + "' is unknown.");
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createUniformCrossover(final Instance config) {
		final Double crossoverProbability = LanguageHelper.lookup(config, "crossover_probability");
		final Double swapProbability = LanguageHelper.lookup(config,"swap_probability");

		return new UniformCrossover<>(crossoverProbability, swapProbability);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createCorrelationUniformCrossover(final Instance config) {
		final Double crossoverProbability = LanguageHelper.lookup(config, "crossover_probability");
		final Double swapProbability = LanguageHelper.lookup(config,"swap_probability");
		
		return new UniformCorrelationCrossover(crossoverProbability, swapProbability, correlations);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createBitFlipMutator (final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return new SingleBitFlipMutator(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createCorrelationBitFlipMutator (final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double threshold = LanguageHelper.lookup(config, "threshold");

		return new SingleBitFlipCorrelationMutator(probability, threshold, correlations);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createSwapMutator (final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return new SwapMutator<>(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createCorrelationSwapMutator (final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double threshold = LanguageHelper.lookup(config, "threshold");

		return new SwapCorrelationMutator<>(probability, threshold, correlations);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createSinglePointCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return new SinglePointCrossover<>(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createCorrelationSinglePointCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return new SinglePointCorrelationCrossover(probability, correlations);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createPartiallyMatchedAlterer(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return (Alterer<G, FitnessValue>) new PartiallyMatchedCrossover(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createCorrelationPartiallyMatchedAlterer(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return (Alterer<G, FitnessValue>) new PartiallyMatchedCorrelationCrossover<G, FitnessValue>(probability, correlations);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createMultiPointCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Integer count = LanguageHelper.lookup(config, "count");

		return new MultiPointCrossover<>(probability, count);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createCorrelationMultiPointCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Integer count = LanguageHelper.lookup(config, "count");

		return new MultiPointCorrelationCrossover<>(probability, count, correlations);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createMeanAlterer(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return  (Alterer<G, FitnessValue>) new MeanAlterer(probability);
	}

	private <G extends NumericGene<?, G> & Mean<G>> Alterer<G, FitnessValue> createCorrelationMeanAlterer(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return  (Alterer<G, FitnessValue>) new MeanCorrelationAlterer<G, FitnessValue>(probability, correlations);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createLineCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double position = LanguageHelper.lookup(config, "position");

		return new LineCrossover(probability, position);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createCorrelationLineCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double position = LanguageHelper.lookup(config, "position");

		return new LineCorrelationCrossover(probability, position, correlations);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createIntermediateCrossover(final Instance config) {
		throw new IllegalStateException("Unsupported alterer.");
	}

	private <G extends Gene<?,G>> Alterer<G, FitnessValue> createGaussianMutator(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		
		return  new GaussianMutator(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createGaussianCorrelationMutator(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double threshold = LanguageHelper.lookup(config, "threshold");

		return factory.apply(probability, threshold);
	}

	private <G extends Gene<?, G>> Alterer<G, FitnessValue> createCompositeAlterer(final Instance config) {
		throw new IllegalStateException("Unsupported alterer.");
	}
}
