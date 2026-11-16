package de.evoal.optimisation.pso.main.impl;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.model.*;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.pso.api.swarm.Particle;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

import java.util.*;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.particle-swarm-optimisation")
public class ParticleSwarmAlgorithm implements OptimisationAlgorithm {

    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    private TerminationCriterion criterion;

    @Inject
    private AttributeHelper helper;

    /**
     * Creates the ids of the individuals in the memory model.
     */
    @Inject
    private IndividualIDGenerator idGenerator;

    /**
     * Records the metrics of the iterations.
     */
    @Inject
    private ExecutionRecorder executionRecorder;

    @Inject
    private TerminationCriterionProducer producer;

    @Inject @Component
    private StatisticsWriter statistics;

    /**
     * The used swarm implementation
     */
    private Swarm swarm;

    @Override
    public OptimisationAlgorithm init(final EObject configuration) {
        swarm = BeanFactory.createComponent(Swarm.class, helper.lookup(configuration, "swarm"));
        criterion = producer.create(configuration);

        return this;
    }

    /**
     * Runs an evaluation step of the swarm.
     *
     * @param step Initialises or evaluates the swarm.
     * @return {@code false} if the evaluation budget ran out during the step.
     */
    private static boolean evaluateWithinBudget(final Runnable step) {
        try {
            step.run();

            return true;
        } catch(final EvaluationBudgetExhaustedException e) {
            log.info("{} Terminating optimisation.", e.getMessage());

            return false;
        }
    }

    @Override
    public void run() {
        int generation = 0;
        boolean withinBudget = evaluateWithinBudget(swarm::initialise);

        final SwarmMemory memory = new SwarmMemory(idGenerator);
        Iteration snapshot = toIteration(memory, generation);

        statistics.add(snapshot);
        while(withinBudget && criterion.shouldContinue(snapshot)) {
            generation = generation + 1;

            log.info("Processing generation: {}", generation);

            swarm.move(generation);
            withinBudget = evaluateWithinBudget(swarm::evaluate);

            snapshot = toIteration(memory, generation);
            statistics.add(snapshot);
        }

        statistics.write();
    }

    /**
     * Creates the memory state of the swarm's current particles and records its metrics.
     */
    private Iteration toIteration(final SwarmMemory memory, final int generation) {
        final Particle[] particles = swarm.getParticles();
        final Iteration iteration = memory.toIteration(generation, particles);

        executionRecorder.recordMetrics(iteration);

        return iteration;
    }
}
