package de.evoal.core.main.search;

import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.initial.InitialPopulation;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.fitness.comparator.FitnessValue;

import de.evoal.core.api.statistics.StatisticsWriter;
import de.evoal.core.main.ea.alterer.AltererFactory;
import de.evoal.core.main.ea.codec.DynamicCodec;
import de.evoal.core.main.ea.fitness.JeneticsFitnessFunction;
import de.evoal.core.main.ea.initial.InitialPopulationFactory;
import de.evoal.core.main.jenetics.ConstraintList;
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

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;

import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Dependent
public class HeuristicSearch {
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
	private int numberOfGenerations;

	@Inject
	@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.size_of_population")
	private int sizeOfPopulation;

	@Inject
	@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.maximize")
	private Boolean maximize;

	@Inject
	@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.maximum_age")
	private int maximumAge;

	private final Map<String, List<Alterer<?, FitnessValue>>> alterers = new HashMap<>();

	@Inject
	private DynamicCodec encoding;

	private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	@Inject
	private JeneticsFitnessFunction fitnessFunction;

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


	@Inject @Named("initial")
	private InitialPopulation initalStream;

	public void run() {
		setup();

		final Constraint<?, FitnessValue> constraint = new ConstraintList(constraints.get());

        final Engine<?, FitnessValue> engine= Engine.builder(this.fitnessFunction, encoding)
											.alterers(flattenAltererMap())
											.offspringSelector(this.offspringSelector)
											.survivorsSelector(this.survivorSelector)
											.optimize(maximize ? Optimize.MAXIMUM : Optimize.MINIMUM)
											.populationSize(sizeOfPopulation)
											.constraint(constraint)
											.maximalPhenotypeAge(maximumAge)
											.executor(executor)
											.build();
        
        EvolutionStatistics<FitnessValue, MinMax<FitnessValue>> statistics = EvolutionStatistics.ofComparable();
		EvolutionStream<?, FitnessValue> initialStream = initalStream.create(engine);

        final EvolutionResult<?, FitnessValue> result
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

	private <G extends Gene<?, G>> Alterer<?, FitnessValue> flattenAltererMap() {
		Alterer<G, FitnessValue> result = null;

		for(final Map.Entry<String, List<Alterer<?, FitnessValue>>> entry : alterers.entrySet()) {
			for(final Alterer<?, FitnessValue> e : entry.getValue()) {
				if(result == null) {
					result = (Alterer<G, FitnessValue>) e;
				} else {
					result = Alterer.of(result, (Alterer<G, FitnessValue>)  e);
				}
			}
		}

		return result;
	}
}
