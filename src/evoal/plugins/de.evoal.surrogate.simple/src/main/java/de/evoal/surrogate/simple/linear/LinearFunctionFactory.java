package de.evoal.surrogate.simple.linear;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;

@Dependent
@Named("linear-regression")
@Slf4j
public class LinearFunctionFactory extends AbstractPartialSurrogateFunctionFactory {

	@Override
	public PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final Space input, final Space output, final EObjectPairStreamSupplier provider) {
		log.info("Calculate linear mapping from {} to {}.", input, output);

		Requirements.requireSize(input, 1);
		Requirements.requireSize(output, 1);
		final EStructuralFeature iFeature = input.iterator().next();
		final EStructuralFeature oFeature = output.iterator().next();

		final SimpleRegression regression = new SimpleRegression(true);

		provider.get()
				.forEach(coordinate -> {
					regression.addData(coordinate.getFirst().eGetAsDouble(iFeature), coordinate.getSecond().eGetAsDouble(oFeature));
				});

		return new LinearFunction(configuration, LinearFunction.toParameters(regression), input, output);
	}

	@Override
	protected PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final Space input, final Space output) {
		return new LinearFunction(configuration, configuration.getState(), input, output);
	}
}
