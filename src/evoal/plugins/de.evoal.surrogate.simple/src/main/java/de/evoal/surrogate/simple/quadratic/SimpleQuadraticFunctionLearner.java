package de.evoal.surrogate.simple.quadratic;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.training.AbstractModelLearner;
import de.evoal.surrogate.api.training.ModelLearner;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.function.Function;

@Dependent
@Named("de.evoal.surrogate.simple.ml.simple-quadratic-regression-learner")
@Slf4j
public class SimpleQuadraticFunctionLearner extends AbstractModelLearner {
	/**
	 * The input feature.
	 */
	private Function<TypedEObject, Double> inputFeature;

	/**
	 * The output feature.
	 */
	private Function<TypedEObject, Double> outputFeature;

	/**
	 * The model to learn.
	 */
	SimpleRegression regression;

	@Override
	public ModelLearner init(final Instance configuration) throws InitializationException {
		super.init(configuration);

        regression = new SimpleRegression(true);

        return this;
	}

	@Override
	public void add(final TypedEObject features) {
		regression.addData(Math.pow(inputFeature.apply(features), 2), outputFeature.apply(features));
	}

	@Override
	public void learn() {
		regression.regress();
	}

	@Override
	public void setFeatureSpaces(final Space inputFeatures, final Space outputFeatures) {
		super.setFeatureSpaces(inputFeatures, outputFeatures);

		Requirements.requireSize(inputFeatures, 1);
		Requirements.requireSize(outputFeatures, 1);

		final EStructuralFeature inputFeature = inputFeatures.iterator().next();
		final EStructuralFeature outputFeature = outputFeatures.iterator().next();

		log.info("Mapping '{}' to '{}'.", inputFeature.getName(), outputFeature.getName());

		this.inputFeature = object -> object.eGetAsDouble(inputFeature);
		this.outputFeature = object -> object.eGetAsDouble(outputFeature);
	}

	@Override
	public @NonNull ModelFunction toFunction() {
		return new SimpleQuadraticFunction(super.inputFeatures, super.outputFeatures, regression.getSlope(), regression.getIntercept());
	}
}
