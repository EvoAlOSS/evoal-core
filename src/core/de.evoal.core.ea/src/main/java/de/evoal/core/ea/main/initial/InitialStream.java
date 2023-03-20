package de.evoal.core.ea.main.initial;

import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.ea.api.codec.CustomCodec;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionStream;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.stream.Stream;

@Dependent
public class InitialStream {
    private InitialCandidatesProvider provider;
    private Engine engine;

    @Inject
    private CustomCodec codec;

    public InitialStream init(final InitialCandidatesProvider provider, final Engine<?, OptimisationValue> engine) {
        this.provider = provider;
        this.engine = engine;

        return this;
    }

    public EvolutionStream create() {
        final Stream<Properties> individuals = provider.create().limit(1000);
        final Stream<Genotype> encoded = individuals.map(codec::encode);

        final Iterable<Genotype> iter = () -> encoded.iterator();

        return engine.stream(iter);
    }
}
