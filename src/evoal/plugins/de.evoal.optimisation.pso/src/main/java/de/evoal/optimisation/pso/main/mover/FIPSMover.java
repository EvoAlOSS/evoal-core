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
package de.evoal.optimisation.pso.main.mover;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.BoundaryType;
import de.evoal.optimisation.pso.api.optimiser.Mover;
import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.random.RandomGenerator;

/**
 *  Fully informed particle swarm (FIPS) mover of Rui Mendes.
 *
 * @author Jeff Ridder
 */
@Slf4j
@Dependent  @Named("de.evoal.core.pso.optimisation.fips-mover")
public class FIPSMover implements Mover {
    @Inject
    private PropertiesBoundaries boundaries;

    @Inject
    private BoundaryType boundaryType;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.phi")
    private double phi;


    @Override
    public FIPSMover init(final Instance configuration) {
        return this;
    }

    /**
     * Moves the particle.
     * @param current The current state (position and velocity) of the particle.
     * @param personalBest The best state ever achieved by the particle.
     * @param neighbors The neighboring particles.
     * @param currentIteration Current iteration.
     * @param maxIterations Max number of iterations.
     */
    public void moveParticle(final State current,
                             final State personalBest,
                             final Particle[] neighbors,
                             final int currentIteration,
                             final int maxIterations)
    {
        final Properties currentPosition = current.getPosition();
        final Double[] currentVelocity = current.getVelocity();
        final Properties personalBestPosition = personalBest.getPosition();

        final Properties nextPosition = new Properties(currentPosition);
        final Double[] next_velocity = new Double[currentVelocity.length];

        double k = 2 / Math.abs(2. - phi - Math.sqrt(phi * phi - 4. * phi));

        for (int i = 0; i < currentPosition.size(); i++) {
            double x = currentPosition.getAsDouble(i);
            double v = currentVelocity[i];

            final PropertiesBoundaries.Boundaries bounds = boundaries.get(currentPosition.getSpecification().get(i));
            final double maximum = bounds.upper().doubleValue();
            final double minimum = bounds.lower().doubleValue();

            double max_v = maximum - minimum;

            double sum = 0.;
            for (Particle n : neighbors)
            {
                sum += RandomGenerator.getDefault().nextDouble() *
                    (n.getBestPosition().getAsDouble(i) - x);
            }

            sum *= phi / neighbors.length;

            double next_v = Math.max(-max_v, Math.min(max_v, k * (v + sum)));

            double next_x = x + next_v;

            if (next_x > maximum) {
                next_x = switch (boundaryType) {
                    case BOUNCE -> 2. * maximum - next_x;
                    case STICK  -> maximum;
                    case WRAP   ->  -max_v + next_x;
                };
            } else if (next_x < minimum) {
                next_x = switch (boundaryType) {
                    case BOUNCE -> 2. * minimum - next_x;
                    case STICK  -> minimum;
                    case WRAP   -> max_v + next_x;
                };
            }


            if (next_x < minimum || next_x > maximum)
            {
                log.error("Position {} value of {} is out of bounds [min,max]: [{}, {}].", i, next_x, minimum, maximum);
            }
            nextPosition.set(i, next_x);
            next_velocity[i] = next_v;
        }
        current.setVelocity(next_velocity);
        current.setPosition(nextPosition);
    }
}
