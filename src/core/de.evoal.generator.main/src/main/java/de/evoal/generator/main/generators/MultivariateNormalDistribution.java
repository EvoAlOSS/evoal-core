package de.evoal.generator.main.generators;

import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.instance.*;
import de.evoal.languages.model.instance.impl.InstanceImpl;
import lombok.NonNull;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named("multivariate-normal-distribution")
@Dependent
public class MultivariateNormalDistribution extends MultivariateRealDistributionBase {

    @Override
    public GeneratorFunction init(final Step configuration) throws InitializationException {
        super.init(configuration);

        double [] means = readMeans(configuration.getInstance());
        double [][] covariance = readCovariance(configuration.getInstance());

        setDistribution(new org.apache.commons.math3.distribution.MultivariateNormalDistribution(means, covariance));

        return this;
    }

    private double[][] readCovariance(final @NonNull Instance instance) {
        final Array array = (Array) instance.findAttribute("covariances")
                                            .getValue();

        return array.getValues()
                .stream()
                .map(Array.class::cast)
                .map(this::readArray)
                .toArray(i -> new double[i][]);
    }

    private double []readArray(final @NonNull Array value) {
        return value.getValues()
                    .stream()
                    .mapToDouble(this::readDouble)
                    .toArray();
    }

    private double readDouble(final Value value) {
        return ((DoubleLiteral)((LiteralValue)value).getLiteral()).getValue();
    }

    private double[] readMeans(final @NonNull Instance instance) {
        final Attribute meansAttribute = instance.findAttribute("means");

        return readArray((Array)meansAttribute.getValue());
    }
}
