package de.evoal.optimisation.ea.main.codec.vector.chromosome;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.optimisation.ea.main.jenetics.BitHelper;
import de.evoal.optimisation.ea.main.jenetics.NaiveBoundedBitChromosome;
import io.jenetics.Chromosome;
import io.jenetics.util.DoubleRange;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.optimisation.ea.optimisation.bit-chromosome")
public class DynamicBitChromosome extends DynamicScaledChromosome {


    @Override
    public Chromosome toJenetics() {
        final DoubleRange range = ranges.get(0);

        return NaiveBoundedBitChromosome.of(range.min(), range.max(), scale);
    }

    @Override
    public Chromosome toJenetics(final Properties values) {
        final DoubleRange range = ranges.get(0);
        final PropertySpecification spec = specification.get(0);

        return NaiveBoundedBitChromosome.of(values.getAsDouble(spec), range.min(), range.max(), scale);
    }

    @Override
    public Properties toProperties(final Chromosome chromosome, final Properties properties) {
        final PropertySpecification spec = specification.get(0);
        final NaiveBoundedBitChromosome actual = (NaiveBoundedBitChromosome)chromosome;

        final byte [] bytes = actual.toByteArray();
        final double value = BitHelper.toDouble(bytes, scale);

        properties.put(spec, value);

        return properties;
    }
}
