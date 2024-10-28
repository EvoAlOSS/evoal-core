package de.evoal.optimisation.sa.api.cooling;

import de.evoal.core.api.cdi.EvoalComponent;

/**
 * Interface for cooling schedules for simulated annealing algorithm
 */
public interface CoolingStrategy extends EvoalComponent<CoolingStrategy> {
    /**
     * updates temperature according to cooling function
     * @param currentTemp
     * @param iteration
     * @return new temperature
     */
    double cool(double currentTemp, int iteration);
}