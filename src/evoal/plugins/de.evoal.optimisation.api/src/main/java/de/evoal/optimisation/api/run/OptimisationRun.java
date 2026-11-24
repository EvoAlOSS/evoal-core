package de.evoal.optimisation.api.run;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.cdi.Component;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.IndividualRecord;
import de.evoal.models.v202704.optimisation.memory.IndividualStub;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.events.IterationFinished;
import de.evoal.optimisation.api.events.IterationStarted;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.events.RunFinished;
import de.evoal.optimisation.api.events.RunListener;
import de.evoal.optimisation.api.events.RunStarted;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.model.IndividualIDGenerator;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriterListener;

/**
 * Executes a run of an optimisation algorithm, the algorithm-specific part is a
 *   {@link SearchProcedure}:
 * <ol>
 *   <li>Iteration 0 initialises the search ({@link SearchProcedure#initialise()}).</li>
 *   <li>As long as the search can continue ({@link Progress#CONTINUE}), the budget is not
 *     exhausted, and the termination criterion agrees, the next iteration is executed
 *     ({@link SearchProcedure#iterate(int)}).</li>
 * </ol>
 * After every iteration, including one interrupted by an exhausted evaluation budget, the
 *   kernel creates the memory state of the iteration from the
 *   {@link SearchProcedure#population()} and publishes it: every executed step holds its
 *   outputs as individuals, related to their direct predecessors, and the ranks hold the
 *   members, related to the individuals of the previous iteration by their {@link Lineage}
 *   ({@link IterationRecording}). The individuals get their ids in the order of their first
 *   occurrence. A predecessor that is not a member of the previous iteration, but an unchanged
 *   copy of one ({@link Lineage.Kind#IDENTITY}), stands for its original.
 *   The properties of a candidate and of its lineage become the properties of the individual
 *   and of its relationship; they have to be defined in the {@link ExecutionRecorder}.
 *   The best individual so far is the first member whose
 *   optimisation value is better than the values of all earlier ones.
 * <p>
 * The run happens in the {@link de.evoal.core.api.cdi.RunScoped} context, and the
 *   configured statistics writers receive the events of the run.
 */
@Dependent
@Slf4j
public class OptimisationRun {
    /**
     * Publishes the events of the run.
     */
    private final RunEventDispatcher events;

    /**
     * Creates the ids of the individuals.
     */
    private final IndividualIDGenerator idGenerator;

    /**
     * Provides the execution of the run.
     */
    private final ExecutionRecorder recorder;

    /**
     * Controls the context of the run.
     */
    private final RunScope scope;

    /**
     * The configured statistics writers.
     */
    private final StatisticsWriter statistics;

    /**
     * The best individual of the run so far and its optimisation value, {@code null}
     *   before the first iteration.
     */
    private IndividualRecord bestIndividual;
    private OptimisationValue bestValue;

    /**
     * The stubs of the members of the previous iteration. The relationships of the next
     *   iteration refer to them instead of the records, so a record never refers to an
     *   earlier iteration and the run keeps only the iterations it needs in memory.
     */
    private Map<Candidate, Individual> previousIndividuals = new IdentityHashMap<>();

    /**
     * Whether a listener of the run reads the steps of the iterations
     *   ({@link RunListener#readsSteps()}); otherwise the iterations have no steps.
     */
    private boolean withSteps;

    /**
     * @param events Publishes the events of the run.
     * @param idGenerator Creates the ids of the individuals.
     * @param recorder Provides the execution of the run.
     * @param scope Controls the context of the run.
     * @param statistics The configured statistics writers.
     */
    @Inject
    public OptimisationRun(final RunEventDispatcher events,
                           final IndividualIDGenerator idGenerator,
                           final ExecutionRecorder recorder,
                           final RunScope scope,
                           final @Component StatisticsWriter statistics) {
        this.events = events;
        this.idGenerator = idGenerator;
        this.recorder = recorder;
        this.scope = scope;
        this.statistics = statistics;
    }

