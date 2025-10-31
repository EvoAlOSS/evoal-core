package de.evoal.surrogate.smile.svr;

import lombok.NonNull;

import java.util.Collections;
import java.util.Map;

import smile.regression.KernelMachine;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.io.pson.AbstractPSONReader;
import de.evoal.surrogate.api.io.pson.PSONModelStorage;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;

public abstract class AbstractSVRPSONReader extends AbstractPSONReader {
    @Override
    public @NonNull KernelBasedSVRFunction load() {
        final SurrogateConfiguration configuration = storage
                .getConfiguration()
                .get();

        final KernelMachine<double []> regression = KernelHelper.fromParameters(configuration.getState());
        final double gamma = configuration.getState()
                .stream()
                .filter(p -> KernelHelper.SOFT_MARGIN_PARAMETER.equals(p.getName()))
                .map(Parameter::getValue)
                .map(Double.class::cast)
                .findFirst()
                .orElse(0.1);

        final double[] sourceMeans = (double [])configuration.getState()
                .stream()
                .filter(p -> "kernel-source-means".equals(p.getName()))
                .map(Parameter::getValue)
                .findFirst()
                .get();
        final double[] sourceSDs = (double [])configuration.getState()
                .stream()
                .filter(p -> "kernel-source-sds".equals(p.getName()))
                .map(Parameter::getValue)
                .findFirst()
                .get();
        final double[] targetMeans = (double [])configuration.getState()
                .stream()
                .filter(p -> "kernel-target-means".equals(p.getName()))
                .map(Parameter::getValue)
                .findFirst()
                .get();
        final double[] targetSDs = (double [])configuration.getState()
                .stream()
                .filter(p -> "kernel-target-sds".equals(p.getName()))
                .map(Parameter::getValue)
                .findFirst()
                .get();

        return toFunction(regression, getInput(), getOutput(), Collections.emptyMap(), gamma, sourceMeans, sourceSDs, targetMeans, targetSDs);
    }

    protected abstract @NonNull KernelBasedSVRFunction toFunction(final @NonNull KernelMachine<double[]> regression,
                                             final @NonNull Space input,
                                             final @NonNull Space output,
                                             final @NonNull Map<Object, Object> objectObjectMap,
                                             final double gamma,
                                             final double @NonNull [] sourceMeans,
                                             final double @NonNull [] sourceSDs,
                                             final double @NonNull [] targetMeans,
                                             final double @NonNull [] targetSDs);
}
