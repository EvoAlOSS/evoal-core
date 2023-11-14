package de.evoal.core.api.optimisation;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.Instance;

import java.util.function.Function;

public interface OptimisationFunction extends EvoalComponent<OptimisationFunction>, Function<Properties, double []> {
    default double [] apply(final Properties candidate) {
        return evaluate(candidate);
    }

    double [] evaluate(final Properties candidate);
}
