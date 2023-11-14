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

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.statistics.writer.StatisticsWriter;
import de.evoal.core.pso.api.optimiser.Mover;
import de.evoal.core.pso.api.optimiser.Swarm;
import de.evoal.core.pso.main.impl.NeighborhoodTopology;
import de.evoal.core.pso.main.statistics.PSOIterationResult;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 *  A collection of particles.
 */
@Dependent
@Named("default-swarm")
@Slf4j
public class DefaultSwarm implements Swarm {

    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    /**
     * Current generation.
     */
    protected int generation = 0;

    @Inject
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.maximise")
    private boolean maximise;

    @Inject @Dependent @Component @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover")
    protected Mover mover;

    @Inject
    private NeighborhoodTopology neighborhoodTopology;

    @Inject
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-generations")
    protected int numberOfGenerations;

    @Inject @Dependent @Component
    private OptimisationFunction optimisationFunction;

    protected Particle[] particles;

    @Inject @Component
    private InitialCandidatesProvider provider;

    @Inject
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.size-of-population")
    private int sizeOfPopulation;

    @Inject @Component
    private StatisticsWriter statistics;

    /**
     * Initializes the particles in the swarm. Randomly sets initial position and evaluates fitness of that position.
     */
    private void initializeParticles() {
        log.info("Initializing swarm with {} members.", sizeOfPopulation);
        final AtomicInteger counter = new AtomicInteger();

        particles = provider.create()
            .limit(sizeOfPopulation)
            .map(candidate -> {
                final OptimisationValue ov = comparator.toValue(optimisationFunction.apply(candidate));
                return new Particle(counter.getAndIncrement(), new State(candidate, ov), mover);
            })
            .toArray(Particle[]::new);
    }

    /**
     * Evaluates the particles in the swarm.
     */
    protected void evaluateParticles() {
        for (Particle particle : particles) {
            final Properties candidate = particle.getCurrentPosition();
            final OptimisationValue ov = comparator.toValue(optimisationFunction.apply(candidate));

            particle.setCurrentFitness(ov);

            if (ov.isBetter(particle.getBestFitness(), maximise)) {
                particle.setBestPosition(particle.getCurrentPosition());
                particle.setBestFitness(particle.getCurrentFitness());
            }
        }
    }

    /**
     * Iterates the swarm.
     */
    @Override
    public void run() {
        initializeParticles();
        logGeneration();

        while(generation < numberOfGenerations) {
            generation = generation + 1;

            log.info("Processing generation: {}", generation);

            moveParticles();
            evaluateParticles();
            logGeneration();
        }

        statistics.write();
    }

    private void logGeneration() {
        statistics.add(new PSOIterationResult(generation, maximise, this));
    }

    /**
     * Moves the particles in the swarm.
     */
    protected void moveParticles() {
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
        return sizeOfPopulation;
    }

    @Override
    public Particle [] getParticles() {
        final Particle [] result = new Particle[particles.length];

        System.arraycopy(particles, 0, result, 0, particles.length);

        return result;
    }
}
