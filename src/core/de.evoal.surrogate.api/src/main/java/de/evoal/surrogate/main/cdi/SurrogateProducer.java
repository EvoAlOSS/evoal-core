package de.evoal.surrogate.main.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.surrogate.api.SurrogateBlackboardEntry;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.function.Function;

@ApplicationScoped
@Slf4j
public class SurrogateProducer {

    private SurrogateConfiguration configuration;

    public void setPreTrainedSurrogate(final @Observes BlackboardEntry event, final Blackboard board, final Function<@NonNull File, @NonNull SurrogateConfiguration> loader) {
        if(!event.isSame(SurrogateBlackboardEntry.PRETRAINED_SURROGATE_FILE)) {
            return;
        }

        final String filename = board.get(SurrogateBlackboardEntry.PRETRAINED_SURROGATE_FILE);
        final File file = new File(filename);

        if(!file.exists()) {
            log.error("Cannot find pre-trained surrogate model: {}", file);
            return;
        }

        this.configuration = loader.apply(file);
    }

    @Produces
    @Dependent
    public SurrogateConfiguration create() {
        return configuration;
    }

    @Produces
    @Dependent
    @Named("surrogate-source-properties-specification")
    public PropertiesSpecification createSourceProperties(final SurrogateConfiguration config) {
        return PropertiesSpecification.builder()
                .add(config.getMappings()
                           .get(0)
                           .getInputDimensions()
                           .stream())
                .build();
    }

    @Produces
    @Dependent
    @Named("surrogate-target-properties-specification")
    public PropertiesSpecification createTargetProperties(final SurrogateConfiguration config) {
        return PropertiesSpecification.builder()
                .add(config.getMappings()
                        .get(config.getMappings().size() - 1)
                        .getOutputDimensions()
                        .stream())
                .build();
    }
}
