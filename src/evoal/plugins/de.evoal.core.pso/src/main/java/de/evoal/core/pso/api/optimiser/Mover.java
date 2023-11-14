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
package de.evoal.core.pso.api.optimiser;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.pso.api.swarm.Particle;
import de.evoal.core.pso.api.swarm.State;

/**
 * The mover calculates the new position of a particle in each generation.
 */
public interface Mover extends EvoalComponent<Mover> {
    /**
     * Moves the particle.
     *
     * @param current The current state (position and velocity) of the particle.
     * @param personalBest The best state ever achieved by the particle.
     * @param neighbors Neighbors of particle being moved.
     * @param currentIteration Current iteration.
     * @param maxIterations Max number of iterations.
     */
    public void moveParticle(final State current,
                             final State personalBest,
                             final Particle[] neighbors,
                             final int currentIteration,
                             final int maxIterations);
}
