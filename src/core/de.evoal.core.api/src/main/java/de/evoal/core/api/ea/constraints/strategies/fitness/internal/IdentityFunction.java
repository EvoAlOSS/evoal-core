package de.evoal.core.api.ea.constraints.strategies.fitness.internal;

import de.evoal.core.api.ea.constraints.strategies.fitness.MalusFunction;
import de.evoal.core.api.properties.Properties;

public class IdentityFunction implements MalusFunction {
    @Override
    public double apply(final Properties properties, final double fitnessValue) {
        return fitnessValue;
    }
}
