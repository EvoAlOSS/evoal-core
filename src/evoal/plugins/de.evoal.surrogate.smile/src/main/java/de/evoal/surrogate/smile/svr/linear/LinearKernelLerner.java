package de.evoal.surrogate.smile.svr.linear;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.smile.svr.AbstractKernelLerner;

@Dependent
@Named("de.evoal.surrogate.smile.ml.linear-svr-learner")
@Slf4j
public class LinearKernelLerner extends AbstractKernelLerner {
	@Override
	public @NonNull ModelFunction toFunction() {
		return new LinearSVRFunction(regression, inputFeatures, outputFeatures, params, margin, sourceMeans, sourceSD, targetMean, targetSD);
	}
}