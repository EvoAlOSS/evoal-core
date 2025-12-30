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
import de.evoal.core.api.properties.info.PropertyBoundaries;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.BoundaryType;
import de.evoal.optimisation.pso.api.optimiser.Mover;
import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;
import de.evoal.languages.model.base.expressions.Instance;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.random.RandomGenerator;

/**
 *  Constriction Factor Mover, CFMover
 *
 * @author Jeff Ridder
 */
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.constriction-factor-mover")
public class CFMover implements Mover {
    @Inject
    private PropertiesBoundaries boundaries;

    @Inject
    private BoundaryType boundaryType;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.c1")
    private double c1;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.c2")
    private double c2;

    @Override
    public CFMover init(final Instance configuration) {
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
    @Override
    public void moveParticle(final State current,
                             final State personalBest,
                             final Particle[] neighbors,
                             final int currentIteration,
                             int maxIterations) {
        final Properties neighborhoodBestPosition = Particle.getNeighborhoodBestPosition(neighbors);

        final Properties currentPosition = current.getPosition();
        final Double[] currentVelocity = current.getVelocity();
        final Properties personalBestPosition = personalBest.getPosition();

        final Properties nextPosition = new Properties(currentPosition);
        Double[] next_velocity = new Double[currentVelocity.length];

        double phi = c1 + c2;

        double k = 2 / Math.abs(2. - phi - Math.sqrt(phi * phi - 4. * phi));

        for (int i = 0; i < currentPosition.size(); i++) {
            double x = currentPosition.getAsDouble(i);
            double v = currentVelocity[i];

            final PropertyBoundaries bounds = boundaries.get(currentPosition.getSpecification().get(i));
            final double maximum = bounds.upper().doubleValue();
            final double minimum = bounds.lower().doubleValue();

            double max_v = maximum - minimum;

            double next_v = Math.max(-max_v, Math.min(max_v, k * (v + c1 * RandomGenerator.getDefault().
                nextDouble() * (personalBestPosition.getAsDouble(i) - x) +
                c2 * RandomGenerator.getDefault().nextDouble() *
                (neighborhoodBestPosition.getAsDouble(i) - x))));

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

            nextPosition.set(i, next_x);
            next_velocity[i] = next_v;
        }
        current.setVelocity(next_velocity);
        current.setPosition(nextPosition);
    }
}
