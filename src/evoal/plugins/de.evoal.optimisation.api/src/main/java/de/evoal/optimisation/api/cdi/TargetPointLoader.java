package de.evoal.optimisation.api.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.ListBasedEObjectStreamSupplier;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.File;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class TargetPointLoader {

    @Inject
    private Blackboard board;

    /**
     * Target point file.
     */
    private File inputFile;

    @SneakyThrows
    public void setInputFile(final @Observes BlackboardEntry entry) {
        if (!OptimisationBlackboardEntries.TARGET_POINTS_FILE.equals(entry.getLabel())) {
            return;
        }

        final String inputFileName = board.get(entry);

        log.info("Loading target points from '{}'", inputFileName);
        final File inputFile = new File(inputFileName);

        if(!inputFile.exists() || ! inputFile.canRead()) {
            log.error("Unable to read training points file '{}'", inputFile);
            throw new IllegalArgumentException("Unable to read target points file: " + inputFile);
        }

        this.inputFile = inputFile;
    }

    public EObjectPairStreamSupplier getTargetObjectStream(
        final Space sourceSpecification,
        final Space targetSpecification
        ) {
        log.info("Creating target stream using {} and {}.", sourceSpecification, targetSpecification);
        final ListBasedEObjectStreamSupplier properties = loadObjects(sourceSpecification, targetSpecification);

        return EObjectPairStreamFactory.createFromList(sourceSpecification, targetSpecification, properties);
    }

    private ListBasedEObjectStreamSupplier loadObjects(final Space sourceSpecification, final Space targetSpecification) {
        final Space spec = sourceSpecification.merge(targetSpecification);
        final ListBasedEObjectStreamSupplier streamSupplier = new ListBasedEObjectStreamSupplier(
                    new FileBasedEObjectStreamSupplier(inputFile, spec)
                            .get()
                            .collect(Collectors.toList()));
        log.info("Loaded {} target points from '{}'", streamSupplier.size(), inputFile);

        return streamSupplier;
    }

    public PropertiesPairStreamSupplier getTargetPropertiesStream(
            final PropertiesSpecification sourceSpecification,
            final PropertiesSpecification targetSpecification
    ) {
        log.info("Creating target stream using {} and {}.", sourceSpecification, targetSpecification);
        final PropertiesBasedPropertiesStreamSupplier properties = loadProperties(sourceSpecification, targetSpecification);

        return new PropertiesBasedPropertiesPairStreamSupplier(properties, sourceSpecification, targetSpecification);
    }

    private PropertiesBasedPropertiesStreamSupplier loadProperties(final PropertiesSpecification sourceSpecification, final PropertiesSpecification targetSpecification) {
        final PropertiesSpecification spec = PropertiesSpecification.builder()
                .add(sourceSpecification)
                .add(targetSpecification)
                .build();
        final PropertiesBasedPropertiesStreamSupplier streamSupplier = new PropertiesBasedPropertiesStreamSupplier(
                new FileBasedPropertiesStreamSupplier(inputFile, spec)
                        .get()
                        .collect(Collectors.toList()));
        log.info("Loaded {} target points from '{}'", streamSupplier.size(), inputFile);

        return streamSupplier;
    }
}
