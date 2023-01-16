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
                       .filter(i -> "constraint-handler".equals(i.getName().getName()))
                       .filter(i -> name.equals(((Instance)i.findAttribute("constraint-handling").getValue()).getName().getName()))
                       .collect(Collectors.toList());
    }
}
