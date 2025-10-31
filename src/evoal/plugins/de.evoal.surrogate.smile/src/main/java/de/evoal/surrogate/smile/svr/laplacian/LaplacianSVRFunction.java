package de.evoal.surrogate.smile.svr.laplacian;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;
import smile.regression.KernelMachine;

import java.util.Map;

public class LaplacianSVRFunction extends KernelBasedSVRFunction {

	public LaplacianSVRFunction(final KernelMachine<double []> regression, final Space input, final Space output, final Map<String, Object> params, final double gamma, final double[] sourceMeans, final double[] sourceSDs, final double[] targetMeans, final double[] targetSDs) {
		super("de.evoal.surrogate.smile.ml.laplacian-svr", input, output, params, regression, gamma, sourceMeans, sourceSDs, targetMeans, targetSDs);
	}
}
