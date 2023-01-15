package de.evoal.approximative.density.model;

import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;

public interface DensityData {

    public void attachTo(final PartialFunctionConfiguration configuration, final String propertyName);

    public double probability(final double value);
}
