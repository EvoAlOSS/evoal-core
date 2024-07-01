package de.evoal.optimisation.api.model;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;

import java.util.function.Function;

public interface OptimisationFunction extends EvoalComponent<OptimisationFunction>, Function<Properties, double []> {
    default double [] apply(final Properties candidate) {
        return evaluate(candidate);
    }

    double [] evaluate(final Properties candidate);
}
