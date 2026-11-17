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
import de.evoal.optimisation.api.fitness.Evaluation;

import de.evoal.optimisation.pso.api.optimiser.Mover;

/**
 * Class defining a particle - the basic unit of a swarm. A particle has a
 *   current state (position, velocity, evaluation) and remembers the best state it
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
     * The current state before the last move, {@code null} before the first move.
     */
    private State stateBeforeMove;

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
        this.personalBest = new State(startPosition, current.getEvaluation());

        this.mover = mover;
        this.random = random;
    }

    /**
     * @return The evaluation of the particle's personal best.
     */
    public Evaluation getBestEvaluation() {
        return this.personalBest.getEvaluation();
    }

    /**
     * @return The position of the particle's personal best.
     */
    public TypedEObject getBestPosition() {
        return personalBest.getPosition();
    }

    /**
     * @return The evaluation of the particle's current position.
     */
    public Evaluation getCurrentEvaluation() {
        return this.current.getEvaluation();
    }

    /**
     * @return The current position of the particle.
     */
    public TypedEObject getCurrentPosition() {
        return current.getPosition();
    }

    /**
     * @return The current state (position, velocity, evaluation) of the particle.
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
        OptimisationValue bestValue = best.getBestEvaluation().value();

        for (final Particle p : particles) {
            final OptimisationValue value = p.getBestEvaluation().value();

            if (value.isBetter(bestValue)) {
                best = p;
                bestValue = value;
            }
        }

        //  return most fit particle's position
        return best.getBestPosition();
    }

    /**
     * Moves the particle with its mover. Changes only the current state.
     *
     * @param neighbors The neighbours of the particle.
     * @param iteration The current iteration, starting at 1.
     */
    public void moveParticle(final Particle[] neighbors, final int iteration) {
        stateBeforeMove = new State(current);

        mover.moveParticle(current, personalBest, neighbors, iteration, random);
    }

    /**
     * Sets the evaluation of the particle's personal best.
     *
     * @param evaluation The evaluation of the personal best.
     */
    public void setBestEvaluation(final Evaluation evaluation) {
        this.personalBest.setEvaluation(evaluation);
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
     * Sets the evaluation of the particle's current position. Called by the swarm when it
     *   evaluates the particles.
     *
     * @param evaluation The evaluation of the current position.
     */
    public void setCurrentEvaluation(final Evaluation evaluation) {
        current.setEvaluation(evaluation);
    }

    /**
     * Undoes the last move, e.g., because the new position cannot be evaluated any more.
     *   The particle is back at its previous position with its previous velocity and evaluation.
     */
    public void undoMove() {
        if(stateBeforeMove == null) {
            throw new IllegalStateException("Particle " + id + " has not been moved yet.");
        }

        current.setPosition(stateBeforeMove.getPosition());
        current.setVelocity(stateBeforeMove.getVelocity());
        current.setEvaluation(stateBeforeMove.getEvaluation());
    }
}
