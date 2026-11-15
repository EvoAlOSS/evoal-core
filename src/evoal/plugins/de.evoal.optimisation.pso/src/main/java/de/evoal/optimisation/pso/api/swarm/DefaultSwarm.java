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

import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.optimiser.Mover;
import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.optimisation.pso.main.impl.NeighborhoodTopology;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
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
    private RandomService randomService;

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
            final TypedEObject candidate = particle.getCurrentPosition();
            final OptimisationValue ov = comparator.toValue(optimisationFunction.evaluate(candidate));

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

        particles = ((Stream<TypedEObject>)provider.create())
                .limit(sizeOfPopulation)
                .map(candidate -> {
                    final OptimisationValue ov = comparator.toValue(optimisationFunction.evaluate(candidate));
                    final int id = counter.getAndIncrement();
                    return new Particle(id, new State(candidate, ov), mover, randomService.random("de.evoal.optimisation.pso/particle-" + id));
                })
                .toArray(Particle[]::new);
    }
}
