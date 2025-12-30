package de.evoal.optimisation.ea.main.codec.vector.chromosome;

import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.api.properties.info.PropertyBoundaries;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Instance;
import io.jenetics.util.DoubleRange;

import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DynamicBoundedDoubleChromosome extends DynamicChromosome {
    @Inject
    private PropertiesBoundaries boundaries;

    protected List<DoubleRange> ranges;

    @Override
    public DynamicChromosome init(final Instance specification) {
        super.init(specification);

        ranges = dataRepresented.stream()
                .map(this::toRange)
                .collect(Collectors.toList());

        return this;
    }

    protected DoubleRange toRange(final DataDescription dataDescription) {
        PropertyBoundaries bounds = boundaries.get(new PropertySpecification(dataDescription.getName(), dataDescription));

        return DoubleRange.of(bounds.lower().doubleValue(), bounds.upper().doubleValue());
    }
}
