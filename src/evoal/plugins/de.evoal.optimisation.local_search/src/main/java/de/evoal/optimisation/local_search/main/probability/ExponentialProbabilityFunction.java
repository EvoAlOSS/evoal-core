package de.evoal.optimisation.local_search.main.probability;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.core.api.utils.Requirements;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.OptimisationValueWithDistance;
import de.evoal.optimisation.local_search.api.probability.AcceptanceProbabilityFunction;
import de.evoal.core.api.languages.AttributeEvaluator;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

/**
 * Exponential acceptance function determines acceptance probability according to formula:
 * <p>
 * P(f(s), f(s'), T) = 1 if s' is better than s<br>
 * P(f(s), f(s'), T) = exp(-|f(s') - f(s)| / T(k)) otherwise<br>
 * The probability decreases with the deterioration and with the temperature.
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.exponential-probability")
public class ExponentialProbabilityFunction implements AcceptanceProbabilityFunction {
    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    @Inject
    private AttributeEvaluator evaluator;

    @Override
    public double apply(final OptimisationValue currentFitness, final OptimisationValue neighbourFitness, double temperature) {
        log.info("current malus is {}, neighbour malus is {}", currentFitness, neighbourFitness);
        log.info("  temp passed to acceptance function is {}", temperature);

        if (neighbourFitness.isBetter(currentFitness)) {
            log.info("neighbour malus better than current malus. Taking neighbouring solution.");
            return 1.0;
        }

        if (temperature <= 0.0) {
            log.info("temperature is 0.0. No changes possible");
            return 0.0;
        }

        // the neighbour is not better, so the probability is exp(-delta / T) which is in (0, 1];
        //   delta is the (non-negative) distance of the fitness values
        final double delta = distanceBetween(neighbourFitness, currentFitness);
        final double probability = EvoalMath.exp(-delta / temperature);
        log.info("Acceptance probability is {}", probability);

        return probability;
    }

    /**
     * @return The distance between the two optimisation values.
     * @throws IllegalArgumentException if the comparator's values have no distance.
     */
    private static double distanceBetween(final OptimisationValue neighbourValue, final OptimisationValue currentValue) {
        if(!(neighbourValue instanceof OptimisationValueWithDistance withDistance)) {
            throw new IllegalArgumentException("The optimisation value " + neighbourValue + " has no distance.");
        }

        return withDistance.distanceFrom(currentValue);
    }

    @Override
    public ExponentialProbabilityFunction init(final EObject config) {
        Requirements.requireSize(optimisationSpace, 1);

        return this;
    }
}