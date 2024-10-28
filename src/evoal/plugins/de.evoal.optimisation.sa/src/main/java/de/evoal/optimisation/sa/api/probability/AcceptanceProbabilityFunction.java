package de.evoal.optimisation.sa.api.probability;

import de.evoal.core.api.cdi.EvoalComponent;

/**
 * Interface for acceptance functions for simulated annealing algorithm.
 */
public interface AcceptanceProbabilityFunction extends EvoalComponent<AcceptanceProbabilityFunction> {
    /**
     * determines acceptance probability for neighbour: P(f(s), f(s'), T)
     * @param currentFitness
     * @param neighbourFitness
     * @param temperature
     * @return  P(f(s), f(s'), T)
     */
    double apply(double[] currentFitness, double[] neighbourFitness, double temperature);
}