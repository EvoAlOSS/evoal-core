package de.evoal.core.api.optimisation;

import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.Instance;

import java.util.function.Function;

public interface OptimisationFunction extends Function<Properties, double []> {
    default double [] apply(final Properties candidate) {
        return apply(candidate);
    }

    double [] evaluate(final Properties candidate);

    OptimisationFunction init(final Instance config);
}
