package de.evoal.surrogate.main.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.properties.info.PropertiesDependencies;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;
import de.evoal.languages.model.mll.SurrogateDefinition;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import de.evoal.surrogate.api.configuration.FunctionCombinerConfiguration;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.FunctionCombiner;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.main.internal.SurrogateFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class SurrogateProducer {

    private SurrogateConfiguration configuration;

    public void setPreTrainedSurrogate(final @Observes BlackboardEntry event, final Blackboard board, final Function<@NonNull File, @NonNull SurrogateConfiguration> loader) {
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

        this.configuration = loader.apply(file);
        
        final EObject mlConfiguration = board.get(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION);
        final EObject eaConfiguration = board.get(CoreBlackboardEntries.OPTIMISATION_CONFIGURATION);

        final Map<String, PropertySpecification> specifications = new HashMap<>();
        addDataFrom(specifications, mlConfiguration);
        addDataFrom(specifications, eaConfiguration);

        linkData(specifications);
    }

    private void linkData(final Map<String, PropertySpecification> specifications) {
        for(final FunctionCombinerConfiguration fcc : configuration.getMappings()) {
            for(final PartialFunctionConfiguration pfc : fcc.getFunctions()) {
                pfc.setInputData(
                        PropertiesSpecification.builder()
                                .add(
                                        pfc.getInputDimensions()
                                                .stream()
                                                .map(specifications::get)
                                                .map(PropertySpecification::type)
                                )
                                .build()

                );

                pfc.setOutputData(
                        PropertiesSpecification.builder()
                                .add(
                                        pfc.getOutputDimensions()
                                                .stream()
                                                .map(specifications::get)
                                                .map(PropertySpecification::type)
                                )
                                .build()

                );
            }


            fcc.setInputData(
                fcc.getInputDimensions()
                        .stream()
                        .map(specifications::get)
                        .map(PropertySpecification::type)
                        .map(DataDescription.class::cast)
                        .collect(Collectors.toList())

            );

            fcc.setOutputData(
                fcc.getOutputDimensions()
                        .stream()
                        .map(specifications::get)
                        .map(PropertySpecification::type)
                        .map(DataDescription.class::cast)
                        .collect(Collectors.toList())
            );
        }
    }

    private void addDataFrom(final Map<String, PropertySpecification> specifications, final EObject eTree) {
        final TreeIterator<EObject> contentIterator = eTree.eAllContents();
        while(contentIterator.hasNext()) {
            final EObject content = contentIterator.next();

            if(content instanceof final DataReference ref) {
                final PropertySpecification spec = new PropertySpecification(ref.getDefinition().getName(), ref.getDefinition());

                specifications.put(spec.name(), spec);
            } else if(content instanceof final SurrogateDefinition def) {
                def.getInputs()
                        .stream()
                        .forEach(descr -> {
                            final PropertySpecification spec = new PropertySpecification(descr.getName(), descr);

                            specifications.put(spec.name(), spec);
                        });

                def.getOutputs()
                        .stream()
                        .forEach(descr -> {
                            final PropertySpecification spec = new PropertySpecification(descr.getName(), descr);

                            specifications.put(spec.name(), spec);
                        });

            } else if(content instanceof final PartialSurrogateFunctionDefinition def) {
                def.getInputs()
                        .stream()
                        .forEach(descr -> {
                            final PropertySpecification spec = new PropertySpecification(descr.getName(), descr);

                            specifications.put(spec.name(), spec);
                        });

                def.getOutputs()
                        .stream()
                        .forEach(descr -> {
                            final PropertySpecification spec = new PropertySpecification(descr.getName(), descr);

                            specifications.put(spec.name(), spec);
                        });

            }

        }
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
                .addDescriptions(config.getMappings()
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
                .addDescriptions(config.getMappings()
                        .get(0)
                        .getOutputData()
                        .stream())
                .build();
    }

    @Produces @Dependent
    public SurrogateFunction createSurrogateFunction(final Blackboard board, @Named("genotype-specification") PropertiesSpecification specification) {
        final SurrogateConfiguration configuration = this.configuration;

        Requirements.requireNotNull(configuration);

        return SurrogateFactory.create(configuration, specification);
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
