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

/**
 * A PSO swarm for different swarm implementations.
 */
public interface Swarm extends EvoalComponent<Swarm> {

    /**
     * @return The size of the swarm population.
     */
    public long size();

    /**
     * @return All particles of the swarm.
     */
    public Particle [] getParticles();

    /**
     * Executes the optimiser by simulating the swarm.
     */
    public void run();
}
