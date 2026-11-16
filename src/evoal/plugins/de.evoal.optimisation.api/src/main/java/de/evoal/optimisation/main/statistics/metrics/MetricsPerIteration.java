package de.evoal.optimisation.main.statistics.metrics;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.MetricValueType;

import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

/**
 * Writes the metrics of every iteration to {@code metrics-per-iteration.csv} (DL type
 *   {@code metrics-per-iteration}): the iteration number and one column per iteration
 *   metric ({@link MetricScope#ITERATION}) defined in the execution, in the order of their
 *   definition. The columns are described in the DL type.
 * <p>
 * The writer is created while the metrics are still being defined, so it creates its
 *   output with the first iteration, when the definitions are complete.
 */
@Dependent
@Named("de.evoal.optimisation.core.metrics-per-iteration")
@Slf4j
public class MetricsPerIteration implements StatisticsWriter {
    /**
     * The iteration metrics, one column each. Taken from the execution with the first iteration.
     */
    private List<MetricDefinition> definitions;

    /**
     * Provides the metric definitions of the current run.
     */
    @Inject
    private ExecutionRecorder recorder;

    /**
     * Creates the output the rows are written to.
     */
    @Inject
    private WriterStrategy strategy;

    /**
     * The output, created with the first iteration. {@code null} before.
     */
    private Writer writer;

    /**
     * Writes the row of the iteration and flushes the output. A failure is logged
     *   and does not stop the run.
     */
    @Override
    public void add(final Iteration result) {
        if(writer == null) {
            createWriter();
        }

        final Object[] record = toRecord(result);

        try {
            writer.addRecord(record);
        } catch(final WriterException e) {
            log.warn("Failed to write the metrics of iteration {}.", result.getNumber(), e);
        }

        writer.flush();
    }

    /**
     * Creates the output with one column per iteration metric.
     */
    private void createWriter() {
        definitions = recorder.getExecution()
                              .getMetricDefinitions()
                              .stream()
                              .filter(definition -> definition.getScope() == MetricScope.ITERATION)
                              .toList();

        final List<Column> columns = new ArrayList<>();
        columns.add(new Column("iteration", ColumnType.Integer));
        definitions.stream()
                   .map(MetricsPerIteration::toColumn)
                   .forEach(columns::add);

        try {
            writer = strategy.create("metrics-per-iteration", columns);
        } catch(final WriterException e) {
            throw new IllegalStateException("Cannot create the output 'metrics-per-iteration'.", e);
        }
    }

    @Override
    public StatisticsWriter init(final EObject configuration) {
        return this;
    }

    /**
     * @return The column of the metric, named after the metric.
     */
    private static Column toColumn(final MetricDefinition definition) {
        final boolean isInteger = definition.getValueType() == MetricValueType.INTEGER;
        final ColumnType type = isInteger ? ColumnType.Integer : ColumnType.Double;

        return new Column(definition.getName(), type);
    }

    /**
     * @return The row of the iteration: its number, then the value of each metric
     *   (empty if the iteration has no value for the metric).
     */
    private Object[] toRecord(final Iteration iteration) {
        final Object[] record = new Object[definitions.size() + 1];
        record[0] = iteration.getNumber();

        for(int index = 0; index < definitions.size(); ++index) {
            final String metricName = definitions.get(index).getName();

            record[index + 1] = iteration.getMetrics().get(metricName);
        }

        return record;
    }

    /**
     * Flushes the output at the end of a run.
     */
    @Override
    public void write() {
        if(writer == null) {
            return;
        }

        try {
            strategy.flush(writer);
        } catch(final WriterException e) {
            log.error("Failed to write the metrics.", e);
        }
    }
}
