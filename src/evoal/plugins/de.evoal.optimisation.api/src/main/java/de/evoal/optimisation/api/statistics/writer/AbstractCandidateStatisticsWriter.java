package de.evoal.optimisation.api.statistics.writer;

import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import jakarta.inject.Inject;
import org.eclipse.emf.ecore.EObject;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

@Slf4j
public abstract class AbstractCandidateStatisticsWriter implements StatisticsWriter {
    private final Function<Iteration, Stream<Individual>> candidatesProducer;

    public AbstractCandidateStatisticsWriter(final Function<Iteration, Stream<Individual>> candidatesProducer) {
        this.candidatesProducer = candidatesProducer;
    }

    @Inject
    protected WriterStrategy strategy;

    protected Writer writer;

    @Override
    public void add(final Iteration result) {
        final AtomicInteger counter = new AtomicInteger(0);

        candidatesProducer
                .apply(result)
                .map(c -> toData(counter.getAndIncrement(), result.getNumber(), c))
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
    public StatisticsWriter init(final EObject configuration) {
        writer = createWriter(configuration);

        return this;
    }

    protected abstract Writer createWriter(final EObject configuration) throws WriterException ;

    protected abstract Object [] toData(final int index, final int iteration, final Individual individual);

    public void write() {
        try {
            strategy.close(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
