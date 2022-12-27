package de.evoal.core.main.ea.codec.chromosome;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.instance.Instance;
import io.jenetics.util.DoubleRange;

import java.util.List;
import java.util.stream.Collectors;

public abstract class DynamicBoundedChromosome extends DynamicChromosome {
    protected List<DoubleRange> ranges;

    @Override
    public void init(final Instance specification) {
        super.init(specification);

        ranges = dataRepresented.stream()
                .map(this::toRange)
                .collect(Collectors.toList());
    }

    protected DoubleRange toRange(final DataDescription dataDescription) {
        // TODO Find actual ranges from DDL
        return DoubleRange.of(-(Double.MAX_VALUE/2), (Double.MAX_VALUE/2));
    }
}
