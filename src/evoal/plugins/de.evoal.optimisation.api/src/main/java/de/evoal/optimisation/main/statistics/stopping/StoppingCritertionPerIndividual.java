package de.evoal.optimisation.main.statistics.stopping;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.optimisation.api.model.*;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Writes for every surviving individual of every iteration which of the
 *   configured candidate-based stopping criteria are satisfied to
 *   {@code stopping-per-candidates-per-iteration.csv} (DL type
 *   {@code stopping-per-candidates-per-iteration}). The columns are described
 *   in the DL type.
 */
@Slf4j
@Named("de.evoal.optimisation.core.stopping-per-candidates-per-iteration")
@Dependent
public class StoppingCritertionPerIndividual implements StatisticsWriter {
    /**
     * Evaluates the attributes of the writer's configuration.
     */
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * Number of columns of a row.
     */
    private int numberOfColumns;

    /**
     * The configured candidate-based stopping criteria, one column each. Other
     *   criteria are skipped with a warning.
     */
    private CandidateBasedStoppingCriterion[] stoppingCriteria;

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
     * Writes one row per surviving individual of the iteration and flushes the output.
     */
    @Override
    public void add(final Iteration result) {
        final int iterationNumber = result.getNumber();
        final Rank bestCandidates = result.getRanks().getFirst();
        final int numberOfCandidates = result.numberOfSurvivedIndividuals();

        result.survivedIndividuals()
              .map(candidate -> toData(iterationNumber, numberOfCandidates, bestCandidates, candidate))
              .forEach(this::appendToWriter);

        writer.flush();
    }

    /**
     * Writes the row. A failure is logged and does not stop the run.
     */
    private void appendToWriter(final Object [] record) {
        try {
            writer.addRecord(record);
        } catch (final WriterException e) {
            log.warn("Failed to writer statistics record.");
        }
    }

    @Override
    @SneakyThrows(WriterException.class)
    public StatisticsWriter init(final EObject configuration) {
        final EObject[] configs = evaluator.attributeToEObjectArray(configuration, "criteria");
        stoppingCriteria = Arrays.stream(configs)
                .map(i -> BeanFactory.createComponent(TerminationCriterion.class, i))
                .peek(StoppingCritertionPerIndividual::warnIfNotCandidateBased)
                .filter(CandidateBasedStoppingCriterion.class::isInstance)
                .map(CandidateBasedStoppingCriterion.class::cast)
                .toArray(CandidateBasedStoppingCriterion[]::new);


        final List<Column> columns = new LinkedList<>();
        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("individual-id", ColumnType.Integer));

        for(int i = 0; i < stoppingCriteria.length; i++) {
            columns.add(new Column("criterion-" + i, ColumnType.Integer));
        }

        this.numberOfColumns = columns.size();
        this.writer = strategy.create("stopping-per-candidates-per-iteration", columns);

        return this;
    }

    /**
     * @return The row of the individual: iteration number, id of the individual
     *   (memory model), then {@code 1} or {@code 0} per criterion.
     */
    protected Object [] toData(final int iterationNumber,
                               final int numberOfCandidates,
                               final Rank bestCandidates,
                               final Individual candidate) {
        final Object [] data = new Object[numberOfColumns];

        data[0] = iterationNumber;
        data[1] = candidate.getId();

        for(int i = 0; i < stoppingCriteria.length; i++) {
            final CandidateBasedStoppingCriterion criterion = stoppingCriteria[i];

            final boolean satisfied = criterion.isSatisfied(
                    iterationNumber,
                    numberOfCandidates,
                    bestCandidates,
                    candidate);

            data[i + 2] = satisfied ? 1 : 0;
        }

        return data;
    }

    /**
     * Only candidate-based criteria can be evaluated per individual; the others are skipped.
     */
    private static void warnIfNotCandidateBased(final TerminationCriterion criterion) {
        if(!(criterion instanceof CandidateBasedStoppingCriterion)) {
            log.warn("One of the configured stopping criteria is not an individual-based one.");
        }
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
