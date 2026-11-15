package de.evoal.optimisation.pso.main.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;

import de.evoal.optimisation.pso.api.swarm.Particle;

/**
 * Groups the particles of a swarm into the ranks of the memory model by their
 *   current fitness. Rank 0 contains the particles with the best fitness, every
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
     * @return Whether the current fitness of the particle is worse than the one of the other particle.
     */
    private static boolean isWorse(final Particle particle, final Particle other) {
        final OptimisationValue fitness = particle.getCurrentFitness();
        final OptimisationValue otherFitness = other.getCurrentFitness();

        return fitness.isWorse(otherFitness);
    }

    /**
     * Creates the ranks of the particles.
     *
     * @param particles The particles of the swarm.
     * @return The ranks, the best first.
     */
    public static List<Rank> toRanks(final Particle[] particles) {
        // greater optimisation values are better
        final Comparator<Particle> byFitness = Comparator.comparing(Particle::getCurrentFitness);
        final Comparator<Particle> bestFirstOrder = byFitness.reversed();
        final List<Particle> bestFirst = Arrays.stream(particles)
                                               .sorted(bestFirstOrder)
                                               .toList();

        final List<Rank> ranks = new ArrayList<>();
        Rank rank = null;
        Particle previous = null;

        for(final Particle particle : bestFirst) {
            final boolean startsNewRank = previous == null || isWorse(particle, previous);

            if(startsNewRank) {
                rank = createRank(ranks.size());
                ranks.add(rank);
            }

            final Individual individual = particle.toIndividual();
            rank.getMembers().add(individual);
            previous = particle;
        }

        return ranks;
    }
}
