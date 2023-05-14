package de.evoal.core.ea.main.codec;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.ea.api.codec.CustomCodec;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.ea.main.codec.chromosome.DynamicChromosome;
import de.evoal.core.ea.main.codec.chromosome.DynamicChromosomeFactory;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;
import io.jenetics.Chromosome;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.util.Factory;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class DynamicCodec<G extends Gene<?, G>> implements CustomCodec<G> {

    private final List<DynamicChromosome> dynamicTemplates;

    private final PropertiesSpecification specification;

    public DynamicCodec(final PropertiesSpecification specification, final List<DynamicChromosome> dynamicTemplates, final List<Chromosome<G>> jeneticsTemplates) {
        this.specification = specification;
        this.dynamicTemplates = dynamicTemplates;
    }

    static DynamicCodec from(final Instance [] config, final PropertiesSpecification specification) {
        final DynamicChromosomeFactory factory = BeanFactory.create(DynamicChromosomeFactory.class);
        final List<DynamicChromosome> chromosomes = Arrays.stream(config)
                                                          .map(Instance.class::cast)
                                                          .map(factory::create)
                                                          .collect(Collectors.toList());

        final List<Chromosome> templates = chromosomes.stream()
                                                      .map(DynamicChromosome::toJenetics)
                                                      .collect(Collectors.toList());



        log.info("Created dynamic codec for properties specification {}.", specification);

        return new DynamicCodec(specification, chromosomes, templates);
    }

    @Override
    public Factory<Genotype<G>> encoding() {
        final List<Chromosome<G>> chromosomes = dynamicTemplates.stream()
                                                                .map(c -> (Chromosome<G>)c.toJenetics())
                                                                .collect(Collectors.toList());

        return Genotype.of(chromosomes);
    }

    @Override
    public Function<Genotype<G>, Properties> decoder() {
        return this::toProperties;
    }

    private Properties toProperties(final Genotype<G> genotype) {
        Properties result = new Properties(specification);

        for(int i = 0; i < dynamicTemplates.size(); ++i) {
            final Chromosome<G> chromosome = genotype.get(i);
            final DynamicChromosome dynamic = dynamicTemplates.get(i);

            result = dynamic.toProperties(chromosome, result);
        }

        return result;
    }

    @Override
    public Genotype<G> encode(final Properties p) {
        final List<Chromosome<G>> chromosomes = dynamicTemplates.stream()
                                                                .map(c -> (Chromosome<G>)c.toJenetics(p))
                                                                .collect(Collectors.toList());

        return Genotype.of(chromosomes);
    }
}
