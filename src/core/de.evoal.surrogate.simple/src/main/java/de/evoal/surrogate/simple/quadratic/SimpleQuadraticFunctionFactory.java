package de.evoal.surrogate.simple.quadratic;

import java.util.List;

import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.simple.linear.LinearFunction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import de.evoal.core.api.properties.PropertiesSpecification;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("simple-quadratic-regression")
@Slf4j
public final class SimpleQuadraticFunctionFactory extends AbstractPartialSurrogateFunctionFactory {

	@Override
	public PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput, final PropertiesPairStreamSupplier provider) {
		log.info("Calculate linear mapping from {} to {}.", requiredInput, producedOutput);

		assert requiredInput.getProperties().size() == 1;
		assert producedOutput.getProperties().size() == 1;

		final SimpleRegression regression = new SimpleRegression(true);

		provider.get()
				.forEach(coordinate -> {
					log.info("Mapping - ({}) to ({}).", coordinate.getFirst(), coordinate.getSecond());
					regression.addData(Math.pow(coordinate.getFirst().get(0), 2), coordinate.getSecond().get(0));
				});

		return new SimpleQuadraticFunction(configuration, LinearFunction.toParameters(regression), requiredInput, actualInput, producedOutput);
	}

	@Override
	protected PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput) {
		return new SimpleQuadraticFunction(configuration, configuration.getState(), requiredInput, actualInput, producedOutput);
	}
}
