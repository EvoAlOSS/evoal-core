package de.evoal.pipeline.impl.components.distributions;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.distribution.Distribution;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Named("de.evoal.pipeline.distributions.multivariate-normal-distribution")
@Dependent
public class MultivariateNormalDistribution extends MultivariateRealDistributionBase {

    @Inject
    private AttributeEvaluator evaluator;

    @Override
    public Distribution init(final Instance configuration) throws InitializationException {
        super.init(configuration);

        double [] means = readMeans(configuration);
        double [][] covariance = readCovariance(configuration);

        setDistribution(new org.apache.commons.math3.distribution.MultivariateNormalDistribution(means, covariance));

        return this;
    }

    private double[][] readCovariance(final @NonNull Instance instance) {
        return evaluator.attributeToDoubleArrayArray(instance, "covariance");
    }

    private double[] readMeans(final @NonNull Instance instance) {
        return evaluator.attributeToDoubleArray(instance, "means");
    }
}
