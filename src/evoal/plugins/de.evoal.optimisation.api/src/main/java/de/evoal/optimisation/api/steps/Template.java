package de.evoal.optimisation.api.steps;

import java.util.ArrayList;
import java.util.List;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.memory.IterationStep;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep;

import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.events.StepExecuted;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Population;
import de.evoal.optimisation.api.run.Progress;
import de.evoal.optimisation.api.run.Ranking;
import de.evoal.optimisation.api.run.SearchProcedure;

/**
 * An algorithm as a composition of steps: the steps of the initialisation (iteration 0) and
 *   the steps of every further iteration. The run kernel executes the template.
 * <p>
 * After a step is executed, the template publishes a {@link StepExecuted} with the step's
 *   kind and description. The executed steps of an iteration become the steps of its
 *   memory state ({@link Population#steps()}).
 * <p>
 * The population of an iteration consists of the {@link #members()}, by default the
 *   population of the search state, ranked by the optimisation values. Afterwards, every member is replaced by a copy that is an
 *   identity of it ({@link Candidate#copy()}): a member that no step replaces is recorded as
 *   the same candidate in the next iteration, also if the next iteration is interrupted by
 *   an exhausted evaluation budget.
 */
public class Template implements SearchProcedure {
    /**
     * Publishes the executed steps; set by the kernel in {@link #initialise(RunEventDispatcher)}.
     */
    private RunEventDispatcher events;

    /**
     * The executed steps since the last population.
     */
    private final List<IterationStep> executedSteps = new ArrayList<>();

    /**
     * The steps of the initialisation.
     */
    private final List<Step> initialisation;

    /**
     * The steps of an iteration.
     */
    private final List<Step> iteration;

    /**
     * The state of the search.
     */
    private final SearchState state = new SearchState();

    /**
     * @param initialisation The steps of the initialisation.
     * @param iteration The steps of an iteration.
     */
    public Template(final List<Step> initialisation, final List<Step> iteration) {
        this.initialisation = List.copyOf(initialisation);
        this.iteration = List.copyOf(iteration);
    }

    private void execute(final List<Step> steps) {
        for(final Step step : steps) {
            step.execute(state);

            final IterationStep executed = toIterationStep(step);
            executedSteps.add(executed);
            events.publish(new StepExecuted(state.getIteration(), executed));
        }
    }

    @Override
    public void initialise(final RunEventDispatcher events) {
        this.events = events;
        state.startIteration(0);
        execute(initialisation);
    }

    @Override
    public Progress iterate(final int number) {
        state.startIteration(number);
        execute(iteration);

        return state.isStopped() ? Progress.STOP : Progress.CONTINUE;
    }

    /**
     * @return The members of the current population: by default, the population of the
     *   search state. Templates whose state lives elsewhere (e.g. the particles of a swarm)
     *   describe it here.
     */
    protected List<Candidate> members() {
        return state.getPopulation();
    }

    /**
     * @throws IllegalArgumentException if a member of the population is not evaluated.
     */
    @Override
    public Population population() {
        final List<Candidate> candidates = members();
        final List<OptimisationValue> values = candidates.stream()
                                                         .map(Candidate::value)
                                                         .toList();

        final Population population = new Population(candidates, Ranking.byValue(values), executedSteps);
        executedSteps.clear();

        // a member that stays in the population is the same candidate in the next iteration
        final List<Candidate> unchanged = candidates.stream()
                                                    .map(Candidate::copy)
                                                    .toList();
        state.setPopulation(unchanged);

        return population;
    }

    /**
     * @return The search state, e.g., for tests.
     */
    public SearchState state() {
        return state;
    }

    /**
     * @return The step for the memory model; its description is "kind: description".
     */
    private static IterationStep toIterationStep(final Step step) {
        final UnorderedIterationStep executed = MemoryFactory.eINSTANCE.createUnorderedIterationStep();
        executed.setDescription(step.kind() + ": " + step.description());

        return executed;
    }
}
