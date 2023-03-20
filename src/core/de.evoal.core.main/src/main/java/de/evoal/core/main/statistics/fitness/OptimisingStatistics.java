package de.evoal.core.main.statistics.fitness;

import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.statistics.*;
import de.evoal.core.api.statistics.io.Writer;
import de.evoal.core.api.statistics.io.WriterException;
import de.evoal.core.api.statistics.writer.AbstractCandidateStatisticsWriter;
import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("optimising-per-individual")
@Dependent
public class OptimisingStatistics extends AbstractCandidateStatisticsWriter {

    @Inject
    @Named("optimisation-function")
    private OptimisationFunction optimisationFunction;

    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification targetSpecification;

    @Override
    protected Writer createWriter() throws WriterException {
        final List<Column> columns = new LinkedList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("index", ColumnType.Integer));

        for(int i = 0; i < targetSpecification.size(); ++i) {
            columns.add(new Column("optimisation-value-" + targetSpecification.get(i).name(), ColumnType.Double));
        }

        return strategy.create("optimisation-by-individual", columns);
    }

    @Override
    protected Object [] toData(final int index, final int iteration, final Candidate candidate) {
        final Object [] data = new Object[2 + targetSpecification.size()];

        data[0] = iteration;
        data[1] = index;

        final Properties individual = candidate.searchSpaceRepresentation();
        final double [] raw = optimisationFunction.evaluate(individual);

        for(int i = 0; i < raw.length; ++i) {
            data[2 + i] = raw[i];
        }

        return data;
    }
}
