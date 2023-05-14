package de.evoal.core.main.constraints.constraint.utils;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ConfigurationUtils {
    private ConfigurationUtils() {
    }

    public static List<Instance> findConstraintHandlerByHandlingStrategy(final Instance [] handlers, final String name) {
        return Arrays.stream(handlers)
                       .map(Instance.class::cast)
                       .filter(LanguageHelper.filterInstanceByType("constraint-handler"))
                       .filter(LanguageHelper.filterByAttributesInstanceType("constraint-handling", name))
                       .collect(Collectors.toList());
    }

    public static Instance findConstraintHandlerByHandlingStrategyAndCategory(final Instance [] handlers, final String name, final String category) {
        return Arrays.stream(handlers)
                .map(Instance.class::cast)
                .filter(LanguageHelper.filterInstanceByType("constraint-handler"))
                .filter(LanguageHelper.filterByAttributesInstanceType("constraint-handling", name))
                .filter(i -> category.equals(BeanFactory.create(LanguageHelper.class).lookup(i, "category")))
                .findFirst()
                .get();
    }
}
