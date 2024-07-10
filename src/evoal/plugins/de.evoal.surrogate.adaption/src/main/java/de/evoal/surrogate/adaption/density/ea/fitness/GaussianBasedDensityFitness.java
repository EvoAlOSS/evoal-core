package de.evoal.surrogate.adaption.density.ea.fitness;

import de.evoal.surrogate.adaption.density.model.GaussianDensityData;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Slf4j
@Named("de.evoal.surrogate.adaption.density.optimisation.gaussian-density")
public class GaussianBasedDensityFitness extends DensityBasedFitness {
    public GaussianBasedDensityFitness() {
        super(GaussianDensityData::new);
    }
}
