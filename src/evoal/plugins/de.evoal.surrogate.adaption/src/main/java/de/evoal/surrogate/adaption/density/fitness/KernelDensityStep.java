package de.evoal.surrogate.adaption.density.fitness;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.surrogate.adaption.density.model.KernelDensityData;

/**
 * Density adaption with the kernel density stored with the model (DL type
 *   {@code 'kernel-density'}).
 */
@Dependent
@Named("de.evoal.surrogate.adaption.density.optimisation.kernel-density")
public class KernelDensityStep extends DensityStep {
    public KernelDensityStep() {
        super(KernelDensityData::new);
    }
}
