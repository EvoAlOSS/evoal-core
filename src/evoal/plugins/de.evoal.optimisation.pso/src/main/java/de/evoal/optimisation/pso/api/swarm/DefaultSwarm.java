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

import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.optimiser.Mover;
import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.optimisation.pso.main.impl.NeighborhoodTopology;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  A collection of particles.
 */
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.default-swarm")
@Slf4j
public class DefaultSwarm implements Swarm {
    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    @Inject
    private AttributeHelper helper;

    @Inject @Dependent @Component @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover")
    protected Mover mover;

    @Inject
    private NeighborhoodTopology neighborhoodTopology;

    @Inject @Dependent @Component
    private OptimisationFunction optimisationFunction;

    @Getter @Setter
    protected Particle[] particles;

    @Inject @Component
    private InitialCandidatesProvider provider;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.size-of-population")
    private int sizeOfPopulation;

    /**
     * Moves the particles in the swarm.
     */
    @Override
    public void move(final int generation, final int numberOfGenerations) {
        IntStream.range(0, particles.length)
                 .parallel()
                 .forEach(i -> particles[i].moveParticle(getNeighbors(i), generation, numberOfGenerations));
    }

    /**
     * Returns the neighboring particles.
     * @param pid ID of the particle for which neighbors are to be returned.
     * @return a Java array of particles.
     */
    protected Particle[] getNeighbors(int pid) {
        return Arrays.stream(neighborhoodTopology.getNeighborIDs(pid))
                     .map(i -> particles[i])
                     .toArray(Particle[]::new);
    }

    @Override
    public long size() {
        return particles.length;
    }

    @Override
    public Particle [] getParticles() {
        final Particle [] result = new Particle[particles.length];

        System.arraycopy(particles, 0, result, 0, particles.length);

        return result;
    }

    /**
     * Evaluates the particles in the swarm.
     */
    @Override
    public void evaluate() {
        for (Particle particle : particles) {
            final Properties candidate = particle.getCurrentPosition();
            final OptimisationValue ov = comparator.toValue(optimisationFunction.apply(candidate));

            particle.setCurrentFitness(ov);

            if (ov.isBetter(particle.getBestFitness())) {
                particle.setBestPosition(particle.getCurrentPosition());
                particle.setBestFitness(particle.getCurrentFitness());
            }
        }
    }

    @Override
    public void initialise() {
        log.info("Initializing swarm with {} members.", sizeOfPopulation);
        final AtomicInteger counter = new AtomicInteger();

        particles = ((Stream<Properties>)provider.create())
                .limit(sizeOfPopulation)
                .map(candidate -> {
                    final OptimisationValue ov = comparator.toValue(optimisationFunction.apply(candidate));
                    return new Particle(counter.getAndIncrement(), new State(candidate, ov), mover);
                })
                .toArray(Particle[]::new);
    }
}
