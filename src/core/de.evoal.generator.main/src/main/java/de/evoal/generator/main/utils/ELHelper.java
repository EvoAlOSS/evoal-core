package de.evoal.generator.main.utils;

import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.LiteralValue;

import java.util.List;
import java.util.stream.Collectors;

public final class ELHelper {
    private ELHelper() {}

    public record Distribution(double μ, double σ) {}

    public static double readDouble(final Instance instance, final String name) {
        return ((DoubleLiteral)((LiteralValue)instance.findAttribute(name).getValue()).getLiteral()).getValue();
    }

    public static List<Distribution> readDistributions(final Instance instance, final String name) {
        final Array array = (Array)instance.findAttribute(name).getValue();

        return array.getValues()
                .stream()
                .map(Instance.class::cast)
                .map(ELHelper::readDistribution)
                .collect(Collectors.toUnmodifiableList());
    }

    private static Distribution readDistribution(final Instance instance) {
        final double μ = ELHelper.readDouble(instance, "μ");
        final double σ = ELHelper.readDouble(instance, "σ");

        return new Distribution(μ, σ);
    }
}
