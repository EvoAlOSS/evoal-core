package de.evoal.surrogate.smile.svr.gaussian;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.smile.svr.AbstractKernelLerner;

@Dependent
@Named("de.evoal.surrogate.smile.ml.gaussian-svr-learner")
@Slf4j
public class GaussianKernelLerner extends AbstractKernelLerner {
	@Override
	public @NonNull ModelFunction toFunction() {
		return new GaussianSVRFunction(regression, inputFeatures, outputFeatures, params, margin, sourceMeans, sourceSD, targetMean, targetSD);
	}
}