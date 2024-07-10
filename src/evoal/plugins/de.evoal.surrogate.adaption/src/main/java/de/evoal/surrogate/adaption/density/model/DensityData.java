package de.evoal.surrogate.adaption.density.model;

import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;

public interface DensityData {

    void attachTo(final PartialFunctionConfiguration configuration, final String propertyName);

    double probability(final double value);
}
