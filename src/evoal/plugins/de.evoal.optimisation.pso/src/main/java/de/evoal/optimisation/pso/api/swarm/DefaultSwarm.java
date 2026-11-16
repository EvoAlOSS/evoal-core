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
import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.random.RandomGenerator;
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

    /**
     * Evaluates and counts the positions of the particles.
     */
    @Inject
    private EvaluationService evaluationService;

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
    public void move(final int generation) {
        IntStream.range(0, particles.length)
                 .parallel()
                 .forEach(i -> particles[i].moveParticle(getNeighbors(i), generation));
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
     * Evaluates the particles in the swarm, one after another in the order of the swarm.
     *   If the evaluation budget runs out, the particles that are not evaluated undo their
     *   last move.
     *
     * @throws EvaluationBudgetExhaustedException if the evaluation budget runs out.
     */
    @Override
    public void evaluate() {
        for(int index = 0; index < particles.length; ++index) {
            final Particle particle = particles[index];
            final TypedEObject candidate = particle.getCurrentPosition();

            final TypedEObject output;
            try {
                output = evaluationService.evaluate(candidate);
            } catch(final EvaluationBudgetExhaustedException e) {
                undoMoves(index);
                throw e;
            }

            final OptimisationValue ov = comparator.toValue(output);
            particle.setCurrentFitness(ov);

            if (ov.isBetter(particle.getBestFitness())) {
                particle.setBestPosition(particle.getCurrentPosition());
                particle.setBestFitness(particle.getCurrentFitness());
            }
        }
    }

    /**
     * Creates and evaluates the particles of the initial swarm, one after another. If the
     *   evaluation budget runs out, the swarm consists of the particles created so far.
     *
     * @throws EvaluationBudgetExhaustedException if the evaluation budget runs out.
     */
    @Override
    public void initialise() {
        log.info("Initializing swarm with {} members.", sizeOfPopulation);

        final Iterator<TypedEObject> candidates = ((Stream<TypedEObject>)provider.create())
                .limit(sizeOfPopulation)
                .iterator();
        final List<Particle> created = new ArrayList<>();

        try {
            while(candidates.hasNext()) {
                final TypedEObject candidate = candidates.next();
                final Particle particle = toParticle(created.size(), candidate);

                created.add(particle);
            }
        } finally {
            particles = created.toArray(Particle[]::new);
        }
    }

    /**
     * Evaluates a candidate and creates a particle at its position.
     *
     * @param id The id of the particle (its index in the swarm).
     * @param candidate The start position of the particle.
     * @return The new particle.
     */
    private Particle toParticle(final int id, final TypedEObject candidate) {
        final TypedEObject output = evaluationService.evaluate(candidate);
        final OptimisationValue ov = comparator.toValue(output);
        final State start = new State(candidate, ov);
        final RandomGenerator random = randomService.random("de.evoal.optimisation.pso/particle-" + id);

        return new Particle(id, start, mover, random);
    }

    /**
     * Undoes the last move of the particles from the given index on.
     *
     * @param firstIndex The index of the first particle whose move is undone.
     */
    private void undoMoves(final int firstIndex) {
        Arrays.stream(particles, firstIndex, particles.length)
              .forEach(Particle::undoMove);
    }
}
