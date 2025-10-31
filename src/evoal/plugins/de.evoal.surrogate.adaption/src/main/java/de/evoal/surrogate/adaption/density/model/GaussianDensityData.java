package de.evoal.surrogate.adaption.density.model;

import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.pson.Parameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import smile.stat.distribution.GaussianDistribution;

import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class GaussianDensityData implements DensityData {
    private final GaussianDistribution distribution;
    private CustomKernelDensity density;

    public GaussianDensityData(final GaussianDistribution distribution) {
        this.distribution = distribution;
    }

    public GaussianDensityData(final ModelReader reader, final EStructuralFeature feature) {
        final Map<String, Object> parameterMap = toMap(reader.getOutputFeatureInformation(feature));

        double mu = (double) parameterMap.get("density-mu");
        double sigma = (double) parameterMap.get("density-sigma");

        distribution = new GaussianDistribution(mu, sigma);
        density = new CustomKernelDensity(distribution);
    }

    public void attachTo(final Consumer<Parameter> appender) {
        attach(appender, "density-mu", distribution.mu);
        attach(appender, "density-sigma", distribution.sigma);
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
