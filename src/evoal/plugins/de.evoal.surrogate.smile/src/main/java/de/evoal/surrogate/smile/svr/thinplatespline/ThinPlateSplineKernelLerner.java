package de.evoal.surrogate.smile.svr.thinplatespline;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.smile.svr.AbstractKernelLerner;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.surrogate.smile.ml.thin-plate-spline-svr-learner")
@Slf4j
public class ThinPlateSplineKernelLerner extends AbstractKernelLerner {
	@Override
	public @NonNull ModelFunction toFunction() {
		return new ThinPlateSplineSVRFunction(regression, inputFeatures, outputFeatures, params, margin, sourceMeans, sourceSD, targetMean, targetSD);
	}
}