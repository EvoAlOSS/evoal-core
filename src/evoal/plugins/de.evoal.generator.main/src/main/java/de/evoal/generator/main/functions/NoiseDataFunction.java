package de.evoal.generator.main.functions;

import java.util.ArrayList;
import java.util.List;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.AbstractGeneratorFunction;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.generator.main.functions.distributions.Distribution;
import de.evoal.generator.main.functions.distributions.DistributionsFactory;
import de.evoal.languages.model.generator.Step;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.generator.generator.noise-data")
public class NoiseDataFunction extends AbstractGeneratorFunction {

	/**
	 * The different distributions to apply.
	 */
	private final List<Distribution> distributions = new ArrayList<>();

	public GeneratorFunction init(final Step configuration) throws InitializationException {
		super.init(configuration);

        distributions.addAll(DistributionsFactory.readDistributions(configuration.getInstance(), "distributions"));

		return this;
	}

	@Override
	public Properties apply(final Properties in) {
		final Properties result = mergeAndCopy(in);
		final int dimension = writeSpecification.size();

		for(int i = 0; i < dimension; ++i) {
			final PropertySpecification ps = writeSpecification.getProperties().get(i);

			double value = result.getAsDouble(ps) + distributions.get(i).sample();

			result.put(ps, value);
		}

		return result;
	}
}
