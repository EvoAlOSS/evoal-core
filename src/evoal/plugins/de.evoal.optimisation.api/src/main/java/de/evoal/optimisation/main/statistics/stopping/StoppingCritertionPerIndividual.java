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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Logs stopping criteria information for every individual of an iteration.
 */
@Slf4j
@Named("de.evoal.optimisation.core.stopping-per-candidates-per-iteration")
@Dependent
public class StoppingCritertionPerIndividual implements StatisticsWriter {

    @Inject
    private AttributeEvaluator evaluator;

    private int numberOfColumns;

    private CandidateBasedStoppingCriterion[] stoppingCriteria;

    @Inject
    protected WriterStrategy strategy;

    protected Writer writer;

    @Override
    @SneakyThrows(WriterException.class)
    public StatisticsWriter init(final EObject configuration) {
        final EObject[] configs = evaluator.attributeToEObjectArray(configuration, "criteria");
        stoppingCriteria = Arrays.stream(configs)
                .map(i -> BeanFactory.createComponent(TerminationCriterion.class, i))
                .peek(s -> {if (!(s instanceof CandidateBasedStoppingCriterion)) log.warn("One of the configured stopping criteria is not an individual-based one."); })
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
        this.writer = strategy.create("candidate-stopping-criteria", columns);

        return this;
    }

    @Override
    public void add(final Iteration result) {
        final int iterationNumber = result.getNumber();
        final Rank bestCandidates = result.getRanks().getFirst();
        final int numberOfCandidates = result.numberOfSurvivedIndividuals();

        final AtomicInteger counter = new AtomicInteger(0);

        result.survivedIndividuals()
                .map(c -> toData(iterationNumber, counter.getAndIncrement(), numberOfCandidates, bestCandidates, c))
                .forEach(this::appendToWriter);

        writer.flush();
    }

    protected Object [] toData(final int iterationNumber, final int candidateNumber, final int numberOfCandidates, final Rank bestCandidates, final Individual candidate) {
        final Object [] data = new Object[numberOfColumns];

        data[0] = iterationNumber;
        data[1] = candidateNumber;

        for(int i = 0; i < stoppingCriteria.length; i++) {
            final CandidateBasedStoppingCriterion criterion = stoppingCriteria[i];

            final boolean satisfied = criterion.isSatisfied(
                    iterationNumber,
                    candidateNumber,
                    numberOfCandidates,
                    bestCandidates,
                    candidate);

            data[i + 2] = satisfied ? 1 : 0;
        }

        return data;
    }

    private void appendToWriter(final Object [] record) {
        try {
            writer.addRecord(record);
        } catch (final WriterException e) {
            log.warn("Failed to writer statistics record.");
        }
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
