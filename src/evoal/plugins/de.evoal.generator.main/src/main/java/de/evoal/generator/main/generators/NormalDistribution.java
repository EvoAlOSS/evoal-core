package de.evoal.generator.main.generators;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.generator.Step;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("de.evoal.generator.generator.normal-distribution")
@Slf4j
public class NormalDistribution extends RealDistributionBase {

    @Inject
    private AttributeEvaluator evaluator;

    @Override
    public GeneratorFunction init(final Step configuration) throws InitializationException {
        super.init(configuration);

        final Instance instance = configuration.getInstance();

        double μ = evaluator.attributeToDouble(instance, "μ");
        double σ = evaluator.attributeToDouble(instance, "σ");

        log.info("Using distribution of μ={} and σ={}", μ, σ);

        for(int i = 0; i < writeSpecification.getProperties().size(); ++i) {
            getDistributions().add(new org.apache.commons.math3.distribution.NormalDistribution(μ, σ));
        }

        return this;
    }
}
