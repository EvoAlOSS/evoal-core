package de.evoal.core.main.statistics.individuals;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.statistics.*;
import de.evoal.core.api.statistics.io.Writer;
import de.evoal.core.api.statistics.io.WriterException;
import de.evoal.core.api.statistics.writer.AbstractCandidateStatisticsWriter;
import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.BaseDataDescription;
import de.evoal.languages.model.ddl.DataDescription;
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
@Named("de.evoal.core.optimisation.candidates-per-generation")
@Dependent
public class CandidatesPerGeneration extends AbstractCandidateStatisticsWriter {

    @Inject
    private ExpressionEvaluator evaluator;

    @Inject
    @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpaceSpecification;

    private boolean storeOptimisationSpace;

    private boolean storeSearchSpace;

    private int rowSize;

    @Override
    protected Writer createWriter(final Instance configuration) throws WriterException {
        final List<Column> columns = new LinkedList<>();
        final boolean prefixColumns = evaluator.attributeToBoolean(configuration, "prefix-data");
        storeSearchSpace = evaluator.attributeToBoolean(configuration, "store-search-space");
        storeOptimisationSpace = evaluator.attributeToBoolean(configuration, "store-optimisation-space");

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("index", ColumnType.Integer));

        if(storeSearchSpace) {
            addVariableSpace(searchSpaceSpecification, prefixColumns, "search-space-value-", columns);
        }

        if(storeOptimisationSpace) {
            addVariableSpace(optimisationSpaceSpecification, prefixColumns, "optimisation-space-value-", columns);
        }

        this.rowSize = columns.size();

        return strategy.create("optimisation-by-individual", columns);
    }

    private void addVariableSpace(final PropertiesSpecification spaceSpecification, final boolean prefixColumns, final String prefix, final List<Column> columns) {
        for (int i = 0; i < spaceSpecification.size(); ++i) {
            final PropertySpecification spec = spaceSpecification.get(i);
            String columnName = spec.name();

            if (prefixColumns) {
                columnName = prefix + columnName;
            }

            columns.add(new Column(columnName, toColumnType(spec)));
        }
    }

    private ColumnType toColumnType(final PropertySpecification spec) {
        Requirements.requireInstanceOf(spec.type(), BaseDataDescription.class);

        return switch (((BaseDataDescription)spec.type()).getRepresentation()) {
            case REAL -> ColumnType.Double;
            case INTEGER -> ColumnType.Integer;
            case STRING -> ColumnType.String;
            case BOOLEAN -> ColumnType.Boolean;
        };
    }

    @Override
    protected Object [] toData(final int index, final int iteration, final Candidate candidate) {
        final Properties searchSpace = candidate.searchSpaceRepresentation();
        final OptimisationValue optimisationSpace = candidate.value();

        final int searchSpaceSize = searchSpaceSpecification.size();

        final Object [] data = new Object[rowSize];

        data[0] = iteration;
        data[1] = index;

        if(storeSearchSpace) {
            for (int i = 0; i < searchSpaceSize; ++i) {
                data[2 + i] = searchSpace.get(i);
            }
        }

        if(storeOptimisationSpace) {
            int searchSpaceOffset = storeSearchSpace ? searchSpaceSize : 0;
            for (int i = 0; i < optimisationSpaceSpecification.size(); ++i) {
                data[2 + searchSpaceOffset + i] = optimisationSpace.toStatistics()[i];
            }
        }
        return data;
    }
}
