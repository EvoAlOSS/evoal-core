package de.evoal.optimisation.main.statistics.stopping;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.model.Iteration;
import de.evoal.optimisation.api.model.StoppingCriterion;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Logs stopping criteria information for an entire iteration.
 */
@Slf4j
@Named("de.evoal.optimisation.core.stopping-per-candidates-per-generation")
@Dependent
public class StoppingCritertionPerGeneration implements StatisticsWriter {

    @Inject
    private AttributeEvaluator evaluator;

    private int numberOfColumns;

    private StoppingCriterion[] stoppingCriteria;

    @Inject
    protected WriterStrategy strategy;

    protected Writer writer;

    @Override
    @SneakyThrows(WriterException.class)
    public StatisticsWriter init(final Instance configuration) {
        final Instance [] configs = evaluator.attributeToInstanceArray(configuration, "criteria");
        stoppingCriteria = Arrays.stream(configs)
                .map(i -> BeanFactory.createComponent(StoppingCriterion.class, i))
                .map(StoppingCriterion.class::cast)
                .toArray(StoppingCriterion[]::new);


        final List<Column> columns = new LinkedList<>();
        columns.add(new Column("generation", ColumnType.Integer));

        for(int i = 0; i < stoppingCriteria.length; i++) {
            columns.add(new Column("criterion-" + i, ColumnType.Integer));
        }

        this.numberOfColumns = columns.size();
        this.writer = strategy.create("stopping-criteria", columns);

        return this;
    }

    @Override
    public void add(final Iteration result) {
        final int iterationNumber = result.iteration();
        final Object [] record = toData(iterationNumber, result);

        appendToWriter(record);

        writer.flush();
    }

    protected Object [] toData(final int iterationNumber, final Iteration result) {
        final Object [] data = new Object[numberOfColumns];

        data[0] = iterationNumber;

        for(int i = 0; i < stoppingCriteria.length; i++) {
            final StoppingCriterion criterion = stoppingCriteria[i];

            final boolean satisfied = criterion.shouldTerminate(result);

            data[i + 1] = satisfied ? 1 : 0;
        }

        return data;
    }

    private void appendToWriter(final Object [] record) {
        try {
            writer.addRecord(record);
        } catch (final WriterException e) {
            log.warn("Failed to writer statistics record.");
        }
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
