package de.evoal.core.api.optimisation;

import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.instance.Instance;

import java.util.function.Function;

public interface OptimisationFunction extends Function<Properties, double []> {
    public default double [] apply(final Properties candidate) {
        return apply(candidate);
    }

    public double [] evaluate(final Properties candidate);

    public OptimisationFunction init(final Instance config);
}
