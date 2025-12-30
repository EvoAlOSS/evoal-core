package de.evoal.optimisation.local_search.main.accepting;

import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("de.evoal.optimisation.local_search.optimisation.threshold-accepting")
@Dependent
@Slf4j
public class ThresholdAcceptingStrategy implements AcceptingStrategy {

    @Inject
    @Named("optimisation-function")
    private OptimisationFunction fitness;

    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.accepting-strategy.initial-threshold")
    private double initialThreshold;

    private double threshold;

    @Inject
    @Named("decreasing-function")
    private DecreasingFunction decreasingFunction;

    @Override
    public AcceptingStrategy init(final Instance configuration) {
        threshold = initialThreshold;

        return this;
    }

    @Override
    public boolean acceptCandidate(final Properties candidate, final OptimisationValue bestFitnessValue) {
        double[] candidateFitness = fitness.evaluate(candidate);
        OptimisationValue alternateValue = comparator.apply(candidateFitness);

        if (alternateValue.isBetter(bestFitnessValue)) {
            log.debug("Neighbour malus better, accepting.");
            return true;
        }
        double dist = alternateValue.distanceFrom(bestFitnessValue);
        log.debug("distance: {} threshold: {}", dist, threshold);

        return (dist > 0 && dist < threshold);
    }

    @Override
    public void setIteration(final int iteration, final int maximum) {
        threshold = decreasingFunction.decrease(threshold, this.initialThreshold, iteration);
    }
}
