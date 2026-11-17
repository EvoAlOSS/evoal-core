package de.evoal.optimisation.pso.main.impl;

import java.util.ArrayList;
import java.util.List;

import de.evoal.core.api.utils.TypedEObjects;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.run.Population;

import de.evoal.optimisation.pso.api.swarm.Particle;

/**
 * Describes the particles of a swarm as population of the run kernel. Every particle is a
 *   member, its index in the swarm is its index in the population. From the second
 *   population on, every member refers to the member of the same particle in the
 *   previous population: a mutation if the particle moved, an identity if its position
 *   has the same values.
 * <p>
 * The swarm has to return its particles in the same order in every iteration.
 */
public class SwarmPopulation {
    /**
     * The members of the previous population, by particle index; empty before the first one.
     */
    private List<Candidate> previous = List.of();

    /**
     * @return A mutation if the position changed, otherwise an identity.
     */
    private Lineage lineageOf(final int particleIndex, final TypedEObject position) {
        final boolean hasPredecessor = particleIndex < previous.size();
        if(!hasPredecessor) {
            return Lineage.NONE;
        }

        final Candidate predecessor = previous.get(particleIndex);
        final boolean moved = !TypedEObjects.haveSameValues(predecessor.input(), position);

        return moved ? Lineage.mutation(predecessor) : Lineage.identity(predecessor);
    }

    /**
     * Creates the population of the particles' current states and remembers their
     *   positions for the next population.
     *
     * @param particles The particles of the swarm, in the same order in every iteration.
     * @return The population, ranked by the particles' current fitness.
     */
    public Population toPopulation(final Particle[] particles) {
        final List<Candidate> members = new ArrayList<>();

        for(int index = 0; index < particles.length; ++index) {
            final Particle particle = particles[index];
            final TypedEObject position = particle.getCurrentPosition();
            final OptimisationValue fitness = particle.getCurrentFitness();
            final TypedEObject output = fitness.toOptmisationSpace();

            members.add(Candidate.evaluated(position, output, fitness, lineageOf(index, position)));
        }

        previous = members;

        return new Population(members, SwarmRanking.toRanks(particles));
    }
}
