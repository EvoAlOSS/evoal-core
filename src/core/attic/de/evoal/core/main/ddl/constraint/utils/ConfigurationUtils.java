package de.evoal.core.main.ddl.constraint.utils;

import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.Instance;

import java.util.ArrayList;
import java.util.List;

public final class ConfigurationUtils {
    private ConfigurationUtils() {
    }

    public static List<Attribute> findByHandlerName(Instance configuration, final String name) {
        final List<Attribute> result = new ArrayList<>();

        for(final Attribute attribute : configuration.getAttributes()) {
            final Instance handlerConfiguration = LanguageHelper.lookup((Instance)attribute.getValue(), "handling");
            final String handlerName = LanguageHelper.lookup(handlerConfiguration, "name");

            if(name.equals(handlerName)) {
                result.add(attribute);
            }
        }

        return result;
    }
}
