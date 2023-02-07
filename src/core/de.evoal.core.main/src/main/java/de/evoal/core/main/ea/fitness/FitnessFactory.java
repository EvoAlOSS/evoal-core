package de.evoal.core.main.ea.fitness;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.core.api.ea.fitness.comparator.FitnessComparator;
import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.instance.Instance;
import lombok.extern.slf4j.Slf4j;
import org.apache.deltaspike.core.api.provider.BeanProvider;

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
	public JeneticsFitnessFunction create(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.fitness") Instance fitnessConfig,
										  final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.comparator") Instance comparatorConfig) {
		final String fitnessName = fitnessConfig.getName().getName();
		final String comparatorName = comparatorConfig.getName().getName();

		log.info("Creating fitness function {} and using comparator {}.", fitnessName, comparatorName);

		final FitnessFunction ff = BeanProvider.getContextualReference(fitnessName, false, FitnessFunction.class)
				                               .init(fitnessConfig);
		final FitnessComparator cmp = BeanProvider.getContextualReference(comparatorName, false, FitnessComparator.class)
				                                  .init(comparatorConfig);

		return new JeneticsFitnessFunction() {
			@Override
			public FitnessValue apply(final Properties properties) {
				double [] values = ff.evaluate(properties);
				return cmp.compare(values);
			}
		};
	}
}
