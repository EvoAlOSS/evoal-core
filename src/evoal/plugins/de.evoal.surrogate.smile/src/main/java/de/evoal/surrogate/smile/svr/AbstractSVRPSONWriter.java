package de.evoal.surrogate.smile.svr;

import lombok.NonNull;

import java.util.List;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.AbstractPSONWriter;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;

public abstract class AbstractSVRPSONWriter extends AbstractPSONWriter {
    private final @NonNull String kernelName;

    protected AbstractSVRPSONWriter(final @NonNull String kernelName) {
        this.kernelName = kernelName;
    }

    @Override
    protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
        final KernelBasedSVRFunction svrFunction = (KernelBasedSVRFunction) function;

        final List<Parameter> parameters = KernelHelper.toParameters(svrFunction.getRegression(), kernelName);
        svrFunction.getParameters()
                .entrySet()
                .stream()
                .map(e -> Parameter.from(e.getKey(), e.getValue()))
                .forEach(parameters::add);

        parameters.add(Parameter.from("kernel-source-means", svrFunction.getSourceMeans()));
        parameters.add(Parameter.from("kernel-source-sds", svrFunction.getSourceSDs()));
        parameters.add(Parameter.from("kernel-target-means", svrFunction.getTargetMeans()));
        parameters.add(Parameter.from("kernel-target-sds", svrFunction.getTargetSDs()));

        configuration.getState()
                     .addAll(parameters);
    }
}
