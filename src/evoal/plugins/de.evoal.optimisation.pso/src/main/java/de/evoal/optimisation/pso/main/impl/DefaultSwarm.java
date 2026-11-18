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

import de.evoal.core.api.ecore.misc.ConcurrentEClassAccess;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.pso.api.optimiser.Mover;
import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.optimisation.pso.api.swarm.Particle;
import de.evoal.optimisation.pso.api.swarm.State;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.evaluation.EvaluationExecutor;
import de.evoal.optimisation.api.fitness.BatchEvaluation;
import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Evaluator;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.random.RandomGenerator;

/**
 * The swarm of the basic particle swarm optimisation (DL type {@code 'default-swarm'}): a
 *   fixed number of particles that move in parallel, each towards its personal best and the
 *   best of its neighbourhood ({@link NeighborhoodTopology}), and are evaluated in parallel
 *   if the optimisation function allows it. Both use the threads of the run
 *   ({@link EvaluationExecutor}); since every particle draws from its own random stream and
 *   the evaluations from their task streams, the results do not depend on the threads.
 */
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.default-swarm")
@Slf4j
public class DefaultSwarm implements Swarm {
    @Inject
    private AttributeHelper helper;

    @Inject @Dependent @Component @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.mover")
    protected Mover mover;

    @Inject
    private NeighborhoodTopology neighborhoodTopology;

    /**
     * Evaluates the positions of the particles.
     */
    @Inject
    private Evaluator evaluator;

    @Getter @Setter
    protected Particle[] particles;

    @Inject @Component
    private InitialCandidatesProvider provider;

    @Inject
    private RandomService randomService;

    /**
     * The threads of the run.
     */
    @Inject
    private EvaluationExecutor executor;

    /**
     * Whether the class of the positions has been prepared for the moves on several threads.
     */
    private boolean preparedForThreads;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.size-of-population")
    private int sizeOfPopulation;

    /**
     * Moves the particles in the swarm, in parallel on the threads of the run.
     */
    @Override
    public void move(final int iteration) {
        if(!preparedForThreads && particles.length > 0) {
            ConcurrentEClassAccess.prepare(particles[0].getCurrentPosition().eClass());
            preparedForThreads = true;
        }

        final List<Callable<Void>> moves = new ArrayList<>(particles.length);
        for(int i = 0; i < particles.length; ++i) {
            final int index = i;

            moves.add(() -> {
                particles[index].moveParticle(getNeighbors(index), iteration);
                return null;
            });
        }

        executor.invokeAll(moves);
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
    public Particle [] getParticles() {
        final Particle [] result = new Particle[particles.length];

        System.arraycopy(particles, 0, result, 0, particles.length);

        return result;
    }

    /**
     * Evaluates the particles in the swarm as one batch and sets their current evaluation. If
     *   the evaluation budget runs out, the first particles that it covers keep their
     *   evaluation and the others undo their last move, as in a sequential evaluation.
     *
     * @throws de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException if the
     *   evaluation budget runs out.
     */
    @Override
    public void evaluate() {
        final List<TypedEObject> positions = Arrays.stream(particles)
                                                   .map(Particle::getCurrentPosition)
                                                   .toList();

        final BatchEvaluation batch = evaluator.evaluateAll(positions);
        final List<Evaluation> evaluations = batch.evaluations();
        for(int index = 0; index < evaluations.size(); ++index) {
            particles[index].setCurrentEvaluation(evaluations.get(index));
        }

        if(batch.isExhausted()) {
            undoMoves(evaluations.size());
            batch.rethrowExhaustion();
        }
    }

    @Override
    public void updatePersonalBests() {
        for(final Particle particle : particles) {
            final Evaluation current = particle.getCurrentEvaluation();
            final Evaluation best = particle.getBestEvaluation();

            if (current.value().isBetter(best.value())) {
                particle.setBestPosition(particle.getCurrentPosition());
                particle.setBestEvaluation(current);
            }
        }
    }

    /**
     * Creates the start positions of the initial swarm, evaluates them as one batch and
     *   creates a particle per evaluated position. If the evaluation budget runs out, the swarm
     *   consists of the particles of the first positions that it covers.
     *
     * @throws de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException if the
     *   evaluation budget runs out.
     */
    @Override
    public void initialise() {
        log.info("Initializing swarm with {} members.", sizeOfPopulation);

        final List<TypedEObject> positions = provider.create()
                                                     .limit(sizeOfPopulation)
                                                     .toList();

        final BatchEvaluation batch = evaluator.evaluateAll(positions);
        final List<Evaluation> evaluations = batch.evaluations();
        final List<Particle> created = new ArrayList<>(evaluations.size());
        for(int id = 0; id < evaluations.size(); ++id) {
            created.add(toParticle(id, positions.get(id), evaluations.get(id)));
        }
        particles = created.toArray(Particle[]::new);

        batch.rethrowExhaustion();
    }

    /**
     * Creates a particle at an evaluated position.
     *
     * @param id The id of the particle (its index in the swarm).
     * @param candidate The start position of the particle.
     * @param evaluation The evaluation of the start position.
     * @return The new particle.
     */
    private Particle toParticle(final int id, final TypedEObject candidate, final Evaluation evaluation) {
        final State start = new State(candidate, evaluation);
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
