package de.evoal.surrogate.main.statistics.surrogate;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

import de.evoal.core.api.statistics.*;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.instance.Instance;
import de.evoal.surrogate.api.function.SurrogateFunction;
import io.jenetics.Genotype;
import io.jenetics.Phenotype;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.ISeq;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("prediction-per-individual")
@Dependent
public class SurrogateStatistics implements StatisticsWriter {
    /**
     * The predictive function used.
     */
    //@Inject
    protected SurrogateFunction predictive;

    /**
     * Encoding for converting between ea and domain.
     */
    // TODO @Inject
    private CustomCodec encoding;

    //@Inject @Named("target-properties-specification")
    private PropertiesSpecification targetSpecification;

    // TODO @Inject
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
        final List<Column> columns = new LinkedList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("index", ColumnType.Integer));

        for(int i = 0; i < targetSpecification.size(); ++i) {
            columns.add(new Column(targetSpecification.getProperties().get(i).name(), ColumnType.Double));
        }

        writer = strategy.create("prediction-by-individual", columns);
    }

    private Object[] dataOfPhenotype(final int index, final long generation, Phenotype<?, FitnessValue> phenotype) {
        final Object [] data = new Object[2 + targetSpecification.size()];

        data[0] = generation;
        data[1] = index;

        final Genotype<?> genotype = phenotype.genotype();
        final Properties individual = (Properties) encoding.decode(genotype);
        final Properties predicted = predictive.apply(individual);

        for(int i = 0; i < predicted.size(); ++i) {
            data[2 + i] = predicted.getValues()[i];
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
