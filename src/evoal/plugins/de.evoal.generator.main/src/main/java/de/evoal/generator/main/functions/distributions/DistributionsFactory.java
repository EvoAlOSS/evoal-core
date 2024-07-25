package de.evoal.generator.main.functions.distributions;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.base.Instance;

import java.util.Arrays;
import java.util.List;

public final class DistributionsFactory {
    private DistributionsFactory() {}

    public static List<Distribution> readDistributions(final Instance instance, final String name) {
        final LanguageHelper helper = BeanFactory.create(LanguageHelper.class);

        final Object [] array = helper.lookup(instance, name);

        return Arrays.stream(array)
                .map(Instance.class::cast)
                .map(i -> BeanFactory.createComponent(Distribution.class, i, "-noise"))
                .toList();
    }
}
