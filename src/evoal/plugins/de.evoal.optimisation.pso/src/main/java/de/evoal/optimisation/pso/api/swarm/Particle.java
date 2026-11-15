/* %%
 *
 * This code is based on JPSO (https://github.com/jpr86/JPSO), an Apache 2.0
 *   licensed software by Jeff Ridder.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.evoal.optimisation.pso.api.swarm;

import java.util.random.RandomGenerator;

import lombok.Getter;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

import de.evoal.optimisation.pso.api.optimiser.Mover;

/**
 * Class defining a particle - the basic unit of a swarm. A particle has a
 *   current state (position, velocity, fitness) and remembers the best state it
 *   has reached so far (personal best).
 * <p>
 * The swarm moves all particles in parallel. Moving a particle changes only
 *   its current state; the personal bests of all particles are changed only
 *   while the swarm is evaluated (sequentially). Therefore, the personal bests a
 *   particle reads from its neighbours do not change during a move, and the
 *   result does not depend on the thread scheduling.
 */
public class Particle {
    /**
     * The current state of the particle, changed by every move.
     */
    private final State current;

    /**
     * The particle's id (its index in the swarm).
     */
    private final int id;

    /**
     * Moves the particle.
     */
    @Getter
    private final Mover mover;

    /**
     * The best state the particle has reached so far. A state of its own, so
     *   that moving the particle does not change it.
     */
    private final State personalBest;

    /**
     * The particle's own random generator. Since particles are moved in parallel, a generator
     *   per particle keeps the results independent of the thread scheduling.
     */
    private final RandomGenerator random;

    /**
     * Creates a new particle. The start position is also its first personal best.
     *
     * @param id The ID number of the new particle.
     * @param current The start state of the particle.
     * @param mover Moves the particle.
     * @param random The particle's own random generator.
     */
    public Particle(final int id, final State current, final Mover mover, final RandomGenerator random) {
        this.id = id;
        this.current = current;

        final TypedEObject startPosition = new TypedEObject(current.getPosition());
        this.personalBest = new State(startPosition, current.getFitness());

        this.mover = mover;
        this.random = random;
    }

    /**
     * @return The best fitness the particle has reached so far.
     */
    public OptimisationValue getBestFitness() {
        return this.personalBest.getFitness();
    }

    /**
     * @return The position of the particle's personal best.
     */
    public TypedEObject getBestPosition() {
        return personalBest.getPosition();
    }

    /**
     * @return The personal best state ever achieved by the particle.
     */
    public State getBestState() {
        return personalBest;
    }

    /**
     * @return The current fitness of the particle.
     */
    public OptimisationValue getCurrentFitness() {
        return this.current.getFitness();
    }

    /**
     * @return The current position of the particle.
     */
    public TypedEObject getCurrentPosition() {
        return current.getPosition();
    }

    /**
     * @return The current state (position, velocity, fitness) of the particle.
     */
    public State getCurrentState() {
        return current;
    }

    /**
     * Returns the best position amongst the neighbours of the particle.
     *
     * @param particles The particles from which the best position is determined.
     * @return The personal best position of the best particle.
     */
    public static TypedEObject getNeighborhoodBestPosition(final Particle[] particles) {
        // initialise with first particle
        Particle best = particles[0];
        OptimisationValue bestFitness = best.getBestFitness();

        for (final Particle p : particles) {
            if (p.getBestFitness().isBetter(bestFitness)) {
                best = p;
                bestFitness = p.getBestFitness();
            }
        }

        //  return most fit particle's position
        return best.getBestPosition();
    }

    /**
     * Moves the particle with its mover. Changes only the current state.
     *
     * @param neighbors The neighbours of the particle.
     * @param current_iteration The current iteration.
     * @param max_iterations The maximum number of iterations.
     */
    public void moveParticle(final Particle[] neighbors, int current_iteration, int max_iterations) {
        mover.moveParticle(current, personalBest, neighbors,
            current_iteration, max_iterations, random);
    }

    /**
     * Sets the best fitness of the particle.
     *
     * @param bestFitness The best fitness.
     */
    public void setBestFitness(final OptimisationValue bestFitness) {
        this.personalBest.setFitness(bestFitness);
    }

    /**
     * Sets the best position of the particle. The position is copied, so later
     *   changes of the given object do not change the personal best.
     *
     * @param bestPosition The best position.
     */
    public void setBestPosition(final TypedEObject bestPosition) {
        final TypedEObject copy = new TypedEObject(bestPosition);
        this.personalBest.setPosition(copy);
    }

    /**
     * Sets the current fitness of the particle. Called by the swarm when it
     *   evaluates the particles.
     *
     * @param fitness The fitness of the current position.
     */
    public void setCurrentFitness(final OptimisationValue fitness) {
        current.setFitness(fitness);
    }

    /**
     * @return The current state of the particle as an individual of the memory model.
     */
    public Individual toIndividual() {
        final Individual result = MemoryFactory.eINSTANCE.createIndividual();

        result.setId(this.id);
        result.setInput(current.getPosition());
        result.setOutput(current.getFitness().toOptmisationSpace());

        return result;
    }
}
