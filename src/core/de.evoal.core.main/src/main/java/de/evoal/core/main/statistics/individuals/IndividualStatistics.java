package de.evoal.core.main.statistics.individuals;

import de.evoal.core.api.statistics.IterationResult;
import de.evoal.core.api.statistics.*;
import de.evoal.core.api.statistics.io.Writer;
import de.evoal.core.api.statistics.io.WriterException;
import de.evoal.core.api.statistics.io.WriterStrategy;
import de.evoal.core.api.statistics.writer.AbstractCandidateStatisticsWriter;
import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;
import de.evoal.core.api.statistics.writer.StatisticsWriter;
import de.evoal.languages.model.base.Instance;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("individuals")
@Dependent
public class IndividualStatistics extends AbstractCandidateStatisticsWriter {

    @Inject @Named("genotype-specification")
    private PropertiesSpecification sourceSpecification;

    @Override
    protected Writer createWriter() throws WriterException {
        final List<Column> columns = new ArrayList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("index", ColumnType.Integer));
        columns.add(new Column("age", ColumnType.Integer));

        for(int i = 0; i < sourceSpecification.size(); ++i) {
            columns.add(new Column(sourceSpecification.getProperties().get(i).name(), ColumnType.Double));
        }

        return strategy.create("individuals", columns);
    }

    @Override
    protected Object[] toData(final int index, final int iteration, final Candidate candidate) {
        final Object [] data = new Object[3 + sourceSpecification.size()];

        final Properties individual = candidate.searchSpaceRepresentation();

        data[0] = iteration;
        data[1] = index;
        data[2] = candidate.age();

        for(int i = 0; i < individual.size(); ++i) {
            data[3 + i] = individual.getValues()[i];
        }

        return data;
    }
}
