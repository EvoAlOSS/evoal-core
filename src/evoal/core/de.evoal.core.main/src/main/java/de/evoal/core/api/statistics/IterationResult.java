package de.evoal.core.api.statistics;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Result of a single iteration of an optimisation
 */
public interface IterationResult {
    /**
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
