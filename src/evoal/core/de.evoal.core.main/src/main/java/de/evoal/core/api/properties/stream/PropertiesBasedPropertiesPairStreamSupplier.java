package de.evoal.core.api.properties.stream;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesPair;
import de.evoal.core.api.properties.PropertiesSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

/**
 * A supplier for a stream of training coordinates.
 */
@Slf4j
public class PropertiesBasedPropertiesPairStreamSupplier implements PropertiesPairStreamSupplier {
    private final PropertiesStreamSupplier supplier;
    private final PropertiesSpecification source;
    private final PropertiesSpecification target;

    public PropertiesBasedPropertiesPairStreamSupplier(final PropertiesStreamSupplier supplier, final PropertiesSpecification source, final PropertiesSpecification target) {
        this.supplier = supplier;
        this.source = source;
        this.target = target;
    }

    @Override
    public Stream<PropertiesPair> get() {
        log.info("Creating properties pairs stream: {} -> {}", source, target);
        final PropertiesSpecification merged = PropertiesSpecification
                .builder()
                .add(source)
                .add(target)
                .build();

        return supplier.apply(merged)
                       .map(this::toPair);
    }

    private PropertiesPair toPair(final Properties properties) {
        return new PropertiesPair(
                new Properties(source).putAll(properties),
                new Properties(target).putAll(properties)
        );
    }
}
