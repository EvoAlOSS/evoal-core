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
package de.evoal.core.pso.main.impl;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.pso.api.swarm.Particle;
import de.evoal.core.pso.api.swarm.DefaultSwarm;
import de.evoal.core.pso.main.mover.ARPSOMover;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *  Implements the diversity enhanced particle movement scheme of Riget and Vesterstrom.
 *
 * @author Jeff Ridder
 */
@Dependent
@Named("de.evoal.core.pso.optimisation.arpso-swarm")
@Slf4j
public class ARPSOSwarm extends DefaultSwarm {
    @Inject
    private PropertiesBoundaries boundaries;

    @Inject
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.swarm.diversity-low")
    private double diversity_low;

    @Inject
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.swarm.diversity-high")
    private double diversity_high;

    /**
     * Moves the particles by first considering the swarm diversity in order to set whether the swarm is attracting or repelling.
     */
    protected void moveParticles() {
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
            particles[p].moveParticle(getNeighbors(p), generation, numberOfGenerations);
        }
    }

    /**
     * Returns the diversity factor of the swarm.  This is calculated using the equation of Riget and Vesterstrom.
     * @param particles The particles in the swarm.
     * @return the diversity of the swarm.
     */
    protected double getDiversity(final Particle[] particles) {
        int pos_length = particles[0].getCurrentPosition().size();

        //  Find average position
        Double[] ave_position = new Double[pos_length];
        for (int i = 0; i < pos_length; i++)
        {
            ave_position[i] = 0.;
            for (Particle p : particles)
            {
                ave_position[i] += p.getCurrentPosition().getAsDouble(i);
            }

            ave_position[i] /= particles.length;
        }

        //  Find max diagonal in search space
//        ValueLimitSet vLim = particles[0].getValueLimitSet();
        double diag_length = 0.;
        /*
        for (int i = 0; i < vLim.getSize(); i++) {
            PropertiesBoundaries.Boundaries bounds =
            double diff = vLim.getValueLimits(i).getMaximum() - vLim.getValueLimits(i).
                getMinimum();

            diag_length += diff * diff;
        }
        */if(true)
        throw new RuntimeException();

        diag_length = Math.sqrt(diag_length);

        double diversity = 0.;
        for (Particle p : particles)
        {
            double variance = 0.;
            for (int i = 0; i < pos_length; i++)
            {
                variance +=
                    Math.pow(p.getCurrentPosition().getAsDouble(i) - ave_position[i], 2);
            }

            diversity += Math.sqrt(variance);
        }

        diversity /= (particles.length * diag_length);

        return diversity;
    }
}
