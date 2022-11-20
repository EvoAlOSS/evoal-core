package de.evoal.core.main.ea.fitness;

import java.util.*;
import java.util.stream.Collectors;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.ea.fitness.FitnessBase;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.fitness.FitnessEvaluator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import lombok.extern.slf4j.Slf4j;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.enterprise.inject.spi.Bean;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Slf4j
public class FitnessFactory {
	private final String NAME_SUFFIX = "-fitness";

	@Inject
	private Blackboard board;

	private FitnessFactory() {
	}

	/**
	 * Creates a fitness function based on the heuristic configuration.
	 *
	 * Blackboard slots used:
	 * <ul>
	 *   <li>{@link BlackboardEntry#EA_CONFIGURATION}.</li>
	 *   <li>{@link BlackboardEntry#PREDICTIVE_FUNCTION}.</li>
	 *   <li>{@link BlackboardEntry#TARGET_PROPERTIES}.</li>
	 * </ul>
	 */
	@Produces @Named("evaluator") @Dependent
	public FitnessEvaluator create(final @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.fitness.name") String name) {
		log.info("Creating fitness evaluator {}.", name);

		return BeanProvider.getContextualReference(name + NAME_SUFFIX, false, FitnessEvaluator.class)::evaluate;
	}

	@Produces @Named("function-names") @Dependent
	public List<String> functionNames() {
		return BeanProvider.getBeanDefinitions(FitnessBase.class, true, true)
				.stream()
 				.map(Bean::getName)
				.filter(Objects::nonNull)
				.filter(name -> name.endsWith(NAME_SUFFIX))
				.map(s -> s.substring(0, s.length() - NAME_SUFFIX.length()))
				.collect(Collectors.toList());
	}
}
