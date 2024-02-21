package de.evoal.generator.main.functions;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.AbstractGeneratorFunction;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.generator.Step;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("de.evoal.generator.generator.constants")
public class ConstantFunction extends AbstractGeneratorFunction {

	private double [] constants = {};

	@Inject
	private ExpressionEvaluator evaluator;


	public Properties apply(final Properties in) {
		final Properties result = mergeAndCopy(in);

		for(int i = 0; i < constants.length; ++i) {
			result.put(writeSpecification.getProperties().get(i), constants[i]);
		}

		return result;
	}

	@Override
	public GeneratorFunction init(final Step configuration) throws InitializationException {
		super.init(configuration);

		constants = evaluator.attributeToDoubleArray(configuration.getInstance(), "constants");

		return this;
	}
}
