package de.evoal.generator.main.functions;

import de.evoal.core.api.properties.Properties;
import de.evoal.generator.api.AbstractGeneratorFunction;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.LiteralValue;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("constants")
public class ConstantFunction extends AbstractGeneratorFunction {
	private double [] constants = {};

	public Properties apply(final Properties in) {
		final Properties result = mergeAndCopy(in);

		for(int i = 0; i < constants.length; ++i) {
			result.put(writeSpecification.getProperties().get(i), constants[i]);
		}

		return result;
	}

	@Override
	public GeneratorFunction init(final Step configuration) {
		super.init(configuration);

		final Array constantsArray = (Array)configuration.getInstance().findAttribute("constants").getValue();

		constants = constantsArray.getValues()
								  .stream()
								  .map(LiteralValue.class::cast)
								  .map(LiteralValue::getLiteral)
								  .map(DoubleLiteral.class::cast)
								  .mapToDouble(DoubleLiteral::getValue)
								  .toArray();

		return this;
	}
}
