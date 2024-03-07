package de.evoal.prediction.interval.statistics;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.core.api.statistics.io.Writer;
import de.evoal.core.api.statistics.io.WriterException;
import de.evoal.core.api.statistics.io.WriterStrategy;
import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;
import de.evoal.core.api.statistics.writer.StatisticsWriter;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.utils.Requirements;


/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("approximative")
@Dependent
public class GenerationStatisticsWriter implements StatisticsWriter {

    /**
     * List of all existing fitness functions.
     */
    private List<Function<Properties, FitnessValue>> functions;

    /**
     * Encoding for converting between ea and domain.
     */
    @Inject @Named("codec")
    private CustomCodec encoding;

    private EvolutionResult<?, FitnessValue> bestIndividual;

    private List<Instance> fitnessInstances;

    private long startTime;
    private long endTime;

    @Inject @ConfigurationValue(entry = BlackboardEntry.OPTIMISATION_CONFIGURATION, access = "algorithm")
    private Instance algorithmConfiguration;

    @Inject @ConfigurationValue(entry = BlackboardEntry.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function")
    private Instance fitnessConfiguration;

    @Inject
    private WriterStrategy strategy;

    private Writer writer;

    /**
     * Changes the fitness type entry in the given config object.
     */
    private static void setFitnessType(final Instance algorithm, final Instance fitness) {
        final Instance copy = EcoreUtil.copy(fitness);
        algorithm.getAttributes()
                .stream()
                .filter(a -> "fitness".equals(((Name)a.getName()).getName().getName()))
                .findFirst()
                .ifPresent(a -> a.setValue(copy));
    }

    private void createWriter() throws WriterException {
        final List<Column> columns = new ArrayList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("individual", ColumnType.String));
        columns.add(new Column("age", ColumnType.Integer));

        for(int i = 0; i < fitnessInstances.size(); ++i) {
            columns.add(new Column(fitnessInstances.get(i).getName().getName(), ColumnType.Double));
        }

        columns.add(new Column("optimized", ColumnType.String));
        columns.add(new Column("time", ColumnType.Integer));

        writer = strategy.create("best-individual-statistics", columns);
    }

    private Object[] dataOfBest() {
        final Object [] data = new Object[3 + fitnessInstances.size() + 2];

        final Genotype genotype = bestIndividual.bestPhenotype().genotype();
        final Properties individual = (Properties) encoding.decode(genotype);

        data[0] = bestIndividual.generation();
        data[1] = Arrays.toString(individual.getValues());
        data[2] = bestIndividual.bestPhenotype().age(bestIndividual.generation());

        final Properties candidate = (Properties) encoding.decode(bestIndividual.bestPhenotype().genotype());

        for(int i = 0; i < functions.size(); ++i) {
            final FitnessValue fitness = functions.get(i).apply(candidate);
            data[3 + i] = fitness.getFitnessValues()[0];
        }

        data[data.length - 2] = bestIndividual.bestPhenotype().fitness().getFitnessValues()[0];
        data[data.length - 1] = endTime - startTime;

        return data;
    }

    public void add(final EvolutionResult<?, FitnessValue> evolutionResult) {
        updateBestGeneration(evolutionResult);
    }

    @Override @SneakyThrows(WriterException.class)
    public StatisticsWriter init(final Instance configuration) {
        Requirements.requireSize(configuration.getAttributes(), 1);

        final Array fitnessArray =
                (Array)configuration.getAttributes()
                                    .get(0)
                                    .getValue();

        fitnessInstances = fitnessArray
                .getValues()
                .stream()
                .map(Instance.class::cast)
                .collect(Collectors.toList());

        fitnessInstances.add(fitnessConfiguration);

        this.functions = fitnessInstances.stream()
                .map(instance -> {
                    setFitnessType(algorithmConfiguration, instance);
                    return BeanProvider.getContextualReference("evaluator", false, FitnessEvaluator.class);
                })
                .collect(Collectors.toList());

        // restore fitness function
        setFitnessType(algorithmConfiguration, fitnessConfiguration);

        createWriter();

        startTime = System.currentTimeMillis();

        return this;
    }

    private void updateBestGeneration(final EvolutionResult<?, FitnessType> generation) {
        if(bestIndividual == null) {
            bestIndividual = generation;
        } else if(bestIndividual.bestFitness().compareTo(generation.bestFitness()) < 0) {
            bestIndividual= generation;
        }
    }

    @Override
    public void write() {
        endTime = System.currentTimeMillis();
        try {
            writer.addRecord(dataOfBest());
            strategy.close(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
