package de.evoal.optimisation.main.constraints.constraint.utils;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.expressions.Instance;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@ApplicationScoped
public class ConfigurationUtils {
    @Inject
    private AttributeHelper helper;

    public List<Instance> findConstraintHandlerByHandlingStrategy(final List<Instance> handlers, final String name) {
        return handlers.stream()
                       .filter(AttributeHelper.filterInstanceByType("constraint-handler"))
                       .filter(helper.filterByAttributesInstanceType("constraint-handling", name))
                       .collect(Collectors.toList());
    }

    public Instance findConstraintHandlerByHandlingStrategyAndCategory(final List<Instance> handlers, final String name, final String category) {
        return handlers.stream()
                .filter(AttributeHelper.filterInstanceByType("constraint-handler"))
                .filter(helper.filterByAttributesInstanceType("constraint-handling", name))
                .filter(i -> category.equals(BeanFactory.create(AttributeHelper.class).lookup(i, "category")))
                .findFirst()
                .get();
    }

    public Optional<Instance> findEpsilonHandler(final List<Instance> handlers) {
        return handlers.stream()
                .filter(AttributeHelper.filterInstanceByType("epsilon-handler"))
                .findFirst();
    }
}
