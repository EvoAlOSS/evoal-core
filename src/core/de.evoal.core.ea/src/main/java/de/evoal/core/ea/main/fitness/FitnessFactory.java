package de.evoal.core.ea.main.fitness;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.instance.Instance;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class FitnessFactory {
	private final String NAME_SUFFIX = "-fitness";

	private FitnessFactory() {
	}

	/**
	 * Creates a fitness function based on the heuristic configuration.<br/>
	 * Blackboard slots used:
	 * <ul>
	 *   <li>{@link CoreBlackboardEntries#OPTIMISATION_CONFIGURATION}.</li>
	 * </ul>
	 */
	@Produces @Dependent
	public JeneticsFitnessFunction create(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function.function") Instance fitnessConfig,
										  final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.comparator") Instance comparatorConfig) {
		final String fitnessName = fitnessConfig.getDefinition().getName();
		final String comparatorName = comparatorConfig.getDefinition().getName();

		log.info("Creating fitness function {} and using comparator {}.", fitnessName, comparatorName);

		final OptimisationFunction ff = BeanFactory.create(fitnessName, OptimisationFunction.class)
				                               .init(fitnessConfig);
		final OptimisationValueComparator cmp = BeanFactory.create(comparatorName, OptimisationValueComparator.class)
				                                  .init(comparatorConfig);

		return new JeneticsFitnessFunction() {
			@Override
			public OptimisationValue apply(final Properties properties) {
				double [] values = ff.evaluate(properties);
				return cmp.toValue(values);
			}
		};
	}
}
