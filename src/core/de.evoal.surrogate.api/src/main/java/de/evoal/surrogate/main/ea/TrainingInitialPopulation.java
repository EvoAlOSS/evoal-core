package de.evoal.surrogate.main.ea;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.initial.InitialPopulation;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.instance.Instance;
import de.evoal.surrogate.api.training.TrainingDataManager;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionInit;
import io.jenetics.engine.EvolutionStream;
import io.jenetics.util.ISeq;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

public class TrainingInitialPopulation<G extends Gene<?, G>, C extends Comparable<C>> implements InitialPopulation<G, C> {

    @Inject
    @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.size_of_population")
    private int sizeOfPopulation;

    @Inject
    private TrainingDataManager manager;

    @Inject
    @Named("surrogate-source-properties-specification")
    private PropertiesSpecification sourceSpecification;

    @Inject
    @Named("surrogate-target-properties-specification")
    private PropertiesSpecification targetSpecification;

    private PropertiesSpecification totalSpecification;

    @PostConstruct
    public void init() {
        totalSpecification = PropertiesSpecification.builder()
                                                    .add(sourceSpecification)
                                                    .add(targetSpecification)
                                                    .build();
    }

    @Inject
    private CustomCodec encoding;

    private EvolutionInit<G> createTargetBasedInitialPopulation() {
        return EvolutionInit.of(createInitialPopulation(), 1l);
    }

    private ISeq<Genotype<G>> createInitialPopulation() {
        return manager.getTrainingStream()
                       .apply(totalSpecification)
                       .unordered()
                       .limit(sizeOfPopulation)
                       .map(((CustomCodec<G>)encoding)::encode)
                       .collect(ISeq.toISeq());
    }

    @Override
    public InitialPopulation init(final Instance initialization) {
        return this;
    }

    @Override
    public EvolutionStream<G, C> create(final Engine<G, C> engine) {
        return engine.stream(createTargetBasedInitialPopulation());
    }
}