    /**
     * Executes a run.
     *
     * @param criterion Decides after every iteration whether the run continues.
     * @param procedure The algorithm-specific part of the run.
     */
    public void execute(final TerminationCriterion criterion, final SearchProcedure procedure) {
        scope.start();

        try {
            bestIndividual = null;
            bestValue = null;
            previousIndividuals = new IdentityHashMap<>();

            final List<RunListener> listeners = List.of(new StatisticsWriterListener(statistics));
            withSteps = listeners.stream().anyMatch(RunListener::readsSteps);

            events.startRun(listeners);
            events.publish(new RunStarted(recorder.getExecution()));

            int number = 0;
            boolean withinBudget = true;
            Progress progress = Progress.CONTINUE;

            events.publish(new IterationStarted(number));
            try {
                procedure.initialise(events);
            } catch(final EvaluationBudgetExhaustedException e) {
                logExhaustedBudget(e, number);
                withinBudget = false;
            }
            Iteration iteration = finishIteration(number, procedure.population());

            while(withinBudget && progress == Progress.CONTINUE && criterion.shouldContinue(iteration)) {
                number += 1;

                events.publish(new IterationStarted(number));
                try {
                    progress = procedure.iterate(number);
                } catch(final EvaluationBudgetExhaustedException e) {
                    logExhaustedBudget(e, number);
                    withinBudget = false;
                }
                iteration = finishIteration(number, procedure.population());
            }

            if(bestIndividual != null) {
                log.info("Finished after iteration {}, best individual: {} -> {}.",
                         number, bestIndividual.getInput(), bestValue);
            }

            events.publish(new RunFinished(recorder.getExecution()));
        } finally {
            events.finishRun();
            scope.stop();
        }
    }

    /**
     * Creates the memory state of an iteration and publishes it: the executed steps with their
     *   outputs, if a listener reads them, and the ranked members ({@link IterationRecording}).
     *   The individuals have the same ids with and without the steps.
     *
     * @return The memory state.
     */
    private Iteration finishIteration(final int number, final Population population) {
        final IterationRecording recording = new IterationRecording(idGenerator, recorder, previousIndividuals);

        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(number);
        if(withSteps) {
            iteration.getSteps().addAll(recording.toSteps(population.steps()));
        } else {
            recording.numberSteps(population.steps());
        }

        final List<IterationRecording.Occurrence> members = recording.occurrencesOf(population.members());
        iteration.getRanks().addAll(recording.toRanks(members, population.ranks()));

        final Map<Candidate, Individual> individualsOfMembers = new IdentityHashMap<>();
        for(final IterationRecording.Occurrence occurrence : members) {
            final Candidate member = occurrence.candidate();
            final IndividualRecord individual = recording.inRanks(occurrence);

            // on an equal value, the earlier individual stays the best
            if(bestValue == null || member.value().isBetter(bestValue)) {
                bestIndividual = individual;
                bestValue = member.value();
            }

            individualsOfMembers.put(member, stubOf(individual, number));
        }
        iteration.setBestSoFar(bestIndividual);

        previousIndividuals = individualsOfMembers;

        events.publish(new IterationFinished(iteration));

        // the iteration is recorded: the members no longer need their predecessors, and
        // keeping them would keep every earlier candidate in memory
        members.forEach(occurrence -> occurrence.candidate().forgetPredecessors());

        return iteration;
    }

    /**
     * @return The stub of a record of the given iteration: the same id and values, shared
     *   input and output, a copy of the fitness, no relationships and no properties.
     */
    static IndividualStub stubOf(final IndividualRecord record, final int iteration) {
        final IndividualStub stub = MemoryFactory.eINSTANCE.createIndividualStub();
        stub.setId(record.getId());
        stub.setInput(record.getInput());
        stub.setOutput(record.getOutput());
        stub.getFitness().addAll(record.getFitness());
        stub.setIteration(iteration);

        return stub;
    }

    private static void logExhaustedBudget(final EvaluationBudgetExhaustedException exception, final int iteration) {
        log.info("{} Terminating optimisation in iteration {}.", exception.getMessage(), iteration);
    }
}
