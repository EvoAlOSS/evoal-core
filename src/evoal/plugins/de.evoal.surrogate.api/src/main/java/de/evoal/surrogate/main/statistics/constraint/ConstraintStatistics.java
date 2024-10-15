package de.evoal.surrogate.main.statistics.constraint;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.optimisation.api.statistics.Candidate;
import de.evoal.optimisation.api.statistics.IterationResult;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.api.constraints.calculation.CalculationFactory;
import de.evoal.optimisation.api.constraints.calculation.CalculationStrategy;
import de.evoal.optimisation.api.constraints.model.ConstraintResult;
import de.evoal.optimisation.api.constraints.model.Constraints;
import de.evoal.optimisation.api.constraints.strategies.CalculationResult;
import de.evoal.languages.model.base.Instance;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("de.evoal.surrogate.optimisation.constraint-statistics")
@Dependent
public class ConstraintStatistics implements StatisticsWriter {
    private final static int NUMBER_OF_STATISTICS_PER_CONSTRAINT = 5;

    private final List<Column> columns = new ArrayList<>();

    @Inject @Named("optimisation-space-specification")
    private PropertiesSpecification objectiveSpecification;

    @Inject
    private CalculationFactory factory;

    @Inject
    private Constraints constraints;

    private CalculationStrategy[] calculators;

    @Inject
    private WriterStrategy strategy;

    private Writer writer;

    @PostConstruct @SneakyThrows(WriterException.class)
    private void init() {
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

    private Object[] toData(final int generation, final Supplier<Stream<Candidate>> candidates) {
        final Object [] data = new Object[1 + constraints.getConstraints().size() * NUMBER_OF_STATISTICS_PER_CONSTRAINT];

        data[0] = generation;

        for(int index = 0; index < calculators.length; ++index) {
            final CalculationStrategy strategy = calculators[index];

            final List<CalculationResult> calculationResults =
                candidates.get()
                        .map(cand -> {
                            try {
                                return strategy.calculate(cand.searchSpaceRepresentation(), new Properties(objectiveSpecification, cand.value().toStatistics()));
                            } catch (final Exception e) {
                                e.printStackTrace();
                                throw e;
                            }
                        }) // TODO FIXME
                        .map(CalculationResult.class::cast)
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

            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT] = invalid;
            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT + 1] = statistics.getSum();
            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT + 2] = statistics.getMin();
            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT + 3] = statistics.getAverage();
            data[1 + index * NUMBER_OF_STATISTICS_PER_CONSTRAINT + 4] = statistics.getMax();
        }

        return data;
    }

    @Override
    public void add(final IterationResult result) {
            try {
                final Object [] data = toData(result.iteration(), () -> result.candidates());
                writer.addRecord(data);
            } catch (final WriterException e) {
                log.error("Failed to add record.", e);
            }
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }

    @Override
    public void write() {
        try {
            strategy.close(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
