package de.evoal.core.api.ecore.stream;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.io.EObjectIOFactory;
import de.evoal.core.api.ecore.io.EObjectReader;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Collections;

/**
 * A simple {@see PropertiesFactory} that works on JSON-stored list of {@see Properties}.
 */
@Slf4j
public class FileBasedEObjectStreamSupplier extends ListBasedEObjectStreamSupplier {

    /**
     * Creates a new {@see PropertiesFactory} based on the given filename.
     *
     * @param filename The file to read.
     */
    public FileBasedEObjectStreamSupplier(final File filename, final Space specification) {
        super(Collections.emptyList());
        log.info("Creating EObject stream from {} with specification {}.", filename, specification);

        try(final EObjectReader reader = EObjectIOFactory.reader(filename, specification)) {
            while(reader.hasNext()) {
                objects.add(reader.next());
            }
        } catch (final Exception e) {
            log.error("Failed to read objects from {}.", filename, e);
        }

        log.info("Successfully fetched {} objects from  {}.", objects.size(), filename);
    }
}
