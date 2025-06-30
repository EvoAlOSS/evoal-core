package de.evoal.optimisation.local_search.main.probability;

import de.evoal.optimisation.local_search.api.probability.AcceptanceProbabilityFunction;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Exponential acceptance function determines acceptance probability according to formula:
 * P(f(s), f(s'), T) = exp(max( (f(s')-f(s)/T(k)), 0) for maximisation
 * P(f(s), f(s'), T) = exp(max( -(f(s')-f(s)/T(k)), 0) for minimisation
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.exponential-probability")
public class ExponentialProbabilityFunction implements AcceptanceProbabilityFunction {

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.maximise")
    private boolean maximise;

    @Override
    public double apply(double[] currentFitness, double[] neighbourFitness, double temperature) {
        log.info("current malus is {}, neighbour malus is {}", currentFitness, neighbourFitness);
        log.info("  temp passed to acceptance function is {}", temperature);
        if ((maximise && neighbourFitness[0] > currentFitness[0]) || (!maximise && neighbourFitness[0] < currentFitness[0])) {
            log.info("neighbour malus better than current malus. Taking neighbouring solution.");
            return 1.0;
        }
        if (temperature <= 0.0) {
            log.info("temperature is 0.0. No changes possible");
            return 0.0;
        }

        int sign = maximise ? 1 : -1;
        double probability = Math.exp(sign*(neighbourFitness[0] - currentFitness[0])/temperature);
        log.info("Acceptance probability is {}", probability);

        return probability;
    }

    @Override
    public ExponentialProbabilityFunction init(final Instance config) {
        return this;
    }
}