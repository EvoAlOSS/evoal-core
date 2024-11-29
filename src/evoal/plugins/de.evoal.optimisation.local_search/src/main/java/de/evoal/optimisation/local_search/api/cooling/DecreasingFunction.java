package de.evoal.optimisation.local_search.api.cooling;

import de.evoal.core.api.cdi.EvoalComponent;

/**
 * Interface for cooling schedules for simulated annealing algorithm
 */
public interface DecreasingFunction extends EvoalComponent<DecreasingFunction> {
    /**
     * updates temperature according to cooling function
     * @param currentTemp
     * @param initialTemp
     * @param iteration
     * @return new temperature
     */
    double decrease(double currentTemp, double initialTemp, int iteration);
}