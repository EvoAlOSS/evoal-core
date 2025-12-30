package de.evoal.optimisation.pso.main.impl;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.cdi.StoppingCriterionProducer;
import de.evoal.optimisation.api.model.*;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.pso.main.statistics.PSOIteration;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.particle-swarm-optimisation")
public class ParticleSwarmAlgorithm implements OptimisationAlgorithm {

    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    private StoppingCriterion criterion;

    @Inject
    private AttributeHelper helper;

    private int maximumNumberOfGenerations;

    @Inject @Dependent @Component
    private OptimisationFunction optimisationFunction;

    @Inject
    private StoppingCriterionProducer producer;

    @Inject @Component
    private StatisticsWriter statistics;

    /**
     * The used swarm implementation
     */
    private Swarm swarm;

    @Override
    public OptimisationAlgorithm init(final Instance configuration) {
        swarm = BeanFactory.createComponent(Swarm.class, helper.lookup(configuration, "swarm"));
        criterion = producer.create(configuration);
        maximumNumberOfGenerations = helper.lookup(configuration, "number-of-generations");

        return this;
    }

    @Override
    public void run() {
        int generation = 0;
        swarm.initialise();

        Iteration snapshot = new PSOIteration(generation, swarm);
        statistics.add(snapshot);
        while(criterion.shouldContinue(snapshot)) {
            generation = generation + 1;

            log.info("Processing generation: {}", generation);

            swarm.move(generation, maximumNumberOfGenerations);
            swarm.evaluate();

            snapshot = new PSOIteration(generation, swarm);
            statistics.add(snapshot);
        }

        statistics.write();
    }
}
