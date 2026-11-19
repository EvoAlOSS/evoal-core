package de.evoal.optimisation.ea.main.codec.vector.chromosome;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.optimisation.ea.main.jenetics.GrayBoundedBitChromosome;
import de.evoal.optimisation.ea.main.jenetics.GrayHelper;
import io.jenetics.Chromosome;
import io.jenetics.util.DoubleRange;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.optimisation.ea.optimisation.gray-chromosome")
public class DynamicGrayChromosome extends DynamicScaledChromosome {
    @Override
    public Chromosome toJenetics() {
        final DoubleRange range = ranges.get(0);

        return GrayBoundedBitChromosome.of(range.min(), range.max(), scale);
    }
    @Override
    public Chromosome toJenetics(final Properties values) {
        final DoubleRange range = ranges.get(0);
        final PropertySpecification spec = specification.get(0);

        return GrayBoundedBitChromosome.of(values.getAsDouble(spec), range.min(), range.max(), scale);
    }
    @Override
    public Properties toProperties(final Chromosome chromosome, final Properties properties) {
        final PropertySpecification spec = specification.get(0);
        final GrayBoundedBitChromosome actual = (GrayBoundedBitChromosome)chromosome;

        final byte [] bytes = actual.toByteArray();
        final double value = GrayHelper.fromGray(bytes, scale);

        properties.put(spec, value);

        return properties;
    }
}
