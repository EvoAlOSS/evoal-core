package de.evoal.surrogate.smile.svr.linear;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.Collections;
import java.util.Map;

import smile.regression.KernelMachine;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;
import de.evoal.surrogate.smile.svr.AbstractSVRPSONReader;

@Named("de.evoal.surrogate.smile.ml.linear-svr-reader-pson")
@Dependent
@Slf4j
public class LinearKernelPSONReader extends AbstractSVRPSONReader {
    @Override
    protected @NonNull KernelBasedSVRFunction toFunction(final @NonNull KernelMachine<double[]> regression,
                                                         final @NonNull Space input,
                                                         final @NonNull Space output,
                                                         final @NonNull Map<Object, Object> objectObjectMap,
                                                         final double gamma,
                                                         final double @NonNull [] sourceMeans,
                                                         final double @NonNull [] sourceSDs,
                                                         final double @NonNull [] targetMeans,
                                                         final double @NonNull [] targetSDs) {
		return new LinearSVRFunction(regression, getInput(), getOutput(), Collections.emptyMap(), gamma, sourceMeans, sourceSDs, targetMeans, targetSDs);
	}
}
