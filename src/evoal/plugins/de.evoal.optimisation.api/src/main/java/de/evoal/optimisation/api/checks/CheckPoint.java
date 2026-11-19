package de.evoal.optimisation.api.checks;

/**
 * Where in an iteration a {@link CandidateCheck} tests the candidates.
 */
public enum CheckPoint {
    /**
     * After the variation and before the evaluation: the check tests the new candidates, so a
     *   failed candidate costs no evaluation ({@link CheckNewCandidates}). Algorithms with an
     *   initial population also test the initial candidates before their evaluation.
     */
    NEW_CANDIDATES,

    /**
     * At the end of every iteration: the check tests the population that the iteration
     *   leaves ({@link CheckPopulation}).
     */
    POPULATION
}
