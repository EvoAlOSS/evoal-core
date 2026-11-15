package de.evoal.surrogate.adaption.density.model;

import de.evoal.surrogate.api.io.pson.Parameter;
import smile.stat.distribution.KernelDensity;

import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KernelDensityData implements DensityData {
    private final double [] trainingData;
    private final double bandwidth;
    private KernelDensity density;

    public KernelDensityData(final double bandwidth, final double [] trainingData) {
        this.bandwidth = bandwidth;
        this.trainingData = trainingData;
    }

    /**
     * Restores the density data from the information stored with a surrogate model.
     *
     * @param information The stored information of a single feature.
     */
    public KernelDensityData(final Collection<Parameter> information) {
        final Map<String, Object> parameterMap = toMap(information);

        bandwidth = (double) parameterMap.get("density-bandwidth");
        trainingData = (double[]) parameterMap.get("density-training");

        density = new KernelDensity(trainingData, bandwidth);
    }

    public void attachTo(final Consumer<Parameter> appender) {
        attach(appender, "density-bandwidth", bandwidth);
        attach(appender, "density-training", trainingData);
    }

    private void attach(final Consumer<Parameter> appender, final String name, final Object value) {
        final Parameter parameter = Parameter.builder()
                .name(name)
                .value(value)
                .build();

        appender.accept(parameter);
    }

    public static Map<String, Object> toMap(final Collection<Parameter> parameters) {
        return parameters.stream().collect(Collectors.toMap(Parameter::getName, Parameter::getValue));
    }

    public double probability(final double value) {
        return density.p(value);
    }
}
