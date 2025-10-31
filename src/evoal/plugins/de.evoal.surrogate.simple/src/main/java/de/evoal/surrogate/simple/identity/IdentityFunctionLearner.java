package de.evoal.surrogate.simple.identity;

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

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.function.Function;

@Dependent
@Named("de.evoal.surrogate.simple.ml.identity-learner")
@Slf4j
public class IdentityFunctionLearner extends AbstractModelLearner {
	/**
	 * The input feature.
	 */
	private Function<TypedEObject, Double> inputFeature;

	/**
	 * The output feature.
	 */
	private Function<TypedEObject, Double> outputFeature;

	@Override
	public ModelLearner init(final Instance configuration) throws InitializationException {
		super.init(configuration);

        return this;
	}

	@Override
	public void add(final TypedEObject features) {
	}

	@Override
	public void learn() {
	}

	@Override
	public void setFeatureSpaces(final Space inputFeatures, final Space outputFeatures) {
		super.setFeatureSpaces(inputFeatures, outputFeatures);

		Requirements.requireSameSize(inputFeatures, outputFeatures);
	}

	@Override
	public @NonNull ModelFunction toFunction() {
		return new IdentityFunction(super.inputFeatures, super.outputFeatures);
	}
}
