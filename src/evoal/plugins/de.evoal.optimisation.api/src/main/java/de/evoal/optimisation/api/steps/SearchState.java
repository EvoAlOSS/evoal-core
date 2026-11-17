package de.evoal.optimisation.api.steps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.Getter;

import de.evoal.optimisation.api.run.Candidate;

/**
 * The state the steps of an algorithm work on:
 * <ul>
 *   <li>the <em>population</em>: the evaluated candidates the algorithm holds. The lineage
 *     of new candidates refers to the candidates they come from.</li>
 *   <li>the current <em>candidates</em>: what the steps of the iteration work on, e.g.,
 *     the selected parents, then their offspring.</li>
 *   <li>the <em>strategy state</em>: further values of the algorithm, e.g., the
 *     temperature or the velocities of the particles.</li>
 * </ul>
 */
public class SearchState {
    /**
     * The current candidates.
     */
    @Getter
    private List<Candidate> candidates = List.of();

    /**
     * The number of the current iteration.
     */
    @Getter
    private int iteration;

    /**
     * The population.
     */
    @Getter
    private List<Candidate> population = List.of();

    /**
     * Whether a step decided that the search cannot continue.
     */
    @Getter
    private boolean stopped;

    /**
     * The strategy state.
     */
    private final Map<StateKey<?>, Object> strategy = new LinkedHashMap<>();

    /**
     * Starts an iteration.
     *
     * @param iteration The number of the iteration.
     */
    void startIteration(final int iteration) {
        this.iteration = iteration;
        this.candidates = List.of();
        this.stopped = false;
    }

    /**
     * @param candidates The new current candidates.
     */
    public void setCandidates(final List<Candidate> candidates) {
        this.candidates = List.copyOf(candidates);
    }

    /**
     * @param population The new population; all its candidates must be evaluated before the
     *   iteration ends.
     */
    public void setPopulation(final List<Candidate> population) {
        this.population = List.copyOf(population);
    }

    /**
     * Ends the search after the current iteration, e.g., because a local search found no
     *   acceptable neighbour.
     */
    public void stop() {
        stopped = true;
    }

    /**
     * @return The value of the strategy state, if there is one.
     */
    public <T> Optional<T> strategy(final StateKey<T> key) {
        return Optional.ofNullable(key.type().cast(strategy.get(key)));
    }

    /**
     * Sets a value of the strategy state.
     */
    public <T> void setStrategy(final StateKey<T> key, final T value) {
        strategy.put(key, value);
    }
}
