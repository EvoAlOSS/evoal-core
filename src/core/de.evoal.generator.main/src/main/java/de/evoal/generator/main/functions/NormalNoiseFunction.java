package de.evoal.generator.main.functions;

import java.util.ArrayList;
import java.util.List;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.AbstractGeneratorFunction;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.generator.main.utils.ELHelper;
import de.evoal.languages.model.generator.Step;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("normally-distributed-noise")
public class NormalNoiseFunction extends AbstractGeneratorFunction {

	/**
	 * The different distributions to apply.
	 */
	private List<RealDistribution> distributions = new ArrayList<>();

	public GeneratorFunction init(final Step configuration) throws InitializationException {
		super.init(configuration);

		ELHelper.readDistributions(configuration.getInstance(), "distributions")
				.stream()
				.map(d -> new NormalDistribution(d.μ(), d.σ()))
				.forEach(distributions::add);

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
