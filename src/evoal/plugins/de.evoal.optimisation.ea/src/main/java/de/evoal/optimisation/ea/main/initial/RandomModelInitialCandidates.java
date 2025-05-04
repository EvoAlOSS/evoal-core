package de.evoal.optimisation.ea.main.initial;

import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import de.evoal.optimisation.ea.api.codec.model.ModelChromosome;
import de.evoal.optimisation.ea.api.codec.model.ModelGene;
import de.evoal.languages.model.base.expressions.Instance;
import io.jenetics.Genotype;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.ea.mdo.random-model-population")
public class RandomModelInitialCandidates implements InitialCandidatesProvider {

    @Inject @Named("codec")
    public CustomCodec codec;

    @Inject @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    @Override
    public RandomModelInitialCandidates init(final Instance instance) {
        return this;
    }

    @Override
    public Stream<Properties> create() {
        final AtomicInteger counter = new AtomicInteger();

        return codec.encoding()
                    .instances()
                    .map(Genotype.class::cast)
                    .filter(g -> ((Genotype)g).isValid())
                    .map(object -> {
                        // The compiler is not able to derive the correct type
                        Genotype<ModelGene> genotype = (Genotype<ModelGene>)object;

                        log.info("Creating random initial candidate #{}.", counter.getAndIncrement());
                        final Properties p = new Properties(searchSpaceSpecification);

                        for(int i = 0; i < genotype.length(); ++i) {
                            p.put(i, ((ModelChromosome)genotype.get(i)).getModel());
                        }

                        return p;
                    });
    }
}
