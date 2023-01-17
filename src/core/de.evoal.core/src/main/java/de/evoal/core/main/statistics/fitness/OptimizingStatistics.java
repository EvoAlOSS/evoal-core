package de.evoal.core.main.statistics.fitness;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.statistics.*;
import de.evoal.languages.model.instance.Instance;
import io.jenetics.Genotype;
import io.jenetics.Phenotype;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.ISeq;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.LinkedList;
import java.util.List;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("optimizing-per-individual")
@Dependent
public class OptimizingStatistics implements StatisticsWriter {

    @Inject
    private CustomCodec codec;

    @Inject
    @Named("optimization-function")
    private FitnessFunction optimization;

    @Inject
    @Named("optimization-function-output")
    private PropertiesSpecification targetSpecification;

    @Inject
    private WriterStrategy strategy;

    private Writer writer;

    @Override
    @SneakyThrows(WriterException.class)
    public StatisticsWriter init(Instance configuration) {
        createWriter();

        return this;
    }

    private void createWriter() throws WriterException {
        final List<Column> columns = new LinkedList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("index", ColumnType.Integer));

        for(int i = 0; i < targetSpecification.size(); ++i) {
            columns.add(new Column("optimization-value-" + targetSpecification.get(i).name(), ColumnType.Double));
        }

        writer = strategy.create("optimization-by-individual", columns);
    }

    private Object[] dataOfPhenotype(final int index, final long generation, Phenotype<?, FitnessValue> phenotype) {
        final Object [] data = new Object[2 + targetSpecification.size()];

        data[0] = generation;
        data[1] = index;

        final Genotype<?> genotype = phenotype.genotype();
        final Properties individual = (Properties)codec.decode(genotype);
        final double [] raw = optimization.evaluate(individual);

        for(int i = 0; i < raw.length; ++i) {
            data[2 + i] = raw[i];
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
