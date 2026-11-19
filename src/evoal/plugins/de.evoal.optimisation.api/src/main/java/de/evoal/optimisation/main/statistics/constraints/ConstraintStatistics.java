package de.evoal.optimisation.main.statistics.constraints;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintEvaluation;
import de.evoal.optimisation.api.constraints.Constraints;
import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

/**
 * Writes the constraint violations of every iteration to {@code constraint-statistics.csv}
 *   (DL type {@code 'constraint-statistics'}): the iteration number, then for every
 *   constraint group of the DDL, in the order of the DDL, {@code infeasible-<group>}, the
 *   number of individuals of the iteration that violate the group, and
 *   {@code violation-<group>}, the sum of their violations of the group. The individuals are
 *   the ones that survive the iteration (the population, as in
 *   {@code 'candidates-per-iteration'}); their degrees are the properties
 *   {@code violation-<n>} of the memory model.
 */
@Dependent
@Named("de.evoal.optimisation.core.constraint-statistics")
@Slf4j
public class ConstraintStatistics implements StatisticsWriter {
    /**
     * The constraints of the run, read in {@link #init(EObject)}.
     */
    private Constraints constraints;

    @Inject
    private ConstraintEvaluation evaluation;

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
    public ConstraintStatistics() {
    }

    /**
     * Creates a writer for the given constraints, e.g., for tests.
     *
     * @param constraints The constraints of the run.
     */
    ConstraintStatistics(final Constraints constraints) {
        this.constraints = constraints;
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
            log.warn("Failed to write the constraint statistics of iteration {}.", result.getNumber(), e);
        }

        writer.flush();
    }

    /**
     * @throws InitializationException if the problem has no constraints.
     */
    @Override
    public StatisticsWriter init(final EObject configuration) throws InitializationException {
        constraints = evaluation.constraints();

        if(constraints.isEmpty()) {
            throw new InitializationException("'constraint-statistics' needs constraints, but the DDL of the problem "
                                              + "declares none.");
        }

        return this;
    }

    /**
     * Creates the output with two columns per group.
     */
    @Override
    public void start() {
        if(writer != null) {
            return;
        }

        final List<Column> columns = new ArrayList<>();
        columns.add(new Column("iteration", ColumnType.Integer));
        for(final String group : constraints.groups()) {
            columns.add(new Column("infeasible-" + group, ColumnType.Integer));
            columns.add(new Column("violation-" + group, ColumnType.Double));
        }

        try {
            writer = strategy.create("constraint-statistics", columns);
        } catch(final WriterException e) {
            throw new IllegalStateException("Cannot create the output 'constraint-statistics'.", e);
        }
    }

    /**
     * @return The row of the iteration.
     */
    Object[] toRecord(final Iteration iteration) {
        final List<Individual> individuals = iteration.survivedIndividuals().toList();
        final Object[] record = new Object[1 + 2 * constraints.groups().size()];
        record[0] = iteration.getNumber();

        int column = 1;
        for(final String group : constraints.groups()) {
            final List<Constraint> inGroup = constraints.inGroup(group);
            long infeasible = 0;
            double violation = 0.0;

            for(final Individual individual : individuals) {
                final double individualViolation = violationOf(individual, inGroup);
                if(individualViolation > 0.0) {
                    infeasible += 1;
                    violation += individualViolation;
                }
            }

            record[column++] = infeasible;
            record[column++] = violation;
        }

        return record;
    }

    /**
     * @return The sum of the degrees of the constraints that the individual records.
     */
    private static double violationOf(final Individual individual, final List<Constraint> inGroup) {
        double sum = 0.0;

        for(final Constraint constraint : inGroup) {
            final Object degree = individual.getProperties().get(ViolationRecord.propertyName(constraint));
            if(degree instanceof Number number) {
                sum += number.doubleValue();
            }
        }

        return sum;
    }

    /**
     * Flushes the output at the end of a run.
     */
    @Override
    public void write() {
        if(writer == null) {
            return;
        }

        try {
            strategy.flush(writer);
        } catch(final WriterException e) {
            log.error("Failed to write the constraint statistics.", e);
        }
    }
}
