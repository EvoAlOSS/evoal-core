package de.evoal.optimisation.api.steps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import lombok.Getter;

import de.evoal.optimisation.api.run.Candidate;

/**
 * The state the steps of an algorithm work on:
 * <ul>
 *   <li>the <em>population</em>: the evaluated candidates the algorithm holds. The lineage
 *     of new candidates refers to the candidates they come from.</li>
 *   <li>the current <em>candidates</em>: what the steps of the iteration work on, e.g.,
 *     the selected parents, then their offspring.</li>
 *   <li>the <em>offered</em> candidates: candidates that are created only when a step asks
 *     for them, e.g., the neighbours of a local search, which are evaluated until one is
 *     accepted ({@link FitnessCalculation#untilAccepted}), and the <em>accepted</em>
 *     candidate.</li>
 *   <li>the <em>strategy state</em>: further values of the algorithm, e.g., the
 *     temperature or the velocities of the particles.</li>
 * </ul>
 */
public class SearchState {
    /**
     * The candidate a fitness calculation found acceptable in the current iteration,
     *   {@code null} if there is none.
     */
    private Candidate accepted;

    /**
     * The current candidates.
     */
    @Getter
    private List<Candidate> candidates = List.of();

    /**
     * The candidates offered in the current iteration, created when they are consumed.
     */
    private Stream<Candidate> offered = Stream.empty();

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
        this.offered = Stream.empty();
        this.accepted = null;
        this.stopped = false;
    }

    /**
     * @return The candidate a fitness calculation found acceptable in the current
     *   iteration, if there is one.
     */
    public Optional<Candidate> getAccepted() {
        return Optional.ofNullable(accepted);
    }

    /**
     * @return The offered candidates; they can be consumed once.
     */
    public Stream<Candidate> getOffered() {
        return offered;
    }

    /**
     * @param accepted The candidate that was found acceptable.
     */
    public void setAccepted(final Candidate accepted) {
        this.accepted = accepted;
    }

    /**
     * @param offered The candidates offered in the current iteration.
     */
    public void setOffered(final Stream<Candidate> offered) {
        this.offered = offered;
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
