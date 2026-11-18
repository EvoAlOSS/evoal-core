package de.evoal.surrogate.adaption.density.fitness;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.surrogate.adaption.density.model.GaussianDensityData;

/**
 * Density adaption with the Gaussian density stored with the model (DL type
 *   {@code 'gaussian-density'}).
 */
@Dependent
@Named("de.evoal.surrogate.adaption.density.optimisation.gaussian-density")
public class GaussianDensityStep extends DensityStep {
    public GaussianDensityStep() {
        super(GaussianDensityData::new);
    }
}
