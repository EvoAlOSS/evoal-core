package de.evoal.optimisation.main.initial;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesStreamSupplier;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;
import de.evoal.core.api.utils.VariableToPropertiesHelper;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Named("de.evoal.optimisation.core.specify-candidates")
@Dependent
public class SpecifiedInitialCandidates implements InitialCandidatesProvider {

    @Inject
    @Named("search-space-specification")
    private PropertiesSpecification sourceSpecification;

    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification targetSpecification;

    private PropertiesSpecification totalSpecification;

    private PropertiesStreamSupplier streamSupplier;

    @Inject
    private AttributeHelper helper;

    private boolean random;

    @Inject
    protected VariableToPropertiesHelper variableToPropertiesHelper;

    private Stream<Properties> createInitialPopulation() {
        final List<Properties> properties = streamSupplier.apply(totalSpecification)
                .map(p -> new Properties(sourceSpecification).putAll(p))
                .collect(Collectors.toList());

        //random or linearly ordered infinite properties stream
        return getStreamByOrder(properties);
    }

    @Override
    public InitialCandidatesProvider init(final Instance configuration) {
        totalSpecification = PropertiesSpecification.builder()
                .add(sourceSpecification)
                .add(targetSpecification)
                .build();

        final Attribute candidateFile = configuration.findAttribute("candidate-file");
        final Attribute variableList = configuration.findAttribute("candidate-list");
        this.random = helper.lookup(configuration, "random");

        if(candidateFile == null && variableList == null) {
            log.error("No candidates have been specified! Please specify candidate list or candidates from file");
        } else if (candidateFile == null) {
            //read list of instances from attribute
            List<Instance> candidates = helper.lookup(configuration, "candidate-list");
            streamSupplier = createStreamFromCandidateList(candidates);
        } else {
            //create stream from file, this takes priority over candidate list
            final String filename = helper.lookup(configuration, "candidate-file");
            streamSupplier = createStreamFromFilename(filename);
        }

        return this;
    }

    private PropertiesStreamSupplier createStreamFromFilename(final String filename) {
        log.info("Creating stream supplier from candidates in {}.", filename);
        final File candidateFile = new File(filename);
        return new FileBasedPropertiesStreamSupplier(candidateFile, totalSpecification);
    }

    private PropertiesStreamSupplier createStreamFromCandidateList(List<Instance> candidates) {
        log.info("Creating stream supplier from candidates specified in .ol file.");

        //generate list of properties from candidates
        List<Properties> properties = new ArrayList<>();
        for (Instance i : candidates) {
            Properties prop = variableToPropertiesHelper.candidateToProperties(i, totalSpecification);
            log.info("read properties {}", prop);
            properties.add(prop);
        }

        return new PropertiesBasedPropertiesStreamSupplier(properties);
    }

    private Stream<Properties> getStreamByOrder(List<Properties> properties) {
        if (this.random) {
            log.info("Creating initial candidates stream with random order");
            final int upperLimit = properties.size();
            final RandomGenerator random = RandomGenerator.getDefault();
            final Supplier<Properties> chooseRandomly = () -> {
                int index = random.nextInt(upperLimit);
                return properties.get(index);
            };

            return Stream.iterate(chooseRandomly.get(), x -> chooseRandomly.get());
        } else {
            log.info("Creating initial candidates stream with linear order");
            return Stream.iterate(0, i -> (i + 1) % properties.size())
                    .map(properties::get);
        }
    }

    @Override
    public Stream<Properties> create() {
        return createInitialPopulation();
    }
}