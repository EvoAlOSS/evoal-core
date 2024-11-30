package de.evoal.optimisation.api.model;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Result of a single iteration of an optimisation algorithm.
 */
public interface Iteration {
    /**
     * The algorithm iteration number that led to this iteration. The value
     *   corresponds to the initial generation and any positive number
     *   means that the optimisation algorithm has been executed the
     *   number of times. .
     *
     * @return The current iteration number.
     */
    int iteration();

    /**
     * @return Stream of all candidates of the iteration. May be empty.
     */
    Stream<Candidate> candidates();

    /**
     * The number of candidates of this iteration if available.
     */
    Optional<Integer> candidateCount();

    /**
     * @return The best candidate of the iteration.
     */
    Candidate bestCandidate();
}
