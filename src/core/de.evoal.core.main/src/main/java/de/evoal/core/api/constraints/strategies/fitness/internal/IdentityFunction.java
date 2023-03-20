package de.evoal.core.api.constraints.strategies.fitness.internal;

import de.evoal.core.api.constraints.strategies.fitness.MalusFunction;
import de.evoal.core.api.properties.Properties;

public class IdentityFunction implements MalusFunction {
    @Override
    public double apply(final Properties genoProperties, final Properties fitnessProperties, final double fitnessValue) {
        return fitnessValue;
    }
}
