package de.evoal.optimisation.ea.main.codec.vector.chromosome;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.optimisation.ea.main.jenetics.BoundedDoubleChromosome;
import de.evoal.optimisation.ea.main.jenetics.BoundedDoubleGene;
import io.jenetics.Chromosome;
import io.jenetics.util.DoubleRange;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@Dependent
@Named("de.evoal.optimisation.ea.optimisation.double-chromosome")
public class DynamicDoubleChromosome extends DynamicBoundedDoubleChromosome {
    @Override
    public Chromosome toJenetics() {
        final List<BoundedDoubleGene> genes = ranges.stream()
                                                    .map(BoundedDoubleGene::of)
                                                    .collect(Collectors.toList());

        return BoundedDoubleChromosome.of(genes);
    }

    @Override
    public Chromosome toJenetics(final Properties values) {
        final List<BoundedDoubleGene> genes = new ArrayList<>(ranges.size());

        for(int i = 0; i < ranges.size(); ++i) {
            final DoubleRange range = ranges.get(i);
            final double value = values.getAsDouble(specification.get(i));

            genes.add(BoundedDoubleGene.of(value, range));
        }

        return BoundedDoubleChromosome.of(genes);
    }

    @Override
    public Properties toProperties(final Chromosome chromosome, final Properties properties) {
        final BoundedDoubleChromosome doubleChromosome = (BoundedDoubleChromosome) chromosome;

        for(int i = 0; i < specification.size(); ++i) {
            final double value = doubleChromosome.get(i).doubleValue();
            final PropertySpecification spec = specification.get(i);

            properties.put(spec, value);
        }

        return properties;
    }
}
