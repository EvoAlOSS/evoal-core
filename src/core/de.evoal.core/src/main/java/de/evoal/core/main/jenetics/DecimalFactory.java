package de.evoal.core.main.jenetics;

import org.decimal4j.api.ImmutableDecimal;
import org.decimal4j.factory.Factories;
import org.decimal4j.scale.ScaleMetrics;

/**
 * Factory for generating decimals with a specified scale.
 */
public final class DecimalFactory {
    private DecimalFactory() {
    }

    public static <S extends ScaleMetrics> ImmutableDecimal<S> create(final int scale, final double value) {
        return (ImmutableDecimal<S>) Factories.getDecimalFactory(scale).valueOf(value);
    }
}
