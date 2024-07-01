package de.evoal.optimisation.api.correlations;

import lombok.Data;

@Data
public class RangedCorrelation extends Correlation {
    /**
     * Boundaries of first chromosome value.
     */
    private Range chromosomeOneRange;

    /**
     * Boundaries of second chromosome value.
     */
    private Range chromosomeTwoRange;

    @Override
    public boolean matchesSource(int chromosomeIndex, final Number chromosomeValue) {
        if(!super.matchesSource(chromosomeIndex, chromosomeValue)) {
            return false;
        }

        return getChromosomeOneRange().includes(chromosomeValue.doubleValue());
    }

    @Override
    public boolean matchesTarget(int chromosomeIndex, final Number chromosomeValue) {
        if(!super.matchesTarget(chromosomeIndex, chromosomeValue)) {
            return false;
        }

        return getChromosomeTwoRange().includes(chromosomeValue.doubleValue());
    }
}
