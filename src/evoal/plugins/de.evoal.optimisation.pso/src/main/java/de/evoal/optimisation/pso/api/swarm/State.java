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

import lombok.Getter;
import lombok.Setter;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.fitness.Evaluation;

/**
 * The state of a particle: a position, the velocity that resulted in the position, and the
 *   evaluation of the position.
 */
@Getter @Setter
public class State {
    /**
     * Evaluation of the position.
     */
    private Evaluation evaluation;

    /**
     * Current position.
     */
    private TypedEObject position;

    /**
     * Current velocity.
     */
    private Double[] velocity;

    /**
     * Creates a copy of a state. The copy shares the position and the velocity with the
     *   original, since the movers replace them instead of changing them.
     *
     * @param other The state to copy.
     */
    public State(final State other) {
        this.position = other.position;
        this.velocity = other.velocity;
        this.evaluation = other.evaluation;
    }

    public State(final TypedEObject position, final Evaluation evaluation) {
        this.position = position;
        this.evaluation = evaluation;

        this.velocity = new Double[position.eSpace().size()];
        for (int i = 0; i < velocity.length; i++) {
            this.velocity[i] = 0.;
        }
    }
}
