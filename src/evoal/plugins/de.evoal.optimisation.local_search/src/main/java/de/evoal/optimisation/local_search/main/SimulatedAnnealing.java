package de.evoal.optimisation.local_search.main;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.api.model.impl.SimpleCandidate;
import de.evoal.optimisation.api.model.impl.SimpleIteration;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;
import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import de.evoal.optimisation.local_search.api.probability.AcceptanceProbabilityFunction;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
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
@Named("de.evoal.optimisation.local_search.optimisation.simulated-annealing-algorithm")
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
    @Named("decreasing-function")
    private DecreasingFunction coolingStrategy;

    @Inject
    @Named("acceptance-function")
    private AcceptanceProbabilityFunction probabilityFunction;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-iterations")
    private int maxIterations;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.maximise")
    private boolean maximise;

    private double temperature;

    private final Random random = new Random();

    @Override
    public OptimisationAlgorithm init(Instance instance) {
        return this;
    }

    @Override
    public void run() {
        //1. create init new search space candidate
        Properties currentCandidate = provider.create().findFirst().get();
        Properties bestCandidate = currentCandidate;
        OptimisationValue currentValue = comparator.apply(fitness.evaluate(currentCandidate));
        OptimisationValue bestValue = currentValue;
        temperature = initialTemperature;

        //2. searching till maxIteration or no new neighbour accepted
        int iterationNumber = 1;
        for(; iterationNumber <= maxIterations; iterationNumber++) {
            final Stream<Properties> neighbourStream = strategy.neighbours(currentCandidate);
            final Properties  finalCurrentCandidate = currentCandidate;
            final double finalTemperature = temperature;
            final Optional<Properties> nextCandidate = neighbourStream.filter(p -> {
                double acceptanceProb = probabilityFunction.apply(fitness.evaluate(finalCurrentCandidate), fitness.evaluate(p), finalTemperature);
                return acceptanceProb >= random.nextDouble();
            }).findFirst();

            if (nextCandidate.isEmpty()) {
                addStatistics(new SimpleCandidate(currentCandidate, currentValue, 2), iterationNumber);
                log.info("No neighbour accepted in iteration {}. Terminating optimisation.", iterationNumber);
                break;
            }

            this.temperature = coolingStrategy.decrease(this.temperature, this.initialTemperature, iterationNumber);
            currentCandidate = nextCandidate.get();
            currentValue = comparator.apply(fitness.evaluate(currentCandidate));
            if (currentValue.isBetter(bestValue, this.maximise)) {
                bestCandidate = currentCandidate;
                bestValue = currentValue;
            }
            addStatistics(new SimpleCandidate(currentCandidate, currentValue, 1), iterationNumber);
        }

        log.info("Best candidate after {} iterations: {}", iterationNumber, bestCandidate);
        statistics.write();
    }

    private void addStatistics(SimpleCandidate candidate, int iterationNumber) {
        this.statistics.add(new SimpleIteration(iterationNumber, Collections.singleton(candidate), candidate));
    }
}
