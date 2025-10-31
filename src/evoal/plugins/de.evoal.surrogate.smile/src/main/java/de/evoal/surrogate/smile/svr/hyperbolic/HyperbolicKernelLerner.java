package de.evoal.surrogate.smile.svr.hyperbolic;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.smile.svr.AbstractKernelLerner;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.hyperbolic-svr-learner")
@Slf4j
public class HyperbolicKernelLerner extends AbstractKernelLerner {
	@Override
	public @NonNull ModelFunction toFunction() {
		return new HyperbolicSVRFunction(regression, inputFeatures, outputFeatures, params, margin, sourceMeans, sourceSD, targetMean, targetSD);
	}
}