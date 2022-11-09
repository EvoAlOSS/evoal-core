package de.evoal.core.main.ddl.constraint.strategies;

import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import javax.enterprise.context.ApplicationScoped;

import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.instance.Instance;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.inject.Inject;

@ApplicationScoped
public class CalculationFactory {
    private final Instance handlerConfigurations;

    @Inject
    public CalculationFactory(final @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.constraint_handling") Instance handlerConfiguration) {
        handlerConfigurations = handlerConfiguration;
    }

    public CalculationStrategy create(final Constraint constraint) {
        final Instance handlerConfig = LanguageHelper.lookup(handlerConfigurations, constraint.getGroup());
        final Instance calculationConfig = LanguageHelper.lookup(handlerConfigurations, "calculation");

        final String calculationName = LanguageHelper.lookup(calculationConfig, "name");

        final CalculationStrategy strategy = BeanProvider.getContextualReference(calculationName, false, CalculationStrategy.class);
        strategy.init(constraint, calculationConfig);

        return strategy;
    }
}
