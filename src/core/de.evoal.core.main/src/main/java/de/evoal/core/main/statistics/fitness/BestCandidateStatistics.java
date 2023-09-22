package de.evoal.core.main.statistics.fitness;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.statistics.IterationResult;
import de.evoal.core.api.statistics.io.Writer;
import de.evoal.core.api.statistics.io.WriterException;
import de.evoal.core.api.statistics.io.WriterStrategy;
import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;
import de.evoal.core.api.statistics.writer.StatisticsWriter;
import de.evoal.languages.model.base.Instance;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.LinkedList;
import java.util.List;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("best-candidate-statistics")
@Dependent
public class BestCandidateStatistics implements StatisticsWriter {

    @Inject
    protected WriterStrategy strategy;

    @Inject
    @Named("search-space-specification")
    private Provider<PropertiesSpecification> searchSpaceSpecification;

    @Inject
    @Named("optimisation-space-specification")
    private Provider<PropertiesSpecification> optimisationSpaceSpecification;
    private Writer writer;

    @SneakyThrows
    @Override
    public StatisticsWriter init(final Instance configuration) {
        final List<Column> columns = new LinkedList<>();

        columns.add(new Column("generation", ColumnType.Integer));

        for(int i = 0; i < searchSpaceSpecification.get().size(); ++i) {
            columns.add(new Column("search-space-value-" + searchSpaceSpecification.get().get(i).name(), ColumnType.Double));
        }

        for(int i = 0; i < optimisationSpaceSpecification.get().size(); ++i) {
            columns.add(new Column("optimisation-space-value-" + optimisationSpaceSpecification.get().get(i).name(), ColumnType.Double));
        }

        this.writer = strategy.create("best-candidate-statistics", columns);

        return this;
    }

    @SneakyThrows
    @Override
    public void add(final IterationResult result) {
        final Properties candidate = result.bestCandidate().searchSpaceRepresentation();
        final OptimisationValue value = result.bestCandidate().value();

        final int searchSpaceSize = searchSpaceSpecification.get().size();
        final int optimisationSpaceSize = optimisationSpaceSpecification.get().size();

        final Object [] data = new Object[1 + searchSpaceSize + optimisationSpaceSize];

        data[0] = result.iteration();
        for(int i = 0; i < searchSpaceSpecification.get().size(); ++i) {
            data[1 + i] = candidate.getAsDouble(i);
        }

        for(int i = 0; i < optimisationSpaceSpecification.get().size(); ++i) {
            data[1 + searchSpaceSize + i] = value.toStatistics()[i];
        }

        writer.addRecord(data);
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
