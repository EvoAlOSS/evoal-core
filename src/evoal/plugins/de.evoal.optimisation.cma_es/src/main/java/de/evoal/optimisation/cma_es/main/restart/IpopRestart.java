package de.evoal.optimisation.cma_es.main.restart;

import java.util.Optional;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Restarts with increasing population size, IPOP-CMA-ES (DL type {@code 'ipop-restart'};
 *   A. Auger, N. Hansen: A restart CMA evolution strategy with increasing population size.
 *   IEEE Congress on Evolutionary Computation 2005, pp. 1769-1776,
 *   doi 10.1109/CEC.2005.1554902): the population size of restart r is
 *   lambda_default * factor^r with the initial step size of the configuration. The schedule
 *   follows {@code cma.fmin} of pycma 4.6.0 ({@code incpopsize}, {@code restarts}).
 */
@Dependent
@Named("de.evoal.optimisation.cma_es.optimisation.ipop-restart")
public class IpopRestart implements RestartStrategy {
    /**
     * The factor of the population size per restart.
     */
    private double factor;

    @Inject
    private AttributeHelper helper;

    /**
     * The largest number of restarts, {@link Integer#MAX_VALUE} for no limit.
     */
    private int maximumRestarts;

    /**
     * Creates a strategy that is configured by {@link #init(EObject)}.
     */
    public IpopRestart() {
    }

    /**
     * Creates a configured strategy, e.g., for tests.
     */
    IpopRestart(final double factor, final int maximumRestarts) {
        this.factor = factor;
        this.maximumRestarts = maximumRestarts;
    }

    @Override
    public RestartStrategy init(final EObject configuration) throws InitializationException {
        factor = helper.<Double>lookup(configuration, "population-factor");
        final Integer maximum = helper.lookup(configuration, "maximum-restarts");
        maximumRestarts = maximum == null ? Integer.MAX_VALUE : maximum;

        return this;
    }

    @Override
    public boolean restarts() {
        return true;
    }

    @Override
    public RestartSchedule schedule(final int defaultPopulationSize) {
        return new RestartSchedule() {
            private int restarts;

            @Override
            public RunSetting first() {
                return new RunSetting(defaultPopulationSize, 1.0, Long.MAX_VALUE, "large");
            }

            @Override
            public Optional<RunSetting> next(final long evaluations, final RandomGenerator random) {
                if(restarts >= maximumRestarts) {
                    return Optional.empty();
                }

                ++restarts;
                final double multiplier = EvoalMath.pow(factor, restarts);
                final int populationSize = (int) (defaultPopulationSize * multiplier);

                return Optional.of(new RunSetting(populationSize, 1.0, Long.MAX_VALUE, "large"));
            }
        };
    }
}
