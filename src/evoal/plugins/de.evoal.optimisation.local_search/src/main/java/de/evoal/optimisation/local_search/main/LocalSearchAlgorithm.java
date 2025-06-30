package de.evoal.optimisation.local_search.main;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Optional;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import de.evoal.languages.model.base.expressions.Instance;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.AttributeHelper;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.cdi.StoppingCriterionProducer;
import de.evoal.optimisation.api.model.*;
import de.evoal.optimisation.api.model.impl.SimpleCandidate;
import de.evoal.optimisation.api.model.impl.SimpleIteration;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;

/**
 * A local search algorithm.
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.local-search")
public class LocalSearchAlgorithm implements OptimisationAlgorithm {
    private AcceptingStrategy acceptingStrategy;

    @Inject @Named("comparator")
    private OptimisationValueComparator comparator;

    /**
     * The stopping criterion to use.
     */
    private StoppingCriterion criterion;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-iterations")
    private int maxIterations;

    @Inject @Named("optimisation-function")
    private OptimisationFunction fitness;

    @Inject
    private AttributeHelper helper;

    @Inject
    private StoppingCriterionProducer producer;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    @Inject @Named("neighbour-strategy")
    private NeighbourChoosingStrategy strategy;

    @Inject @Component
    private StatisticsWriter statistics;

    @Override
    public OptimisationAlgorithm init(final Instance instance) {
        criterion = producer.create(instance);
        acceptingStrategy = BeanFactory.createComponent(AcceptingStrategy.class, helper.lookup(instance, "accepting-strategy"));

        return this;
    }

    @Override
    public void run() {
        //1. create init new search space candidate
        Properties candidate = provider.create().findFirst().get();
        OptimisationValue candidateFitness = comparator.apply(fitness.apply(candidate));

        // Log initial iteration
        Iteration state = toIteration(0, candidate, candidateFitness, 1);

        // 2. iterate  until stopping criteria is met or there is no new neighbour
        int iterationNumber = 1;
        while(!criterion.shouldTerminate(state)) {
            // 2.1 Just a final copy to satisfy Java
            final OptimisationValue finalCandidateFitess = candidateFitness;

            // 2.2 Search for acceptable candidate
            final Optional<Properties> acceptableCandidate =
                    strategy.neighbours(candidate)
                            .filter(c -> acceptingStrategy.acceptCandidate(c, finalCandidateFitess))
                            .findFirst();

            // 2.3 No candidate found
            if(acceptableCandidate.isEmpty()) {
                // add final entry to log
                toIteration(iterationNumber, candidate, candidateFitness, 2);
                log.info("No improvement in generation {}. Terminating optimisation.", iterationNumber);
                break;
            }

            // 2.4 update candidate information
            candidate = acceptableCandidate.get();
            candidateFitness = comparator.apply(fitness.evaluate(candidate));

            // 2.5 Update protocol
            state = toIteration(iterationNumber, candidate, candidateFitness, 1);

            // 2.6 Update iteration-specific data
            acceptingStrategy.setIteration(iterationNumber, maxIterations);
            iterationNumber += 1;
        }

        log.info("Best candidate after {} iterations: {}", iterationNumber - 1, candidate);

        this.statistics.write();
    }

    private Iteration toIteration(final int iteration, final Properties search, final OptimisationValue optimisation, final int age) {
        log.info("{}: {} -> {}.", 0, search, optimisation);

        final SimpleCandidate candidate = new SimpleCandidate(search, optimisation, age);
        final Iteration state = new SimpleIteration(iteration, Collections.singleton(candidate), candidate);

        statistics.add(state);

        return state;
    }
}
