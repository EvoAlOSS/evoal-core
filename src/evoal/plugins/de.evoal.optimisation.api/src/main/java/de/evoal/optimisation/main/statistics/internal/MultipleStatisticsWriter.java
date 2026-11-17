package de.evoal.optimisation.main.statistics.internal;

import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import org.eclipse.emf.ecore.EObject;

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
    public void add(final Iteration result) {
        Arrays.stream(writers).forEach(w -> w.add(result));
    }

    @Override
    public void start() {
        Arrays.stream(writers).forEach(StatisticsWriter::start);
    }

    @Override
    public StatisticsWriter init(EObject configuration) {
        return this;
    }

    @Override
    public void write() {
        Arrays.stream(writers).forEach(StatisticsWriter::write);
    }
}
