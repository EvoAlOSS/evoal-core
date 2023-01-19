package de.evoal.surrogate.main.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.properties.PropertiesPair;
import de.evoal.core.api.properties.PropertiesSpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;

import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
@Slf4j
public class TargetPointLoader {

    @Inject
    private Blackboard board;

    /**
     * For loading points from file.
     */
    private PropertiesBasedPropertiesStreamSupplier loadedProperties;


    private PropertiesStreamSupplier targetPoints;

    @SneakyThrows
    public void load(final @Observes BlackboardEntry entry) {
        if (!BlackboardEntry.TARGET_POINTS_FILE.equals(entry)) {
            return;
        }

        final String inputFileName = board.get(entry);

        log.info("Loading target points from '{}'", inputFileName);
        final File inputFile = new File(inputFileName);

        if(!inputFile.exists() || ! inputFile.canRead()) {
            log.error("Unable to read training points file '{}'", inputFile);
            throw new IllegalArgumentException("Unable to read target points file: " + inputFile);
        }

        loadedProperties = new PropertiesBasedPropertiesStreamSupplier(new FileBasedPropertiesStreamSupplier(inputFile, PropertiesSpecification.builder().build()).get().collect(Collectors.toList()));
        log.info("Loaded {} target points from '{}'", loadedProperties.size(), inputFile);
        throw new IllegalStateException("Not yet implemented");        // TODO FIXME PROPERTIES
    }

    @Produces @Named("target-stream")
    public Stream<PropertiesPair> getTargetStream(
            @Named("surrogate-source-properties-specification") final PropertiesSpecification sourceSpecification,
            @Named("surrogate-target-properties-specification") final PropertiesSpecification targetSpecification) {
        log.info("Creating target stream using {} and {}.", sourceSpecification, targetSpecification);

        return new PropertiesBasedPropertiesPairStreamSupplier(targetPoints, /*sourceSpecification*/ PropertiesSpecification.builder().build(), targetSpecification).get();
    }
}
