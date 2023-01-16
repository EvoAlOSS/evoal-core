package de.evoal.surrogate.main.ea;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.surrogate.api.SurrogateBlackboardEntry;
import de.evoal.surrogate.api.training.TrainingDataManager;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.io.File;

@ApplicationScoped
@Slf4j
public class TrainingDataProducer {
    /*
    public void setTrainingData(final @Observes BlackboardEntry event, final Blackboard board, final TrainingDataManager manager) {
        if (!event.isSame(SurrogateBlackboardEntry.SURROGATE_TRAINING_DATA_FILE)) {
            return;
        }

        final String filename = board.get(SurrogateBlackboardEntry.SURROGATE_TRAINING_DATA_FILE);
        final File trainingFile = new File(filename);

        log.info("Using training data from {}.", filename);

        // TODO FIXME PROPERTIES
        manager.setTrainingStream(new FileBasedPropertiesStreamSupplier(trainingFile, PropertiesSpecification.builder().build()));
    }
    */
}
