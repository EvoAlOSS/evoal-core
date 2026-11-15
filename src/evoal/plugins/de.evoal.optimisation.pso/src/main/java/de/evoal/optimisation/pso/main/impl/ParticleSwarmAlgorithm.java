package de.evoal.optimisation.pso.main.impl;

import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
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

    private int maximumNumberOfGenerations;

    @Inject @Dependent @Component
    private OptimisationFunction optimisationFunction;

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
        maximumNumberOfGenerations = helper.lookup(configuration, "number-of-generations");

        return this;
    }

    @Override
    public void run() {
        int generation = 0;
        swarm.initialise();

        final SwarmMemory memory = new SwarmMemory(idGenerator);
        final Particle[] initialParticles = swarm.getParticles();
        Iteration snapshot = memory.toIteration(generation, initialParticles);

        statistics.add(snapshot);
        while(criterion.shouldContinue(snapshot)) {
            generation = generation + 1;

            log.info("Processing generation: {}", generation);

            swarm.move(generation, maximumNumberOfGenerations);
            swarm.evaluate();

            final Particle[] particles = swarm.getParticles();
            snapshot = memory.toIteration(generation, particles);
            statistics.add(snapshot);
        }

        statistics.write();
    }
}
