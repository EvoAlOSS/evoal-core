package de.evoal.surrogate.smile.svr.hyperbolic;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;
import de.evoal.surrogate.smile.svr.AbstractSVRPSONReader;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import smile.regression.KernelMachine;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.Collections;
import java.util.Map;

@Named("de.evoal.surrogate.smile.ml.hyperbolic-svr-reader-pson")
@Dependent
@Slf4j
public class HyperbolicKernelPSONReader extends AbstractSVRPSONReader {
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
        return new HyperbolicSVRFunction(regression, getInput(), getOutput(), Collections.emptyMap(), gamma, sourceMeans, sourceSDs, targetMeans, targetSDs);
    }
}
