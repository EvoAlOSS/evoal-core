package de.evoal.surrogate.api.io;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.Space;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.net.URI;

@ApplicationScoped
@Slf4j
public class ModelStorageFactory {
    /**
     * Creates a model storage for reading or writing from the given location.
     *
     * @param location The location to use.
     * @return A valid model storage.
     */
    public @NonNull ModelStorage create(final  @NonNull URI location, final @NonNull Space inputSpace, final @NonNull Space outputSpace) {
        final String path = location.getPath();
        final String [] parts = path.split("\\.");

        final String filetype = parts[parts.length - 1];

        log.info("Creating model storage for type '{}'.", filetype);

        return BeanFactory.create(filetype, ModelStorage.class)
                          .setLocation(location)
                          .setSpaces(inputSpace, outputSpace);
    }
}
