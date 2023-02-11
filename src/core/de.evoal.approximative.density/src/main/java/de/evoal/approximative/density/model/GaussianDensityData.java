package de.evoal.approximative.density.model;


import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import smile.stat.distribution.GaussianDistribution;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GaussianDensityData implements DensityData {
    private final GaussianDistribution distribution;
    private CustomKernelDensity density;

    public GaussianDensityData(final GaussianDistribution distribution) {
        this.distribution = distribution;
    }

    public GaussianDensityData(final PartialFunctionConfiguration configuration, final String propertyName) {
        final Map<String, Object> parameterMap = toMap(configuration.getOutputParameters().get(propertyName));

        double mu = (double) parameterMap.get("density-mu");
        double sigma = (double) parameterMap.get("density-sigma");

        distribution = new GaussianDistribution(mu, sigma);
        density = new CustomKernelDensity(distribution);
    }

    public void attachTo(final PartialFunctionConfiguration configuration, final String propertyName) {
        attach(configuration, propertyName, "density-mu", distribution.mu);
        attach(configuration, propertyName, "density-sigma", distribution.sigma);
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
