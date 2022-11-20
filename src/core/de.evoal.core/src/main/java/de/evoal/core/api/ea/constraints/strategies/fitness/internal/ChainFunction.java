package de.evoal.core.api.ea.constraints.strategies.fitness.internal;

import de.evoal.core.api.ea.constraints.strategies.fitness.MalusFunction;
import de.evoal.core.api.properties.Properties;

public class ChainFunction implements MalusFunction {
    private final MalusFunction child;
    private final MalusFunction strategy;

    public ChainFunction(final MalusFunction child, final MalusFunction strategy) {
        this.child = child;
        this.strategy = strategy;
    }

    @Override
    public double apply(final Properties properties, final double fitnessValue) {
        double adaptedFitnessValue = child.apply(properties, fitnessValue);

        return strategy.apply(properties, adaptedFitnessValue);
    }
}
