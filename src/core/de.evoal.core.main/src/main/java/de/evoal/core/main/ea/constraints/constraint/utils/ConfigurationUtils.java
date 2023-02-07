package de.evoal.core.main.ea.constraints.constraint.utils;

import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.Instance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class ConfigurationUtils {
    private ConfigurationUtils() {
    }

    public static List<Instance> findConstraintHandlerByHandlingStrategy(final Array handlers, final String name) {
        return handlers.getValues()
                       .stream()
                       .map(Instance.class::cast)
                       .filter(LanguageHelper.filterInstanceByType("constraint-handler"))
                       .filter(LanguageHelper.filterByAttributesInstanceType("constraint-handling", name))
                       .collect(Collectors.toList());
    }

    public static Instance findConstraintHandlerByHandlingStrategyAndCategory(final Array handlers, final String name, final String category) {
        return handlers.getValues()
                .stream()
                .map(Instance.class::cast)
                .filter(LanguageHelper.filterInstanceByType("constraint-handler"))
                .filter(LanguageHelper.filterByAttributesInstanceType("constraint-handling", name))
                .filter(i -> category.equals(LanguageHelper.lookup(i, "category")))
                .findFirst()
                .get();
    }
}
