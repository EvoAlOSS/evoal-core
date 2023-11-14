package de.evoal.core.ea.main.search;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.core.api.optimisation.OptimisationAlgorithm;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.api.optimisation.OptimisationValue;

import de.evoal.core.api.statistics.writer.StatisticsWriter;
import de.evoal.core.ea.main.fitness.JeneticsFitnessFunction;
import de.evoal.core.ea.main.initial.InitialStream;
import de.evoal.core.ea.main.jenetics.ConstraintList;
import de.evoal.core.ea.main.alterer.AltererFactory;
import de.evoal.core.ea.main.codec.DynamicCodec;
import de.evoal.core.ea.main.statistics.JeneticsStatisticsWriter;
import de.evoal.languages.model.base.Attribute;
import de.evoal.languages.model.ol.OptimisationModule;
import io.jenetics.*;
import io.jenetics.engine.*;
import io.jenetics.stat.MinMax;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;

import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Dependent
@Named("evolutionary-algorithm")
public class EvolutionaryAlgorithmOptimisation implements OptimisationAlgorithm {
	@Inject
	private Blackboard board;

	@Inject
	private ExpressionEvaluator evaluator;

	@Inject
	private LanguageHelper helper;

	@Inject
	@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-generations")
	private int numberOfGenerations;

	@Inject
	@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.size-of-population")
	private int sizeOfPopulation;

	@Inject
	@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.maximise")
	private Boolean maximize;

	@Inject
	@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.maximum-age")
	private int maximumAge;

	private final Map<String, List<Alterer<?, OptimisationValue>>> alterers = new HashMap<>();

	@Inject
	private DynamicCodec encoding;

	private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	@Inject
	private JeneticsFitnessFunction fitnessFunction;

	@Inject @Named("offspring")
	private Selector offspringSelector;

	@Inject @Component
	private StatisticsWriter statistics;

	@Inject @Named("survivor")
	private Selector survivorSelector;

	@Inject
	private AltererFactory factory;

	@Inject
	private Instance<List<Constraint>> constraints;


	@Inject @Named("initial")
	private InitialCandidatesProvider provider;

	@Override
	public OptimisationAlgorithm init(de.evoal.languages.model.base.Instance instance) {
		return this;
	}

	public void run() {
		setup();

		final Constraint<?, OptimisationValue> constraint = new ConstraintList(constraints.get());

        final Engine<?, OptimisationValue> engine= Engine.builder(this.fitnessFunction, encoding)
											.alterers(flattenAltererMap())
											.offspringSelector(this.offspringSelector)
											.survivorsSelector(this.survivorSelector)
											.optimize(maximize ? Optimize.MAXIMUM : Optimize.MINIMUM)
											.populationSize(sizeOfPopulation)
											.constraint(constraint)
											.maximalPhenotypeAge(maximumAge)
											.executor(executor)
											.build();
        
        EvolutionStatistics<OptimisationValue, MinMax<OptimisationValue>> statistics = EvolutionStatistics.ofComparable();
		EvolutionStream<?, OptimisationValue> initialStream = BeanFactory.create(InitialStream.class).init(provider, engine).create();
		JeneticsStatisticsWriter writer = new JeneticsStatisticsWriter(this.statistics);

        final EvolutionResult<?, OptimisationValue> result
        		=  initialStream.limit(Limits.byFixedGeneration(numberOfGenerations))
        						.limit(Limits.byExecutionTime(Duration.ofMinutes(5)))
//		        				.parallel()
		        				.peek(writer::add)
		                		.peek(statistics)
        						.collect(EvolutionResult.toBestEvolutionResult());
		this.statistics.write();

		System.out.println(statistics);

        executor.shutdownNow();
	}

	private void setup() {
		final OptimisationModule configuration = board.get(CoreBlackboardEntries.OPTIMISATION_CONFIGURATION);

		final de.evoal.languages.model.base.Instance alterers = helper.lookup(configuration, "algorithm.alterers");

		for(final Attribute category: alterers.getAttributes()) {
			final String name = category.getDefinition().getName();
			log.info("Processing alterer category '{}'.", name);

			final List<de.evoal.languages.model.base.Instance> listOfAltererConfigurations = (List<de.evoal.languages.model.base.Instance>)evaluator.evaluate(category.getValue());

			for(final de.evoal.languages.model.base.Instance alterer : listOfAltererConfigurations) {
				this.alterers
					.computeIfAbsent(name, k -> new ArrayList<>())
					.add(factory.create(alterer));
			}
		}
	}

	private <G extends Gene<?, G>> Alterer<?, OptimisationValue> flattenAltererMap() {
		Alterer<G, OptimisationValue> result = null;

		for(final Map.Entry<String, List<Alterer<?, OptimisationValue>>> entry : alterers.entrySet()) {
			for(final Alterer<?, OptimisationValue> e : entry.getValue()) {
				if(result == null) {
					result = (Alterer<G, OptimisationValue>) e;
				} else {
					result = Alterer.of(result, (Alterer<G, OptimisationValue>)  e);
				}
			}
		}

		return result;
	}
}
