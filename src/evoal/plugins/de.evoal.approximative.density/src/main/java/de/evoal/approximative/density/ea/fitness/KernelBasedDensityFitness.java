package de.evoal.approximative.density.ea.fitness;

import de.evoal.approximative.density.model.KernelDensityData;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Slf4j
@Named("kernel-density")
public class KernelBasedDensityFitness extends DensityBasedFitness {
    public KernelBasedDensityFitness() {
        super(KernelDensityData::new);
    }
}
