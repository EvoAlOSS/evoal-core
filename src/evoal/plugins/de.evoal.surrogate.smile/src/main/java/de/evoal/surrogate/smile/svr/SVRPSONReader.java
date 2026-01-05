package de.evoal.surrogate.smile.svr;

import de.evoal.surrogate.smile.KernelFactory;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.NonNull;

import java.util.Collections;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import smile.regression.KernelMachine;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.io.pson.AbstractPSONReader;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;

@Dependent
@Named("de.evoal.surrogate.smile.ml.epsilon-svr-reader-pson")
@Slf4j
public class SVRPSONReader extends AbstractPSONReader {
    @Override
    public @NonNull KernelBasedSVRFunction load() {
        final SurrogateConfiguration configuration = storage
                .getConfiguration()
                .get();

        final KernelMachine<double[]> regression = KernelFactory.fromParameters(configuration.getState());

        final Parameter modelParameter = configuration
                .getState()
                .stream()
                .filter(p -> "model".equals(p.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The model parameter is missing."));

        final Map<String, Object> modelMap = (Map<String, Object>)modelParameter.getValue();
        final Map<String, Object> parameterMap = (Map<String, Object>)modelMap.get("parameters");
        final Map<String, Object> normalizationMap = (Map<String, Object>)modelMap.get("normalization");

        final double gamma = (Double)parameterMap.get(KernelFactory.MLL_SOFT_MARGIN_PARAMETER);

        final double[] sourceMeans = (double[]) normalizationMap.get("kernel-source-means");
        final double[] sourceSDs = (double[]) normalizationMap.get("kernel-source-sds");
        final double[] targetMeans = (double[]) normalizationMap.get("kernel-target-means");
        final double[] targetSDs = (double[]) normalizationMap.get("kernel-target-sds");

        return toFunction(regression, getInput(), getOutput(), Collections.emptyMap(), gamma, sourceMeans, sourceSDs, targetMeans, targetSDs);
    }

    protected @NonNull KernelBasedSVRFunction toFunction(final @NonNull KernelMachine<double[]> regression,
                                                         final @NonNull Space input,
                                                         final @NonNull Space output,
                                                         final @NonNull Map<Object, Object> objectObjectMap,
                                                         final double gamma,
                                                         final double @NonNull [] sourceMeans,
                                                         final double @NonNull [] sourceSDs,
                                                         final double @NonNull [] targetMeans,
                                                         final double @NonNull [] targetSDs) {
        return new KernelBasedSVRFunction(getInput(), getOutput(), Collections.emptyMap(), regression, gamma, sourceMeans, sourceSDs, targetMeans, targetSDs);
    }
}