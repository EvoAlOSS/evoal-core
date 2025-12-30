package de.evoal.optimisation.api.statistics.writer;

import de.evoal.optimisation.api.model.Candidate;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.model.Iteration;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import jakarta.inject.Inject;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public abstract class AbstractCandidateStatisticsWriter implements StatisticsWriter {

    @Inject
    protected WriterStrategy strategy;

    protected Writer writer;

    @Override
    public void add(final Iteration result) {
        final AtomicInteger counter = new AtomicInteger(0);

        result.candidates()
                .map(c -> toData(counter.getAndIncrement(), result.iteration(), c))
                .forEach(r -> {
                    try {
                        writer.addRecord(r);
                    } catch (final WriterException e) {
                        log.warn("Failed to writer statistics record.");
                    }
                });

        writer.flush();
    }

    @Override
    @SneakyThrows(WriterException.class)
    public StatisticsWriter init(final Instance configuration) {
        writer = createWriter(configuration);

        return this;
    }

    protected abstract Writer createWriter(final Instance configuration) throws WriterException ;

    protected abstract Object [] toData(final int index, final int iteration, final Candidate individual);

    public void write() {
        try {
            strategy.close(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
