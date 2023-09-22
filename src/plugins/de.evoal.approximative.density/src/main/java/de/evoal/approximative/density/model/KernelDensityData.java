package de.evoal.approximative.density.model;

import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import smile.stat.distribution.KernelDensity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KernelDensityData implements DensityData {
    private final double [] trainingData;
    private final double bandwidth;
    private KernelDensity density;

    public KernelDensityData(final double bandwidth, final double [] trainingData) {
        this.bandwidth = bandwidth;
        this.trainingData = trainingData;
    }

    public KernelDensityData(final PartialFunctionConfiguration configuration, final String propertyName) {
        final Map<String, Object> parameterMap = toMap(configuration.getOutputParameters().get(propertyName));

        bandwidth = (double) parameterMap.get("density-bandwidth");
        trainingData = (double[]) parameterMap.get("density-training");

        density = new KernelDensity(trainingData, bandwidth);
    }

    public void attachTo(final PartialFunctionConfiguration configuration, final String propertyName) {
        attach(configuration, propertyName, "density-bandwidth", bandwidth);
        attach(configuration, propertyName, "density-training", trainingData);
    }

    private void attach(final PartialFunctionConfiguration regression, final String propertyName, final String name, final Object value) {
        final Parameter parameter = Parameter.builder()
                .name(name)
                .value(value)
                .build();

        regression.addOutputParameter(propertyName, parameter);
    }

    public static Map<String, Object> toMap(final List<Parameter> parameters) {
        return parameters.stream().collect(Collectors.toMap(Parameter::getName, Parameter::getValue));
    }

    public double probability(final double value) {
        return density.p(value);
    }
}
