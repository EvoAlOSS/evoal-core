package de.evoal.optimisation.ea.main.statistics;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.correlations.LinkageGroup;
import de.evoal.optimisation.api.correlations.ProblemCorrelations;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

/**
 * Writes the metrics of the {@link LinkageStatistics} into {@code linkage-statistics.csv} (DL
 *   type {@code 'linkage-statistics'}): the iteration number, then for every building block
 *   and correlation g of the DDL, in its order: {@code children-<g>}, {@code preserved-<g>},
 *   {@code rate-<g>}, {@code preserved-before-<g>} and {@code rate-before-<g>}. A rate is
 *   empty if no child was counted, and all values are empty if the iteration has no metrics
 *   (e.g. for another algorithm). A problem without building blocks and correlations is
 *   rejected.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.linkage-statistics")
@Slf4j
public class LinkageStatisticsWriter implements StatisticsWriter {
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
    public LinkageStatisticsWriter() {
    }

    /**
     * Creates a writer for the given groups, e.g., for tests.
     *
     * @param groups The building blocks and correlations of the DDL, in its order.
     */
    LinkageStatisticsWriter(final List<LinkageGroup> groups) {
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
            log.warn("Failed to write the linkage statistics of iteration {}.", result.getNumber(), e);
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
            throw new InitializationException("'linkage-statistics' needs building blocks or correlations, but the DDL "
                                              + "of the problem declares none.");
        }

        return this;
    }

    private static Double rate(final Number part, final Number whole) {
        if(part == null || whole == null || whole.longValue() == 0) {
            return null;
        }

        return part.doubleValue() / whole.doubleValue();
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
            final String name = LinkageStatistics.nameOf(group);
            columns.add(new Column("children-" + name, ColumnType.Integer));
            columns.add(new Column("preserved-" + name, ColumnType.Integer));
            columns.add(new Column("rate-" + name, ColumnType.Double));
            columns.add(new Column("preserved-before-" + name, ColumnType.Integer));
            columns.add(new Column("rate-before-" + name, ColumnType.Double));
        }

        try {
            writer = strategy.create("linkage-statistics", columns);
        } catch(final WriterException e) {
            throw new IllegalStateException("Cannot create the output 'linkage-statistics'.", e);
        }
    }

    /**
     * @return The row of the iteration.
     */
    Object[] toRecord(final Iteration iteration) {
        final List<Object> record = new ArrayList<>();
        record.add(iteration.getNumber());

        for(final LinkageGroup group : groups) {
            final String name = LinkageStatistics.nameOf(group);
            final Number children = iteration.getMetrics().get(LinkageStatistics.CHILDREN + name);
            final Number preserved = iteration.getMetrics().get(LinkageStatistics.PRESERVED + name);
            final Number before = iteration.getMetrics().get(LinkageStatistics.PRESERVED_BEFORE + name);

            record.add(children == null ? null : children.longValue());
            record.add(preserved == null ? null : preserved.longValue());
            record.add(rate(preserved, children));
            record.add(before == null ? null : before.longValue());
            record.add(rate(before, children));
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
            log.error("Failed to write the linkage statistics.", e);
        }
    }
}
