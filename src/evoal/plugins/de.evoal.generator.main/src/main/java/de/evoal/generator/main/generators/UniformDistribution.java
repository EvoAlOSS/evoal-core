package de.evoal.generator.main.generators;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.generator.Step;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("de.evoal.generator.generator.uniform-distribution")
@Slf4j
public class UniformDistribution extends RealDistributionBase {
	@Inject
	private ExpressionEvaluator evaluator;


	public GeneratorFunction init(final Step configuration) throws InitializationException {
		super.init(configuration);

		final Instance instance = configuration.getInstance();
		double lowerBound = evaluator.attributeToDouble(instance,  "lower");
		double upperBound = evaluator.attributeToDouble(instance,  "upper");
		//Object ranges = ((RealLiteral)configuration.getInstance().findAttribute("μ").getValue()).getLiteral();
		//if(true) throw new IllegalStateException("Not yet implemented.");
		log.info("Using uniform distribution with lower={} and upper={}", lowerBound, upperBound);


		for(int i = 0; i < writeSpecification.getProperties().size(); ++i) {
			getDistributions().add(new UniformRealDistribution(lowerBound, upperBound));
		}

		return this;
	}
}
