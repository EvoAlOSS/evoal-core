package de.evoal.optimisation.api.constraints.calculation;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.dl.util.FQNProvider;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.constraints.model.Constraint;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import de.evoal.languages.model.base.Instance;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CalculationFactory {
    private final Map<String, Instance> calculationConfigurationByCategory = new HashMap<>();

    @Inject
    private AttributeHelper helper;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.handlers")
    private List<Instance> handlerConfigurations;

    @PostConstruct
    public void init() {
       handlerConfigurations.stream()
                            .filter(AttributeHelper.filterInstanceByType("constraint-handler"))
                            .forEach(i -> {
                                final String category = helper.lookup(i, "category");
                                final Instance config = helper.lookup(i, "calculation");

                                calculationConfigurationByCategory.put(category, config);
                            });
    }

    public CalculationStrategy create(final Constraint constraint) {
        final Instance config = calculationConfigurationByCategory.get(constraint.getGroup());
        final String name = new FQNProvider().get(config);

        final CalculationStrategy strategy = BeanFactory.create(name, CalculationStrategy.class);
        strategy.init(constraint, config);

        return strategy;
    }
}
