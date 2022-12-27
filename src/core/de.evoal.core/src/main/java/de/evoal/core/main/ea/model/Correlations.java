package de.evoal.core.main.ea.model;

import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.properties.Properties;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Root class for all existing correlations.
 */
@Data
public class Correlations<G extends Gene<?, G>> {
    /**
     * Codec for encoding and decoding between domain and ea values.
     */
    private CustomCodec<G> codec;

    /**
     * The concrete list of all correlations.
     */
    private final List<Correlation> correlations = new ArrayList<>();

    public Correlations(final CustomCodec<G> codec) {
        this.codec = codec;
    }

    public List<Correlation> find(final Genotype<G> genotype, final int chromosomeIndex) {
        final Properties properties = codec.decode(genotype);

        return correlations.stream()
                           .filter(c -> c.matchesSource(chromosomeIndex, properties.getAsDouble(chromosomeIndex)))
                           .collect(Collectors.toList());
    }

    public int findCorrelationRoot(final Genotype<G> genotype, final int chromosomeIndex) {
        final Properties properties = codec.decode(genotype);

        final double chromosomeValue = properties.getAsDouble(chromosomeIndex);

        for(final Correlation correlation : correlations) {
            if(!correlation.matchesTarget(chromosomeIndex, chromosomeValue)) {
                continue;
            }

            final int sourceIndex = correlation.getChromosomeOne();
            final double sourceValue = properties.getAsDouble(sourceIndex);

            if(!correlation.matchesSource(sourceIndex, sourceValue)) {
                continue;
            }

            return findCorrelationRoot(genotype, sourceIndex);
        }

        return chromosomeIndex;
    }
}
