package de.evoal.optimisation.main.statistics.individuals;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.cdi.ComponentProducer;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

/**
 * Evaluates a reference function on the surviving individuals of every iteration and writes
 *   its values to {@code reference-values-per-individual.csv} (DL type
 *   {@code reference-values-per-individual}). The rows are those of
 *   {@code candidates-per-iteration}, in the same order, so both files join by
 *   {@code individual-id} and {@code generation}.
 * <p>
 * The reference is evaluated directly on the thread of the algorithm, in the order of the
 *   survivors, not through the evaluation service: it uses no evaluation budget, does not
 *   count as a real or surrogate evaluation and publishes no events. Therefore, the run does
 *   not change when the writer is added. The evaluations are counted in the execution metric
 *   {@value ReferenceEvaluations#METRIC_NAME}. Random numbers of an evaluation
 *   ({@code RandomService.taskRandom}) are only available in the evaluations of the run, so a
 *   reference that draws them fails.
 */
@Named("de.evoal.optimisation.core.reference-values-per-individual")
@Dependent
@Slf4j
public class ReferenceValuesPerIndividual implements StatisticsWriter {
    /**
     * The name of the output, the writer's DL type.
     */
    private static final String OUTPUT_NAME = "reference-values-per-individual";

    /**
     * Reads the attributes of the writer's configuration.
     */
    @Inject
    private AttributeHelper attributes;

    /**
     * Counts the evaluations of the reference.
     */
    @Inject
    private ReferenceEvaluations evaluations;

    /**
     * The optimisation space whose values the reference computes.
     */
    @Inject
    @Named("optimisation-space")
    private Space optimisationSpace;

    /**
     * Creates the reference function from its configuration.
     */
    @Inject
    private ComponentProducer producer;

    /**
     * The reference function, created in {@link #init(EObject)}.
     */
    private OptimisationFunction reference;

    /**
     * Creates the output the rows are written to.
     */
    @Inject
    private WriterStrategy strategy;

    /**
     * The output, created in {@link #init(EObject)}.
     */
    private Writer writer;

    /**
     * Writes one row with the reference values of every survivor of the iteration and
     *   flushes the output.
     *
     * @throws IllegalStateException if the reference cannot evaluate a survivor.
     */
    @Override
    public void add(final Iteration iteration) {
        final int number = iteration.getNumber();

        iteration.survivedIndividuals()
                 .map(individual -> toRow(number, individual))
                 .forEach(this::addRecord);

        writer.flush();
    }

    /**
     * Writes a row; a failure is logged.
     */
    private void addRecord(final Object[] row) {
        try {
            writer.addRecord(row);
        } catch(final WriterException e) {
            log.warn("Failed to write a record of '{}'.", OUTPUT_NAME, e);
        }
    }

    /**
     * @return The columns: {@code individual-id}, {@code generation}, then one column per
     *   feature of the optimisation space.
     */
    private List<Column> columns() {
        final List<Column> columns = new ArrayList<>();
        columns.add(new Column("individual-id", ColumnType.Integer));
        columns.add(new Column("generation", ColumnType.Integer));

        for(final EStructuralFeature feature : optimisationSpace) {
            final ColumnType type = ColumnType.of(feature);
            columns.add(new Column(feature.getName(), type));
        }

        return columns;
    }

    /**
     * Evaluates the reference on the input of the individual and counts the evaluation.
     *
     * @throws IllegalStateException if the evaluation fails.
     */
    private TypedEObject evaluate(final Individual individual) {
        evaluations.count();

        try {
            return reference.evaluate(individual.getInput());
        } catch(final RuntimeException e) {
            throw new IllegalStateException("The reference function of '" + OUTPUT_NAME
                                            + "' cannot evaluate the individual " + individual.getId() + ".", e);
        }
    }

    /**
     * Creates the reference function and the output, and defines the execution metric
     *   {@value ReferenceEvaluations#METRIC_NAME}.
     *
     * @throws IllegalStateException if the output cannot be created.
     */
    @Override
    public StatisticsWriter init(final EObject configuration) {
        final EObject referenceConfiguration = attributes.lookup(configuration, "reference");
        reference = producer.create(OptimisationFunction.class, referenceConfiguration);

        final List<Column> columns = columns();
        try {
            writer = strategy.create(OUTPUT_NAME, columns);
        } catch(final WriterException e) {
            throw new IllegalStateException("Cannot create the output '" + OUTPUT_NAME + "'.", e);
        }

        evaluations.register();

        return this;
    }

    /**
     * @return The row of the individual, in the order of {@link #columns()}.
     */
    private Object[] toRow(final int iteration, final Individual individual) {
        final TypedEObject referenceValues = evaluate(individual);

        final Object[] row = new Object[2 + optimisationSpace.size()];
        row[0] = individual.getId();
        row[1] = iteration;

        int column = 2;
        for(final EStructuralFeature feature : optimisationSpace) {
            row[column] = referenceValues.eGet(feature);
            column += 1;
        }

        return row;
    }

    /**
     * Flushes the output at the end of a run.
     */
    @Override
    public void write() {
        try {
            strategy.flush(writer);
        } catch(final WriterException e) {
            log.error("Failed to write '{}'.", OUTPUT_NAME, e);
        }
    }
}
