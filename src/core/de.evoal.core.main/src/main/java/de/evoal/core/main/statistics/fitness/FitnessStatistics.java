package de.evoal.core.main.statistics.fitness;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.statistics.*;
import de.evoal.languages.model.instance.Instance;
import io.jenetics.Phenotype;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.ISeq;
import javax.enterprise.context.Dependent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.LinkedList;
import java.util.List;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("fitness-per-individual")
@Dependent
public class FitnessStatistics implements StatisticsWriter {

    @Inject
    @Named("optimization-function-output")
    private Provider<PropertiesSpecification> targetSpecification;

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

        for(int i = 0; i < targetSpecification.get().size(); ++i) {
            columns.add(new Column("fitness-value-" + targetSpecification.get().get(i).name(), ColumnType.Double));
        }

        writer = strategy.create("fitness-by-individual", columns);
    }

    private Object[] dataOfPhenotype(final int index, final long generation, Phenotype<?, FitnessValue> phenotype) {
        final Object [] data = new Object[2 + targetSpecification.get().size()];

        data[0] = generation;
        data[1] = index;

        final Object [] fitnessValues = phenotype.fitness().toStatistics();

        for(int i = 0; i < fitnessValues.length; ++i) {
            data[2 + i] = fitnessValues[i];
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
