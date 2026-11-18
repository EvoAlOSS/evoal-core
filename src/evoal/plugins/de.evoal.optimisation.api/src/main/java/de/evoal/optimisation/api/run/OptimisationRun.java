package de.evoal.optimisation.api.run;

import java.util.ArrayList;
import java.util.Arrays;
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
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.models.v202704.optimisation.memory.Relationship;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.events.IterationFinished;
import de.evoal.optimisation.api.events.IterationStarted;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.events.RunFinished;
import de.evoal.optimisation.api.events.RunStarted;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.Fitness;
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
 *   {@link SearchProcedure#population()} and publishes it. Every member becomes a new
 *   individual with the next id, related to the individuals of the previous iteration
 *   by its {@link Lineage}. A predecessor that is not a member of the previous iteration,
 *   but an unchanged copy of one ({@link Lineage.Kind#IDENTITY}), stands for its original.
 *   The best individual so far is the first individual whose
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
    private Individual bestIndividual;
    private OptimisationValue bestValue;

    /**
     * The individuals of the members of the previous iteration.
     */
    private Map<Candidate, Individual> previousIndividuals = new IdentityHashMap<>();

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

            events.startRun(List.of(new StatisticsWriterListener(statistics)));
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
     * Creates the memory state of an iteration and publishes it.
     *
     * @return The memory state.
     */
    private Iteration finishIteration(final int number, final Population population) {
        final Map<Candidate, Individual> individualsOfMembers = new IdentityHashMap<>();
        final List<Individual> individuals = new ArrayList<>();
        for(final Candidate member : population.members()) {
            final Individual individual = toIndividual(member);

            individuals.add(individual);
            individualsOfMembers.put(member, individual);
        }

        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(number);
        iteration.getRanks().addAll(toRanks(population.ranks(), individuals));
        iteration.getSteps().addAll(population.steps());
        iteration.setBestSoFar(bestIndividual);

        previousIndividuals = individualsOfMembers;

        events.publish(new IterationFinished(iteration));

        return iteration;
    }

    /**
     * @return The individual of the member with the next id, its objectives and fitness,
     *   related to its predecessors.
     */
    private Individual toIndividual(final Candidate member) {
        final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
        individual.setId(idGenerator.nextId());
        individual.setInput(member.input());
        individual.setOutput(member.output());

        final Fitness fitness = member.fitness();
        if(fitness != null) {
            Arrays.stream(fitness.values())
                  .forEach(individual.getFitness()::add);
        }

        // on an equal value, the earlier individual stays the best
        if(bestValue == null || member.value().isBetter(bestValue)) {
            bestIndividual = individual;
            bestValue = member.value();
        }

        final Lineage lineage = member.lineage();
        if(lineage.kind() != Lineage.Kind.NONE) {
            individual.getRelationships().add(toRelationship(lineage));
        }

        return individual;
    }

    /**
     * @return The ranks of the memory model.
     */
    private static List<Rank> toRanks(final List<List<Integer>> ranks, final List<Individual> individuals) {
        final List<Rank> result = new ArrayList<>();

        for(final List<Integer> indices : ranks) {
            final Rank rank = MemoryFactory.eINSTANCE.createRank();
            rank.setNumber(result.size());
            indices.forEach(index -> rank.getMembers().add(individuals.get(index)));

            result.add(rank);
        }

        return result;
    }

    /**
     * @return The relationship of the lineage to the individuals of the previous iteration.
     * @throws IllegalStateException if a predecessor does not belong to the previous iteration.
     */
    private Relationship toRelationship(final Lineage lineage) {
        final Relationship relationship = switch(lineage.kind()) {
            case IDENTITY -> MemoryFactory.eINSTANCE.createIdentity();
            case MUTATION -> MemoryFactory.eINSTANCE.createMutation();
            case RECOMBINATION -> MemoryFactory.eINSTANCE.createRecombination();
            case NONE -> throw new IllegalArgumentException("A lineage without predecessors has no relationship.");
        };

        for(final Candidate predecessor : lineage.predecessors()) {
            relationship.getTarget().add(individualOf(predecessor));
        }

        return relationship;
    }

    /**
     * @return The individual of the previous iteration that the candidate stands for: its own
     *   or, for an unchanged copy, the one of its original.
     * @throws IllegalStateException if the candidate does not belong to the previous iteration.
     */
    private Individual individualOf(final Candidate predecessor) {
        Candidate candidate = predecessor;

        while(!previousIndividuals.containsKey(candidate)) {
            if(candidate.lineage().kind() != Lineage.Kind.IDENTITY) {
                throw new IllegalStateException("The predecessor " + predecessor + " is not a member of the "
                                                + "previous iteration.");
            }

            candidate = candidate.lineage().predecessor();
        }

        return previousIndividuals.get(candidate);
    }

    private static void logExhaustedBudget(final EvaluationBudgetExhaustedException exception, final int iteration) {
        log.info("{} Terminating optimisation in iteration {}.", exception.getMessage(), iteration);
    }
}
