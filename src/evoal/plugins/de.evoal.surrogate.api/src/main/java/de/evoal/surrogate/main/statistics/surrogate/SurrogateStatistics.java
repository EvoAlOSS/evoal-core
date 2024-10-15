package de.evoal.surrogate.main.statistics.surrogate;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.optimisation.api.statistics.Candidate;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.writer.AbstractCandidateStatisticsWriter;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.languages.model.base.Instance;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.extern.slf4j.Slf4j;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("de.evoal.surrogate.optimisation.prediction-per-individual")
@Dependent
public class SurrogateStatistics extends AbstractCandidateStatisticsWriter {
    /**
     * The predictive function used.
     */
    @Inject
    protected SurrogateFunction predictive;

    @Inject
    @Named("surrogate-target-properties-specification")
    private PropertiesSpecification targetSpecification;

    @Override
    protected Writer createWriter(final Instance configuration) throws WriterException {
        final List<Column> columns = new LinkedList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("index", ColumnType.Integer));

        for(int i = 0; i < targetSpecification.size(); ++i) {
            columns.add(new Column(targetSpecification.getProperties().get(i).name(), ColumnType.Double));
        }

        return strategy.create("prediction-by-individual", columns);
    }

    @Override
    protected Object[] toData(final int index, final int iteration, final Candidate candidate) {
        final Object [] data = new Object[2 + targetSpecification.size()];

        data[0] = iteration;
        data[1] = index;

        final Properties representation = candidate.searchSpaceRepresentation();
        final Properties predicted = predictive.apply(representation);

        for(int i = 0; i < predicted.size(); ++i) {
            data[2 + i] = predicted.getValues()[i];
        }

        return data;
    }
}
