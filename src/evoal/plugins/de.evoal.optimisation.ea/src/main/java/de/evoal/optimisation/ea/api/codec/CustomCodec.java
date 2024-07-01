package de.evoal.optimisation.ea.api.codec;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.engine.Codec;

/**
 * A custom codec for our properties.
 *
 * @param <G> The gene type.
 */
public interface CustomCodec<G extends Gene<?, G>> extends Codec<Properties, G>, EvoalComponent<CustomCodec<G>> {

    /**
     * Encodes an individual according to the codes into a genotype.
     *
     * @param p The individual to code.
     * @return The generated (non-null) genotype.
     */
    Genotype<G> encode(final Properties p);
}
