package de.evoal.generator.main.generators;

import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.base.DoubleLiteral;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.base.Literal;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("normal-distribution")
public class NormalDistribution extends RealDistributionBase {

    @Override
    public GeneratorFunction init(final Step configuration) throws InitializationException {
        super.init(configuration);

        double μ = ((DoubleLiteral)configuration.getInstance().findAttribute("μ").getValue()).getValue();
        double σ = ((DoubleLiteral)configuration.getInstance().findAttribute("σ").getValue()).getValue();

        for(int i = 0; i < writeSpecification.getProperties().size(); ++i) {
            getDistributions().add(new org.apache.commons.math3.distribution.NormalDistribution(μ, σ));
        }

        return this;
    }
}
