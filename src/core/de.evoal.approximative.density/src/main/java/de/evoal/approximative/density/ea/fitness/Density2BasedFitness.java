package de.evoal.approximative.density.ea.fitness;

import de.evoal.approximative.density.model.DensityData2;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Slf4j
@Named("density2")
public class Density2BasedFitness extends DensityBasedFitness {
    public Density2BasedFitness() {
        super(DensityData2::new);
    }
}
