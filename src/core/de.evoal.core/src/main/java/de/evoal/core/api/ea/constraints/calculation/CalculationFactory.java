package de.evoal.core.api.ea.constraints.calculation;

import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import javax.enterprise.context.ApplicationScoped;

import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CalculationFactory {
    private final Map<String, Instance> calculationConfigurationByCategory = new HashMap<>();

    @Inject
    public CalculationFactory(final @ConfigurationValue(entry = BlackboardEntry.OPTIMISATION_CONFIGURATION, access = "algorithm.handlers") Array handlerConfigurations) {
        handlerConfigurations.getValues()
                             .stream()
                             .map(Instance.class::cast)
                             .filter(LanguageHelper.filterInstanceByType("constraint-handler"))
                             .forEach(i -> {
                                 final String category = LanguageHelper.lookup(i, "category");
                                 final Instance config = LanguageHelper.lookup(i, "calculation");

                                 calculationConfigurationByCategory.put(category, config);
                             });
    }

    public CalculationStrategy create(final Constraint constraint) {
        final Instance config = calculationConfigurationByCategory.get(constraint.getGroup());
        final String calculationName = LanguageHelper.lookup(config, "name");

        final CalculationStrategy strategy = BeanProvider.getContextualReference(calculationName, false, CalculationStrategy.class);
        strategy.init(constraint, config);

        return strategy;
    }
}
