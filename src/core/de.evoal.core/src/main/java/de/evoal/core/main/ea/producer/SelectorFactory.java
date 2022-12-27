package de.evoal.core.main.ea.producer;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.instance.Instance;
import io.jenetics.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class SelectorFactory {

	@Produces
	@Named("survivor")
	public Selector createSurvivorSelector(
			@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.selectors.survivor.name") final String name,
			@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.selectors.survivor") Instance config) {
		return create(name, config);
	}

	@Produces @Named("offspring")
	public Selector createOffspringSelector(
			@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.selectors.offspring.name") final String name,
			@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.selectors.offspring") Instance config) {
		return create(name, config);
	}

	private <G extends Gene<?, G>, C extends Comparable<? super C>> Selector<G, C> create(final String name, final Instance config) {
		switch(name) {
			case "elite_selector": return createEliteSelector(config);
			case "monte_carlo_selector": return createMonteCarloSelector(config);
			case "exponential_rank_selector": return createExponentialRankSelector(config);
			case "linear_rank_selector": return createLinearRankSelector(config);
			case "boltzmann_selector": return createBoltzmannSelector(config);
			case "probability_selector": return createProbabilitySelector(config);
			case "stochastic_universal_selector": return createStochasticUniversalSelector(config);
			case "tournament_selector": return createTournamentSelector(config);
			case "truncation_selector": return createTruncationSelector(config);
			
		}
		throw new IllegalStateException("Selector '" + name + "' is unknown.");
	}
	
	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createBoltzmannSelector(final Instance config) {
		double beta = LanguageHelper.lookup(config, "beta");

		return (Selector<G,C>) new BoltzmannSelector<>(beta);
	}

	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createExponentialRankSelector(final Instance config) {
		// TODO Auto-generated method stub
		return null;
	}

	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createTruncationSelector(final Instance config) {
		int worstRank = LanguageHelper.lookup(config, "worstRank");
		return new TruncationSelector<>(worstRank);
	}

	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createTournamentSelector(final Instance config) {
		int sampleSize = LanguageHelper.lookup(config, "size");
		return new TournamentSelector<>(sampleSize);
	}

	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createStochasticUniversalSelector(final Instance config) {
		
		return (Selector<G,C>) new StochasticUniversalSelector<>();
	}

	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createProbabilitySelector(final Instance config) {
		// TODO Auto-generated method stub
		return null;
	}

	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createLinearRankSelector(final Instance config) {
		Integer nminus = LanguageHelper.lookup(config, "nminus");
		if(nminus == null) {
			throw new IllegalStateException("'" + nminus + "' is not defined.");
		}
		else return new LinearRankSelector<>(nminus);
	}

	private static <G extends Gene<?,G>, C extends Comparable<? super C>> Selector<G, C> createMonteCarloSelector(final Instance config) {
		return new MonteCarloSelector<>();
	}

	private <G extends Gene<?,G>, C extends Comparable<? super C>> EliteSelector<G,C> createEliteSelector(final Instance config) {
		
		int count = LanguageHelper.lookup(config, "count");
		final Instance nonEliteSelectorConfig = LanguageHelper.lookup(config, "nonEliteSelector");
		
		if(nonEliteSelectorConfig == null) {
			return new EliteSelector<>(count);
		}
		else {
			Selector<G,C> nonEliteSelector = create(LanguageHelper.lookup(nonEliteSelectorConfig, "name"), nonEliteSelectorConfig);
			return new EliteSelector<>(count, nonEliteSelector);
		}
	}
}
