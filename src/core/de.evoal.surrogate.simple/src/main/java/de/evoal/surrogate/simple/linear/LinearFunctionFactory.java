package de.evoal.surrogate.simple.linear;


import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import de.evoal.core.api.properties.PropertiesSpecification;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.List;

@Dependent
@Named("linear-regression")
@Slf4j
public class LinearFunctionFactory extends AbstractPartialSurrogateFunctionFactory {

	@Override
	public PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput, final PropertiesPairStreamSupplier provider) {
		log.info("Calculate linear mapping from {} to {}.", requiredInput, producedOutput);

		assert requiredInput.getProperties().size() == 1;
		assert producedOutput.getProperties().size() == 1;

		final SimpleRegression regression = new SimpleRegression(true);

		provider.get()
				.forEach(coordinate -> {
					log.info("Mapping - ({}) to ({}).", coordinate.getFirst(), coordinate.getSecond());
					regression.addData(coordinate.getFirst().get(0), coordinate.getSecond().get(0));
				});

		return new LinearFunction(configuration, LinearFunction.toParameters(regression), requiredInput, actualInput, producedOutput);
	}

	@Override
	protected PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput) {
		return new LinearFunction(configuration, configuration.getState(), requiredInput, actualInput, producedOutput);
	}
}
