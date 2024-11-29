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
import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Threshold Accepting
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.threshold-accepting-algorithm")
public class ThresholdAccepting implements OptimisationAlgorithm {
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

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initial-threshold")
    private double initialThreshold;

    @Inject
    @Named("decreasing-function")
    private DecreasingFunction decreasingFunction;

    @Inject @Component
    private StatisticsWriter statistics;

    @Override
    public OptimisationAlgorithm init(final Instance instance) {
        return this;
    }

    @Override
    public void run() {
        //1. create init new search space candidate
        double threshold = this.initialThreshold;
        Properties currentCandidate = provider.create().findFirst().get();
        Properties bestCandidate = currentCandidate;
        double[] currentFitness = fitness.apply(currentCandidate);
        OptimisationValue currentValue = comparator.apply(currentFitness);
        OptimisationValue bestValue = currentValue;

        int iterationNumber = 1;
        for(; iterationNumber <= maxIterations; iterationNumber++) {
            final Stream<Properties> neighbourStream = strategy.neighbours(currentCandidate);
            final OptimisationValue finalCurrentValue = currentValue;
            final double finalThreshhold = threshold;
            final Optional<Properties> nextCandidate = neighbourStream.filter(p -> {
                double[] candidateFitness = fitness.evaluate(p);
                OptimisationValue alternateValue = comparator.apply(candidateFitness);
                if (alternateValue.isBetter(finalCurrentValue, this.maximise)) {
                    log.debug("Neighbour fitness better, accepting.");
                    return true;
                }
                double dist = alternateValue.distanceFrom(finalCurrentValue);
                log.debug("distance: {} threshold: {}", dist, finalThreshhold);
                return (dist > 0 && dist < finalThreshhold);
                //return dist > 0 && dist < finalThreshhold;
            }).findFirst();

            if(nextCandidate.isEmpty()) {
                addStatistics(new SimpleCandidate(currentCandidate, currentValue, 2), iterationNumber);
                log.info("No improvement in generation {}. Terminating optimisation.", iterationNumber);
                break;
            }
            threshold = decreasingFunction.decrease(threshold, this.initialThreshold, iterationNumber);
            currentCandidate = nextCandidate.get();
            log.info("current candidate is: {}", currentCandidate);
            currentFitness = fitness.evaluate(currentCandidate);
            currentValue = comparator.apply(currentFitness);
            if (currentValue.isBetter(bestValue, this.maximise)) {
                bestCandidate = currentCandidate;
                bestValue = currentValue;
            }
            addStatistics(new SimpleCandidate(currentCandidate, currentValue, 1), iterationNumber);
        }

        log.info("Best candidate after {} iterations: {}", iterationNumber, bestCandidate);

        this.statistics.write();
    }

    private void addStatistics(SimpleCandidate candidate, int iterationNumber) {
        this.statistics.add(new SimpleIterationResult(iterationNumber, Collections.singleton(candidate), candidate));
    }
}