package de.evoal.surrogate.adaption.density.ea.fitness;

import de.evoal.surrogate.adaption.density.model.GaussianDensityData;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.surrogate.adaption.density.optimisation.gaussian-density")
@Slf4j
public class GaussianBasedDensityFitness extends DensityBasedFitness {
    public GaussianBasedDensityFitness() {
        super(GaussianDensityData::new);
    }
}
