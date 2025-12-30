package de.evoal.optimisation.ea.main.codec.vector;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.optimisation.ea.main.codec.vector.chromosome.DynamicChromosome;
import de.evoal.languages.model.base.expressions.Instance;
import io.jenetics.Chromosome;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.util.Factory;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class VectorGenotypeCodec<G extends Gene<?, G>> implements CustomCodec<G> {

    @Inject
    private @Named("genotype-specification") PropertiesSpecification specification;

    @Inject
    private AttributeHelper helper;

    private List<DynamicChromosome> dynamicTemplates;

    @Override
    public VectorGenotypeCodec<G> init(final Instance config) {
        log.info("LanguageHelper is {}", helper);
        final List<Instance> chromosomeConfigurations = helper.lookup(config, "chromosomes");

        dynamicTemplates = chromosomeConfigurations.stream()
                                 .map(i -> BeanFactory.createComponent(DynamicChromosome.class, i))
                                 .collect(Collectors.toList());

        return this;
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

    @Produces
    @Named("de.evoal.optimisation.ea.optimisation.vector-genotype")
    @ApplicationScoped
    public static CustomCodec create() {
        log.info("Creating vector-based codec for optimisation problem.");
        return BeanFactory.injectFields(new VectorGenotypeCodec());
    }
}
