package de.evoal.optimisation.cma_es.main;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.correlations.BuildingBlock;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.LinkageGroup;
import de.evoal.optimisation.api.correlations.ProblemCorrelations;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

/**
 * Compares the linkage CMA-ES learned with the linkage the DDL declares and writes it into
 *   {@code learned-linkage.csv} (DL type {@code 'learned-linkage'}): the iteration number,
 *   then for every correlation g of the DDL ({@code correlation-<n>}) the declared
 *   coefficient ({@code declared-<g>}), the correlation the covariance matrix implies
 *   ({@code learned-<g>}) and their difference learned - declared ({@code difference-<g>}),
 *   and for every building block b ({@code building-block-<n>}) the mean absolute learned
 *   correlation within the block ({@code within-<b>}) and between the block and the other
 *   features ({@code between-<b>}).
 * <p>
 * The covariance matrix describes the whole search space; a ranged correlation is compared
 *   like an unranged one. A learned value is empty if the iteration has none, e.g., for the
 *   diagonal model or another algorithm. A problem without building blocks and correlations
 *   is rejected.
 */
@Dependent
@Named("de.evoal.optimisation.cma_es.optimisation.learned-linkage")
@Slf4j
public class LearnedLinkageWriter implements StatisticsWriter {
    /**
     * The building blocks and correlations of the DDL, in its order.
     */
    private List<LinkageGroup> groups;

    @Inject
    private ProblemCorrelations problemCorrelations;

    /**
     * Creates the output the rows are written to.
     */
    @Inject
    private WriterStrategy strategy;

    /**
     * The output, created at the start of the run. {@code null} before.
     */
    private Writer writer;

    /**
     * Creates a writer that is configured by {@link #init(EObject)}.
     */
    public LearnedLinkageWriter() {
    }

    /**
     * Creates a writer for the given groups, e.g., for tests.
     *
     * @param groups The building blocks and correlations of the DDL, in its order.
     */
    LearnedLinkageWriter(final List<LinkageGroup> groups) {
        this.groups = List.copyOf(groups);
    }

    /**
     * Writes the row of the iteration and flushes the output. A failure is logged and does not
     *   stop the run.
     */
    @Override
    public void add(final Iteration result) {
        if(writer == null) {
            start();
        }

        try {
            writer.addRecord(toRecord(result));
        } catch(final WriterException e) {
            log.warn("Failed to write the learned linkage of iteration {}.", result.getNumber(), e);
        }

        writer.flush();
    }

    /**
     * @throws InitializationException if the problem has neither building blocks nor
     *   correlations.
     */
    @Override
    public StatisticsWriter init(final EObject configuration) throws InitializationException {
        groups = problemCorrelations.correlations().linkageGroups();
        if(groups.isEmpty()) {
            throw new InitializationException("'learned-linkage' needs building blocks or correlations, but the DDL of the "
                                              + "problem declares none.");
        }

        return this;
    }

    private static Double realOf(final Number value) {
        return value == null ? null : value.doubleValue();
    }

    /**
     * Creates the output.
     */
    @Override
    public void start() {
        if(writer != null) {
            return;
        }

        final List<Column> columns = new ArrayList<>();
        columns.add(new Column("iteration", ColumnType.Integer));
        for(final LinkageGroup group : groups) {
            final String name = DistributionMetrics.nameOf(group);
            switch(group) {
                case Correlation correlation -> {
                    columns.add(new Column("declared-" + name, ColumnType.Double));
                    columns.add(new Column("learned-" + name, ColumnType.Double));
                    columns.add(new Column("difference-" + name, ColumnType.Double));
                }
                case BuildingBlock block -> {
                    columns.add(new Column("within-" + name, ColumnType.Double));
                    columns.add(new Column("between-" + name, ColumnType.Double));
                }
            }
        }

        try {
            writer = strategy.create("learned-linkage", columns);
        } catch(final WriterException e) {
            throw new IllegalStateException("Cannot create the output 'learned-linkage'.", e);
        }
    }

    /**
     * @return The row of the iteration.
     */
    Object[] toRecord(final Iteration iteration) {
        final List<Object> record = new ArrayList<>();
        record.add(iteration.getNumber());

        for(final LinkageGroup group : groups) {
            final String name = DistributionMetrics.nameOf(group);
            switch(group) {
                case Correlation correlation -> {
                    final Double learned = realOf(iteration.getMetrics().get(DistributionMetrics.LEARNED + name));
                    record.add(correlation.coefficient());
                    record.add(learned);
                    record.add(learned == null ? null : learned - correlation.coefficient());
                }
                case BuildingBlock block -> {
                    record.add(realOf(iteration.getMetrics().get(DistributionMetrics.LEARNED_WITHIN + name)));
                    record.add(realOf(iteration.getMetrics().get(DistributionMetrics.LEARNED_BETWEEN + name)));
                }
            }
        }

        return record.toArray();
    }

    @Override
    public void write() {
        if(writer == null) {
            return;
        }

        try {
            strategy.flush(writer);
        } catch(final WriterException e) {
            log.error("Failed to write the learned linkage.", e);
        }
    }
}
