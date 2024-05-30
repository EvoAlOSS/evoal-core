package de.evoal.core.ea.main.selector;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.ea.api.operators.AltererComponent;
import de.evoal.core.ea.api.operators.AltererComponentProvider;
import de.evoal.core.ea.api.operators.SelectorComponent;
import de.evoal.core.ea.api.operators.SelectorComponentProvider;
import de.evoal.core.ea.main.comparator.ParetoOptimisationValue;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.dl.util.FQNProvider;
import io.jenetics.*;
import io.jenetics.ext.moea.NSGA2Selector;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Slf4j
public class SelectorFactory {
	@Inject
	private LanguageHelper helper;

	@Inject
	@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.size-of-population")
	private int sizeOfPopulation;

	@Produces
	@Named("survivor")
	public Selector createSurvivorSelector(
			@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.selectors.survivor.name") final String name,
			@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.selectors.survivor") Instance config) {
		return create(name, config);
	}

	@Produces @Named("offspring")
	public Selector createOffspringSelector(
			@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.selectors.offspring.name") final String name,
			@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.selectors.offspring") Instance config) {
		return create(name, config);
	}

	public <G extends Gene<?, G>, C extends Comparable<? super C>> Selector<G, C> create(final String name, final Instance config) {
		switch(name) {
			case "elite-selector": return createEliteSelector(config);
			case "monte-carlo-selector": return createMonteCarloSelector(config);
			case "stochastic-universal-selector": return createStochasticUniversalSelector(config);
			case "tournament-selector": return createTournamentSelector(config);
			case "truncation-selector": return createTruncationSelector(config);

			case "nsga2-selector": return createNSGA2Selector(config);

			/* probability-based selectors */
			case "boltzmann-selector": return createBoltzmannSelector(config);
			case "exponential-rank-selector": return createExponentialRankSelector(config);
			case "linear-rank-selector": return createLinearRankSelector(config);
			case "roulette-wheel-selector": return createRouletteWheelSelector(config);
		}

		try {
			return BeanFactory.createComponent(SelectorComponent.class, config);
		} catch(final IllegalStateException e) {
			return BeanFactory.createComponentUsingProvider(SelectorComponentProvider.class, config);
		}
	}

	private <G extends Gene<?, G>, C extends Comparable<? super C>> Selector<G, C> createNSGA2Selector(final Instance config) {
		return (Selector<G, C>) new NSGA2Selector<>(ParetoOptimisationValue.dominance(),
				ParetoOptimisationValue.compare(),
				ParetoOptimisationValue.distance(),
				ParetoOptimisationValue.dimension()
				);
	}

	private <G extends Gene<?, G>, C extends Comparable<? super C>> Selector<G,C> createRouletteWheelSelector(final Instance config) {
		return (Selector<G,C>) new RouletteWheelSelector<>();
	}

	private <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createBoltzmannSelector(final Instance config) {
		final Double beta = helper.lookup(config, "beta");

		return (Selector<G,C>) new BoltzmannSelector<>(beta);
	}

	private <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createExponentialRankSelector(final Instance config) {
		final Double c = helper.lookup(config, "c");

		return new ExponentialRankSelector<>(c);
	}

	private <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createTruncationSelector(final Instance config) {
		int worstRank = helper.lookup(config, "worst-rank");
		return new TruncationSelector<>(worstRank);
	}

	private <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createTournamentSelector(final Instance config) {
		int count = (int)(helper.<Double>lookup(config, "size-factor") * sizeOfPopulation);
		return new TournamentSelector<>(count);
	}

	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createStochasticUniversalSelector(final Instance config) {
		return (Selector<G,C>) new StochasticUniversalSelector<>();
	}

	private <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createLinearRankSelector(final Instance config) {
		Integer nminus = helper.lookup(config, "nminus");
		if(nminus == null) {
			throw new IllegalStateException("'" + nminus + "' is not defined.");
		}
		else return new LinearRankSelector<>(nminus);
	}

	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createMonteCarloSelector(final Instance config) {
		return new MonteCarloSelector<>();
	}

	private <G extends Gene<?,G>, C extends Comparable<? super C>> EliteSelector<G,C> createEliteSelector(final Instance config) {
		int count = (int)(helper.<Double>lookup(config, "size-factor") * sizeOfPopulation);
		final Instance nonEliteSelectorConfig = helper.lookup(config, "non-elite-selector");

		if(nonEliteSelectorConfig == null) {
			return new EliteSelector<>(count);
		} else {
			Selector<G,C> nonEliteSelector = create(helper.lookup(nonEliteSelectorConfig, "name"), nonEliteSelectorConfig);
			return new EliteSelector<>(count, nonEliteSelector);
		}
	}
}
