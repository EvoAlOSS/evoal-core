package de.evoal.surrogate.main.ea;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.api.constraints.strategies.RepairStrategy;
import de.evoal.languages.model.base.Instance;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import io.jenetics.util.RandomRegistry;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Dependent
public class TrainingRepairStrategy implements RepairStrategy {
    @Inject
    private Blackboard board;

    @Inject
    @Named("genotype-specification")
    private PropertiesSpecification sourceSpecification;

    @Inject
    @Named("surrogate-target-properties-specification")
    private PropertiesSpecification targetSpecification;

    private List<Properties> trainingData;

    @Override
    public RepairStrategy init(final Instance configuration) {
        final String filename = board.get(SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA_FILE);
        final File trainingFile = new File(filename);

        log.info("Using training data from {} for population.", filename);

        final PropertiesSpecification totalSpecification =
                PropertiesSpecification.builder()
                        .add(sourceSpecification)
                        .add(targetSpecification)
                        .build();

        final PropertiesStreamSupplier stream = new FileBasedPropertiesStreamSupplier(trainingFile, totalSpecification);

        trainingData =  stream
                .apply(totalSpecification)
                .map(p -> new Properties(sourceSpecification).putAll(p))
                .unordered()
                .collect(Collectors.toList());

        return this;
    }


    @Override
    public Properties apply(final Properties candidate, long generation) {
        int index = RandomRegistry.random()
                                  .nextInt(0, trainingData.size());

        return trainingData.get(index);
    }
}
