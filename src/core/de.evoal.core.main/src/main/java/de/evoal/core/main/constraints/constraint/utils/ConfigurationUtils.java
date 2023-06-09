package de.evoal.core.main.constraints.constraint.utils;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ConfigurationUtils {
    @Inject
    private LanguageHelper helper;

    public List<Instance> findConstraintHandlerByHandlingStrategy(final Instance [] handlers, final String name) {
        return Arrays.stream(handlers)
                       .map(Instance.class::cast)
                       .filter(LanguageHelper.filterInstanceByType("constraint-handler"))
                       .filter(helper.filterByAttributesInstanceType("constraint-handling", name))
                       .collect(Collectors.toList());
    }

    public Instance findConstraintHandlerByHandlingStrategyAndCategory(final Instance [] handlers, final String name, final String category) {
        return Arrays.stream(handlers)
                .map(Instance.class::cast)
                .filter(LanguageHelper.filterInstanceByType("constraint-handler"))
                .filter(helper.filterByAttributesInstanceType("constraint-handling", name))
                .filter(i -> category.equals(BeanFactory.create(LanguageHelper.class).lookup(i, "category")))
                .findFirst()
                .get();
    }
}
