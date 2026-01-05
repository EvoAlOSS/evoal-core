package de.evoal.surrogate.smile.svr;

import de.evoal.surrogate.smile.KernelFactory;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.AbstractPSONWriter;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;
import lombok.extern.slf4j.Slf4j;

@Dependent
@Named("de.evoal.surrogate.smile.ml.epsilon-svr-writer-pson")
@Slf4j
public class SVRPSONWriter extends AbstractPSONWriter {
    @Override
    protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
        final KernelBasedSVRFunction svrFunction = (KernelBasedSVRFunction) function;

        final Map<String, Object> modelConfiguration = new HashMap<>();
        final Map<String, Object> normalizationConfiguration = new HashMap<>();
        modelConfiguration.put("parameters", svrFunction.getParameters());
        modelConfiguration.put("normalization", normalizationConfiguration);
        modelConfiguration.put("regression", KernelFactory.toConfiguration(svrFunction.getRegression()));

        normalizationConfiguration.put("kernel-source-means", svrFunction.getSourceMeans());
        normalizationConfiguration.put("kernel-source-sds", svrFunction.getSourceSDs());
        normalizationConfiguration.put("kernel-target-means", svrFunction.getTargetMeans());
        normalizationConfiguration.put("kernel-target-sds", svrFunction.getTargetSDs());

        configuration.getState()
                     .add(Parameter.builder().name("model").value(modelConfiguration).build());
    }
}
