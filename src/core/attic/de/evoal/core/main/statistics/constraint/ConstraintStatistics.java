package de.evoal.core.main.statistics.constraint;

import de.evoal.core.api.statistics.*;
import de.evoal.core.main.ddl.constraint.strategies.CalculationFactory;
import de.evoal.core.main.ddl.constraint.strategies.CalculationStrategy;
import de.evoal.languages.model.instance.Instance;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.constraints.model.ConstraintResult;
import de.evoal.core.api.ea.constraints.model.Constraints;
import de.evoal.core.api.ea.constraints.strategies.CalculationResult;
import de.evoal.core.api.ea.fitness.type.FitnessType;
import de.evoal.core.api.properties.Properties;
import io.jenetics.Phenotype;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.ISeq;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("constraint-statistics")
@Dependent
public class ConstraintStatistics implements StatisticsWriter {
    private final static int NUMBER_OF_STATISTICS_PER_CONSTRAINT = 5;

    private final List<Column> columns = new ArrayList<>();

    @Inject
    private CalculationFactory factory;

    @Inject
    private Constraints constraints;

    @Inject
    private CustomCodec codec;

    private CalculationStrategy[] calculators;

    private long endTime;

    private long startTime;

    @Inject
    private WriterStrategy strategy;

    private Writer writer;

    @PostConstruct @SneakyThrows(WriterException.class)
    private void init() {
        startTime = System.currentTimeMillis();

        createColumns();

        writer = strategy.create("constraint-statistics", columns);

        calculators = constraints.getConstraints()
                .stream()
                .map(factory::create)
                .toArray(CalculationStrategy[]::new);
    }

    private void createColumns() {
        columns.add(new Column("generation", ColumnType.Integer));

        for(int i = 0; i < constraints.getConstraints().size(); ++i) {
            columns.add(new Column("violatingIndividuals_" + i, ColumnType.Integer));
            columns.add(new Column("sumOfDifferences_" + i, ColumnType.Double));
            columns.add(new Column("minOfDifferences_" + i, ColumnType.Double));
            columns.add(new Column("avgOfDifferences_" + i, ColumnType.Double));
            columns.add(new Column("maxOfDifferences_" + i, ColumnType.Double));
        }
    }

    private Object[] toData(final long generation, final ISeq<Phenotype<?, FitnessType>> population) {
        final Object [] data = new Object[1 + constraints.getConstraints().size() * NUMBER_OF_STATISTICS_PER_CONSTRAINT];

        data[0] = generation;

        for(int index = 0; index < calculators.length; ++index) {
            final CalculationStrategy strategy = calculators[index];

            final List<CalculationResult> calculationResults =
                population.stream()
                        .map(Phenotype::genotype)
                        .map(g -> (Properties)codec.decode(g))
                        .map(strategy::calculate)
                        .collect(Collectors.toList());

            final long invalid = calculationResults
                    .stream()
                    .filter(r -> !r.isSuccessful())
                    .count();

            final DoubleSummaryStatistics statistics =
                calculationResults
                        .stream()
                        .filter(r -> !r.isSuccessful())
                        .map(CalculationResult::getResult)
                        .mapToDouble(ConstraintResult::getComparisonDifference)
                        .summaryStatistics();

            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT + 0] = invalid;
            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT + 1] = statistics.getSum();
            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT + 2] = statistics.getMin();
            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT + 3] = statistics.getAverage();
            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT + 4] = statistics.getMax();
        }

        return data;
    }

    @SneakyThrows(WriterException.class)
    public void add(final EvolutionResult<?, FitnessType> evolutionResult) {
        final ISeq<Phenotype<?, FitnessType>> population = (ISeq<Phenotype<?, FitnessType>>)(Object)evolutionResult.population();

        writer.addRecord(toData(evolutionResult.generation(), population));
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }

    public void write() {
        endTime = System.currentTimeMillis();
        try {
            strategy.close(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
