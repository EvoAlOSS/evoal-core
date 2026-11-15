package de.evoal.optimisation.pso.main.impl;

import java.util.List;
import java.util.stream.IntStream;

import de.evoal.core.api.utils.TypedEObjects;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.memory.Identity;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Mutation;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.models.v202704.optimisation.memory.Relationship;
import de.evoal.optimisation.api.model.IndividualIDGenerator;

import de.evoal.optimisation.pso.api.swarm.Particle;

/**
 * Creates the memory states (iterations) of a swarm. The current position of
 *   every particle becomes an individual with a unique id. From the second
 *   iteration on, every individual refers to the individual of the same particle
 *   in the previous iteration: a {@link Mutation} if the particle moved, an
 *   {@link Identity} if its position is unchanged.
 * <p>
 * A particle is identified by its index in the swarm, so the swarm has to
 *   return its particles in the same order in every iteration.
 */
public class SwarmMemory {
    /**
     * Creates the ids of the individuals.
     */
    private final IndividualIDGenerator idGenerator;

    /**
     * The individuals of the previous iteration, by particle index. Empty
     *   before the first iteration.
     */
    private Individual[] previousIndividuals = new Individual[0];

    /**
     * @param idGenerator Creates the ids of the individuals.
     */
    public SwarmMemory(final IndividualIDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    /**
     * Creates the individual of a particle's current state and relates it to
     *   the particle's individual of the previous iteration.
     */
    private Individual toIndividual(final int particleIndex, final Particle particle) {
        final TypedEObject position = particle.getCurrentPosition();
        final OptimisationValue fitness = particle.getCurrentFitness();
        final TypedEObject output = fitness.toOptmisationSpace();

        final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
        individual.setId(idGenerator.nextId());
        individual.setInput(position);
        individual.setOutput(output);

        final boolean hasPredecessor = particleIndex < previousIndividuals.length;
        if(hasPredecessor) {
            final Individual predecessor = previousIndividuals[particleIndex];
            final Relationship relationship = toRelationship(predecessor, individual);

            individual.getRelationships().add(relationship);
        }

        return individual;
    }

    /**
     * Creates the memory state of an iteration and remembers its individuals
     *   as predecessors of the next iteration.
     *
     * @param number The number of the iteration (0 for the initial swarm).
     * @param particles The particles of the swarm, in the same order in every iteration.
     * @return The memory state of the iteration.
     */
    public Iteration toIteration(final int number, final Particle[] particles) {
        final Individual[] individuals = IntStream.range(0, particles.length)
                                                  .mapToObj(index -> toIndividual(index, particles[index]))
                                                  .toArray(Individual[]::new);
        final List<Rank> ranks = SwarmRanking.toRanks(particles, individuals);

        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(number);
        iteration.getRanks().addAll(ranks);

        previousIndividuals = individuals;

        return iteration;
    }

    /**
     * @return A {@link Mutation} if the position changed, otherwise an {@link Identity}.
     */
    private static Relationship toRelationship(final Individual predecessor, final Individual individual) {
        final TypedEObject previousPosition = predecessor.getInput();
        final TypedEObject position = individual.getInput();
        final boolean moved = !TypedEObjects.haveSameValues(previousPosition, position);

        final Relationship relationship = moved ? MemoryFactory.eINSTANCE.createMutation()
                                                : MemoryFactory.eINSTANCE.createIdentity();
        relationship.getTarget().add(predecessor);

        return relationship;
    }
}
