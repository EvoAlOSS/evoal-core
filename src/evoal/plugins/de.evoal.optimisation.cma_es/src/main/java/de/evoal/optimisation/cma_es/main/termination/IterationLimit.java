package de.evoal.optimisation.cma_es.main.termination;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * The largest number of iterations of a CMA-ES run (DL type {@code 'iteration-limit'},
 *   attribute {@code 'maximum-iterations'} of {@code 'cma-es-termination'}). The limit is
 *   computed for every run with the population size of that run, as {@code cmaes.m} does
 *   with {@code MaxIter}; a run ends when its number of iterations reaches the limit.
 */
public interface IterationLimit extends EvoalComponent<IterationLimit> {
    /**
     * @param dimension The number of search features n.
     * @param populationSize The population size lambda of the run.
     * @return The limit L(n, lambda), possibly not an integer.
     */
    double of(int dimension, int populationSize);

    /**
     * @param dimension The number of search features n.
     * @param populationSize The population size lambda of the run.
     * @return The number of iterations after which the run ends: ceil(L(n, lambda)), at least
     *   1. An iteration count reaches a real limit exactly when it reaches its ceiling.
     */
    default long iterations(final int dimension, final int populationSize) {
        return Math.max(1L, (long) Math.ceil(of(dimension, populationSize)));
    }
}
