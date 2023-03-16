package de.evoal.core.ea.main.codec.chromosome;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.languages.model.instance.Instance;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DynamicChromosomeFactory {
    public DynamicChromosome create(final Instance specification) {
        final String chromosomeName = specification.getDefinition().getName();

        final DynamicChromosome chromosome = BeanFactory.create(chromosomeName, DynamicChromosome.class);
        chromosome.init(specification);

        return chromosome;
    }
}
