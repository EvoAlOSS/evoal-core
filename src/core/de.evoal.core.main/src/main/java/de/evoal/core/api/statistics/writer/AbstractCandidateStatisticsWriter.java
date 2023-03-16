package de.evoal.core.api.statistics.writer;

import de.evoal.core.api.statistics.Candidate;
import de.evoal.core.api.statistics.IterationResult;
import de.evoal.core.api.statistics.io.Writer;
import de.evoal.core.api.statistics.io.WriterException;
import de.evoal.core.api.statistics.io.WriterStrategy;
import de.evoal.languages.model.instance.Instance;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public abstract class AbstractCandidateStatisticsWriter implements StatisticsWriter {

    @Inject
    protected WriterStrategy strategy;

    private Writer writer;

    @Override
    public void add(final IterationResult result) {
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
    }

    @Override
    @SneakyThrows(WriterException.class)
    public StatisticsWriter init(final Instance configuration) {
        writer = createWriter();

        return this;
    }

    protected abstract Writer createWriter() throws WriterException ;

    protected abstract Object [] toData(final int index, final int iteration, final Candidate candidate);

    public void write() {
        try {
            strategy.close(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
