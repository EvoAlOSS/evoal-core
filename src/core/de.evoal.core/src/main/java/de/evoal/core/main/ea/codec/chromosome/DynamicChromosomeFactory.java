package de.evoal.core.main.ea.codec.chromosome;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.languages.model.instance.Instance;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DynamicChromosomeFactory {
    public DynamicChromosome create(final Instance specification) {
        final String chromosomeName = specification.getName().getName();

        final DynamicChromosome chromosome = BeanFactory.create(chromosomeName, DynamicChromosome.class);
        chromosome.init(specification);

        return chromosome;
    }
}
