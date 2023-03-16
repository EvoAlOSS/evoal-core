package de.evoal.surrogate.main.ea;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.ea.api.codec.CustomCodec;
import de.evoal.core.ea.api.initial.InitialPopulation;
import de.evoal.languages.model.instance.Instance;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionInit;
import io.jenetics.engine.EvolutionStream;
import io.jenetics.util.ISeq;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;

@Slf4j
public class TrainingInitialPopulation<G extends Gene<?, G>, C extends Comparable<C>> implements InitialPopulation<G, C> {

    @Inject
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.size-of-population")
    private int sizeOfPopulation;

    @Inject
    private Blackboard board;

    @Inject
    @Named("genotype-specification")
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
        final String filename = board.get(SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA_FILE);
        final File trainingFile = new File(filename);

        log.info("Using training data from {} for population.", filename);

        final PropertiesStreamSupplier stream = new FileBasedPropertiesStreamSupplier(trainingFile, PropertiesSpecification.builder().add(sourceSpecification).add(targetSpecification).build());

        return stream
                       .apply(totalSpecification)
                       .map(p -> new Properties(sourceSpecification).putAll(p))
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
