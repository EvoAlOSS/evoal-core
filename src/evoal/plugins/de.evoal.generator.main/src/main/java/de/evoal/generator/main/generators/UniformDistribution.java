package de.evoal.generator.main.generators;

import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.base.RealLiteral;
import de.evoal.languages.model.generator.Step;
import org.apache.commons.math3.distribution.UniformRealDistribution;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.generator.generator.uniform-distribution")
public class UniformDistribution extends RealDistributionBase {
	public GeneratorFunction init(final Step configuration) throws InitializationException {
		super.init(configuration);

		Object ranges = ((RealLiteral)configuration.getInstance().findAttribute("μ").getValue()).getLiteral();
		if(true) throw new IllegalStateException("Not yet implemented.");

		for(int i = 0; i < writeSpecification.getProperties().size(); ++i) {
			getDistributions().add(new UniformRealDistribution(-1.0, 1.0));
		}

		return this;
	}
}
