package de.evoal.optimisation.local_search.main.cooling;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.models.core.ecore.Space;
import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import de.evoal.core.api.languages.AttributeEvaluator;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

/**
 * Exponential cooling strategy determines new temperature according to formula:
 * T(k) = T_0 * exp(-k^(1/N))
 * where T_0 = initial temperature, k = iteration and N = dimension of search space
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.exponential-decrease")
public class ExponentialDecreaseFunction implements DecreasingFunction {

    @Inject
    private AttributeEvaluator evaluator;

    @Inject @Named("search-space")
    private Space searchSpaceSpecification;

    private int searchSpecSize;

    @Override
    public double decrease(double currentTemp, double initialTemp, int iteration) {
        double newTemp = initialTemp * EvoalMath.exp(-1 * (EvoalMath.pow(iteration, (1.0 / this.searchSpecSize))));
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public ExponentialDecreaseFunction init(final EObject config) {
        this.searchSpecSize = searchSpaceSpecification.size();
        return this;
    }
}