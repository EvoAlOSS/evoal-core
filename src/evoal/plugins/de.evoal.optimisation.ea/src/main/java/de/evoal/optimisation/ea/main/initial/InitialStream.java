package de.evoal.optimisation.ea.main.initial;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionStream;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Stream;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Dependent
public class InitialStream {

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.size-of-population")
    private int populationSize;

    private InitialCandidatesProvider provider;

    private Engine engine;

    @Inject @Named("codec")
    private CustomCodec codec;

    public InitialStream init(final InitialCandidatesProvider provider, final Engine<?, OptimisationValue> engine) {
        this.provider = provider;
        this.engine = engine;

        return this;
    }

    public EvolutionStream create() {
        final Stream<Properties> stream = provider.create();

        final Stream<Genotype> encoded = stream.limit(populationSize)
                                               .map(codec::encode);

        final Iterable<Genotype> iter = () -> encoded.iterator();

        return engine.stream(iter);
    }
}
