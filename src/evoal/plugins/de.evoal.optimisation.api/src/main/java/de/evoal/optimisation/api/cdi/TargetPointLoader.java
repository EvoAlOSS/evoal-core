package de.evoal.optimisation.api.cdi;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import de.evoal.models.core.ecore.Space;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.ListBasedEObjectStreamSupplier;

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
}
