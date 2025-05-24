package de.evoal.surrogate.api.ea.constraints.strategies.malus.internal;

import de.evoal.surrogate.api.ea.constraints.strategies.malus.MalusFunction;
import de.evoal.core.api.properties.Properties;

public class IdentityFunction implements MalusFunction {
    @Override
    public double apply(final Properties genoProperties, final Properties fitnessProperties, final double fitnessValue) {
        return fitnessValue;
    }
}
