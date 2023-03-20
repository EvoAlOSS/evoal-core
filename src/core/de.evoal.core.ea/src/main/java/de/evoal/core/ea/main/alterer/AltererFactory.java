package de.evoal.core.ea.main.alterer;

import java.util.function.BiFunction;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.ea.api.codec.CustomCodec;
import de.evoal.core.ea.main.alterer.internal.MeanCorrelationAlterer;
import de.evoal.core.ea.main.alterer.mutator.SingleBitFlipMutator;
import de.evoal.core.ea.main.alterer.crossover.*;
import de.evoal.core.ea.main.alterer.mutator.SingleBitFlipCorrelationMutator;
import de.evoal.core.ea.main.alterer.mutator.SwapCorrelationMutator;
import de.evoal.core.api.correlations.Correlations;
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

	@Inject
	private CustomCodec codec;

	/**
	 * Creates an alterer based on the heuristic configuration.
	 *
	 * Blackboard slots used:
	 * <ul>
	 *   <li>None</li>
	 * </ul>
	 */
	public <G extends Gene<?, G>> Alterer<G, OptimisationValue> create(final Instance config) {
		final String name = LanguageHelper.lookup(config, "name");

		log.info("Creating alterer with name '{}'.", name);

		switch(name) {
			//case "CompositeAlterer": return createCompositeAlterer(config);
			case "mean-alterer": return createMeanAlterer(config);
			case "correlation-mean-alterer": return (Alterer<G, OptimisationValue>) createCorrelationMeanAlterer(config);
			case "partial-matched-alterer": return createPartiallyMatchedAlterer(config);
			case "correlation-partial-matched-alterer": return createCorrelationPartiallyMatchedAlterer(config);

			case "gaussian-mutator": return createGaussianMutator(config);
			case "correlation-gaussian-mutator": return createGaussianCorrelationMutator(config);
			case "swap-mutator": return createSwapMutator(config);
			case "correlation-swap-mutator": return createCorrelationSwapMutator(config);
			case "bit-flip-mutator": return createBitFlipMutator(config);
			case "correlation-bit-flip-mutator": return createCorrelationBitFlipMutator(config);

//			case "IntermediateCrossover": return createIntermediateCrossover(config);
			case "line-crossover": return createLineCrossover(config);
			case "correlation-line-crossover": return createCorrelationLineCrossover(config);
			case "multi-point-crossover": return createMultiPointCrossover(config);
			case "correlation-multi-point-crossover": return createCorrelationMultiPointCrossover(config);
			case "single-point-crossover": return createSinglePointCrossover(config);
			case "correlation-single-point-crossover": return createCorrelationSinglePointCrossover(config);
			case "uniform-crossover": return createUniformCrossover(config);
			case "correlation-uniform-crossover": return createCorrelationUniformCrossover(config);
		}
		throw new IllegalStateException("Selector '" + name + "' is unknown.");
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createUniformCrossover(final Instance config) {
		final Double crossoverProbability = LanguageHelper.lookup(config, "crossover-probability");
		final Double swapProbability = LanguageHelper.lookup(config,"swap-probability");

		return new UniformCrossover<>(crossoverProbability, swapProbability);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createCorrelationUniformCrossover(final Instance config) {
		final Double crossoverProbability = LanguageHelper.lookup(config, "crossover-probability");
		final Double swapProbability = LanguageHelper.lookup(config,"swap-probability");
		
		return new UniformCorrelationCrossover(crossoverProbability, swapProbability, correlations, codec);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createBitFlipMutator (final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return new SingleBitFlipMutator(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createCorrelationBitFlipMutator (final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double threshold = LanguageHelper.lookup(config, "threshold");

		return new SingleBitFlipCorrelationMutator(probability, threshold, correlations, codec);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createSwapMutator (final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return new SwapMutator<>(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createCorrelationSwapMutator (final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double threshold = LanguageHelper.lookup(config, "threshold");

		return new SwapCorrelationMutator<>(probability, threshold, correlations, codec);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createSinglePointCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return new SinglePointCrossover<>(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createCorrelationSinglePointCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return new SinglePointCorrelationCrossover(probability, correlations, codec);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createPartiallyMatchedAlterer(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return (Alterer<G, OptimisationValue>) new PartiallyMatchedCrossover(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createCorrelationPartiallyMatchedAlterer(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return (Alterer<G, OptimisationValue>) new PartiallyMatchedCorrelationCrossover<G, OptimisationValue>(probability, correlations, codec);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createMultiPointCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Integer count = LanguageHelper.lookup(config, "count");

		return new MultiPointCrossover<>(probability, count);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createCorrelationMultiPointCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Integer count = LanguageHelper.lookup(config, "count");

		return new MultiPointCorrelationCrossover<>(probability, count, correlations, codec);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createMeanAlterer(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return  (Alterer<G, OptimisationValue>) new MeanAlterer(probability);
	}

	private <G extends NumericGene<?, G> & Mean<G>> Alterer<G, OptimisationValue> createCorrelationMeanAlterer(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");

		return new MeanCorrelationAlterer<G, OptimisationValue>(probability, correlations, codec);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createLineCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double position = LanguageHelper.lookup(config, "position");

		return new LineCrossover(probability, position);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createCorrelationLineCrossover(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double position = LanguageHelper.lookup(config, "position");

		return new LineCorrelationCrossover(probability, position, correlations, codec);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createIntermediateCrossover(final Instance config) {
		throw new IllegalStateException("Unsupported alterer.");
	}

	private <G extends Gene<?,G>> Alterer<G, OptimisationValue> createGaussianMutator(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		
		return  new GaussianMutator(probability);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createGaussianCorrelationMutator(final Instance config) {
		final Double probability = LanguageHelper.lookup(config, "probability");
		final Double threshold = LanguageHelper.lookup(config, "threshold");

		return factory.apply(probability, threshold);
	}

	private <G extends Gene<?, G>> Alterer<G, OptimisationValue> createCompositeAlterer(final Instance config) {
		throw new IllegalStateException("Unsupported alterer.");
	}
}
