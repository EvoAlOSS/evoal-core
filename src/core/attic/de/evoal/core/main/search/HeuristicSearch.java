package de.evoal.core.main.search;

import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.main.ea.alterer.AltererFactory;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.fitness.type.FitnessType;

import de.evoal.core.api.ea.fitness.FitnessEvaluator;
import de.evoal.core.api.statistics.StatisticsWriter;
import de.evoal.languages.model.eal.EAModel;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.Name;
import de.evoal.languages.model.instance.Value;
import io.jenetics.*;
import io.jenetics.engine.*;
import io.jenetics.stat.MinMax;
import io.jenetics.util.Factory;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.inject.Instance;

import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
public class HeuristicSearch<G extends Gene<?, G>> {
	@Inject
	private Blackboard board;

	/**
	 * Location for storing the output.
	 */
	@Inject
	@BlackboardValue(BlackboardEntry.EVALUATION_OUTPUT_FOLDER)
	private File outputDirectory;

	/**
	 * The actual run
	 */
	@Inject
	@BlackboardValue(BlackboardEntry.EVALUATION_RUN)
	private String run;

	@Inject
	@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.number_of_generations")
	private int numberOfGenerations = 100;

	@Inject
	@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.size_of_population")
	private int sizeOfPopulation = 100;

	@Inject
	@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.maximum_age")
	private int maximumAge = 100;

	private final Map<String, List<Alterer<G, FitnessType>>> alterers = new HashMap<>();

	@Inject
	private CustomCodec encoding;

	private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	@Inject
	@Named("evaluator")
	private FitnessEvaluator fitnessEvaluator;

	@Inject @Named("offspring")
	private Selector offspringSelector;

	@Inject @Named("statistics")
	private StatisticsWriter statistics;

	@Inject @Named("survivor")
	private Selector survivorSelector;

	@Inject
	private AltererFactory factory;

	@Inject
	private Instance<List<Constraint>> constraints;


	@Inject
	private Function<Engine, EvolutionStream> initalStreamFactory;

	public void run() {
		setup();

        final Factory<Genotype<G>> gtf = encoding.encoding();

		final Constraint<G, FitnessType> constraint = new ListConstraint(constraints.get());

        final Engine<G, FitnessType> engine= Engine.builder(this.fitnessEvaluator, encoding)
											.alterers(flattenAltererMap())
											.offspringSelector(this.offspringSelector)
											.survivorsSelector(this.survivorSelector)
											.optimize(Optimize.MAXIMUM)
											.populationSize(sizeOfPopulation)
											.constraint(constraint)
											.maximalPhenotypeAge(maximumAge)
											.executor(executor)
											.build();
        
        EvolutionStatistics<FitnessType, MinMax<FitnessType>> statistics = EvolutionStatistics.ofComparable();
		EvolutionStream<G, FitnessType> initialStream = initalStreamFactory.apply(engine);

        final EvolutionResult<G, FitnessType> result
        		=  initialStream.limit(Limits.byFixedGeneration(numberOfGenerations))
        						.limit(Limits.byExecutionTime(Duration.ofMinutes(5)))
//		        				.parallel()
		        				.peek(this.statistics::add)
		                		.peek(statistics)
        						.collect(EvolutionResult.toBestEvolutionResult());
		this.statistics.write();

		System.out.println(statistics);

        executor.shutdownNow();
	}

	private void setup() {
		final EAModel configuration = board.get(BlackboardEntry.EA_CONFIGURATION);

		final de.evoal.languages.model.instance.Instance alterers = LanguageHelper.lookup(configuration.getInstance(), "algorithm.alterers");

		for(final Attribute category: alterers.getAttributes()) {
			final String name = ((Name)category.getName()).getName().getName();
			log.info("Processing alterer category '{}'.", name);

			final Array array = (Array) category.getValue();

			for(final Value alterer : array.getValues()) {
				this.alterers
						.computeIfAbsent(name, k -> new ArrayList<>())
						.add(factory.create((de.evoal.languages.model.instance.Instance)alterer));
			}
		}


	}

	private Alterer<G, FitnessType> flattenAltererMap() {
		Alterer<G, FitnessType> result = null;

		for(final Map.Entry<String, List<Alterer<G, FitnessType>>> entry : alterers.entrySet()) {
			for(final Alterer<G, FitnessType> e : entry.getValue()) {
				if(result == null) {
					result = e;
				} else {
					result = Alterer.of(result, e);
				}
			}
		}

		return result;
	}
}
