package de.evoal.surrogate.simple.quadratic;

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
import de.evoal.surrogate.simple.linear.LinearFunction;

@Dependent
@Named("simple-quadratic-regression")
@Slf4j
public final class SimpleQuadraticFunctionFactory extends AbstractPartialSurrogateFunctionFactory {

	@Override
	public PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final Space input, final Space output, final EObjectPairStreamSupplier provider) {
		log.info("Calculate quadratic mapping from {} to {}.", input, output);

		Requirements.requireSize(input, 1);
		Requirements.requireSize(output, 1);
		final EStructuralFeature iFeature = input.iterator().next();
		final EStructuralFeature oFeature = output.iterator().next();

		final SimpleRegression regression = new SimpleRegression(true);

		provider.get()
				.forEach(coordinate -> {
					regression.addData(Math.pow(coordinate.getFirst().eGetAsDouble(iFeature), 2), coordinate.getSecond().eGetAsDouble(oFeature));
				});

		return new SimpleQuadraticFunction(configuration, LinearFunction.toParameters(regression), input, output);
	}

	@Override
	protected PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final Space input, final Space output) {
		return new SimpleQuadraticFunction(configuration, configuration.getState(), input, output);
	}
}
