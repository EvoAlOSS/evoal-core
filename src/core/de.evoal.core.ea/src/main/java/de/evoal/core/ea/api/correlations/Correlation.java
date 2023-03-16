package de.evoal.core.ea.api.correlations;

import de.evoal.core.ea.api.codec.CustomCodec;
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
     * Codec for encoding and decoding between domain and ea values.
     */
    private CustomCodec codec;

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
