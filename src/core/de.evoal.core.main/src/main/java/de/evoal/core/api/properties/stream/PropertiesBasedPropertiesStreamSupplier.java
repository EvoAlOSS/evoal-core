package de.evoal.core.api.properties.stream;

import de.evoal.core.api.properties.Properties;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * A supplier of a stream of {@see Properties} based on a list of {@see Properties}.
 */
@Slf4j
public class PropertiesBasedPropertiesStreamSupplier implements PropertiesStreamSupplier {
    /**
     * The raw collection to stream
     */
    protected final List<Properties> properties;

    /**
     * Creates a new {@see PropertiesStreamSupplier} that is based on a collection of {@see Properties} and a required
     *   {@see PropertiesSpecification}.
     *
     * @param properties The collection of properties to stream.
     */
    public PropertiesBasedPropertiesStreamSupplier(final List<Properties> properties) {
        this.properties = new ArrayList<>(properties);
    }

    @Override
    public Stream<Properties> get() {
        return properties.stream();
    }

    public int size() {
        return properties.size();
    }
}
