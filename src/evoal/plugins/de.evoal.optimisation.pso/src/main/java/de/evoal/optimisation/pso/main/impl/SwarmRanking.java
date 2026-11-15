package de.evoal.optimisation.pso.main.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;

import de.evoal.optimisation.pso.api.swarm.Particle;

/**
 * Groups the individuals of a swarm's particles into the ranks of the memory
 *   model by the particles' current fitness. Rank 0 contains the particles with the best fitness, every
 *   following rank the particles with the next worse fitness. Particles with an
 *   equal fitness share a rank and keep their order in the swarm.
 */
public final class SwarmRanking {
    private SwarmRanking() {
    }

    private static Rank createRank(final int number) {
        final Rank rank = MemoryFactory.eINSTANCE.createRank();
        rank.setNumber(number);

        return rank;
    }

    /**
     * Creates the ranks of the particles' individuals.
     *
     * @param particles The particles of the swarm.
     * @param individuals The individuals of the particles' current states, by particle index.
     * @return The ranks, the best first.
     */
    public static List<Rank> toRanks(final Particle[] particles, final Individual[] individuals) {
        // greater optimisation values are better
        final Comparator<Integer> byFitness = Comparator.comparing(index -> particles[index].getCurrentFitness());
        final Comparator<Integer> bestFirstOrder = byFitness.reversed();
        final List<Integer> bestFirst = IntStream.range(0, particles.length)
                                                 .boxed()
                                                 .sorted(bestFirstOrder)
                                                 .toList();

        final List<Rank> ranks = new ArrayList<>();
        Rank rank = null;
        OptimisationValue previousFitness = null;

        for(final int index : bestFirst) {
            final OptimisationValue fitness = particles[index].getCurrentFitness();
            final boolean startsNewRank = previousFitness == null || fitness.isWorse(previousFitness);

            if(startsNewRank) {
                rank = createRank(ranks.size());
                ranks.add(rank);
            }

            rank.getMembers().add(individuals[index]);
            previousFitness = fitness;
        }

        return ranks;
    }
}
