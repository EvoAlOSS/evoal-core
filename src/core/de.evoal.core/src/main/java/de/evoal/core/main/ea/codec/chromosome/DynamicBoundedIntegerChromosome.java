package de.evoal.core.main.ea.codec.chromosome;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.instance.Instance;
import io.jenetics.util.IntRange;

import java.util.List;
import java.util.stream.Collectors;

public abstract class DynamicBoundedIntegerChromosome extends DynamicChromosome {
    protected List<IntRange> ranges;

    @Override
    public void init(final Instance specification) {
        super.init(specification);

        ranges = dataRepresented.stream()
                .map(this::toRange)
                .collect(Collectors.toList());
    }

    protected IntRange toRange(final DataDescription dataDescription) {
        // TODO Find actual ranges from DDL
        return IntRange.of(-(Integer.MAX_VALUE/2), (Integer.MAX_VALUE/2));
    }
}
