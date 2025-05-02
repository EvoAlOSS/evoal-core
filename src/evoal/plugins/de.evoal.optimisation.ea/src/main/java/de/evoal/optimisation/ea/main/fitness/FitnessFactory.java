package de.evoal.optimisation.ea.main.fitness;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.main.fitness.JeneticsFitnessFunction;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class FitnessFactory {

	private FitnessFactory() {
	}

	/**
	 * Creates a fitness function based on the heuristic configuration.<br/>
	 * Blackboard slots used:
	 * <ul>
	 *   <li>{@link OptimisationBlackboardEntries#OPTIMISATION_CONFIGURATION}.</li>
	 * </ul>
	 */
	@Produces @Dependent
	public JeneticsFitnessFunction create(final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function") Instance fitnessConfig,
										  final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.comparator") Instance comparatorConfig) {
		final String fitnessName = fitnessConfig.getDefinition().getName();
		final String comparatorName = comparatorConfig.getDefinition().getName();

		log.info("Creating fitness function {} and using comparator {}.", fitnessName, comparatorName);

		final OptimisationFunction ff = BeanFactory.createComponent(OptimisationFunction.class, fitnessConfig);
		final OptimisationValueComparator cmp = BeanFactory.createComponent(OptimisationValueComparator.class, comparatorConfig);

		return new JeneticsFitnessFunction() {
			@Override
			public OptimisationValue apply(final Properties properties) {
				double [] values = ff.evaluate(properties);
				return cmp.toValue(values);
			}
		};
	}
}
