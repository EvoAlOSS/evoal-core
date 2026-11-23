package de.evoal.optimisation.api.statistics.writer;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;

/**
 * Base class for statistics writers that write one row per individual of an
 *   iteration. A subclass only chooses the individuals (e.g. all survivors or
 *   only the best ones) and the name of the output.
 * <p>
 * Columns: {@code individual-id}, {@code generation}, then the values of the
 *   search space and of the optimisation space (each optional, see the
 *   attributes {@code store-search-space} and {@code store-optimisation-space}
 *   of the DL types). The {@code individual-id} is the id of the individual in
 *   the memory model, so rows of different outputs can be joined.
 */
@Slf4j
public abstract class AbstractCandidateStatisticsWriter implements StatisticsWriter {
    /**
     * Selects the individuals of an iteration that are written.
     */
    private final Function<Iteration, Stream<? extends Individual>> candidatesProducer;

    /**
     * Evaluates the attributes of the writer's configuration.
     */
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The optimisation space whose values are written.
     */
    @Inject
    @Named("optimisation-space")
    private Space optimisationSpace;

    /**
     * Name of the output, the writer's DL type (e.g. {@code candidates-per-iteration}).
     */
    private final String outputName;

    /**
     * Number of columns of a row.
     */
    private int rowSize;

    /**
     * The search space whose values are written.
     */
    @Inject
    @Named("search-space")
    private Space searchSpace;

    /**
     * Whether the values of the optimisation space are written ({@code store-optimisation-space}).
     */
    private boolean storeOptimisationSpace;

    /**
     * Whether the values of the search space are written ({@code store-search-space}).
     */
    private boolean storeSearchSpace;

    /**
     * Creates the output the rows are written to.
     */
    @Inject
    protected WriterStrategy strategy;

    /**
     * The output, created in {@link #init(EObject)}.
     */
    protected Writer writer;

    /**
     * @param candidatesProducer Selects the individuals of an iteration that are written.
     * @param outputName Name of the output, the writer's DL type.
     */
    protected AbstractCandidateStatisticsWriter(final Function<Iteration, Stream<? extends Individual>> candidatesProducer,
                                                final String outputName) {
        this.candidatesProducer = candidatesProducer;
        this.outputName = outputName;
    }

    /**
     * Writes one row for every selected individual of the iteration and flushes the output.
     */
    @Override
    public void add(final Iteration result) {
        final int iteration = result.getNumber();

        candidatesProducer
                .apply(result)
                .map(individual -> toData(iteration, individual))
                .forEach(r -> {
                    try {
                        writer.addRecord(r);
                    } catch (final WriterException e) {
                        log.warn("Failed to writer statistics record.");
                    }
                });

        writer.flush();
    }

    /**
     * Adds one column per feature of the space, named after the feature and
     *   optionally prefixed ({@code prefix-data}).
     */
    private void addVariableSpace(final Space space,
                                  final boolean prefixColumns,
                                  final String prefix,
                                  final List<Column> columns) {
        for (final EStructuralFeature feature : space) {
            String columnName = feature.getName();

            if (prefixColumns) {
                columnName = prefix + columnName;
            }

            final ColumnType columnType = ColumnType.of(feature);
            columns.add(new Column(columnName, columnType));
        }
    }

    /**
     * Creates the output with the columns of this writer.
     *
     * @param configuration The writer's configuration from the OL file.
     * @return The output the rows are written to.
     * @throws WriterException if the output cannot be created.
     */
    protected Writer createWriter(final EObject configuration) throws WriterException {
        final List<Column> columns = new LinkedList<>();
        final boolean prefixColumns = evaluator.attributeToBoolean(configuration, "prefix-data");
        storeSearchSpace = evaluator.attributeToBoolean(configuration, "store-search-space");
        storeOptimisationSpace = evaluator.attributeToBoolean(configuration, "store-optimisation-space");

        columns.add(new Column("individual-id", ColumnType.Integer));
        columns.add(new Column("generation", ColumnType.Integer));

        if(storeSearchSpace) {
            addVariableSpace(searchSpace, prefixColumns, "search-space-value-", columns);
        }

        if(storeOptimisationSpace) {
            addVariableSpace(optimisationSpace, prefixColumns, "optimisation-space-value-", columns);
        }

        this.rowSize = columns.size();

        return strategy.create(outputName, columns);
    }

    @Override
    @SneakyThrows(WriterException.class)
    public StatisticsWriter init(final EObject configuration) {
        writer = createWriter(configuration);

        return this;
    }

    /**
     * Creates the row of one individual, in the order of the columns of {@link #createWriter(EObject)}.
     *
     * @param iteration Number of the iteration.
     * @param individual The individual.
     * @return The values of the row.
     */
    protected Object [] toData(final int iteration, final Individual individual) {
        final Space searchSpace = individual.getInput().eSpace();
        final Space optimisationSpace = individual.getOutput().eSpace();

        final int searchSpaceSize = searchSpace.size();

        final Object [] data = new Object[rowSize];

        data[0] = individual.getId();
        data[1] = iteration;

        if(storeSearchSpace) {
            int i = 0;
            for (final EStructuralFeature feature : searchSpace) {
                data[2 + i++] = individual.getInput().eGet(feature);
            }
        }

        if(storeOptimisationSpace) {
            int searchSpaceOffset = storeSearchSpace ? searchSpaceSize : 0;

            int i = 0;
            for (final EStructuralFeature feature : optimisationSpace) {
                data[2 + searchSpaceOffset + i++] = individual.getOutput().eGet(feature);
            }
        }
        return data;
    }

    /**
     * Flushes the output at the end of a run.
     */
    @Override
    public void write() {
        try {
            strategy.flush(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
