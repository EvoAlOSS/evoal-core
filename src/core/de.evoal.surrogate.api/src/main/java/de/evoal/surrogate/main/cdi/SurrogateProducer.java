package de.evoal.surrogate.main.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.properties.PropertiesDependencies;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.SurrogateBlackboardEntry;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.FunctionCombiner;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.main.internal.SurrogateFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.File;
import java.util.function.Function;

@ApplicationScoped
@Slf4j
public class SurrogateProducer {

    private SurrogateConfiguration configuration;

    public void setPreTrainedSurrogate(final @Observes BlackboardEntry event, final Blackboard board, final Function<@NonNull File, @NonNull SurrogateConfiguration> loader) {
        if(!event.isSame(SurrogateBlackboardEntry.SURROGATE_PRETRAINED_FILE)) {
            return;
        }

        final String filename = board.get(SurrogateBlackboardEntry.SURROGATE_PRETRAINED_FILE);
        final File file = new File(filename);

        log.info("Using pre-trained surrogate model {}.", filename);
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
                           .getInputData()
                           .stream())
                .build();
    }

    @Produces
    @Dependent
    @Named("surrogate-target-properties-specification")
    public PropertiesSpecification createTargetProperties(final SurrogateConfiguration config) {
        return PropertiesSpecification.builder()
                .add(config.getMappings()
                        .get(0)
                        .getOutputData()
                        .stream())
                .build();
    }

    @Produces @Dependent
    public SurrogateFunction createSurrogateFunction() {
        final SurrogateConfiguration configuration = this.configuration;

        Requirements.requireNotNull(configuration);

        return SurrogateFactory.create(configuration, null);
    }

    @Produces @Named("output-dependencies") // FIXME Should be part of core to not wire core and surrogate the hard way.
    public PropertiesDependencies calculateOutputDependencies(
            @Named("surrogate-source-properties-specification") final PropertiesSpecification source,
            final SurrogateFunction function,
            @Named("surrogate-target-properties-specification") final PropertiesSpecification target) {

        return _calculate(function, 0, new PropertiesDependencies(source));
    }

    private PropertiesDependencies _calculate(final SurrogateFunction function, final int index, final PropertiesDependencies dependencies) {
        if(index == function.getMappings().size()) {
            return dependencies;
        }

        final FunctionCombiner current = function.getMappings().get(index);
        final PropertiesDependencies next = new PropertiesDependencies(current.getOutputSpecification());

        for(final PartialSurrogateFunction fn : current.getFunctions()){
            for(final PropertySpecification ops : fn.getOutputProperty().getProperties()) {
                next.add(ops, fn.getUsedProperties());
            }
        }

        return _calculate(function, index + 1, next);
    }
}
