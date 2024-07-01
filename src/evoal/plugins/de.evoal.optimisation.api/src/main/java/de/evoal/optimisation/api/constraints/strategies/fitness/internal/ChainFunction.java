package de.evoal.optimisation.api.constraints.strategies.fitness.internal;

import de.evoal.optimisation.api.constraints.strategies.fitness.MalusFunction;
import de.evoal.core.api.properties.Properties;

public class ChainFunction implements MalusFunction {
    private final MalusFunction child;
    private final MalusFunction strategy;

    public ChainFunction(final MalusFunction child, final MalusFunction strategy) {
        this.child = child;
        this.strategy = strategy;
    }

    @Override
    public double apply(final Properties genoProperties, final Properties fitnessProperties, final double fitnessValue) {
        double adaptedFitnessValue = child.apply(genoProperties, fitnessProperties, fitnessValue);

        return strategy.apply(genoProperties, fitnessProperties, adaptedFitnessValue);
    }
}
