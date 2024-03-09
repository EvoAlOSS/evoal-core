package de.evoal.core.ea.main.codec.program;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.ea.api.codec.CustomCodec;
import de.evoal.core.ea.main.codec.vector.VectorGenotypeCodec;
import de.evoal.core.ea.main.codec.vector.chromosome.DynamicChromosome;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.dl.util.FQNProvider;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.prog.ProgramChromosome;
import io.jenetics.util.Factory;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ProgramGenotypeCodec<G extends Gene<?, G>> implements CustomCodec<G> {
    @Inject
    private LanguageHelper helper;

    @Override
    public ProgramGenotypeCodec<G> init(final Instance config) {
        final Object[] chromosomeConfigurations = helper.lookup(config, "chromosomes");

        final FQNProvider provider = new FQNProvider();
/*
        dynamicTemplates = Arrays.stream(chromosomeConfigurations)
                .map(Instance.class::cast)
                .filter(i -> "de.evoal.core.optimisation.program-chromosome".equals(provider.get(i)))
                .map(i -> ProgramChromosome.of())
                .collect(Collectors.toList());
TODO
 */
        return this;
    }

    @Override
    public Genotype<G> encode(final Properties p) {
        return null;
    }

    @Override
    public Factory<Genotype<G>> encoding() {
        return null;
    }

    @Override
    public Function<Genotype<G>, Properties> decoder() {
        return null;
    }

    @Produces
    @Named("de.evoal.core.ea.optimisation.program-genotype")
    @ApplicationScoped
    public static CustomCodec create() {
        log.info("Creating program-based codec for optimisation problem.");
        return BeanFactory.injectFields(new ProgramGenotypeCodec());
    }
}
