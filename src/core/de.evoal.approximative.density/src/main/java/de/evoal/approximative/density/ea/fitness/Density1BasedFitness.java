package de.evoal.approximative.density.ea.fitness;

import de.evoal.approximative.density.model.DensityData1;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Slf4j
@Named("density1")
public class Density1BasedFitness extends DensityBasedFitness {
    public Density1BasedFitness() {
        super(DensityData1::new);
    }
}
