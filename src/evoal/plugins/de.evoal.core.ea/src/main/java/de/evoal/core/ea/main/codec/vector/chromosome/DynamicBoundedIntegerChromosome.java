package de.evoal.core.ea.main.codec.vector.chromosome;

import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Instance;
import io.jenetics.util.IntRange;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DynamicBoundedIntegerChromosome extends DynamicChromosome {
    @Inject
    private PropertiesBoundaries boundaries;

    protected List<IntRange> ranges;

    @Override
    public DynamicChromosome init(final Instance specification) {
        super.init(specification);

        ranges = dataRepresented.stream()
                .map(this::toRange)
                .collect(Collectors.toList());

        return this;
    }

    protected IntRange toRange(final DataDescription dataDescription) {
        PropertiesBoundaries.Boundaries bounds = boundaries.get(new PropertySpecification(dataDescription.getName(), dataDescription));

        return IntRange.of(bounds.lower().intValue(), bounds.upper().intValue());
    }
}
