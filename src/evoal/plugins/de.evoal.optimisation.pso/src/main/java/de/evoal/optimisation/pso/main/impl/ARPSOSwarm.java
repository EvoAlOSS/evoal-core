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
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.optimisation.pso.main.mover.ARPSOMover;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;
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

    @Inject
    @Named("search-space")
    private Space searchSpace;

    /**
     * The mover whose direction the swarm switches.
     */
    private ARPSOMover arpsoMover;

    /**
     * Checks the preconditions of ARPSO: the diversity is relative to the diagonal of the
     *   search space, so every variable needs a lower and an upper boundary, and only the
     *   {@code 'arpso-mover'} can switch between attraction and repulsion.
     *
     * @throws InitializationException if a precondition does not hold.
     */
    @Override
    public Swarm init(final EObject configuration) throws InitializationException {
        if(!(mover instanceof ARPSOMover arMover)) {
            throw new InitializationException("The 'arpso-swarm' requires the 'arpso-mover', but the mover is " + mover.getClass().getSimpleName() + ".");
        }
        arpsoMover = arMover;

        for(final EStructuralFeature feature : searchSpace) {
            if(!FeatureBoundaries.isBounded(feature)) {
                throw new InitializationException("The 'arpso-swarm' requires a lower and an upper boundary for every search variable, but '" + feature.getName() + "' has none.");
            }
        }

        return this;
    }

    /**
     * Sets whether the swarm is attracting or repelling, depending on the diversity of the
     *   swarm.
     */
    @Override
    public void adjust(final int iteration) {
        final double diversity = diversity(particles, diagonalLength(particles[0].getCurrentPosition().eSpace()));

        if (diversity < diversity_low && arpsoMover.getDirection() > 0) {
            arpsoMover.setDirection(-1);
            log.info("Repelling at iteration: {}", iteration);
        } else if (diversity > diversity_high && arpsoMover.getDirection() < 0) {
            arpsoMover.setDirection(1);
            log.info("Attracting at iteration: {}", iteration);
        }
    }

    /**
     * Moves the particles one after another.
     */
    @Override
    public void move(final int iteration) {
        for (int p = 0; p < particles.length; p++) {
            particles[p].moveParticle(getNeighbors(p), iteration);
        }
    }

    /**
     * @return The length of the diagonal of the search space, i.e., of the box given by the
     *   boundaries of the variables.
     */
    private double diagonalLength(final Space space) {
        double squaredLength = 0.;
        for (final EStructuralFeature feature : space) {
            final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);
            final double range = bounds.upper().doubleValue() - bounds.lower().doubleValue();
            squaredLength += range * range;
        }

        return Math.sqrt(squaredLength);
    }

    /**
     * Calculates the diversity of the swarm with the equation of Riget and Vesterstrom: the mean
     *   distance of the particles to their mean position, relative to the diagonal of the
     *   search space.
     *
     * @param particles The particles of the swarm.
     * @param diagonalLength The length of the diagonal of the search space.
     * @return The diversity of the swarm.
     */
    static double diversity(final Particle[] particles, final double diagonalLength) {
        final Space space = particles[0].getCurrentPosition().eSpace();

        //  Find average position
        final double[] averagePosition = new double[space.size()];
        int i = 0;
        for (final EStructuralFeature feature : space) {
            for (final Particle p : particles) {
                averagePosition[i] += p.getCurrentPosition().eGetAsDouble(feature);
            }
            averagePosition[i] /= particles.length;

            i += 1;
        }

        double diversity = 0.;
        for (final Particle p : particles) {
            double squaredDistance = 0.;
            int j = 0;
            for (final EStructuralFeature feature : space) {
                final double distance = p.getCurrentPosition().eGetAsDouble(feature) - averagePosition[j];
                squaredDistance += distance * distance;

                j += 1;
            }

            diversity += Math.sqrt(squaredDistance);
        }

        return diversity / (particles.length * diagonalLength);
    }
}
