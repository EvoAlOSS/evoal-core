package de.evoal.optimisation.ea.main.codec.vector.chromosome;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.optimisation.ea.main.jenetics.BoundedIntegerChromosome;
import de.evoal.optimisation.ea.main.jenetics.BoundedIntegerGene;
import io.jenetics.Chromosome;
import io.jenetics.util.IntRange;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Named("de.evoal.optimisation.ea.optimisation.integer-chromosome")
public class DynamicIntegerChromosome extends DynamicBoundedIntegerChromosome {
    @Override
    public Chromosome toJenetics() {
        final List<BoundedIntegerGene> genes = ranges.stream()
                                                    .map(BoundedIntegerGene::of)
                                                    .collect(Collectors.toList());

        return BoundedIntegerChromosome.of(genes);
    }

    @Override
    public Chromosome toJenetics(final Properties values) {
        final List<BoundedIntegerGene> genes = new ArrayList<>(ranges.size());

        for(int i = 0; i < ranges.size(); ++i) {
            final IntRange range = ranges.get(i);
            final int value = values.getAsInteger(specification.get(i));

            genes.add(BoundedIntegerGene.of(value, range));
        }

        return BoundedIntegerChromosome.of(genes);
    }

    @Override
    public Properties toProperties(final Chromosome chromosome, final Properties properties) {
        final BoundedIntegerChromosome integerChromosome = (BoundedIntegerChromosome) chromosome;

        for(int i = 0; i < specification.size(); ++i) {
            final int value = integerChromosome.get(i).intValue();
            final PropertySpecification spec = specification.get(i);

            properties.put(spec, value);
        }

        return properties;
    }
}
