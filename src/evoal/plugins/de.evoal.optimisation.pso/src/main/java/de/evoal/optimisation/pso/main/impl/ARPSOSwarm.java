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
package de.evoal.optimisation.pso.main.impl;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.DefaultSwarm;
import de.evoal.optimisation.pso.main.mover.ARPSOMover;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 *  Implements the diversity enhanced particle movement scheme of Riget and Vesterstrom.
 *
 * @author Jeff Ridder
 */
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.arpso-swarm")
@Slf4j
public class ARPSOSwarm extends DefaultSwarm {
    @Inject
    private FeatureBoundaries boundaries;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.swarm.diversity-low")
    private double diversity_low;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.swarm.diversity-high")
    private double diversity_high;

    /**
     * Moves the particles by first considering the swarm diversity in order to set whether the swarm is attracting or repelling.
     */
    @Override
    public void move(final int generation) {
        if(mover instanceof ARPSOMover arMover) {
            //  Assess diversity and set direction on the mover
            double diversity = this.getDiversity(particles);

            if (diversity < diversity_low && arMover.getDirection() > 0) {
                //  tell the ARPSOMover to set direction = -1;
                arMover.setDirection(-1);
                log.info("Repelling at iteration: {}", generation);
            } else if (diversity > diversity_high && arMover.getDirection() < 0) {
                //  tell the ARPSOMover to set direction = 1;
                arMover.setDirection(1);
                log.info("Attracting at iteration: {}", generation);
            }
        }

        for (int p = 0; p < particles.length; p++) {
            particles[p].moveParticle(getNeighbors(p), generation);
        }
    }

    /**
     * Returns the diversity factor of the swarm.  This is calculated using the equation of Riget and Vesterstrom.
     * @param particles The particles in the swarm.
     * @return the diversity of the swarm.
     */
    protected double getDiversity(final Particle[] particles) {
        final Space space  = particles[0].getCurrentPosition().eSpace();
        final int pos_length = space.size();

        //  Find average position
        Double[] ave_position = new Double[pos_length];
        int i = 0;
        for (final EStructuralFeature feature : space)
        {
            ave_position[i] = 0.;
            for (Particle p : particles)
            {
                ave_position[i] += p.getCurrentPosition().eGetAsDouble(feature);
            }

            ave_position[i] /= particles.length;

            i += 1;
        }

        //  Find max diagonal in search space
        TypedEObject properties = particles[0].getCurrentPosition();
        double diag_length = 0.;


        for (final EStructuralFeature feature : properties.eSpace()) {
            FeatureBoundaries.Boundaries bounds = boundaries.get(feature);
            double maximum = bounds.upper().doubleValue();
            double minimum = bounds.lower().doubleValue();
            double diff = maximum - minimum;
            diag_length += diff * diff;
        }

        diag_length = Math.sqrt(diag_length);

        double diversity = 0.;
        for (Particle p : particles)
        {
            double variance = 0.;
            i = 0;
            for (final EStructuralFeature feature : space)
            {
                final double distance = p.getCurrentPosition().eGetAsDouble(feature) - ave_position[i];
                variance += distance * distance;
            }

            diversity += Math.sqrt(variance);

            i += 1;
        }

        diversity /= (particles.length * diag_length);

        return diversity;
    }
}
