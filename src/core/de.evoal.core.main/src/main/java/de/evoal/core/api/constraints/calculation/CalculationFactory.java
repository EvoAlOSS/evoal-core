package de.evoal.core.api.constraints.calculation;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.constraints.model.Constraint;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import javax.enterprise.context.ApplicationScoped;

import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.base.Instance;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CalculationFactory {
    private final Map<String, Instance> calculationConfigurationByCategory = new HashMap<>();

    @Inject
    private LanguageHelper helper;

    @Inject
    public CalculationFactory(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.handlers") Instance [] handlerConfigurations) {
        Arrays.stream(handlerConfigurations)
                             .map(Instance.class::cast)
                             .filter(LanguageHelper.filterInstanceByType("constraint-handler"))
                             .forEach(i -> {
                                 final String category = helper.lookup(i, "category");
                                 final Instance config = helper.lookup(i, "calculation");

                                 calculationConfigurationByCategory.put(category, config);
                             });
    }

    public CalculationStrategy create(final Constraint constraint) {
        final Instance config = calculationConfigurationByCategory.get(constraint.getGroup());
        final String calculationName = helper.lookup(config, "name");

        final CalculationStrategy strategy = BeanFactory.create(calculationName, CalculationStrategy.class);
        strategy.init(constraint, config);

        return strategy;
    }
}
