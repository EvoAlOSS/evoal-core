package de.evoal.optimisation.api.correlations;

import lombok.Data;

/**
 * Base class for correlations. Represents a correlation between two chromosomes.
 */
@Data
public class Correlation {
    /**
     * Index of first chromosome.
     */
    private int chromosomeOne;

    /**
     * Index of second chromosome.
     */
    private int chromosomeTwo;

    /**
     * Correlation factor
     */
    private double correlationFactor;

    public boolean matchesSource(int chromosomeIndex, final Number chromosomeValue) {
        return chromosomeOne == chromosomeIndex;
    }

    public boolean matchesTarget(int chromosomeIndex, final Number chromosomeValue) {
        return chromosomeTwo == chromosomeIndex;
    }
}
