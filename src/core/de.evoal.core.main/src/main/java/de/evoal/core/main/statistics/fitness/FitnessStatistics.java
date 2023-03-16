package de.evoal.core.main.statistics.fitness;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.statistics.*;
import de.evoal.core.api.statistics.io.Writer;
import de.evoal.core.api.statistics.io.WriterException;
import de.evoal.core.api.statistics.writer.AbstractCandidateStatisticsWriter;
import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;

import javax.enterprise.context.Dependent;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.LinkedList;
import java.util.List;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("fitness-per-individual")
@Dependent
public class FitnessStatistics extends AbstractCandidateStatisticsWriter {

    @Inject
    @Named("optimisation-function-output")
    private Provider<PropertiesSpecification> targetSpecification;

    @Override
    protected Writer createWriter() throws WriterException {
        final List<Column> columns = new LinkedList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("index", ColumnType.Integer));

        for(int i = 0; i < targetSpecification.get().size(); ++i) {
            columns.add(new Column("fitness-value-" + targetSpecification.get().get(i).name(), ColumnType.Double));
        }

        return strategy.create("fitness-by-individual", columns);
    }

    @Override
    protected Object[] toData(final int index, final int iteration, final Candidate candidate) {
        final Object [] data = new Object[2 + targetSpecification.get().size()];

        data[0] = iteration;
        data[1] = index;

        final Object [] fitnessValues = candidate.value().toStatistics();

        System.arraycopy(fitnessValues, 0, data, 2, fitnessValues.length);

        return data;
    }
}
