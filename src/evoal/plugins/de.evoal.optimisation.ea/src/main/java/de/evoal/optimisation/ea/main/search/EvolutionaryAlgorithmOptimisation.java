package de.evoal.optimisation.ea.main.search;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.cdi.StoppingCriterionProducer;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.model.OptimisationValue;

import de.evoal.optimisation.api.model.StoppingCriterion;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import de.evoal.optimisation.ea.main.alterer.AltererFactory;
import de.evoal.optimisation.main.fitness.JeneticsFitnessFunction;
import de.evoal.optimisation.ea.main.initial.InitialStream;
import de.evoal.optimisation.ea.main.jenetics.ConstraintList;
import de.evoal.optimisation.ea.main.statistics.IterationAdapter;
import de.evoal.optimisation.ea.main.statistics.JeneticsStatisticsWriter;
import de.evoal.languages.model.base.expressions.Attribute;
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
@Named("de.evoal.optimisation.ea.optimisation.evolutionary-algorithm")
public class EvolutionaryAlgorithmOptimisation implements OptimisationAlgorithm {
	@Inject
	private Blackboard board;

	@Inject
	private AttributeEvaluator evaluator;

	@Inject
	private AttributeHelper helper;

	@Inject
	@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-generations")
	private int numberOfGenerations;

	@Inject
	@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.size-of-population")
	private int sizeOfPopulation;

	@Inject
	@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.maximise")
	private Boolean maximize;

	@Inject
	@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.maximum-age")
	private int maximumAge;

	@Inject
	@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.offspring-fraction")
	private double offspringFraction;

	private final Map<String, List<Alterer<?, OptimisationValue>>> alterers = new HashMap<>();

	@Inject @Named("codec")
	private CustomCodec encoding;

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

	@Inject
	private StoppingCriterionProducer stoppingProducer;

	/**
	 * Stopping criterion.
	 */
	private Predicate<? super EvolutionResult<?, OptimisationValue>> stoppingCriterion = (Predicate<EvolutionResult<?, OptimisationValue>>) optimisationValueEvolutionResult -> true;

	public void run() {
		setup();

		final Constraint<?, OptimisationValue> constraint = new ConstraintList(constraints.get());

        final Engine<?, OptimisationValue> engine= Engine.builder(this.fitnessFunction, encoding)
											.alterers(flattenAltererMap())
											.offspringSelector(this.offspringSelector)
											.offspringFraction(offspringFraction)
											.survivorsSelector(this.survivorSelector)
											.optimize(maximize ? Optimize.MAXIMUM : Optimize.MINIMUM)
											.populationSize(sizeOfPopulation)
											.constraint(constraint)
											.maximalPhenotypeAge(maximumAge)
											.executor(executor)
											.build();
        
        final EvolutionStatistics<OptimisationValue, MinMax<OptimisationValue>> statistics = EvolutionStatistics.ofComparable();
		final EvolutionStream<?, OptimisationValue> initialStream = BeanFactory.create(InitialStream.class).init(provider, engine).create();
		final JeneticsStatisticsWriter writer = new JeneticsStatisticsWriter(this.statistics);

        final EvolutionResult<?, OptimisationValue> result
        		=  initialStream.limit(stoppingCriterion)
//		        				.parallel()
		        				.peek(writer::add)
		                		.peek(statistics)
        						.collect(EvolutionResult.toBestEvolutionResult());
		this.statistics.write();

		System.out.println(statistics);

        executor.shutdownNow();
	}

	private void setup() {
		final OptimisationModule configuration = board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);

		// create list of alterers
		final de.evoal.languages.model.base.expressions.Instance alterers = helper.lookup(configuration, "algorithm.alterers");
		for(final Attribute category: alterers.getAttributes()) {
			final String name = category.getDefinition().getName();
			log.info("Processing alterer category '{}'.", name);

			final List<de.evoal.languages.model.base.expressions.Instance> listOfAltererConfigurations = (List<de.evoal.languages.model.base.expressions.Instance>)evaluator.evaluate(category.getValue());

			for(final de.evoal.languages.model.base.expressions.Instance alterer : listOfAltererConfigurations) {
				this.alterers
					.computeIfAbsent(name, k -> new ArrayList<>())
					.add(factory.create(alterer));
			}
		}

		final StoppingCriterion criterion = stoppingProducer.create(configuration.getAlgorithm());

		this.stoppingCriterion = (result) -> criterion.shouldTerminate(new IterationAdapter(result));
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
