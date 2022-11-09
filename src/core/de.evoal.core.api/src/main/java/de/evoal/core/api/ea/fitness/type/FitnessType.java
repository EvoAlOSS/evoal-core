package de.evoal.core.api.ea.fitness.type;

/**
 * The fitness type of the heuristic search.
 */
public interface FitnessType extends Comparable<FitnessType> {
    /**
     * @return All fitness values
     */
    public double[] getFitnessValues();
}
