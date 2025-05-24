package de.evoal.surrogate.api.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.info.FeatureDependencies;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.info.PropertiesDependencies;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.main.internal.SurrogateFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

@ApplicationScoped
@Slf4j
public class SurrogateProducer {

    @Inject
    private EAnnotationHelper helper;

    @Inject @Named("surrogate-loader")
    private Function<@NonNull File, @NonNull SurrogateConfiguration> loader;

    /**
     * This function cache is necessary to access function from different places
     */
    private Map<File, SurrogateFunction> functionCache = new HashMap<>();

    /**
     * Loads a pre-trained surrogate function from file.
     *
     * @param file The file containing the surrogate function.
     * @param space The functions space.
     * @return The loaded function
     */
    public SurrogateFunction load(final File file, final Space space) {
        log.info("Using pre-trained surrogate model {}.", file);

        if(functionCache.containsKey(file)) {
            log.info("Using cached function");
            return functionCache.get(file);
        }

        if(!file.exists()) {
            log.error("Cannot find pre-trained surrogate model: {}", file);
            throw new RuntimeException("Cannot find pre-trained surrogate model: " + file);
        }

        if(!file.canRead()) {
            log.error("Cannot read pre-trained surrogate model: {}", file);
            throw new RuntimeException("Cannot read pre-trained surrogate model: " + file);
        }

        final SurrogateConfiguration configuration = loader.apply(file);
        configuration.link(space);

        final SurrogateFunction function = SurrogateFactory.create(configuration);
        functionCache.put(file, function);

        return function;
    }

    public SurrogateFunction loadCached(final File file) {
        if(!functionCache.containsKey(file)) {
            log.error("Cannot find pre-trained surrogate model: {}", file);
            throw new IllegalStateException("Cannot find pre-trained surrogate model: " + file);
        }

        return functionCache.get(file);
    }

    /**
     * Sets the pre-trained surrogate model if the configuration is set via the black board .
     *
     * @param event Event fired if a black board entry is set
     * @param board The black board
     * @param loader The function to load the pre-trained function
     */
    /*
    public void setPreTrainedSurrogateXXX(final @Observes BlackboardEntry event,
                                       final Blackboard board,
                                       final Function<@NonNull File,  @NonNull SurrogateConfiguration> loader) {
        if(!event.isSame(SurrogateBlackboardEntries.SURROGATE_PRETRAINED_FILE)) {
            return;
        }

        final String filename = board.get(SurrogateBlackboardEntries.SURROGATE_PRETRAINED_FILE);
        final File file = new File(filename);

        log.info("Using pre-trained surrogate model {}.", filename);
        if(!file.exists()) {
            log.error("Cannot find pre-trained surrogate model: {}", file);
            return;
        }

        if(!file.canRead()) {
            log.error("Cannot read pre-trained surrogate model: {}", file);
            return;
        }

        this.configuration = loader.apply(file);
    }

//    @Produces
//    @Dependent
    public SurrogateConfiguration create(final Space space) {
        return configuration;
    }

    //    @Produces
    //@Dependent
    //@Named("surrogate-source-space-specification")
    public Space createSourceSpace(final SurrogateConfiguration config) {
        return SurrogateConfiguration.getInputs(config);
    }

    //@Produces
    //@Dependent
    //@Named("surrogate-target-space-specification")
    public Space createTargetSpace(final SurrogateConfiguration config) {
        return SurrogateConfiguration.getOutputs(config);
    }

    //@Produces
    //@Dependent
    //@Named("surrogate-source-properties-specification")
    public PropertiesSpecification createSourceProperties(final SurrogateConfiguration config, final EAnnotationHelper helper) {
        final Stream descriptions =
                config.getFunctions()
                      .stream()
                      .flatMap(f -> f.getInputData().stream())
                      .distinct()
                      .map(helper::dataDescriptionOf);

        return PropertiesSpecification.builder()
                .add(descriptions)
                .build();
    }

    //@Produces
    //@Dependent
    //@Named("surrogate-target-properties-specification")
    public PropertiesSpecification createTargetProperties(final SurrogateConfiguration config) {
        final Stream descriptions =
                config.getFunctions()
                        .stream()
                        .flatMap(f -> f.getOutputData().stream())
                        .distinct()
                        .map(helper::dataDescriptionOf);

        return PropertiesSpecification.builder()
                .add(descriptions)
                .build();
    }

    public SurrogateFunction createXXX(final Blackboard board) {
        final SurrogateConfiguration configuration = this.configuration;
        Requirements.requireNotNull(configuration);

        return SurrogateFactory.create(configuration);
    }
    */
}
