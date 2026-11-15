package de.evoal.optimisation.local_search.main.accepting;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.OptimisationValueWithDistance;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

@Named("de.evoal.optimisation.local_search.optimisation.threshold-accepting")
@Dependent
@Slf4j
public class ThresholdAcceptingStrategy implements AcceptingStrategy {

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.accepting-strategy.initial-threshold")
    private double initialThreshold;

    private double threshold;

    @Inject
    @Named("decreasing-function")
    private DecreasingFunction decreasingFunction;

    @Override
    public AcceptingStrategy init(final EObject configuration) {
        threshold = initialThreshold;

        return this;
    }

    @Override
    public boolean acceptCandidate(final OptimisationValue candidateValue, final OptimisationValue currentValue) {
        if (candidateValue.isBetter(currentValue)) {
            log.debug("Neighbour malus better, accepting.");
            return true;
        }

        if(!(candidateValue instanceof OptimisationValueWithDistance distAlt)) {
            log.warn("Neighbour malus is not a distance value.");
            return false;
        }

        double dist = distAlt.distanceFrom(currentValue);
        log.debug("distance: {} threshold: {}", dist, threshold);

        return (dist > 0 && dist < threshold);
    }

    @Override
    public void setIteration(final int iteration, final int maximum) {
        threshold = decreasingFunction.decrease(threshold, this.initialThreshold, iteration);
    }
}
