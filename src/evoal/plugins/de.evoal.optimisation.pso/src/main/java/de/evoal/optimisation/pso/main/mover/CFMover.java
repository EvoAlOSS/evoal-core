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
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.BoundaryType;
import de.evoal.optimisation.pso.api.optimiser.Mover;
import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;
import de.evoal.languages.model.base.expressions.Instance;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.random.RandomGenerator;
import de.evoal.core.api.math.EvoalMath;

/**
 *  Constriction Factor Mover, CFMover
 *
 * @author Jeff Ridder
 */
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.constriction-factor-mover")
public class CFMover implements Mover {
    @Inject
    private FeatureBoundaries boundaries;

    @Inject
    private BoundaryType boundaryType;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.c1")
    private double c1;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover.c2")
    private double c2;

    /**
     * Moves the particle.
     * @param current The current state (position and velocity) of the particle.
     * @param personalBest The best state ever achieved by the particle.
     * @param neighbors The neighboring particles.
     * @param iteration The current iteration, starting at 1.
     */
    @Override
    public void moveParticle(final State current,
                             final State personalBest,
                             final Particle[] neighbors,
                             final int iteration,
                             final RandomGenerator random) {
        final TypedEObject neighborhoodBestPosition = Particle.getNeighborhoodBestPosition(neighbors);

        final TypedEObject currentPosition = current.getPosition();
        final Double[] currentVelocity = current.getVelocity();
        final TypedEObject personalBestPosition = personalBest.getPosition();

        final TypedEObject nextPosition = new TypedEObject(currentPosition);
        Double[] next_velocity = new Double[currentVelocity.length];

        double phi = c1 + c2;

        double k = 2 / Math.abs(2. - phi - Math.sqrt(EvoalMath.square(phi) - 4. * phi));

        int i = 0;
        for(final EStructuralFeature feature : currentPosition.eSpace()) {
            double x = currentPosition.eGetAsDouble(feature);
            double v = currentVelocity[i];

            final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);
            final double maximum = bounds.upper().doubleValue();
            final double minimum = bounds.lower().doubleValue();

            double max_v = maximum - minimum;

            double next_v = Math.max(-max_v, Math.min(max_v, k * (v + c1 * random.
                nextDouble() * (personalBestPosition.eGetAsDouble(feature) - x) +
                c2 * random.nextDouble() *
                (neighborhoodBestPosition.eGetAsDouble(feature) - x))));

            final BoundaryHandling.Moved moved = BoundaryHandling.apply(boundaryType, x + next_v, next_v, minimum, maximum);
            nextPosition.eSet(feature, moved.position());
            next_velocity[i] = moved.velocity();

            i += 1;
        }
        current.setVelocity(next_velocity);
        current.setPosition(nextPosition);
    }
}
