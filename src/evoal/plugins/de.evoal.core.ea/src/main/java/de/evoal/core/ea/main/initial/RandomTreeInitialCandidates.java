package de.evoal.core.ea.main.initial;

import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.ea.api.codec.CustomCodec;
import io.jenetics.Genotype;
import io.jenetics.prog.ProgramChromosome;
import io.jenetics.prog.ProgramGene;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Slf4j
@Dependent
@Named("de.evoal.core.ea.genetic-programming.random-tree-population")
public class RandomTreeInitialCandidates implements InitialCandidatesProvider {

    @Inject @Named("codec")
    public CustomCodec codec;

    @Inject @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    @Override
    public Stream<Properties> create() {
        final AtomicInteger counter = new AtomicInteger();

        return codec.encoding()
                    .instances()
                    .map(Genotype.class::cast)
                    .filter(g -> ((Genotype)g).isValid())
                    .map(object -> {
                        // The compiler is not able to derive the correct type
                        Genotype<ProgramGene<Double>> genotype = (Genotype<ProgramGene<Double>>)object;

                        log.info("Creating random initial candidate #{}.", counter.getAndIncrement());
                        final Properties p = new Properties(searchSpaceSpecification);

                        for(int i = 0; i < genotype.length(); ++i) {
                            p.put(i, genotype.get(i).gene().toTreeNode());
                        }
                        System.err.println(p);
                        return p;
                    });
    }
}
