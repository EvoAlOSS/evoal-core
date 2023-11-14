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
package de.evoal.core.pso.api.swarm;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import lombok.Getter;
import lombok.Setter;

/**
 *  Describes the state of the particle. The State is the current position,
 *  velocity that resulted in the position, and fitness of the particle at that
 *  position.
 */
@Getter @Setter
public class State {
    /**
     * Current position.
     */
    private Properties position;

    /**
     * Current velocity.
     */
    private Double[] velocity;

    /**
     * Current fitness.
     */
    private OptimisationValue fitness;

    public State(final Properties position, final OptimisationValue fitness) {
        this.position = position;
        this.fitness = fitness;

        this.velocity = new Double[position.size()];
        for (int i = 0; i < velocity.length; i++) {
            this.velocity[i] = 0.;
        }
    }
}
