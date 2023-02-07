package de.evoal.core.main.statistics.individuals;

import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.core.api.statistics.*;
import de.evoal.languages.model.instance.Instance;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import io.jenetics.Genotype;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import io.jenetics.Phenotype;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.ISeq;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("individuals")
@Dependent
public class IndividualStatistics implements StatisticsWriter {
    /**
     * Encoding for converting between ea and domain.
     */
    @Inject
    private CustomCodec encoding;

    @Inject @Named("genotype-specification")
    private PropertiesSpecification sourceSpecification;

    @Inject
    private WriterStrategy strategy;

    private Writer writer;

    @PostConstruct
    @SneakyThrows(WriterException.class)
    private void init() {
        createWriter();
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }

    private void createWriter() throws WriterException {
        final List<Column> columns = new ArrayList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("index", ColumnType.Integer));
        columns.add(new Column("age", ColumnType.Integer));

        for(int i = 0; i < sourceSpecification.size(); ++i) {
            columns.add(new Column(sourceSpecification.getProperties().get(i).name(), ColumnType.Double));
        }

        writer = strategy.create("individuals", columns);
    }

    private Object[] dataOfPhenotype(final int index, final long generation, Phenotype<?, FitnessValue> phenotype) {
        final Object [] data = new Object[4 + sourceSpecification.size()];

        final Genotype<?> genotype = phenotype.genotype();
        final Properties individual = (Properties) encoding.decode(genotype);

        data[0] = generation;
        data[1] = index;
        data[2] = phenotype.age(generation);

        for(int i = 0; i < individual.size(); ++i) {
            data[3 + i] = individual.getValues()[i];
        }

        return data;
    }

    @SneakyThrows(WriterException.class)
    public void add(final EvolutionResult<?, FitnessValue> evolutionResult) {
        final ISeq<Phenotype<?, FitnessValue>> population = (ISeq<Phenotype<?, FitnessValue>>)(Object)evolutionResult.population();

        for(int i = 0; i < population.size(); ++i) {
            writer.addRecord(dataOfPhenotype(i, evolutionResult.generation(), population.get(i)));
        }
    }

    public void write() {
        try {
            strategy.close(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
