package de.evoal.core.main.statistics.individuals;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.statistics.IterationResult;
import de.evoal.core.api.statistics.io.Writer;
import de.evoal.core.api.statistics.io.WriterException;
import de.evoal.core.api.statistics.io.WriterStrategy;
import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;
import de.evoal.core.api.statistics.writer.StatisticsWriter;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.BaseDataDescription;
import de.evoal.languages.model.ddl.DataDescription;
import lombok.SneakyThrows;
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
@Named("de.evoal.core.optimisation.best-candidate-per-generation")
@Dependent
public class BestCandidatePerGeneration implements StatisticsWriter {

    @Inject
    protected WriterStrategy strategy;

    @Inject
    private ExpressionEvaluator evaluator;

    @Inject
    @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpaceSpecification;

    private Writer writer;

    private boolean storeOptimisationSpace;

    private boolean storeSearchSpace;

    private int rowSize;

    @SneakyThrows
    @Override
    public StatisticsWriter init(final Instance configuration) {
        final List<Column> columns = new LinkedList<>();
        final boolean prefixColumns = evaluator.attributeToBoolean(configuration, "prefix-data");
        storeSearchSpace = evaluator.attributeToBoolean(configuration, "store-search-space");
        storeOptimisationSpace = evaluator.attributeToBoolean(configuration, "store-optimisation-space");

        columns.add(new Column("generation", ColumnType.Integer));

        if(storeSearchSpace) {
            addVariableSpace(searchSpaceSpecification, prefixColumns, "search-space-value-", columns);
        }

        if(storeOptimisationSpace) {
            addVariableSpace(optimisationSpaceSpecification, prefixColumns, "optimisation-space-value-", columns);
        }

        this.writer = strategy.create("best-candidate-statistics", columns);
        this.rowSize = columns.size();

        return this;
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
        if(spec.type() instanceof BaseDataDescription) {
            return switch (((BaseDataDescription)spec.type()).getRepresentation()) {
                case REAL -> ColumnType.Double;
                case INTEGER -> ColumnType.Integer;
                case STRING -> ColumnType.String;
                case BOOLEAN -> ColumnType.Boolean;
            };
        } else {
            return ColumnType.String;
        }
    }

    @SneakyThrows
    @Override
    public void add(final IterationResult result) {
        final Properties searchSpace = result.bestCandidate().searchSpaceRepresentation();
        final OptimisationValue optimisationSpace = result.bestCandidate().value();

        final int searchSpaceSize = searchSpaceSpecification.size();

        final Object [] data = new Object[rowSize];

        data[0] = result.iteration();
        if(storeSearchSpace) {
            for (int i = 0; i < searchSpaceSize; ++i) {
                data[1 + i] = searchSpace.get(i);
            }
        }

        if(storeOptimisationSpace) {
            int searchSpaceOffset = storeSearchSpace ? searchSpaceSize : 0;
            for (int i = 0; i < optimisationSpaceSpecification.size(); ++i) {
                data[1 + searchSpaceOffset + i] = optimisationSpace.toStatistics()[i];
            }
        }

        writer.addRecord(data);
        writer.flush();
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
