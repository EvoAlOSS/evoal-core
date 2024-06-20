package de.evoal.surrogate.main.ea;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.languages.model.base.Instance;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.List;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class TrainingInitialCandidates implements InitialCandidatesProvider {
    @Inject
    private Blackboard board;

    @Inject
    @Named("genotype-specification")
    private PropertiesSpecification sourceSpecification;

    @Inject
    @Named("surrogate-target-properties-specification")
    private PropertiesSpecification targetSpecification;

    private PropertiesSpecification totalSpecification;

    private Stream<Properties> createInitialPopulation() {
        final String filename = board.get(SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA_FILE);
        final File trainingFile = new File(filename);

        log.info("Using training data from {} for population.", filename);

        final PropertiesStreamSupplier stream = new FileBasedPropertiesStreamSupplier(trainingFile, PropertiesSpecification.builder().add(sourceSpecification).add(targetSpecification).build());
        final List<Properties> properties = stream.apply(totalSpecification)
                        .map(p -> new Properties(sourceSpecification).putAll(p))
                        .collect(Collectors.toList());

        final int upperLimit = properties.size();
        final RandomGenerator random = RandomGenerator.getDefault();
        final Supplier<Properties> chooseRandomly = () -> {
            int index = random.nextInt(upperLimit);
            return properties.get(index);
        };

        return Stream.iterate(chooseRandomly.get(), x -> chooseRandomly.get());
    }

    @Override
    public InitialCandidatesProvider init(final Instance configuration) {
        totalSpecification = PropertiesSpecification.builder()
                                .add(sourceSpecification)
                                .add(targetSpecification)
                                .build();

        return this;
    }

    @Override
    public Stream<Properties> create() {
        return createInitialPopulation();
    }
}
