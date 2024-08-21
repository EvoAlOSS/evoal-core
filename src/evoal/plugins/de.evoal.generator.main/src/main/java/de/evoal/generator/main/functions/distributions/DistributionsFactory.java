package de.evoal.generator.main.functions.distributions;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.Instance;

import java.util.List;

public final class DistributionsFactory {
    private DistributionsFactory() {}

    public static List<Distribution> readDistributions(final Instance instance, final String name) {
        final AttributeHelper helper = BeanFactory.create(AttributeHelper.class);

        final List<Instance> distributions = helper.lookup(instance, name);

        return distributions.stream()
                .map(i -> BeanFactory.createComponent(Distribution.class, i, "-noise"))
                .toList();
    }
}
