package de.evoal.optimisation.pso.main.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.pso.api.swarm.Particle;

/**
 * Groups the particles of a swarm into ranks by their current fitness. Rank 0 contains the
 *   particles with the best fitness, every following rank the particles with the next worse
 *   fitness. Particles with an equal fitness share a rank and keep their order in the swarm.
 */
public final class SwarmRanking {
    private SwarmRanking() {
    }

    /**
     * Creates the ranks of the particles.
     *
     * @param particles The particles of the swarm.
     * @return The particle indices of every rank, the best rank first.
     */
    public static List<List<Integer>> toRanks(final Particle[] particles) {
        // greater optimisation values are better
        final Comparator<Integer> byFitness = Comparator.comparing(index -> particles[index].getCurrentFitness());
        final Comparator<Integer> bestFirstOrder = byFitness.reversed();
        final List<Integer> bestFirst = IntStream.range(0, particles.length)
                                                 .boxed()
                                                 .sorted(bestFirstOrder)
                                                 .toList();

        final List<List<Integer>> ranks = new ArrayList<>();
        List<Integer> rank = null;
        OptimisationValue previousFitness = null;

        for(final int index : bestFirst) {
            final OptimisationValue fitness = particles[index].getCurrentFitness();
            final boolean startsNewRank = previousFitness == null || fitness.isWorse(previousFitness);

            if(startsNewRank) {
                rank = new ArrayList<>();
                ranks.add(rank);
            }

            rank.add(index);
            previousFitness = fitness;
        }

        return ranks;
    }
}
