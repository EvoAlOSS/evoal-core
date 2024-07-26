package de.evoal.generator.main.generators;

import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.base.*;
import de.evoal.core.api.languages.ExpressionEvaluator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.inject.Inject;

@Slf4j
@Named("de.evoal.generator.generator.multivariate-normal-distribution")
@Dependent
public class MultivariateNormalDistribution extends MultivariateRealDistributionBase {

    @Inject
    private ExpressionEvaluator evaluator;

    @Override
    public GeneratorFunction init(final Step configuration) throws InitializationException {
        super.init(configuration);

        double [] means = readMeans(configuration.getInstance());
        double [][] covariance = readCovariance(configuration.getInstance());

        setDistribution(new org.apache.commons.math3.distribution.MultivariateNormalDistribution(means, covariance));

        return this;
    }

    private double[][] readCovariance(final @NonNull Instance instance) {
        final double[][] covariances = evaluator.attributeToDoubleArrayArray(instance, "covariance");
        return covariances;
    }

    private double[] readMeans(final @NonNull Instance instance) {
        double[] means = evaluator.attributeToDoubleArray(instance, "means");
        return means;
    }
}
