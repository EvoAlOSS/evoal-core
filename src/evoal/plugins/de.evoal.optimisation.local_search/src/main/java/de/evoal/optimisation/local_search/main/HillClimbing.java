package de.evoal.optimisation.local_search.main;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.api.statistics.SimpleCandidate;
import de.evoal.optimisation.api.statistics.SimpleIterationResult;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.languages.model.base.Instance;
import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Hill climbing
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.hill-climbing-algorithm")
public class HillClimbing implements OptimisationAlgorithm {
    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-iterations")
    private int maxIterations;

    @Inject @Named("optimisation-function")
    private OptimisationFunction fitness;

    @Inject @Named("comparator")
    private OptimisationValueComparator comparator;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.maximise")
    private boolean maximise;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;
    @Inject @Named("neighbour-strategy")
    private NeighbourChoosingStrategy strategy;

    @Inject @Component
    private StatisticsWriter statistics;

    @Override
    public OptimisationAlgorithm init(final Instance instance) {
        return this;
    }

    @Override
    public void run() {
        //1. create init new search space candidate
        Properties currentBestCandidate = provider.create().findFirst().get();
        double[] currentBestFitness = fitness.apply(currentBestCandidate);
        OptimisationValue currentBestValue = comparator.apply(currentBestFitness);

        //2. climbing till maxIteration or no new better neighbour
        int iterationNumber = 1;
        for(; iterationNumber <= maxIterations; iterationNumber++) {
            final Stream<Properties> neighbourStream = strategy.neighbours(currentBestCandidate);
            final OptimisationValue finalCurrentBestValue = currentBestValue;
            final Optional<Properties> nextBestCandidate = neighbourStream.filter(p -> {
                double[] candidateFitness = fitness.evaluate(p);
                OptimisationValue alternateBestValue = comparator.apply(candidateFitness);
                if(maximise) {
                    return alternateBestValue.compareTo(finalCurrentBestValue) > 0;
                } else {
                    return alternateBestValue.compareTo(finalCurrentBestValue) < 0;
                }
            }).findFirst();

            if(nextBestCandidate.isEmpty()) {
                addStatistics(new SimpleCandidate(currentBestCandidate, currentBestValue, 2), iterationNumber);
                log.info("No improvement in generation {}. Terminating optimisation.", iterationNumber);
                break;
            }

            currentBestCandidate = nextBestCandidate.get();
            double[] currentFitness = fitness.evaluate(currentBestCandidate);
            currentBestValue = comparator.apply(currentFitness);
            addStatistics(new SimpleCandidate(currentBestCandidate, currentBestValue, 1), iterationNumber);
        }

        log.info("Best candidate after {} iterations: {}", iterationNumber, currentBestCandidate);

        this.statistics.write();
    }

    private void addStatistics(SimpleCandidate candidate, int iterationNumber) {
        this.statistics.add(new SimpleIterationResult(iterationNumber, Collections.singleton(candidate), candidate));
    }
}
