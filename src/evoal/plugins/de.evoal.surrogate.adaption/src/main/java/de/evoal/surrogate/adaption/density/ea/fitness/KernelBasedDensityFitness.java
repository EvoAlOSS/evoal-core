package de.evoal.surrogate.adaption.density.ea.fitness;

import de.evoal.surrogate.adaption.density.model.KernelDensityData;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.surrogate.adaption.density.optimisation.kernel-density")
@Slf4j
public class KernelBasedDensityFitness extends DensityBasedFitness {
    public KernelBasedDensityFitness() {
        super(KernelDensityData::new);
    }
}
