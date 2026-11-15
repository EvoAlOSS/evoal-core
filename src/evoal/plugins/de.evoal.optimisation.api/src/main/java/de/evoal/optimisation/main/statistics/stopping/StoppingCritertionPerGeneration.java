package de.evoal.optimisation.main.statistics.stopping;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Writes for every iteration which of the configured stopping criteria are
 *   satisfied to {@code stopping-per-candidates-per-generation.csv} (DL type
 *   {@code stopping-per-candidates-per-generation}). The columns are described
 *   in the DL type.
 */
@Slf4j
@Named("de.evoal.optimisation.core.stopping-per-candidates-per-generation")
@Dependent
public class StoppingCritertionPerGeneration implements StatisticsWriter {
    /**
     * Evaluates the attributes of the writer's configuration.
     */
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * Number of columns of a row.
     */
    private int numberOfColumns;

    /**
     * The configured stopping criteria, one column each.
     */
    private TerminationCriterion[] stoppingCriteria;

    /**
     * Creates the output the rows are written to.
     */
    @Inject
    protected WriterStrategy strategy;

    /**
     * The output, created in {@link #init(EObject)}.
     */
    protected Writer writer;

    /**
     * Writes the row of the iteration and flushes the output.
     */
    @Override
    public void add(final Iteration result) {
        final int iterationNumber = result.getNumber();
        final Object [] record = toData(iterationNumber, result);

        appendToWriter(record);

        writer.flush();
    }

    /**
     * Writes the row. A failure is logged and does not stop the run.
     */
    private void appendToWriter(final Object [] record) {
        try {
            writer.addRecord(record);
        } catch (final WriterException e) {
            log.warn("Failed to writer statistics record.");
        }
    }

    @Override
    @SneakyThrows(WriterException.class)
    public StatisticsWriter init(final EObject configuration) {
        final EObject[] configs = evaluator.attributeToEObjectArray(configuration, "criteria");
        stoppingCriteria = Arrays.stream(configs)
                .map(i -> BeanFactory.createComponent(TerminationCriterion.class, i))
                .map(TerminationCriterion.class::cast)
                .toArray(TerminationCriterion[]::new);


        final List<Column> columns = new LinkedList<>();
        columns.add(new Column("generation", ColumnType.Integer));

        for(int i = 0; i < stoppingCriteria.length; i++) {
            columns.add(new Column("criterion-" + i, ColumnType.Integer));
        }

        this.numberOfColumns = columns.size();
        this.writer = strategy.create("stopping-per-candidates-per-generation", columns);

        return this;
    }

    /**
     * @return The row of the iteration: its number, then {@code 1} or {@code 0} per criterion.
     */
    protected Object [] toData(final int iterationNumber, final Iteration result) {
        final Object [] data = new Object[numberOfColumns];

        data[0] = iterationNumber;

        for(int i = 0; i < stoppingCriteria.length; i++) {
            final TerminationCriterion criterion = stoppingCriteria[i];

            final boolean satisfied = criterion.shouldTerminate(result);

            data[i + 1] = satisfied ? 1 : 0;
        }

        return data;
    }

    /**
     * Flushes the output at the end of a run.
     */
    @Override
    public void write() {
        try {
            strategy.flush(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
