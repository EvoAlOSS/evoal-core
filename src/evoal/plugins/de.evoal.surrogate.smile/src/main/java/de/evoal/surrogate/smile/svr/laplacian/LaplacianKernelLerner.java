package de.evoal.surrogate.smile.svr.laplacian;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.smile.svr.AbstractKernelLerner;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.laplacian-svr-learner")
@Slf4j
public class LaplacianKernelLerner extends AbstractKernelLerner {
	@Override
	public @NonNull ModelFunction toFunction() {
		return new LaplacianSVRFunction(regression, inputFeatures, outputFeatures, params, margin, sourceMeans, sourceSD, targetMean, targetSD);
	}
}