package de.evoal.optimisation.api.correlations;

import de.evoal.core.api.properties.Properties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Root class for all existing correlations.
 */
@Data
public class Correlations {

    /**
     * The concrete list of all correlations.
     */
    private final List<Correlation> correlations = new ArrayList<>();

    public List<Correlation> find(final Properties candidate, final int chromosomeIndex) {

        return correlations.stream()
                           .filter(c -> c.matchesSource(chromosomeIndex, (Number)candidate.get(chromosomeIndex)))
                           .collect(Collectors.toList());
    }

    public int findCorrelationRoot(final Properties candidate, final int chromosomeIndex) {
        final double chromosomeValue = candidate.getAsDouble(chromosomeIndex);

        for(final Correlation correlation : correlations) {
            if(!correlation.matchesTarget(chromosomeIndex, chromosomeValue)) {
                continue;
            }

            final int sourceIndex = correlation.getChromosomeOne();
            final double sourceValue = candidate.getAsDouble(sourceIndex);

            if(!correlation.matchesSource(sourceIndex, sourceValue)) {
                continue;
            }

            return findCorrelationRoot(candidate, sourceIndex);
        }

        return chromosomeIndex;
    }
}
