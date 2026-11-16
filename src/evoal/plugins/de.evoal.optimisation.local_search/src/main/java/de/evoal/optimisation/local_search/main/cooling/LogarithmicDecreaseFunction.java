package de.evoal.optimisation.local_search.main.cooling;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

/**
 * Logarithmic decrease strategy determines new temperature according to formula:
 * T(k) = T_0 / ln(k + e)
 * <p>
 * The shift by e makes T(0) = T_0 and the temperature falls from the first iteration on
 *   (the classic T_0 / ln(k + 1) starts at 1.44 * T_0 for k = 1).
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.logarithmic-decrease")
public class LogarithmicDecreaseFunction implements DecreasingFunction {

    @Override
    public double decrease(double currentTemp, double initialTemp, int iteration) {
        double newTemp = initialTemp / EvoalMath.log(iteration + Math.E);
        log.info("reducing to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public LogarithmicDecreaseFunction init(final EObject config) {
        return this;
    }
}