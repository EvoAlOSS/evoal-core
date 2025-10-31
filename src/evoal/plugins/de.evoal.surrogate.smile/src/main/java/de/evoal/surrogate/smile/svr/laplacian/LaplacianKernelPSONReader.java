package de.evoal.surrogate.smile.svr.laplacian;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;
import de.evoal.surrogate.smile.svr.AbstractSVRPSONReader;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import smile.regression.KernelMachine;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.Collections;
import java.util.Map;

@Named("de.evoal.surrogate.smile.ml.laplacian-svr-reader-pson")
@Dependent
@Slf4j
public class LaplacianKernelPSONReader extends AbstractSVRPSONReader {
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
        return new LaplacianSVRFunction(regression, getInput(), getOutput(), Collections.emptyMap(), gamma, sourceMeans, sourceSDs, targetMeans, targetSDs);
    }
}
