package de.evoal.optimisation.sa.main;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.api.statistics.SimpleCandidate;
import de.evoal.optimisation.api.statistics.SimpleIterationResult;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.languages.model.base.Instance;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.hc.api.neighbour.NeighbourChoosingStrategy;
import de.evoal.optimisation.sa.api.cooling.CoolingStrategy;
import de.evoal.optimisation.sa.api.probability.AcceptanceProbabilityFunction;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Simulated Annealing algorithm starts with initial temperature T_0 and initial candidate s. New solutions
 * are sought from set of neighbours of S. Given a neighbour s', an acceptance probability P(f(s), f(s'), T) is
 * calculated and compared to random number r in [0, 1). If P(f(s), f(s'), T) >= r, neighbour solution is accepted
 * and temperature is decremented according to cooling schedule. The algorithm repeats for a given number of
 * iterations or until no neighbour is accepted.
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.sa.optimisation.simulated-annealing-algorithm")
public class SimulatedAnnealing implements OptimisationAlgorithm {
    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    @Inject @Named("comparator")
    private OptimisationValueComparator comparator;

    @Inject @Named("optimisation-function")
    private OptimisationFunction fitness;

    @Inject @Named("neighbour-strategy")
    private NeighbourChoosingStrategy strategy;

    @Inject @Component
    private StatisticsWriter statistics;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initial-temperature")
    private double initialTemperature;

    @Inject
    @Named("cooling-strategy")
    private CoolingStrategy coolingStrategy;

    @Inject
    @Named("acceptance-function")
    private AcceptanceProbabilityFunction probabilityFunction;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-iterations")
    private int maxIterations;

    private double temperature;

    private final Random random = new Random();

    @Override
    public OptimisationAlgorithm init(Instance instance) {
        return this;
    }

    @Override
    public void run() {
        //1. create init new search space candidate
        Properties currentBestCandidate = provider.create().findFirst().get();
        OptimisationValue currentBestValue = comparator.apply(fitness.evaluate(currentBestCandidate));
        temperature = initialTemperature;

        //2. searching till maxIteration or no new better neighbour
        int iterationNumber = 1;
        for(; iterationNumber <= maxIterations; iterationNumber++) {
            final Stream<Properties> neighbourStream = strategy.neighbours(currentBestCandidate);
            final Properties  finalCurrentBestCandidate = currentBestCandidate;
            final double finalTemperature = temperature;
            final Optional<Properties> nextBestCandidate = neighbourStream.filter(p -> {
                double acceptanceProb = probabilityFunction.apply(fitness.evaluate(finalCurrentBestCandidate), fitness.evaluate(p), finalTemperature);
                return acceptanceProb >= random.nextDouble();
            }).findFirst();

            if (nextBestCandidate.isEmpty()) {
                addStatistics(new  SimpleCandidate(currentBestCandidate, currentBestValue, 2), iterationNumber);
                log.info("No neighbour accepted in iteration {}. Terminating optimisation.", iterationNumber);
                break;
            }

            this.temperature = coolingStrategy.cool(this.temperature, iterationNumber);
            currentBestCandidate = nextBestCandidate.get();
            currentBestValue = comparator.apply(fitness.evaluate(currentBestCandidate));
            addStatistics(new SimpleCandidate(currentBestCandidate, currentBestValue, 1), iterationNumber);
        }

        log.info("Best candidate after {} iterations: {}", iterationNumber, currentBestCandidate);
        statistics.write();
    }

    private void addStatistics(SimpleCandidate candidate, int iterationNumber) {
        this.statistics.add(new SimpleIterationResult(iterationNumber, Collections.singleton(candidate), candidate));
    }
}
