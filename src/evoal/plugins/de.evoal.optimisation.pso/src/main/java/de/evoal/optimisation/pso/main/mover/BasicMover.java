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

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.random.RandomGenerator;

/**
 *  Basic PSO Mover, BasicMover
 *
 * @author Jeff Ridder
 */
@Named("de.evoal.core.pso.optimisation.basic-mover")
@Dependent
public class BasicMover implements Mover {
    @Inject
    private PropertiesBoundaries boundaries;

    @Inject
    private BoundaryType boundaryType;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.inertia-start")
    private double wstart;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.inertia-end")
    private double wend;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.c1")
    private double c1;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.c2")
    private double c2;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.maximise")
    private boolean maximise;

    @Override
    public BasicMover init(final Instance configuration) {
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
        final Properties neighborhoodBestPosition = Particle.getNeighborhoodBestPosition(neighbors, maximise);

        final Properties currentPosition = current.getPosition();
        final Double[] currentVelocity = current.getVelocity();

        final Properties personalBestPosition = personalBest.getPosition();

        final Properties nextPosition = new Properties(currentPosition);
        final Double[] nextVelocity = new Double[currentVelocity.length];

        for (int i = 0; i < currentVelocity.length; i++) {
            double x = currentPosition.getAsDouble(i);
            double v = currentVelocity[i];

            final PropertiesBoundaries.Boundaries bounds = boundaries.get(currentPosition.getSpecification().get(i));
            final double maximum = bounds.upper().doubleValue();
            final double minimum = bounds.lower().doubleValue();

            double max_v = maximum - minimum;

            double rand1 = RandomGenerator.getDefault().nextDouble();
            double rand2 = RandomGenerator.getDefault().nextDouble();

            double w = wstart + ((currentIteration + 1.) / (double) maxIterations) * (wend - wstart);
            double next_v = Math.max(-max_v, Math.min(max_v, w * v + c1 * rand1 * (personalBestPosition.getAsDouble(i) - x) +
                c2 * rand2 * (neighborhoodBestPosition.getAsDouble(i) - x)));

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

            nextPosition.set(i ,next_x); // TODO Cast to data type
            nextVelocity[i] = next_v;
        }
        current.setVelocity(nextVelocity);
        current.setPosition(nextPosition);
    }
}
