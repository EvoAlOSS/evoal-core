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

import de.evoal.optimisation.api.model.Candidate;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.pso.api.optimiser.Mover;
import lombok.Getter;

/**
 * Class defining a particle - the basic unit of a swarm.
 */
public class Particle {
    private final int id;

    @Getter
    private final Mover mover;

    private final State current;

    private final State personalBest;

    /**
     * Creates a new instance of Particle.
     * @param id The ID number of the new particle.
     */
    public Particle(final int id, final State current, final Mover mover) {
        this.id = id;
        this.current = current;
        this.personalBest = current;

        this.mover = mover;
    }

    /**
     * Returns the current state (position, velocity, malus) of the particle.
     * @return current state.
     */
    public State getCurrentState()
    {
        return current;
    }

    /**
     * Returns the personal best state ever achieved by the particle.
     * @return personal best state.
     */
    public State getBestState()
    {
        return personalBest;
    }

    /**
     * Returns the current position vector of the particle.
     * @return current position vector.
     */
    public Properties getCurrentPosition()
    {
        return current.getPosition();
    }

    /**
     * Sets the current malus of the particle.  This should be called only by an
     * IEvaluator object.
     * @param fitness The malus of the particle.
     */
    public void setCurrentFitness(final OptimisationValue fitness)
    {
        current.setFitness(fitness);
    }

    /**
     * Returns the current malus of the particle.
     * @return current malus.
     */
    public OptimisationValue getCurrentFitness()
    {
        return this.current.getFitness();
    }

    /**
     * Sets the best position of the particle.
     * @param bestPosition position vector.
     */
    public void setBestPosition(final Properties bestPosition)
    {
        this.personalBest.setPosition(bestPosition);
    }

    /**
     * Returns the best position of the particle.
     * @return position vector.
     */
    public Properties getBestPosition()
    {
        return personalBest.getPosition();
    }

    /**
     * Sets the best malus of the particle.
     * @param bestFitness best malus.
     */
    public void setBestFitness(final OptimisationValue bestFitness)
    {
        this.personalBest.setFitness(bestFitness);
    }

    /**
     * Returns the best malus of the particle.
     * @return best malus.
     */
    public OptimisationValue getBestFitness()
    {
        return this.personalBest.getFitness();
    }

    /**
     * Calls the moveParticle method of the particle's IMover.
     * @param neighbors Java array of my neighbors.
     * @param current_iteration current iteration.
     * @param max_iterations max number of iterations.
     */
    public void moveParticle(final Particle[] neighbors, int current_iteration, int max_iterations) {
        mover.moveParticle(current, personalBest, neighbors,
            current_iteration, max_iterations);
    }

    /**
     * Returns the best position amongst the neighors of the particle.
     *
     * @param particles Java array of particles from which best position is to be determined.
     * @return position vector.
     */
    public static Properties getNeighborhoodBestPosition(final Particle[] particles, final boolean maximise) {
        // initialise with first particle
        Particle best = particles[0];
        OptimisationValue bestFitness = best.getBestFitness();

        for (final Particle p : particles) {
            if (p.getBestFitness().isBetter(bestFitness, maximise)) {
                best = p;
                bestFitness = p.getBestFitness();
            }
        }

        //  return most fit particle's position
        return best.getBestPosition();
    }

    public Candidate toCandidate() {
        return new Candidate() {
            private final Properties candidate = current.getPosition();
            private final OptimisationValue value = current.getFitness();

            @Override
            public Properties searchSpaceRepresentation() {
                return candidate;
            }

            @Override
            public OptimisationValue value() {
                return value;
            }
        };
    }
}
