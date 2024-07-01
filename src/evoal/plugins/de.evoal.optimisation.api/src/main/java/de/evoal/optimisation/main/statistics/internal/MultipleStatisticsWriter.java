package de.evoal.optimisation.main.statistics.internal;

import de.evoal.optimisation.api.statistics.IterationResult;
import de.evoal.languages.model.base.Instance;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

import java.util.Arrays;

/**
 * A statistics writer that dispatches its calls to a list of children.
 */
public class MultipleStatisticsWriter implements StatisticsWriter {
    private final StatisticsWriter[] writers;

    public MultipleStatisticsWriter(final StatisticsWriter ... writers) {
        this.writers = writers;
    }

    @Override
    public void add(final IterationResult result) {
        Arrays.stream(writers).forEach(w -> w.add(result));
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }

    @Override
    public void write() {
        Arrays.stream(writers).forEach(StatisticsWriter::write);
    }
}
