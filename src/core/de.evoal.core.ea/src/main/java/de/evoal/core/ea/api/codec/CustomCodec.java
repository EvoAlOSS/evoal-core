package de.evoal.core.ea.api.codec;

import de.evoal.core.api.properties.Properties;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.engine.Codec;

/**
 * A custom codec for our properties.
 *
 * @param <G> The gene type.
 */
public interface CustomCodec<G extends Gene<?, G>> extends Codec<Properties, G> {

    /**
     * Encodes an individual according to the codes into a genotype.
     *
     * @param p The individual to code.
     * @return The generated (non-null) genotype.
     */
    public Genotype<G> encode(final Properties p);
}
