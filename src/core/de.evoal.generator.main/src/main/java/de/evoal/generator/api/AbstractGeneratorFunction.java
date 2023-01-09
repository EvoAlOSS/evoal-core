package de.evoal.generator.api;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.instance.DataReference;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class AbstractGeneratorFunction implements GeneratorFunction {

    protected Step configuration;

    /**
     * The properties the generator function writes.
     */
    protected PropertiesSpecification writeSpecification;

    /**
     * The properties the generator function reads.
     */
    protected PropertiesSpecification readSpecification;

    @Override
    public GeneratorFunction init(final Step configuration) throws InitializationException {
        this.configuration = configuration;

        writeSpecification = createSpecification(configuration.getWrites());
        readSpecification = createSpecification(configuration.getReads());

        log.info("Reading {}", readSpecification);
        log.info("Writing {}", writeSpecification);

        return this;
    }

    private static PropertiesSpecification createSpecification(final List<DataReference> references) {
        final PropertiesSpecification.Builder builder = PropertiesSpecification.builder();

        builder.add(references.stream()
                              .map(DataReference::getDefinition)
                              .map(DataDescription::getName));

        return builder.build();
    }

    /**
     * Merges the properties' specification with the write-specicfication of this
     *   generator function, creates a new properties instance according to the new
     *   specification and copies all property values.
     */
    protected Properties mergeAndCopy(final Properties properties) {
        final PropertiesSpecification specification =
                PropertiesSpecification.builder()
                                       .add(properties.getSpecification())
                                       .add(writeSpecification)
                                       .build();

        final Properties result = new Properties(specification);
        for(final PropertySpecification ps : properties.getSpecification().getProperties()) {
            result.put(ps, properties.get(ps));
        }

        return result;
    }
}
