package de.evoal.generator.main.utils;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;

import java.util.List;
import java.util.stream.Collectors;

public final class ConfigurationHelper {
    private ConfigurationHelper() {}

    public record Distribution(double μ, double σ) {}

    public static List<Distribution> readDistributions(final Instance instance, final String name) {
        final Array array = (Array)instance.findAttribute(name).getValue();

        return array.getValues()
                .stream()
                .map(Instance.class::cast)
                .map(ConfigurationHelper::readDistribution)
                .collect(Collectors.toUnmodifiableList());
    }

    private static Distribution readDistribution(final Instance instance) {
        final LanguageHelper helper = BeanFactory.create(LanguageHelper.class);

        final double μ = helper.lookup(instance, "μ");
        final double σ = helper.lookup(instance, "σ");

        return new Distribution(μ, σ);
    }
}
