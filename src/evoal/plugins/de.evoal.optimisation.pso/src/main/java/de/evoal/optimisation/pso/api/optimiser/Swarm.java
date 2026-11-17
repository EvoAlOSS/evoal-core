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
package de.evoal.optimisation.pso.api.optimiser;

import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.optimisation.pso.api.swarm.Particle;

/**
 * A PSO swarm for different swarm implementations.
 */
public interface Swarm extends EvoalComponent<Swarm> {

    /**
     * Adjusts the parameters of the swarm before the particles move, e.g., the direction of
     *   ARPSO. Does nothing by default.
     *
     * @param generation The current generation, starting at 1.
     */
    default void adjust(final int generation) {
    }

    /**
     * Evaluates the current positions of all particles and sets their current fitness.
     */
    void evaluate();

    /**
     * @return All particles of the swarm.
     */
    public Particle[] getParticles();

    /**
     * Creates the initial population.
     */
    void initialise();

    /**
     * Moves the swarm.
     *
     * @param generation The current generation, starting at 1.
     */
    void move(final int generation);

    /**
     * Sets the particles of the swarm.
     *
     * @param particles The particles.
     */
    void setParticles(Particle[] particles);

    /**
     * @return The size of the swarm population.
     */
    public long size();

    /**
     * Updates the personal best of every particle with its current position and fitness, if
     *   the current fitness is better.
     */
    void updatePersonalBests();
}
