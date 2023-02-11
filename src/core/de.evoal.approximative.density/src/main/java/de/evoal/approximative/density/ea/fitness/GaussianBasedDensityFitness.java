package de.evoal.approximative.density.ea.fitness;

import de.evoal.approximative.density.model.GaussianDensityData;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Slf4j
@Named("gaussian-density")
public class GaussianBasedDensityFitness extends DensityBasedFitness {
    public GaussianBasedDensityFitness() {
        super(GaussianDensityData::new);
    }
}
